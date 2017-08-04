package br.com.casadocodigo.loja.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.servlet.ModelAndView;

import br.com.casadocodigo.loja.bo.ProdutoBO;
import br.com.casadocodigo.loja.enumerador.TipoLivro;
import br.com.casadocodigo.loja.model.CarrinhoCompras;
import br.com.casadocodigo.loja.model.CarrinhoItem;
import br.com.casadocodigo.loja.utils.UtilPages;

@Controller
@RequestMapping("/carrinho")
@Scope(value=WebApplicationContext.SCOPE_REQUEST)
public class CarrinhoComprasController {
	
	@Autowired
	private ProdutoBO produtoBO;
	
	@Autowired
    private CarrinhoCompras carrinho;

	@RequestMapping("/adicionarProduto")
	public ModelAndView adicionarProduto(Integer produtoId, TipoLivro tipoLivro) {
		
		ModelAndView modelAndView = new ModelAndView(UtilPages.DETALHAR_CARRINHO_REDIRECT);
		
		CarrinhoItem carrinhoItem = criaItem(produtoId, tipoLivro);
		carrinho.add(carrinhoItem);
		
		return modelAndView;
	
	}
	
	private CarrinhoItem criaItem(Integer produtoId, TipoLivro tipoLivro){
		
	    return new CarrinhoItem(produtoBO.consultarProduto(produtoId), tipoLivro);
	    
	}
	
	@RequestMapping(value="/detalharCarrinho", method=RequestMethod.GET)
	public ModelAndView itens(){
		
	    return new ModelAndView(UtilPages.DETALHAR_CARRINHO);
	    
	}

}
