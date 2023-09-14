import java.util.LinkedList;
public class Registro {
    
    Estudiante Estudiante;
    LinkedList <Asignatura> listAsignatura;
    
    
    
    Registro(Estudiante codEstudiante){
        
        this.Estudiante = Estudiante;
        listAsignatura = new LinkedList<>();
    }
}
