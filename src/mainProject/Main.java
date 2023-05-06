package mainProject;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		creazioneLetturaElementiMultimediali();

	}

	public static void creazioneLetturaElementiMultimediali() {
		ElementoMultimediale[] arr = new ElementoMultimediale[5];
		System.out.println(
				"Digita 'Audio' per creare un nuovo Audio\nDigita 'Video' per creare un nuovo Video\nDigita 'Img' per creare una nuova Immagine");
		for (int i = 0; i < 5; i++) {
			boolean prossimo;
			Scanner st = new Scanner(System.in);
			do {
				System.out.println("Creazione del " + (i + 1) + "º Elemento Multimediale: ");
				String tipo = st.nextLine();
				prossimo = false;
				switch (tipo) {
					case ("Audio"):
						System.out.println("Digita il titolo dell'audio");
						String titoloAudio = st.nextLine();
						boolean VerificaDurataAudio;
						do {
							VerificaDurataAudio = false;
							System.out.println("Digita la durata dell'audio (Min 1 - Max 10)");
							int durataAudio = st.nextInt();
							if (durataAudio >= 1 && durataAudio <= 10) {
								arr[i] = new Audio(titoloAudio, durataAudio);
								VerificaDurataAudio = true;
							}
						} while (!VerificaDurataAudio);
						System.out.println(arr[i]);
						prossimo = true;
						break;

					case ("Video"):
						System.out.println("Digita il titolo del video");
						String titoloVideo = st.nextLine();
						boolean VerificaDurataVideo;
						do {
							VerificaDurataVideo = false;
							System.out.println("Digita la durata del video");
							int durataVideo = st.nextInt();
							if (durataVideo >= 1 && durataVideo <= 10) {
								arr[i] = new Video(titoloVideo, durataVideo);
								VerificaDurataVideo = true;
							}
						} while (!VerificaDurataVideo);
						System.out.println(arr[i]);
						prossimo = true;
						break;

					case ("Img"):
						System.out.println("Digita il titolo dell'immagine");
						String titoloImmagine = st.nextLine();
						arr[i] = new Immagine(titoloImmagine);
						System.out.println(arr[i]);
						prossimo = true;
						break;

					default:
						System.out.println("ERRORE hai digitato l'elemento sbagliato");
				}
			} while (!prossimo);
		}
		boolean riproduzione;
		Scanner sd = new Scanner(System.in);
		do {
			riproduzione = false;
			System.out.print("Vuoi riprodurre qualcosa? ('Si' per avanzare 'No' per uscire) ");
			String rispostaRiproduzione = sd.nextLine();
			if (rispostaRiproduzione.equals("Si")) {
				System.out.println("Ecco l'elenco degli Elementi Multimediali disponibili: ");
				for (int i = 0; i < arr.length; i++) {
					if (arr[i] instanceof Audio || arr[i] instanceof Video) {
						System.out.println("Digita: " + (i + 1) + " per riprodurre : " + arr[i]);
					} else if (arr[i] instanceof Immagine) {
						System.out.println("Digita: " + (i + 1) + " per vedere : " + arr[i]);
					}
				}
				int scelta = sd.nextInt();

				if (arr[scelta - 1] instanceof Audio) {
					Audio a = (Audio) arr[scelta - 1];
					a.play();
				} else if (arr[scelta - 1] instanceof Video) {
					Video v = (Video) arr[scelta - 1];
					v.play();
				} else if (arr[scelta - 1] instanceof Immagine) {
					Immagine i = (Immagine) arr[scelta - 1];
					i.show();
				}

			} else if (rispostaRiproduzione.equals("No") ) {
				System.out.println("Grazie per aver utilizzato il sistema di Elementi Multimediali, arrivederci!");
				riproduzione = true;
			}

		} while (!riproduzione);

	}

}
