package HELONMOREIRA_QUESTAO8;

public class Sistema {
	private String _Usuario;
	private String _Livro;
	private int _Tempo = 0;
	
	Sistema(String nomeLivro,String nomeUsuario,int tempo){
		_Livro = nomeLivro;
		_Usuario = nomeUsuario;
		_Tempo = tempo;
	}
	
	public String GetUsuario(){
		return _Usuario;
	}
	
	public void SetUsuario(String usuario){
		_Usuario = usuario;
	}
	
	public String GetLivro(){
		return _Livro;
	}
	
	public void SetLivro(String livro){
		_Livro = livro;
	}
	
	public int GetPrazo(){
		return _Tempo;
	}
	
	public void SetPrazo(int tempo){
		_Tempo = tempo;
	}
}
