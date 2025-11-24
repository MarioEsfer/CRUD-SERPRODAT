package entidad;

import java.sql.Date;

public class Alumno {
    private int codigo;
    private String nombre;
    private String paterno;
    private String materno;
    private Date fecha;
    private int codigoDistrito;
    private String direccion;

    
    public Alumno() {}

    // Constructor con parámetros
    public Alumno(int codigo, String nombre, String paterno, String materno, Date fecha, int codigoDistrito, String direccion) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.paterno = paterno;
        this.materno = materno;
        this.fecha = fecha;
        this.codigoDistrito = codigoDistrito;
        this.direccion = direccion;
    }

    // Getters y Setters
    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPaterno() {
        return paterno;
    }

    public void setPaterno(String paterno) {
        this.paterno = paterno;
    }

    public String getMaterno() {
        return materno;
    }

    public void setMaterno(String materno) {
        this.materno = materno;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }
    
    public int getcodigoDistrito() {
        return codigoDistrito;
    }

    public void setcodigoDistrito(int codigoDistrito) {
        this.codigoDistrito = codigoDistrito;
    }
    
    public String getdireccion() {
        return direccion;
    }

    public void setdireccion(String direccion) {
        this.direccion = direccion;
    }
}
