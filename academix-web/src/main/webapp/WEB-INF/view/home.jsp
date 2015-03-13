<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="utf-8">
	    <meta name="viewport" content="width=device-width, initial-scale=1.0">
	    <meta name="description" content="">
	    <meta name="author" content="">
	
	    <title>Welcome</title>
		<!-- Bootstrap and jquery-ui-->
		<link rel="stylesheet" href="//code.jquery.com/ui/1.11.2/themes/smoothness/jquery-ui.css">
		 <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/css/bootstrap.min.css">
		<link href='resources/css/bootstrap.min.css' rel="stylesheet" media="screen">
		<link href='resources/css/slider.css' rel="stylesheet" media="screen">
		<link href='resources/css/bootstrap-switch.css' rel="stylesheet" media="screen">
		

		<style type="text/css">
			.redButton{
				width: 100%; 
				height: 60px;
				cursor: pointer;
			}
			
			.hide-block{
			   display: none;
			}
			
			.modal-dialog-center { /* Edited classname 10/03/2014 */
			    margin: 0;
			    position: absolute;
			    top: 50%;
			    left: 50%;
			}
			
			.div-status-info {
				height: 60px; 
				margin: 0px;
				padding:7px; 
				text-align: center; 
				vertical-align: middle;			
			}
			
			.navbar-blue {
				background-image: url("resources/images/header_bg.png");
				background-repeat: repeat;
			}
			
			body {
			    margin-top: 125px; /* adjust this if the height of the menu bar changes */
			}
			
			.navbar-fixed-top .nav {
			    padding: 15px 0;
			}
			
			.navbar-fixed-top .navbar-brand {
				padding: 0 15px;
			}
			
			.div-title {
				vertical-align: middle;
				font-weight: bold;
				font-size: x-large;
				color: white;
				height: 60px;
			}
			
			body .modal {
				width: 90%; /* desired relative width */
			  	left: 5%; /* (100%-width)/2 */
			  	/* place center */
			  	margin-left:auto;
			  	margin-right:auto; 
			}
			
			@media(min-width:768px) {
			    .navbar-fixed-top .nav {
			        padding: 15px 0;
			    }
			
			    .navbar-fixed-top .navbar-brand {
			        padding: 15px 0;
			    }
			}
			
			/* style icon */
			.inner-addon .glyphicon {
		    	position: absolute;
		  		padding: 10px;
		  		pointer-events: none;
			}
			
			/* align icon */
			.left-addon .glyphicon  { left:  0px;}
			.right-addon .glyphicon { right: 20px;}
			
			/* add padding  */
			.left-addon input  { padding-left:  20px; }
			.right-addon input { padding-right: 20px; }
			
			input[type="checkbox"], 
			input[type="radio"],
			input.radio,
			input.checkbox {
			vertical-align:text-top;
			width:15px;
			height:15px;
			padding:0;
			margin:0;
			position:relative;
			overflow:hidden;
			top:2px;
			}
			
			label.description 
			{ border:none;
			color:#222;
			display:block;
			font-size:95%;
			font-weight:700; 
			line-height:150%; 
			padding:0 0 1px; 
			width: 30%; 
			float: left; 
			}
		</style> 

</head>
<body>
	<nav class="navbar navbar-inverse navbar-fixed-top navbar-blue" role="navigation">
        <div class="container">
            <!-- Brand and toggle get grouped for better mobile display -->
            <div class="navbar-header">
            	 <div class="container">
        			<div class="row">
           	 			<div class="col-md-6">
                			<a href="#">
                    			<img src='resources/images/academix_logo.png' alt="AcademiX" style="height: 100%;">
                			</a>
                		</div>
                		<div class="col-md-6 div-title" style="margin-top: 20px;">
                			<img src='resources/images/logo_text.png' alt="AcademiX" style="height: 100%; width: 20%">
                		</div>
                	</div>
                </div>
            </div>
        </div>
    </nav>
    <div class="container">
		<div class="row">
			<div class="col-md-3">
				A
			</div>
			<div class="col-md-3">
				B
			</div>
			<div class="col-md-3">
				C
			</div>
			<div class="col-md-3">
				D
			</div>
		</div>		
	</div>
	
	<script type="text/javascript" src="resources/js/jquery-1.11.1.min.js"></script>
	<script type="text/javascript" src="resources/js/jquery-ui-1.10.4.min.js"></script>
	<script type="text/javascript" src="resources/js/bootstrap.min.js"></script>
	<script type="text/javascript" src="resources/js/bootstrap-slider.js"></script>
	<script type="text/javascript" src="resources/js/bootstrap-switch.min.js"></script>
	
	<script>
		$(document).ready(function(){
			$("#successResponsePanel").hide();
			$("#errorResponsePanel").hide();
						
			$("#salaryPercentageDiv").hide();
			$("#currentSalaryDiv").hide();
			
			$(".form-control").val('');
			
			$("#currentAge").val(25);
			$("#payoutAge").val(60);
			$("#payoutPeriod").val(20);
			$("#riskProfileDiv").hide();
			
			$(".switch").bootstrapSwitch({
				onColor : 'success',
				offColor : 'warning',
				onText : 'YES',
				offText : 'NO',
				animate : true,
				inverse : true,
				state : false,
				onSwitchChange : function(event, state) {
					$(this).val(state);
				},
				onInit : function(event, state) {
					$(this).val(false);
				}
			});
			
			$("#salaryComponent").bootstrapSwitch({
				onColor : 'success',
				offColor : 'warning',
				onText : 'Salary Percent',
				offText : 'Amount',
				animate : true,
				inverse : true,				
				onSwitchChange : function(event, state) {
					if(state){
						$("#salaryPercentageDiv").show();
						$("#currentSalaryDiv").show();
						$("#selectedAmountDiv").hide();
						$("#selectedAmount").val('');
					} else {
						$("#salaryPercentageDiv").hide();
						$("#currentSalaryDiv").hide();
						$("#selectedAmountDiv").show();	
						$("#currentSalary").val('');
						$("#salaryPercentage").val('');
					}
				}
			});
			
			var currentAgeSlider = $("#currentAgeSlider").slider().on('slideStop', function(event){
				$("#currentAge").val(event.value);
			});
			
			$("#currentAge").on('change', function(){
				currentAgeSlider.slider('setValue', $(this).val());
			});
			
			var payoutAgeSlider = $("#payoutAgeSlider").slider().on('slideStop', function(event){
				$("#payoutAge").val(event.value);
			});
			
			$("#payoutAge").on('change', function(){
				payoutAgeSlider.slider('setValue', $(this).val());
			});
			
			var payoutPeriodSlider = $("#payoutPeriodSlider").slider().on('slideStop', function(event){
				$("#payoutPeriod").val(event.value);
			});
			
			$("#payoutPeriod").on('change', function(){
				payoutPeriodSlider.slider('setValue', $(this).val());
			});
			
			$("#reset").click(function(){
				$(".form-control").val('');
				
				$("#currentAge").val(25);
				currentAgeSlider.slider('setValue', 25);
				$("#payoutAge").val(60);
				payoutAgeSlider.slider('setValue', 60);
				$("#payoutPeriod").val(20);
				payoutPeriodSlider.slider('setValue', 20);
				$("#successResponsePanel").hide();
				$("#riskProfileDiv").hide();
				$("#investmentType").val("");
				$(".switch").bootstrapSwitch('state',false, false);
				$('#menu1').html("Select Product " + '<span class="caret"</span>');
				$('#menu2').html("Select Investment Type " + '<span class="caret"</span>');
			});
			
			$("#pcForm").submit(function(event){
				
			    $.ajax({
		           type: "POST",
		           url: '<c:url value="/cost/calculate"/>',
		           data: createFormData(), // serializes the form's elements.
		           dataType: 'json',
		           contentType: "application/json; charset=utf-8",
				  
		           success: function(data)
		           {
				  
		               if(data.message == 'SUCCESS'){
							
		            	   	$("#errorResponsePanel").hide();
		            	   	$("#successResponsePanel").show();
			       			
			       			$("#grossReturnAmountForFirstYear").html(data.result.grossReturnAmountForFirstYear);
			       			$("#grossReturnPercentageForFirstYear").html(data.result.grossReturnPercentageForFirstYear);
			       			$("#costAmountForFirstYear").html(data.result.costAmountForFirstYear);
			       			$("#costPercentageForFirstYear").html(data.result.costPercentageForFirstYear);
			       			$("#currentAssets").html(data.result.currentAsset);
			       			$("#yearlyPayIn").html(data.result.yearlyPayIn);
			       			$("#grossReturn").html(data.result.grossReturn);
			       			$("#directCost").html(data.result.directCost);
			       			$("#indirectCost").html(data.result.indirectCost);
			       			$("#assetAfterFirstYear").html(data.result.assetAfterFirstYear);
								
								if($('#costTable tr').size()>2){
									for(var j =0;j < data.result.costs.length;j++)
									{
										 $('#costTable tr').remove();
									}
								}
								$row1 = $('<tr rowspan="4"/>');
								
								$col11 = $('<th colspan="6"/>');
								$col12 = $('<th colspan="6"/>');
								$col13 = $('<th colspan="6"/>');
															
								$col11.html("&nbsp;&nbsp;&nbsp;&nbsp;AGE");
								$col12.html("&nbsp;&nbsp;AAOK");
								$col13.html("AAOP");
									
								$row1.append($col11);
								$row1.append($col12);
								$row1.append($col13)
								
								$("#costTable").append($row1);
								
							for(var i =0;i < data.result.costs.length;i++)
							{
								var item =  data.result.costs[i];
								
								$row = $('<tr rowspan="4" id="dynamicRow"'+'"i"'+'/>');
								
								$col = $('<td colspan="6"/>');
								$col1 = $('<td colspan="6"/>');
								$col2 = $('<td colspan="6"/>');
								
								$col.html("&nbsp;&nbsp;&nbsp;&nbsp;"+item.age);
								$col1.html(item.aop);
								$col2.html(item.aok);
								
								$row.append($col);
								$row.append($col1);
								$row.append($col2);
								$("#costTable").append($row);
								
							}
			       			
			       			//$("#collapseSuccess").slideDown();
			       			if($("#icon").hasClass("glyphicon-chevron-right")){
			       				$("#collapseSuccess").slideDown();
			       				
								$("#icon").removeClass("glyphicon-chevron-right");
								$("#icon").addClass("glyphicon-chevron-down");
							}
			       			
			       			$('html, body').animate({
			                    scrollTop: $("#successResponsePanel").offset().top
			              	}, 1000);  
		               } else {
						   	$("#successResponsePanel").hide();	
		            	   	$("#errorResponsePanel").show();
							var messages = data.message.split('.');
						
							if($('#errorTable tr').size()>0){
									for(var j =0;j < messages.length;j++)
									{
										 $('#errorTable tr').remove();
									}
								}
							for(var k =0;k < messages.length;k++){
								$row22 = $('<tr/>');
								$col22 = $('<td/>');
								$col22.html(messages[k]);
								$row22.append($col22);
								$("#errorTable").append($row22);
							}
							            	   	
		               }
		           },
		           error: function(jqXHR, textStatus, errorMessage) {
		        	   	$("#successResponsePanel").hide();	
	            	   	$("#errorResponsePanel").show();
						$row22 = $('<tr/>');
						$col22 = $('<td/>');
						$col22.html(errorMessage);
						$row22.append($col22);
						$("#errorTable").append($row22);
	            	   
	                }
		         });
				return false;
			});
			
			$("#resultTitle").click(function(){
				$("#collapseSuccess").slideToggle();
				
				if($("#icon").hasClass("glyphicon-chevron-right")){
					$("#icon").removeClass("glyphicon-chevron-right");
					$("#icon").addClass("glyphicon-chevron-down");
					$('html, body').animate({
	                    scrollTop: $("#successResponsePanel").offset().top
	              	}, 1000); 
				} else {
					$("#icon").removeClass("glyphicon-chevron-down");
					$("#icon").addClass("glyphicon-chevron-right");
				}
			});
			
			$(".close").click(function(){
				$(this).parent().hide();
			})
		});
	
	function retDivision(value){
		if(value!=""){
			return parseInt(value)/100;
		}else {
			return value;
		}
	}
		
	function createFormData(){
						
			return '{ '+
						'"product":"'+$("#product").val()+'", '+
						'"currentAsset":"'+$("#currentAsset").val()+'", '+
						'"payIn":"'+$("#payIn").val()+'", '+
						'"currentAge": "'+$("#currentAge").val()+'", '+
						'"payoutAge":"'+$("#payoutAge").val()+'", '+
						'"payoutPeriod":"'+$("#payoutPeriod").val()+'", '+
						'"investment":{ '+
						'"investmentType":"'+$("#investmentType").val()+'", '+
						'"assetAllocation":{ '+
							'"shortTermBonds":"'+retDivision($("#korteObligationer").val())+'", '+
							'"longTermBonds":"'+retDivision($("#langeObligationer").val())+'", '+
							'"indexBonds":"'+retDivision($("#indexObligationer").val())+'", '+
							'"foreignBonds":"'+retDivision($("#udenlandskeObligationer").val())+'", '+
							'"highYieldBonds":"'+retDivision($("#hojrentOobligationer").val())+'", '+
							'"danishStocks":"'+retDivision($("#danskeAktier").val())+'", '+
							'"foreignStocks":"'+retDivision($("#udenlandskeAktier").val())+'", '+
							'"unnotedStocks":"'+retDivision($("#unoteredeAktier").val())+'", '+
							'"depositPensionPools":"'+retDivision($("#indlanPulje").val())+'"'+
						'}'+
						'}'+
					'}';
		}
			
		
		function showHideRiskProfile(){
			if(document.getElementById("investmentType").value=="CUSTOM"){
				$("#riskProfileDiv").show();
			}else {
				$("#riskProfileDiv").hide();
			}
		}
		
		$(".dropdown-menu li a").click(function(){
		
		  var selText = $(this).text();
		  
		    if(selText=="Kapitalpension"){
			 $("#product").val("KAPITALPENSION");
			}else if(selText=="Selvpension"){
			 $("#product").val("SELVPENSION");
			}else if(selText=="Borneopsparing"){
			 $("#product").val("BORNEOPSPARING");
			}else if(selText=="Ratepension"){
			 $("#product").val("RATEPENSION");
			}else if(selText=="Aldersopsparing"){
			 $("#product").val("ALDERSOPSPARING");
			}else if(selText=="High Risk"){
			 $("#investmentType").val("HIGH_RISK");
			 showHideRiskProfile();
			}else if(selText=="Medium Risk"){
			 $("#investmentType").val("MEDIUM_RISK");
			 showHideRiskProfile();
			}else if(selText=="Low Risk"){
			 $("#investmentType").val("LOW_RISK");
			 showHideRiskProfile();
			}else if(selText=="Individual Selection"){
			 $("#investmentType").val("CUSTOM");
			 showHideRiskProfile();
			}
						
		  $(this).parents('.form-group').find('button[data-toggle="dropdown"]').html(selText+' <span class="caret"></span>');
		});
	</script>
	
