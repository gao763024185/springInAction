package com.test.baseJava;


import java.util.List;

/**
 * Created by 高保红 on 2017/7/6.
 */
public class BlankDisc implements CompactDisc {

    private String title ;
    private String artist ;
    private List<String> tracks;


    public BlankDisc(String title, String artist, List<String> tracks) {
        this.title = title;
        this.artist = artist;
        this.tracks = tracks;
    }

    public BlankDisc() {
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public List<String> getTracks() {
        return tracks;
    }

    public void setTracks(List<String> tracks) {
        this.tracks = tracks;
    }

    public void play(){

        System.out.println("Playing "+title+" by "+artist);
        for (String track : tracks) {
            playTrack(track);
        }
    }

    public void playTrack(String track){
        System.out.println("-Track: "+track);
    }
}
