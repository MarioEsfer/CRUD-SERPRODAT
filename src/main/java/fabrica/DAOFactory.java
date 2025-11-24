package fabrica;

import interfaces.AlumnoDAO;
import interfaces.DistritoDAO;
import interfaces.EmpleadoDao;

public abstract class DAOFactory {
	// Constantes para identificar el tipo de base de datos
    public static final int MYSQL = 1;
    public static final int ORACLE = 2;
    public static final int DB2 = 3;
    public static final int SQLSERVER = 4;
    public static final int XML = 5;
    
    // Existirá un método get por cada DAO que exista en el sistema
    //SE REGISTRAN LAS INTERFACES DAO QUE ESTAMOS HACIENDO 
    public abstract DistritoDAO getDistritoDAO();
    public abstract AlumnoDAO getAlumnoDAO();
    public abstract EmpleadoDao getEmpleadoDao();
    
    public static DAOFactory getDAOFactory(int whichFactory) {
        switch (whichFactory) {
            case MYSQL:
            	//Creamos la clase para trabajar con MYSQL
                return new MysqlDAOFactory();
            case ORACLE:
                //return new OracleDAOFactory();
            /*case DB2:
                return new Db2DAOFactory();
            case SQLSERVER:
                return new SqlServerDAOFactory();
            case XML:
                return new XmlDAOFactory();*/
            default:
                return null;
        }
    }
}
