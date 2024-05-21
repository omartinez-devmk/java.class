import java.util.Scanner;

public class GestiónUsuarios {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Pedir al usuario los detalles
        System.out.print("Ingrese el nombre: ");
        String nombre = scanner.nextLine();

        System.out.print("Ingrese el apellido: ");
        String apellido = scanner.nextLine();

        System.out.print("Ingrese el correo electrónico: ");
        String correoElectronico = scanner.nextLine();

        // Pedir la contraseña
        System.out.print("Ingrese la contraseña: ");
        String contraseña = scanner.nextLine();

        // Crear un nuevo usuario con roles
        UsuarioConRoles usuario = new UsuarioConRoles(nombre, apellido, correoElectronico, contraseña);

        // Crear un nuevo rol y asignarle permisos
        Rol rolAdmin = new Rol("Admin");
        rolAdmin.agregarPermiso("crear_usuario");
        rolAdmin.agregarPermiso("eliminar_usuario");

        // Asignar el rol al usuario
        usuario.asignarRol(rolAdmin);

        // Verificar la contraseña del usuario ingresada nuevamente para validación
        System.out.print("Verifique la contraseña: ");
        String contraseñaVerificacion = scanner.nextLine();

        if (usuario.verificarContraseña(contraseñaVerificacion)) {
            System.out.println("La contraseña es correcta.");
        } else {
            System.out.println("La contraseña es incorrecta.");
        }

        // Verificar si el usuario tiene un permiso específico
        if (usuario.tienePermiso("crear_usuario")) {
            System.out.println("El usuario tiene permiso para crear usuarios.");
        } else {
            System.out.println("El usuario no tiene permiso para crear usuarios.");
        }

        scanner.close();
    }
}

