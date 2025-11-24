package entidad;

public class Empleado {
    private int codigo;
    private String nombre;
    private String apellidos;
    private String login;
    private String clave;

    // Constructor vacío
    public Empleado() {}

    // Constructor con parámetros
    public Empleado(int codigo, String nombre, String apellidos, String login, String clave) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.login = login;
        this.clave = clave;
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

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }
}
