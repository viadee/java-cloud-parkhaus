package de.viadee.parkhaus.schranke.rest;

import de.viadee.parkhaus.schranke.service.SchrankeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("schranke")
public class SchrankenResource {

    SchrankeService schrankenService;

    @Autowired
    public SchrankenResource(SchrankeService schrankenService) {
        this.schrankenService = schrankenService;
    }

    @GetMapping(path = "{id}", produces = MediaType.TEXT_PLAIN_VALUE)
    public String get(@PathVariable("id") String id) {
        return this.schrankenService.canExit(id) ? "GREEN" : "RED";
    }
}

