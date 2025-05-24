<%-- 
    Document   : login
    Created on : 23 abr. 2025, 15:39:47
    Author     : Usuario
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <html lang="en">
        <head>
            <meta charset="UTF-8">
            <meta name="viewport" content="width=device-width, initial-scale=1.0">
            <title>Washi</title>
            <link rel="stylesheet" href="recursos/css/styleLogin.css">
            <link href="https://fonts.googleapis.com/css?family=Quicksand&display=swap" rel="stylesheet">

        </head>
        <body>
            <div class="container">
                <div class="login-box">
                    <div class="imagen-section">
                        <img src="recursos/imagenes/washi.png" alt="washi" />  
                    </div>

                    <div class="login-section">
                        <h2>Iniciar Sesión</h2>
                        <form action="login" method="post">
                            <label for="correo">Correo:</label>
                            <input type="text" id="username" name="correo" placeholder="@ejemplo.com" required>

                            <label for="contrasena">Contraseña:</label>
                            <input type="password" id="password" name="contrasena" placeholder="********" required>

                            <a href="index.jsp">Registrate</a>

                            <button type="submit" value="Submit">Ingresar</button>
                        </form>
                    </div>
                </div>
            </div>
        </body>
    </html>
