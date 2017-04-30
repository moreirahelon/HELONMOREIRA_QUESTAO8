package HELONMOREIRA_QUESTAO8;

public class Livro {
	private String _Nome;
	private String _SituacaoDoLivro;

	Livro(String nome, String status){
		_Nome = nome;
		_SituacaoDoLivro = status;
	}

	public String GetNome(){
		return _Nome;
	}

	public void SetNome(String nome){
		_Nome = nome;
	}
	
	public String GetSituacaoDoLivro(){
		return _SituacaoDoLivro;
	}
	
	public void SetSituacaoDoLivro(String situacao){
		_SituacaoDoLivro = situacao;
	}
}
