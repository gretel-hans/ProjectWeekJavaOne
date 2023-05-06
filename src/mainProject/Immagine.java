package mainProject;

public class Immagine extends ElementoMultimediale implements gestioneLuminosita {

    private int l=5;
    public Immagine(String titolo){
        super(titolo);
    }

    public void aumentaLuminosita(){
        l++;
    }
    public void diminuisciLuminosita(){
      l--;  
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
        return "Immagine = [ Titolo immmagine: "+this.titolo+ " ]";
      }
}
