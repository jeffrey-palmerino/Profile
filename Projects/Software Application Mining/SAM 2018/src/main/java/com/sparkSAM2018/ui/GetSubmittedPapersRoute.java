package com.sparkSAM2018.ui;

import com.sparkSAM2018.application.SAMCenter;

import spark.ModelAndView;
import spark.Request;
import spark.Response;
import spark.TemplateViewRoute;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * The {@code GET /submittedPapers} route handler.
 *
 * Displays the submitted papers so a PCM can submit their interests
 */
public class GetSubmittedPapersRoute implements TemplateViewRoute {

    private final SAMCenter samCenter;

    public GetSubmittedPapersRoute(SAMCenter samCenter) {
        this.samCenter = samCenter;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public ModelAndView handle(Request request, Response response) {
        Map<String, Object> vm = new HashMap<>();
        vm.put("title", GetHomeRoute.TITLE);

        if(!samCenter.getPapersSubmitted().isEmpty()){
            samCenter.getPapersSubmitted().clear();
        }
        for(int x = 0; x < samCenter.getSubmittedPapers().size(); x++){
            samCenter.getPapersSubmitted().add(samCenter.getSubmittedPapers().get(x).getTitle() + " by " +
            samCenter.getSubmittedPapers().get(x).getAuthor() + ", version: " + samCenter.getSubmittedPapers().get(x).getVersion());
        }

        if(samCenter.getPapersSubmitted().size() > 0){
            vm.put("papersSubmitted",samCenter.getPapersSubmitted());
        } else{
            //do nothing
        }

        return new ModelAndView(vm, "submittedPapers.ftl");
    }
}
