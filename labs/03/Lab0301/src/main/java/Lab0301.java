import java.util.LinkedList;
import java.util.Queue;

public class Lab0301 {
    
    static Queue<Registro> regis = new LinkedList<>();
    public static void main(String[] args) {
        
        registro_estudiante();
        registro_asignaturas();
        reporte_registro_final();
        
    }
    
    public static void registro_estudiante(){
        
        String codigo = Entrada.readText("CODIGO ESTUDIANTIL: ");
        String nombre = Entrada.readText("NOMRBE DEL ESTUDIANTE: ");
        String Correo = Entrada.readText("CORREO ESTUDIANTE: ");
        int semestre = Entrada.readInt("SEMESTRE: ");
        
        Estudiante estud = new Estudiante(codigo, nombre, Correo, semestre);
        //crear registro con el codigo del estudiante (por ahora)
        //luego agregamos las asignaturas
        regis.add(new Registro(estud));
    }
    
    public static void registro_asignaturas(){
        
    }
    
    public static void reporte_registro_final(){
        
    }
    
}
