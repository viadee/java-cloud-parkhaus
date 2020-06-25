package de.viadee.parkhaus.schranke.service;

import de.viadee.parkhaus.schranke.api.ParkhausManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class SchrankeService {

    ParkhausManager parkhausManager;

    @Autowired
    public SchrankeService(ParkhausManager parkhausManager) {
        this.parkhausManager = parkhausManager;
    }

    public boolean canExit(String parkhausId) {
        return this.parkhausManager.isAllowedToExit(parkhausId);
    }
}
