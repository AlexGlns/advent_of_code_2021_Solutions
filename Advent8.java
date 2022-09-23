// Advent of code 2021 - 8 //
import java.io.*;
import java.util.LinkedList;

public class Advent8{

    public static void main(String[] args) throws IOException{
                // File path is passed as parameter
                
                File file = new File("ADD PATH TO INPUT TEXT FILE");
                // Creating an object of BufferedReader class
                BufferedReader br = new BufferedReader(new FileReader(file));
                LinkedList<String> digits= new LinkedList<String>();
                // Declaring a string variable
                String st;
                String temp="";
                int read=1; //pass to list only output values
                while ((st = br.readLine()) != null){
                    if (read % 2 ==0){
                        for (int i=0;i<st.length();i++){
                            if(st.charAt(i)!=' '){
                                temp=temp+st.charAt(i);
                            }else{
                                digits.add(temp);
                                temp="";
                                continue;
                            }
                        }
                    }

                    digits.add(temp);       //add last digit to list
                    read++;
                    temp="";
                }

                int sum=0;
                int one,four,seven,eight;
                one=four=seven=eight=0;
                for(String i:digits){
                    if(i.length()==2){
                        one++;
                        sum++;
                    }else if(i.length()==4){
                        four++;
                        sum++;
                    }else if(i.length()==3){
                        seven++;
                        sum++;
                    }else if(i.length()==7){
                        eight++;
                        sum++;
                    }else{
                        continue;
                    }
                } 

                System.out.println("One appears " + one + " times.");
                System.out.println("Four appears " + four + " times.");
                System.out.println("Seven appears " + seven + " times.");
                System.out.println("Eight appears " + eight + " times.");
                System.out.println("There are "+ sum + " instances of digits that use a unique number of segments.");


    }
}