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
                    Submit Paper Page
                </div>
            </h2>

            <form method="POST" enctype="multipart/form-data" action="/postPaper">
                Enter Author Name: <input type="text" name="authorName" required><br />
                Enter Title: <input type="text" name="title" required><br />
                Enter Version: <input type="number" name="version" required><br />
                Enter Contact Author Email: <input type="email" name="email" required><br />
                Enter File Type: <input type="text" name="filetype" required>
                <br /><br />

                File to upload: <br />
                <input type="file" name="uploaded_file" accept=".pdf,.doc,.docx" required="true"> <br/>
                <input type="submit" required="true" value="Press"> to upload the paper.
            </form> <br /><br />


            <#if paperSubmissionMessage??>
                ${paperSubmissionMessage}
            </#if>
        </div>
    </body>
</html>