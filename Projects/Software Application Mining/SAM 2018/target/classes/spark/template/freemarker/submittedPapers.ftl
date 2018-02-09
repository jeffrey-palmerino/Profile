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

            <h2>
                <div class="body">
                    Submitted Papers
                </div>
            </h2>

            <#if papersSubmitted??>
                <br />
                Submitted Papers:
                <br />
                <ol>
                    <form method="POST" action="/reviewRequest">
                        <#list papersSubmitted as n>
                            <li> <input class="boxes" name="papers" value="${n}" type="checkbox" > ${n} </input> </li>
                        </#list>
                        <input type="submit" value="Press"> to submit your desired papers.
                    </form>
                </ol>
            </#if>

            <#if notification??>
                ${notification}
            </#if>
        </div>

        <script type="text/javascript">
            jQuery(function(){
                $("input[name=papers]").change(function(){
                    var max= 5;
                    if( $("input[name=papers]:checked").length == max ){
                        $("input[name=papers]").attr('disabled', 'disabled');
                        $("input[name=papers]:checked").removeAttr('disabled');
                    }else{
                        $("input[name=papers]").removeAttr('disabled');
                    }
                });
            });
        </script>
    </body>
</html>