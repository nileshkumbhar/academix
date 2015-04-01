<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>

<!DOCTYPE html>
<html>

<head>

    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">

	<!-- Header -->
    <title><tiles:insertAttribute name="title" /></title>

    <!-- Bootstrap Core CSS -->
    <link href='resources/css/bootstrap.min.css' rel="stylesheet" media="screen">
    <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/css/bootstrap.min.css">
    <link href="http://maxcdn.bootstrapcdn.com/font-awesome/4.3.0/css/font-awesome.min.css" rel="stylesheet">
    
    <!-- MetisMenu CSS -->
    <link href='resources/css/metisMenu.min.css' rel="stylesheet" media="screen">

    <!-- Timeline CSS -->
    <link href='resources/css/timeline.css' rel="stylesheet" media="screen">

    <!-- Custom CSS -->
    <link href='resources/css/sb-admin-2.css' rel="stylesheet" media="screen">

    <!-- Morris Charts CSS -->
    <link href='resources/css/morris.css' rel="stylesheet" media="screen">
    
    <!-- Custom Fonts -->
    <link href='resources/css/font-awesome.min.css' rel="stylesheet" media="screen">
    
    <link href='resources/css/footer.css' rel="stylesheet" media="screen">
    
    <link rel="stylesheet" href="https://cdn.datatables.net/plug-ins/f2c75b7247b/integration/bootstrap/3/dataTables.bootstrap.css">
    
	<!-- Bootstrap switch -->    
	<link href="resources/css/bootstrap-switch.css" rel="stylesheet">
	
	<!-- Bootstrap Datepicker -->
	<link href="resources/css/bootstrap-datepicker3.min.css" rel="stylesheet">

    <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
        <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
        <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->

</head>

<body>
	

    <div id="wrapper">

       	<!-- Navigation -->
		<nav class="navbar navbar-default navbar-static-top" role="navigation"
			style="margin-bottom: 0; background-color: #000000; background-repeat: repeat;">
			
			<!-- Header -->
			<tiles:insertAttribute name="header" />
		
			<!-- Menu -->
			<tiles:insertAttribute name="menu" />
		</nav>
		

        <div id="page-wrapper">
        	<tiles:insertAttribute name="body" />
		</div>
        <!-- /#page-wrapper -->
        
        <tiles:insertAttribute name="footer" />
    </div>
    
    <!-- /#wrapper -->
	

</body>

</html>

<tiles:insertAttribute name="js" ignore="true"/>