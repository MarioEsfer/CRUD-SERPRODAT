package controlador;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import service.DistritoService;

import java.io.IOException;
import java.util.List;

import dao.MysqlAlumnoDAO;
import dao.MysqlDistritoDAO;
import entidad.Distrito;

/**
 * Servlet implementation class ServletDistrito
 */
@WebServlet("/ServletDistrito")
public class ServletDistrito extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    DistritoService servicioDistrito = new DistritoService();
	
    public ServletDistrito() {
        super();
        // TODO Auto-generated constructor stub
    }


	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String tipo = request.getParameter("operacion");
		
		if (tipo.equals("REGISTRAR")) {
			registrar(request,response);
		}
		
		
	}

	private void registrar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//nom almacena el valor de la caja nombre
		String nom = request.getParameter("nombre");
		
		//Crear un objeto de la clase Distrito
		//Lo que capturamos de la pagina son datos del distrito
		Distrito dis = new Distrito();
		
		//Setear los atributos del objeto dis
		dis.setNombre(nom);
		
		//Creamos un objeto global para invocar el metodo registrarDistrito que contienen el saveDistrito
		//que contienen el saveDistrito
		int salida = servicioDistrito.registrarDistrito(dis);
		
		//Vañdar el valor de salida
		if (salida != -1) {
			request.setAttribute("MENSAJE", "Registro Exitoso");
			request.setAttribute("TIPO_MENSAJE", "success");
		}else {
			request.setAttribute("MENSAJE", "Registro erroneo");
			request.setAttribute("TIPO_MENSAJE", "danger");
		}
		
		request.getRequestDispatcher("/registrarDistrito.jsp").forward(request, response);
		
	}

}
