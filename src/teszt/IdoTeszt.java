package teszt;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import kollekcio.RendezesKollekcio;

public class IdoTeszt {
    private static final int KIS_TOMB_HOSSZ=3;
    private static final int KOZEPES_TOMB_HOSSZ=KIS_TOMB_HOSSZ*10;
    private static final int NAGY_TOMB_HOSSZ=KOZEPES_TOMB_HOSSZ*2;
    
    private static final int MATRIX_TOMB_HOSSZ=2;
    
    private static final char CSILLAG='*';
    
    
    public static void main(String[] args) {      
        tombokIdore();
    }
    
    private static int[][] rndTombokGeneral(int hossz){
        int[][] tombok = new int[MATRIX_TOMB_HOSSZ][];
        for (int i = 0; i < MATRIX_TOMB_HOSSZ; i++) {
            tombok[i] = rndTombGeneral(hossz);
        }
        return tombok;
    }
    
    private static void tombokIdore(){
        int[][] kisTombok=rndTombokGeneral(KIS_TOMB_HOSSZ);
        int[][] kozepesTombok=rndTombokGeneral(KOZEPES_TOMB_HOSSZ);
        int[][] nagyTombok=rndTombokGeneral(NAGY_TOMB_HOSSZ);
        
        String strTxtbe = "";
        strTxtbe+=strIdovelBuilder(kisTombok, KIS_TOMB_HOSSZ);
        strTxtbe+=strIdovelBuilder(kozepesTombok, KOZEPES_TOMB_HOSSZ);
        strTxtbe+=strIdovelBuilder(nagyTombok, NAGY_TOMB_HOSSZ);
        
        fajlbaIr(strTxtbe);
    }

    private static String strIdovelBuilder(int[][] tombok, int tombHossz) {
        String str = "";
        for (int i = 0; i < MATRIX_TOMB_HOSSZ; i++) {
            for (int j = 0; j < tombHossz; j++) {
                System.out.print(tombok[i][j]+" ");
            }
            System.out.println("");
            str+=strEgyTombIdovel(tombok, i);
        }
        for (int i = 0; i < MATRIX_TOMB_HOSSZ; i++) {
            for (int j = 0; j < tombHossz; j++) {
                System.out.print(tombok[i][j]+" ");
            }
        }
        return str;
    }
    
    private static void fajlbaIr(String szoveg){
        Path p=Paths.get("statisztika.txt");
        
        if (Files.exists(p)) {
            try {
                Files.delete(p);
            } catch (IOException ex) {
                Logger.getLogger(IdoTeszt.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        try {
            Files.write(p, szoveg.getBytes());
        } catch (IOException ex) {
            Logger.getLogger(IdoTeszt.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    private static int[] rndTombGeneral(int hossz){
        int[] tomb = new int[hossz];
        for (int i = 0; i < hossz; i++) {
            tomb[i]=(int) (Math.random() * 100);
        }
        return tomb;
    }
    
    private static String strEgyTombIdovel(int[][] tombok, int index){
        int[] tomb = tombok[index];
        
        String idoTesztStr="";
        
        idoTesztStr+=vonal(CSILLAG);
        long kezdesiIdo=System.nanoTime();
        RendezesKollekcio.tovabbfejlesztettBeszuroRendezes(tomb);
        long futasiIdo=System.nanoTime()-kezdesiIdo;
        idoTesztStr+="Továbbfejlesztett beszúró rendezés\n";
        idoTesztStr+=(index+1)+". teszt sor/"+MATRIX_TOMB_HOSSZ+"\n";
        idoTesztStr+=tomb.length+"db hosszú tömbbel\n";
        idoTesztStr+="Futási idő: "+ futasiIdo+"ns\n";
        idoTesztStr+=vonal(CSILLAG)+"\n";
        
        kever(tomb);
        
        idoTesztStr+=vonal('*');
        kezdesiIdo=System.nanoTime();
        RendezesKollekcio.beszuroRendezes(tomb);
        futasiIdo=System.nanoTime()-kezdesiIdo;
        idoTesztStr+="Beszúró rendezés\n";
        idoTesztStr+=(index+1)+". teszt sor/"+MATRIX_TOMB_HOSSZ+"\n";
        idoTesztStr+=tomb.length+"db hosszú tömbbel\n";
        idoTesztStr+="Futási idő: "+ futasiIdo+"ns\n";
        idoTesztStr+=vonal(CSILLAG)+"\n";
        
        kever(tomb);
        
        idoTesztStr+=vonal(CSILLAG);
        kezdesiIdo=System.nanoTime();
        RendezesKollekcio.buborekRendezes(tomb);
        futasiIdo=System.nanoTime()-kezdesiIdo;
        idoTesztStr+="Buborék rendezés\n";
        idoTesztStr+=(index+1)+". teszt sor/"+MATRIX_TOMB_HOSSZ+"\n";
        idoTesztStr+=tomb.length+"db hosszú tömbbel\n";
        idoTesztStr+="Futási idő: "+ futasiIdo+"ns\n";
        idoTesztStr+=vonal(CSILLAG)+"\n";
        
        kever(tomb);
        
        idoTesztStr+=vonal(CSILLAG);
        kezdesiIdo=System.nanoTime();
        RendezesKollekcio.egyszeruCseresRendezes(tomb);
        futasiIdo=System.nanoTime()-kezdesiIdo;
        idoTesztStr+="Egyszerű cserés rendezés\n";
        idoTesztStr+=(index+1)+". teszt sor/"+MATRIX_TOMB_HOSSZ+"\n";
        idoTesztStr+=tomb.length+"db hosszú tömbbel\n";
        idoTesztStr+="Futási idő: "+ futasiIdo+"ns\n";
        idoTesztStr+=vonal(CSILLAG)+"\n";
        
        kever(tomb);
        
        idoTesztStr+=vonal(CSILLAG);
        kezdesiIdo=System.nanoTime();
        RendezesKollekcio.maximumKivalasztasosRendezes(tomb);
        futasiIdo=System.nanoTime()-kezdesiIdo;
        idoTesztStr+="Maximumkiválasztásos rendezés\n";
        idoTesztStr+=(index+1)+". teszt sor/"+MATRIX_TOMB_HOSSZ+"\n";
        idoTesztStr+=tomb.length+"db hosszú tömbbel\n";
        idoTesztStr+="Futási idő: "+ futasiIdo+"ns\n";
        idoTesztStr+=vonal(CSILLAG)+"\n";
        
        kever(tomb);
        
        idoTesztStr+=vonal(CSILLAG);
        kezdesiIdo=System.nanoTime();
        RendezesKollekcio.minimumKivalasztasosRendezes(tomb);
        futasiIdo=System.nanoTime()-kezdesiIdo;
        idoTesztStr+="Minimumkiválasztásos rendezés\n";
        idoTesztStr+=(index+1)+". teszt sor/"+MATRIX_TOMB_HOSSZ+"\n";
        idoTesztStr+=tomb.length+"db hosszú tömbbel\n";
        idoTesztStr+="Futási idő: "+ futasiIdo+"ns\n";
        idoTesztStr+=vonal(CSILLAG)+"\n";
        
        kever(tomb);
        
        idoTesztStr+=vonal(CSILLAG);
        kezdesiIdo=System.nanoTime();
        RendezesKollekcio.tovabbfejlesztettBuborekRendezes(tomb);
        futasiIdo=System.nanoTime()-kezdesiIdo;
        idoTesztStr+="Továbbfejlesztett buborék rendezés\n";
        idoTesztStr+=(index+1)+". teszt sor/"+MATRIX_TOMB_HOSSZ+"\n";
        idoTesztStr+=tomb.length+"db hosszú tömbbel\n";
        idoTesztStr+="Futási idő: "+ futasiIdo+"ns\n";
        idoTesztStr+=vonal(CSILLAG)+"\n";
        
        
        return idoTesztStr;
    }
    
    private static void kever(int[] tomb){
        Random rnd = new Random();
        
        for (int i = 0; i < tomb.length; i++) {
            int index = rnd.nextInt(tomb.length);
            int temp = tomb[index];
            tomb[index] = tomb[i];
            tomb[i] = temp;
	}
    }
    
    private static String vonal(char jel){
        String s = "";
        for (int i = 0; i < 30; i++) {
            s+=jel;
        }
        s+="\n";
        return s;
    }
}
