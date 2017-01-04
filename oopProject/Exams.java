package oopProject;


public class Exams {
	
	private String examName;
	private String sinavTarihi;
	private String basvuruTarihi;
	private String sonucTarihi;
	
	public Exams(String examName,String sinavTarihi,String basvuruTarihi, String sonucTarihi) {
		this.examName = examName;
		this.sinavTarihi = sinavTarihi;
		this.basvuruTarihi = basvuruTarihi;
		this.sonucTarihi = sonucTarihi;
	}
	public void setExamName(String examName) {
		this.examName = examName;
	}
	public void setSinavTarihi(String sinavTarihi) {
		this.sinavTarihi = sinavTarihi;
	}
	public void setBasvuruTarihi(String basvuruTarihi) {
		this.basvuruTarihi = basvuruTarihi;
	}
	public void setSonucTarihi(String sonucTarihi) {
		this.sonucTarihi = sonucTarihi;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return String.format("%s <|> %s <|> %s <|> %s",this.examName,this.sinavTarihi,this.basvuruTarihi,this.sonucTarihi);
	}
	
	
	
}
