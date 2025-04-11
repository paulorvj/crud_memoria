package usuario;

import static org.junit.Assert.assertNull;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDate;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import usuario.gerenciar.GerenciarUsuario;

class GerenciarUsuarioTests {

	private static GerenciarUsuario gerenciarUsuario;
	
	@BeforeEach
	void setUp() throws Exception {
		gerenciarUsuario = new GerenciarUsuario();
	}

	@Test
	void testCadastrar() {
		Usuario usuario = new Usuario();
		usuario.setNome("Chuck Norris");
		usuario.setCpf(12312312311L);
		usuario.setDataNascimento(LocalDate.of(2012, 12, 12));

		gerenciarUsuario.salvar(usuario);
		
		Usuario usuarioBd = gerenciarUsuario.findById(1);
		
		assertEquals("Chuck Norris", usuarioBd.getNome());
		assertEquals(12312312311L, usuarioBd.getCpf());
		assertEquals(LocalDate.of(2012, 12, 12),usuarioBd.getDataNascimento());
	}
	
	@Test
	void testAlterar() {
		Usuario usuario = new Usuario();
		usuario.setNome("Chuck Norris");
		usuario.setCpf(12312312311L);
		usuario.setDataNascimento(LocalDate.of(2012, 12, 12));

		gerenciarUsuario.salvar(usuario);
		
		Usuario usuarioBd = gerenciarUsuario.findById(1);
		
		usuarioBd.setNome("Novo nome");
		usuarioBd.setCpf(22222222222L);
		usuarioBd.setDataNascimento(LocalDate.of(2010, 10, 10));
		
		gerenciarUsuario.atualizar(usuarioBd);
		
		Usuario usuarioAtualizado = gerenciarUsuario.findById(1);
		
		assertEquals(usuarioBd.getNome(), usuarioAtualizado.getNome());
		assertEquals(usuarioBd.getCpf(), usuarioAtualizado.getCpf());
		assertEquals(usuarioBd.getDataNascimento(), usuarioAtualizado.getDataNascimento());
	}

	@Test
	void testListar() {
		Usuario usuarioUm = new Usuario();
		usuarioUm.setNome("Chuck Norris");
		usuarioUm.setCpf(12312312311L);
		usuarioUm.setDataNascimento(LocalDate.of(2012, 12, 12));
		
		Usuario usuarioDois = new Usuario();
		usuarioDois.setNome("Novo nome");
		usuarioDois.setCpf(22222222222L);
		usuarioDois.setDataNascimento(LocalDate.of(2010, 10, 10));
		
		gerenciarUsuario.salvar(usuarioUm);
		gerenciarUsuario.salvar(usuarioDois);
		
		List<Usuario> usuarios = gerenciarUsuario.listar();
		assertEquals(2, usuarios.size());
	}
	
	@Test
	void testRemover() {
		Usuario usuarioUm = new Usuario();
		usuarioUm.setNome("Chuck Norris");
		usuarioUm.setCpf(12312312311L);
		usuarioUm.setDataNascimento(LocalDate.of(2012, 12, 12));
		
		gerenciarUsuario.salvar(usuarioUm);
		
		List<Usuario> usuarios = gerenciarUsuario.listar();
		assertEquals(1, usuarios.size());
		
		gerenciarUsuario.remover(1);
		
		Usuario usuario = gerenciarUsuario.findById(1);
		
		assertNull(usuario);
	}


}
