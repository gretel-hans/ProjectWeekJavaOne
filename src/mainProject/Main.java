package mainProject;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Video v1= new Video("Video testo",2);
		Scanner st= new Scanner(System.in);
		Scanner sd= new Scanner(System.in);

		System.out.print("Inserisci il titolo del video");
		String titolo=st.nextLine();
		System.out.print("Inserisci la durata di:"+ titolo);
		int durata=sd.nextInt();
		Video v2= new Video (titolo, durata);
		v2.play();

		v1.diminuisciLuminosita();
		v1.play();

	}

	public static void play(){

	}

}
