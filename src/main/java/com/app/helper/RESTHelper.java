package com.app.helper;

import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import org.json.JSONArray;
import org.json.JSONObject;

/**
 * Created by Kenwjj on 23/2/2017.
 */
public class RESTHelper {
    // Endpoint for API
    private static final String URL = "http://datamall2.mytransport.sg/ltaodataservice/CarParkAvailability";
    // API Key
    private static final String API_KEY = "5Ln62kPRQq2M4wdMfJ3zUw==";

    // Retrieve JSON Results from API
    public static JSONArray retrieveFromCarparksAPI(){
        HttpResponse<JsonNode> request  = null;
        try {
            request  = Unirest.get(URL)
                    .header("accept", "application/json")
                    .header("AccountKey",API_KEY)
                    .asJson();
            JSONObject obj = request.getBody().getObject();

            JSONArray value = (JSONArray) obj.get("value");
            return value;
        } catch (UnirestException e) {
            e.printStackTrace();
        }
        return null;

    }
}
