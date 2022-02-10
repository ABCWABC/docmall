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
	
	<%@ include file="/WEB-INF/views/include/plugin_js.jsp" %>
	


</head>

<body class="bg-gradient-primary">

  <div class="container">

    <!-- Outer Row -->
    <div class="row justify-content-center">
      <div class="col-xl-10 col-lg-12 col-md-9">
        <div class="card o-hidden border-0 shadow-lg my-5">
          <div class="card-body p-0">
            <!-- Nested Row within Card Body -->
            <div class="row">
              <div class="col-lg-12">
                <div class="p-5">
                  <div class="text-center">
                    <h1 class="h4 text-gray-900 mb-4">Welcome Back!</h1>
                  </div>
                  <form class="user">
                    <div class="form-group">
                      <input type="text" class="form-control form-control-user" id="mbsp_id" name="mbsp_id" placeholder="아이디 입력">
                    </div>
                    <div class="form-group">
                      <input type="password" class="form-control form-control-user" id="mbsp_password" name="mbsp_password" placeholder="비밀번호 입력">
                    </div>
                    <div class="form-group">
                      <div class="custom-control custom-checkbox small">
                        <input type="checkbox" class="custom-control-input" id="customCheck">
                        <label class="custom-control-label" for="customCheck">아이디/비밀번호 기억하기</label>
                      </div>
                    </div>
                    <button type="button" id="btnLogin" class="btn btn-primary btn-user btn-block">Login</button>
                    <hr>
                    <a href="main" class="btn btn-google btn-user btn-block">
                      <i class="fab fa-google fa-fw"></i> 구글아이디로 로그인
                    </a>
	                <a href="main" class="btn btn-facebook btn-user btn-block">
	                  <i class="fab fa-facebook-f fa-fw"></i> 페이스북으로 로그인
	                </a>
                  </form>
                  <hr>
	              <div class="text-center">
	                <a class="small" href="searchID">아이디 찾기</a> /
	                <a class="small" href="searchPW">비밀번호 찾기</a>
	              </div>
	              <div class="text-center">
	                <a class="small" href="join">회원가입</a>
	              </div>
                </div>
              </div>
            </div>
          </div>
        </div>
      </div>
    </div>

  </div>
    
  <script>
    	
  	$(document).ready(function(){

        //로그인
        $("#btnLogin").on("click", function(){

            let mbsp_id = $("#mbsp_id");
            let mbsp_password = $("#mbsp_password");

            if(mbsp_id.val() == "" || mbsp_id.val() == null){
                alert("아이디를 입력하세요.");
                mbsp_id.focus();
                return;
            }

            if(mbsp_password.val() == "" || mbsp_password.val() == null){
                alert("비밀번호를 입력하세요.");
                mbsp_password.focus();
                return;
            }

            $.ajax({
                url: '/member/login',
                type: 'post',
                dataType: 'text',
                data: { mbsp_id : mbsp_id.val() , mbsp_password : mbsp_password.val() },
                success: function(data){
                    
                    if(data == "success"){
                        alert("로그인 성공");
                        location.href = "/";
                    }else if(data == "idFail"){
                        alert("아이디를 확인해주세요");
                        mbsp_id.focus();
                    }else if(data == "pwFail"){
                        alert("비밀번호를 확인해주세요");
                        mbsp_password.focus();
                    }
                }
            });
        });

    });
  
  </script>

</body>

</html>