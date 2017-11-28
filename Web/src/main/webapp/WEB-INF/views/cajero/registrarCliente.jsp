<%@page import="pojo.Usuario"%>
<%@page import="org.springframework.web.context.request.SessionScope"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="frm" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s" %>
<%@ page session="true" %>

<!DOCTYPE html>
<html>

<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link href='http://fonts.googleapis.com/css?family=Roboto:300,400,500,700,900' rel='stylesheet' type='text/css'>
    
    <!-- Page title -->
    <title>LUNA | Responsive Admin Theme</title>
    <!-- Vendor styles -->
    <s:url value="/resources/bootstrapIntranet/vendor/fontawesome/css/font-awesome.css" var="css1"/>
    <link href="${css1}" rel="stylesheet" type="text/css"/>
    <s:url value="/resources/bootstrapIntranet/vendor/animate.css/animate.css" var="css2"/>
    <link href="${css2}" rel="stylesheet" type="text/css"/>
    <s:url value="/resources/bootstrapIntranet/vendor/bootstrap/css/bootstrap.css" var="css3"/>
    <link href="${css3}" rel="stylesheet" type="text/css"/>
    <s:url value="/resources/bootstrapIntranet/vendor/toastr/toastr.min.css" var="css4"/>
    <link href="${css4}" rel="stylesheet" type="text/css"/>
    <!-- App styles -->
    <s:url value="/resources/bootstrapIntranet/styles/pe-icons/pe-icon-7-stroke.css" var="css4"/>
    <link href="${css4}" rel="stylesheet" type="text/css"/>
    <s:url value="/resources/bootstrapIntranet/styles/pe-icons/helper.css" var="css5"/>
    <link href="${css5}" rel="stylesheet" type="text/css"/>
    <s:url value="/resources/bootstrapIntranet/styles/stroke-icons/style.css" var="css6"/>
    <link href="${css6}" rel="stylesheet" type="text/css"/>
    <s:url value="/resources/bootstrapIntranet/styles/style.css" var="css7"/>
    <link href="${css7}" rel="stylesheet" type="text/css"/>
    
    <s:url value="/resources/bootstrapIntranet/images/profile.jpg" var="img"/>
</head>
<body>

<!-- Wrapper-->
<div class="wrapper">
    <!-- Header-->
    <nav class="navbar navbar-default navbar-fixed-top">
        <div class="container-fluid">
            <div class="navbar-header">
                <div id="mobile-menu">
                    <div class="left-nav-toggle">
                        <a href="#">
                            <i class="stroke-hamburgermenu"></i>
                        </a>
                    </div>
                </div>
                <a class="navbar-brand" href="index-2.html">
                    CARGO
                </a>
            </div>
            <div id="navbar" class="navbar-collapse collapse">
                <div class="left-nav-toggle">
                    <a href="#">
                        <i class="stroke-hamburgermenu"></i>
                    </a>
                </div>
                <ul class="nav navbar-nav navbar-right">
                    <li class=" profil-link">
                        <a href="#">
                            <span class="profile-address"><% Usuario u = (Usuario)session.getAttribute("usuario"); out.print(u.getNombreUsuario()); %></span>
                            <img src="${img}" class="img-circle" alt="">
                        </a>
                    </li>
                </ul>
            </div>
        </div>
    </nav>
    <!-- End header-->

    <!-- Navigation-->
    <aside class="navigation">
        <nav>
            <ul class="nav luna-nav">
                <li class="inactive">
                    <a href="${pageContext.request.contextPath}/principalCajero">Principal</a>
                </li>
                <li class="nav-category">
                    Encomiendas
                </li>
                <li class="">
                    <a href="${pageContext.request.contextPath}/NuevaEncomienda">Registrar Encomienda</a>
                </li>
                <li class="nav-category">
                    Cliente
                </li>
                <li class="active">
                    <a href="${pageContext.request.contextPath}/NuevoCliente">Nuevo Cliente</a>
                </li>
                <li class="nav-info">
                    <i class="pe pe-7s-shield text-accent"></i>
                    <div class="m-t-xs">
                        <span class="c-white">LUNA</span> admin theme with Dark UI style for monitoring and administration web applications.
                    </div>
                </li>
            </ul>
        </nav>
    </aside>
    <!-- End navigation-->


    <!-- Main content-->
    <section class="content">
            <div class="container-fluid">

                <div class="row">
                    <div class="col-lg-12">
                        <div class="view-header">
                            <div class="header-icon">
                                <i class="pe page-header-icon pe-7s-shield"></i>
                            </div>
                            <div class="header-title">
                                <h3 class="m-b-xs">Registrar Nuevo Cliente</h3>
                                <small>
                                    Registro de un nuevo cliente.
                                </small>
                            </div>
                        </div>
                        <hr>
                    </div>
                </div>
                
				<div class="row">
                	<div class="col-lg-6">
                		<frm:form role="form" method="POST" action="CrearCliente">
	        		        <div class="form-group">
	                            <label class="control-label">DNI</label>
	                            <frm:input path="dniCliente" id="txtDni" oninput="validarDNI()" pattern="\d*" minlength="8"  maxlength="8" class="form-control" type="text" required="true"></frm:input>
								<label class="control-label">Nombres</label>
	                            <frm:input path="persona.nombres" class="form-control" type="text" required="true"></frm:input>
								<label class="control-label">Apellidos</label>
	                            <frm:input path="persona.apellidos" class="form-control" type="text" required="true"></frm:input>
								<label class="control-label">Direcci�n</label>
	                            <frm:input path="persona.direccion" class="form-control" type="text" required="true"></frm:input>
								<label class="control-label">Telefono</label>
	                            <frm:input path="persona.telefono" class="form-control" type="text" required="true"></frm:input>
								<label class="control-label">Correo Electronico</label>
	                            <frm:input path="correoElectronico" class="form-control" type="text" required="true"></frm:input>
                                <label class="control-label">Genero</label>
	                            <frm:select path="persona.genero" class="form-control"> 
	                          	    <frm:option value="M">Masculino</frm:option>
									<frm:option value="F">Femenino</frm:option>
								</frm:select>
								<input class="btn btn-accent" type="submit" value="Registrar"/> 
	                        	<input class="btn btn-accent" type="reset" value="Limpiar"/> 
	                        </div>
                        </frm:form>
              		</div>
	            </div>
            </div>
    </section>
    <!-- End main content-->
</div>
<!-- End wrapper-->
<!-- Vendor scripts -->
<s:url value="/resources/bootstrapIntranet/vendor/pacejs/pace.min.js" var="js1"/>
<script src="${js1}"></script>
<s:url value="/resources/bootstrapIntranet/vendor/jquery/dist/jquery.min.js" var="js2"/>
<script src="${js2}"></script>
<s:url value="/resources/bootstrapIntranet/vendor/bootstrap/js/bootstrap.min.js" var="js3"/>
<script src="${js3}"></script>

<!-- App scripts -->
<s:url value="/resources/bootstrapIntranet/scripts/luna.js" var="js4"/>
<script src="${js4}"></script>

</body>

</html>