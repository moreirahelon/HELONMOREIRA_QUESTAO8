package HELONMOREIRA_QUESTAO8;

import static org.junit.Assert.*;
import org.junit.Test;

public class Sprint_3Test {

	@Test
	public void testUsuarioAcessarSistema() {
		Biblioteca _Biblioteca = new Biblioteca();
		Usuario _Usuario = new Usuario("UsuarioTeste",true,0);
		Livro _Livro = new Livro("LivroTeste","Disponível");

		_Biblioteca.BD_Livros.add(_Livro);
		_Biblioteca.InserirNovoUsuario("UsuarioTeste");

		Usuario _UsuarioTest = null;
		for(Usuario u : _Biblioteca.BD_Usuario){
			if(u.GetNome() == "UsuarioTeste"){
				_UsuarioTest = u;
			}
		}

		assertEquals("UsuarioTeste", _UsuarioTest.GetNome());
		assertTrue(_UsuarioTest.GetUsuarioBloqueado());
		assertEquals(0,_UsuarioTest.GetTempoBloqueado());

		_Biblioteca.BloquearUsuario("UsuarioTeste", 18);

		assertEquals(18,_UsuarioTest.GetTempoBloqueado());
	}
	
	@Test
	public void testUsuarioPesquisaLivro(){
		Biblioteca _Biblioteca = new Biblioteca();
		Livro _Livro1 = new Livro("LivroTeste1","Retirado");
		Livro _Livro2 = new Livro("LivroTeste2","Disponível");
		Livro _Livro3 = new Livro("LivroTeste3","Extraviado");
		
		_Biblioteca.BD_Livros.add(_Livro1);
		_Biblioteca.BD_Livros.add(_Livro2);
		_Biblioteca.BD_Livros.add(_Livro3);
		
		assertEquals("Retirado",_Biblioteca.SituacaoDoLivro("LivroTeste1"));
		assertEquals("Disponível",_Biblioteca.SituacaoDoLivro("LivroTeste2"));
		assertEquals("Extraviado",_Biblioteca.SituacaoDoLivro("LivroTeste3"));
	}
}
