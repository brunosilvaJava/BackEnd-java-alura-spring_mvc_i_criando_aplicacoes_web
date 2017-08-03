package br.com.casadocodigo.loja.model;

import java.math.BigDecimal;

import javax.persistence.Embeddable;

import br.com.casadocodigo.loja.enumerador.TipoLivro;

@Embeddable
public class Preco {

	private BigDecimal valor;
	
    private TipoLivro tipo;
    
    public Preco() {
	
    }

	public BigDecimal getValor() {
		return valor;
	}

	public void setValor(BigDecimal valor) {
		this.valor = valor;
	}

	public TipoLivro getTipo() {
		return tipo;
	}

	public void setTipo(TipoLivro tipo) {
		this.tipo = tipo;
	}

}
