package br.com.casadocodigo.loja.enumerador;

public enum TipoLivro {
	
	EBOOK(0), 
	IMPRESSO(1), 
	COMBO(2);
	
	private Integer tipoLivro;
	
	private TipoLivro(Integer tipoLivro) {
		this.tipoLivro = tipoLivro;
	}	
	
	public Integer getTipoLivro() {
		return tipoLivro;
	}
	
}
