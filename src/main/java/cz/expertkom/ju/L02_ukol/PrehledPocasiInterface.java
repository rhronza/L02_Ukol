package cz.expertkom.ju.L02_ukol;

import java.util.List;

import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;

public interface PrehledPocasiInterface {
	/* 
	 * vystavím jen get-y(), sety zůstanou v rozhraní skyryty - respektive 
	 * nebudou v rozhraní definovány, tj. nebude je možno v instanci použít 
	 * 
	 * */
	
	public List<String> getPrehledPocasiAktualni();
	
	public List<String> getPrehledPocasiPredpoved();
	
	public HttpResponse<JsonNode> getOdpovedPredpovedPocasi();
	
	public HttpResponse<JsonNode> getOdpovedAktualniPocasi();
}
