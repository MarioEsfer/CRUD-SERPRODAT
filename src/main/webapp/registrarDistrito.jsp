<jsp:include page="menu.jsp"/>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Registrar Distrito</title>

<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.8/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-sRIl4kxILFvY47J16cr9ZwB07vP4J8+LH7qKQnuqkuIAvNWLzeN8tE5YBujZqJLB" crossorigin="anonymous">

</head>
<body>
<c:if test="${requestScope.MENSJIE!=null}">
  <div class="alert alert-warning alert-dismissible fade show" role="alert">
    <strong>${requestScope.MENSJIE}</strong>
    <button type="button" class="close" data-dismiss="alert" aria-label="Close">
      <span aria-hidden="true">&times;</span>
    </button>
  </div>
</c:if>

	<div class="container mt-5">
	    <h3>Registrar Distrito</h3>
	    <form action="ServletDistrito?operacion=REGISTRAR" method="post" id="form_registrar">
	      <div class="mb-3">
	        <label class="form-label">Nombre</label>
	        <input type="text" class="form-control" name="nombre" placeholder="Ingresar Nombre">
	      <button type="submit" class="btn btn-primary">Crear</button>
	      <a href="listarDistrito.jsp" class="btn btn-secondary">Lista</a>
	    </form>
   	</div>
   	
	<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
  	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.8/dist/js/bootstrap.bundle.min.js"></script>
  	<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery-validate/1.19.5/jquery.validate.min.js"></script>

	<!-- JQuery Validation -->
	<script src="https://cdn.jsdelivr.net/npm/jquery-validation@1.19.5/dist/jquery.validate.js"></script>
	<script src="https://cdn.jsdelivr.net/npm/jquery-validation@1.19.5/dist/jquery.validate.min.js"></script>
	<script src="https://cdn.jsdelivr.net/npm/jquery-validation@1.19.5/dist/additional-methods.js"></script>
	<script src="https://cdn.jsdelivr.net/npm/jquery-validation@1.19.5/dist/additional-methods.min.js"></script>

	<script>
	    // Validación personalizada: solo letras y espacios
	    $.validator.addMethod("soloLetras", function(value, element) {
	      return this.optional(element) || /^[a-zA-ZáéíóúÁÉÍÓÚñÑ\s]+$/.test(value);
	    }, "Este campo solo acepta letras");
	
	    // Inicializar validación del formulario
	    $('#form_registrar').validate({
	      rules: {
	        nombre: {
	          required: true,
	          soloLetras: true
	        },
	        
	      messages: {
	        nombre: {
	          required: 'El nombre es obligatorio'
	        },
	        
	      errorElement: 'span',
	      errorPlacement: function(error, element) {
	        error.addClass('invalid-feedback');
	        element.closest('.mb-3').append(error);
	      },
	      highlight: function(element) {
	        $(element).addClass('is-invalid');
	      },
	      unhighlight: function(element) {
	        $(element).removeClass('is-invalid');
	      }
	    });
	</script>



</body>
</html>