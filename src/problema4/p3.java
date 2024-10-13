package problema4;
import java.time.LocalDate;
import java.util.*;

class Persoana{
    private String nume;
    private String cnp;
    public Persoana(String nume, String cnp){
        this.nume = nume;
        this.cnp = cnp;
    }

    public String getNume(){
        return nume;
    }
    public String getCnp(){
        return cnp;
    }
    public void setNume(String nume){
        this.nume = nume;
    }
    public void setCnp(String cnp){
        this.cnp = cnp;
    }
  public int GetVarsta(){
      int an = Integer.parseInt(cnp.substring(1, 3));
      int luna = Integer.parseInt(cnp.substring(3, 5));
      int zi = Integer.parseInt(cnp.substring(5, 7));
      int prim = Character.getNumericValue(cnp.charAt(0));
      if (prim == 1 || prim == 2) { // 1900 - 1999
          an += 1900;
      } else if (prim == 5 || prim == 6) { // 2000 - 2099
          an += 2000;
      }
      LocalDate dataNasterii = LocalDate.of(an, luna, zi);
      LocalDate dataCurenta = LocalDate.now();
      int data=dataCurenta.getYear() - dataNasterii.getYear();
      return data;
  }
}

public class p3 {
 public static int Validare(String cnp){
        int nr=0,ok=0,i;
        if(cnp.length()==13)
            nr++;
        if(cnp.charAt(0)=='1'|| cnp.charAt(0)=='2'|| cnp.charAt(0)=='5'|| cnp.charAt(0)=='6' ){
            nr++;
        }
        for(i=0;i<cnp.length();i++){
            if(!Character.isDigit(cnp.charAt(i))){
                ok=1;
            }
        }
        if(ok==0 && nr==2)
            return 1;
        else
            return 0;
    }
    public static void main(String[] args) {
        int n,i;
        String nume,cnp;
        Scanner sc = new Scanner(System.in);
        System.out.print("n: ");
        n = sc.nextInt();
       Persoana [] p=new Persoana[n];
       for(i=0;i<n;i++){
           System.out.print("nume: ");
           nume=sc.next();
           do {
               System.out.print("cnp: ");
               cnp = sc.next();
           }while(Validare(cnp)==0);
           p[i]=new Persoana(nume,cnp);
           System.out.println(p[i].getNume()+" "+p[i].getCnp()+" "+ p[i].GetVarsta());
       }
       sc.close();
    }
}
