<!DOCTYPE html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"></meta>
    <title>${title} | SAM 2018</title>
    <link rel="stylesheet" href="/css/style.css">
    <link rel="stylesheet" href="/css/game.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>

</head>
    <body>
        <div class="page">

            <h1> - Software Architecture Mining 2018 - </h1>

            <div class="navigation">
                <a href="/">Home Page</a> -
                <a href="/signin">Sign In</a>
            </div>

            <h3> Welcome conference member! Enter your login information below. </h3>

            <div>
                Not signed up? Register with the conference through <a href="/registration">this</a> link!
            </div><br /><br />

            Member Type:
            <form action="/name" method="POST">
                <div>
                    <input type="radio" name="memberType" value="author"> Author </input>
                    <input type="radio" name="memberType" value="pcm"> Program Committee Member </input>
                    <input type="radio" name="memberType" value="pcc"> Program Committee Chair </input>
                    <input type="radio" name="memberType" value="administrator"> Administrator </input>
                </div>

                <br/>
                Username: <br />
                <input name="username" />
                <br/>

                <div>
                    <#if usernameError??>
                        ${usernameError}
                    </#if>
                </div><br />

                <button type="submit"> Sign In </button>
            </form>

        </div>


    </body>
</html>