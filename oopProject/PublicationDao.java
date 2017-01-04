package oopProject;

import java.util.List;


public interface PublicationDao {
	
	public List<Publication> getAllPublications();
	public Publication getPublication(String id);
	public void addPublication(String id,String authors,String title,String venue,int year,String text);
	public void deletePublication(Publication publication);
	
}
