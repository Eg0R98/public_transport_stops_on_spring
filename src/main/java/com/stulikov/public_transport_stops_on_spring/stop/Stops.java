package com.stulikov.public_transport_stops_on_spring.stop;


import java.util.ArrayList;
import java.util.List;

public class Stops {
    private static List<Stop> listStops = new ArrayList<>();

    public static List<Stop> getMatches(String title) {
        String titleIgnoreCase = title.toLowerCase();
        List<Stop> list = new ArrayList<>();
        for (Stop s : listStops) {
            if (s.isThereACompleteLackOfPublicTransport()) {
                continue;
            }
            if (s.getTitle().toLowerCase().contains(titleIgnoreCase)) {
                list.add(s);
            }
        }
        return list;
    }

    public static Integer getStopID(Stop stop) {
        return stop.getStopID();
    }

    public static void setListStops(List<Stop> listStops) {
        Stops.listStops = listStops;
    }
}
