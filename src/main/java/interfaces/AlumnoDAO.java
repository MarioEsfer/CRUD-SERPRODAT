package interfaces;



import java.util.List;

import entidad.Alumno;

public interface AlumnoDAO {
	//sirve para definir metodos, solo se definen los metodos
		public int saveAlumno(Alumno obj);
		public int updateAlumno(Alumno obj);
		public int deleteAlumno(int codigo);
		public Alumno findAlumno(int codigo);
		List<Alumno> listarAlumno();
		List<Alumno> listarAlumnoPorApellido(String ape);

}
