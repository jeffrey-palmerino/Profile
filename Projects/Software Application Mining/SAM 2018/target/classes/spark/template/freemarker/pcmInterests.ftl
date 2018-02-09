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
                <a href="/pcc">Home Page</a> -
                <a href="/assignPapers">Assign Papers</a> -
                <a href="/reviewedPapers">Reviewed Papers</a> -
                <a href="/pcmInterests">PCM Interests</a> -
                <a href="/">Sign Out</a>
            </div><br /><br />

            <h2>
                <div class="body">
                    PCM Interests
                </div>
            </h2>

                <#if pcmInterests??>
                    <ol>
                        <#list pcmInterests?keys as key>
                            <li> PCM Username: ${key} </li>
                            <ul>
                                <li> Interests: </li>
                                <ul>
                                    <#list pcmInterests[key] as n>
                                        Paper: <i> ${n} </i> <br />
                                    </#list>
                                </ul>
                            </ul>
                        </#list>
                    </ol>
                </#if>
            </body>
        </div>
    </body>
</html>