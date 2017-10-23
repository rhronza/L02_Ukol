package cz.expertkom.ju.L02_ukol;

import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.Unirest;

/*
 *  poèasí pomocí API portálu http://openweathermap.org/api
 * 
 */

public class Pocasi {


	/* Most = 3070291, jiná ID mìsta z tabulky */
	private static final String mesto = "3070291"; 
	
	/*metrické jednotky */
	private static final String units = "metric";

	/* jazyk èeský */
	private static final String lang = "cz";
	
	/* API key - vygenerováno 23.10.2017*/
	private static final String apiKey = "3172100236108fdde8ea3c8d33d36a90";
	
	private static final String ZADOST_AKTUALNI_POCASI 	= "http://api.openweathermap.org/data/2.5/weather?id="+mesto+"&units="+units+"&lang="+lang+"&APPID="+apiKey;
	private static final String ZADOST_PREDPOVED_POCASI = "http://api.openweathermap.org/data/2.5/forecast?id="+mesto+"&units="+units+"&lang="+lang+"&APPID="+apiKey;

	/* 
	 * do tøíd se ukládají výsledky po dotazu klienta metodou get() na server 
	 * (ve formátu JSON) promìnné se inicializují v kontruktoru:
	 * 	 *  
	 *  */
	private HttpResponse<JsonNode> odpovedAktualniPocasi; 
	private HttpResponse<JsonNode> odpovedPredpovedPocasi;
	
	public Pocasi() {
		
		/* ten blok try,catch jsem tam musel dát neb mì Eclipse stále obtìžovala, že mám neošetøenou výjimku :-)  */
		try {
			
			this.odpovedAktualniPocasi  = Unirest.get(ZADOST_AKTUALNI_POCASI). asJson();
			this.odpovedPredpovedPocasi = Unirest.get(ZADOST_PREDPOVED_POCASI).asJson();

		} catch (Exception e) {
			System.out.println("chyba: "+e.getLocalizedMessage());
		}
		
	}
	
	public HttpResponse<JsonNode> getOdpovedAktualniPocasi() {
		return odpovedAktualniPocasi;
	}
   
	public HttpResponse<JsonNode> getOdpovedPredpovedPocasi() {
		return odpovedPredpovedPocasi;
	}
	
	


}

