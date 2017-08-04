package br.com.casadocodigo.loja.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import br.com.casadocodigo.loja.dao.service.ProdutoDAOService;
import br.com.casadocodigo.loja.model.Produto;

@Repository
@Transactional
public class ProdutoDAOImpl implements ProdutoDAOService{
	
	@PersistenceContext
	private EntityManager entityManager;
	
	@Override
	public void gravar(Produto produto){

		entityManager.persist(produto);
		
    }
	
	@Override
	public List<Produto> listar(){
		
		List<Produto> listaProdutos = entityManager.createQuery("select p from Produto p").getResultList();
		
	    return listaProdutos;
	    
	}
	
	@Override
	public Produto consultarProduto(Integer idProduto){
		
	    return entityManager.find(Produto.class, idProduto);
	    
	    
	}

}
