package com.sparkSAM2018.ui;

import static spark.Spark.*;

import com.sparkSAM2018.application.SAMCenter;
import com.sparkSAM2018.model.Notification;
import spark.TemplateEngine;
import java.util.Objects;


/**
 * The server that initializes the set of HTTP request handlers.
 * This defines the <em>web application interface</em> for this
 * guessing game application.
 *
 * <p>
 * There are multiple ways in which you can have the client issue a
 * request and the application generate responses to requests. If your team is
 * not careful when designing your approach, you can quickly create a mess
 * where no one can remember how a particular request is issued or the response
 * gets generated. Aim for consistency in your approach for similar
 * activities or requests.
 * </p>
 *
 * <p>Design choices for how the client makes a request include:
 * <ul>
 *     <li>Request URL</li>
 *     <li>HTTP verb for request (GET, POST, PUT, DELETE and so on)</li>
 *     <li><em>Optional:</em> Inclusion of request parameters</li>
 * </ul>
 * </p>
 *
 * <p>Design choices for generating a response to a request include:
 * <ul>
 *     <li>View templates with conditional elements</li>
 *     <li>Use different view templates based on results of executing the client request</li>
 *     <li>Redirecting to a different application URL</li>
 * </ul>
 * </p>
 *
 * @author <a href='mailto:bdbvse@rit.edu'>Bryan Basham</a>
 */
public class WebServer {

    //
    // Constants
    //

    /**
     * The URL patterns to request pages
     */

    public static final String HOME_URL = "/";
    public static final String SIGNIN_URL = "/signin";
    public static final String REGISTRATION_URL = "/registration";

    public static final String AUTHOR_URL = "/author";
    public static final String PCM_URL = "/pcm";
    public static final String PCC_URL = "/pcc";
    public static final String ADMIN_URL = "/admin";

    //
    // Attributes
    //
    //private final SAMCenter samCenter;
    private final SAMCenter samCenter;
    private final Notification note;
    private final TemplateEngine templateEngine;

    //
    // Constructor
    //

    /**
     * The constructor for the Web Server.
     *
     * @param samCenter
     *    The {@link //CheckersCenter} for the application
     * @param templateEngine
     *    The default {@link TemplateEngine} to render views.
     */
    public WebServer(final SAMCenter samCenter,
                     final TemplateEngine templateEngine, final Notification note) {
        Objects.requireNonNull(samCenter, "samCenter must not be null");
        Objects.requireNonNull(templateEngine, "templateEngine must not be null");
        this.samCenter = samCenter;
        this.templateEngine = templateEngine;
        this.note = note;
    }

    //
    // Public methods
    //

    /**
     * Initialize all of the HTTP routes that make up this web application.
     *
     * <p>
     * Initialization of the web server includes defining the location for static
     * files, and defining all routes for processing client requests. The method
     * returns after the web server finishes its initialization.
     * </p>
     */
    public void initialize() {
        // Configuration to serve static files
        externalStaticFileLocation(System.getProperty("user.dir") + "\\src\\main\\resources\\public");

        //GET routes related to signing in, registering, home page
        get(HOME_URL, new GetHomeRoute(), templateEngine);
        get(SIGNIN_URL, new GetSigninRoute(), templateEngine);
        get(REGISTRATION_URL, new GetRegistrationRoute(), templateEngine);

        //GET routes related to the author
        get(AUTHOR_URL, new GetAuthorRoute(samCenter), templateEngine);
        get("/submitPaper", new GetSubmitPaperRoute(samCenter), templateEngine);
        get("/reviewSubmissions", new GetReviewSubmissionsRoute(samCenter), templateEngine);
        get("/submissionReport", new GetSubmissionReportRoute(samCenter,note), templateEngine);

        //GET routes related to PCM
        get(PCM_URL, new GetPCMRoute(samCenter), templateEngine);
        get("/submittedPapers", new GetSubmittedPapersRoute(samCenter), templateEngine);
        get("/reviewPapers", new GetReviewPapersRoute(samCenter),templateEngine);

        //GET routes related to PCC
        get(PCC_URL, new GetPCCRoute(samCenter), templateEngine);
        get("/assignPapers", new GetAssignPapersRoute(samCenter), templateEngine);
        get("/pcmInterests", new GetPCMInterestsRoute(samCenter), templateEngine);
        get("/reviewedPapers", new GetReviewedPapersRoute(samCenter), templateEngine);

        //GET routes related to administrator
        get(ADMIN_URL, new GetAdministratorRoute(samCenter), templateEngine);
        get("/manageAccounts", new GetManageAccountsRoute(samCenter,note), templateEngine);
        get("/manageDeadlines", new GetManageDeadlinesRoute(samCenter), templateEngine);
        get("/manageNotifications", new GetManageNotificationsRoute(samCenter,note), templateEngine);


        //POST routes
        post("/name", new PostNameRoute(samCenter,note), templateEngine);
        post("/registrationPost", new PostRegistrationRoute(samCenter), templateEngine);
        post("/postPaper", new PostPaperRoute(samCenter,note), templateEngine);
        post("/reviewRequest", new PostReviewRequest(samCenter,note), templateEngine);
        post("/postAssignPapers", new PostAssignPapers(samCenter,note), templateEngine);
        post("/postReview", new PostReviewRoute(samCenter,note), templateEngine);
        post("/postManageNotifications", new PostManageNotificationsRoute(samCenter,note), templateEngine);
        post("/finalReport", new PostFinalReportRoute(samCenter,note), templateEngine);
    }
}
