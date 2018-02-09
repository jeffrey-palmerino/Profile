package com.sparkSAM2018.ui;

import com.sparkSAM2018.application.SAMCenter;
import spark.ModelAndView;
import spark.Request;
import spark.Response;
import spark.TemplateViewRoute;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * The {@code GET /pcm} route handler.
 *
 * Displays home page for a PCM
 */
public class GetPCMRoute implements TemplateViewRoute{

    private final SAMCenter samCenter;

    public GetPCMRoute(SAMCenter samCenter){
        this.samCenter = samCenter;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public ModelAndView handle(Request request, Response response) {
        Map<String, Object> vm = new HashMap<>();
        vm.put("title", GetHomeRoute.TITLE);

        if(request.queryParams("notification") != null){
            String notie = request.queryParams("notification");
            for(int x = 0; x < samCenter.getpcmNotifications().size(); x++){
                if(samCenter.getpcmNotifications().get(x).getMessage().equals(notie)){
                    samCenter.getpcmNotifications().remove(samCenter.getpcmNotifications().get(x));
                }
            }
        }

        ArrayList value;
        List<String> noties = new ArrayList<>();
        for(String name: samCenter.getAssignmentMap().keySet()){
            value = samCenter.getAssignmentMap().get(name);
            if(value.contains(request.cookie("usernamePCM"))){
                for(int x = 0; x < samCenter.getpcmNotifications().size(); x++){
                    noties.add(samCenter.getpcmNotifications().get(x).getMessage());
                }
            }
        }

        vm.put("notification",noties);
        return new ModelAndView(vm, "pcm.ftl");
    }
}
