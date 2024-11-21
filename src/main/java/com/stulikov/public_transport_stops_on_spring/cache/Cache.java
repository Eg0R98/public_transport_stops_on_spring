package com.stulikov.public_transport_stops_on_spring.cache;

import com.stulikov.public_transport_stops_on_spring.forecast.Forecast;

import java.time.Instant;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Cache {
    private static long timeUpdate = 30;

    private static Map<Integer, CacheItem> cacheMap = new HashMap<>();

    public static void add(int stopNumber, List<Forecast> forecasts) {
        cacheMap.put(stopNumber, new CacheItem(forecasts));
    }

    public static List<Forecast> searchAndGet(int stopNumber) {
        if (cacheMap.containsKey(stopNumber)) {
            CacheItem cacheItem = cacheMap.get(stopNumber);
            if (Cache.updateOrNot(cacheItem)) return null;
            return cacheItem.getForecasts();
        }
        return null;
    }

    private static boolean updateOrNot(CacheItem cacheItem) {
        long timeDifference = Instant.now().getEpochSecond() - cacheItem.getInstantStart().getEpochSecond();
        return timeDifference > timeUpdate;
    }

}

