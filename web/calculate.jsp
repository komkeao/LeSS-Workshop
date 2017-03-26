<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <!-- Latest compiled and minified CSS -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">

<!-- Optional theme -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap-theme.min.css" integrity="sha384-rHyoN1iRsVXV4nD0JutlnGaslCJuC7uwjduW9SVrLvRYooPp2bWYgmgJQIXwl/Sp" crossorigin="anonymous">
<title>Main Page</title>
    </head> 

    <body>
        <div class="container">
           <br><br><br><br><br>
  <div align="center" >

<div class="container">
  <h2>ค่าที่จอดรถ</h2>
</div>
</div>


<form>
  <div class="form-group">
    <div class="col-xs-4">

    </div>
    <div class="col-xs-4">
      <h4>หมายเลขทะเเบียนรถ    ${license} </h4>
      <h4>หมวดจังหวัด    ${province} </h4>
      <h4>วันเวลาที่เข้า    ${inTime} </h4>
      <h4>วันเวลาที่ออก    ${outTime} </h4>
      <h4>จำนวนชั่วโมงที่จอด    ${hr} ชั่วโมง</h4>
       <h4>จำนวนเงินค่าจอด    ${money} บาท</h4>
    </div>
    <div class="col-xs-4">

    </div>
  </div>
</form>


  <br><br> <br><br>  <br><br>  <br><br>  <br><br>

  <div align="center" >


    <div class="container">

        <form action="result">
        <div class="form-group">
          <div class="col-xs-4">

          </div>
          <div class="col-xs-4">
          <h3>รับเงิน</h3>
            <input class="form-control" id="ex2" type="text">
          </div>
          <div class="col-xs-4">

          </div>
        </div>
          <br/>
          <br/>
          <br/>
          <br/>
          <br/>
          <br/>
              <button type="submit" class="btn btn-primary btn-lg">คำนวณเงินทอน</button>
      </form>
    </div>




    <br><br>

  </div>
  </div>
</div>

        </div>
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
        <!-- Latest compiled and minified JavaScript -->
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js" integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa" crossorigin="anonymous"></script>
    </body>
</html>
`