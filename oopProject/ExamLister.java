package oopProject;

import java.io.IOException;
import java.util.ArrayList;


import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class ExamLister {
	
	public ArrayList<Exams> examsInfo(){
			
			Document doc;
			
			ArrayList<Exams> exms = new ArrayList<Exams>();
									
			try{
				
				
				doc = Jsoup.connect("http://www.osym.gov.tr/TR,8797/takvim.html").get();
				
				Elements table = doc.select("div.table div.row");
				
				Element sinavAdi = table.get(0).select("div.col-sm-6").get(0);
				Element sinavTarihi = table.get(0).select("div.col-sm-2").get(0);
				Element basvuruTarihi = table.get(0).select("div.col-sm-2").get(1);
				Element sonucTarihi = table.get(0).select("div.col-sm-2").get(2);
							
					
				exms.add(new Exams(sinavAdi.text(),
						 sinavTarihi.text(),
						 basvuruTarihi.text(),
						 sonucTarihi.text()));
				
					
					sinavAdi = table.get(6).select("div.col-sm-6").get(0);
					sinavTarihi = table.get(6).select("div.col-sm-2").get(0);
					basvuruTarihi = table.get(6).select("div.col-sm-2").get(1);
					sonucTarihi = table.get(6).select("div.col-sm-2").get(2);
								
						
					exms.add(new Exams(sinavAdi.text(),
							 sinavTarihi.text(),
							 basvuruTarihi.text(),
							 sonucTarihi.text()));
					
					
					sinavAdi = table.get(14).select("div.col-sm-6").get(0);
					sinavTarihi = table.get(14).select("div.col-sm-2").get(0);
					basvuruTarihi = table.get(14).select("div.col-sm-2").get(1);
					sonucTarihi = table.get(14).select("div.col-sm-2").get(2);
								
						
					exms.add(new Exams(sinavAdi.text(),
							 sinavTarihi.text(),
							 basvuruTarihi.text(),
							 sonucTarihi.text()));
									
			
				
				return exms;
	
			}catch(IOException e){
				
				e.printStackTrace();
				
			}
			
			return exms;
		}

	
}
