package br.com.herbertrausch.mongodb;

import java.text.ParseException;

import com.google.gson.Gson;

public class ClienteDao {
	
//	private MongoDatabase db;
	private final String COLLECTION = "cliente";
	
	private String jsonObject;
	private Gson gson = new Gson();
	
	public void save(Cliente c) throws ParseException{
		
//		jsonObject = gson.toJson(c);
//		db = MongoConnection.getConnection().getDatabase();
//		Document document = Document.parse(jsonObject);
//		db.getCollection(COLLECTION).insertOne(document);

	}
	
//	public List<Document> get(){
//		List<Document> result = new ArrayList<Document>();
//		db = MongoConnection.getConnection().getDatabase();
//		FindIterable<Document> iterable = db.getCollection(COLLECTION).find();
//
//        iterable.forEach(new Block<Document>() {
//            @Override
//            public void apply(final Document document) {
//                result.add(document);
//            }
//        });
//
//        
//        return result;
//		
//	}
//	
//	public List<Document> getByNome(String nome){
//		
//		List<Document> result = new ArrayList<Document>();
//		db = MongoConnection.getConnection().getDatabase();
//		
//		FindIterable<Document> iterable = db.getCollection(COLLECTION).find(
//		        new Document("nome", nome));
//		
//        iterable.forEach(new Block<Document>() {
//            @Override
//            public void apply(final Document document) {
//                result.add(document);
//            }
//        });
//
//        
//        return result;
//		
//	}

}
