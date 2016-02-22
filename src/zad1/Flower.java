package zad1;

public abstract class Flower {

	public Flower() {};
	String nazwa;
	int ilosc;
	String color;
	double cena;
	public String getColor() {
		return color;
	} 
	
}

class Rose extends Flower {

	public Rose(int ilosc) {
		super();
		this.ilosc = ilosc;
		color = "czerwony";
		nazwa = "róża";
	}

	
	
	
}

class Peony extends Flower {

	public Peony(int ilosc) {
		super();
		this.ilosc = ilosc;
		color = "różowy";
		nazwa = "piwonia";
	}
	
	
	
}

class Freesia extends Flower {

	public Freesia(int ilosc) {
		super();
		this.ilosc = ilosc;
		color = "żółte";
		nazwa = "frezja";
	}
	
	
	
}

class Lilac extends Flower {

	public Lilac(int ilosc) {
		super();
		this.ilosc = ilosc;
		color = "różowy";
		nazwa = "bez";
	}
	
	
	
	
}
