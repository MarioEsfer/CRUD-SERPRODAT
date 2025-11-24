<jsp:include page="menu.jsp"/>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="entidad.Alumno" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%
  Alumno a = (Alumno) request.getAttribute("registro");
%>
<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <title>Actualizar Alumno</title>
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.8/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-sRIl4kxILFvY47J16cr9ZwB07vP4J8+LH7qKQnuqkuIAvNWLzeN8tE5YBujZqJLB" crossorigin="anonymous">
</head>

<body>
  <c:if test="${not empty requestScope.MENSAJE}">
    <c:set var="tipo" value="${requestScope.TIPO_MENSAJE != null ? requestScope.TIPO_MENSAJE : 'info'}"/>
    <div class="alert alert-${tipo} alert-dismissible fade show" role="alert">
      <strong>${requestScope.MENSAJE}</strong>
      <button type="button" class="btn-close" data-bs-dismiss="alert" aria-label="Close"></button>
    </div>
 </c:if>


  <div class="container">
    <h2>Actualizar Datos del Alumno</h2>

    <form action="ServletAlumno?accion=ACTUALIZAR" method="post" id="form_registrar">
    
    	<input type="hidden" value="${requestScope.registro.codigoDistrito}" id="idDistrito">
    
      <div class="form-group mb-3">
        <label for=form-label>Codigo</label>
        <input type="text" class="form-control" name="codigo" readonly="readonly" value="${requestScope.registro.codigo}">
      </div>

      <div class="form-group mb-3">
        <label for="form-label">Nombres</label>
        <input type="text" class="form-control" name="nombre" value="${requestScope.registro.nombre}">
      </div>

      <div class="form-group mb-3">
        <label for="form-label">Apellido Paterno</label>
        <input type="text" class="form-control" name="apellidoPa" value="${requestScope.registro.paterno}">
      </div>

      <div class="form-group mb-3">
        <label for="form-label">Apellido Materno</label>
        <input type="text" class="form-control" name="apellidoMa" value="${requestScope.registro.materno}">
      </div>

      <div class="form-group mb-3">
        <label for="form-label">Fecha de Nacimiento</label>
        <input type="date" class="form-control" name="fecNac" value="${requestScope.registro.fecha}">
      </div>
      
      <div class="mb-3">
        <label class="form-label">Distrito</label>
        <select class="form-control" name="distrito" id="cboDistritos">
        	<option>[Seleccionar distrito]</option>
	        	<c:forEach items="${requestScope.distritos}" var="row">
	        		<option value="${row.codigo}">${row.nombre}</option>
	        	</c:forEach>
        </select>	
      </div>
      
      <div class="mb-3">
        <label class="form-label">Direccion</label>
        <input type="text" class="form-control" name="direccion" value="${requestScope.registro.direccion}">
      </div>

      <button type="submit" class="btn btn-primary">Modificar</button>
      <button type="button" class="btn btn-success" onclick="window.location.href='ServletAlumno?accion=LISTAR'">Lista de Alumnos</button>
    </form>
  </div>

	<!-- Scripts -->
  	<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
  	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.8/dist/js/bootstrap.bundle.min.js"></script>
  	<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery-validate/1.19.5/jquery.validate.min.js"></script>

	<!-- JQuery Validation -->
	<script src="https://cdn.jsdelivr.net/npm/jquery-validation@1.19.5/dist/jquery.validate.js"></script>
	<script src="https://cdn.jsdelivr.net/npm/jquery-validation@1.19.5/dist/jquery.validate.min.js"></script>
	<script src="https://cdn.jsdelivr.net/npm/jquery-validation@1.19.5/dist/additional-methods.js"></script>
	<script src="https://cdn.jsdelivr.net/npm/jquery-validation@1.19.5/dist/additional-methods.min.js"></script>	
	
	<script>
		//Obtener el valor dde la caja idDistrito
		var dis=$("#idDistrito").val();
		$("#cboDistritos").val(dis);
	</script> 

</body>
</html>
