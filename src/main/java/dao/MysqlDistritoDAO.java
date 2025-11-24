package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import entidad.Distrito;
import interfaces.DistritoDAO;
import utils.MysqlDBConexion;

public class MysqlDistritoDAO implements DistritoDAO {

	@Override
	public int saveDistrito(Distrito dis) {
		int estado = 0;
        Connection cn = null;
        PreparedStatement ps = null;
        try {
            cn = MysqlDBConexion.getConexion();
            String sql = "INSERT INTO tb_distrito (nom_dis) VALUES(?)";
            ps = cn.prepareStatement(sql);
            ps.setString(1, dis.getNombre());
            estado = ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try { 
            	if (ps != null) ps.close(); 
            	if (cn != null) cn.close();
            } catch (Exception e) {}
        }
        return estado;
	}

	@Override
	public int updateDistrito(Distrito dis) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int deleteDistrito(int codigo) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<Distrito> listDistrito() {
		Distrito bean = null;
		List<Distrito> lista = new ArrayList<Distrito>();
		Connection cn = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		try {
			cn = MysqlDBConexion.getConexion();
			String sql = "select * from tb_distrito";
			pst = cn.prepareStatement(sql);
			rs = pst.executeQuery();
			while (rs.next()) {
				bean = new Distrito();
				bean.setCodigo(rs.getInt(1));;
				bean.setNombre(rs.getString(2));
				lista.add(bean);
			}			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (cn !=null) cn.close();
				if (cn !=null) cn.close();
				if (cn !=null) cn.close();			
			} catch (Exception e2) {
				e2.printStackTrace();
			}
			
		}
		
		
		return lista;
	}

}
