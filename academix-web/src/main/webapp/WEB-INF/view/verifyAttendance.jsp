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
			modelAttribute="classes" novalidate="novalidate">
			<div class="form-group">
				<label for="username" class="control-label">Username</label>
				<form:select path="class" items="${classes}" itemLabel="title" itemValue="id" />
				<button type="submit" class="btn-primary"></button>
			</div>
		</form:form>
	</div>
</div>
