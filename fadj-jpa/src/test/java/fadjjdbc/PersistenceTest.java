package fadjjdbc;

import br.com.herbertrausch.domain.Endereco;
import br.com.herbertrausch.domain.EnderecoService;

public class PersistenceTest {
	
	public static void main(String [] args){
		
		Endereco e;
		EnderecoService es = new EnderecoService();

		e = es.getEndereco((long) 1);
		
		System.out.println(e.toString());
	}

}
