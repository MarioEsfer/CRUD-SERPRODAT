package interfaces;

import java.util.ArrayList;
import java.util.List;

import entidad.Distrito;

public interface DistritoDAO {
	//sirve para definir metodos, solo se definen los metodos
	public int saveDistrito(Distrito dis);
	public int updateDistrito(Distrito dis);
	public int deleteDistrito(int codigo);
	public List<Distrito> listDistrito();	
}	
