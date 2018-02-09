package com.sparkSAM2018.model;

/**
 * Class that represents the Program Committee Chair (PCC) for the conference
 *
 */
public class PCC {

    private String username = "pcc";
    private String empty;

    public PCC(String username){
        this.empty = username;
    }

    public String getPCCName(){
        return username;
    }

    public boolean hasPCC(String name){
        return username.equals(name);
    }
}
