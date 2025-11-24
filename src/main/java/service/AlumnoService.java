package service;



import java.util.List;

import entidad.Alumno;
import fabrica.DAOFactory;
import interfaces.AlumnoDAO;

public class AlumnoService {
	//1. Definir el gestor de BD vamos a trabajar del DAOFactory q es la principal
		//Se le envia el parametro 1 que es Mysql
	DAOFactory fabrica = DAOFactory.getDAOFactory(1);
	
	//2. Definir con que DAO de interfaces se va a trabajar q se registro en la fabrica
	AlumnoDAO daoAlumno = fabrica.getAlumnoDAO();
	
	//3. Creamos un metodo que se comuniq con el metodo implementado de MysqlDistritoDAO
	public int registrarAlumno(Alumno obj) {
		return daoAlumno.saveAlumno(obj);
	}
	
	public List<Alumno> listAlumno() {
		return daoAlumno.listarAlumno();
	}
	
	public int actualizarAlumno(Alumno obj) {
		return daoAlumno.updateAlumno(obj);
	}
	
	public Alumno buscarAlumno(int cod) {
		return daoAlumno.findAlumno(cod);
	}
	
	public int eliminarAlumno(int cod) {
		return daoAlumno.deleteAlumno(cod);
	}
	
	
}
