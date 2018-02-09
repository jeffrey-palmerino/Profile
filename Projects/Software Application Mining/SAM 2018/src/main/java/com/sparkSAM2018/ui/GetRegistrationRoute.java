package com.sparkSAM2018.ui;

import spark.ModelAndView;
import spark.Request;
import spark.Response;
import spark.TemplateViewRoute;

import java.util.HashMap;
import java.util.Map;

/**
 * The {@code GET /registration} route handler.
 *
 * Displays page for registration
 */
public class GetRegistrationRoute implements TemplateViewRoute {

    static final String TITLE = "Software Architecture Mining";
    /**
     * {@inheritDoc}
     */
    @Override
    public ModelAndView handle(Request request, Response response) {
        Map<String, Object> vm = new HashMap<>();
        vm.put("title", TITLE);

        return new ModelAndView(vm, "registration.ftl");
    }
}