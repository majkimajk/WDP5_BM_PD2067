package zad3;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PipedWriter;
import java.util.Scanner;

public class WątekA extends Thread {
	
	private int idTowaru;
	private int wagaTowaru;
	private int counter = 0;
	private PipedWriter WriterPipe;

	Towar twr;

	public WątekA(Towar t) {
		
		twr = t;
		WriterPipe = new PipedWriter();
		twr.WriterPipe = WriterPipe;
	}

	File f = new File("../Towary.txt");


	public void run() {

		File f = new File("../Towary.txt");
		Scanner scan = null;
		try {
			scan = new Scanner(f);
		} catch (FileNotFoundException e) {
			System.out.println("nie mam pliku");
			e.printStackTrace();
		}

		
		while (scan.hasNextInt()) {

			idTowaru = scan.nextInt();
			wagaTowaru= scan.nextInt();
			counter++;
			if(counter % 200 == 0) {
				System.out.println("utworzono " + counter + " obiektów");
			}
			try {
				WriterPipe.write(wagaTowaru);
				WriterPipe.flush();
			} catch (IOException e) {
				e.printStackTrace();
			}


		}

		try {
			WriterPipe.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}

