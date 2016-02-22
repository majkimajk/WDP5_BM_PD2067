package zad1;


import java.util.TreeMap;

public class PriceList {
	
	private static PriceList cennik;
	private PriceList() {
		mapa = new TreeMap<String, Double>();
	};

	
	
	
	public TreeMap<String, Double> mapa;
	

	
	public static PriceList getInstance() {
		if(cennik != null)
			return cennik;
		else {
			cennik = new PriceList();
			return cennik;
		}
	}
	
	protected void put(String kwiat, double cena){
		mapa.put(kwiat, cena);
	}
	




	

	
	

}
