package br.com.casadocodigo.loja.bo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.casadocodigo.loja.dao.service.ProdutoDAOService;
import br.com.casadocodigo.loja.model.Produto;

@Service
public class ProdutoBO {
	
	@Autowired
	private ProdutoDAOService produtoDAO;
	
	public void gravar(Produto produto){

		 produtoDAO.gravar(produto);
		
    }
	
	public List<Produto> listar(){
		
	    return produtoDAO.listar();
	    
	}

	public Produto consultarProduto(Integer idProduto) {
		return produtoDAO.consultarProduto(idProduto);
	}
	
	
	
	

}
