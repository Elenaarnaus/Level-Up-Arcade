package usuarios.model;

/**
 * Representa la entidad de un usuario o jugador dentro del sistema Arcade.
 * Contiene la información básica del perfil y credenciales.
 * * @author TuNombre
 * @version 1.0
 */
public class Usuario {
    private int idUsuario;
    private String username;
    private String password;
    private String email;

    /**
     * Constructor para crear un nuevo usuario con sus datos principales.
     * @param username Nombre único de usuario en la plataforma.
     * @param password Contraseña de acceso (se recomienda almacenar el hash).
     * @param email Correo electrónico de contacto.
     */
    public Usuario(String username, String password, String email) {
        this.username = username;
        this.setPassword(password);
        this.email = email;
    }

    /** @return El nombre de usuario. */
    public String getUsername() { return username; }
    
    /** @return El correo electrónico. */
    public String getEmail() { return email; }
    
    /** @return El ID único generado por la base de datos. */
    public int getIdUsuario() { return idUsuario; }
    
    /** @param idUsuario Establece el ID del usuario tras la consulta SQL. */
    public void setIdUsuario(int idUsuario) { this.idUsuario = idUsuario; }

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
}
