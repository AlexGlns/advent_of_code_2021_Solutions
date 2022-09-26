// Advent of code 2021 - 12 //
import java.util.*;

import javax.management.relation.RoleResult;

public class Advent14{
    static  Map<String, String> adjList=new LinkedHashMap<String,String>();   //Map for polymerer template with rules (Key:pair,Value:element)

    public static void main(String[] args) {
        //Initialize polymer template
        adjList.put("CH","B");
        adjList.put("HH","N");
        adjList.put("CB","H");
        adjList.put("NH","C");
        adjList.put("HB","C");
        adjList.put("HC","B");
        adjList.put("HN","C");
        adjList.put("NN","C");
        adjList.put("BH","H");
        adjList.put("NC","B");
        adjList.put("NB","B");
        adjList.put("BN","B");
        adjList.put("BB","N");
        adjList.put("BC","B");
        adjList.put("CC","N");
        adjList.put("CN","C");

        String templPol="NNCB";
        String PolResult="";
        String pair="";
        int step=1;
        while(step<=10){
            for(int i=0;i<templPol.length()-1;i++){
                pair=Character.toString(templPol.charAt(i))+Character.toString(templPol.charAt(i+1));
                String res=adjList.get(pair);
                PolResult=PolResult+Character.toString(templPol.charAt(i))+res;
            }
            PolResult=PolResult+Character.toString(templPol.charAt(templPol.length()-1));
            System.out.println("After step " + step + " " + PolResult);
            templPol=PolResult;
            PolResult="";
            step++;
        }
        int B,C,H,N;
        B=C=H=N=0;
        for(int i=0;i<templPol.length();i++){
            switch (templPol.charAt(i)) {
                case 'B':
                    B++;
                    break;
                case 'C':
                    C++;
                    break;
                case 'H':
                    H++;
                    break;
                case 'N':
                    N++;
                    break; 
                default:
                    break;
            }
        }
        int max=-1;
        Integer min=Integer.MAX_VALUE;
        char maxP,minP;
        
        max=B;
        maxP='B';
        
        if(C>max){
            max=C;
            maxP='C';
        }
        if(H>max){
            max=H;
            maxP='H';
        }
        if(N>max){
            max=N;
            maxP='N';
        }

        min=B;
        minP='B';

        if(C<min){
            min=C;
            minP='C';
        }
        if(H<min){
            min=H;
            minP='H';
        }
        if(N<min){
            min=N;
            minP='N';
        }
        
        System.out.println();
        System.out.println("Most common element is " + maxP + " which occurs " + max + " times");
        System.out.println("Least common element is " + minP + " which occurs " + min + " times");
        System.out.println(max-min);
    }
}