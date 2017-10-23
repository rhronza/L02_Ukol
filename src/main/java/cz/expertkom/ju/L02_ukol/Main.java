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
		
		aktualniPocasi="Aktuální poèasí pro mìsto: "+pocasi.getOdpovedAktualniPocasi().getBody().getObject().getString("name")+"\n"+
						"  teplota aktuální:	   "+pocasi.getOdpovedAktualniPocasi().getBody().getObject().getJSONObject("main").getDouble("temp")+"\n"+
						"  teplota minimální:	   "+pocasi.getOdpovedAktualniPocasi().getBody().getObject().getJSONObject("main").getDouble("temp_min")+"\n"+
						"  teplota maximální:	   "+pocasi.getOdpovedAktualniPocasi().getBody().getObject().getJSONObject("main").getDouble("temp_max")+"\n"+
						"  tlak:            	   "+pocasi.getOdpovedAktualniPocasi().getBody().getObject().getJSONObject("main").getDouble("pressure")+"\n"+
						"  rychlost vìtru:         "+pocasi.getOdpovedAktualniPocasi().getBody().getObject().getJSONObject("wind").getDouble("speed")+"\n"+
						"  popis:                  "+pocasi.getOdpovedAktualniPocasi().getBody().getObject().getJSONArray("weather").getJSONObject(0).getString("description");
		
		System.out.println(aktualniPocasi);
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
