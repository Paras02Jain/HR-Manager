<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport"
          content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <!-- Bootstrap CSS -->
    <link rel="stylesheet"
          href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css">

    <style>
    body{
    height:450px;
    }
        .col-25 {
            float: left;
            width: 20%;
            margin-left:20px;
        }

        .col-75 {
            float: left;
            width: 75%;
        }

        input[type=text], input[type=password] {
            width: 80%;
            padding: 5px;
            border: 1px solid #ccc;
            border-radius: 2px;
            resize: vertical;
            max-width: 280px;
           
        }



        fieldset.scheduler-border {
            border: 3px groove black !important;
            padding: 0 1.4em 1.4em 1.4em !important;
            /* margin: 0100 0 0 !important; */
            margin-top:90px;
            -webkit-box-shadow:  0px 0px 0px 0px #000;
            box-shadow:  0px 0px 0px 0px #000;
        }

        legend.scheduler-border {
            width:inherit; /* Or auto */
            padding:0 10px; /* To give a bit of padding on the left and right */
            border-bottom:none;
           
        }
        .col{
        margin-left:95px;}

    </style>
    <title> Employee </title>
</head>
<body>
<header style="background-image: linear-gradient(#AFAEFD, #efe8de);">
		<H1 class="text-center my-10" style="height:90px; padding-top: 15px;">HR Manager Login</H1>
	</header>
<div class="d-md-flex h-100 form">
    <div class="container" style="align-content: center; width:500px">
        <form action="ValidateUser"  method="post">
            <fieldset class="scheduler-border">
                <legend class="scheduler-border">Login</legend>
                <div class="row form-group">
                    <div class="col-25">
                        <label for="username">User ID:</label>
                    </div>
                    <div class="col-75">
                        <input type="text" class="form-control" id="username"
                               name="username" pattern=".{5,50}" required>
                    </div>
                </div>
                <div class="row form-group">
                    <div class="col-25">
                        <label for="password">Password:</label>
                    </div>
                    <div class="col-75">
                        <input type="password" class="form-control" id="password"
                               name="password" pattern=".{5,50}" required>
                    </div>
                </div>

                <div class="row form-group">
                    <div class="col">
                        <button type="submit" class="btn btn-outline-info btn-light">Login</button>
                    </div>
                </div>
            </fieldset>
            
        </form>


    </div>
</div>

<div class="footer">
<footer style="background-image: linear-gradient(#AFAEFD, #efe8de); margin-top:-2px">
		<H4 class="text-center my-10 ">@copyright 2020-2021 Fresher Training </H4>
	</footer>
     
</div>


<!-- Optional JavaScript -->
<!-- jQuery first, then Popper.js, then Bootstrap JS -->
<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"></script>
<script
        src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js"></script>
<script
        src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>



</body>
</html>