/**
 * 
 */
function loginAction(){
	var userName = document.getElementById("inputEmail3").value ;    
    var password = document.getElementById("inputPassword3").value;

		var request = $.ajax({
        url : 'rest/login?username='+userName+'&password='+password,
        type: "get",   
        success: function(response) {
		
            //sen request to next page.
    		if(response == "true"){
                alert("Login Successful!");
    		localStorage.setItem("username", userName);
    		window.location.href = 'taskPage.jsp?username='+userName;
    		}
			else{
			alert("Login failure. Incorrect username/password. Please try again.");
			}
      
        },   
        failure: function(msg)
        {		alert("login failed");
            // $("#sometextplace").text("Procedure did not load");
        }
    });
    
}
function onLoadAddTask(){

}
function register(){
	var username = document.getElementById("username").value ;
	var firstname = document.getElementById("first_name").value ;    
    var lastname = document.getElementById("last_name").value;
    var email = document.getElementById("email").value ;    
    var password = document.getElementById("password").value ;    
    
 var request = $.ajax({ 
     url : 'rest/register?username='+username+'&password='+password+'&email='+email+'&first_name='+firstname+'&last_name='+lastname,
     type: "get",   
     success: function(response) {
	 

	if(response == "true"){
	alert("Registration Successful!");
		window.location.href ='index.jsp';
		}
		else{
		alert("Registration failure! please try again!");
		}
     },   
     failure: function(msg)
     {
	 alert("failure while registering");
         // $("#sometextplace").text("Procedure did not load");
     }
 });
}

function addAction(){
document.getElementById("taskform").reset();
	$('#taskParent').show();	
}
function closeAddTask(){
document.getElementById("taskform").reset();
$('#taskParent').hide();
$('#EditParent').hide();
}
function senTaskDetails(){
var username=localStorage.getItem("username");
	var tasktitle = document.getElementById("tasktitle").value ;
	var taskmessage = document.getElementById("taskmessage").value ;    
    var date = document.getElementById("date").value;    

var sel = document.getElementById("priority");    
var opt = sel.options[sel.selectedIndex];
var priority=opt.value;

$.ajax({			
					url: 'rest/task/savetask?username='+username+'&title='+tasktitle+'&message='+taskmessage+'&date='+date+'&priority='+priority,
					type: "get",
			        success: function (response) {
						if(response == "true"){
						alert("Task successfully added!");
						window.location.href ='taskPage.jsp?username'+username;
						}
			    
			        },
			        error: function (msg) {
			            alert("Please try Adding new tasks again!")
			           
			        }
			    });
}
function completeTask(task){

var username=localStorage.getItem("username");
var tr = task.parentNode.parentNode;
var tr = tr.parentNode;

var taskid = tr.getAttribute('id') ;

if(confirm("Your task will be marked as completed and will be deleted from this list. You want to continue?")){
	
	//aajax
	$.ajax({			
					url: 'rest/task/markcomplete?username='+username+'&id='+taskid,
					type: "get",
			        success: function (response) {
						if(response == "true"){
						$('#'+taskid).remove();
						alert("Task successfully Updated!");
						window.location.href ='taskPage.jsp?username'+username;
						}
			    
			        },
			        error: function (msg) {
			            alert("Updation failed.Please try Again!")
			           
			        }
			    });

	
	}
}


function editTask(sender){

console.log(sender);
var username=localStorage.getItem("username");
var tr = sender.parentNode.parentNode;
var tr = tr.parentNode;
console.log(tr);
var taskid = tr.getAttribute('id') ;

$('#EditParent').show();
console.log("taskid", taskid);
var arr = $("#" + taskid).children();
console.log("array", arr);
$("#tasktitle1").val(arr[1].innerHTML);
$("#taskmessage1").val(arr[2].innerHTML);
$("#date1").val(arr[3].innerHTML);
$("#priority1").val(arr[4].innerHTML);
$("#taskid1").val(taskid);
			
}

function editTaskDetails(task){
var username=localStorage.getItem("username");
	var tasktitle = document.getElementById("tasktitle1").value ;
	var taskmessage = document.getElementById("taskmessage1").value ;    
    var date = document.getElementById("date1").value;    

var sel = document.getElementById("priority1");    
var opt = sel.options[sel.selectedIndex];
var priority=opt.value;

var taskid = $("#taskid1").val();;

$.ajax({			
					url: 'rest/task/updatetask?username='+username+'&title='+tasktitle+'&message='+taskmessage+'&date='+date+'&priority='+priority+'&id='+taskid+'&iscompleted=0',
					type: "get",
			        success: function (response) {
						if(response == "true"){
						alert("Task successfully Updated!");
						window.location.href ='taskPage.jsp?username'+username;
						}
			    
			        },
			        error: function (msg) {
			            alert("Updation failed.Please try Again!")
			           
			        }
			    });

}
function allTasksSubmit(){

}
function deleteTask(task){
console.log(task);
var username=localStorage.getItem("username");
var tr = task.parentNode.parentNode;
var tr = tr.parentNode;

var taskid = tr.getAttribute('id') ;

if(confirm("Your task will be deleted from this list. You want to continue?")){
	$('#'+taskid).remove();
	$.ajax({
			        type: "get",
			        url: 'rest/task/deletetask?username='+username+'&id='+taskid,
			      
			   
			        success: function (response) {
					
			            if(response=="true"){
					alert("Task successfully deleted!");	
						}
						else{
						}
			   
			        },
			        
			        failure: function (msg) {
			            alert("erro");
			            alert(msg.responseText);
			        }
			    });
	
	
	}
}

			  

function loadTaskForUser(status){

var username=localStorage.getItem("username");
$("#username1").html("Hello, "+username);
if(status){
populateTaskList1(username);
}else{
populateTaskList(username); 
}


}

function populateTaskList(username){
	
	$.ajax({
			        type: "get",
			        url: 'rest/task/gettask?username='+username,
			  
			     
			        success: function (data) {
			            
					
			        var trHTML = '';
			                
			        $.each(data.array, function (i, item) {
					
					
				
				 trHTML = '';
			            trHTML += '<tr id='+ data.array[i]["id"]+ '><td><p data-placement="top" data-toggle="tooltip" title="" data-original-title="Edit"><button onclick="completeTask(this)" class="btn btn-success  btn-xs" data-title="Edit" data-toggle="modal" data-target="#edit"><span class="glyphicon glyphicon-ok">'+
						'</span></button></p></td>'+ '<td>' + data.array[i]["title"]+ '</td><td>' + data.array[i]["message"] + '</td><td>'+ data.array[i]["date"] + '</td>'+
							'<td>'+ data.array[i]["priority"] + '</td>'+
						'<td><p data-placement="top" data-toggle="tooltip" title="" data-original-title="Edit"><button onclick="editTask(this)" class="btn btn-primary btn-xs" data-title="Edit"' + 
						'data-toggle="modal" data-target="#edit"><span class="glyphicon glyphicon-pencil"></span></button></p></td>'+
    '<td><p data-placement="top" data-toggle="tooltip" title="" data-original-title="Delete"><button onclick="deleteTask(this)" class="btn btn-danger btn-xs" data-title="Delete" data-toggle="modal" data-target="#delete"><span class="glyphicon glyphicon-trash"></span></button></p></td>'					
						+'</tr>';
						
						 $('#mytable').append(trHTML);
						 
			        });
			        
			       
			        
			        
					},
			        failure: function(msg)
     {
	 alert("failure while registering");
         // $("#sometextplace").text("Procedure did not load");
     }
			    });
			    
}

function populateTaskList1(username){
	
	$.ajax({
			        type: "get",
			        url: 'rest/task/getcompletedtask?username='+username,
			  
			     
			        success: function (data) {
			            
					
			        var trHTML = '';
			                
			        $.each(data.array, function (i, item) {
					
					
				
				 trHTML = '';
			            trHTML += '<tr id='+ data.array[i]["id"]+ '><td>' + data.array[i]["title"]+ '</td><td>' + data.array[i]["message"] + '</td><td>'+ data.array[i]["date"] + '</td>'+
							'<td>'+ data.array[i]["priority"] + '</td>'+
						    '<td><p data-placement="top" data-toggle="tooltip" title="" data-original-title="Delete"><button onclick="deleteTask(this)" class="btn btn-danger btn-xs" data-title="Delete" data-toggle="modal" data-target="#delete"><span class="glyphicon glyphicon-trash"></span></button></p></td>'					
						+'</tr>';
						
						 $('#mytable').append(trHTML);
						 
			        });
			        
			       
			        
			        
					},
			        failure: function(msg)
     {
	 alert("failure while registering");
         // $("#sometextplace").text("Procedure did not load");
     }
			    });
			    
}
