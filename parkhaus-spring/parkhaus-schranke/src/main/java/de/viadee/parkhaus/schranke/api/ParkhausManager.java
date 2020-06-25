package de.viadee.parkhaus.schranke.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class ParkhausManager {

    private RestTemplate restTemplate;

    @Value("${manager-url}")
    private String url;

    @Autowired
    public ParkhausManager(RestTemplateBuilder builder) {
        this.restTemplate = builder.build();
    }

     public boolean isAllowedToExit(String id){
       return restTemplate.getForEntity(url + "/parkticket/"+ id+ "/isAllowedToExit", Boolean.class).getBody();
    }

}

