package br.com.herbertrausch;

import br.com.herbertrausch.domain.Endereco;
import br.com.herbertrausch.rest.RestFulClient;

public class Principal {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		RestFulClient ws = new RestFulClient();
		
		
		//Recuperando todos os enderecos
		ws.recuperarEnderecos();
		
		//Salvando endereco
		
		Endereco e1 = new Endereco();
		
		e1.setCidade("Varginha");
		e1.setRua("Imigrante Cliente2");
		
//		ws.salvarEndereco(e1);
		
		ws.closeConnection();
		

	}

}
