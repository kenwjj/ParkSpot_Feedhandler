package com.app.controller;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.app.helper.RESTHelper;
import com.app.model.Carpark;
import org.json.JSONArray;

import java.io.IOException;
import java.sql.Timestamp;
import java.util.Date;

/**
 * Created by Kenwjj on 23/2/2017.
 */
public class CarparkController {

    public CarparkController() {
    }

    public void publish(){
        Carpark[] carparks = getCarparks();
        Timestamp now = new Timestamp(new Date().getTime());
        for (Carpark c:carparks){
            c.setLastUpdated(now);
        }
        // TODO Publish to database

    }

    public Carpark[] getCarparks(){
        JSONArray jsonList = RESTHelper.retrieveFromCarparksAPI();
        ObjectMapper mapper = new ObjectMapper();
        mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        Carpark[] carparks = null;
        try {
            carparks = mapper.readValue(jsonList.toString(), Carpark[].class);
        } catch (IOException e) {
            return null;
        }
        return carparks;
    }


}
