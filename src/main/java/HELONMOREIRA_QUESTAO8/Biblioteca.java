package HELONMOREIRA_QUESTAO8;

import java.util.ArrayList;
import java.util.List;

public class Biblioteca {
	List<Usuario> BD_Usuario = new ArrayList<Usuario>(); 
	List<Livro> BD_Livros = new ArrayList<Livro>(); 
	List<Sistema> HistoricoDeEmprestimos = new ArrayList<Sistema>();
	
	boolean InserirNovoUsuario(String usuario){
		Usuario user = new Usuario(usuario,true,0);
		boolean flag = true;
		
		try{
			Persistir(user);
		}catch(Exception e){
			System.out.println(e.getMessage());
			flag = false;
		}
		return flag;
	}
	
	void Persistir(Usuario user) throws Exception{
		BD_Usuario.add(user);
 
	}
	
	boolean RemoverUsuario(String nome){
		Usuario user = null;
		
		for(Usuario u : BD_Usuario){
			if(u.GetNome() == nome){
				user = u;
			}
		}
		
		if(user == null){
			return false;
		}
		
		BD_Usuario.remove(user);
		
		return true;
	}
	
	void BloquearUsuario(String nome,int tempo){
		Usuario user = null;
		
		for(Usuario u : BD_Usuario){
			if(u.GetNome() == nome){
				user = u;
			}
		}
		
		if(user == null){
			return ;
		}
		
		BD_Usuario.remove(user);
		user.SetUsuarioBloqueado(false);
		user.SetTempoBloqueado(tempo);
		BD_Usuario.add(user);
	}
	
	//---------------------------------------------------------//
	boolean EmprestarLivro(String nomeDoUsuario){
		Usuario user = null;
		
		for(Usuario u : BD_Usuario){
			if(u.GetNome() == nomeDoUsuario){
				user = u;
			}
		}
		
		if(user == null){
			return false;
		}
		
		return user.GetUsuarioBloqueado();
	}
	
	Livro ProcurarLivro(String nomeDoLivro){
		
		System.out.printf("Procurando o livro %s! \n", nomeDoLivro);
		for(Livro l : BD_Livros){
			if(l.GetNome() == nomeDoLivro){
				System.out.printf("Livro encontrado! \n");
				return l;
			}
		}
		System.out.printf("Livro nao encontrado! \n");
		return null;
	}
	
	public String SituacaoDoLivro(String nomeDoLivro){
		Livro book;
		
		book = ProcurarLivro(nomeDoLivro);
		
		if (book==null){
			return "Livro nao encontrado!";
		}
		
		return book.GetSituacaoDoLivro();
	}
	
	void RegistrarEmprestimo(String nomeDoLivro, String nomeDoUsuario,int tempo){
		Livro book;
		Usuario user = null;
		
		book = ProcurarLivro(nomeDoLivro);
		
		if (book == null){
			return;
		}
		
		for(Usuario u : BD_Usuario){
			if(u.GetNome() == nomeDoUsuario){
				user = u;
			}
		}
		
		if(user == null){
			return ;
		}
		
		Sistema system = new Sistema(nomeDoLivro,nomeDoUsuario,tempo);
		
		BD_Livros.remove(book);
		book.SetSituacaoDoLivro("Retirado");
		BD_Livros.add(book);
		HistoricoDeEmprestimos.add(system);
	}
	
	void RegistrarDevolucao(String nomeDoLivro, String nomeDoUsuario){
		Livro book;
		Usuario user = null;
		
		book = ProcurarLivro(nomeDoLivro);
		
		if (book == null){
			return;
		}
		
		for(Usuario u : BD_Usuario){
			if(u.GetNome() == nomeDoUsuario){
				user = u;
			}
		}
		
		if(user == null){
			return ;
		}
		
		Sistema system = new Sistema(nomeDoLivro, nomeDoUsuario, 0);
		
		BD_Livros.remove(book);
		book.SetSituacaoDoLivro("Disponível");
		BD_Livros.add(book);
		
		HistoricoDeEmprestimos.remove(system);
	}
}
