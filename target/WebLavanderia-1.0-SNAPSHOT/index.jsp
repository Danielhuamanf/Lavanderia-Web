<%-- 
    Document   : index
    Created on : 23 abr. 2025, 09:37:48
    Author     : Usuario
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="recursos/css/style.css"/>
        <title>JSP Page</title>
    </head>
    <body>
        <div class="form-container">
            <%
                String mensaje = (String) request.getAttribute("mensaje");
                String tipoMensaje = (String) request.getAttribute("tipoMensaje");
                if (mensaje != null) {
            %>
            <div class="alert <%= tipoMensaje%>">
                <%= mensaje%>
            </div>
            <% }%>
            <h1>Formulario registro</h1> 
            <form action="registrar" method="post">
                <table style="width:80%">
                    <tr>
                        <td>Nombre</td>
                        <td><input type="text" name="nombre" required/></td>
                    </tr>
                    <tr>
                        <td>Correo</td>
                        <td><input type="text" name="correo" required/></td>
                    </tr>
                    <tr>
                        <td>Telefono</td>
                        <td><input type="text" name="telefono" required/></td>
                    </tr>
                    <tr>
                        <td>Contraseña</td>
                        <td><input type="text" name="contrasena" required/></td>
                    </tr>
                    <tr>
                        <td>Direccion</td>
                        <td><input type="text" name="direccion" required/></td>
                    </tr>
                    <tr>
                        <td>Rol</td>
                        <td>
                        <select name="rol" required>
                        <option value="" disabled selected>Seleccione un rol</option>
                        <option value="A">Administrador</option>
                        <option value="C">Cliente</option>
                        </td>
                    </select>
                    </tr>

                </table> 
                <input type="submit" value="Submit"/>
            </form>
        </div>
    </body>
</html>
