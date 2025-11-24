package fabrica;

import dao.MysqlDistritoDAO;
import dao.MysqlEmpleadoDao;
import dao.MysqlAlumnoDAO;
import interfaces.AlumnoDAO;
import interfaces.DistritoDAO;
import interfaces.EmpleadoDao;

public class MysqlDAOFactory extends DAOFactory {

	@Override
	public DistritoDAO getDistritoDAO() {
		// colocamos el nobre de la clase que se va a crear dentro del pq dao 
		//donde esta el desarrollo de los metodos
		return new MysqlDistritoDAO();
		
	}

	@Override
	public AlumnoDAO getAlumnoDAO() {
		// TODO Auto-generated method stub
		return new MysqlAlumnoDAO();
	}

	@Override
	public EmpleadoDao getEmpleadoDao() {
		// TODO Auto-generated method stub
		return new MysqlEmpleadoDao();
	}

}	