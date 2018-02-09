package com.sparkSAM2018.model;

import javax.servlet.http.Part;

/**
 * Class that represents a paper that is submitted to the conference
 *
 */
public class Paper {

    private Author author;
    private String title;
    private int version;
    private Part paper;
    private String username;

    public Paper(Author author, String title, int version, Part paper, String username){
        this.author = author;
        this.title = title;
        this.version = version;
        this.paper = paper;
        this.username = username;
    }

    public String getAuthor(){
        return author.getAuthorUsername();
    }

    public String getTitle(){
        return title;
    }

    public int getVersion(){
        return version;
    }

    public Part getPaper(){
        return paper;
    }

    public String getUsername(){
        return username;
    }
}
