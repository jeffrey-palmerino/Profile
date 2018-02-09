package com.sparkSAM2018.ui;

import com.sparkSAM2018.application.SAMCenter;
import spark.ModelAndView;
import spark.Request;
import spark.Response;
import spark.TemplateViewRoute;

import java.util.HashMap;
import java.util.Map;

/**
 * The {@code GET /admin} route handler.
 *
 * Displays the Administrators home page
 */
public class GetAdministratorRoute implements TemplateViewRoute {

    private final SAMCenter samCenter;

    public GetAdministratorRoute(SAMCenter samCenter) {
        this.samCenter = samCenter;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public ModelAndView handle(Request request, Response response) {
        Map<String, Object> vm = new HashMap<>();
        vm.put("title", GetHomeRoute.TITLE);

        return new ModelAndView(vm, "admin.ftl");
    }
}
