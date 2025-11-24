package controlador;

import java.util.List;
import java.io.IOException;
import java.sql.Date;

import entidad.Alumno;
import entidad.Distrito;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import modelo.ModelAlumno;
import service.AlumnoService;
import service.DistritoService;

@WebServlet("/ServletAlumno")
public class ServletAlumno extends HttpServlet {
    private static final long serialVersionUID = 1L;
    
    
    AlumnoService servicioAlumno = new AlumnoService();
    DistritoService servicioDistrito = new DistritoService();
    
    public ServletAlumno() {
    	super();
    }

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String tipo = request.getParameter("accion");

        if (tipo.equals("LISTAR")) {
            listarAlumno(request, response);
        } else if (tipo.equals("REGISTRAR")) {
        	registrarAlumno(request, response);
        } else if (tipo.equals("BUSCAR")) {
            buscarAlumno(request, response);
        } else if (tipo.equals("ACTUALIZAR")) {
            actualizarAlumno(request, response);
        } else if (tipo.equals("ELIMINAR")) {
            eliminarAlumno(request, response);
        } else if (tipo.equals("LISTAR_DISTRITO")) {
			listarDistrito(request,response);
		}
    }
    
    private void listarDistrito(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Distrito> lista = servicioDistrito.listarDistrito();
		
		request.setAttribute("distritos", lista);
		request.getRequestDispatcher("/registrarAlumno.jsp").forward(request, response);
	}

    private void listarAlumno(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        List<Alumno> lista = servicioAlumno.listAlumno();
        
        //Para la lista envarla a la pagina, se crea un atributo q almacene el valor de lista
        request.setAttribute("alumnos", lista);
        request.getRequestDispatcher("/listarAlumno.jsp").forward(request, response);
    }

    private void registrarAlumno(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String nom = request.getParameter("nombre");
        String pat = request.getParameter("apellidoPa");
        String mat = request.getParameter("apellidoMa");
        String fecha = request.getParameter("fechaNac");
        String dis = request.getParameter("distrito");
        String dir = request.getParameter("direccion");
        
        //Crear un objeto de la clase Alumno ya que lo que acabamos de capturar 
        //son datos de un alumno
        Alumno obj = new Alumno();

        //Setear los atributos del objeto obj
        obj.setNombre(nom);
        obj.setPaterno(pat);
        obj.setMaterno(mat);
        if (fecha != null && !fecha.isEmpty()) {
            obj.setFecha(Date.valueOf(fecha));
        }
        obj.setcodigoDistrito(Integer.parseInt(dis));
        obj.setdireccion(dir);

        int estado = servicioAlumno.registrarAlumno(obj);
        
        if (estado != -1) {
			request.setAttribute("MENSAJE", "Registro exitoso");
			request.setAttribute("TIPO_MENSAJE", "success");
		} else {
			request.setAttribute("MENSAJE", "Error al registrar");
			request.setAttribute("TIPO_MENSAJE", "danger");
		}    
        
        request.getRequestDispatcher("registrarAlumno.jsp").forward(request, response);
        
    }

    private void buscarAlumno(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //Obtener el codigo de docente a buscar
    	String cod = request.getParameter("codigo");
  
    	//Declarar un objeto de la clase docente para llamar al metodo bus y le pasamos el cod
        Alumno a = servicioAlumno.buscarAlumno(Integer.parseInt(cod));
        request.setAttribute("registro", a);
        
        List<Distrito> lista = servicioDistrito.listarDistrito();
        request.setAttribute("distritos", lista);
        
        request.getRequestDispatcher("/actualizarAlumno.jsp").forward(request, response);
        
        
    }

    private void actualizarAlumno(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String codigo = request.getParameter("codigo");
        String nom = request.getParameter("nombre");
        String pat = request.getParameter("apellidoPa");
        String mat = request.getParameter("apellidoMa");
        String fecha = request.getParameter("fecNac");
        String dis = request.getParameter("distrito");
        String dir = request.getParameter("direccion");
        
        Alumno obj = new Alumno();
        
        obj.setCodigo(Integer.parseInt(codigo));
        obj.setNombre(nom);
        obj.setPaterno(pat);
        obj.setMaterno(mat);
        if (fecha != null && !fecha.isEmpty()) {
            obj.setFecha(Date.valueOf(fecha));
        }
        obj.setcodigoDistrito(Integer.parseInt(dis));
        obj.setdireccion(dir);

        int estado = servicioAlumno.actualizarAlumno(obj);
        
        if (estado != -1) {
            request.setAttribute("MENSAJE", "Se actualizo correctamente");
            request.setAttribute("TIPO_MENSAJE", "success");
        } else {
        	request.setAttribute("MENSAJE", "Error en la actualizacion");
        	request.setAttribute("TIPO_MENSAJE", "danger");
        }
        
        request.getRequestDispatcher("actualizarAlumno.jsp").forward(request, response);
        
    }

    private void eliminarAlumno(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //Obtener el codigo el docente a eliminar
    	String cod = request.getParameter("codigo");
        
        servicioAlumno.eliminarAlumno(Integer.parseInt(cod));
        
        //Llamamos al metodo listarAlumno xq hace que se ejecute el getRequestDispatcher
        //Donde se le envia el atributo alumnos
        listarAlumno(request, response);
    }
    
    
    
    
}
