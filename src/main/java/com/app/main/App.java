package com.app.main;

import com.app.controller.CarparkController;

public class App
{
    public static void main( String[] args )
    {
        // Initialize Carpark Controller
        CarparkController cpc = new CarparkController();
        // Start Publishing
        cpc.publish();

    }

}
