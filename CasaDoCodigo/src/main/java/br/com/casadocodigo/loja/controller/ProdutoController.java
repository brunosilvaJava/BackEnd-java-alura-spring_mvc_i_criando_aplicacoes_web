package br.com.casadocodigo.loja.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.com.casadocodigo.loja.bo.ProdutoBO;
import br.com.casadocodigo.loja.enumerador.TipoLivro;
import br.com.casadocodigo.loja.infra.FileSaver;
import br.com.casadocodigo.loja.model.Produto;
import br.com.casadocodigo.loja.validation.ProdutoValidation;

@Controller
@RequestMapping("/produtos")
public class ProdutoController {

	@Autowired
	private ProdutoBO produtoBO;
	
	@Autowired
    private FileSaver fileSaver;

	@InitBinder
	public void initBinder(WebDataBinder webDataBinder) {

		webDataBinder.addValidators(new ProdutoValidation());

	}

	@RequestMapping(value = "/initIncluirProduto", method = RequestMethod.GET)
	public ModelAndView initIncluirProduto(Produto produto) {

		ModelAndView modelAndView = new ModelAndView("produtos/incluirProduto");
		modelAndView.addObject("tipos", TipoLivro.values());

		return modelAndView;

	}

	@RequestMapping(value = "/gravarProduto", method = RequestMethod.POST)
	public ModelAndView gravarProduto(MultipartFile sumario, @Valid Produto produto, BindingResult result, RedirectAttributes redirectAttributtes) {
		
		if (result.hasErrors()) {
			return initIncluirProduto(produto);
		}
		
		String path = fileSaver.write("arquivos-sumario", sumario);
	    produto.setSumarioPath(path);

		produtoBO.gravar(produto);

		redirectAttributtes.addFlashAttribute("statusInclusaoLivro", "Produto cadastrado com sucesso!");

		return new ModelAndView("redirect:listarProdutos");

	}

	@RequestMapping(value = "/listarProdutos", method = RequestMethod.GET)
	public ModelAndView listar() {

		ModelAndView modelAndView = new ModelAndView("produtos/listarProdutos");
		modelAndView.addObject("produtos", produtoBO.listar());

		return modelAndView;

	}

}
