package de.viadee.parkhaus.manager.service;

import de.viadee.parkhaus.manager.config.ParkhausConfig;
import de.viadee.parkhaus.manager.entity.Parkticket;
import de.viadee.parkhaus.manager.repository.ParkticketRepository;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.ws.rs.BadRequestException;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.NoSuchElementException;

@ApplicationScoped
public class ParkticketService {

    final ParkticketRepository parkticketRepository;

    final ParkhausConfig parkhausConfig;

    @Inject
    public ParkticketService(ParkticketRepository parkticketRepository, ParkhausConfig parkhausConfig) {
        this.parkticketRepository = parkticketRepository;
        this.parkhausConfig = parkhausConfig;
    }

    public String create(LocalDateTime entered) {
        if (entered == null) {
            throw new BadRequestException("entered must be specified");
        }
        
        Parkticket parkticket = new Parkticket(entered);

        parkticketRepository.persist(parkticket);

        return parkticket.getId();
    }

    public Parkticket get(String id) {
        return parkticketRepository.findById(id);
    }


    public Double getPaymentAmount(String id) {
        Parkticket parkticket = parkticketRepository.findById(id);
        if (parkticket == null) {
            throw new NoSuchElementException();
        }
        return getPaymentAmount(parkticket);
    }

    public Double getPaymentAmount(Parkticket parkticket) {
        LocalDateTime to = LocalDateTime.now();

        LocalDateTime from = parkticket.getEntered();

        long parkingTime = ChronoUnit.HOURS.between(from, to);

        return parkhausConfig.getGebuehr() * parkingTime;
    }


    public boolean makePayment(String id, Double payment) {
        Parkticket parkticket = parkticketRepository.findById(id);

        if (parkticket == null) {
            throw new NoSuchElementException();
        }

        if (parkticket != null && getPaymentAmount(parkticket).equals(payment)) {
            parkticket.setPayment(LocalDateTime.now());
            parkticketRepository.persist(parkticket);
            return true;
        } else {
            return false;
        }

    }

    public List<Parkticket> getAll() {
        return parkticketRepository.findAll();
    }


    public boolean isAllowedToExit(String id) {
        Parkticket parkticket = this.parkticketRepository.findById(id);

        if (parkticket == null) {
            throw new NoSuchElementException();
        }

        LocalDateTime now = LocalDateTime.now();
        return parkticket.getEntered().isBefore(now)
                && parkticket.getPayment() != null
                && now.minusMinutes(parkhausConfig.getToleranceBtwPaymentAndExit()).isBefore(parkticket.getPayment());
    }
}
