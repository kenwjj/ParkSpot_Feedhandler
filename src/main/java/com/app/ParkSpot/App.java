package com.app.ParkSpot;

import com.app.controller.CarparkController;

public class App
{
    public static void main( String[] args )
    {

        CarparkController cpc = new CarparkController();
        cpc.publish();

    }

}