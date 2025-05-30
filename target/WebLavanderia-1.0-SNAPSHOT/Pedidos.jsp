<%-- 
    Document   : Pedidos
    Created on : 28 may. 2025, 17:32:51
    Author     : Usuario
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html lang="en">
    <jsp:include page="/Componentes/menuNav.jsp" />


<div class="table-responsive">
    <table class="table table-striped table-hover table-bordered align-middle text-center">
        <thead class="table-info sticky-top">
            <tr>
                <th>ID</th>
                <th>Categoría</th>
                <th>Tipo de Servicio</th>
                <th>Cantidad</th>             
                <th>Fecha Recolección</th>
                <th>Hora Recolección</th>
                <th>Fecha Entrega</th>
                <th>Hora Entrega</th>
                <th>Total</th>
                <th>Acciones</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach items="${solicitudes}" var="solicitud">
                <tr>
                    <td>${solicitud.idSolicitud}</td>
                    <td>${solicitud.idCategoria.nombreCategoria}</td>
                    <td>${solicitud.idServicio.nombreServicio}</td>
                    <td>${solicitud.cantidad} kg</td>
                    <td>${solicitud.fechaRecoleccion}</td>
                    <td>${solicitud.horaRecoleccion}</td>
                    <td>${solicitud.fechaEntrega}</td>
                    <td>${solicitud.horaEntrega}</td>
                    <td>S/<fmt:formatNumber value="${solicitud.subtotal}" type="number" minFractionDigits="2" /></td>
                    <td>
                        <a href="SolicitudServlet?action=eliminar&id=${solicitud.idSolicitud}" 
                           class="btn btn-sm btn-outline-danger" 
                           title="Eliminar solicitud" 
                           onclick="return confirm('¿Seguro que quieres eliminar esta solicitud?');">
                           <i class="bi bi-trash"></i> Eliminar
                        </a>
                    </td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
</div>


<div class="mt-3">
    <h5 class="text-center text-success">${mensaje}</h5>
</div>


<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>


<link href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.10.5/font/bootstrap-icons.css" rel="stylesheet">

