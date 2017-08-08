package com.aop;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by 高保红 on 2017/8/1.
 */
//@Aspect
public class TrackCounter {
    private Map<String, Integer> trackCounts = new HashMap<String, Integer>();

//    @Pointcut("execution(* com.test.auto.CompactDisc.playTrack(String))" + "&& args(trackNumber)")
//    public void trackPlayed(String trackNumber) {
//    }

//    @Before("trackPlayed(trackNumber)")
    public void countTrack(String trackNumber) {
        int currentCount = getPlayCount(trackNumber);
        trackCounts.put(trackNumber, currentCount + 1);
    }

    public int getPlayCount(String trackNumber) {
        return trackCounts.containsKey(trackNumber) ? trackCounts.get(trackNumber) : 0;
    }
}
