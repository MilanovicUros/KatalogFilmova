
public class filmovi {
	
	String naziv;
	int godina;
	String zanr;
	public String getNaziv() {
		return naziv;
	}
	public void setNaziv(String naziv) {
		this.naziv = naziv;
	}
	public int getGodina() {
		return godina;
	}
	public void setGodina(int godina) {
		this.godina = godina;
	}
	public String getZanr() {
		return zanr;
	}
	public void setZanr(String zanr) {
		this.zanr = zanr;
	}
	
	public boolean equals (Object o) {
		if  (!(o instanceof filmovi))
			throw new RuntimeException("Greska");
		filmovi f = (filmovi) (o);
		if (f.getNaziv().equals(naziv) && f.getGodina()==(godina))
			return true;
		else
			return false;
	}
	

}
