package mainProject;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Vuoi creare dei nuovi elementi multimediali o visualizzarne alcuni già creati?\ns -> Creazione e visualizzaione\nn -> Visualizzazione elementi già creati ");
		String rispostaCreazione=sc.nextLine();
		if(rispostaCreazione.equals("s")){
			creazioneLetturaElementiMultimediali();
		}else if(rispostaCreazione.equals("n")){
			visualizzazioneElementiMultimediali();
		}

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
				String tipo = st.nextLine();
				prossimo = false;
				switch (tipo) {
					case ("audio"):
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

						boolean volumeAudioModificato;	
							do{
								volumeAudioModificato=false;
								System.out.println("Modifica volume dell'audio, valore attuale:5 (a -> aumentare - d -> diminuire)");
								String aumentoDiminuisco=st.nextLine();
								if(aumentoDiminuisco.equals("a")){
									boolean aumentoValido;
									do{
										aumentoValido=false;
										System.out.println("Digita la quantità di aumento (Min 0 - Max 5)");
										int aumento = st.nextInt();
										if(aumento>=0 && aumento<=5){
											Audio a = (Audio) arr[i]; 
											a.alzaVolume(aumento);
											aumentoValido = true;
											volumeAudioModificato=true;
										}
									}while(!aumentoValido);
								}else if(aumentoDiminuisco.equals("d")){
									boolean diminuiscoValido;
									do{
										diminuiscoValido=false;
										System.out.println("Digita la quantità di decremento (Min 0 - Max 5)");
										int diminuisco = st.nextInt();
										if(diminuisco>=0 && diminuisco<=5){
											Audio a = (Audio) arr[i]; 
											a.alzaVolume(diminuisco);
											diminuiscoValido = true;
											volumeAudioModificato=true;
										}
									}while(!diminuiscoValido);
								}
							}while(!volumeAudioModificato);
						System.out.println(arr[i]);
						prossimo = true;
						break;

					case ("video"):
						System.out.println("Digita il titolo del video");
						String titoloVideo = st.nextLine();
						boolean VerificaDurataVideo;
						do {
							VerificaDurataVideo = false;
							System.out.println("Digita la durata del video (Min 1 - Max 10)");
							int durataVideo = st.nextInt();
							if (durataVideo >= 1 && durataVideo <= 10) {
								arr[i] = new Video(titoloVideo, durataVideo);
								VerificaDurataVideo = true;
							}
						} while (!VerificaDurataVideo);

						boolean volumeVideoModificato;	
							do{
								volumeVideoModificato=false;
								System.out.println("Modifica volume del video, valore attuale:5 (a -> aumentare - d -> diminuire)");
								String aumentoDiminuisco=st.nextLine();
								if(aumentoDiminuisco.equals("a")){
									boolean aumentoValido;
									do{
										aumentoValido=false;
										System.out.println("Digita la quantità di aumento (Min 0 - Max 5)");
										int aumento = st.nextInt();
										if(aumento>=0 && aumento<=5){
											Video v = (Video) arr[i]; 
											v.aumentaVolume(aumento);
											aumentoValido = true;
											volumeVideoModificato=true;
										}
									}while(!aumentoValido);
								}else if(aumentoDiminuisco.equals("d")){
									boolean diminuiscoValido;
									do{
										diminuiscoValido=false;
										System.out.println("Digita la quantità di decremento (Min 0 - Max 5)");
										int diminuisco = st.nextInt();
										if(diminuisco>=0 && diminuisco<=5){
											Video v = (Video) arr[i]; 
											v.diminuisciVolume(diminuisco);
											diminuiscoValido = true;
											volumeVideoModificato=true;
										}
									}while(!diminuiscoValido);
								}
							}while(!volumeVideoModificato);

							
							boolean luminositaVideoModificato;
							do{
								luminositaVideoModificato=false;
								System.out.println("Modifica della luminosità del video , valore attuale:5 (a -> aumentare - d -> diminuire)");
								String aumentoDiminuiscoVideo=st.nextLine();
								if(aumentoDiminuiscoVideo.equals("a")){
									boolean aumentoLuminositaVideoValido;
									do{
										aumentoLuminositaVideoValido=false;
										System.out.println("Digita la quantità di aumento (Min 0 - Max 5)");
										int aumento = st.nextInt();
										if(aumento>=0 && aumento<=5){
											Video v = (Video) arr[i]; 
											v.aumentaLuminosita(aumento);
											aumentoLuminositaVideoValido = true;
											luminositaVideoModificato=true;
										}
									}while(!aumentoLuminositaVideoValido);
								}else if(aumentoDiminuiscoVideo.equals("d")){
									boolean diminuiscoValido;
									do{
										diminuiscoValido=false;
										System.out.println("Digita la quantità di decremento (Min 0 - Max 5)");
										int diminuisco = st.nextInt();
										if(diminuisco>=0 && diminuisco<=5){
											Video v = (Video) arr[i]; 
											v.diminuisciLuminosita(diminuisco);
											diminuiscoValido = true;
											luminositaVideoModificato=true;
										}
									}while(!diminuiscoValido);
								}
							}while(!luminositaVideoModificato);


						System.out.println(arr[i]);
						prossimo = true;
						break;

					case ("img"):
						System.out.println("Digita il titolo dell'immagine");
						String titoloImmagine = st.nextLine();
						arr[i] = new Immagine(titoloImmagine);
						boolean luminositaImmagineModificato;
							
							do{
								luminositaImmagineModificato=false;
								System.out.println("Modifica della luminosità dell'immagine , valore attuale:5 (a -> aumentare - d -> diminuire)");
								String aumentoDiminuisco=st.nextLine();
								if(aumentoDiminuisco.equals("a")){
									boolean aumentoLuminositaImgValido;
									do{
										aumentoLuminositaImgValido=false;
										System.out.println("Digita la quantità di aumento (Min 0 - Max 5)");
										int aumento = st.nextInt();
										if(aumento>=0 && aumento<=5){
											Immagine im = (Immagine) arr[i]; 
											im.aumentaLuminosita(aumento);
											aumentoLuminositaImgValido = true;
											luminositaImmagineModificato=true;
										}
									}while(!aumentoLuminositaImgValido);
								}else if(aumentoDiminuisco.equals("d")){
									boolean diminuiscoValido;
									do{
										diminuiscoValido=false;
										System.out.println("Digita la quantità di decremento (Min 0 - Max 5)");
										int diminuisco = st.nextInt();
										if(diminuisco>=0 && diminuisco<=5){
											Immagine im = (Immagine) arr[i]; 
											im.diminuisciLuminosita(diminuisco);
											diminuiscoValido = true;
											luminositaImmagineModificato=true;
										}
									}while(!diminuiscoValido);
								}
							}while(!luminositaImmagineModificato);
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
		System.out.print("Vuoi riprodurre/vedere qualcosa? ('s' per avanzare | 'n' per uscire) ");
		do {
			//System.out.print("Vuoi riprodurre qualcosa? ('Si' per avanzare 'No' per uscire) ");
			String rispostaRiproduzione = sd.nextLine();
			riproduzione = false;
			if (rispostaRiproduzione.equals("s")) {
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
					System.out.print("Vuoi riprodurre qualcosa? ('s' per avanzare 'n' per uscire) ");
					 rispostaRiproduzione = sd.nextLine();

				} else if (arr[scelta - 1] instanceof Video) {
					Video v = (Video) arr[scelta - 1];
					v.play();
					System.out.print("Vuoi riprodurre qualcosa? ('s' per avanzare 'n' per uscire) ");
					rispostaRiproduzione = sd.nextLine();

				} else if (arr[scelta - 1] instanceof Immagine) {
					Immagine i = (Immagine) arr[scelta - 1];
					i.show();
					System.out.print("Vuoi riprodurre qualcosa? ('s' per avanzare 'n' per uscire) ");
					rispostaRiproduzione = sd.nextLine();
				}

			} else if (rispostaRiproduzione.equals("n") ) {
				System.out.println("Grazie per aver utilizzato il sistema di Elementi Multimediali, arrivederci!");
				riproduzione = true;
			}

		} while (!riproduzione);

	}

	public static void visualizzazioneElementiMultimediali(){
		ElementoMultimediale[] arr2 = new ElementoMultimediale[5];
		arr2[0]= new Video("Video Divertenti", 8, 2, 6);
		arr2[1]= new Immagine("Quadro fiori", 3);
		arr2[2]= new Audio("Happy birthday Sfera Ebbasta", 3,7);
		arr2[3]= new Video("Inter - Milan highlights",5 , 8, 3);
		arr2[4]= new Immagine("Tramonto al mare",10);

		for (int i =0;i<arr2.length;i++){
			System.out.println(arr2[i]);
		}
		System.out.println("Vuoi visualizzare/riprodurre qualcosa? (s -> per avanzare | n -> per uscire)");

		boolean riproduzioneVisualizza;
		Scanner sv = new Scanner(System.in);

		do {
			String rispostaRiproduzione = sv.nextLine();
			riproduzioneVisualizza = false;
			if (rispostaRiproduzione.equals("s")) {
				System.out.println("Ecco l'elenco degli Elementi Multimediali disponibili: ");
				for (int i = 0; i < arr2.length; i++) {
					if (arr2[i] instanceof Audio || arr2[i] instanceof Video) {
						System.out.println("Digita: " + (i + 1) + " per riprodurre : " + arr2[i]);
					} else if (arr2[i] instanceof Immagine) {
						System.out.println("Digita: " + (i + 1) + " per vedere : " + arr2[i]);
					}
				}
				int scelta = sv.nextInt();

				if (arr2[scelta - 1] instanceof Audio) {
					Audio a = (Audio) arr2[scelta - 1];
					a.play();
					System.out.print("Vuoi riprodurre qualcosa? ('s' per avanzare 'n' per uscire) ");
					 rispostaRiproduzione = sv.nextLine();

				} else if (arr2[scelta - 1] instanceof Video) {
					Video v = (Video) arr2[scelta - 1];
					v.play();
					System.out.print("Vuoi riprodurre qualcosa? ('s' per avanzare 'n' per uscire) ");
					rispostaRiproduzione = sv.nextLine();

				} else if (arr2[scelta - 1] instanceof Immagine) {
					Immagine i = (Immagine) arr2[scelta - 1];
					i.show();
					System.out.print("Vuoi riprodurre qualcosa? ('s' per avanzare 'n' per uscire) ");
					rispostaRiproduzione = sv.nextLine();
				}

			} else if (rispostaRiproduzione.equals("n") ) {
				System.out.println("Grazie per aver utilizzato il sistema di Elementi Multimediali, arrivederci!");
				riproduzioneVisualizza = true;
			}

		} while (!riproduzioneVisualizza);

	}
}
