<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<style>
	.bord {
		background-color: <%= request.getAttribute("couleurBord")%>;
	}
	.centre {
		background-color: <%= request.getAttribute("couleurCentre")%>;
	}
</style>