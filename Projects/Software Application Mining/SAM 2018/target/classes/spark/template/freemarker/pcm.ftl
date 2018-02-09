<!DOCTYPE html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>

    <title>${title} | SAM 2018</title>
    <link rel="stylesheet" type="text/css" href="/css/style.css">
</head>
    <body>
        <div class="page">

            <h1> - Software Architecture Mining 2018 - </h1>

            <div class="navigation">
                <a href="/pcm">Home Page</a> -
                <a href="/submittedPapers">Papers Submitted</a> -
                <a href="/reviewPapers">Papers for Review</a> -
                <a href="/">Sign Out</a>
            </div><br /><br />

            <div class="notification" id="notification">
                <#if notification??>
                    <#list notification as notification>
                        ${notification}, click <a href="/pcm?notification=${notification}">ok</a> to acknowledge.<br />
                    </#list>
                </#if>
            </div>

            <h2>
                <div class="body">
                    PCM Page
                </div>
            </h2>
        </div>
    </body>
</html>