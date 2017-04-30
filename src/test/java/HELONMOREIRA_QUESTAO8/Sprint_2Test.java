package HELONMOREIRA_QUESTAO8;

import static org.junit.Assert.*;
import org.junit.Test;

public class Sprint_2Test {

	@Test
	public void testRegistrarEmprestimo() {
		Biblioteca _Biblioteca = new Biblioteca();
		Usuario _Usuario = new Usuario("UsuarioTeste",true,0);
		Livro _Livro = new Livro("LivroTeste","Disponível");
		
		_Biblioteca.BD_Livros.add(_Livro);
		_Biblioteca.InserirNovoUsuario("UsuarioTeste");
		_Biblioteca.RegistrarEmprestimo("LivroTeste","UsuarioTeste",18);
		
		assertEquals("Retirado", _Biblioteca.BD_Livros.get(0).GetSituacaoDoLivro());
	}
	
	@Test
	public void testRegistrarDevolucaoLivro(){
		Biblioteca _Biblioteca = new Biblioteca();
		Usuario _Usuario = new Usuario("UsuarioTeste",true,0);
		Livro _Livro = new Livro("LivroTeste","Disponível");
		
		_Biblioteca.BD_Livros.add(_Livro);
		_Biblioteca.InserirNovoUsuario("UsuarioTeste");
		_Biblioteca.RegistrarEmprestimo("LivroTeste","UsuarioTeste",18);
		_Biblioteca.RegistrarDevolucao("LivroTeste","UsuarioTeste");
		
		assertEquals("Disponível", _Biblioteca.BD_Livros.get(0).GetSituacaoDoLivro());
	}

}
