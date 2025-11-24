package service;

import java.util.List;
import entidad.Distrito;
import fabrica.DAOFactory;
import interfaces.DistritoDAO;

public class DistritoService {
	//1. Definir el gestor de BD vamos a trabajar del DAOFactory q es la principal
	//Se le envia el parametro 1 que es Mysql
	DAOFactory fabrica = DAOFactory.getDAOFactory(1);
	
	//2. Definir con que DAO de interfaces se va a trabajar q se registro en la fabrica
	DistritoDAO daoDistrito = fabrica.getDistritoDAO();
	
	//3. Creamos un metodo que se comuniq con el metodo implementado de MysqlDistritoDAO
	public int registrarDistrito(Distrito dis) {
		return daoDistrito.saveDistrito(dis);
	}
	
	public List<Distrito> listarDistrito(){
		return daoDistrito.listDistrito();
	}
	
}
