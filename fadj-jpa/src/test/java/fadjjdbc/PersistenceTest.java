package fadjjdbc;

import java.util.List;

import br.com.herbertrausch.domain.Endereco;
import br.com.herbertrausch.domain.EnderecoService;
import br.com.herbertrausch.domain.Produto;
import br.com.herbertrausch.domain.ProdutoAtributo;
import br.com.herbertrausch.domain.ProdutoService;

public class PersistenceTest {
	
	public static void main(String [] args){
		
		Produto p = new Produto();
		ProdutoService db = new ProdutoService();
		
		List<Produto> ps = db.getProdutos();
		
		p = ps.get(0);
		
		List<Object[]> pa = db.getSomaMediaValor();
		
		System.out.println("");
	}

}
