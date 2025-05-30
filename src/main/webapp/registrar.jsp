<%-- 
    Document   : index
    Created on : 23 abr. 2025, 09:37:48
    Author     : Usuario
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="es">
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Registro de Usuario</title>
        <!-- Bootstrap CSS -->
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
        <link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0/css/all.min.css" rel="stylesheet">

    </head>
    <body class="bg-light">
        <div class="container mt-5">
            <div class="row justify-content-center">
                <div class="col-md-6">
                    <div class="card shadow-sm">
                        <div class="card-header text-center bg-primary text-white">
                            <h4>Registro de Usuario</h4>
                        </div>
                        <div class="card-body">
                            <!-- Mensajes de alerta -->
                            <%
                                String mensaje = (String) request.getAttribute("mensaje");
                                String tipoMensaje = (String) request.getAttribute("tipoMensaje");
                                if (mensaje != null) {
                            %>
                            <div class="alert <%= tipoMensaje != null ? tipoMensaje : "alert-info"%>">
                                <%= mensaje%>
                            </div>
                            <% }%>

                            <!-- Formulario -->
                            <form action="UsuarioServlet?action=registrar" method="post">
                                <!-- Nombre -->
                                <div class="mb-3">
                                    <label for="nombre" class="form-label">Nombre</label>
                                    <input type="text" name="nombre" id="nombre" value="${usuario.nombre}" 
                                           class="form-control" maxlength="50" placeholder="Ingresa tu nombre" required>
                                </div>

                                <!-- Correo -->
                                <div class="mb-3">
                                    <label for="correo" class="form-label">Correo Electrónico</label>
                                    <input type="email" name="correo" id="correo" value="${usuario.correo}" 
                                           class="form-control" maxlength="100" placeholder="Ingresa tu correo" required>
                                </div>

                                <!-- Teléfono -->
                                <div class="mb-3">
                                    <label for="telefono" class="form-label">Teléfono</label>
                                    <input type="tel" name="telefono" id="telefono" value="${usuario.telefono}" 
                                           class="form-control" maxlength="15" placeholder="Ingresa tu número de teléfono" required>
                                </div>

                                <div class="mb-3">
                                    <label for="contrasena" class="form-label">Contraseña</label>
                                    <input type="password" name="contrasena" id="contrasena" 
                                           class="form-control" maxlength="50" placeholder="Ingresa tu contraseña" required>
                                </div>

                                <div class="mb-3">
                                    <label for="confirmarContrasena" class="form-label">Confirmar Contraseña</label>
                                    <input type="password" name="confirmarContrasena" id="confirmarContrasena" 
                                           class="form-control" maxlength="50" placeholder="Confirma tu contraseña" required>
                                </div>

                                <!-- Dirección -->
                                <div class="mb-3">
                                    <label for="direccion" class="form-label">Dirección</label>
                                    <input type="text" name="direccion" id="direccion" value="${usuario.direccion}" 
                                           class="form-control" maxlength="100" placeholder="Ingresa tu dirección" required>
                                </div>

                                <!-- Botones -->
                                <div class="d-flex justify-content-between">
                                    <button type="submit" class="btn btn-primary">
                                        <i class="fa fa-save"></i> Registrar
                                    </button>
                                    <a href="login.jsp" class="btn btn-secondary">
                                        <i class="fa fa-arrow-left"></i> Volver atrás
                                    </a>
                                </div>
                            </form>
                        </div>
                    </div>
                </div>
            </div>
        </div>


        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>
    </body>
</html>

