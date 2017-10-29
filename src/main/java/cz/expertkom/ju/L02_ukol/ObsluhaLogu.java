package cz.expertkom.ju.L02_ukol;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

/* tohle mi vnutila Eclipse */
//@SuppressWarnings("serial")

public class ObsluhaLogu {
	
	private static final String souborLogu ="SOUBOR_LOGU.TXT";
	private static final SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy HH:mm:ss");
	
	
	/*
	 *  třída má 2 konstruktory, bez parametru - nic nevykoná
	 *  s parametrem provede zápis do logovacího souboru
	 */
	
	
	public ObsluhaLogu() {
		// nic se nevykonává
		
	}
	
	public ObsluhaLogu(String retez) {
		this.pridejZapisDoLogu(retez);
	}
	
	
	
	public void zalozLog() {
		try	{
		    BufferedWriter bw = new BufferedWriter(new FileWriter(souborLogu));
	        Date datumCas = new Date();
	        bw.write(sdf.format(datumCas)+": "+"LOG ZALOŽEN");
	        bw.newLine();
	        bw.flush();
	        bw.close();
    	}
    	catch (Exception e)	{
	        System.out.println("Log se nepovedlo vytvořit.");
    	}
	}
	
	public void pridejZapisDoLogu(String udalost) {
		try {
			BufferedWriter bw = new BufferedWriter(new FileWriter(souborLogu, true));
			Date datumCas = new Date();
	        bw.write(sdf.format(datumCas)+": "+udalost);
	        bw.newLine();
	        bw.flush();
	        bw.close();
    	}
    	catch (Exception e)	{
	        System.out.println("Do logu se nepovedlo zapsat.");
    	}			
	} 
	
	public void vypisLog() {
	   	try {
			BufferedReader br = new BufferedReader(new FileReader(souborLogu));
	        String s;
	        while ( (s = br.readLine() ) != null)
	        {
	                System.out.println(s);
	        }
	        br.close();
    	} catch (Exception e){
	        System.out.println("Nepodařilo se vypsat log.");
    	}

	}

}
