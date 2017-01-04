package oopProject;

import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.List;

import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import com.mongodb.MongoClient;

public class PublicationDaoImpl implements PublicationDao {
	
	
	private DBCollection publics;
	
	public PublicationDaoImpl(){
						
			MongoClient mongo;
			
			try {
				mongo = new MongoClient("localhost",27017);
				DB db = mongo.getDB("admin");
				this.publics = db.getCollection("publications");
				
			} catch (UnknownHostException e) {
				
				e.printStackTrace();
			}
			
														
	}

	@Override
	public List<Publication> getAllPublications() {
		
		List<Publication> pList = new ArrayList<Publication>();
		
		BasicDBObject searchQuery = new BasicDBObject();
		
		DBCursor cursor = this.publics.find(searchQuery);
		
		while(cursor.hasNext()){
			
			DBObject obj = cursor.next();
			pList.add(new Publication(obj.get("_id").toString(),
					 obj.get("authors").toString(),
					 obj.get("title").toString(),
					 obj.get("venue").toString(),
					 Integer.parseInt(obj.get("year").toString()),
					 obj.get("text").toString()) );

		}
				
		return pList;
		
	}
	
	@Override
	public Publication getPublication(String id) {
		
		Publication p;
		 
		BasicDBObject searchQuery = new BasicDBObject();
		
		searchQuery.put("_id",id);
		
		DBCursor cursor = this.publics.find(searchQuery);
		
		if(cursor.hasNext()){
			
			DBObject obj = cursor.next();
			
			 p = new Publication(obj.get("_id").toString(),
					 obj.get("title").toString(),
					 obj.get("authors").toString(),					 
					 obj.get("venue").toString(),
					 Integer.parseInt(obj.get("year").toString()),
					 obj.get("text").toString());	
			 
			 return p;
			 
			
		}
		
		return null;
		
	}

	@Override
	public void addPublication(String id, String authors, String title, String venue, int year,String text) {
		
		BasicDBObject document = new BasicDBObject();
		document.put("_id", id);
		document.put("authors", authors);
		document.put("title", title);
		document.put("venue", venue);
		document.put("year", year);
		document.put("text", text);
		this.publics.insert(document);
		
		
	}

	@Override
	public void deletePublication(Publication publication) {
		
		BasicDBObject searchQuery = new BasicDBObject();
		searchQuery.put("_id",publication.getId());
		this.publics.remove(searchQuery);
		
	}
	


		
	
}
