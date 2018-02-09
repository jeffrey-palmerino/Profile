package com.sparkSAM2018.model;

import com.sparkSAM2018.application.SAMCenter;
import spark.Request;

import javax.servlet.http.Part;

/**
 * Class that represents an author
 *
 */
public class Author {

    private String name;

    public Author(String name){
        this.name = name;
    }

    public String getAuthorUsername(){
        return name;
    }

    public boolean hasAuthor(String othername){
        return name.equals(othername);
    }

    public void submitPaper(SAMCenter samCenter, String author_name, String paper_title, int version, Part uploadedFile, Request request){
        samCenter.getSubmittedPapers().add(new Paper(new Author(author_name),paper_title,version,uploadedFile,request.cookie("usernameAuthor")));
    }
}
