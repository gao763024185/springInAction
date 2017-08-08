package com.aop;//package com.aop;
//
//import com.test.baseJava.BlankDisc;
//import com.test.baseJava.CompactDisc;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.context.annotation.EnableAspectJAutoProxy;
//
//import java.util.ArrayList;
//import java.util.List;
//
///**
// * Created by 高保红 on 2017/8/1.
// */
//
//@Configuration
//@EnableAspectJAutoProxy
//public class TrackCounterConfig {
//    @Bean
//    public CompactDisc cd(){
//        BlankDisc cd = new BlankDisc();
//        cd.setTitle("Sgt.Pepper's Lonely Hearts Club Band");
//        cd.setArtist("The Beatles");
//        List<String> tracks = new ArrayList<String>();
//        tracks.add("Sgt.Pepper's Lonely Hearts Club Band");
//        tracks.add("With a Little Help from My Friends");
//        tracks.add("Getting Better");
//        tracks.add("Fixing a Hole");
//        cd.setTracks(tracks);
//        return cd;
//    }
//
//    @Bean
//    public TrackCounter trackCounter(){
//        return new TrackCounter();
//    }
//}
