package cz.expertkom.ju.L02_ukol;

/*
 * Aktu�ln� po�as� a jeho p�edpov�� pomoc� API port�lu http://openweathermap.org/api
 * 
 * Aplika�n� logika je ve t��d� "Pocasi" 
 * 
 */

public class Main {

	public static void main(String[] args) {

		Pocasi pocasi = new Pocasi();
		
		String aktualniPocasi;
		String predpovedPocasi;
		
		aktualniPocasi="Aktu�ln� po�as� pro m�sto: "+pocasi.getOdpovedAktualniPocasi().getBody().getObject().getString("name")+"\n"+
						"  teplota aktu�ln�:	   "+pocasi.getOdpovedAktualniPocasi().getBody().getObject().getJSONObject("main").getDouble("temp")+"\n"+
						"  teplota minim�ln�:	   "+pocasi.getOdpovedAktualniPocasi().getBody().getObject().getJSONObject("main").getDouble("temp_min")+"\n"+
						"  teplota maxim�ln�:	   "+pocasi.getOdpovedAktualniPocasi().getBody().getObject().getJSONObject("main").getDouble("temp_max")+"\n"+
						"  tlak:            	   "+pocasi.getOdpovedAktualniPocasi().getBody().getObject().getJSONObject("main").getDouble("pressure")+"\n"+
						"  rychlost v�tru:         "+pocasi.getOdpovedAktualniPocasi().getBody().getObject().getJSONObject("wind").getDouble("speed")+"\n"+
						"  popis:                  "+pocasi.getOdpovedAktualniPocasi().getBody().getObject().getJSONArray("weather").getJSONObject(0).getString("description");
		
		System.out.println(aktualniPocasi);
		predpovedPocasi="\n"+
						"P�edpov�� po�as� na 5 dn� pro m�sto: "+pocasi.getOdpovedPredpovedPocasi().getBody().getObject().getJSONObject("city").getString("name")+"\n"+
				        "  teplota:                  "+pocasi.getOdpovedPredpovedPocasi().getBody().getObject().getJSONArray("list").getJSONObject(0).getJSONObject("main").getDouble("temp")+"\n"+
						"  teplota minim�ln�:        "+pocasi.getOdpovedPredpovedPocasi().getBody().getObject().getJSONArray("list").getJSONObject(0).getJSONObject("main").getDouble("temp_min")+"\n"+
						"  teplota maxim�ln�:        "+pocasi.getOdpovedPredpovedPocasi().getBody().getObject().getJSONArray("list").getJSONObject(0).getJSONObject("main").getDouble("temp_max")+"\n"+
						"  tlak:                     "+pocasi.getOdpovedPredpovedPocasi().getBody().getObject().getJSONArray("list").getJSONObject(0).getJSONObject("main").getDouble("pressure")+"\n"+
						"  rychlost v�tru:           "+pocasi.getOdpovedPredpovedPocasi().getBody().getObject().getJSONArray("list").getJSONObject(0).getJSONObject("wind").getDouble("speed")+"\n"+
						"  popis:                    "+pocasi.getOdpovedPredpovedPocasi().getBody().getObject().getJSONArray("list").getJSONObject(0).getJSONArray("weather").getJSONObject(0).getString("description")+"\n";
		System.out.println(predpovedPocasi);
		
	}

}
