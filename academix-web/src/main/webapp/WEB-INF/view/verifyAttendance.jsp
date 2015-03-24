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
	<div class="col-xs-3">
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
				
				</div>
			</div>
		</form:form>
	</div>
</div>

<script type="text/javascript">
	$(document).ready(function(){
		$("#attendanceSheet").hide();
	});
	
	function loadAttendanceSheet(classId){
		alert(classId);
		$.ajax({
			url : "loadAttendanceSheet",
			data : {
				classId : classId
			},
			method : "post",
			success : function(data) {
				$("#attendanceSheet").show();
				$("#attendanceSheet")
						.html("<strong>" + data + "</strong>");
			}
		});
	};
</script>