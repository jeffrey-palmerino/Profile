package com.sparkSAM2018.model;

import com.sparkSAM2018.application.SAMCenter;
import com.sparkSAM2018.ui.PostPaperRoute;

import javax.servlet.http.Part;
import java.util.ArrayList;
import java.util.List;

/**
 * Class that represents a notification that can be sent to different users
 *
 */
public class Notification {

    private String message;

    private String submissionNote = "A paper has been submitted";
    private String reviewNote = "A PCM has reviewed a paper";
    private String assignedNote = "You have been assigned a paper for review";
    private String interestsNote = "A PCM has submitted their interests";

    public Notification(String message){
        this.message = message;
    }

    public String getMessage(){
        return message;
    }

    public void sendPaperSubmissionNotification(SAMCenter samCenter){
        samCenter.getpccNotifications().add(new Notification(this.submissionNote));
    }

    public void sendAssignedPaperNotification(SAMCenter samCenter){
        samCenter.getpcmNotifications().add(new Notification(this.assignedNote));
    }

    public void sendPCMInterestsNotification(SAMCenter samCenter){
        samCenter.getpccNotifications().add(new Notification(this.interestsNote));
    }

    public void sendReviewNotification(SAMCenter samCenter){
        samCenter.getpccNotifications().add(new Notification(this.reviewNote));
    }

    public void sendFinalReportNotification(SAMCenter samCenter){
        String username = "";
        List<String> note = new ArrayList<>();

        for(int x = 0; x < samCenter.getFinalReviews().size(); x++){
            for(int y = 0; y < samCenter.getSubmittedPapers().size(); y++){
                Part file = samCenter.getSubmittedPapers().get(y).getPaper();
                String fileName = PostPaperRoute.getSubmittedFileName(file);
                if(samCenter.getFinalReviews().get(x).getPaperTitle().equals(fileName)) {
                    samCenter.getAuthorMap().put(samCenter.getSubmittedPapers().get(y).getUsername(),samCenter.getFinalReviews().get(x));
                    username = samCenter.getSubmittedPapers().get(y).getUsername();
                    note.add("A submission has been reviewed");
                }
            }
        }
        samCenter.getauthorNotifications().put(username, note);
    }

    public void setSubmissionNote(String message){
        this.submissionNote = message;
    }

    public void setReviewNote(String message){
        this.reviewNote = message;
    }
    public void setInterestsNote(String message){
        this.interestsNote = message;
    }
    public void setAssignedNote(String message){
        this.assignedNote = message;
    }

    public String getSubmissionNote(){
        return submissionNote;
    }
    public String getReviewNote(){
        return reviewNote;
    }
    public String getInterestsNote(){
        return interestsNote;
    }
    public String getAssignedNote(){
        return assignedNote;
    }

}

