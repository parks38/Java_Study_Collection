<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
    <script src="https://code.jquery.com/jquery-1.12.4.min.js"> </script>
    <style>
      /* Add a black background color to the top navigation */
      .topnav {
        background-color: #333;
        overflow: hidden;
      }

      /* Style the links inside the navigation bar */
      .topnav a {
        float: left;
        color: #f2f2f2;
        text-align: center;
        padding: 14px 16px;
        text-decoration: none;
        font-size: 17px;
      }

      /* Change the color of links on hover */
      .topnav a:hover {
        background-color: #ddd;
        color: black;
      }

      /* Add a color to the active/current link */
      .topnav a.active {
        background-color: #04AA6D;
        color: white;
      }
    </style>
</head>

<body>
<div class="container">
    <div class="topnav">
        <a class="active" href="javascript:void(0);" data-value="1" onclick="categoryFilterURL(this)">Home</a>
        <a href="javascript:void(0);" data-value="2" onclick="categoryFilterURL(this)">News</a>
        <a href="javascript:void(0);" data-value="3" onclick="categoryFilterURL(this)">Contact</a>
        <a href="javascript:void(0);" data-value="4" onclick="categoryFilterURL(this)">About</a>
    </div>
    <br>
        <div class="form-group">
            <select id="type" name="types">
                <option value="title">제목</option>
                <option value="titleContent">제목+내용</option>
            </select>
            <br><br>
            <label for="keyword">keyword</label>
            <input type="text" id="keyword" name="keyword"> <br>
            <label for="fromdate">from date</label>
            <input type="date" id="fromdate" name="fromdate"><br>
            <label for="todate">to date</label>
            <input type="date" id="todate" name="todate">
        </div>
        <br>
        <button id="submit" type="submit" value="search" onclick="searchFilterURL()">검색</button><br><br>
    <button id="sort-date" type="submit" value="date" onclick="sortFilterURL()">등록일순</button><br><br>
    <button id="sort-visit" type="submit" value="visit" onclick="sortFilterURL()">조회순</button>
    <br>
</div>

${filter}

<script>

  // 검색
  function searchFilterURL() {
    var fromdate = $("input[name='fromdate']").val();
    var todate = $("input[name='todate']").val();

    var filterOption = {
      type: $("#type option:selected").val(),
      keyword: $("input[name='keyword']").val(),
      fromdate: fromdate,
      todate: todate
    };
    if (fromdate || todate) {
      common_ajax("KEYWORD_DATE", filterOption);
    } else {
      common_ajax("KEYWORD", filterOption);
    }
  }

  //$(function)

  // 카테고리 - working !
  function categoryFilterURL(event) {
    var filterOption = {
      categoryId: $(event).data('value')
    };
    common_ajax("CATEGORY", filterOption);
  }

  // sort
  function sortFilterURL() {
    var param = "${param.filter}" == null ? "RECENT" : "${param.filter}";
    var filter = param.indexOf("SORT") <= -1 ? param + "_SORT" : param;

    common_ajax("RECENT_SORT", ${filterOption});
  }

  //공통 ajax
  function common_ajax(filter, filterType) {
    //location.href = "/category?filter=" + filter;

    $.ajax({
      type: 'POST',
      url: '/category?filter=' + filter,
      data: JSON.stringify(filterType),
      contentType: 'application/json; charset=utf-8',
      dataType: 'text',
      success : function(data) {

      }
    });
    return false; // a 태그 reload 문제
  }

  $(document).ready(function() {

    $("a.active").click(function() {
      var filterType = {
        categoryId: $(this).data('value')
      };

      $.ajax({
        type: 'POST',
        url: '/category?filter=' + "CATEGORY",
        data: JSON.stringify(filterType),
        contentType: 'application/json; charset=utf-8',
        dataType: 'text',
        success : function(data) {

        }
      });
    });
  });
</script>
</body>

</html>