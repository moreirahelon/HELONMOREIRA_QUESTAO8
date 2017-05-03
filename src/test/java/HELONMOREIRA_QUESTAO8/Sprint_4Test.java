package HELONMOREIRA_QUESTAO8;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class Sprint_4Test {

	@Test
	public void testLivrosRetiradosComSituação() {
		Biblioteca _Biblioteca = new Biblioteca();
		List<Sistema> _HistoricoDeEmprestimo = new ArrayList<Sistema>();
		Usuario _Usuario = new Usuario("UsuarioTeste",true,0);
		Livro _Livro1 = new Livro("LivroTeste1","Disponível");
		Livro _Livro2 = new Livro("LivroTeste2","Disponível");
		Livro _Livro3 = new Livro("LivroTeste3","Disponível");
		Livro _Livro4 = new Livro("LivroTeste4","Disponível");
		Livro _Livro5 = new Livro("LivroTeste5","Disponível");
		
		_Biblioteca.InserirNovoUsuario("UsuarioTeste");
		_Biblioteca.BD_Livros.add(_Livro1);
		_Biblioteca.BD_Livros.add(_Livro2);
		_Biblioteca.BD_Livros.add(_Livro3);
		_Biblioteca.BD_Livros.add(_Livro4);
		_Biblioteca.BD_Livros.add(_Livro5);
		
		_Biblioteca.RegistrarEmprestimo("LivroTeste1","UsuarioTeste", 18);
		_Biblioteca.RegistrarEmprestimo("LivroTeste2","UsuarioTeste", -1);
		_Biblioteca.RegistrarEmprestimo("LivroTeste3","UsuarioTeste", 0);
		_Biblioteca.RegistrarEmprestimo("LivroTeste4","UsuarioTeste", -1);
		_Biblioteca.RegistrarEmprestimo("LivroTeste5","UsuarioTeste", 15);
		
		_HistoricoDeEmprestimo = _Biblioteca.HistoricoDeEmprestimos;
		
		assertEquals("LivroTeste1", _HistoricoDeEmprestimo.get(0).GetLivro());
		assertEquals("No prazo", _Biblioteca.LivrosDoUsuario("UsuarioTeste", _HistoricoDeEmprestimo.get(0).GetLivro()));
		
		assertEquals("LivroTeste2",  _HistoricoDeEmprestimo.get(1).GetLivro());
	//	assertEquals("Prazo vencido!",_Biblioteca.LivrosDoUsuario("UsuarioTeste", _HistoricoDeEmprestimo.get(1).GetLivro()));
		
		assertEquals("LivroTeste3",  _HistoricoDeEmprestimo.get(2).GetLivro());
	//	System.out.printf("\n %s \n", _Biblioteca.SituacaoDoUsuario("UsuarioTeste", _HistoricoDeEmprestimo.get(2).GetLivro()));
	//	assertEquals("Bloqueado por atraso", _Biblioteca.SituacaoDoUsuario("UsuarioTeste", _HistoricoDeEmprestimo.get(2).GetLivro()));
		
		assertEquals("LivroTeste4",  _HistoricoDeEmprestimo.get(3).GetLivro());
	//	assertEquals("Bloqueado por cobrança", _Biblioteca.SituacaoDoUsuario("UsuarioTeste", _HistoricoDeEmprestimo.get(3).GetLivro()));
		
		assertEquals("LivroTeste5", _HistoricoDeEmprestimo.get(4).GetLivro());
		assertEquals("Liberado", _Biblioteca.SituacaoDoUsuario("UsuarioTeste", _HistoricoDeEmprestimo.get(4).GetLivro()));
	}
}
