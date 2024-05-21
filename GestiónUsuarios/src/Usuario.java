import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

// Clase Usuario que representa un usuario en el sistema
public class Usuario {
    private String nombre;
    private String apellido;
    private String correoElectronico;
    private String contraseñaHash; // Almacena el hash de la contraseña
    
    // Creación del construcor de la clase Usuario
    public Usuario(String nombre, String apellido, String correoElectronico, String contraseña) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.correoElectronico = correoElectronico;
        this.contraseñaHash = encriptarContraseña(contraseña); // Encripta la contraseña al crear el usuario
    }
    // Método Getter para obtener el atributo nombre
    public String getNombre() {
        return nombre;
    }
    
    // Método Setter para establecer el atributo nombre
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    // Método Getter para obtener el atributo apellido
    public String getApellido() {
        return apellido;
    }

    // Método Setter para establecer el atributo apellido
    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    // Método Getter para obtener el atributo correoElectronico
    public String getCorreoElectronico() {
        return correoElectronico;
    }
    
    // Método Setter para establecer el atributo correoElectronico
    public void setCorreoElectronico(String correoElectronico) {
        this.correoElectronico = correoElectronico;
    }

    // Método para verificar si una contraseña introducida coincide con la almacenada
    public boolean verificarContraseña(String contraseña) {
        return encriptarContraseña(contraseña).equals(contraseñaHash);
    }

    // Método privado para encriptar una contraseña usando SHA-256
    private String encriptarContraseña(String contraseña) {
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            byte[] hash = md.digest(contraseña.getBytes());
            StringBuilder hexString = new StringBuilder();
            for (byte b : hash) {
                String hex = Integer.toHexString(0xff & b);
                if (hex.length() == 1) hexString.append('0');
                hexString.append(hex);
            }
            return hexString.toString();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            return null;
        }
    }
}
