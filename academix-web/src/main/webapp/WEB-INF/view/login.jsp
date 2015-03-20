<!-- /.row -->
<div class="row">
	<div class="col-lg-12 col-md-9">

		<div id="login-overlay" class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<h4 class="modal-title" id="myModalLabel">Login to Academix</h4>
				</div>
				<div class="modal-body">
					<div class="row">
						<div class="col-xs-6">
							<div class="well">
								<form id="loginForm" method="POST" action="<c:url value='j_spring_security_check' />"
									novalidate="novalidate">
									<div class="form-group">
										<label for="username" class="control-label">Username</label> <input
											type="text" class="form-control" id="username"
											name="username" value="" required=""
											title="Please enter you username"
											placeholder="example@gmail.com"> <span
											class="help-block"></span>
									</div>
									<div class="form-group">
										<label for="password" class="control-label">Password</label> <input
											type="password" class="form-control" id="password"
											name="password" value="" required=""
											title="Please enter your password"> <span
											class="help-block"></span>
									</div>
									<div id="loginErrorMsg" class="alert alert-error hide">Wrong
										username og password</div>
									<div class="checkbox">
										<label> <input type="checkbox" name="remember"
											id="remember"> Remember login
										</label>
										<p class="help-block">(if this is a private computer)</p>
									</div>
									<button type="submit" class="btn btn-success btn-block">Login</button>
									<a href="/forgot/" class="btn btn-default btn-block">Help
										to login</a>
								</form>
							</div>
						</div>
						<div class="col-xs-6">
							<p class="lead">
								Features Available -
							</p>
							<ul class="list-unstyled" style="line-height: 2">
								<li><span class="fa fa-check text-success"></span> Attendance </li>
								<li><span class="fa fa-check text-success"></span> Report Cards</li>
								<li><span class="fa fa-check text-success"></span> Examination </li>
								<li><span class="fa fa-check text-success"></span> Progress Reports</li>
								<li><span class="fa fa-check text-success"></span> Scheduler </li>
								<li><span class="fa fa-check text-success"></span> Meetings </li>
								<li><span class="fa fa-check text-success"></span> Notice Board </li>
								<li><a href="/read-more/"><u>Read more</u></a></li>
							</ul>
							<p>
								<a href="/new-customer/" class="btn btn-info btn-block">Yes
									please, register now!</a>
							</p>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
</div>