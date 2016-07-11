<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Task Management</title>
        <link rel="stylesheet" href="web\style.css">
<link rel="stylesheet" href="web\myStyles.css">
<script type="text/javascript" src="http://code.jquery.com/jquery-1.9.1.js"></script>
<script type="text/javascript" src="web/main.js"></script>
<link rel="stylesheet" href="web\startbootstrap_creative\css\bootstrap.min.css">
<!--<link rel="stylesheet" href="web\startbootstrap_creative\css\creative.min.css">-->
<link rel="stylesheet" href="web\startbootstrap_creative\css\myStyle.css">

<link rel="stylesheet" href="web\font_awesome\css\font-awesome.min.css">
        
    </head>
    <body bgcolor="silver">
        <div class="container ">
    
    <div class="loginParent">
            <div class="panel panel-default">
                <div class="panel-heading"> <strong class="">Login</strong>

                </div>
                <div class="panel-body">
                    <form class="form-horizontal" role="form">
                        <div class="form-group">
                            <label for="inputEmail3" class="col-sm-3 control-label">Email</label>
                            <div class="col-sm-9">
                                <input type="text" class="form-control" id="inputEmail3" placeholder="username" required="">
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="inputPassword3" class="col-sm-3 control-label">Password</label>
                            <div class="col-sm-9">
                                <input type="password" class="form-control" id="inputPassword3" placeholder="Password" required="">
                            </div>
                        </div>
                        <div class="form-group">
                            <div class="col-sm-offset-3 col-sm-9">
                                <div class="checkbox">
                                    <label class="">
                                        <input type="checkbox" class="">Remember me</label>
                                </div>
                            </div>
                        </div>
                        <div class="form-group last">
                            <div class="col-sm-offset-3 col-sm-9">
                                <button onclick="loginAction()" type="button" class="btn btn-success btn-sm">Sign in</button>
                                <button type="reset" class="btn btn-default btn-sm">Reset</button>
                            </div>
                        </div>
                    </form>
                </div>
                <div class="panel-footer">Not Registered? <a href="register.jsp" class="">Register here</a>
                </div>
            </div>
        </div>
		</div>
        
    </body>
</html>