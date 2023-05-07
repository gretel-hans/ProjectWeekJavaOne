package mainProject;

public class Audio extends ElementoMultimediale {
    private int durata;
    private int v=5;

	public Audio(String titolo, int durata){
        super(titolo);
        this.durata = durata;
    }

    public Audio(String titolo, int durata, int v){
        super(titolo);
        this.durata = durata;
        this.v=v;
    }

    public int getDurata(){
        return this.durata;
    }
    public void setDurata(int durata){
        this.durata=durata;
    }

    public void alzaVolume(int aumento) {
        this.v+=aumento;
    }

    public void abbassaVolume(int diminuisci) {
        this.v-=diminuisci;
    }

    public void play(){
        for(int i=0;i<this.durata;i++){
            System.out.print("Titolo audio: "+super.titolo);
            for(int j=0;j<this.v;j++){
                if(j==this.v-1){
                    System.out.println(" ! ");
                }else{
                    System.out.print(" ! ");
                }
            }
        }
    }

@Override
public String toString(){
return "Audio = [ Titolo Audio: "+ super.titolo + ", durata: " + this.durata + "min, volume: " + this.v + " ]" ;
}
    
}
