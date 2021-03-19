package de.viadee.parkhaus.manager.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
public class ParkticketServiceTest {

    @Autowired
    ParkticketService parkticketService;

    @Test
    public void createTest() {
        assertNotNull(parkticketService.create(LocalDateTime.now()));
    }

}