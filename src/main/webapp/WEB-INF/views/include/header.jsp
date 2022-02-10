<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

	
	<!-- Topbar -->
	<nav class="navbar navbar-expand navbar-light bg-white topbar mb-4 static-top shadow">
	
	<!-- 2022-02-10 추가 / 시작 -->

	<c:if test="${sessionScope.loginStatus == null }">
		
		<a class="p-2 text-dark" href="member/login">로그인</a>
		<a class="p-2 text-dark" href="member/join">회원가입</a>
	
	</c:if>
	
	<c:if test="${sessionScope.loginStatus != null }">
	
		<a class="p-2 text-dark" href="member/logout">로그아웃</a>
		<a class="p-2 text-dark" href="member/modify">정보수정</a>
	
	</c:if>

	<!-- 2022-02-10 추가 / 끝 -->


		<!-- Sidebar Toggle (Topbar) -->
		<button id="sidebarToggleTop" class="btn btn-link d-md-none rounded-circle mr-3">
			<i class="fa fa-bars"></i>
		</button>

		<!-- Topbar Search -->
		<form class="d-none d-sm-inline-block form-inline mr-auto ml-md-3 my-2 my-md-0 mw-100 navbar-search">
			<div class="input-group">
				<input type="text" class="form-control bg-light border-0 small" placeholder="상품검색..." aria-label="Search" aria-describedby="basic-addon2">
				<div class="input-group-append">
					<button class="btn btn-primary" type="button"><i class="fas fa-search fa-sm"></i></button>
				</div>
			</div>
		</form>

		<!-- Topbar Navbar -->
		<ul class="navbar-nav ml-auto">

			<!-- Nav Item - Search Dropdown (Visible Only XS) -->
			<li class="nav-item dropdown no-arrow d-sm-none">
				<a class="nav-link dropdown-toggle" href="#" id="searchDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
					<i class="fas fa-search fa-fw"></i>
				</a>
				<!-- Dropdown - Messages -->
				<div class="dropdown-menu dropdown-menu-right p-3 shadow animated--grow-in" aria-labelledby="searchDropdown">
					<form class="form-inline mr-auto w-100 navbar-search">
						<div class="input-group">
							<input type="text" class="form-control bg-light border-0 small" placeholder="Search for..." aria-label="Search" aria-describedby="basic-addon2">
							<div class="input-group-append">
								<button class="btn btn-primary" type="button"><i class="fas fa-search fa-sm"></i></button>
							</div>
						</div>
					</form>
				</div>
			</li>

			<!-- Nav Item - Alerts --> <!-- 종알람부분 -->
			<li class="nav-item dropdown no-arrow mx-1">
				<a class="nav-link dropdown-toggle" href="#" id="alertsDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
					<i class="fas fa-bell fa-fw"></i>
					<!-- Counter - Alerts -->
					<span class="badge badge-danger badge-counter">3+</span>
				</a> 
				<!-- Dropdown - Alerts --> <!-- 어느부분? -->
				<div class="dropdown-list dropdown-menu dropdown-menu-right shadow animated--grow-in" aria-labelledby="alertsDropdown">
					<h6 class="dropdown-header">알람제목</h6>
					<a class="dropdown-item d-flex align-items-center" href="#">
						<div class="mr-3">
							<div class="icon-circle bg-primary"><i class="fas fa-file-alt text-white"></i></div>
						</div>
						<div>
							<div class="small text-gray-500">알람1</div>
							<span class="font-weight-bold">알람내용1</span>
						</div>
					</a>
					<a class="dropdown-item d-flex align-items-center" href="#">
						<div class="mr-3">
							<div class="icon-circle bg-success"><i class="fas fa-donate text-white"></i></div>
						</div>
						<div>
							<div class="small text-gray-500">알람2</div>
							<span class="font-weight-bold">알람내용2</span>
						</div>
					</a>
					<a class="dropdown-item d-flex align-items-center" href="#">
						<div class="mr-3">
							<div class="icon-circle bg-warning">
								<i class="fas fa-exclamation-triangle text-white"></i>
							</div>
						</div>
						<div>
							<div class="small text-gray-500">알람3</div>
							<span class="font-weight-bold">알람내용3</span>
						</div>
					</a>
					<a class="dropdown-item text-center small text-gray-500" href="#">다른내용까지 전부 확인</a>
				</div>
			</li>

			<!-- Nav Item - Messages --> <!-- 메세지박스 부분 -->
			<li class="nav-item dropdown no-arrow mx-1">
				<a class="nav-link dropdown-toggle" href="#" id="messagesDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
				<i class="fas fa-envelope fa-fw"></i>
				<!-- Counter - Messages --> <span class="badge badge-danger badge-counter">7</span>
				</a>
				<!-- Dropdown - Messages -->
				<div class="dropdown-list dropdown-menu dropdown-menu-right shadow animated--grow-in" aria-labelledby="messagesDropdown">
					<h6 class="dropdown-header">메세지 제목</h6>
					<a class="dropdown-item d-flex align-items-center" href="#">
						<div class="dropdown-list-image mr-3">
							<img class="rounded-circle" src="img/undraw_profile_1.svg" alt="...">
							<div class="status-indicator bg-success"></div>
						</div>
						<div class="font-weight-bold">
							<div class="text-truncate">메세지1</div>
							<div class="small text-gray-500">메세지내용1</div>
						</div>
					</a>
					<a class="dropdown-item d-flex align-items-center" href="#">
						<div class="dropdown-list-image mr-3">
							<img class="rounded-circle" src="img/undraw_profile_2.svg" alt="...">
							<div class="status-indicator"></div>
						</div>
						<div>
							<div class="text-truncate">메세지2</div>
							<div class="small text-gray-500">메세지내용2</div>
						</div>
					</a>
					<a class="dropdown-item d-flex align-items-center" href="#">
						<div class="dropdown-list-image mr-3">
							<img class="rounded-circle" src="img/undraw_profile_3.svg" alt="...">
							<div class="status-indicator bg-warning"></div>
						</div>
						<div>
							<div class="text-truncate">메세지3</div>
							<div class="small text-gray-500">메세지내용3</div>
						</div>
					</a>
					<a class="dropdown-item d-flex align-items-center" href="#">
						<div class="dropdown-list-image mr-3">
							<img class="rounded-circle" src="https://source.unsplash.com/Mv9hjnEUHR4/60x60" alt="...">
							<div class="status-indicator bg-success"></div>
						</div>
						<div>
							<div class="text-truncate">메세지4</div>
							<div class="small text-gray-500">메세지내용4</div>
						</div>
					</a>
					<a class="dropdown-item text-center small text-gray-500" href="#">다른메세지전부확인</a>
				</div>
			</li>

			<div class="topbar-divider d-none d-sm-block"></div>

			<!-- Nav Item - User Information -->
			<li class="nav-item dropdown no-arrow">
				<a class="nav-link dropdown-toggle" href="#" id="userDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
					<span class="mr-2 d-none d-lg-inline text-gray-600 small">비회원/로그인시 사람이름</span>
						<img class="img-profile rounded-circle" src="/resources/img/undraw_profile.svg">
				</a>
				<!-- Dropdown - User Information -->
				<div class="dropdown-menu dropdown-menu-right shadow animated--grow-in" aria-labelledby="userDropdown">
					<a class="dropdown-item" href="#">
						<i class="fas fa-user fa-sm fa-fw mr-2 text-gray-400"></i> Profile
					</a>
					<a class="dropdown-item" href="#">
						<i class="fas fa-cogs fa-sm fa-fw mr-2 text-gray-400"></i> Settings
					</a>
					<a class="dropdown-item" href="#">
						<i class="fas fa-list fa-sm fa-fw mr-2 text-gray-400"></i> Activity Log
					</a>
					<div class="dropdown-divider"></div>
					<a class="dropdown-item" href="/member/login" data-toggle="modal" data-target="#logoutModal">
						<i class="fas fa-sign-out-alt fa-sm fa-fw mr-2 text-gray-400"></i> Logout
					</a>
				</div>
			</li>
		</ul>
	</nav>
	<!-- End of Topbar -->
	