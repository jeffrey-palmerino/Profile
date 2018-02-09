package com.sparkSAM2018.ui;

import com.sparkSAM2018.application.SAMCenter;

import com.sparkSAM2018.model.Notification;
import com.sparkSAM2018.model.Review;
import spark.ModelAndView;
import spark.Request;
import spark.Response;
import spark.TemplateViewRoute;

import java.util.*;

import static spark.Spark.halt;

/**
 * The {@code GET /reviewedPapers} route handler.
 *
 * Displays the reviewed papers to the PCC
 */
public class GetReviewedPapersRoute implements TemplateViewRoute {

    private final SAMCenter samCenter;

    public GetReviewedPapersRoute(SAMCenter samCenter) {
        this.samCenter = samCenter;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public ModelAndView handle(Request request, Response response) {
        Map<String, Object> vm = new HashMap<>();
        vm.put("title", GetHomeRoute.TITLE);

        vm.put("samCenter", samCenter);
        return new ModelAndView(vm, "reviewedPapers.ftl");
    }
}
