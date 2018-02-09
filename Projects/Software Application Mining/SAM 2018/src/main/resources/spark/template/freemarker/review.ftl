<!DOCTYPE html>
<head xmlns="http://www.w3.org/1999/html">
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"></meta>

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
                    Paper Review Assignments
                </div>
                <div class="subbody">
                    *click on a paper to show review form*
                </div>
            </h2>

            <#if paperName??>
                Your Assigned Papers: <br />
                <ol>
                    <#list paperName as n>
                        <form action="/postReview?paper=${n}" method="POST">
                            Paper: <a href="UploadedPapers/${n}" onclick="showReviewForm()" target="_blank" > <i>${n}</i> </a>
                            <div class="reviewForm" id="reviewForm">
                                <br />
                                    Rating of Paper, 1 through 10: <input type="number" name="rating" min="1" max="10"><br />
                                    Overall Comments About Paper: <br />
                                    <textarea placeholder="Overall comments here...." name="comments"
                                          rows="3"
                                          cols="50"></textarea>
                                    <input type="submit" value="Submit Review">
                            </div>
                        </form>
                    </#list>
                </ol>
            </#if>

            <#if notification??>
                ${notification}
            </#if>
        </div>

        <script type="text/javascript">
            function showReviewForm() {
                var element = document.getElementById("reviewForm");
                element.style.display = 'block';
            }
        </script>
    </body>
</html>