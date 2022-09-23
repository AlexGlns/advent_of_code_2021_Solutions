// Advent of code 2021 - 10 //
import java.util.LinkedList;
import java.util.Scanner;

public class Advent10{
    
    public static void main(String[] args){
        Scanner myObj= new Scanner(System.in);
        int j=1;
        int sum=0;
        while(j<=10){
            System.out.println("Enter Chunks Input");

            String chunk=myObj.nextLine();
            LinkedList<Character> LeftChunks = new LinkedList<Character>();
            boolean corrupted=false;
            for (int i = 0; i < chunk.length(); i++) {
                if(chunk.charAt(i)=='(' || chunk.charAt(i)=='[' || chunk.charAt(i)=='{' || chunk.charAt(i)=='<'){       //left chunk then add to list
                    LeftChunks.addLast(chunk.charAt(i));
                }else{
                    if(LeftChunks.isEmpty()){
                        System.out.println("Chunk is Corrupted!");
                        corrupted=true;
                        break;
                    }else{                                                                                               //right chunk then pop from list
                        Character l=LeftChunks.removeLast();
                        if(l=='(' && chunk.charAt(i)==')'){
                            continue;
                        }else if(l=='[' && chunk.charAt(i)==']'){
                            continue;
                        }else if(l=='{' && chunk.charAt(i)=='}'){
                            continue;
                        }else if(l=='<' && chunk.charAt(i)=='>'){
                            continue;
                        }else{
                            System.out.println("Chunk is Corrupted");
                            
                            switch (chunk.charAt(i)) {
                                case ')':
                                    sum+=3;
                                    break;
                                case ']':
                                    sum+=57;
                                    break;
                                case '}':
                                    sum+=1197;
                                    break;
                                case '>':
                                    sum+=25137;
                                    break;
                                default:
                                    break;
                            }
                            
                            corrupted=true;
                            break;
                        }
                    }
                }
            }
                if(corrupted==false){
                    System.out.println("Chunk is NOT corrupted!");
                }
                System.out.println();
                j++;
        }
        System.out.println("Total error score : " + sum);
        myObj.close();
    }

}