package zad2;


import java.util.ArrayList;

public class Letters  {

	private ArrayList<String> znaki = new ArrayList<String>();
	private ArrayList<Thread> wątki = new ArrayList<Thread>();
	private String napis;
	
	
	public Letters(String litery) {
		
		napis = litery;
		for (int i = 0; i < napis.length(); i++) {
		znaki.add(String.valueOf(napis.charAt(i)));
		
		}
		for (int j = 0; j < znaki.size(); j++) {
			 PrintLetter wątek = new PrintLetter(znaki.get(j));
			 wątek.setName("Thread " + znaki.get(j));
			 
			 wątki.add(wątek);
			
		}	
	}

	
	private class PrintLetter extends Thread {
		private String textToPrint;
		public PrintLetter(String text) {
			textToPrint = text;
		}
		
		 public void run() {
			 while(true) {
				 System.out.print(textToPrint);
				 try {
					Thread.sleep(1000);
				} catch (InterruptedException exc) {
					return;
			
				}
			 }
		 }
	}
	
	public ArrayList<Thread> getThreads() {
		
		return wątki;		
	}
	

}
