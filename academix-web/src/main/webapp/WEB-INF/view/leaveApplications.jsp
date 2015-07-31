<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<div class="row">
	<div class="col-lg-12">
		<h1 class="page-header">Leave Applications</h1>
	</div>
	<!-- /.col-lg-12 -->
</div>
<div class="row">
	<div class="col-xs-12">
		<button type="button" class="btn btn-success btn-lg" data-toggle="modal" data-target="#newLeaveAppModal">Create Leave Application</button>
	</div>
	<div class="col-lg-12"><BR/></div>
</div>
<div class="row">
	<div class="col-xs-12">
		<div class="table-responsive">
			<table id="leaveApplicationsTbl" class="table table-striped">
				<thead>
					<tr>
						<th width="20%">Student Name</th>
						<th width="10%">Application Date</th>
						<th width="10%">Leave From</th>
						<th width="10%">Leave To</th>
						<th width="10%">Reason</th>
						<th width="20%">Applied By</th>
						<th width="10%">Status</th>
						<th width="10%">Details</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${leaveApplications}" var="application">
						<tr>
							<td>${application.student.name}</td>
							<td><fmt:formatDate type="date" value="${application.applicationDate}" /></td>
							<td><fmt:formatDate type="date" value="${application.leaveFromDate}" /></td>
							<td><fmt:formatDate type="date" value="${application.leaveToDate}" /></td>
							<td>${application.reason}</td>
							<td>${application.applicant.name}</td>
							<td>${application.status.title}</td>
							<td><button type="button" class="btn btn-info" onclick="showLeaveDetails('${application.applicationContent}');" data-toggle="modal" data-target="#leaveModal">Details</button></td>
						</tr>
					</c:forEach>
				</tbody>
				<tfoot>
					<tr>
						<th width="20%">Student Name</th>
						<th width="10%">Application Date</th>
						<th width="10%">Leave From</th>
						<th width="10%">Leave To</th>
						<th width="10%">Reason</th>
						<th width="20%">Applied By</th>
						<th width="10%">Status</th>
						<th width="10%">Details</th>
					</tr>
				</tfoot>
			</table>
		</div>
	</div>
</div>

<!-- Modal -->
<div id="leaveModal" class="modal fade" role="dialog">
  <div class="modal-dialog modal-lg">

    <!-- Modal content-->
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal">&times;</button>
        <h4 class="modal-title">Leave Application</h4>
      </div>
      <div class="modal-body" id="leaveModalBody">
        
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
      </div>
    </div>

  </div>
</div>

<!-- Modal -->
<div id="newLeaveAppModal" class="modal fade" role="dialog">
  <div class="modal-dialog modal-lg">

    <!-- Modal content-->
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal">&times;</button>
        <h4 class="modal-title">Leave Application</h4>
      </div>
      <div class="modal-body">
        <textarea rows="10" cols="20" id="editor"></textarea>
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
      </div>
    </div>

  </div>
</div>
<!-- jQuery -->
<script type="text/javascript" src="resources/js/jquery-1.11.1.min.js"></script>
<script type="text/javascript" src="resources/js/jquery.hotkeys.js"></script>
<script type="text/javascript" src="resources/js/bootstrap-wysiwyg.js"></script>
<script type="text/javascript"
	src="resources/js/jquery-ui-1.10.4.min.js"></script>

<script type="text/javascript">
	$(document).ready(function() {
		$('#leaveApplicationsTbl').dataTable();
		$('#editor').wysiwyg();
	});
	
	function showLeaveDetails(applicationContent){
		$('#leaveModalBody').html(applicationContent);
	};
</script>