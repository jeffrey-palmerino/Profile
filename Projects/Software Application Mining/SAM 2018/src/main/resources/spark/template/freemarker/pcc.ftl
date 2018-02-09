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

            <div class="container">

            </div>
            <div class="navigation">
                <a href="/pcc">Home Page</a> -
                <a href="/assignPapers">Assign Papers</a> -
                <a href="/reviewedPapers">Reviewed Papers</a> -
                <a href="/pcmInterests">PCM Interests</a> -
                <a href="/">Sign Out</a>
            </div><br /><br />

            <div class="notification" id="notification">
                <#if notification??>
                    <#list notification as notification>
                        ${notification}, click <a href="/pcc?notification=${notification}">ok</a> to acknowledge.<br />
                    </#list>
                </#if>
            </div>

            <h2>
                <div class="body">
                    PCC Page
                </div>
            </h2>
        </div>

        <script type="text/javascript">
            function hideNotification(){
                var element = document.getElementById("notification");
                element.style.display = 'none';
            }
        </script>
    </body>
</html>