package com.sparkSAM2018.ui;

import com.sparkSAM2018.application.SAMCenter;

import com.sparkSAM2018.model.Administrator;
import com.sparkSAM2018.model.Author;
import com.sparkSAM2018.model.Notification;
import com.sparkSAM2018.model.PCC;
import spark.ModelAndView;
import spark.Request;
import spark.Response;
import spark.TemplateViewRoute;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static spark.Spark.halt;

/**
 * The {@code POST /name} route handler.
 *
 * Verifies a users login
 */
public class PostNameRoute implements TemplateViewRoute {

    private final SAMCenter samCenter;
    private final Notification note;
    Administrator admin;
    PCC pcc = new PCC(null);

    public PostNameRoute(SAMCenter samCenter, Notification note){
        this.samCenter = samCenter;
        this.note = note;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public ModelAndView handle(Request request, Response response) {
        Map<String, Object> vm = new HashMap<>();
        vm.put("title", GetHomeRoute.TITLE);
         admin = new Administrator(note);

        String radioValue = request.queryParams("memberType");
        String username = request.queryParams("username");

        if(radioValue == null){
            return invalidUsernameError(vm);
        }
        else{
            return validateSignin(vm, username, radioValue, response);
        }
    }

    private ModelAndView validateSignin(Map<String, Object> vm, String username, String radioValue, Response response){
        switch(radioValue){
            case "author":
                if(samCenter.getUsernameAvailability(username,"author")){
                    response.cookie("usernameAuthor",username);
                    response.redirect("/author");
                    halt();
                    return null;
                }
                else{
                    return invalidUsernameError(vm);
                }
            case "pcm":
                if(samCenter.getUsernameAvailability(username,"pcm")){
                    response.cookie("usernamePCM",username);
                    response.redirect(String.format("/pcm"));
                    return null;
                }
                else{
                    return invalidUsernameError(vm);
                }
            case "pcc":
                String pccName = pcc.getPCCName();
                if(pccName.equals(username)){
                    response.cookie("usernamePCC",username);
                    response.redirect("/pcc");
                    halt();
                    return null;
                }
                else{
                    return invalidUsernameError(vm);
                }
            case "administrator":
                String adminName = admin.getUsername();
                if(adminName.equals(username)){
                    response.redirect("/admin");
                    halt();
                    return null;
                }
            default:
                return invalidUsernameError(vm);
        }
    }

    private ModelAndView invalidUsernameError(Map<String, Object> vm){
        vm.put("usernameError", "Invalid username, please make sure your username is right and/or you have selected a member type button.");
        return new ModelAndView(vm, "signin.ftl");
    }
}