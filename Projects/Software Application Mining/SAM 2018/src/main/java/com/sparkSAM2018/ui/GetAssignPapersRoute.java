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
 * The {@code GET /assignPaper} route handler.
 *
 * Displays the page that shows the papers available for assignment
 */
public class GetAssignPapersRoute implements TemplateViewRoute {

    private final SAMCenter samCenter;

    public GetAssignPapersRoute(SAMCenter samCenter){
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

        vm.put("papersSubmitted",samCenter.getPapersSubmitted());
        vm.put("samCenter", samCenter);

        return new ModelAndView(vm, "assignPapers.ftl");
    }
}

