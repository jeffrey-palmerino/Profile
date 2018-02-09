package com.sparkSAM2018.ui;

import com.sparkSAM2018.application.SAMCenter;

import com.sparkSAM2018.model.Notification;
import spark.*;

import java.util.*;

/**
 * The {@code POST /postAssignPapers} route handler.
 *
 * Verifies an assignment of PCMs to a given paper
 */
public class PostAssignPapers implements TemplateViewRoute {

    private final SAMCenter samCenter;
    private final Notification note;

    public PostAssignPapers(SAMCenter samCenter, Notification note) {
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

        QueryParamsMap map = request.queryMap("assignedAuthor");
        QueryParamsMap map2 = request.queryMap("paper");

        phase1(map,map2,response);
        phase2(request,vm);
        note.sendAssignedPaperNotification(samCenter);

        vm.put("samCenter",samCenter);
        vm.put("papersSubmitted",samCenter.getPapersSubmitted());
        vm.put("notification", "You have successfully assigned a paper.");

        return new ModelAndView(vm, "assignPapers.ftl");
    }

    public void phase1(QueryParamsMap map, QueryParamsMap map2, Response response){
        String selected_pcm[] = map.values();
        String paper[] = map2.values();

        String assigned_PCMS="";
        String assigned_paper="";
        for(Object obj:selected_pcm) {
            assigned_PCMS = assigned_PCMS+(String)obj+"_";
        }
        for(Object obj:paper) {
            assigned_paper = (String)obj;
        }
        response.cookie("assigned_PCMS",assigned_PCMS);
        response.cookie("assigned_paper",assigned_paper);
    }

    public void phase2(Request request, Map<String, Object> vm){
        String paper_assigned = "";
        ArrayList assigned_PCMS_list = new ArrayList();
        try {
            String pcms_Assigned = request.cookie("assigned_PCMS");
            paper_assigned = request.cookie("assigned_paper");

            StringTokenizer st1 = new StringTokenizer(pcms_Assigned, "_");
            StringTokenizer st2 = new StringTokenizer(paper_assigned, "_");
            while (st1.hasMoreTokens()) {
                assigned_PCMS_list.add(st1.nextElement());
            }
            while (st2.hasMoreTokens()) {
                Object paper = st2.nextElement();
                paper_assigned = (String)paper;
            }
        }
        catch(NullPointerException e){
           //nothing
        }

        for(int x = 0; x < samCenter.getPapersSubmitted().size(); x++){
            if(samCenter.getPapersSubmitted().get(x).equals(paper_assigned)){
                samCenter.getPapersSubmitted().remove(x);
            }
        }
        samCenter.getAssignmentMap().put(paper_assigned,assigned_PCMS_list);
    }
}
