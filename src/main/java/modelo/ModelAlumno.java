package modelo;

import java.sql.*;
import java.util.*;

import entidad.Alumno;
import utils.MysqlDBConexion;

public class ModelAlumno {

    // 1️⃣ Registrar alumno
    public int registrarAlumno(Alumno obj) {
        int estado = 0;
        Connection cn = null;
        PreparedStatement ps = null;
        try {
            cn = MysqlDBConexion.getConexion();
            String sql = "INSERT INTO tb_alumno (nom_alu, ape_pat_alu, ape_mat_alu, fec_nac_alu) VALUES (?, ?, ?, ?)";
            ps = cn.prepareStatement(sql);
            ps.setString(1, obj.getNombre());
            ps.setString(2, obj.getPaterno());
            ps.setString(3, obj.getMaterno());
            ps.setDate(4, obj.getFecha());
            estado = ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try { if (ps != null) ps.close(); if (cn != null) cn.close(); } catch (Exception e) {}
        }
        return estado;
    }

    // 2️⃣ Listar todos los alumnos
    public List<Alumno> listar() {
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
                a.setCodigo(rs.getInt("cod_alu"));
                a.setNombre(rs.getString("nom_alu"));
                a.setPaterno(rs.getString("ape_pat_alu"));
                a.setMaterno(rs.getString("ape_mat_alu"));
                a.setFecha(rs.getDate("fec_nac_alu"));
                lista.add(a);
  
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
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

    // 3️⃣ Buscar alumno por código
    public Alumno buscarAlumno(int cod) {
        Alumno a = null;
        Connection cn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            cn = MysqlDBConexion.getConexion();
            String sql = "SELECT * FROM tb_alumno WHERE cod_alu = ?";
            ps = cn.prepareStatement(sql);
            ps.setInt(1, cod);
            rs = ps.executeQuery();
            if (rs.next()) {
                a = new Alumno();
                a.setCodigo(rs.getInt("cod_alu"));
                a.setNombre(rs.getString("nom_alu"));
                a.setPaterno(rs.getString("ape_pat_alu"));
                a.setMaterno(rs.getString("ape_mat_alu"));
                a.setFecha(rs.getDate("fec_nac_alu"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try { if (rs != null) rs.close(); if (ps != null) ps.close(); if (cn != null) cn.close(); } catch (Exception e) {}
        }
        return a;
    }

    // 4️⃣ Actualizar alumno
    public int actualizarAlumno(Alumno obj) {
        int estado = 0;
        Connection cn = null;
        PreparedStatement ps = null;
        try {
            cn = MysqlDBConexion.getConexion();
            String sql = "UPDATE tb_alumno SET nom_alu=?, ape_pat_alu=?, ape_mat_alu=?, fec_nac_alu=? WHERE cod_alu=?";
            ps = cn.prepareStatement(sql);
            ps.setString(1, obj.getNombre());
            ps.setString(2, obj.getPaterno());
            ps.setString(3, obj.getMaterno());
            ps.setDate(4, obj.getFecha());
            ps.setInt(5, obj.getCodigo());
            estado = ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try { if (ps != null) ps.close(); if (cn != null) cn.close(); } catch (Exception e) {}
        }
        return estado;
    }

    // 5️⃣ Eliminar alumno
    public int eliminarAlumno(int cod) {
        int estado = 0;
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
}
