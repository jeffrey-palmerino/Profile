package com.sparkSAM2018.ui;

import com.sparkSAM2018.application.SAMCenter;

import com.sparkSAM2018.model.Notification;
import spark.ModelAndView;
import spark.Request;
import spark.Response;
import spark.TemplateViewRoute;

import javax.servlet.http.Part;

import java.util.*;

/**
 * The {@code POST /reviewRequest} route handler.
 *
 * Verifies a PCM's review request (i.e. there interests in papers)
 */
public class PostReviewRequest implements TemplateViewRoute {

    private final SAMCenter samCenter;
    private final Notification note;

    List<String> preFormattedTitle = new ArrayList<>();
    List<String> finalizedTitles = new ArrayList<>();

    public PostReviewRequest(SAMCenter samCenter, Notification note) {
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

        String str = request.body();
        List<String> strings = Arrays.asList(str.replaceAll("^.*?=", "").split("by.*?(=|$)"));

        for(int x = 0; x < strings.size(); x++){
            String stris = strings.get(x);
            String stris2 = stris.replaceAll("\\+"," ");
             preFormattedTitle.add(stris2);
        }

        for(int x = 0; x < strings.size(); x++){
            String st = preFormattedTitle.get(x);
            String stris3 = st.replaceAll("\\s$","");
            finalizedTitles.add(stris3);
        }

        for(int y = 0; y < finalizedTitles.size(); y++){
            for(int a = 0; a < samCenter.getSubmittedPapers().size(); a++) {
                try {
                    if (samCenter.getSubmittedPapers().get(a).getTitle().equals(finalizedTitles.get(y))) {
                        Part part = samCenter.getSubmittedPapers().get(a).getPaper();
                        samCenter.getInterests().add(part);
                    } else {
                        //do nothing
                    }
                } catch (IndexOutOfBoundsException e) {
                    System.out.println("out of bounds");
                }
            }
        }
        samCenter.getformattedInterests().put(request.cookie("usernamePCM"),finalizedTitles);
        note.sendPCMInterestsNotification(samCenter);

        preFormattedTitle = new ArrayList<>();
        finalizedTitles = new ArrayList<>();

        vm.put("papersSubmitted",samCenter.getPapersSubmitted());
        vm.put("notification", "You have successfully submitted your paper interests.");
        return new ModelAndView(vm,"submittedPapers.ftl");
    }
}
