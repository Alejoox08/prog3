
public class Estudiante {
    
    private String codigo;
    private String nombre;
    private String Correo;
    private int semestre;
    
    public Estudiante(String codigo, String nombre, String Correo, int semestre) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.Correo = Correo;
        this.semestre = semestre;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCorreo() {
        return Correo;
    }

    public void setCorreo(String Correo) {
        this.Correo = Correo;
    }

    public int getSemestre() {
        return semestre;
    }

    public void setSemestre(int semestre) {
        this.semestre = semestre;
    }
    
    
}
