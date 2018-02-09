package com.sparkSAM2018.ui;

import com.sparkSAM2018.application.SAMCenter;
import com.sparkSAM2018.model.Author;
import com.sparkSAM2018.model.PCC;
import com.sparkSAM2018.model.PCM;

import spark.ModelAndView;
import spark.Request;
import spark.Response;
import spark.TemplateViewRoute;

import java.util.HashMap;
import java.util.Map;

/**
 * The {@code POST /registrationPost} route handler.
 *
 * Verifies a users request to register a username
 */
public class PostRegistrationRoute implements TemplateViewRoute {

    static final String SIGNIN_FTL = "signin.ftl";

    private final SAMCenter samCenter;

    public PostRegistrationRoute(SAMCenter samCenter){
        this.samCenter = samCenter;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public ModelAndView handle(Request request, Response response) {
        Map<String, Object> vm = new HashMap<>();
        vm.put("title", GetHomeRoute.TITLE);

        final String radioValue = request.queryParams("memberType");
        final String username = request.queryParams("username");

        if(radioValue == null){
            vm.put("usernameError","Please select your member type in order to proceed.");
            return new ModelAndView(vm,"registration.ftl");
        }
        else{
            if(isNameAvailable(username, radioValue, response)){
                return new ModelAndView(vm, SIGNIN_FTL);
            }
            else{
                vm.put("usernameError","Invalid username, please try again.");
                return new ModelAndView(vm,"registration.ftl");
            }
        }
    }


    private boolean isNameAvailable(String username, String radioValue, Response response){
        switch(radioValue){
            case "author":
                if(samCenter.getUsernameAvailability(username,"author")){
                    return false;
                }
                else{
                    samCenter.getAuthorUsernameList().add(new Author(username));
                    return true;
                }
            case "pcm":
                if(samCenter.getUsernameAvailability(username,"pcm")){
                    return false;
                }
                else{
                    samCenter.getPCMUsernameList().add(new PCM(username));
                    return true;
                }
            default:
                return false;
        }
    }
}

