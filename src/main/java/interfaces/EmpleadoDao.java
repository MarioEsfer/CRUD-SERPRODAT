package interfaces;

import java.util.List;

import entidad.Empleado;
import entidad.Menu;

public interface EmpleadoDao {
		public Empleado iniciarSesion(String login, String clave);
		public List<Menu> traerMenusDelEmpleado(int codEmp);
}













