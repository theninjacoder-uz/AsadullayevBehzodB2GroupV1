<%--
  Created by IntelliJ IDEA.
  User: User
  Date: 26.02.2022
  Time: 16:24
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <title>Online Library</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
    <script src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js"></script>
    <style>
        .login-form {
            width: 340px;
            margin: 200px auto;
            font-size: 15px;
        }

        .login-form form {
            margin-bottom: 15px;
            background: #f7f7f7;
            box-shadow: 0 2px 2px rgba(0, 0, 0, 0.3);
            padding: 30px;
        }

        .login-form h2 {
            margin: 0 0 15px;
        }

        .form-control, .btn {
            min-height: 38px;
            border-radius: 2px;
        }

        .btn {
            font-size: 15px;
            font-weight: bold;
        }
    </style>
</head>
<body>
<div class="login-form">
    <form action="/sign-in" method="post">
        <h2 class="text-center">Log in</h2>
        <div class="form-group">
            <input name="username" type="text" class="form-control" placeholder="Username" required="required">
        </div>
        <div class="form-group">
            <input name="password" type="text" class="form-control" placeholder="Password" required="required">
        </div>
        <div class="form-group">
            <button type="submit" class="btn btn-primary btn-block">Sign in</button>
        </div>
    </form>
</div>

<div id="toast" class="toast m-5" th:classappend="${response!=null} ? show : hide"
     style="position: absolute; top: 0; right: 0;">
    <div class="toast-header text-success">
        <strong class="mr-2">Message</strong>
        <button onclick="closeToast()" class="ml-2 mb-1 close" data-dismiss="toast" aria-label="Close">
            <span aria-hidden="true">&times;</span>
        </button>
    </div>
    <div class="toast-body" th:text="${response!=null} ? ${response.getMessage()}:' '"
         th:classappend="${response!=null && response.getStatusCode() == 0} ? 'text-success' : 'text-danger'"></div>
</div>

<script>
    function closeToast() {
        document.getElementById("toast").className = 'toast m-5 hide'
    }
</script>
</body>
</html>