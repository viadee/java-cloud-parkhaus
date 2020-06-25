package de.viadee.parkhaus.schranke.api;


import io.micronaut.http.annotation.Get;
import io.micronaut.http.client.annotation.Client;

@Client("parkhaus-manager")
public interface ParkhausManager {

   @Get("parkticket/{id}/isAllowedToExit")
   public boolean isAllowedToExit(String id);
}
