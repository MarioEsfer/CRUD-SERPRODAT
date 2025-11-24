/*package modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import entidad.Empleado;
import utils.MysqlDBConexion;


public class ModelEmpleado {

    public Empleado iniciarSesion(String log, String pas) {
        Empleado obj = null;
        Connection cn = null;
        ResultSet rs = null;
        PreparedStatement pstn = null;

        try {
            String sql = "SELECT * FROM tb_empleado WHERE login_emp=? AND clave_emp=?";
            cn = MysqlDBConexion.getConexion();
            pstn = cn.prepareStatement(sql);
            pstn.setString(1, log);
            pstn.setString(2, pas);
            rs = pstn.executeQuery();

            if (rs.next()) {
                obj = new Empleado();
                obj.setCodigo(rs.getInt(1));         // cod_emp
                obj.setNombre(rs.getString(2));      // nom_emp
                obj.setApellidos(rs.getString(3));   // ape_emp
                obj.setLogin(rs.getString(4));       // login_emp
                obj.setClave(rs.getString(5));       // clave_emp
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (rs != null) rs.close();
                if (pstn != null) pstn.close();
                if (cn != null) cn.close();
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }

        return obj;
    }
}*/
