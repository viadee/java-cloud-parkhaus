package de.viadee.parkhaus.manager.service;

import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;

import javax.inject.Inject;
import javax.ws.rs.BadRequestException;
import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

@QuarkusTest
public class ParkticketServiceTest {

  @Inject
  private ParkticketService parkticketService;

  @Test
  public void create() {

    LocalDateTime entered = LocalDateTime.now().plusDays(1);
    assertNotNull(parkticketService.create(entered));

    assertThrows(BadRequestException.class, () -> parkticketService.create(null));
  }
}
