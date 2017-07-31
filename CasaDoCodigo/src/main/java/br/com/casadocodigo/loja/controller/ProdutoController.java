package br.com.casadocodigo.loja.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import br.com.casadocodigo.loja.bo.ProdutoBO;
import br.com.casadocodigo.loja.enumerador.TipoLivro;
import br.com.casadocodigo.loja.model.Produto;

@Controller
@RequestMapping("/produtos")
public class ProdutoController {
	
	@Autowired
	private ProdutoBO produtoBO;
	
	@RequestMapping(value="/initIncluirProduto", method=RequestMethod.GET)
	public ModelAndView initIncluirProduto(){
		
	    ModelAndView modelAndView = new ModelAndView("produtos/incluirProduto");
        modelAndView.addObject("tipos", TipoLivro.values());
        
        return modelAndView;
	    
	}
	
	@RequestMapping(value="/gravarProduto", method=RequestMethod.POST)
	public String gravarProduto(Produto produto){
		
		produtoBO.gravar(produto);

	    return "ok";
	    
	}

	@RequestMapping(value="/listarProdutos", method=RequestMethod.GET)
	public ModelAndView listar(){
		
	    ModelAndView modelAndView = new ModelAndView("produtos/listarProdutos");
	    modelAndView.addObject("produtos", produtoBO.listar());
	    
	    return modelAndView;
	    
	}

}
