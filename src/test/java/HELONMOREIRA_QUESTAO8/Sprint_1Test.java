/**
 * 
 */
package HELONMOREIRA_QUESTAO8;

import static org.junit.Assert.*;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import org.junit.Test;
import junit.framework.TestCase;

public class Sprint_1Test extends TestCase {


	@Test
	public void testInserirNovoUsuario() throws Exception {
		Biblioteca _Biblioteca = new Biblioteca();
		Usuario _Usuario = new Usuario("UsuarioTeste",true,0);
		
		assertTrue(_Biblioteca.InserirNovoUsuario("UsuarioTeste"));
		assertEquals(_Biblioteca.BD_Usuario.get(0).GetNome(), "UsuarioTeste");
	}
	
	@Test
	public void testRemoverUsuario(){
		Biblioteca _Biblioteca = new Biblioteca();
		Usuario _Usuario = new Usuario("UsuarioTeste",true,0);
		
		assertTrue(_Biblioteca.InserirNovoUsuario("UsuarioTeste"));
		assertTrue(_Biblioteca.RemoverUsuario("UsuarioTeste"));
		assertFalse(_Biblioteca.RemoverUsuario("UsuarioTeste"));
	}
	
	@Test
	public void testAdicionarPrazoBanimento(){
		Biblioteca _Biblioteca = new Biblioteca();
		Usuario _Usuario = new Usuario("UsuarioTeste",true,0);
		
		_Biblioteca.InserirNovoUsuario("UsuarioTeste");
		_Biblioteca.BloquearUsuario("UsuarioTeste", 2);
		
		assertEquals(_Biblioteca.BD_Usuario.get(0).GetTempoBloqueado(), 2);
		assertFalse(_Biblioteca.BD_Usuario.get(0).GetUsuarioBloqueado());
	}
}
