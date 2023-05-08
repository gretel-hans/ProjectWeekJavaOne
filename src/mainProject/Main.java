package mainProject;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Vuoi creare dei nuovi elementi multimediali o visualizzarne alcuni già creati?\ns -> Creazione e visualizzaione\nn -> Visualizzazione elementi già creati ");
		boolean rispostaIniziale;
		do{
			String rispostaCreazione = sc.nextLine().toLowerCase();
			rispostaIniziale=false;
			if (rispostaCreazione.equals("s")) {
				creazioneLetturaElementiMultimediali();
				rispostaIniziale=true;
			} else if (rispostaCreazione.equals("n")) {
				visualizzazioneElementiMultimediali();
				rispostaIniziale=true;
			}else{
				System.out.println("Errore nella scelta.\ns -> Creazione e visualizzaione Elementi Multimediali\nn -> Visualizzazione Elementi Multimediali già creati");
			}

		}while(!rispostaIniziale);
	}

	public static void creazioneLetturaElementiMultimediali() {
		ElementoMultimediale[] arr = new ElementoMultimediale[5];
		System.out.println(
				"Digita 'audio' per creare un nuovo Audio\nDigita 'video' per creare un nuovo Video\nDigita 'img' per creare una nuova Immagine");
		for (int i = 0; i < 5; i++) {
			boolean prossimo;
			Scanner st = new Scanner(System.in);
			do {
				System.out.println("Creazione del " + (i + 1) + "º Elemento Multimediale: ");
				String tipo = st.nextLine().toLowerCase();
				prossimo = false;
				switch (tipo) {
					case ("audio"):
						System.out.println("Digita il titolo dell'audio");
						String titoloAudio = st.nextLine();
						boolean VerificaDurataAudio;
						do {
							VerificaDurataAudio = false;
							System.out.println("Digita la durata dell'audio (Min '1' - Max '10')");
							int durataAudio = st.nextInt();
							if (durataAudio >= 1 && durataAudio <= 10) {
								arr[i] = new Audio(titoloAudio, durataAudio);
								VerificaDurataAudio = true;
							} else {
								System.out.println("ERRORE! Valore fuori raggio");
							}
						} while (!VerificaDurataAudio);
						gestioneVolume(arr, i);
						System.out.println(arr[i]);
						prossimo = true;
						break;

					case ("video"):
						System.out.println("Digita il titolo del video");
						String titoloVideo = st.nextLine();
						boolean VerificaDurataVideo;
						do {
							VerificaDurataVideo = false;
							System.out.println("Digita la durata del video (Min '1' - Max '10')");
							int durataVideo = st.nextInt();
							if (durataVideo >= 1 && durataVideo <= 10) {
								arr[i] = new Video(titoloVideo, durataVideo);
								VerificaDurataVideo = true;
							} else {
								System.out.println("ERRORE! Valore fuori raggio");
							}
						} while (!VerificaDurataVideo);

						gestioneVolume(arr, i);
						gestioneLuminosita(arr, i, "Video");

						System.out.println(arr[i]);
						prossimo = true;
						break;

					case ("img"):
						System.out.println("Digita il titolo dell'immagine");
						String titoloImmagine = st.nextLine();
						arr[i] = new Immagine(titoloImmagine);
						gestioneLuminosita(arr, i, "immagine");
						System.out.println(arr[i]);
						prossimo = true;
						break;

					default:
						System.out.println("ERRORE hai digitato l'elemento sbagliato\n'audio' -> creazione nuovo Audio\n'video' -> creazione nuovo Video\n'img' -> creazione nuova Immagine");
				}
			} while (!prossimo);
		}

		riproduzioneElementi(arr);
	}

	public static void visualizzazioneElementiMultimediali() {
		ElementoMultimediale[] arr2 = new ElementoMultimediale[5];
		arr2[0] = new Video("Video Divertenti", 8, 2, 6);
		arr2[1] = new Immagine("Quadro fiori", 3);
		arr2[2] = new Audio("Happy birthday Sfera Ebbasta", 3, 7);
		arr2[3] = new Video("Inter - Milan highlights", 5, 8, 3);
		arr2[4] = new Immagine("Tramonto al mare", 10);

		for (int i = 0; i < arr2.length; i++) {
			System.out.println(arr2[i]);
		}

		riproduzioneElementi(arr2);
	}

	public static void riproduzioneElementi(ElementoMultimediale[] ar) {

		System.out.println("Vuoi visualizzare/riprodurre qualcosa? (s -> per avanzare | 0 -> per uscire)");
		boolean riproduzioneVisualizza;
		Scanner sv = new Scanner(System.in);

		do {

			String rispostaRiproduzione = sv.nextLine().toLowerCase();
			riproduzioneVisualizza = false;
			if (rispostaRiproduzione.equals("s")) {
				System.out.println("Ecco l'elenco degli Elementi Multimediali disponibili: ");
				boolean rispostaCorretta;
				int scelta;
				do {
					rispostaCorretta = false;
					for (int i = 0; i < ar.length; i++) {
						if (ar[i] instanceof Audio || ar[i] instanceof Video) {
							System.out.println("Digita: " + (i + 1) + " per riprodurre : " + ar[i]);
						} else if (ar[i] instanceof Immagine) {
							System.out.println("Digita: " + (i + 1) + " per vedere : " + ar[i]);
						}
					}
					scelta = sv.nextInt();
					if (scelta >= 1 && scelta <= 5) {
						rispostaCorretta = true;
					} else {
						System.out.println("ERRORE! Scelta Non Valida");
					}

				} while (!rispostaCorretta);

				if (ar[scelta - 1] instanceof Audio) {
					Audio a = (Audio) ar[scelta - 1];
					a.play();
					System.out.print("Vuoi riprodurre qualcosa? ('s' per avanzare '0' per uscire) ");
					rispostaRiproduzione = sv.nextLine().toLowerCase();

				} else if (ar[scelta - 1] instanceof Video) {
					Video v = (Video) ar[scelta - 1];
					v.play();
					System.out.print("Vuoi riprodurre qualcosa? ('s' per avanzare '0' per uscire) ");
					rispostaRiproduzione = sv.nextLine().toLowerCase();

				} else if (ar[scelta - 1] instanceof Immagine) {
					Immagine i = (Immagine) ar[scelta - 1];
					i.show();
					System.out.print("Vuoi riprodurre qualcosa? ('s' per avanzare '0' per uscire) ");
					rispostaRiproduzione = sv.nextLine().toLowerCase();
				}

			} else if (rispostaRiproduzione.equals("0")) {
				System.out.println("Grazie per aver utilizzato il sistema di Elementi Multimediali, arrivederci!");
				riproduzioneVisualizza = true;
			} else {
				System.out.println(
						"ERRORE! Hai digitato la cosa sbagliata\nPreme 's' per visualizzare gli elementi e 'n' per uscire");
			}

		} while (!riproduzioneVisualizza);
	}

	public static void gestioneLuminosita(ElementoMultimediale[] arr, int i, String tipo) {
		Scanner st = new Scanner(System.in);
		boolean luminositaVideoModificato;
		System.out.println("Modifica luminosità " + tipo + ", valore attuale:5 (a -> aumentare - d -> diminuire)");
		do {
			luminositaVideoModificato = false;
			String aumentoDiminuiscoVideo = st.nextLine().toLowerCase();
			if (aumentoDiminuiscoVideo.equals("a")) {
				boolean aumentoLuminositaVideoValido;
				System.out.println("Digita la quantità di aumento (Min '0' - Max '5')");
				do {
					aumentoLuminositaVideoValido = false;
					int aumento = st.nextInt();
					if (aumento >= 0 && aumento <= 5) {
						if (arr[i] instanceof Video) {
							Video v = (Video) arr[i];
							v.aumentaLuminosita(aumento);
							aumentoLuminositaVideoValido = true;
							luminositaVideoModificato = true;
						} else if (arr[i] instanceof Immagine) {
							Immagine im = (Immagine) arr[i];
							im.aumentaLuminosita(aumento);
							aumentoLuminositaVideoValido = true;
							luminositaVideoModificato = true;
						}
					} else {
						System.out.println("ERRORE! Valore fuori raggio\nAumento Min '0' - Max '5'");
					}
				} while (!aumentoLuminositaVideoValido);
			} else if (aumentoDiminuiscoVideo.equals("d")) {
				boolean diminuiscoValido;
				System.out.println("Digita la quantità di decremento (Min '0' - Max '5')");
				do {
					diminuiscoValido = false;
					int diminuisco = st.nextInt();
					if (diminuisco >= 0 && diminuisco <= 5) {
						if (arr[i] instanceof Video) {
							Video v = (Video) arr[i];
							v.diminuisciLuminosita(diminuisco);
							diminuiscoValido = true;
							luminositaVideoModificato = true;
						} else if (arr[i] instanceof Immagine) {
							Immagine im = (Immagine) arr[i];
							im.diminuisciLuminosita(diminuisco);
							diminuiscoValido = true;
							luminositaVideoModificato = true;
						}
					} else {
						System.out.println("ERRORE! Valore fuori raggio\nDecremento Min '0' - Max '5'");
					}
				} while (!diminuiscoValido);
			} else {
				System.out.println("ERRORE! Valore non valido\n'd' -> per decrementare - 'a' -> per aumentare ");
			}
		} while (!luminositaVideoModificato);
	}

	public static void gestioneVolume(ElementoMultimediale[] arr, int i) {
		Scanner st = new Scanner(System.in);
		boolean volumeVideoModificato;
		System.out.println("Modifica volume del video, valore attuale:5 (a -> aumentare - d -> diminuire)");
		do {
			volumeVideoModificato = false;
			String aumentoDiminuisco = st.nextLine().toLowerCase();
			if (aumentoDiminuisco.equals("a")) {
				boolean aumentoValido;
				System.out.println("Digita la quantità di aumento (Min '0' - Max '5')");
				do {
					aumentoValido = false;
					int aumento = st.nextInt();
					if (aumento >= 0 && aumento <= 5) {
						if (arr[i] instanceof Video) {
							Video v = (Video) arr[i];
							v.aumentaVolume(aumento);
							aumentoValido = true;
							volumeVideoModificato = true;
						} else if (arr[i] instanceof Audio) {
							Audio a = (Audio) arr[i];
							a.alzaVolume(aumento);
							aumentoValido = true;
							volumeVideoModificato = true;
						}
					} else {
						System.out.println("ERRORE! Valore fuori raggio\nMin '0' - Max '5'");
					}
				} while (!aumentoValido);
			} else if (aumentoDiminuisco.equals("d")) {
				boolean diminuiscoValido;
				System.out.println("Digita la quantità di decremento (Min '0' - Max '5')");
				do {
					diminuiscoValido = false;
					int diminuisco = st.nextInt();
					if (diminuisco >= 0 && diminuisco <= 5) {
						if (arr[i] instanceof Video) {
							Video v = (Video) arr[i];
							v.diminuisciVolume(diminuisco);
							diminuiscoValido = true;
							volumeVideoModificato = true;
						} else if (arr[i] instanceof Audio) {
							Audio a = (Audio) arr[i];
							a.abbassaVolume(diminuisco);
							diminuiscoValido = true;
							volumeVideoModificato = true;
						}
					} else {
						System.out.println("ERRORE! Valore fuori raggio\nMin '0' - Max '5'");
					}
				} while (!diminuiscoValido);
			} else {
				System.out.println("ERRORE! Valore non valido\na -> aumentare - d -> diminuire");
			}
		} while (!volumeVideoModificato);
	}
}
