package com.sparkSAM2018.ui;

import com.sparkSAM2018.application.SAMCenter;
import com.sparkSAM2018.model.Review;
import spark.ModelAndView;
import spark.Request;
import spark.Response;
import spark.TemplateViewRoute;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * The {@code GET /author} route handler.
 *
 * Displays home page for author
 */
public class GetAuthorRoute implements TemplateViewRoute {

    private final SAMCenter samCenter;

    public GetAuthorRoute(SAMCenter samCenter){
        this.samCenter = samCenter;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public ModelAndView handle(Request request, Response response) {
        Map<String, Object> vm = new HashMap<>();
        vm.put("title", GetHomeRoute.TITLE);

        List<String> valueNotifications;
        if(request.queryParams("notification") != null){
            String notie = request.queryParams("notification");
            for(String username: samCenter.getauthorNotifications().keySet()){
                valueNotifications = samCenter.getauthorNotifications().get(username);
                for(int x = 0; x < valueNotifications.size(); x++){
                    if(valueNotifications.get(x).equals(notie)){
                        samCenter.getauthorNotifications().put(username, new ArrayList<>());
                    }
                }
            }
        }

        List<String> value = new ArrayList<>();
        for(String username: samCenter.getauthorNotifications().keySet()){
            if(username.equals(request.cookie("usernameAuthor"))){
                value = samCenter.getauthorNotifications().get(username);
            }
        }

        vm.put("notification",value);
        return new ModelAndView(vm, "author.ftl");
    }
}
