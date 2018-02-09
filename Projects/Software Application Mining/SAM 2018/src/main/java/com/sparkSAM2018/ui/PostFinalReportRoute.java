package com.sparkSAM2018.ui;

import com.sparkSAM2018.application.SAMCenter;

import com.sparkSAM2018.model.Notification;
import com.sparkSAM2018.model.Review;
import spark.ModelAndView;
import spark.Request;
import spark.Response;
import spark.TemplateViewRoute;

import javax.servlet.http.Part;

import java.util.*;

import static spark.Spark.halt;

/**
 * The {@code POST /reviewRequest} route handler.
 *
 * Verifies a PCM's review request (i.e. there interests in papers)
 */
public class PostFinalReportRoute implements TemplateViewRoute {

    private final SAMCenter samCenter;
    private final Notification note;

    public PostFinalReportRoute(SAMCenter samCenter, Notification note) {
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

        int final_rating = Integer.parseInt(request.queryParams("rating"));
        String comments = request.queryParams("comments");
        comments = comments.replace("\n", "").replace("\r", "");

        String paper = request.queryParams("paper");
        samCenter.getFinalReviews().add(new Review(final_rating,comments,paper,null));
        note.sendFinalReportNotification(samCenter);

        for(int x = 0; x < samCenter.getReviews().size(); x++){
            if(samCenter.getReviews().get(x).getPaperTitle().equals(paper)){
                samCenter.getReviews().remove(x);
            }
        }

        vm.put("samCenter", samCenter);
        vm.put("finalReviewNotification", "You have successfully submitted a final review.");
        return new ModelAndView(vm, "reviewedPapers.ftl");
    }
}