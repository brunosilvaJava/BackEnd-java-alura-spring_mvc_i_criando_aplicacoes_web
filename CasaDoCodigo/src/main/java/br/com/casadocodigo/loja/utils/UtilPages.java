package br.com.casadocodigo.loja.utils;

public abstract class UtilPages {
	
	private static final String REDIRECT = "redirect:/";

	private static final String PRODUTOS = "produtos/";
	
	public static final String INCLUIR_PRODUTO = PRODUTOS + "incluirProduto";
	public static final String LISTAR_PRODUTOS = PRODUTOS + "listarProdutos";
	public static final String DETALHAR_PRODUTO = PRODUTOS + "detalharProduto";
	
	public static final String LISTAR_PRODUTOS_REDIRECT = REDIRECT + LISTAR_PRODUTOS;
	
	private static final String CARRINHO = "carrinho/";

	public static final String DETALHAR_CARRINHO = CARRINHO + "detalharCarrinho";
	
	public static final String DETALHAR_CARRINHO_REDIRECT = REDIRECT + DETALHAR_CARRINHO;
	
}
