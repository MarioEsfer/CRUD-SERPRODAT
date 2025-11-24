package service;

import java.util.List;

import entidad.Empleado;
import entidad.Menu;
import fabrica.DAOFactory;
import interfaces.EmpleadoDao;

public class EmpleadoService {
		DAOFactory fabrica = DAOFactory.getDAOFactory(1);
		
		EmpleadoDao daoEmpleado = fabrica.getEmpleadoDao();
		
		public Empleado iniciarSesion(String login, String clave) {
			return daoEmpleado.iniciarSesion(login, clave);
		} 
		
		public List<Menu> traerMenusDelEmpleado(int codEmp) {
			return daoEmpleado.traerMenusDelEmpleado(codEmp);
		}
		
}
