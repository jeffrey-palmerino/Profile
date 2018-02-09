package com.sparkSAM2018.ui;

import com.sparkSAM2018.application.SAMCenter;

import spark.ModelAndView;
import spark.Request;
import spark.Response;
import spark.TemplateViewRoute;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * The {@code GET /manageDeadlines} route handler.
 *
 * Displays the page for the administrator to manage deadlines
 */
public class GetManageDeadlinesRoute implements TemplateViewRoute {

    private final SAMCenter samCenter;

    public GetManageDeadlinesRoute(SAMCenter samCenter){
        this.samCenter = samCenter;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public ModelAndView handle(Request request, Response response) {
        Map<String, Object> vm = new HashMap<>();
        vm.put("title", GetHomeRoute.TITLE);

        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        Date submissionDate;
        if(request.queryParams("submissionDeadline") != null){
            try {
                submissionDate = df.parse(request.queryParams("submissionDeadline"));
                samCenter.setSubmissionDeadline(submissionDate);
            }catch(ParseException e){
                //do nothing
            }
        }

        Date reviewDate;
        if(request.queryParams("reviewDeadline") != null){
            try {
                reviewDate = df.parse(request.queryParams("reviewDeadline"));
                samCenter.setReviewDeadline(reviewDate);
            }catch(ParseException e){
                //nothing
            }
        }

        vm.put("submissionDeadline", samCenter.getSubmissionDeadline());
        vm.put("reviewDeadline", samCenter.getReviewDeadline());

        return new ModelAndView(vm, "manageDeadlines.ftl");
    }
}
