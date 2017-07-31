package br.com.casadocodigo.loja.dao.service;

import java.util.List;

import br.com.casadocodigo.loja.model.Produto;


public interface ProdutoDAOService {

	void gravar(Produto produto);
	
	List<Produto> listar();

}
