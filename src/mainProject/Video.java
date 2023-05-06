package mainProject;

public class Video extends ElementoMultimediale implements gestioneLuminosita {
    public int l = 5;
    private int durata;
    public int v = 5;

    public Video(String titolo, int durata) {
        super(titolo);
        this.durata = durata;
    }

    public void aumentaLuminosita() {
        l++;
    }

    public void diminuisciLuminosita() {
        l--;
    }
    public int getLuminosita(){
        return this.l;
    }

    public void aumentaVolume() {
        v++;
    }

    public void diminuisciVolume() {
        v--;
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
        return "Video = [ Titolo video: "+ super.titolo + ", durata: "+ this.durata + "min ]";
    }

}
