package usuarios.dao;

import usuarios.model.Usuario;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UsuarioDAOImpl implements UsuarioDAO {
    
    @Override
    public void insertar(Usuario usuario) {
        String sql = "INSERT INTO usuarios (username, password, email) VALUES (?, ?, ?)";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, usuario.getUsername());
            ps.setString(2, usuario.getPassword());
            ps.setString(3, usuario.getEmail());
            ps.executeUpdate();
        } catch (SQLException e) { e.printStackTrace(); }
    }

    @Override
    public List<Usuario> listarTodos() {
        List<Usuario> lista = new ArrayList<>();
        String sql = "SELECT * FROM usuarios";
        try (Connection conn = DatabaseConnection.getConnection();
             Statement st = conn.createStatement();
             ResultSet rs = st.executeQuery(sql)) {
            while (rs.next()) {
                Usuario u = new Usuario(rs.getString("username"), rs.getString("password"), rs.getString("email"));
                u.setIdUsuario(rs.getInt("id_usuario"));
                lista.add(u);
            }
        } catch (SQLException e) { e.printStackTrace(); }
        return lista;
    }

    @Override
    public void modificar(Usuario usuario) {
        String sql = "UPDATE usuarios SET username = ?, email = ? WHERE id_usuario = ?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, usuario.getUsername());
            ps.setString(2, usuario.getEmail());
            ps.setInt(3, usuario.getIdUsuario());
            ps.executeUpdate();
        } catch (SQLException e) { e.printStackTrace(); }
    }

    @Override
    public void eliminar(int idUsuario) {
        String sql = "DELETE FROM usuarios WHERE id_usuario = ?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, idUsuario);
            ps.executeUpdate();
        } catch (SQLException e) { e.printStackTrace(); }
    }
}
