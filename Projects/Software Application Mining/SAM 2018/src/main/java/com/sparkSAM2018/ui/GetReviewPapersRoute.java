package com.sparkSAM2018.ui;

import com.sparkSAM2018.application.SAMCenter;
import spark.ModelAndView;
import spark.Request;
import spark.Response;
import spark.TemplateViewRoute;

import javax.servlet.http.Part;
import java.lang.reflect.Array;
import java.util.*;

/**
 * The {@code GET /reviewPapers} route handler.
 *
 * Displays the assigned PCMs to their associated papers
 */
public class GetReviewPapersRoute implements TemplateViewRoute {

    private final SAMCenter samCenter;

    public GetReviewPapersRoute(SAMCenter samCenter){
        this.samCenter = samCenter;
    }

    @Override
    public ModelAndView handle(Request request, Response response){
        Map<String, Object> vm = new HashMap<>();
        vm.put("title", GetHomeRoute.TITLE);

        ArrayList value;
        List<String> noties = new ArrayList<>();
        for(String name: samCenter.getAssignmentMap().keySet()){
            value = samCenter.getAssignmentMap().get(name);
            if(value.contains(request.cookie("usernamePCM"))){
                List<String> strings = Arrays.asList(name.replaceAll("^.*?", "").split("by.*?(=|$)"));
                for(int y = 0; y < strings.size(); y++){
                    String stris3 = strings.get(y).replaceAll("\\s$","");
                    noties.add(stris3);
                }
            }
        }

        List<String> fileName = new ArrayList<>();
        for(int x = 0; x < noties.size(); x++) {
            for (int y = 0; y < samCenter.getSubmittedPapers().size(); y++){
                String hi = samCenter.getSubmittedPapers().get(y).getTitle();
                String yo = noties.get(x);
                if(noties.get(x).equals(samCenter.getSubmittedPapers().get(y).getTitle())){
                    Part file = samCenter.getSubmittedPapers().get(y).getPaper();
                    fileName.add(PostPaperRoute.getSubmittedFileName(file));
                }
            }
        }

        if(request.queryParams("empty") != null){
            fileName = new ArrayList<>();
            vm.put("notification", "You have successfully submitted your review.");
        }
        vm.put("paperName", fileName);
        return new ModelAndView (vm,"review.ftl");
    }
}