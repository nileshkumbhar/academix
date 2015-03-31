<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<div class="row">
	<div class="col-lg-12">
		<h1 class="page-header">Attendance</h1>
	</div>
	<!-- /.col-lg-12 -->
</div>
<!-- /.row -->
<div class="row">
	<div class="col-xs-12">
		<form:form id="attendanceForm" method="POST" action="verifyAttendance"
			modelAttribute="classes" novalidate="novalidate" class="dropdown">
			<div class="form-group">
				<div class="dropdown">
					<button class="btn btn-default dropdown-toggle" type="button"
						id="dropdownMenu1" data-toggle="dropdown" aria-expanded="true">
						Class <span class="caret"></span>
					</button>
					<ul class="dropdown-menu" role="menu"
						aria-labelledby="dropdownMenu1">
						<c:forEach items="${classes}" var="class">
							<li role="presentation"><a role="menuitem" tabindex="-1"
								href="#" onclick="loadAttendanceSheet('${class.id}')">${class.title}</a></li>
						</c:forEach>
					</ul>
				</div>
				<div id="attendanceSheet">
					<table id="example" class="table table-striped">
						<thead>
							<tr>
								<th width="10%">Roll No.</th>
								<th width="20%">Name</th>
								<th width="20%">Status</th>
								<th width="50%">Absent Reason</th>
							</tr>
						</thead>

						<tfoot>
							<tr>
								<th>Roll No.</th>
								<th>Name</th>
								<th>Status</th>
								<th>Absent Reason</th>
							</tr>
						</tfoot>
					</table>
				</div>
			</div>
		</form:form>
	</div>
</div>
<!-- jQuery -->
<script type="text/javascript" src="resources/js/jquery-1.11.1.min.js"></script>
<script type="text/javascript" src="resources/js/jquery-ui-1.10.4.min.js"></script>
<script type="text/javascript" src="resources/js/bootstrap-switch.min.js"></script>

<script type="text/javascript">
	$(document).ready(function(){
		$("#attendanceSheet").hide();
	});
	
	function loadAttendanceSheet(classId){
		$("#attendanceSheet").show();
		$('#example').dataTable( {
	   		"ajax": {
	   	    	"url": "loadAttendanceSheet?classId="+classId,
	   	    	"type": "GET",
	   	    	"dataSrc": ""
	   		},
	   	    "columns": [
   	    	            { "data": "student.studentInfo.rollNumber" },
   	    	            { "data": "student.name" },
   	    	            { "data": function ( present )  {
   	    	            			return  '<input type="checkbox" class="status" '+(present ? 'checked/>' : '/>');
   	    	         			} },
   	    	            { "data":  function ( absentReason )  {
   	            			return  '<input type="text" class="absentReason form-control input-large"/>';
   	         			} }
   	    	          
   	    	],
   	    	"fnDrawCallback": function( oSettings ) {
   	    		$(".status").bootstrapSwitch({
   	    			onColor : 'success',
   					offColor : 'warning',
   					onText : '<strong>PRESENT</strong>',
   					offText : '<strong>ABSENT</strong>',
   					animate : true,
   					state : true,
   					size : 'small',
   					onSwitchChange : function(event, state) {
   						$(this).val(state);
   					}
   	    		});
   	       }
		});
		
	};
</script>