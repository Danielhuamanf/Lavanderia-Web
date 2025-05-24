<%-- 
    Document   : servicio
    Created on : 22 may. 2025, 12:24:31
    Author     : Usuario
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Solicitar Servicio - Lavandería</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
    <link rel="stylesheet" href="recursos/css/home.css">
</head>
<body>
    <div class="d-flex">
        <!-- Sidebar -->
        <div class="d-flex flex-column" id="sidebar-wrapper">
            <div class="sidebar-heading">WashyAQP</div>
            <div class="list-group list-group-flush flex-grow-1">
                <a href="home.jsp" class="list-group-item list-group-item-action">
                    <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor"
                        class="bi bi-house-door-fill" viewBox="0 0 16 16">
                        <path
                            d="M6.5 14.5v-3.505c0-.245.25-.495.5-.495h2c.25 0 .5.25.5.5v3.5a.5.5 0 0 0 .5.5h4a.5.5 0 0 0 .5-.5v-7a.5.5 0 0 0-.146-.354L13 5.793V2.5a.5.5 0 0 0-.5-.5h-1a.5.5 0 0 0-.5.5v1.293L8.354 1.146a.5.5 0 0 0-.708 0l-6 6A.5.5 0 0 0 1.5 7.5v7a.5.5 0 0 0 .5.5h4a.5.5 0 0 0 .5-.5" />
                    </svg>
                    Inicio
                </a>
                <a href="#servicio.html" class="list-group-item list-group-item-action">
                    <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor"
                        class="bi bi-cart-plus-fill" viewBox="0 0 16 16">
                        <path
                            d="M.5 1a.5.5 0 0 0 0 1h1.11l.401 1.607 1.498 7.985A.5.5 0 0 0 4 12h1a2 2 0 1 0 0 4 2 2 0 0 0 0-4h7a2 2 0 1 0 0 4 2 2 0 0 0 0-4h1a.5.5 0 0 0 .491-.408l1.5-8A.5.5 0 0 0 14.5 3H2.89l-.405-1.621A.5.5 0 0 0 2 1zM6 14a1 1 0 1 1-2 0 1 1 0 0 1 2 0m7 0a1 1 0 1 1-2 0 1 1 0 0 1 2 0M9 5.5V7h1.5a.5.5 0 0 1 0 1H9v1.5a.5.5 0 0 1-1 0V8H6.5a.5.5 0 0 1 0-1H8V5.5a.5.5 0 0 1 1 0" />
                    </svg>
                    Solicitar Servicio
                </a>
                <a href="#mis-pedidos" class="list-group-item list-group-item-action">
                    <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor"
                        class="bi bi-archive-fill" viewBox="0 0 16 16">
                        <path
                            d="M12.643 15C13.979 15 15 13.845 15 12.5V5H1v7.5C1 13.845 2.021 15 3.357 15zM5.5 7h5a.5.5 0 0 1 0 1h-5a.5.5 0 0 1 0-1M.8 1a.8.8 0 0 0-.8.8V3a.8.8 0 0 0 .8.8h14.4A.8.8 0 0 0 16 3V1.8a.8.8 0 0 0-.8-.8z" />
                    </svg>
                    Mis Pedidos
                </a>
                <a href="#perfil" class="list-group-item list-group-item-action">
                    <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor"
                        class="bi bi-person-circle" viewBox="0 0 16 16">
                        <path d="M11 6a3 3 0 1 1-6 0 3 3 0 0 1 6 0" />
                        <path fill-rule="evenodd"
                            d="M0 8a8 8 0 1 1 16 0A8 8 0 0 1 0 8m8-7a7 7 0 0 0-5.468 11.37C3.242 11.226 4.805 10 8 10s4.757 1.225 5.468 2.37A7 7 0 0 0 8 1" />
                    </svg>
                    Perfil
                </a>
                <a href="#metodos-pago" class="list-group-item list-group-item-action">
                    <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor"
                        class="bi bi-credit-card-2-back-fill" viewBox="0 0 16 16">
                        <path
                            d="M0 4a2 2 0 0 1 2-2h12a2 2 0 0 1 2 2v5H0zm11.5 1a.5.5 0 0 0-.5.5v1a.5.5 0 0 0 .5.5h2a.5.5 0 0 0 .5-.5v-1a.5.5 0 0 0-.5-.5zM0 11v1a2 2 0 0 0 2 2h12a2 2 0 0 0 2-2v-1z" />
                    </svg>
                    Métodos de Pago
                </a>
            </div>
            <div class="logout">
                
                <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor"
                    class="bi bi-box-arrow-left" viewBox="0 0 16 16">
                    <path fill-rule="evenodd"
                        d="M6 12.5a.5.5 0 0 0 .5.5h8a.5.5 0 0 0 .5-.5v-9a.5.5 0 0 0-.5-.5h-8a.5.5 0 0 0-.5.5v2a.5.5 0 0 1-1 0v-2A1.5 1.5 0 0 1 6.5 2h8A1.5 1.5 0 0 1 16 3.5v9a1.5 1.5 0 0 1-1.5 1.5h-8A1.5 1.5 0 0 1 5 12.5v-2a.5.5 0 0 1 1 0z" />
                    <path fill-rule="evenodd"
                        d="M.146 8.354a.5.5 0 0 1 0-.708l3-3a.5.5 0 1 1 .708.708L1.707 7.5H10.5a.5.5 0 0 1 0 1H1.707l2.147 2.146a.5.5 0 0 1-.708.708z" />
                </svg>
            </div>
        </div>
        <!-- Main Content -->
        <div class="container-fluid">
            <div class="p-3">
                <h1 class="text-primary">Solicitar Servicio</h1>
                <p>Bienvenido a la sección de solicitud de servicios. Sigue el tutorial breve para aprender cómo seleccionar tus servicios.</p>

                <!-- Tutorial Section -->
                <div class="alert alert-info" role="alert">
                    <strong>Tutorial:</strong> Elige el tipo de servicio, personaliza tus preferencias y programa la recolección y entrega. Presiona el botón "Abrir Modal" para comenzar.
                </div>

                <!-- Open Modal Button -->
                <button type="button" class="btn btn-primary" data-bs-toggle="modal" data-bs-target="#serviceModal">
                    Abrir Modal
                </button>

                <!-- Modal -->
                <div class="modal fade" id="serviceModal" tabindex="-1" aria-labelledby="serviceModalLabel" aria-hidden="true">
                    <div class="modal-dialog">
                        <div class="modal-content">
                            <div class="modal-header">
                                <h5 class="modal-title" id="serviceModalLabel">Solicitar Servicio</h5>
                                <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                            </div>
                            <div class="modal-body">
                                <form>
                                    <!-- Tipo de Servicio -->
                                    <div class="mb-3">
                                        <label for="tipoServicio" class="form-label">Tipo de Servicio</label>
                                        <select id="tipoServicio" class="form-select">
                                            <option selected>Selecciona...</option>
                                            <option value="1">Lavado estándar</option>
                                            <option value="2">Lavado y planchado</option>
                                            <option value="3">Limpieza en seco</option>
                                            <option value="4">Limpieza de calzado</option>
                                            <option value="5">Ropa delicada o blanca</option>
                                        </select>
                                    </div>

                                    <!-- Tipo de Prendas -->
                                    <div class="mb-3">
                                        <label for="tipoPrenda" class="form-label">Tipo de Prenda</label>
                                        <input type="text" id="tipoPrenda" class="form-control" placeholder="Ejemplo: camisetas, pantalones">
                                    </div>

                                    <!-- Cantidad -->
                                    <div class="mb-3">
                                        <label for="cantidad" class="form-label">Cantidad o Peso (kg)</label>
                                        <input type="number" id="cantidad" class="form-control" placeholder="Ejemplo: 5">
                                    </div>

                                    <!-- Servicios Adicionales -->
                                    <div class="mb-3">
                                        <label for="serviciosAdicionales" class="form-label">Servicios Adicionales</label>
                                        <div class="form-check">
                                            <input class="form-check-input" type="checkbox" value="desmanchado" id="desmanchado">
                                            <label class="form-check-label" for="desmanchado">
                                                Desmanchado
                                            </label>
                                        </div>
                                        <div class="form-check">
                                            <input class="form-check-input" type="checkbox" value="fragancia" id="fragancia">
                                            <label class="form-check-label" for="fragancia">
                                                Fragancia especial
                                            </label>
                                        </div>
                                        <div class="form-check">
                                            <input class="form-check-input" type="checkbox" value="doblado" id="doblado">
                                            <label class="form-check-label" for="doblado">
                                                Doblado
                                            </label>
                                        </div>
                                    </div>

                                    <!-- Notas Adicionales -->
                                    <div class="mb-3">
                                        <label for="notasAdicionales" class="form-label">Notas Adicionales</label>
                                        <textarea id="notasAdicionales" class="form-control" rows="3" placeholder="Ejemplo: No usar suavizante"></textarea>
                                    </div>
                                </form>
                            </div>
                            <div class="modal-footer">
                                <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Cancelar</button>
                                <button type="button" class="btn btn-primary">Guardar</button>
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
    </div>

    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>