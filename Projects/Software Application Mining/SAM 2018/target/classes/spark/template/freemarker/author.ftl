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
                <a href="/author">Home Page</a> -
                <a href="/submitPaper">Submit Paper</a> -
                <a href="/reviewSubmissions">Review Submissions</a> -
                <a href="/submissionReport">Final Review Reports</a> -
                <a href="/">Sign Out</a>
            </div><br /><br />

            <div class="notification" id="notification">
                <#if notification??>
                    <#list notification as notification>
                        ${notification}, click <a href="/author?notification=${notification}">ok</a> to acknowledge.<br />
                    </#list>
                </#if>
            </div>

            <h2>
                <div class="body">
                    Author Page
                </div>
            </h2>
        </div>
    </body>
</html>