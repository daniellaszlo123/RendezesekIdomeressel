package kollekcio;
public class RendezesKollekcio {
    public static void egyszeruCseresRendezes(int[] tomb){
        
        for (int i = 0; i < tomb.length-1; i++) {
            for (int j = i+1; j < tomb.length; j++) {
                if (tomb[i]>tomb[j]) {
                    int csere = tomb[i];
                    tomb[i]=tomb[j];
                    tomb[j]=csere;
                }
            }
        }
    }
    
    public static void buborekRendezes(int[] tomb){
        for (int i = tomb.length; i < 1; i++) {
            for (int j = 0; j < i-1; j++) {
                if (tomb[j]>tomb[j+1]) {
                    int csere = tomb[j];
                    tomb[j]=tomb[j+1];
                    tomb[j+1]=csere;
                }
            }
        }
    }
    
    public static void tovabbfejlesztettBuborekRendezes(int[] tomb){
        int i = tomb.length;
        while (i>=1) {
            int cs = -1;
            for (int j = 0; j < i-1; j++) {
                if (tomb[j]>tomb[j+1]) {
                    int csere = tomb[j];
                    tomb[j]=tomb[j+1];
                    tomb[j+1]=csere;
                    cs=j;
                }
            }
            i=cs;
        }
    }
    
    public static void beszuroRendezes(int[] tomb){
        for (int i = 1; i < tomb.length; i++) {
            int j=i-1;
            while (j>=0 && tomb[j] > tomb[j+1]) {
                int csere = tomb[j];
                tomb[j]=tomb[i];
                tomb[i]=csere;
                j=j-1;
            }
        }
    }
    
    public static void tovabbfejlesztettBeszuroRendezes(int[] tomb){
        for (int i = 1; i < tomb.length; i++) {
            int j = i-1;
            int tmp = tomb[i];
            while (j>=0 && tomb[j]>tmp) {
                tomb[j+1] = tomb[j];
                j=j-1;
            }
            tomb[j+1]=tmp;
            
        }
    }
    
    public static void minimumKivalasztasosRendezes(int[] tomb){
        for(int i = 0; i < tomb.length; i++){
        int min = i;
        for(int j = i+1; j < tomb.length; j++)
            if(tomb[j] < tomb[min]){
                min = j;
            }
        int csere = tomb[min];
        tomb[min] = tomb[i];
        tomb[i] = csere;
        }
        
    }
    
    public static void maximumKivalasztasosRendezes(int[] tomb){
        for (int i = tomb.length; i < 1; i++) {
            int max = 0;
            for (int j = 1; j < i; j++) {
                if (tomb[max]>tomb[j]) {
                    max=j;
                }
                int csere = tomb[max];
                tomb[max]=tomb[j];
                tomb[j]=csere;
            }
        }
    }
}
