package HELONMOREIRA_QUESTAO8;

public class Usuario {
	private String _Nome;
	private boolean _UsuarioBloqueado;
	private int _TempoBloqueado;
	
	Usuario(String nome, boolean usuarioBloqueado, int tempoBloqueado){
		_Nome = nome;
		_UsuarioBloqueado = usuarioBloqueado;
		_TempoBloqueado = tempoBloqueado;
	}
	
	String GetNome(){
		return _Nome;
	}
	
	void SetNome(String nome){
		_Nome = nome;
	}
	
	boolean GetUsuarioBloqueado(){
		return _UsuarioBloqueado;
	}
	
	void SetUsuarioBloqueado(boolean bloqueado){
		_UsuarioBloqueado = bloqueado;
	}
	
	int GetTempoBloqueado(){
		return _TempoBloqueado;
	}
	
	void SetTempoBloqueado(int tempoBloqueado){
		_TempoBloqueado = tempoBloqueado;
	}
}
