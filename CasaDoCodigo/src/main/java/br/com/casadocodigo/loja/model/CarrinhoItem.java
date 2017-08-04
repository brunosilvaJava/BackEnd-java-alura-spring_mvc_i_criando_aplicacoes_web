package br.com.casadocodigo.loja.model;

import java.math.BigDecimal;

import org.springframework.stereotype.Component;

import br.com.casadocodigo.loja.enumerador.TipoLivro;

@Component
public class CarrinhoItem {
	
	private TipoLivro tipoLivro;
    private Produto produto;
    
    public CarrinhoItem() {
	}

    public CarrinhoItem(Produto produto, TipoLivro tipoLivro) {
        this.produto = produto;
        this.tipoLivro = tipoLivro;
    }
	
	public BigDecimal getPreco(){
		
	    return produto.precoPara(tipoLivro);
	    
	}
    
	public BigDecimal getTotal(int quantidade) {
	
		return this.getPreco().multiply(new BigDecimal(quantidade));
	
	}
	
    @Override
	public int hashCode() {
		
    	final int prime = 31;
	
		int result = 1;
		result = prime * result + ((produto == null) ? 0 : produto.hashCode());
		result = prime * result + ((tipoLivro == null) ? 0 : tipoLivro.hashCode());
		
		return result;
	
    }

	@Override
	public boolean equals(Object obj) {
		
		if (this == obj)
			return true;
		
		if (obj == null)
			return false;
		
		if (getClass() != obj.getClass())
			return false;
		CarrinhoItem other = (CarrinhoItem) obj;
		
		if (produto == null) {
			if (other.produto != null)
				return false;
		} else if (!produto.equals(other.produto))
			return false;
		
		if (tipoLivro != other.tipoLivro)
			return false;
		
		return true;
		
	}

    public TipoLivro getTipoLivro() {
        return tipoLivro;
    }

	public void setTipoLivro(TipoLivro tipoLivro) {
        this.tipoLivro = tipoLivro;
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

}
