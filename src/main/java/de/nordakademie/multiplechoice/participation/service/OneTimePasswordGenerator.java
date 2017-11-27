package de.nordakademie.multiplechoice.participation.service;

import java.util.UUID;
/**
 * Created by Daniel Fiolka on 23.11.17.
 */
public class OneTimePasswordGenerator {

    public OneTimePasswordGenerator(){
    }

    /** Generiert einen langen random String
     * @return String
     */
    public String generatePassword(){
        String uuid = UUID.randomUUID().toString();
        return uuid;
    }

}
