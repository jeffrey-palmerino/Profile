package com.sparkSAM2018.model;

import com.sparkSAM2018.application.SAMCenter;

/**
 * Class that represents the Administrator for the conference
 *
 */
public class Administrator {

    private String username = "Administrator";
    Notification note;

    public Administrator(Notification note){
        this.note = note;
    }

    public String getUsername(){
        return username;
    }

    public void deleteUsername(SAMCenter samCenter, String username){
        for(int x = 0; x < samCenter.getAuthorUsernameList().size(); x++){
            if(username.equals(samCenter.getAuthorUsernameList().get(x).getAuthorUsername())){
                samCenter.getAuthorUsernameList().remove(samCenter.getAuthorUsernameList().get(x));
            }
        }
        for(int x = 0; x < samCenter.getPCMUsernameList().size(); x++){
            if(username.equals(samCenter.getPCMUsernameList().get(x).getPCMName())){
                samCenter.getPCMUsernameList().remove(samCenter.getPCMUsernameList().get(x));
            }
        }
        for(int x = 0; x < samCenter.getPCCUsernameList().size(); x++){
            if(username.equals(samCenter.getPCCUsernameList().get(x).getPCCName())){
                samCenter.getPCCUsernameList().remove(samCenter.getPCCUsernameList().get(x));
            }
        }
    }

    public void addUsername(SAMCenter samCenter, String memberType, String username){
        switch(memberType){
            case "Author":
                samCenter.getAuthorUsernameList().add(new Author(username));
                break;
            case "PCM":
                samCenter.getPCMUsernameList().add(new PCM(username));
                break;
            default:
                System.out.println("Didn't add username.");
        }
    }

    public void modifyNotifications(String sub, String interests, String rev, String ass){
        if(!sub.equals("")){
            note.setSubmissionNote(sub);
        }
        if(!interests.equals("")){
            note.setInterestsNote(interests);
        }
        if(!rev.equals("")){
            note.setReviewNote(rev);
        }
        if(!ass.equals("")){
            note.setAssignedNote(ass);
        }
    }

}
