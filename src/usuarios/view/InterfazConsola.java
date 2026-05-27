package usuarios.view;

import usuarios.model.Usuario;
import java.util.List;

/**
 * Clase encargada de la interacción directa con el usuario mediante consola.
 * Gestiona la entrada y salida de datos (Vista).
 */
public class InterfazConsola {
    
    /**
     * Imprime en pantalla el menú principal con las opciones del sistema.
     */
    public void mostrarMenu() {
        System.out.println("\n--- LEVELUP ARCADE ---");
        System.out.println("1. Registrar Usuario");
        System.out.println("2. Listar Usuarios");
        System.out.println("3. Modificar Usuario");
        System.out.println("4. Eliminar Usuario");
        System.out.println("5. Salir");
        System.out.print("Selecciona una opción: ");
    }

    /**
     * Muestra una tabla formateada con los datos de los usuarios.
     * @param usuarios Lista de usuarios a representar en pantalla.
     */
    public void mostrarUsuarios(List<Usuario> usuarios) {
        if (usuarios.isEmpty()) {
            System.out.println("No hay usuarios registrados.");
            return;
        }
        System.out.println("\n--- LISTADO DE JUGADORES ---");
        System.out.printf("%-5s %-15s %-20s\n", "ID", "USERNAME", "EMAIL");
        for (Usuario u : usuarios) {
            System.out.printf("%-5d %-15s %-20s\n", u.getIdUsuario(), u.getUsername(), u.getEmail());
        }
    }
}