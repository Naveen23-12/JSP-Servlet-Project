<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>Login</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css">
</head>
<body class="login-page">

<div class="glass-card">
    <h2>Welcome Back</h2>
    <form action="LoginServlet" method="post">
        <div class="input-group">
            <input type="text" name="username" required />
            <label>Username</label>
        </div>

        <div class="input-group">
            <input type="password" name="password" required />
            <label>Password</label>
        </div>

        <button class="btn-glossy" type="submit">Login</button>
    </form>

    <p class="error-message">
        ${errorMessage}
    </p>
</div>

</body>
</html>
