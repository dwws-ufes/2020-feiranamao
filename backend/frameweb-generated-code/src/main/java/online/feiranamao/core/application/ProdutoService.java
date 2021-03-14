package online.feiranamao.core.application;

import java.util.List;
import java.util.Optional;

public interface ProdutoService {

	
	
	
	
	public Optional<Produto> findProdutoById(Long id);
	public List<Produto> findAllProdutos();
	public Produto saveProduto(Produto produto);
	public void deleteProduto(Produto produto);

}