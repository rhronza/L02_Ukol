package cz.expertkom.ju.L02_ukol;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/*
 *  počasí pomocí API portálu http://openweathermap.org/api a knihovny UNIREST
 * 
 */

public class PrehledPocasi extends Pocasi implements PrehledPocasiInterface{


    private List<String> prehledPocasiAktualni = new ArrayList<String>();
    private List<String> prehledPocasiPredpoved = new ArrayList<String>();
	
	public PrehledPocasi() {
		super();
		
		/* naplnění seznamu aktuálního počasí */ 
		this.prehledPocasiAktualni.add("Aktuální počasí pro město: "+getAktualniPocasiMesto());
		this.prehledPocasiAktualni.add("         teplota průměrná: "+getAktualniTeplotaPrumer().toString());
		this.prehledPocasiAktualni.add("        teplota minimální: "+getAktualniTeplotaMinnimalni().toString());
		this.prehledPocasiAktualni.add("        teplota maximální: "+getAktualniTeplotaMaximalni().toString());
		this.prehledPocasiAktualni.add("           rychlost větru: "+getAktualniRychlostVetru().toString());
		this.prehledPocasiAktualni.add("                     tlak: "+getAktualniTlak().toString());
		this.prehledPocasiAktualni.add("                    popis: "+getAktualniPopis());
		Date datumCas = new Date();
		
		
		/* naplnění seznamu předpovědi počasí */
		this.prehledPocasiPredpoved.add("Předpověď počasí pro město: "+getPrepovedMesto());
		this.prehledPocasiPredpoved.add("         teplota průměrná: "+getPredpovedPrumernaTeplota().toString());
		this.prehledPocasiPredpoved.add("        teplota minimální: "+getPredpovedTeplotaMinimalni().toString());
		this.prehledPocasiPredpoved.add("        teplota maximální: "+getPredpovedTeplotaMaximalni().toString());
		this.prehledPocasiPredpoved.add("           rychlost větru: "+getPredpovedRychlostVetru().toString());
		this.prehledPocasiPredpoved.add("                     tlak: "+getPredpovedTlak().toString());
		this.prehledPocasiPredpoved.add("                    popis: "+getPredpovedPopis());

		
	}

	public List<String> getPrehledPocasiAktualni() {
		return prehledPocasiAktualni;
	}

	public void setPrehledPocasiAktualni(List<String> prehledPocasiAktualni) {
		this.prehledPocasiAktualni = prehledPocasiAktualni;
	}

	public List<String> getPrehledPocasiPredpoved() {
		return prehledPocasiPredpoved;
	}

	public void setPrehledPocasiPredpoved(List<String> prehledPocasiPredpoved) {
		this.prehledPocasiPredpoved = prehledPocasiPredpoved;
	}




}

