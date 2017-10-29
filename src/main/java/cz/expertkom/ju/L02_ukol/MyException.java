package cz.expertkom.ju.L02_ukol;

/* tohle mi vnutila Eclipse*/
@SuppressWarnings("serial") 

public class MyException extends Exception {
	
	private String duvod;
	private ObsluhaLogu obsluhaLogu = new ObsluhaLogu();
	
	public MyException(String duvod) {
		this.duvod = duvod;
		obsluhaLogu.pridejZapisDoLogu(this.duvod);
		System.out.println(this.duvod+"\n");	
	}
}
