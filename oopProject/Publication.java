package oopProject;

import java.util.HashMap;
import java.util.List;


public class Publication {
	
	private String id;
	private String title;
	private String authors;
	private String venue;
	private int year;
	private String text;
	public SimilarityCalculate similarity;
	
	public Publication(String id,String title,String authors,String venue,int year,String text) {
		this.setId(id);	
		this.setTitle(title);
		this.setAuthors(authors);
		this.setVenue(venue);
		this.setYear(year);
		this.setText(text);
		
	}
	public HashMap<String,Double> similarity(SimilarityCalculate similarity,List<Publication> publications){
		
		String comparedId;
		String currentText = this.getText();
		HashMap<String,Double> similarityScores = new HashMap<String,Double>();
		for (Publication publication : publications) {
			
			comparedId = publication.getId();
			similarityScores.put(comparedId, similarity.CalculateSimilarity(currentText, publication.getText()));
			
		}
		
		return similarityScores;
		
	}
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	public String getId() {
		return id;
	}
    public void setId(String id) {
		this.id = id;
	}
    public String getTitle() {
		return title;
	}
    public void setTitle(String title) {
		this.title = title;
	}
    public String getAuthors() {
		return authors;
	}
    public void setAuthors(String authors) {
		this.authors = authors;
	}
    public String getVenue() {
		return venue;
	}
    public void setVenue(String venue) {
		this.venue = venue;
	}
    public int getYear() {
		return year;
	}
    public void setYear(int year) {
		this.year = year;
	}
    @Override
    public String toString() {
    	
    	return getId() + " || " + getTitle() + " || " + getAuthors() + " || " + getVenue() + " || " + getYear();
    }
  
	
}
