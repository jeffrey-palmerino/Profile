package com.sparkSAM2018.ui;

import com.sparkSAM2018.application.SAMCenter;
import com.sparkSAM2018.model.Notification;
import com.sparkSAM2018.model.Review;
import spark.ModelAndView;
import spark.Request;
import spark.Response;
import spark.TemplateViewRoute;

import java.util.HashMap;
import java.util.Map;

public class GetSubmissionReportRoute implements TemplateViewRoute {

    final private SAMCenter samCenter;
    final private Notification note;

    public GetSubmissionReportRoute(SAMCenter samCenter, Notification note) {
        this.samCenter = samCenter;
        this.note = note;
    }

    @Override
    public ModelAndView handle(Request request, Response response) {
        Map<String, Object> vm = new HashMap<>();
        Map<String, Object> vm2 = force(vm,request);

        vm2.put("title", GetHomeRoute.TITLE);
        return new ModelAndView(vm2, "submissionReports.ftl");
    }

    public Map<String,Object> force(Map<String, Object> vm, Request request){
        Review rev;
        for(String obj: samCenter.getAuthorMap().keySet()){
            if(obj.equals(request.cookie("usernameAuthor"))){
                rev = samCenter.getAuthorMap().get(obj);
                System.out.println(rev);
                vm.put("finalReview", rev);
            }else{
                System.out.println("not working");
            }
        }
        System.out.println("did nothing?");
        return vm;
    }
}


