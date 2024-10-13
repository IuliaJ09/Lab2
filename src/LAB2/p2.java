package LAB2;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;
class Vers{
     String v;
     Vers(String v){
         this.v=v;
     }
     int NrCuv(String v)
        {
         int i,nr=0;
         for(i=0;i<v.length();i++){
             if(v.charAt(i)==' '){
                 nr++;
             }
         }
        return nr;
    }
    int NrVocale(String v){
         int i,nr=0;
         for(i=0;i<v.length();i++){
             if(v.charAt(i)=='a' || v.charAt(i)=='e' || v.charAt(i)=='i' || v.charAt(i)=='o' || v.charAt(i)=='u'){
                 nr++;
             }
             if(v.charAt(i)=='A' || v.charAt(i)=='E' || v.charAt(i)=='I' || v.charAt(i)=='O' || v.charAt(i)=='U'){
                 nr++;
             }
         }
         return nr+1;
    }
}

public class p2 {
    public static void main(String[] args) throws IOException {
       Vers []v=new Vers[10];
       Scanner sc=new Scanner(new File("C:\\Users\\Aquiris\\IdeaProjects\\Lab2\\src\\LAB2\\versuri.txt"));
       String s;
       FileWriter fw=new FileWriter("cantec_out.txt");
       int i=0;
       while(sc.hasNextLine()){
           s=sc.nextLine();
           v[i]=new Vers(s);

           double randomNumber = Math.random();
           if(randomNumber<0.1){
               v[i].v=v[i].v.toUpperCase();
          }
          System.out.println(v[i].v+" "+v[i].NrCuv(v[i].v)+" "+v[i].NrVocale(v[i].v));
           fw.write(v[i].v+" "+v[i].NrCuv(v[i].v)+" "+v[i].NrVocale(v[i].v)+"\n");
           i++;
       }
       fw.close();
       sc.close();
    }

}
