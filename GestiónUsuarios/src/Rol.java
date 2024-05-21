import java.util.ArrayList;
import java.util.List;

// Clase Rol que representa un rol en el sistema, con una lista de permisos asociados
public class Rol {
    private String nombre;
    private List<String> permisos;

    // Constructor para inicializar un rol con su nombre
    public Rol(String nombre) {
        this.nombre = nombre;
        this.permisos = new ArrayList<>();
    }
    
    // Método para agregar un permiso a la lista de permisos del rol
    public void agregarPermiso(String permiso) {
        permisos.add(permiso);
    }
    
    // Método para verificar si el rol tiene un permiso específico
    public boolean tienePermiso(String permiso) {
        return permisos.contains(permiso);
    }

    // Método Getter para obtener el atributo nombre
    public String getNombre() {
        return nombre;
    }
    
    // Método Setter para establecer el atributo nombre
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    // Método Getter para obtener el atributo Permisos
    public List<String> getPermisos() {
        return permisos;
    }
    
    // Método Setter para establecer el atributo Permisos
    public void setPermisos(List<String> permisos) {
        this.permisos = permisos;
    }
}
