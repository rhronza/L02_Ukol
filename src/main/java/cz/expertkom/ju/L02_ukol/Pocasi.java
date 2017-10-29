package cz.expertkom.ju.L02_ukol;

import java.text.SimpleDateFormat;

import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.Unirest;

public class Pocasi {

	/* Most = 3070291, jiné ID města z tabulky */
	private static final String mesto = "3070291"; 
	
	/*metrické jednotky */
	private static final String units = "metric";

	/* jazyk český */
	private static final String lang = "cz";
	 
	/* API key - vygenerováno 23.10.2017*/
	private static final String apiKey = "3172100236108fdde8ea3c8d33d36a90";
	
	private static final String ZADOST_AKTUALNI_POCASI 	= "http://api.openweathermap.org/data/2.5/weather?id="+mesto+"&units="+units+"&lang="+lang+"&APPID="+apiKey;
	private static final String ZADOST_PREDPOVED_POCASI = "http://api.openweathermap.org/data/2.5/forecast?id="+mesto+"&units="+units+"&lang="+lang+"&APPID="+apiKey;

	/* 
	 * do těchto tříd se ukládají odpovědi na dotaz klienta metodou get() na server 
	 * (výsledky jsou ve formátu JS0ON) proměnné se inicializují v kontruktoru:
	 * 	 *  
	 *  */
	private HttpResponse<JsonNode> odpovedAktualniPocasi; 
	private HttpResponse<JsonNode> odpovedPredpovedPocasi;

	protected static final SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy HH:mm:ss");
	
	/* konstruktor */
	public Pocasi() throws MyException {
		
		/* ten blok try,catch jsem tam musel dát neb mi Eclipse stále obtěžovala, že mám neošetřenou výjimku :-)  */
		try {
			
			this.odpovedAktualniPocasi  = Unirest.get(ZADOST_AKTUALNI_POCASI). asJson();
			this.odpovedPredpovedPocasi = Unirest.get(ZADOST_PREDPOVED_POCASI).asJson();

		} catch (Exception e) {
			throw new MyException("Nepodařilo se získat data z webové stránky");			
		}
	}
	

	/*  JSON struktura odpovědi na žádost o AKTUÁLNÍ počasí: 
	{
	"coord":{"lon":-0.13,"lat":51.51},
	"weather":[{"id":300,"main":"Drizzle","description":"light intensity drizzle","icon":"09d"}],
	"base":"stations",
	"main":{"temp":280.32,"pressure":1012,"humidity":81,"temp_min":279.15,"temp_max":281.15},
	"visibility":10000,
	"wind":{"speed":4.1,"deg":80},
	"clouds":{"all":90},
	"dt":1485789600,
	"sys":{"type":1,"id":5091,"message":0.0103,"country":"GB","sunrise":1485762037,"sunset":1485794875},
	"id":2643743,
	"name":"London",
	"cod":200
	}
	 */
	public HttpResponse<JsonNode> getOdpovedAktualniPocasi() {
		return odpovedAktualniPocasi;
	}
   
	/* následují get-y(), které z JSON struktury "vyzobají" požadovaná data */
	
	public String getAktualniPocasiMesto() {
		  return  odpovedAktualniPocasi.getBody().getObject().getString("name");
	}
	
	public Double getAktualniTeplotaPrumer() {
		return odpovedAktualniPocasi.getBody().getObject().getJSONObject("main").getDouble("temp");
	}
	
	public Double getAktualniTeplotaMinnimalni() {
		return odpovedAktualniPocasi.getBody().getObject().getJSONObject("main").getDouble("temp_min");
	}
	
	public Double getAktualniTeplotaMaximalni() {
		return odpovedAktualniPocasi.getBody().getObject().getJSONObject("main").getDouble("temp_max");
	}

	public Double getAktualniTlak() {
		return odpovedAktualniPocasi.getBody().getObject().getJSONObject("main").getDouble("pressure");
	}

	public Double getAktualniRychlostVetru() {
		return odpovedAktualniPocasi.getBody().getObject().getJSONObject("wind").getDouble("speed");
	}
	
	public String getAktualniPopis() {
		return odpovedAktualniPocasi.getBody().getObject().getJSONArray("weather").getJSONObject(0).getString("description");
	}
	
	
	/* JSON struktura odpovědi na žádost o PŘEDPOVĚĎ: 
	{
		"city":{"id":1851632,"name":"Shuzenji",
		"coord":{"lon":138.933334,"lat":34.966671},
		"country":"JP",
		"cod":"200",
		"message":0.0045,
		"cnt":38,
		"list":[{
		        "dt":1406106000,
		        "main":{
		            "temp":298.77,
		            "temp_min":298.77,
		            "temp_max":298.774,
		            "pressure":1005.93,
		            "sea_level":1018.18,
		            "grnd_level":1005.93,
		            "humidity":87
		            "temp_kf":0.26},
		        "weather":[{"id":804,"main":"Clouds","description":"overcast clouds","icon":"04d"}],
		        "clouds":{"all":88},
		        "wind":{"speed":5.71,"deg":229.501},
		        "sys":{"pod":"d"},
		        "dt_txt":"2014-07-23 09:00:00"}
		        ]
		        }
        */
	public HttpResponse<JsonNode> getOdpovedPredpovedPocasi() {
		return odpovedPredpovedPocasi;
	}
	
	/* následují get-y(), které z JSON struktury "vyzobají" požadovaná data */
	
	public String getPrepovedMesto(){
		return odpovedPredpovedPocasi.getBody().getObject().getJSONObject("city").getString("name");
	}
	
	public Double getPredpovedPrumernaTeplota() {
		return odpovedPredpovedPocasi.getBody().getObject().getJSONArray("list").getJSONObject(0).getJSONObject("main").getDouble("temp");
	}
	
	public Double getPredpovedTeplotaMinimalni() {
		return odpovedPredpovedPocasi.getBody().getObject().getJSONArray("list").getJSONObject(0).getJSONObject("main").getDouble("temp_min");
	}
	
	public Double getPredpovedTeplotaMaximalni() {
		return odpovedPredpovedPocasi.getBody().getObject().getJSONArray("list").getJSONObject(0).getJSONObject("main").getDouble("temp_max");
	}

	public Double getPredpovedTlak() {
		return odpovedPredpovedPocasi.getBody().getObject().getJSONArray("list").getJSONObject(0).getJSONObject("main").getDouble("pressure");
	}
	
	public Double getPredpovedRychlostVetru() {
		return odpovedPredpovedPocasi.getBody().getObject().getJSONArray("list").getJSONObject(0).getJSONObject("wind").getDouble("speed");
	}
	
	public String getPredpovedPopis() {
		return odpovedPredpovedPocasi.getBody().getObject().getJSONArray("list").getJSONObject(0).getJSONArray("weather").getJSONObject(0).getString("description");
	}
}

	
	
	
	
	
	
	
	
	


