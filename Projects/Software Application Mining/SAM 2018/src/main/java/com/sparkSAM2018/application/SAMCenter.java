package com.sparkSAM2018.application;

import com.sparkSAM2018.model.*;
import spark.Request;
import spark.Session;

import javax.servlet.http.Part;
import java.util.*;

/**
 *
 * The object to coordinate the state of the application.
 *
 */
public class SAMCenter {

    //
    // attributes
    //

    private List<Author> authorUsernames = new ArrayList<>();
    private List<PCM> pcmUsernames = new ArrayList<>();
    private List<PCC> pccUsernames = new ArrayList<>();

    private List<Paper> submittedPapers = new ArrayList<>();
    private List<String> papersSubmitted = new ArrayList<>();
    private List<Part> interests = new ArrayList<>();

    private HashMap<String, List<String>> formattedInterests = new HashMap<>();
    private HashMap<String, ArrayList> assignmentMap = new HashMap<>();
    private HashMap<String, Review> authorMap = new HashMap<>();

    private List<Notification> pccNotifications = new ArrayList<>();
    private List<Notification> pcmNotifications = new ArrayList<>();
    private HashMap<String, List<String>> authorNotifications = new HashMap<>();

    private List<Review> reviews = new ArrayList<>();
    private List<Review> finalReviews = new ArrayList<>();

    private Date submissionDeadline;
    private Date reviewDeadline;

    //
    // constructor
    //

    public SAMCenter() {

    }

    public HashMap<String, Review> getAuthorMap(){
        return authorMap;
    }

    public HashMap<String, List<String>> getauthorNotifications(){
        return authorNotifications;
    }

    public List<Review> getFinalReviews(){
        return finalReviews;
    }

    public List<Review> getReviews(){
        return reviews;
    }

    public HashMap<String, ArrayList> getAssignmentMap(){
        return assignmentMap;
    }

    public void setSubmissionDeadline(Date date){
        this.submissionDeadline = date;
    }

    public Date getSubmissionDeadline(){
        return submissionDeadline;
    }

    public void setReviewDeadline(Date date){
        this.reviewDeadline = date;
    }

    public Date getReviewDeadline(){
        return reviewDeadline;
    }

    public List<Author> getAuthorUsernameList() {
        return authorUsernames;
    }

    public List<PCM> getPCMUsernameList() {
        return pcmUsernames;
    }

    public List<PCC> getPCCUsernameList() {
        return pccUsernames;
    }

    public List<Paper> getSubmittedPapers(){
        return submittedPapers;
    }

    public List<String> getPapersSubmitted(){
        return papersSubmitted;
    }

    public List<Part> getInterests(){
        return interests;
    }

    public List<Notification> getpccNotifications(){
        return pccNotifications;
    }

    public List<Notification> getpcmNotifications(){
        return pcmNotifications;
    }

    public Map<String, List<String>> getformattedInterests(){
        return formattedInterests;
    }

    public boolean getUsernameAvailability(String name, String type){
        switch(type){
            case "author":
                for (Author author: authorUsernames) {
                    if(author.hasAuthor(name)){
                        return true;
                    }
                }
                break;
            case "pcm":
                for (PCM pcm: pcmUsernames) {
                    if(pcm.hasPCM(name)){
                        return true;
                    }
                }
                break;
            case "pcc":
                for (PCC pcc: pccUsernames) {
                    if(pcc.hasPCC(name)){
                        return true;
                    }
                }
                break;
        }
        return false;
    }
}

