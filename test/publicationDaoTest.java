package test;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import oopProject.Publication;
import oopProject.PublicationDaoImpl;

public class publicationDaoTest {
	
	private PublicationDaoImpl makale = new PublicationDaoImpl();
	
	@Test	
	public void findByPublicationId() throws NullPointerException{
		try{
			
			Publication p = this.makale.getPublication("304587");
			assertEquals(1999, p.getYear());
	        assertEquals("Isabel F. Cruz, Kimberly M. James", p.getAuthors());
		
		}catch(NullPointerException e){
			
			System.out.println(e.getMessage());	
			
		}		
		
	}
	@Test 
	public void insertDatabase(){
		
		Publication p = new Publication("304580",
				"A user-centered interface for querying distributed multimedia databases",
				"Isabel F. Cruz, Kimberly M. James",				
				"International Conference on Management of Data",
				1999,
				"some content");
		
		
		
		try{
			this.makale.addPublication(p.getId(),p.getAuthors(),p.getTitle(),p.getVenue(),p.getYear(),p.getText());
			
			Publication newP = this.makale.getPublication("304580");
			
			assertEquals(1999, p.getYear());
	        assertEquals(p.getAuthors(),newP.getAuthors());
	        
	        return;
			
		}catch(NullPointerException e){
			
			System.out.println(e.getMessage());
			
		}
												
	}
	@Test
	public void deleteFromDatabase(){
		
			Publication deletedPublic = new Publication("304580",
				"A user-centered interface for querying distributed multimedia databases",
				"Isabel F. Cruz, Kimberly M. James",				
				"International Conference on Management of Data",
				1999,
				"some content");
			
			try{
				this.makale.deletePublication(deletedPublic);

				Publication newP = this.makale.getPublication("304580");
				assertEquals(null,newP);
												
				return;
			}catch(NullPointerException e){
				
				System.out.println(e.getMessage());
				
			}
			
			
			
	}
	public void allPublicationsFromDatabase(){
		
		int size = 10;
		
		List<Publication> pList = new ArrayList<Publication>();
		
		pList =  this.makale.getAllPublications(); 
		
		assertEquals(size,pList.size());
		
		
		
	}
}
