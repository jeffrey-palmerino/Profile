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

            <h3> Thank you for choosing to register with SAM 2018! </h3>

            <div>
                Please identify your member type below.
            </div>
            <form action="/registrationPost" method="POST">
                <div>
                    <input type="radio" name="memberType" value="author"> Author </input>
                    <input type="radio" name="memberType" value="pcm"> Program Committee Member </input>
                    <input type="radio" name="memberType" value="pcc"> Program Committee Chair </input>
                </div><br /><br />

                Please enter your desired username below. You will be redirected to the sign-in page upon successful registration.

                <br/>
                Username: <input name="username" />
                <br/>

                <div>
                    <#if usernameError??>
                        ${usernameError}
                    </#if>
                </div><br />

                <button type="submit"> Register </button>
            </form>

        </div>


    </body>
</html>