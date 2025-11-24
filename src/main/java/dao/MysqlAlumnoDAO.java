package dao;

import java.sql.*;
import java.util.*;

import entidad.Alumno;
import interfaces.AlumnoDAO;
import utils.MysqlDBConexion;

public class MysqlAlumnoDAO implements AlumnoDAO{

    // 1️⃣ Registrar alumno
	@Override
    public int saveAlumno(Alumno obj) {
        int estado = 0;
        Connection cn = null;
        PreparedStatement ps = null;
        try {
            cn = MysqlDBConexion.getConexion();
            String sql = "INSERT INTO tb_alumno VALUES (NULL, ?, ?, ?, ?, ?, ?)";
            ps = cn.prepareStatement(sql);
            ps.setString(1, obj.getNombre());
            ps.setString(2, obj.getPaterno());
            ps.setString(3, obj.getMaterno());
            ps.setDate(4, obj.getFecha());
            ps.setInt(5, obj.getcodigoDistrito());
            ps.setString(6, obj.getdireccion());
            estado = ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try { 
            	if (ps != null) ps.close(); 
            	if (cn != null) cn.close(); 
            } catch (Exception e2) {
            	e2.printStackTrace();
            }
        }
        return estado;
    }    

    // 3️⃣ Buscar alumno por código
    @Override
    public Alumno findAlumno(int codigo) {
    	Alumno a = null;
        Connection cn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            cn = MysqlDBConexion.getConexion();
            String sql = "SELECT * FROM tb_alumno WHERE cod_alu=?";
            ps = cn.prepareStatement(sql);
            ps.setInt(1, codigo);
            rs = ps.executeQuery();
            if (rs.next()) {
                a = new Alumno();
                a.setCodigo(rs.getInt("cod_alu"));
                a.setNombre(rs.getString("nom_alu"));
                a.setPaterno(rs.getString("ape_pat_alu"));
                a.setMaterno(rs.getString("ape_mat_alu"));
                a.setFecha(rs.getDate("fec_nac_alu"));
                a.setcodigoDistrito(rs.getInt("cod_dis"));
                a.setdireccion(rs.getString("dir_alu"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try { 
            	if (rs != null) rs.close(); 
            	if (ps != null) ps.close(); 
            	if (cn != null) cn.close(); 
            } catch (Exception e2) {
            	e2.printStackTrace();
            }
        }
        return a;
    }

    // 4️⃣ Actualizar alumno
    @Override
    public int updateAlumno(Alumno obj) {
        int estado = -1;
        Connection cn = null;
        PreparedStatement ps = null;
        try {
            cn = MysqlDBConexion.getConexion();
            String sql = "UPDATE tb_alumno SET nom_alu=?, ape_pat_alu=?, ape_mat_alu=?, fec_nac_alu=?,"+ 
            									"cod_dis=?, dir_alu=? WHERE cod_alu=?";
            ps = cn.prepareStatement(sql);
            ps.setString(1, obj.getNombre());
            ps.setString(2, obj.getPaterno());
            ps.setString(3, obj.getMaterno());
            ps.setDate(4, obj.getFecha());        
            ps.setInt(5, obj.getcodigoDistrito());
            ps.setString(6, obj.getdireccion());
            ps.setInt(7, obj.getCodigo());
            estado = ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try { if (ps != null) ps.close(); if (cn != null) cn.close(); } catch (Exception e) {}
        }
        return estado;
    }

    // 5️⃣ Eliminar alumno
    @Override
    public int deleteAlumno(int cod) {
        int estado = -1;
        Connection cn = null;
        PreparedStatement ps = null;
        try {
            cn = MysqlDBConexion.getConexion();
            String sql = "DELETE FROM tb_alumno WHERE cod_alu=?";
            ps = cn.prepareStatement(sql);
            ps.setInt(1, cod);
            estado = ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try { if (ps != null) ps.close(); if (cn != null) cn.close(); } catch (Exception e) {}
        }
        return estado;
    }

	

	@Override
	public List<Alumno> listarAlumno() {
		Alumno a = null;
        List<Alumno> lista = new ArrayList<Alumno>();
        Connection cn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            cn = MysqlDBConexion.getConexion();
            String sql = "SELECT * FROM tb_alumno";
            ps = cn.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                a = new Alumno();
                a.setCodigo(rs.getInt(1));
                a.setNombre(rs.getString(2));
                a.setPaterno(rs.getString(3));
                a.setMaterno(rs.getString(4));
                a.setFecha(rs.getDate(5));
                a.setcodigoDistrito(rs.getInt(6));
                a.setdireccion(rs.getString(7));
                lista.add(a);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally  {
			try {
				if (rs != null) 
					rs.close();
				if (ps != null) 
					ps.close();
				if (cn != null) 
					cn.close();			
			} catch (Exception e2) {
				e2.printStackTrace();
			} 
		}
        return lista;
	}

	@Override
	public List<Alumno> listarAlumnoPorApellido(String ape) {
		List<Alumno> lista = new ArrayList<Alumno>();
		Alumno bean = null;
		Connection cn = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		try {
			cn=MysqlDBConexion.getConexion();
			String sql = "select * from tb_alumno where concat(ape_pat_alu, ' ', ape_mat_alu) like ?";
			pst=cn.prepareStatement(sql);
			pst.setString(1, ape+"%");
			rs=pst.executeQuery();
			while (rs.next()) {
				bean= new Alumno();
				bean.setCodigo(rs.getInt(1));
				bean.setNombre(rs.getString(2));
				bean.setPaterno(rs.getString(3));
				bean.setMaterno(rs.getString(4));
				bean.setFecha(rs.getDate(5));
				bean.setcodigoDistrito(rs.getInt(6));
				bean.setdireccion(rs.getString(7));
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
