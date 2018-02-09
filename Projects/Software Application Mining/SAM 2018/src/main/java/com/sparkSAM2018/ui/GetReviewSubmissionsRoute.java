package com.sparkSAM2018.ui;

import com.sparkSAM2018.application.SAMCenter;

import spark.ModelAndView;
import spark.Request;
import spark.Response;
import spark.TemplateViewRoute;

import java.util.*;

/**
 * The {@code GET /reviewSubmissions} route handler.
 *
 * Displays the submissions for the given author
 */
public class GetReviewSubmissionsRoute implements TemplateViewRoute {

    private final SAMCenter samCenter;

    public GetReviewSubmissionsRoute(SAMCenter samCenter) {
        this.samCenter = samCenter;
    }

    @Override
    public ModelAndView handle(Request request, Response response) {
        Map<String, Object> vm = new HashMap<>();
        vm.put("title", GetHomeRoute.TITLE);


        HashMap<String, Integer> yourSubmissions = new HashMap<>();
        for(int x = 0; x < samCenter.getSubmittedPapers().size(); x++){
            if(samCenter.getSubmittedPapers().get(x).getUsername().equals(request.cookie("usernameAuthor"))){
                yourSubmissions.put(samCenter.getSubmittedPapers().get(x).getTitle(), samCenter.getSubmittedPapers().get(x).getVersion());
            }
        }

        vm.put("submissions", yourSubmissions);
        return new ModelAndView(vm, "reviewSubmissions.ftl");
    }
}
