package mainProject;

public class Video extends ElementoMultimediale implements gestioneLuminosita {
    public int l = 5;
    private int durata;
    public int v = 5;

    public Video(String titolo, int durata) {
        super(titolo);
        this.durata = durata;
    }

    public Video(String titolo, int durata, int l, int v) {
        super(titolo);
        this.durata = durata;
        this.l=l;
        this.v=v;
    }

    public void aumentaLuminosita(int n) {
        this.l+=n;
    }

    public void diminuisciLuminosita(int n) {
        this.l-=n;
    }
    public int getLuminosita(){
        return this.l;
    }

    public void aumentaVolume(int aumento) {
        this.v+=aumento;
    }

    public void diminuisciVolume(int diminuisci) {
        this.v-=diminuisci;
    }

    public void setTitolo(String titolo) {
        super.titolo = titolo;
    }

    public String getTitolo() {
        return super.titolo;
    }

    public void setDurata(int durata) {
        this.durata = durata;
    }

    public int getDurata() {
        return this.durata;
    }

    public void play(){
        

        for(int i=0;i<this.durata;i++){
            System.out.print("Titolo video: "+super.titolo );
            for (int j=0;j<this.l;j++){
                System.out.print(" * ");
            }
            for (int s=0;s<this.v;s++){
                if(s==this.v-1){
                    System.out.println(" ! ");
                }else{
                    System.out.print(" ! ");
                }
            }
        }
    }

    @Override
    public String toString(){
        return "Video = [ Titolo video: "+ super.titolo + ", durata: "+ this.durata + "min, luminosità: "+ this.l + ", volume: "+this.v +  " ]";
    }

}
