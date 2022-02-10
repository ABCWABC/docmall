<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="Mark Otto, Jacob Thornton, and Bootstrap contributors">
    <meta name="generator" content="Hugo 0.88.1">
	<title>엠와이몰 - Your Real Beauty</title>
	
	<!-- Custom fonts for this template-->
	<link href="/resources/vendor/fontawesome-free/css/all.min.css" rel="stylesheet" type="text/css">
	<link href="https://fonts.googleapis.com/css?family=Nunito:200,200i,300,300i,400,400i,600,600i,700,700i,800,800i,900,900i" rel="stylesheet">
	
	<!-- Custom styles for this template-->
	<link href="/resources/css/sb-admin-2.min.css" rel="stylesheet">

</head>

<body id="page-top">

	<!-- Page Wrapper -->
	<div id="wrapper">
	
		<!-- Sidebar -->
		<%@include file="/WEB-INF/views/include/side.jsp"%>
		
		<!-- Content Wrapper -->
        <div id="content-wrapper" class="d-flex flex-column">

            <!-- Main Content -->
            <div id="content">
		
				<%@include file="/WEB-INF/views/include/header.jsp"%>
			
				<!-- Begin Page Content -->
				<div class="container-fluid">
		
					<!-- BEST Page-->
					<div>
						<h6 style="color: black; font-weight: bold; text-align: center; margin-top: 150px">TODAY BEST</h6><!-- 수정 스타일시트로 빼기 -->
					</div>
					<div class="row" style="margin-bottom: 150px;"><!-- 수정 스타일시트로 빼기 -->
						<!-- Earnings (Monthly) Card Example -->
						<div class="todaySlider">
							<div class="item-wrap swiper-container">
								<div class="item-cont swiper-wrapper">
									<dl class="item-list swiper-slide">
										<dt class="thumb">
											<a href="best1 주소"><img class="MS_prod_img_l" src="/resources/imgExam/Best1.jpg" /></a>
											<a href="best2 주소"><img class="MS_prod_img_l" src="/resources/imgExam/Best2.jpg" /></a>
											<a href="best3 주소"><img class="MS_prod_img_l" src="/resources/imgExam/Best3.jpg" /></a>
										</dt>
									</dl>
								</div>
							</div>
						</div>
					</div>
						
					<!-- Page Heading -->
					<div>
						<h6 style="color: black; font-weight: bold; text-align: center; margin-top: 150px">NEW</h6><!-- 수정 스타일시트로 빼기 -->
					</div>
					<div class="row" style="margin-bottom: 150px;"><!-- 수정 스타일시트로 빼기 -->
						<!-- Earnings (Monthly) Card Example -->
						<div class="todaySlider">
							<div class="item-wrap swiper-container">
								<div class="item-cont swiper-wrapper">
									<dl class="item-list swiper-slide">
										<dt class="thumb">
											<a href="best1 주소"><img class="MS_prod_img_l" src="/resources/imgExam/NEW1.jpg" /></a>
											<a href="best2 주소"><img class="MS_prod_img_l" src="/resources/imgExam/NEW2.jpg" /></a>
											<a href="best2 주소"><img class="MS_prod_img_l" src="/resources/imgExam/NEW3.jpg" /></a>
										</dt>
									</dl>
								</div>
							</div>
						</div>
					</div>
				</div>
		
				<div class="row">
					<div class="col-lg-6">
						<!-- Default Card Example -->
						<div class="card mb-4">
							<div class="card-header">하단카드제목1</div>
							<div class="card-body">하단카드내용1</div>
						</div>
		
						<!-- Basic Card Example -->
						<div class="card shadow mb-4">
							<div class="card-header py-3">
								<h6 class="m-0 font-weight-bold text-primary">하단카드제목2</h6>
							</div>
							<div class="card-body">하단카드내용2</div>
						</div>
					</div>
		
					<div class="col-lg-6">
						<!-- Dropdown Card Example -->
						<div class="card shadow mb-4">
							<!-- Card Header - Dropdown -->
							<div class="card-header py-3 d-flex flex-row align-items-center justify-content-between">
								<h6 class="m-0 font-weight-bold text-primary">하단카드제목3</h6>
								<div class="dropdown no-arrow">
									<a class="dropdown-toggle" href="#" role="button" id="dropdownMenuLink" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
										<i class="fas fa-ellipsis-v fa-sm fa-fw text-gray-400"></i>
									</a>
									<div class="dropdown-menu dropdown-menu-right shadow animated--fade-in" aria-labelledby="dropdownMenuLink">
										<a class="dropdown-item" href="#">선택1</a>
										<a class="dropdown-item" href="#">선택2</a>
										<div class="dropdown-divider"></div>
										<a class="dropdown-item" href="#">또다른선택3</a>
									</div>
								</div>
							</div>
							<!-- Card Body -->
							<div class="card-body">하단카드내용3</div>
						</div>
		
						<!-- Collapsable Card Example -->
						<div class="card shadow mb-4">
							<!-- Card Header - Accordion -->
							<a href="#collapseCardExample" class="d-block card-header py-3" data-toggle="collapse" role="button" aria-expanded="true" aria-controls="collapseCardExample">
								<h6 class="m-0 font-weight-bold text-primary">하단카드제목4</h6>
							</a>
							<!-- Card Content - Collapse -->
							<div class="collapse show" id="collapseCardExample">
								<div class="card-body">하단카드내용4</div>
							</div>
						</div>
					</div>
				</div>
			</div>
			
			<!-- footer -->
			<%@include file="/WEB-INF/views/include/footer.jsp"%>
		</div>
	</div>
	
	<!-- logoutModal -->
	<%@include file="/WEB-INF/views/include/logoutModal.jsp"%>

	<!-- Bootstrap core JavaScript-->
	<script src="/resources/vendor/jquery/jquery.min.js"></script>
	<script src="/resources/vendor/bootstrap/js/bootstrap.bundle.min.js"></script>

	<!-- Core plugin JavaScript-->
	<script src="/resources/vendor/jquery-easing/jquery.easing.min.js"></script>

	<!-- Custom scripts for all pages-->
	<script src="/resources/js/sb-admin-2.min.js"></script>

</body>


</html>