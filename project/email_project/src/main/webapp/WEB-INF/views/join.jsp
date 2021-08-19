<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
    <script src="https://code.jquery.com/jquery-1.12.4.min.js"> </script>
</head>
<body>
    <div class="container">
        <form>
            <div class="form-group">
                <label for="password">password</label>
                <input type="password" id="password">
            </div>
        </form>
        <br>
        <button id="submit" class="btn btn-primary">enter </button>
    </div>

    <script>
        $(function() {
          $("button").click(function() {
            var password = $("#password").val();

            $.ajax({
              type : 'POST',
              url : '/user/join',
              data : JSON.stringify(password),
              contentType : 'application/json; charset=utf-8',
              dataType : 'json'
            }).done(function(r) {
                console.log(r);
                alert('회원가입 성공');
            });
          });
        });
    </script>
</body>
</html>