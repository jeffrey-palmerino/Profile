package com.sparkSAM2018.ui;

import com.sparkSAM2018.application.SAMCenter;

import com.sparkSAM2018.model.Notification;
import spark.ModelAndView;
import spark.Request;
import spark.Response;
import spark.TemplateViewRoute;

import java.util.HashMap;
import java.util.Map;

/**
 * The {@code GET /manageDeadlines} route handler.
 *
 * Displays the page for the administrator to manage deadlines
 */
public class GetManageNotificationsRoute implements TemplateViewRoute {

    private final SAMCenter samCenter;
    private final Notification note;

    public GetManageNotificationsRoute(SAMCenter samCenter, Notification note){
        this.samCenter = samCenter;
        this.note = note;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public ModelAndView handle(Request request, Response response) {
        Map<String, Object> vm = new HashMap<>();
        vm.put("title", GetHomeRoute.TITLE);

        vm.put("submission", note.getSubmissionNote());
        vm.put("review", note.getReviewNote());
        vm.put("interests", note.getInterestsNote());
        vm.put("assigned", note.getAssignedNote());

        return new ModelAndView(vm, "manageNotifications.ftl");
    }
}

