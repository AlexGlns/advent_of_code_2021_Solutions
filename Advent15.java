// Advent of code 2021 - 15 //
import java.util.*;

public class Advent15{

    private int[][] visited ;                           //if visited[i][j]==0 then column is not visited
    static List<Integer> Xpos=new ArrayList<Integer>();
    static List<Integer> Ypos=new ArrayList<Integer>();
    
    Advent15(){
        visited=new int[10][10];
        visited[0][0]=1;
        for(int i=0;i<10;i++){
            for (int j=0;j<10;j++){
                visited[i][j]=0;
            }
        }
    }

    void BFS(int [][] grid){
        int x,y;
        Xpos.add(0);    //starting x
        Ypos.add(0);    //starting y

        while(Xpos.size()!=0 && Ypos.size()!=0){
            x=Xpos.remove(0);
            y=Ypos.remove(0);

            if(IN_Cave(x+1, y)){        //go down
                if(visited[x+1][y]==0){
                    visited[x+1][y]=grid[x+1][y]+visited[x][y];
                    Xpos.add(x+1);
                    Ypos.add(y);
                }else{
                    if(visited[x+1][y]>visited[x][y]+grid[x+1][y])
                        visited[x+1][y]=grid[x+1][y]+visited[x][y];
                }
            }

            if(IN_Cave(x-1, y)){        //go up
                if(visited[x-1][y]==0){
                    visited[x-1][y]=grid[x-1][y]+visited[x][y];
                    Xpos.add(x-1);
                    Ypos.add(y);
                }else{
                    if(visited[x-1][y]>visited[x][y]+grid[x-1][y])
                        visited[x-1][y]=grid[x+1][y]+visited[x][y];
                }
            }

            if(IN_Cave(x, y+1)){        //go East
                if(visited[x][y+1]==0){
                    visited[x][y+1]=grid[x][y+1]+visited[x][y];
                    Xpos.add(x);
                    Ypos.add(y+1);
                }else{
                    if(visited[x][y+1]>visited[x][y]+grid[x][y+1])
                        visited[x+1][y]=grid[x][y+1]+visited[x][y];
                }
            }

            if(IN_Cave(x, y-1)){        //go West
                if(visited[x][y-1]==0){
                    visited[x][y-1]=grid[x][y-1]+visited[x][y];
                    Xpos.add(x);
                    Ypos.add(y-1);
                }else{
                    if(visited[x][y-1]>visited[x][y]+grid[x][y-1])
                        visited[x][y-1]=grid[x][y-1]+visited[x][y];
                }
            }
        }
        
        System.out.println("Lowest total risk of path is :" + visited[visited.length-1][visited.length-1]);
    }

    private int[][] Mark_Path(int [][] grid){
                //Mark Path with zeros
                int x,y;
                x=y=grid.length-1;
                grid[x][y]=0;
                while(x+y!=0){
                        int up,down,east,west;
                        String min="";
                        up=down=east=west=1000000;
                        if(IN_Cave(x+1, y)){        //go down
                            down=visited[x+1][y];
                            min="Down";
                        }
            
                        if(IN_Cave(x-1, y)){        //go up
                            if(visited[x-1][y]<down){
                                up=visited[x-1][y];
                                min="up";
                            }else{
                                up=visited[x-1][y];
                                min="up";
                            }
                        }
            
                        if(IN_Cave(x, y+1)){        //go East
                            if(visited[x][y+1]<up && visited[x][y+1]<down){
                                east=visited[x][y+1];
                                min="east";
                            }
                        }
            
                        if(IN_Cave(x, y-1)){        //go West
                            if(visited[x][y-1]<up && visited[x][y-1]<east && visited[x][y-1]<down){
                                min="west";
                            }   
                        }

                        switch (min) {
                            case "up":
                                grid[x-1][y]=0;
                                x=x-1;
                                break;
                            case "Down":
                                grid[x+1][y]=0;
                                x=x+1;
                                break;
                            case "east":
                                grid[x][y+1]=0;
                                y=y+1;
                                break;
                            case "west":
                                grid[x][y-1]=0;
                                y=y-1;
                                break;
                            default:
                                break;
                        }
                }
                return grid;
    }

    static void PrintMatrix(int [][] grid){
        for (int i=0;i<grid.length;i++){
            for (int j=0;j<grid[i].length;j++){
                System.out.print(" " + grid[i][j]);
            }
            System.out.println();
        }
        System.out.println();
    }
    
    
    
    private boolean IN_Cave(int row,int col){
        return (row>=0 && col>=0 && row<10 && col<10);
    }


    public static void main(String[] args) {
        int[][] Grid = {{1,1,6,3,7,5,1,7,4,2},
                        {1,3,8,1,3,7,3,6,7,2},
                        {2,1,3,6,5,1,1,3,2,8},
                        {3,6,9,4,9,3,1,5,6,9},
                        {7,4,6,3,4,1,7,1,1,1},
                        {1,3,1,9,1,2,8,1,3,7},
                        {1,3,5,9,9,1,2,4,2,1},
                        {3,1,2,5,4,2,1,6,3,9},
                        {1,2,9,3,1,3,8,5,2,1},
                        {2,3,1,1,9,4,4,5,8,1}
        };
        PrintMatrix(Grid);
        Advent15 obj=new Advent15();
        obj.BFS(Grid);
        Grid=obj.Mark_Path(Grid);
        System.out.println("Lowest path is marked with zeros:");
        PrintMatrix(Grid);

    }
}