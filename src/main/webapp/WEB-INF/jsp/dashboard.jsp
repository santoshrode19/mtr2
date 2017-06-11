<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<div class="panel panel-primary">
	<div class="panel-heading">Dashboard </div>
</div>
<div class="row">
	<div class="col-lg-3 col-md-6" data-toggle="collapse"
		data-parent="#accordion">		<!-- data-target="#pendingTasksDiv" -->
		<div class="panel panel-green">
			<div class="panel-heading">
				<div class="row">
					<div class="col-xs-3">
						<i class="fa fa-folder-open fa-5x"></i>
					</div>
					<div class="col-xs-9 text-right">
						<div class="huge">0</div>
						<div>Pending Tasks</div>
					</div>
				</div>
			</div>
			<div class="panel-footer">
				<div class="clearfix"></div>
			</div>
		</div>
	</div>
	<div class="col-lg-3 col-md-6" data-toggle="collapse"
		data-parent="#accordion">			<!-- data-target="#openTasksDiv" -->
		<div class="panel panel-primary">
			<div class="panel-heading">
				<div class="row">
					<div class="col-xs-3">
						<i class="fa fa-flag-checkered fa-5x"></i>
					</div>
					<div class="col-xs-9 text-right">
						<div class="huge">${openRequestCount}</div>
						<div>Open Tasks</div>
					</div>
				</div>
			</div>
			<div class="panel-footer">
				<div class="clearfix"></div>
			</div>
		</div>
	</div>
	<div class="col-lg-3 col-md-6" data-toggle="collapse"
		data-parent="#accordion" >		<!-- data-target="#overdueTasksDiv" -->
		<div class="panel panel-red">
			<div class="panel-heading">
				<div class="row">
					<div class="col-xs-3">
						<i class="fa fa-warning fa-5x"></i>
					</div>
					<div class="col-xs-9 text-right">
						<div class="huge">0</div>
						<div>Tasks Overdue</div>
					</div>
				</div>
			</div>
			<div class="panel-footer">
				<div class="clearfix"></div>
			</div>
		</div>
	</div>
	<div class="col-lg-3 col-md-6">
		<div class="panel panel-yellow">
			<div class="panel-heading">
				<div class="row">
					<div class="col-xs-3">
						<i class="fa fa-file-text fa-5x"></i>
					</div>
					<div class="col-xs-9 text-right">
						<div class="huge">0</div>
						<div>Nearing Deadline</div>
					</div>
				</div>
			</div>
			<div class="panel-footer">
				<div class="clearfix"></div>
			</div>
		</div>
	</div>
</div>




<div class="panel-group" id="accordion">
	<div class="panel panel-default">
		<div class="panel-collapse collapse" id="pendingTasksDiv">
			<div class="panel-heading">Tasks Pending</div>
			<!-- /.panel-heading -->
			<div class="panel-body display-panel">
				<div class="dataTable_wrapper">
					<table id="pendingTasksTable"
						class="table table-bordered table-hover table-striped table-condensed table-responsive">
						<thead>
							<tr>
								<th>Project Id</th>
								<th>Task Name</th>
								<th>Create Time</th>
								<th>Target Finish Time</th>
								<th>Priority</th>
							</tr>
						</thead>
						<tbody>
							<c:forEach var="pendingTasksVar" items="${pendingTasksList}">
								<tr class="odd gradeX">
									<td>${pendingTasksVar.id.projectId}</td>
									<td>${pendingTasksVar.taskName}</td>
									<td>${pendingTasksVar.startDate}</td>
									<td>${pendingTasksVar.finishDate}</td>
									<td>${pendingTasksVar.priority}</td>
								</tr>
							</c:forEach>

						</tbody>
					</table>
				</div>
			</div>
			<!-- /.panel-body -->
		</div>
	</div>
	<!-- /.panel -->
	
	<div class="panel panel-default">
		<div class="panel-collapse collapse" id="openTasksDiv">
			<div class="panel-heading">Tasks Open</div>
			<!-- /.panel-heading -->
			<div class="panel-body display-panel">
				<div class="dataTable_wrapper">
					<table id="openTasksTable"
						class="table table-bordered table-hover table-striped table-condensed table-responsive">
						<thead>
							<tr>
								<th>Project Id</th>
								<th>Task Name</th>
								<th>Create Time</th>
								<th>Target Finish Time</th>
								<th>Priority</th>
							</tr>
						</thead>
						<tbody>
							<c:forEach var="openTasksVar" items="${openTasksList}">
								<tr class="odd gradeX">
									<td>${openTasksVar.id.projectId}</td>
									<td>${openTasksVar.taskName}</td>
									<td>${openTasksVar.startDate}</td>
									<td>${openTasksVar.finishDate}</td>
									<td>${openTasksVar.priority}</td>
								</tr>
							</c:forEach>

						</tbody>
					</table>
				</div>
			</div>
			<!-- /.panel-body -->
		</div>
	</div>
	<!-- /.panel -->
	
	<div class="panel panel-default">
		<div class="panel-collapse collapse in" id="overdueTasksDiv">
			<div class="panel-heading">Tasks Overdue</div>
			<!-- /.panel-heading -->
			<div class="panel-body display-panel">
				<div class="dataTable_wrapper">
					<table id="overdueTasksTable"
						class="table table-bordered table-hover table-striped table-condensed table-responsive">
						<thead>
							<tr>
								<th>Project Id</th>
								<th>Task Name</th>
								<th>Create Time</th>
								<th>Target Finish Time</th>
								<th>Priority</th>
							</tr>
						</thead>
						<tbody>
							<c:forEach var="overdueTasksVar" items="${overdueTasksList}">
								<tr class="odd gradeX">
									<td>${overdueTasksVar.id.projectId}</td>
									<td>${overdueTasksVar.taskName}</td>
									<td>${overdueTasksVar.startDate}</td>
									<td>${overdueTasksVar.finishDate}</td>
									<td>${overdueTasksVar.priority}</td>
								</tr>
							</c:forEach>

						</tbody>
					</table>
				</div>
			</div>
			<!-- /.panel-body -->
		</div>
	</div>
	<!-- /.panel -->
</div>
	
<script type="text/javascript">
    $(document).ready(function () {
    	$('#pendingTasksTable').dataTable();
        $('#openTasksTable').dataTable();
        $('#overdueTasksTable').dataTable();
    });
</script>
