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

            <h2>
                <div class="body">
                    Final Reports of Reviewed Submissions
                </div>
            </h2>

            <#if finalReview??>
                Final Reports
                <ol>
                    <li>Title: <a href="UploadedPapers/${finalReview.getPaperTitle()}">${finalReview.getPaperTitle()}</a></li>
                    <ul>
                        <li>Final Rating: ${finalReview.getRating()}</li>
                        <li>Final Comments: ${finalReview.getComments()}</li>
                    </ul>
                </ol>
            </#if>

        </div>
    </body>
</html>