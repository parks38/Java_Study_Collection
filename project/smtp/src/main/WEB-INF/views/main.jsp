<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
</head>
<body>
    <div class="form-group" style="width: 38%; margin: 10px auto;">
        <button type="button" class="btn btn-primary btn-lg btn-block" onclick="send_mail()">보내기</button>
    </div>

    <script type="text/javascript">
      function send_mail(){
        window.open("/test_mail.jsp", "", "width=370, height=360, resizable=no, scrollbars=no, status=no");
      }
    </script>
</body>