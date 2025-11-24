<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Login - Instituto</title>
</head>
<body>

	<c:if test="${not empty requestScope.MENSAJE}">
	    <c:set var="tipo" value="${requestScope.TIPO_MENSAJE != null ? requestScope.TIPO_MENSAJE : 'info'}" />
	    <div class="alert alert-${tipo} alert-dismissible fade show" role="alert">
	      <strong>${requestScope.MENSAJE}</strong>
	      <button type="button" class="btn-close" data-bs-dismiss="alert" aria-label="Close"></button>
	    </div>
	 </c:if>

<h2 align="center">Sistema de Login</h2>

<form action="ServletEmpleado?accion=INICIAR" method="post">
    <table border="1" align="center" cellpadding="10">
        <tr>
            <td>Login:</td>
            <td><input type="text" name="txtLogin" required placeholder="Ingrese su usuario"></td>
        </tr>
        <tr>
            <td>Password:</td>
            <td><input type="password" name="txtPass" required placeholder="Ingrese su contraseña"></td>
        </tr>
        <tr>
            <td colspan="2" align="right">
                <input type="submit" value="Ingresar">
            </td>
        </tr>
    </table>
</form>

	<!-- Scripts -->
  <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
  <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.8/dist/js/bootstrap.bundle.min.js"></script>
  <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery-validate/1.19.5/jquery.validate.min.js"></script>

</body>
</html>
