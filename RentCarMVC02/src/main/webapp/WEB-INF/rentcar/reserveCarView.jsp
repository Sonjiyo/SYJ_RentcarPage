<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file= "../util.jsp" %>
<h2 class="my-5">예약 완료</h2>
<img src="${ctx}/img/${vo.img}" style="width:100%;height:100%;object-fit:cover">
<p>차량 금액 : ${reservation.totalPrice - optionPrice }</p>
<p>옵션 금액 : ${optionPrice }</p>
<p>총 금액 : ${reservation.totalPrice }</p>