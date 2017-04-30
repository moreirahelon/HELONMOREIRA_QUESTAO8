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
}
