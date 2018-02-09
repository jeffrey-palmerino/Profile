package com.sparkSAM2018.ui;

import com.sparkSAM2018.application.SAMCenter;

import com.sparkSAM2018.model.Administrator;
import com.sparkSAM2018.model.Notification;
import spark.ModelAndView;
import spark.Request;
import spark.Response;
import spark.TemplateViewRoute;

import java.util.HashMap;
import java.util.Map;

import static spark.Spark.halt;

/**
 * The {@code POST /manageNotificatios} route handler.
 *
 * Verify the changes made by the admin to the notifications
 */
public class PostManageNotificationsRoute implements TemplateViewRoute {

    private final SAMCenter samCenter;
    private final Notification note;

    public PostManageNotificationsRoute(SAMCenter samCenter, Notification note) {
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

        String submission_note = request.queryParams("submissionNote");
        String interests_note = request.queryParams("interestsNote");
        String reviewed_note = request.queryParams("reviewedNote");
        String assigned_note = request.queryParams("assignedNote");

        Administrator admin = new Administrator(note);
        admin.modifyNotifications(submission_note,interests_note,reviewed_note,assigned_note);

        response.redirect("/manageNotifications");
        halt();
        return null;
    }
}