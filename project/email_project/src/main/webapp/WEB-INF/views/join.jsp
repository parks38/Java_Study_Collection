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
        <form>
            <div class="form-group">
                <label for="password">password</label>
                <input type="password" id="password">
            </div>
            <input type="submit" id="submit" class="btn btn-primary" value="Enter">
        </form>
        <br>
    </div>

    <script>
      $("#submit").click(function () {
        var user = {
          "password": $("#password").val()
        };

        $.ajax({
          type: 'POST',
          url: '/user/form',
          data: JSON.stringify(user),
          contentType: 'application/json; charset=utf-8',
          dataType: 'json'
        });
      });
    </script>
</body>
</html>