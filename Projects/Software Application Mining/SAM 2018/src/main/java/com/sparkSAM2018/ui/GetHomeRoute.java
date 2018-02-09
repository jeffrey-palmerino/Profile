package com.sparkSAM2018.ui;

import spark.*;
import java.util.HashMap;
import java.util.Map;

/**
 * The {@code GET /} route handler.
 *
 * Displays home page
 */
public class GetHomeRoute implements TemplateViewRoute {

    static final String TITLE = "Software Architecture Mining";

    /**
     * {@inheritDoc}
     */
    @Override
    public ModelAndView handle(Request request, Response response) {
        Map<String, Object> vm = new HashMap<>();
        vm.put("title", TITLE);

        return new ModelAndView(vm, "home.ftl");
    }
}

