package com.sparkSAM2018.ui;

import com.sparkSAM2018.application.SAMCenter;
import com.sparkSAM2018.model.Administrator;
import com.sparkSAM2018.model.Notification;
import spark.ModelAndView;
import spark.Request;
import spark.Response;
import spark.TemplateViewRoute;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * The {@code GET /manageAccounts} route handler.
 *
 * Displays the page for the administrator to manage accounts
 */
public class GetManageAccountsRoute implements TemplateViewRoute {

    private final SAMCenter samCenter;
    private final Notification note;
    Administrator admin;

    public GetManageAccountsRoute(SAMCenter samCenter, Notification note){
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
        admin = new Administrator(note);

        if(request.queryParams("usernameDelete") != null){
            admin.deleteUsername(samCenter,request.queryParams("usernameDelete"));
        }
        if(request.queryParams("usernameAdd") != null){
            admin.addUsername(samCenter,request.queryParams("memberType"),request.queryParams("usernameAdd"));
        }

        List<String> aNames = new ArrayList<>();
        for(int x=0; x<samCenter.getAuthorUsernameList().size(); x++){
            aNames.add(samCenter.getAuthorUsernameList().get(x).getAuthorUsername());
        }
        List<String> pcc = new ArrayList<>();
        for(int x=0; x<samCenter.getPCCUsernameList().size(); x++){
            pcc.add(samCenter.getPCCUsernameList().get(x).getPCCName());
        }
        List<String> pcms = new ArrayList<>();
        for(int x=0; x<samCenter.getPCMUsernameList().size(); x++){
            pcms.add(samCenter.getPCMUsernameList().get(x).getPCMName());
        }

        vm.put("authors", aNames);
        vm.put("pcms", pcms);
        vm.put("pcc", pcc);

        return new ModelAndView(vm, "manageAccounts.ftl");
    }
}
