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
	boolean EmprestarLivro(String nome){
		Usuario user = null;
		
		for(Usuario u : BD_Usuario){
			if(u.GetNome() == nome){
				user = u;
			}
		}
		
		if(user == null){
			return false;
		}
		
		return user.GetUsuarioBloqueado();
	}
	Livro ProcurarLivro(String nome){
		
		System.out.printf("Procurando o livro %s! \n", nome);
		for(Livro l : BD_Livros){
			if(l.GetNome() == nome){
				System.out.printf("Livro encontrado! \n");
				return l;
			}
		}
		System.out.printf("Livro nao encontrado! \n");
		return null;
	}
	
	void RegistrarEmprestimo(String nomeLivro, String nomeUsuario,int tempo){
		Livro book;
		Usuario user = null;
		
		book = ProcurarLivro(nomeLivro);
		
		if (book == null){
			return;
		}
		
		for(Usuario u : BD_Usuario){
			if(u.GetNome() == nomeUsuario){
				user = u;
			}
		}
		
		if(user == null){
			return ;
		}
		
		Sistema system = new Sistema(nomeLivro,nomeUsuario,tempo);
		
		BD_Livros.remove(book);
		book.SetSituacaoDoLivro("Retirado");
		BD_Livros.add(book);
		HistoricoDeEmprestimos.add(system);
	}
	
	void RegistrarDevolucao(String nomeLivro, String nomeUsuario){
		Livro book;
		Usuario user = null;
		
		book = ProcurarLivro(nomeLivro);
		
		if (book == null){
			return;
		}
		
		for(Usuario u : BD_Usuario){
			if(u.GetNome() == nomeUsuario){
				user = u;
			}
		}
		
		if(user == null){
			return ;
		}
		
		Sistema system = new Sistema(nomeLivro, nomeUsuario, 0);
		
		BD_Livros.remove(book);
		book.SetSituacaoDoLivro("Disponível");
		BD_Livros.add(book);
		
		HistoricoDeEmprestimos.remove(system);
	}
}
