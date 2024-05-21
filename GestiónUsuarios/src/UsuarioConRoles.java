import java.util.ArrayList;
import java.util.List;

// Clase UsuarioConRoles que extiende la clase Usuario y agrega funcionalidad para roles
public class UsuarioConRoles extends Usuario {
    private List<Rol> roles;

    // Constructor para inicializar un usuario con roles
    public UsuarioConRoles(String nombre, String apellido, String correoElectronico, String contraseña) {
        super(nombre, apellido, correoElectronico, contraseña);
        this.roles = new ArrayList<>();
    }
    
    // Método para asignar un rol al usuario
    public void asignarRol(Rol rol) {
        roles.add(rol);
    }
    
    // Método para verificar si el usuario tiene un permiso específico
    public boolean tienePermiso(String permiso) {
        for (Rol rol : roles) {
            if (rol.tienePermiso(permiso)) {
                return true;
            }
        }
        return false;
    }
    
    // Métodos Getter y Setter para los roles del usuario
    public List<Rol> getRoles() {
        return roles;
    }

    public void setRoles(List<Rol> roles) {
        this.roles = roles;
    }
}
