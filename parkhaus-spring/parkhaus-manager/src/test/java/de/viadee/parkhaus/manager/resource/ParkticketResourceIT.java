package de.viadee.parkhaus.manager.resource;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class ParkticketResourceIT {

    @Autowired
    MockMvc mvc;

    @Test
    public void createIT() throws Exception {
        mvc.perform(post("/parkticket?entered=2020-01-31T18:00"))
                .andExpect(status().isOk());

    }

}