<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Completed Tasks</title>

<link rel="stylesheet" href="web\style.css">
<script type="text/javascript" src="http://code.jquery.com/jquery-1.9.1.js"></script>
<script src="web\startbootstrap_creative\js\bootstrap.min.js"></script>
<script type="text/javascript" src="web/main.js"></script>
<link rel="stylesheet" href="web\startbootstrap_creative\css\bootstrap.min.css">
<!--<link rel="stylesheet" href="web\startbootstrap_creative\css\creative.min.css">-->
<link rel="stylesheet" href="web\startbootstrap_creative\css\myStyle.css">

<link rel="stylesheet" href="web\font_awesome\css\font-awesome.min.css">

</head>
<body onload="loadTaskForUser(true)">
<header class="headerClass">

    <nav class="navbar navbar-default navbar-fixed-top" id="navbar">
      <div class="container-fluid">
        <!-- Brand and toggle get grouped for better mobile display -->
        <div class="navbar-header">
          <button type="button" class="navbar-toggle collapsed nav-btn-icon-movil" data-toggle="collapse" data-target="#bs-navbar-main" aria-expanded="false">
            <i class="fa fa-navicon animated"></i>
          </button>
          <a class="navbar-brand text-uppercase" href="#">
            Task Management
          </a>
        </div>
        <!-- Collect the nav links, forms, and other content for toggling -->
        <div class="collapse navbar-collapse" id="bs-navbar-main">
          <ul class="nav navbar-nav navbar-right">
            <li><a href="taskPage.jsp"><i class="fa fa-user"></i>&nbsp; Pending Tasks</a></li>
            <li class="active"><a ><i class="fa fa-coffee"></i>&nbsp; Completed Tasks</a></li>
            
          </ul>
        </div><!-- /.navbar-collapse -->
      </div><!-- /.container-fluid -->
    </nav>
  </header>
<div class="container CustomProperty">

    <div class="row">

      <div class="col-xs-11 col-sm-6 col-md-6 col-lg-6">
        <!-- title name -->
		<div id="username1" style= "
    font-size: 30px;
    color: greenyellow;
    font-weight: bolder;">
		</div><a href="index.jsp">Logout</a>
        <h1 class="text-uppercase">See your completed Tasks history!</h1>
        <br>
        

		<div id="taskList">
		<div class="table-responsive">        
              <table id="mytable" class="table table-bordred table-striped">
                   
                   <thead>
                   
                   <tr>
                   <th>Task Title</th>
                    <th>Task Message</th>
                     <th>Date</th>
                     <th>Priority</th>
                     
                      
                       <th>Delete</th>
                   </tr></thead>
    <tbody>
    
    
    
    
   
    
   
    
    </tbody>
        
</table>
</div>

		</div>
        

      </div>
	  
	  <div id="taskParent" class="hideParent col-xs-11 col-sm-6 col-md-6 col-lg-6">
	  
     

<div id="myModal" class="modal1" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
  <div class="modal-dialog">
    <div class="modal-content">
      <div class="modal-header">
        <button onclick="closeAddTask()" type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>
        <h3 id="myModalLabel">Please add the task</h3>
      </div>
      <div class="modal-body">
        <form id="taskform" class="form-horizontal col-sm-12">
          <div class="form-group"><label>Task Title</label><input id="tasktitle" class="form-control required" placeholder="Your name" data-placement="top" data-trigger="manual" data-content="Must be at least 3 characters long, and must only contain letters." type="text"></div>
          <div class="form-group"><label>Task Message</label><textarea id="taskmessage" class="form-control" placeholder="Your message here.." data-placement="top" data-trigger="manual"></textarea></div>
          <div class="form-group"><label>Date</label><input id="date" class="form-control phone" placeholder="DD/MM/YYYY" data-placement="top" data-trigger="manual" data-content="Must be a valid date of future" type="text"></div>
		<div class="dropdown">
  
  <select id="priority">
  <option value="High">High</option>
  <option value="Medium">Medium</option>
  <option value="Low">Low</option>
</select>
</div>
     <div class="form-group"><button onclick="senTaskDetails()" type="button" class="btn btn-success pull-right">Save It!</button> <p class="help-block pull-left text-danger hide" id="form-error">&nbsp; The form is not valid. </p></div>
		</form>
      </div>
      <div class="modal-footer">
        <button onclick="closeAddTask()" type="button" class="btn" data-dismiss="modal" aria-hidden="true">Cancel</button>
      </div>
    </div>
  </div>
</div>
  </div>
  
  <div id="EditParent" class="hideParent col-xs-11 col-sm-6 col-md-6 col-lg-6">
	  
     

<div id="myModal" class="modal1" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
  <div class="modal-dialog">
    <div class="modal-content">
      <div class="modal-header">
        <button onclick="closeAddTask()" type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>
        <h3 id="myModalLabel">Please add the task</h3>
      </div>
      <div class="modal-body">
        <form id="taskform" class="form-horizontal col-sm-12">
          <div class="form-group"><label>Task Title</label><input id="tasktitle1" class="form-control required" placeholder="Your name" data-placement="top" data-trigger="manual" data-content="Must be at least 3 characters long, and must only contain letters." type="text"></div>
          <div class="form-group"><label>Task Message</label><textarea id="taskmessage1" class="form-control" placeholder="Your message here.." data-placement="top" data-trigger="manual"></textarea></div>
          <div class="form-group"><label>Date</label><input id="date1" class="form-control phone" placeholder="DD/MM/YYYY" data-placement="top" data-trigger="manual" data-content="Must be a valid date of future" type="text"></div>
			<input style="display:none;" id="taskid1" class="form-control phone" placeholder="DD/MM/YYYY" data-placement="top" data-trigger="manual" data-content="Must be a valid date of future" type="text">
		
		<div class="dropdown">
  
  <select id="priority1">
  <option value="High">High</option>
  <option value="Medium">Medium</option>
  <option value="Low">Low</option>
</select>
</div>
     <div class="form-group"><button onclick="editTaskDetails(this)" type="button" class="btn btn-success pull-right">Update It!</button> <p class="help-block pull-left text-danger hide" id="form-error">&nbsp; The form is not valid. </p></div>
		</form>
      </div>
      <div class="modal-footer">
        <button onclick="closeAddTask()" type="button" class="btn" data-dismiss="modal" aria-hidden="true">Cancel</button>
      </div>
    </div>
  </div>
</div>
  </div>
  
</div>  

      </div>

    </div>

  </div>
  
</div>

</body>
</html>