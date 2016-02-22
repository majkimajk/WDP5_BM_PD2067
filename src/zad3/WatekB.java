package zad3;

import java.io.IOException;
import java.io.PipedReader;

public class WątekB extends Thread {
	

	private Towar twr;
	private PipedReader ReaderPipe;
	private long totalWeight = 0;
	private int counter = 0;
	
	WątekB(Towar t) {
		
		twr = t;
		ReaderPipe = new PipedReader();
		try {
			twr.WriterPipe.connect(ReaderPipe);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void run() {



		while(true) {
			try {
				int currentWeight = (int) ReaderPipe.read();
				if(currentWeight != -1) {
					totalWeight = totalWeight + (long) currentWeight;
				}
				else {
					break;
				}
				counter++;
				if(counter % 100 == 0) {
					System.out.println("policzono wagę " + counter + " towarów");
				}

			} catch (IOException e) {
				break;
			}
		}
		System.out.println(totalWeight);
	}

}
