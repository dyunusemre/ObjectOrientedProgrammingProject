package oopProject;

import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;

public class FileParser {
	
	public String fileParse(String filePath,String fileName){
		String content ="";
		PDDocument pd;
		try{
			File input = new File(filePath);
			pd = PDDocument.load(input);
			PDFTextStripper stripper = new PDFTextStripper();
			content = stripper.getText(pd);
			
			PrintWriter pw = new PrintWriter(new FileWriter("C:\\Users\\Yunus Emre\\Downloads\\PublicationText\\"+fileName+".txt"));
			
			pw.write(content);
						
			
			if(pd != null){
				pd.close();
				pw.close();
			}
			
			return content;
			
			
		}catch(Exception e){
			e.printStackTrace();
		}
		return content;
		
	}
	
}
