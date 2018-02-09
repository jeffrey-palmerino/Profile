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

            Current Paper Submission Notification: <#if submission??> <i>"${submission}"</i> </#if><br />
            Current Paper Reviewed Notificaiton: <#if review??> <i>"${review}"</i> </#if><br />
            Current Interests Submitted Notificaiton: <#if interests??> <i>"${interests}"</i> </#if><br />
            Current Assigned Paper Notificaiton: <#if assigned??> <i>"${assigned}"</i> </#if><br />

            <br />
            <form action="/postManageNotifications" method="POST">
                Change Submitted Paper Notification: <input type="text" name="submissionNote"><br />
                Change Paper Reviewed Notification: <input type="text" name="reviewedNote"><br />
                Change Paper Interests Notification: <input type="text" name="interestsNote"><br />
                Change Assigned Paper Notification: <input type="text" name="assignedNote"><br />
                <input type="submit" value="Change Notification(s)"> </input>
            </form>

        </div>
    </body>
</html>