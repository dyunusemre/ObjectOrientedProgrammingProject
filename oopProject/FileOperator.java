package oopProject;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import au.com.bytecode.opencsv.CSVReader;

public class FileOperator {
	
	public ArrayList<Publication> readCsvFile(String FileName){
		
		ArrayList<Publication> publicationList = new ArrayList<Publication>();
		
		CSVReader csvReader = null;
		
		try{
			
			csvReader = new CSVReader(new FileReader(FileName));
			String row[];
			
			while((row = csvReader.readNext()) != null){
				
				publicationList.add(new Publication(row[0].trim(), row[1].trim(),
						row[2].trim(),row[3].trim(),Integer.parseInt(row[4].trim())
						,null));
				
				
			}
			
		}catch(IOException e){
			
			e.printStackTrace();
			
		}
		
		return publicationList;
		
	}
	public ArrayList<String> listFilesForFolder(File folder){
		
		ArrayList<String> folderNames = new ArrayList<String>();
		
		for (File fileEntry : folder.listFiles()) {
	        if (fileEntry.isDirectory()) {
	        	listFilesForFolder(fileEntry);
	        } else {
	            folderNames.add(fileEntry.getName());
	        }
	    }
				
		return folderNames;
		
	}
		
}
