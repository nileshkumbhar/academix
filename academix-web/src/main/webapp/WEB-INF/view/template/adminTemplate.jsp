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
    <link href="//maxcdn.bootstrapcdn.com/font-awesome/4.2.0/css/font-awesome.min.css" rel="stylesheet">

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
	
    <!-- jQuery -->
    <script type="text/javascript" src="resources/js/jquery-1.11.1.min.js"></script>
    <script type="text/javascript" src="resources/js/jquery-ui-1.10.4.min.js"></script>

    <!-- Bootstrap Core JavaScript -->
    <script type="text/javascript" src="resources/js/bootstrap.min.js"></script>

    <!-- Metis Menu Plugin JavaScript -->
    <script type="text/javascript" src="resources/js/metisMenu.min.js"></script>

    <!-- Morris Charts JavaScript -->
    <script type="text/javascript" src="resources/js/raphael-min.js"></script>
    <script type="text/javascript" src="resources/js/morris.min.js"></script>
    <!-- <script type="text/javascript" src="resources/js/morris-data.js"></script> -->

    <!-- Custom Theme JavaScript -->
    <script type="text/javascript" src="resources/js/sb-admin-2.js"></script>

</body>

</html>
