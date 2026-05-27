package usuarios.dao;

import usuarios.model.Usuario;
import java.util.List;

/**
 * Interfaz que define las operaciones de persistencia para los usuarios.
 * Sigue el patrón Data Access Object (DAO) para desacoplar la lógica de negocio del almacenamiento.
 */
public interface UsuarioDAO {
    /**
     * Registra un nuevo usuario en la base de datos.
     * @param usuario Objeto con los datos del jugador a insertar.
     */
    void insertar(Usuario usuario);

    /**
     * Recupera todos los usuarios registrados en el sistema.
     * @return Una lista de objetos {@link Usuario}.
     */
    List<Usuario> listarTodos();

    /**
     * Actualiza la información de un usuario existente.
     * @param usuario Objeto con los nuevos datos y el ID correspondiente.
     */
    void modificar(Usuario usuario);

    /**
     * Elimina de forma permanente un usuario mediante su ID.
     * @param idUsuario Identificador único del usuario a borrar.
     */
    void eliminar(int idUsuario);
}
