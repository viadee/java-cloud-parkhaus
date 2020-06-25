package de.viadee.parkhaus.schranke.service;

import de.viadee.parkhaus.schranke.api.ParkhausManager;

import javax.inject.Singleton;

@Singleton
public class SchrankenService {

    ParkhausManager parkhausManager;

    public SchrankenService(ParkhausManager parkhausManager) {
        this.parkhausManager = parkhausManager;
    }

    public boolean canExit(String id) {
        return this.parkhausManager.isAllowedToExit(id);
    }

}
