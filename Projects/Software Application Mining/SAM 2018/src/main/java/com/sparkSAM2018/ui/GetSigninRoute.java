package com.sparkSAM2018.ui;

import spark.TemplateViewRoute;

import spark.*;
import java.util.HashMap;
import java.util.Map;

/**
 * The {@code GET /signin} route handler.
 *
 * Displays signin page
 */
public class GetSigninRoute implements TemplateViewRoute {

    /**
     * {@inheritDoc}
     */
    @Override
    public ModelAndView handle(Request request, Response response) {
        Map<String, Object> vm = new HashMap<>();
        vm.put("title", GetHomeRoute.TITLE);


        return new ModelAndView(vm, "signin.ftl");
    }
}

