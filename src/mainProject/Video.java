package mainProject;

public class Video implements gestioneLuminosita {
    private String titolo;
    public int l = 5;
    public int durata;
    public int v = 5;

    public Video(String titolo, int durata) {
        this.titolo = titolo;
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
        this.titolo = titolo;
    }

    public String getTitolo() {
        return this.titolo;
    }

    public void setDurata(int durata) {
        this.durata = durata;
    }

    public int getDurata() {
        return this.durata;
    }

    public void play(){
        for(int i=0;i<this.durata;i++){
            System.out.print(this.titolo );
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

}
