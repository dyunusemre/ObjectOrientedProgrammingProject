package oopProject;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.Set;
import java.util.SortedSet;

import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.MongoClient;

import oopProject.MostFrequentWords.Word;


public class App {
	
	public static void main(String[] args) throws IOException {
		
		/*ArrayList<Publication> plist;
		
		ArrayList<String> pdfs;
		
		FileOperator fo = new FileOperator();
		FileParser fp = new FileParser();
		
		AutoDownloadCSV autoDownloader = new AutoDownloadCSV();
		
		PublicationDaoImpl publication;
			
		plist = fo.readCsvFile("resources/ACM.csv");
		
		JaccardSimilarity similarity = new JaccardSimilarity();
		
		/*for (int i = 0; i < plist.size(); i++) {
			
			autoDownloader.downloadFile(plist.get(i).getId());
			
		}*/
		
		/*		
		File folder = new File("C:\\Users\\Yunus Emre\\Downloads\\Publication");
				
		pdfs = fo.listFilesForFolder(folder);
				
		ArrayList<String> publics = new ArrayList<String>();
		
		try{
			
			publication = new PublicationDaoImpl();
			
			String filePath;
															
		
						for (int j = 0; j < plist.size(); j++) {
							
							
							filePath = "C:\\Users\\Yunus Emre\\Downloads\\Publication\\"+pdfs.get(j);	
							
							publication.addPublication(plist.get(j).getId(),
									   plist.get(j).getAuthors(),
									   plist.get(j).getTitle(),
									   plist.get(j).getVenue(),
									   plist.get(j).getYear(),
									   fp.fileParse(filePath,pdfs.get(j)).toString());
							
							publics.add(fp.fileParse(filePath,pdfs.get(j)).toString());
							
						}
			
		}catch(Exception ex){
			
			System.out.println(ex.getMessage());
			
		}	
		
	
			
		//YDS VE ALES sinavlarinin bilgilerini goruntuleyen kisim
		
		ArrayList<Exams> exm = new ArrayList<Exams>();
		
		ExamLister listExams = new ExamLister();
		
		exm = listExams.examsInfo();
		*/
		/*
		
		for (Exams exams : exm) {
			
			System.out.println(exams.toString());
			
		}
	
		
		MostFrequentWords countWords = new MostFrequentWords();		
		
		
		SortedSet<Word> sortedWords = countWords.getWords("C:\\Users\\Yunus Emre\\Downloads\\PublicationText\\"+pdfs.get(0)+".txt");
		System.out.println(pdfs.get(0));
		int i = 0;
		for (Word word : sortedWords) {
			if (i > 10) {
				break;
			}

			System.out.println(word.count + "\t" + word.word);

			i++;
		}
		
		System.out.println(pdfs.get(1));
		
		sortedWords = countWords.getWords("C:\\Users\\Yunus Emre\\Downloads\\PublicationText\\"+pdfs.get(1)+".txt");
		
		i = 0;
		for (Word word : sortedWords) {
			if (i > 10) {
				break;
			}

			System.out.println(word.count + "\t" + word.word);

			i++;
		}*/
		
		
		PublicationDaoImpl p1 = new PublicationDaoImpl();
		
		p1.getPublication("304589");
		
		Publication p2 = p1.getPublication("304589");
		
		System.out.println(p2.similarity(new JaccardSimilarity(),p1.getAllPublications()));
	
		
		
	}
	
}
