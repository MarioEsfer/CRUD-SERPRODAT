<jsp:include page="menu.jsp"/>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1" %>
<%@ page pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.List" %>
<%@ page import="entidad.Alumno" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
  <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
  
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
<link rel="stylesheet" href="https://cdn.datatables.net/2.3.4/css/dataTables.dataTables.min.css">
 
 
  
  <title>Listado de Alumnos</title>
</head>
<body>
  <h2 align="center">LISTADO DE ALUMNOS</h2>  
  
  	<div class="container">
  	
  	  <button type="submit" class="btn btn-primary" onclick="window.location.href='ServletAlumno?accion=LISTAR_DISTRITO'">Registrar Alumno</button>
  	
	  <table border="2" id="myTable" class="display table table-bordered table-striped">
		  <thead>
		    <tr bgcolor="#cccccc">
		      <th>CODIGO</th>
		      <th>NOMBRES</th>
		      <th>APELLIDO PATERNO</th>
		      <th>APELLIDO MATERNO</th>
		      <th>FECHA DE NACIMIENTO</th>
		      <th>EDITAR</th>
		      <th>ELIMINAR</th>
		    </tr>
		</thead>	    
	    <tbody>
	       <c:forEach items="${requestScope.alumnos}" var="item">
		    <tr>
		      <td>${item.codigo}</td>
		      <td>${item.nombre}</td>
		      <td>${item.paterno}</td>
		      <td>${item.materno}</td>
		      <td>${item.fecha}</td>
		      <td align="center">
		        <a href="ServletAlumno?accion=BUSCAR&codigo=${item.codigo}" title="Editar">
		          <img src="img/edit.png" alt="Editar">
		        </a>
		      </td>
		      <td align="center">
		        <a href="ServletAlumno?accion=ELIMINAR&codigo=${item.codigo}" title="Eliminar">
		          <img src="img/delete.jpg" alt="Eliminar">
		        </a>
		      </td>
		    </tr>         
		   </c:forEach> 
		</tbody>
	  </table>
  	</div>
  	
  	<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script> 
	<script src="https://cdn.datatables.net/2.3.4/js/dataTables.min.js"></script>
  
  <script>
		$(document).ready(function() {
		  $('#myTable').DataTable({
		    language: {
		      url: 'https://cdn.datatables.net/plug-ins/2.0.0/i18n/es-ES.json'
		    }
		  });
		});
	</script>


</body>
</html>
