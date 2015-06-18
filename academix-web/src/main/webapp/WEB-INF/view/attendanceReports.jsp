<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<div class="row">
	<div class="col-lg-12">
		<h1 class="page-header">Attendance Reports</h1>
	</div>
	<!-- /.col-lg-12 -->
</div>
<!-- /.row -->
<div class="row">
	<div class="col-xs-12">
		<form:form method="post" modelAttribute="attendanceInput" action="downloadReport">
			<div class="form-inline">
				<div class="form-group">
					<div class="dropdown">
						<button class="btn btn-default dropdown-toggle" type="button"
							id="classDropdown" data-toggle="dropdown" aria-expanded="true">
							Class <span class="caret"></span>
						</button>
						<ul class="dropdown-menu" role="menu"
							aria-labelledby="dropdownMenu1">
							<c:forEach items="${classes}" var="class">
								<li role="presentation"><a role="menuitem" tabindex="-1"
									href="#" onclick="changeClass('${class.id}', '${class.title}')">${class.title}</a></li>
							</c:forEach>
						</ul>
					</div>
				</div>
				<div class="form-group">
					<div class="input-group">
						<form:hidden path="className" id="className"/>
						<form:input path="monthYear" type="text" id="date" class="form-control" placeholder="Date"/>
						<span class="input-group-addon" id="basic-addon2"><span class="glyphicon glyphicon-calendar"></span></span>
					</div>
				</div>
				<div class="form-group">
					<button type="submit" class="btn btn-primary">Load Report</button>
				</div>
			</div>
		</form:form>
	</div>
</div>
<!-- jQuery -->
<script type="text/javascript" src="resources/js/jquery-1.11.1.min.js"></script>
<script type="text/javascript"
	src="resources/js/jquery-ui-1.10.4.min.js"></script>
<script type="text/javascript"
	src="resources/js/bootstrap-switch.min.js"></script>
<script type="text/javascript"
	src="resources/js/bootstrap-datepicker.min.js"></script>

<script type="text/javascript">
	var classId = '';
	$(document).ready(function() {
		$("#date").datepicker({
			format: "mm-yyyy",
            viewMode: "months", 
            minViewMode: "months"
		});
	});

	function changeClass(classIdVar, classTitle){
		classId = classIdVar;
		$("#classDropdown").html(classTitle);
		$("#className").val(classTitle);
	}
	
</script>