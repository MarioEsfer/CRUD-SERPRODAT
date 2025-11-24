package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import entidad.Alumno;
import entidad.Empleado;
import entidad.Menu;
import interfaces.EmpleadoDao;
import utils.MysqlDBConexion;

public class MysqlEmpleadoDao implements EmpleadoDao {

	@Override
	public Empleado iniciarSesion(String login, String clave) {
		Empleado bean = null;
		Connection cn = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		try {
			cn=MysqlDBConexion.getConexion();
			String sql = "select * from tb_empleado where login_emp=? AND clav_emp=?";
			pst=cn.prepareStatement(sql);
			pst.setString(1, login);
			pst.setString(2, clave);
			rs=pst.executeQuery();
			if (rs.next()) {
				bean= new Empleado();
				bean.setCodigo(rs.getInt(1));
				bean.setNombre(rs.getString(2));
				bean.setApellidos(rs.getString(3));
			}			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (cn !=null)
					cn.close();
				if (pst !=null)
					pst.close();
				if (rs !=null)
					rs.close();			
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return bean;
	}

	@Override
	public List<Menu> traerMenusDelEmpleado(int codEmp) {
		List<Menu> lista = new ArrayList<Menu>();
		Menu bean = null;
		Connection cn = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		try {
			cn=MysqlDBConexion.getConexion();
			String sql = "select a.cod_men, m.des_men, m.url_men from tb_acceso a join tb_menu m "
						+ "on a.cod_men=m.cod_men where a.cod_emp=?";
			pst=cn.prepareStatement(sql);
			pst.setInt(1, codEmp);
			rs=pst.executeQuery();
			while (rs.next()) {
				bean= new Menu();
				bean.setCodigo(rs.getInt(1));
				bean.setNombre(rs.getString(2));
				bean.setUrl(rs.getString(3));
                lista.add(bean);			
			}			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (cn !=null)
					cn.close();
				if (pst !=null)
					pst.close();
				if (rs !=null)
					rs.close();			
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		
		return lista;
	}

}
