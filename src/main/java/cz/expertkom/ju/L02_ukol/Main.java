package cz.expertkom.ju.L02_ukol;

/*
 * Aktuální poèasí a jeho pøedpovìï pomocí API portálu http://openweathermap.org/api
 * 
 * Aplikaèní logika je ve tøídì "Pocasi" 
 * 
 */

public class Main {

	public static void main(String[] args) {

		Pocasi pocasi = new Pocasi();
		
		String aktualniPocasi;
		String predpovedPocasi;
		
		/*  JSON struktura odpovìdi na žádost o aktuální poèasí: 
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
		
		aktualniPocasi="Aktuální poèasí pro mìsto: "+pocasi.getOdpovedAktualniPocasi().getBody().getObject().getString("name")+"\n"+
						"  teplota aktuální:	   "+pocasi.getOdpovedAktualniPocasi().getBody().getObject().getJSONObject("main").getDouble("temp")+"\n"+
						"  teplota minimální:	   "+pocasi.getOdpovedAktualniPocasi().getBody().getObject().getJSONObject("main").getDouble("temp_min")+"\n"+
						"  teplota maximální:	   "+pocasi.getOdpovedAktualniPocasi().getBody().getObject().getJSONObject("main").getDouble("temp_max")+"\n"+
						"  tlak:            	   "+pocasi.getOdpovedAktualniPocasi().getBody().getObject().getJSONObject("main").getDouble("pressure")+"\n"+
						"  rychlost vìtru:         "+pocasi.getOdpovedAktualniPocasi().getBody().getObject().getJSONObject("wind").getDouble("speed")+"\n"+
						"  popis:                  "+pocasi.getOdpovedAktualniPocasi().getBody().getObject().getJSONArray("weather").getJSONObject(0).getString("description");
		
		System.out.println(aktualniPocasi);
		
		
		/* JSON struktura odpovìdi na žádost o pøedpovìï: 
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
		
		predpovedPocasi="\n"+
						"Pøedpovìï poèasí na 5 dnù pro mìsto: "+pocasi.getOdpovedPredpovedPocasi().getBody().getObject().getJSONObject("city").getString("name")+"\n"+
				        "  teplota:                  "+pocasi.getOdpovedPredpovedPocasi().getBody().getObject().getJSONArray("list").getJSONObject(0).getJSONObject("main").getDouble("temp")+"\n"+
						"  teplota minimální:        "+pocasi.getOdpovedPredpovedPocasi().getBody().getObject().getJSONArray("list").getJSONObject(0).getJSONObject("main").getDouble("temp_min")+"\n"+
						"  teplota maximální:        "+pocasi.getOdpovedPredpovedPocasi().getBody().getObject().getJSONArray("list").getJSONObject(0).getJSONObject("main").getDouble("temp_max")+"\n"+
						"  tlak:                     "+pocasi.getOdpovedPredpovedPocasi().getBody().getObject().getJSONArray("list").getJSONObject(0).getJSONObject("main").getDouble("pressure")+"\n"+
						"  rychlost vìtru:           "+pocasi.getOdpovedPredpovedPocasi().getBody().getObject().getJSONArray("list").getJSONObject(0).getJSONObject("wind").getDouble("speed")+"\n"+
						"  popis:                    "+pocasi.getOdpovedPredpovedPocasi().getBody().getObject().getJSONArray("list").getJSONObject(0).getJSONArray("weather").getJSONObject(0).getString("description")+"\n";
		System.out.println(predpovedPocasi);
		
	}

}
