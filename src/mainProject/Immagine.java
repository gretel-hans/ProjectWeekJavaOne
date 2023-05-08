package mainProject;

public class Immagine extends ElementoMultimediale implements gestioneLuminosita {

    private int l=5;
    public Immagine(String titolo){
        super(titolo);
    }
    public Immagine(String titolo, int l){
      super(titolo);
      this.l=l;
  }

    public void aumentaLuminosita(int n){
        this.l+=n;
    }
    public void diminuisciLuminosita(int n){
      this.l-=n;  
    }
    public int getLuminosita(){
        return this.l;  
      }


      public void show(){
        System.out.print("Titolo immagine: "+this.titolo);
        for (int i=0;i<l;i++){
            if(i==l-1){
                System.out.println(" * ");
            }else{
                System.out.print(" * ");
            }
            
        }
      }

      @Override
      public String toString(){
        return "Immagine = [ Titolo immmagine: "+this.titolo+ ", luminosità: " +this.l + " ]";
      }
}
