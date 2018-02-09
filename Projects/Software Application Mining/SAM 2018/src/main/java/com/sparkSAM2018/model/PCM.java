package com.sparkSAM2018.model;

/**
 * Class that represents a Program Committee Member (PCM) for the conference
 *
 */
public class PCM {

    private String username;

    public PCM(String username){
        this.username = username;
    }

    public String getPCMName(){
        return username;
    }

    public boolean hasPCM(String name){
        return username.equals(name);
    }
}
