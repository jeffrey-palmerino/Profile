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

            <h2>
                <div class="body">
                    Reviewed Papers
                </div>
                <div class="subbody">
                    *click on a paper to see the report and to generate a final report*<br />
                </div>
            </h2>

            <#if finalReviewNotification??>
                ${finalReviewNotification}
            </#if><br />

            Papers Reviewed: <br />
            <#if samCenter??>
                <ol>
                    <#list samCenter.getReviews() as rev>
                        <form action="/finalReport?paper=${rev.getPaperTitle()}" method="POST">
                            Paper title: <i><a href="UploadedPapers/${rev.getPaperTitle()}" onclick="showReport()" target="_blank">${rev.getPaperTitle()}</a></i><br />
                            <div class="report" id="report">
                                <p>PCM Rater Username: ${rev.getPcm()}</p>
                                <p>Overall Comments: "${rev.getComments()}" <br /></p>
                                <p>Rating: ${rev.getRating()} </p>
                                <div class="final-report" id="final-report">
                                        Final Rating of Paper, 1 through 10: <input type="number" name="rating" min="1" max="10"><br />
                                        Final Overall Comments About Paper: <br />
                                        <textarea placeholder="Overall comments here...." name="comments"
                                                  rows="3"
                                                  cols="50"></textarea>
                                        <input type="submit" value="Submit Review">
                                </div>
                            </div>
                        </form>
                    </#list>
                </ol>
            </#if>
        </div>

        <script type="text/javascript">
            function showReport(){
                var element = document.getElementById("report");
                element.style.display = 'block';
                showFinalReport();
            }
            function showFinalReport(){
                var element = document.getElementById("final-report");
                element.style.display = 'block';
            }
        </script>
    </body>
</html>