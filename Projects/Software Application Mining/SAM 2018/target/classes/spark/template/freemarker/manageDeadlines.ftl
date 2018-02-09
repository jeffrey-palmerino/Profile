<!DOCTYPE html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"></meta>
    <title>${title} | SAM 2018</title>
    <link rel="stylesheet" type="text/css" href="/css/style.css">
</head>
    <body>
        <div class="page">

            <h1> - Software Architecture Mining 2018 - </h1>

            <div class="navigation">
                <a href="/admin">Home Page</a> -
                <a href="/manageAccounts">Manage Accounts</a> -
                <a href="/manageDeadlines">Manage Deadlines</a> -
                <a href="/manageNotifications">Manage Notifications</a> -
                <a href="/">Sign Out</a>
            </div><br /><br />

            <h2>
                <div class="body">
                    Admin Page
                </div>
            </h2>

            Current Paper Submission Deadline: <#if submissionDeadline??> ${submissionDeadline?date}</#if><br />
            Current Review Deadline: <#if reviewDeadline??> ${reviewDeadline?date}</#if><br />

            <br />
            <form method="GET" action="/manageDeadlines">
                Change Submission Deadline: <input type="date" name="submissionDeadline"></input><br />
                Change Review Deadline: <input type="date" name="reviewDeadline"></input><br />
                <input type="submit" value="Change Date(s)"> </input>
            </form>

        </div>
    </body>
</html>