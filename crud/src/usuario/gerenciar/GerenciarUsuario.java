package usuario.gerenciar;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import usuario.Usuario;

public class GerenciarUsuario {

	private HashMap<Integer, Usuario> usuariosBD;
	private int id;
	
	public GerenciarUsuario() {
		usuariosBD = new HashMap<>();
		id = 0;
	}
	
	public void salvar(Usuario usuario) {
		id++;
		usuario.setId(id);
		usuariosBD.put(id, usuario);
	}
	
	public void atualizar(Usuario usuario) {
		usuariosBD.put(usuario.getId(), usuario);
	}
	
	public List<Usuario> listar() {
		List<Usuario> usuarios = new ArrayList<>(usuariosBD.values());
		return usuarios;
	}
	
	public void remover(int id) {
		usuariosBD.remove(id);
	}
	
	public Usuario findById(int id) {
		return usuariosBD.get(id);
	}
}
