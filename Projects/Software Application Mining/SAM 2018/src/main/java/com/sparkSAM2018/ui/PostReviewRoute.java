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
 * The {@code POST /postReview} route handler.
 *
 * Verifies a PCM's review of a paper
 */
public class PostReviewRoute implements TemplateViewRoute {

    private final SAMCenter samCenter;
    Notification note;

    public PostReviewRoute(SAMCenter samCenter, Notification note) {
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

        int rating = Integer.parseInt(request.queryParams("rating"));
        String comments = request.queryParams("comments");
        comments = comments.replace("\n", "").replace("\r", "");

        String paper = request.queryParams("paper");
        String stris3 = "";
        for(int x = 0; x < samCenter.getSubmittedPapers().size(); x++){
            Part file = samCenter.getSubmittedPapers().get(x).getPaper();
            String fileName = PostPaperRoute.getSubmittedFileName(file);
            if(paper.equals(fileName)){
                stris3 = fileName;
            }
        }

        String pcm = request.cookie("usernamePCM");
        samCenter.getReviews().add(new Review(rating, comments, stris3, pcm));
        note.sendReviewNotification(samCenter);

        response.redirect("/reviewPapers?empty=yes");
        halt();
        return null;
    }
}