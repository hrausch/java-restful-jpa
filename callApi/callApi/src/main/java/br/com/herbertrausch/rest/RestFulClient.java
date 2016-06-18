package br.com.herbertrausch.rest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;

import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpPut;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;

import com.google.gson.Gson;

import br.com.herbertrausch.domain.Endereco;

public class RestFulClient {

    public static final int OPERACAO_RECUPERAR = 1;
    public static final int OPERACAO_SALVAR = 2;

    //Endereco do servidor do Web Service
    private String BASE_URL_WS = "http://localhost:8080/restmongo/rest/";

    private String URL_RECUPERAR_ENDERECOS = BASE_URL_WS.concat("enderecos");

    private HttpClient httpClient;

    public RestFulClient(){
    	
        
    }
    
    public void closeConnection(){
    	httpClient.getConnectionManager().shutdown();
    }
    
    


    public String recuperarEnderecos(){
    	
    		String output = "";
    		try {
    			// instancia um cliente http
    	        httpClient = new DefaultHttpClient();
    	        
    			//inicia um protocolo via GET
    	    	HttpGet getRequest = new HttpGet();
    	    	
    	    	//define o cabeçalho do pacote
    	    	getRequest.setHeader("Content-Type", "application/json");
    			
    			//define a URL de requisição
        		getRequest.setURI(new URI(URL_RECUPERAR_ENDERECOS));
    			
    			//executa a requisicao
        		HttpResponse response = httpClient.execute(getRequest);
				
    			//se codigo for diferente de 200 (sucesso) lança uma nova exceção
				if (response.getStatusLine().getStatusCode() != 200) {
					throw new RuntimeException("Failed : HTTP error code : "
						+ response.getStatusLine().getStatusCode());
				}

				//se recuperou o pacote - trata as informações.
				BufferedReader br = new BufferedReader(
		                        new InputStreamReader((response.getEntity().getContent())));

				String aux;
				System.out.println("Output from Server .... \n");
				
				while ((aux = br.readLine()) != null) {
					output += aux;
				}
				

				
				
			} catch (ClientProtocolException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}catch (URISyntaxException e) {
	            e.printStackTrace();
	        }
    		
    		return output;


    }

    
    
    public void salvarEndereco(Endereco e){
    	
    	
    	
    	 try {
    		// instancia um cliente http
    	        httpClient = new DefaultHttpClient();
    	        
    	        HttpPost postRequest = new HttpPost(URL_RECUPERAR_ENDERECOS);

    			Gson gson = new Gson();
    			String json = gson.toJson(e);    			
    			StringEntity input = new StringEntity(json);
    			
    			input.setContentType("application/json");
    			
    			postRequest.setEntity(input);

    			HttpResponse response = httpClient.execute(postRequest);

    			if (response.getStatusLine().getStatusCode() != 200) {
    				throw new RuntimeException("Failed : HTTP error code : "
    					+ response.getStatusLine().getStatusCode());
    			}

    			
    			BufferedReader br = new BufferedReader(
    	                        new InputStreamReader((response.getEntity().getContent())));

    			String output;
    			System.out.println("Output from Server .... \n");
    			while ((output = br.readLine()) != null) {
    				System.out.println(output);
    			}


    		  } catch (MalformedURLException e1) {

    			e1.printStackTrace();
    		
    		  } catch (IOException e2) {

    			e2.printStackTrace();

    		  }
    }


   
}