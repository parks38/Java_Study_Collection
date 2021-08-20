<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
    <script src="https://code.jquery.com/jquery-1.12.4.min.js"> </script>
    <style>

      *{
        margin: 0;
        padding: 0;
        box-sizing: border-box;
        font-family: sans-serif;
      }
      main {

      }
      form {
        width: 100%;
        max-width: 400px;
        padding: 20px;
        text-align: center;
        margin: auto;
        margin-top: 40px;
        animation: cambia-color 10s linear infinite;
        background: -webkit-linear-gradient(left, #7a26dd, #e80808);
        background-size: 400% 400%;
      }
      @keyframes cambia-color{
        0% {
          background-position: 0%, 50%;
        }
        50% {
          background-position: 100%, 50%;
        }
        100% {
          background-position: 0%, 100%;
        }
      }
      .title {
        font-size: 14px;
        margin: auto;
        text-align: center;
        font-weight: 100;
        color: whitesmoke;
      }
      .logotipo {
        width: 140px;
        margin-top: 40px;
      }
      ::placeholder {
        color: whitesmoke;
      }
      input[type="text"] {
        width: 100%;
        padding: 14px;
        font-size: 16px;
        margin-top: 20px;
        background: rgba(255, 255, 255, 0.4);
        border-style: none;
        outline: 0px;
        color: whitesmoke;
      }
      input[type="password"] {
        width: 100%;
        padding: 14px;
        font-size: 16px;
        margin-top: 20px;
        background: rgba(255, 255, 255, 0.4);
        border-style: none;
        outline: 0px;
        color: whitesmoke;
      }
      input[type="submit"] {
        width: 100%;
        padding: 14px;
        font-size: 16px;
        font-weight: 100;
        margin-top: 20px;
        transition: background 300ms;
      }
      input[type="submit"]:hover {
        cursor: pointer;
        background: rgba(255, 255, 255, 0.6);
      }

      label  {
        color: white;
      }
    </style>
</head>
<body>
<div class="container">
    <!--
        서버의 최적화를 위해서는 new password 와 re-newPassword 일치를 먼저 확인한 후
        password 를 가서 현재 패스워드값을 알아내야합니다.
        서버를 쓰는 것은 메모리를 써야하기 때문에 costy 하기 때문에
        front 단에서 확인할 수 있는 password 부터 확인한다.
    -->
    <form>
        <div class="form-group">
            <label for="password">password</label>
            <input type="password" id="password">
            <label for="newPassword">new Password</label>
            <input type="password" id="newPassword">
            <label for="authnewPass">re-new Password</label>
            <input type="password" id="authnewPass">
        </div>
        <input type="submit" id="submit" class="btn btn-primary" value="Enter">
    </form>
    <br>
</div>

<script>
  $("#submit").click(function () {
    if ($("#newPassword").val() !== $("#authnewPass").val()) {
      alert("new password does not match");
    }
    var user = {
      "password": $("#password").val()
    };

    $.ajax({
      type: 'POST',
      url: '/user/join',
      data: JSON.stringify(user),
      contentType: 'application/json; charset=utf-8',
      dataType: 'json',
      success : function(error) {
        alert("비밀번호 확인 완료");
      }
    });
  });
</script>
</body>
</html>