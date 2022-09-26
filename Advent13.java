// Advent of code 2021 - 13 //
import java.beans.Visibility;
import java.util.*;

public class Advent13{
    private int x;
    private int y;

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public Advent13(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public Advent13() {
    }

    static void printArray(char paper[][]){
        for(int i=0;i<paper.length;i++){
            for(int j=0;j<paper[i].length;j++){
                System.out.print(paper[i][j]);
            }
            System.out.println();
        }

        System.out.println();
    }

    public static void main(String[] args) {
        List<Advent13> inputL=new ArrayList<Advent13>();
        inputL.add(new Advent13(6,10));
        inputL.add(new Advent13(0,14));
        inputL.add(new Advent13(9,10));
        inputL.add(new Advent13(0,3));
        inputL.add(new Advent13(10,4));
        inputL.add(new Advent13(4,11));
        inputL.add(new Advent13(6,0));
        inputL.add(new Advent13(6,12));
        inputL.add(new Advent13(4,1));
        inputL.add(new Advent13(0,13));
        inputL.add(new Advent13(10,12));
        inputL.add(new Advent13(3,4));
        inputL.add(new Advent13(3,0));
        inputL.add(new Advent13(8,4));
        inputL.add(new Advent13(1,10));
        inputL.add(new Advent13(2,14));
        inputL.add(new Advent13(8,10));
        inputL.add(new Advent13(9,0));

        int Yfold=7;            //Y fold instruction
        int Xfold=5;            //X fold instruction

        char[][] paper=new char[2*Yfold+1][2*Xfold+1];
        
        for(int i=0;i<(2*Yfold+1);i++){         //Initiallize array
            for(int j=0;j<(2*Xfold)+1;j++){
                paper[i][j]='.';
            }
        }

        for(Advent13 temp : inputL){
            int tempX=temp.getX();
            int tempY=temp.getY();
            paper[tempY][tempX]='#';            //Add Dots to paper 
        }

        printArray(paper);

        for(int i=0;i<paper[Yfold].length;i++){
            paper[Yfold][i]='-';
        }

        printArray(paper);

        char[][] transparentarray=new char[Yfold][2*Xfold+1];       //Create transparent Array
        for(int i=0;i<(Yfold);i++){
            for(int j=0;j<(2*Xfold)+1;j++){
                transparentarray[i][j]=paper[i][j];                 //copy up-half of paper
            }
        }
        
        for(int i=Yfold+1;i<paper.length;i++){
            for(int j=0;j<(paper[i].length);j++){
                if(paper[i][j]=='#'){
                    transparentarray[(paper.length-1)-i][j]=paper[i][j];
                }
            }
        }

        int VisibleDots=0;

        for(int i=0;i<transparentarray.length;i++){
            for(int j=0;j<(transparentarray[i].length);j++){
                if(transparentarray[i][j]=='#'){
                    VisibleDots++;
                }
            }
        }

        System.out.println("Transparent paper:");
        printArray(transparentarray);

        System.out.println("Visible dots after first fold instruction: " + VisibleDots);




        //Advent13 temp=inputL.get(0);
        //System.out.println(temp.getX());
    }
}