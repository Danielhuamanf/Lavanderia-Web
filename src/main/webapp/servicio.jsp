<%-- 
    Document   : servicio
    Created on : 22 may. 2025, 12:24:31
    Author     : Usuario
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html lang="en">
    <jsp:include page="/Componentes/menuNav.jsp" />
    <!-- Main Content -->


    <div class="container-fluid">
        <div class="p-3">
            <h1 class="text-primary">Solicitar Servicio</h1>
            <p>Bienvenido a la sección de solicitud de servicios. Personaliza tus preferencias y programa la recolección y entrega.</p>

            <!-- Tutorial Section -->
            <div class="alert alert-info" role="alert">
                <strong>Tutorial:</strong> Elige el tipo de servicio, ajusta las preferencias y confirma los detalles para programar tu servicio.
            </div>

            <!-- Open Modal Button -->
            <button type="button" class="btn btn-primary" data-bs-toggle="modal" data-bs-target="#serviceModal">
                Solicitar Servicio
            </button>

            <!-- Modal -->
            <div class="modal fade" id="serviceModal" tabindex="-1" aria-labelledby="serviceModalLabel" aria-hidden="true">
                <div class="modal-dialog modal-lg">
                    <div class="modal-content">
                        <div class="modal-header">
                            <h5 class="modal-title" id="serviceModalLabel">Detalles del Servicio</h5>
                            <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                        </div>
                        <div class="modal-body">
                            <form id="serviceForm" method="post" action="SolicitudServlet?action=guardarSolicitud">

                                <!-- Categorías de Servicios -->
                                <h5>Categorías de Servicios</h5>
                                <div class="row g-3">
                                    <div class="col-md-6">
                                        <label for="categoriaServicio" class="form-label">Categoría</label>
                                        <select id="categoriaServicio" name="categoriaServicio" class="form-select" required>
                                            <c:forEach var="categoria" items="${categorias}">

                                                <option value="${categoria.idCategoria}">${categoria.nombreCategoria}</option>

                                            </c:forEach>
                                        </select>
                                    </div>
                                </div>
                                <hr>

                                <!-- Opciones de Servicios -->
                                <h5>Opciones del Servicio</h5>
                                <div class="row g-3">
                                    <div class="col-md-6">
                                        <label for="tipoServicio" class="form-label">Tipo de Servicio</label>
                                        <select id="tipoServicio" name="tipoServicio" class="form-select" required>
                                            <c:forEach var="servicio" items="${servicios}">

                                                <option value="${servicio.idServicio}" data-precio="${servicio.precioBase}">
                                                    ${servicio.descripcion} - S/<fmt:formatNumber value="${servicio.precioBase}" type="number" minFractionDigits="2"/>
                                                </option>

                                            </c:forEach>
                                        </select>
                                    </div>
                                    <div class="col-md-6">
                                        <label for="cantidad" class="form-label">Cantidad o Peso (kg)</label>
                                        <input type="number" id="cantidad" name="cantidad" class="form-control" placeholder="Ejemplo: 5" min="1" required>
                                    </div>
                                </div>

                                <div class="mt-3">
                                    <h6>Tipo de Ropa</h6>
                                    <div class="form-check">
                                        <input class="form-check-input" type="radio" name="tipoRopa" id="ropaNormal" value="normal" checked>
                                        <label class="form-check-label" for="ropaNormal">Ropa normal</label>
                                    </div>
                                    <div class="form-check">
                                        <input class="form-check-input" type="radio" name="tipoRopa" id="ropaDelicada" value="delicada">
                                        <label class="form-check-label" for="ropaDelicada">Ropa delicada (+S/5 por kg)</label>
                                    </div>
                                    <div class="form-check">
                                        <input class="form-check-input" type="radio" name="tipoRopa" id="ropaBlanca" value="blanca">
                                        <label class="form-check-label" for="ropaBlanca">Ropa blanca (+S/3 por kg)</label>
                                    </div>
                                </div>
                                <hr>

                                <!-- Programación -->
                                <h5>Programación</h5>
                                <div class="row g-3">
                                    <div class="col-md-6">
                                        <label for="fechaRecoleccion" class="form-label">Fecha de Recolección</label>
                                        <input type="date" id="fechaRecoleccion" name="fechaRecoleccion" class="form-control" required>
                                    </div>
                                    <div class="col-md-6">
                                        <label for="horaRecoleccion" class="form-label">Hora de Recolección</label>
                                        <input type="time" id="horaRecoleccion" name="horaRecoleccion" class="form-control" required>
                                    </div>
                                    <div class="col-md-6">
                                        <label for="fechaEntrega" class="form-label">Fecha de Entrega</label>
                                        <input type="date" id="fechaEntrega" name="fechaEntrega" class="form-control" required>
                                    </div>
                                    <div class="col-md-6">
                                        <label for="horaEntrega" class="form-label">Hora de Entrega</label>
                                        <input type="time" id="horaEntrega" name="horaEntrega" class="form-control" required>
                                    </div>
                                </div>
                                <hr>

                                <!-- Notas Adicionales -->
                                <h5>Notas Adicionales</h5>
                                <textarea id="notasAdicionales" name="notasAdicionales" class="form-control" rows="3" placeholder="Ejemplo: Tratar manchas específicas, evitar detergentes fuertes"></textarea>
                                <hr>
                                

                                <!-- Mostrar Total -->
                               <input type="hidden" id="precioServicio" name="precioServicio" value="0.00">

                                <!-- Mostrar Total -->
                                <div class="mt-3 text-end">
                                    <h5>Total: S/<span id="totalPrice">0.00</span></h5>
                                </div>
                                <button type="submit" class="btn btn-primary">Guardar</button>

                            </form>
                            <div class="modal-footer">
                                <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Cancelar</button>

                            </div>
                        </div>

                    </div>
                </div>
            </div>
        </div>
    </div>



    <!-- Registro Resumen -->
    <div class="mt-4">
        <h5>Resumen del Servicio</h5>
        <p>Aquí aparecerán los servicios seleccionados.</p>
    </div>
</div>
</div>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>

<script>
    document.addEventListener('DOMContentLoaded', () => {
        const tipoServicio = document.getElementById('tipoServicio');
        const cantidad = document.getElementById('cantidad');
        const adicionales = document.querySelectorAll('.additional-service');
        const totalPrice = document.getElementById('totalPrice');
        const tipoRopaInputs = document.querySelectorAll('input[name="tipoRopa"]');

        const calcularTotal = () => {
            let total = 0;

// Precio base del servicio
            if (tipoServicio.value) {
                const selectedOption = tipoServicio.options[tipoServicio.selectedIndex];
                const precioBase = parseFloat(selectedOption.getAttribute('data-precio'));
                const cantidadValue = parseInt(cantidad.value) || 1;
                total += precioBase * cantidadValue;

                // Agregar costo adicional por tipo de ropa
                const tipoRopaSeleccionado = document.querySelector('input[name="tipoRopa"]:checked').value;
                if (tipoRopaSeleccionado === 'delicada') {
                    total += 5 * cantidadValue; // +S/5 por kg
                } else if (tipoRopaSeleccionado === 'blanca') {
                    total += 3 * cantidadValue; // +S/3 por kg
                }
            }

// Servicios adicionales
            adicionales.forEach(adicional => {
                if (adicional.checked) {
                    total += parseFloat(adicional.getAttribute('data-precio'));
                }
            });

            totalPrice.textContent = total.toFixed(2);
        };

        tipoServicio.addEventListener('change', calcularTotal);
        cantidad.addEventListener('input', calcularTotal);
        adicionales.forEach(adicional => adicional.addEventListener('change', calcularTotal));
        tipoRopaInputs.forEach(input => input.addEventListener('change', calcularTotal));
    });




</script>
</body>
</html>