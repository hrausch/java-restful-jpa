package br.com.herbertrausch;

import java.util.ArrayList;

import br.com.herbertrausch.domain.Endereco;
import br.com.herbertrausch.rest.RestFulClient;

public class Principal {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		RestFulClient ws = new RestFulClient();
		
		
		//Recuperando todos os enderecos
		String json = ws.recuperarEnderecos();
		System.out.println(json);
		
		//transformando em objetos
		
		ArrayList<Endereco> e1 = Endereco.fromArrayJson(json);
		
		for(Endereco e: e1){
			System.out.println(e.getRua());
		
			System.out.println(e.getEstado());
		}
		//Salvando endereco
		

//		
//		e1.setCidade("Varginha");
//		e1.setRua("Imigrante Cliente2");
		
//		ws.salvarEndereco(e1);
		
		ws.closeConnection();
		

	}

}
