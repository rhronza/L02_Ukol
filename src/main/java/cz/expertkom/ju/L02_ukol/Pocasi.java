package cz.expertkom.ju.L02_ukol;

import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.Unirest;

/*
 *  po�as� pomoc� API port�lu http://openweathermap.org/api
 * 
 */

public class Pocasi {


	/* Most = 3070291, jin� ID m�sta z tabulky */
	private static final String mesto = "3070291"; 
	
	/*metrick� jednotky */
	private static final String units = "metric";

	/* jazyk �esk� */
	private static final String lang = "cz";
	
	/* API key - vygenerov�no 23.10.2017*/
	private static final String apiKey = "3172100236108fdde8ea3c8d33d36a90";
	
	private static final String ZADOST_AKTUALNI_POCASI 	= "http://api.openweathermap.org/data/2.5/weather?id="+mesto+"&units="+units+"&lang="+lang+"&APPID="+apiKey;
	private static final String ZADOST_PREDPOVED_POCASI = "http://api.openweathermap.org/data/2.5/forecast?id="+mesto+"&units="+units+"&lang="+lang+"&APPID="+apiKey;

	/* 
	 * do t��d se ukl�daj� v�sledky po dotazu klienta metodou get() na server 
	 * (ve form�tu JSON) prom�nn� se inicializuj� v kontruktoru:
	 * 	 *  
	 *  */
	private HttpResponse<JsonNode> odpovedAktualniPocasi; 
	private HttpResponse<JsonNode> odpovedPredpovedPocasi;
	
	public Pocasi() {
		
		/* ten blok try,catch jsem tam musel d�t neb m� Eclipse st�le obt�ovala, �e m�m neo�et�enou v�jimku :-)  */
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

