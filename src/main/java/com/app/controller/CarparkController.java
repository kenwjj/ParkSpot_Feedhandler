package com.app.controller;


import com.app.dao.CarparkDAO;
import com.app.helper.RESTHelper;
import com.app.model.Carpark;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.json.JSONArray;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.sql.Connection;
import java.sql.Timestamp;
import java.util.Date;

/**
 * Created by Kenwjj on 23/2/2017.
 */
public class CarparkController {
    private Connection conn;
    Logger LOGGER = LoggerFactory.getLogger(CarparkController.class);
    public CarparkController() {
    }

    // Start publishing Carpark Availability Info
    public void publish(){
        Carpark[] carparks = getCarparks();
        Timestamp now = new Timestamp(new Date().getTime());
        CarparkDAO cpDAO = new CarparkDAO();

        for (Carpark c:carparks){
            c.setLastUpdated(now);
            LOGGER.info("Publishing {} - {}",c.getClass().toString(),c);
            cpDAO.insertCarpark(c);
        }
        cpDAO.closeDB();
    }

    // Retrieve Carpark Availability Info from API
    public Carpark[] getCarparks(){
        JSONArray jsonList = RESTHelper.retrieveFromCarparksAPI();
        ObjectMapper mapper = new ObjectMapper();
        mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        Carpark[] carparks = null;
        LOGGER.info("JSON String: {}",jsonList.toString());
        try {
            carparks = mapper.readValue(jsonList.toString(), Carpark[].class);
        } catch (IOException e) {
            return null;
        }
        return carparks;
    }

}
