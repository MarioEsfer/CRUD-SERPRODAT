package controlador;

import java.io.IOException;
import java.util.List;

import entidad.Empleado;
import entidad.Menu;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import service.EmpleadoService;

@WebServlet("/ServletEmpleado")
public class ServletEmpleado extends HttpServlet {	
    private static final long serialVersionUID = 1L;
    
    EmpleadoService EmpleadoService = new EmpleadoService();

    public ServletEmpleado() {
        super();
    }

    protected void service(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    	String tipo = request.getParameter("accion");
    	
    	if (tipo.equals("INICIAR")) {
    		iniciarSesionEmpleado(request, response);
    	} else if (tipo.equals("CERRAR")) {
    		cerrarSesionEmpleado(request, response);
    	}
    }

	private void iniciarSesionEmpleado(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String login = request.getParameter("txtLogin");
		String clave = request.getParameter("txtPass");
		
		Empleado bean = EmpleadoService.iniciarSesion(login, clave);
		//validar el objeto bean
		if (bean != null) {
			//Obtener el codigo del usuario que inicia sesio
			int codEmp = bean.getCodigo();
			//obtener lista de los menús
		    List<Menu> lista = EmpleadoService.traerMenusDelEmpleado(codEmp);
		    //crear una sesión
		    HttpSession session = request.getSession();
		    //crear un atributo dentro del objeto "session"
		    session.setAttribute("menus", lista);
		    //direccionar a la página menu.jsp
		    request.getRequestDispatcher("/menu.jsp").forward(request, response);
		} 
		else {
		    request.setAttribute("MENSAJE", "usuario y/o clave incorrectos");
		    //direccionar a la página menu.jsp
		    request.getRequestDispatcher("/index.jsp").forward(request, response);
		}
		
	}
	
	private void cerrarSesionEmpleado(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		session.invalidate();
		
		request.getRequestDispatcher("/index.jsp").forward(request, response);
		
	}
	
}
