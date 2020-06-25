package de.viadee.parkhaus.schranke.service;

import de.viadee.parkhaus.schranke.api.ParkhausManager;
import org.eclipse.microprofile.rest.client.inject.RestClient;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

@ApplicationScoped
public class SchrankenService {

    @Inject
    @RestClient
    ParkhausManager parkhausManager;

    public boolean canExit(String id) {
        return this.parkhausManager.isAllowedToExit(id);
    }

}
