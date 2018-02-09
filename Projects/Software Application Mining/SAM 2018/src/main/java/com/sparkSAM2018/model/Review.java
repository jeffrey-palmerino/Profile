package com.sparkSAM2018.model;

public class Review {

    private int rating;
    private String comments;
    private String paper_title;
    private String pcm;

    public Review(int rating, String comments, String paperTitle, String pcm) {
        this.rating = rating;
        this.comments = comments;
        this.paper_title = paperTitle;
        this.pcm = pcm;
    }

    public int getRating(){
        return rating;
    }

    public String getComments(){
        return comments;
    }

    public String getPaperTitle(){
        return paper_title;
    }

    public String getPcm(){
        return pcm;
    }
}
