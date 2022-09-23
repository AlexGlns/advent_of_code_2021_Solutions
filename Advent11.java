// Advent of code 2021 - 11 //
import java.util.LinkedList;

public class Advent11{
    
    static void PrintGrid(int[][] GRID){
        for (int i = 0; i < GRID.length; i++) {
            for (int j = 0; j < GRID[i].length; j++) {
                System.out.print(GRID[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    static  LinkedList<Integer> flashedX = new LinkedList<Integer>();   //Store x-position of flashed octapus
    static  LinkedList<Integer> flashedY = new LinkedList<Integer>();   //Store y-position of flashed octapus

    static int[][] AddAdjacents(int[][] _Grid){
        int x=flashedX.removeLast();
        int y=flashedY.removeLast();

        if(x==0 && y==0){
            if(_Grid[x][y+1]!=0){
                _Grid[x][y+1]++;
            }
            if(_Grid[x+1][y]!=0){
                _Grid[x+1][y]++;
            }
            if(_Grid[x+1][y+1]!=0){
                _Grid[x+1][y+1]++;
            }
        }else if(x==0 && y==_Grid.length-1){
            if(_Grid[x][y-1]!=0){
                _Grid[x][y-1]++;
            }
            if(_Grid[x+1][y]!=0){
                _Grid[x+1][y]++;
            }
            if(_Grid[x+1][y-1]!=0){
                _Grid[x+1][y-1]++;
            }
        }else if(x==0){
            if(_Grid[x][y-1]!=0){
                _Grid[x][y-1]++;
            }
            if(_Grid[x][y+1]!=0){
                _Grid[x][y+1]++;
            }
            if(_Grid[x+1][y]!=0){
                _Grid[x+1][y]++;
            }
            if(_Grid[x+1][y+1]!=0){
                _Grid[x+1][y+1]++;
            }
            if(_Grid[x+1][y-1]!=0){
                _Grid[x+1][y-1]++;
            }
        }else if(x==_Grid.length-1 && y==0){
            if(_Grid[x][y+1]!=0){
                _Grid[x][y+1]++;
            }
            if(_Grid[x-1][y]!=0){
                _Grid[x-1][y]++;
            }
            if(_Grid[x-1][y+1]!=0){
                _Grid[x-1][y+1]++;
            }
        }else if(x==_Grid.length-1 && y==_Grid.length-1){
            if(_Grid[x][y-1]!=0){
                _Grid[x][y-1]++;
            }
            if(_Grid[x-1][y]!=0){
                _Grid[x-1][y]++;
            }
            if(_Grid[x-1][y-1]!=0){
                _Grid[x-1][y-1]++;
            }
        }else if(x==_Grid.length-1){
            if(_Grid[x][y-1]!=0){
                _Grid[x][y-1]++;
            }
            if(_Grid[x][y+1]!=0){
                _Grid[x][y+1]++;
            }
            if(_Grid[x-1][y]!=0){
                _Grid[x-1][y]++;
            }
            if(_Grid[x-1][y+1]!=0){
                _Grid[x-1][y+1]++;
            }
            if(_Grid[x-1][y-1]!=0){
                _Grid[x-1][y-1]++;
            }
        }else{
            if(y==0){
                if(_Grid[x][y+1]!=0){
                    _Grid[x][y+1]++;
                }
                if(_Grid[x+1][y]!=0){
                    _Grid[x+1][y]++;
                }
                if(_Grid[x-1][y]!=0){
                    _Grid[x-1][y]++;
                }
                if(_Grid[x+1][y+1]!=0){
                    _Grid[x+1][y+1]++;
                }
                if(_Grid[x-1][y+1]!=0){
                    _Grid[x-1][y+1]++;
                }
            }else if(y==_Grid.length-1){
                if(_Grid[x][y-1]!=0){
                    _Grid[x][y-1]++;
                }
                if(_Grid[x+1][y]!=0){
                    _Grid[x+1][y]++;
                }
                if(_Grid[x-1][y]!=0){
                    _Grid[x-1][y]++;
                }
                if(_Grid[x+1][y-1]!=0){
                    _Grid[x+1][y-1]++;
                }
                if(_Grid[x-1][y-1]!=0){
                    _Grid[x-1][y-1]++;
                }
            }else{
                if(_Grid[x][y-1]!=0){
                    _Grid[x][y-1]++;
                }
                if(_Grid[x+1][y]!=0){
                    _Grid[x+1][y]++;
                }
                if(_Grid[x-1][y]!=0){
                    _Grid[x-1][y]++;
                }
                if(_Grid[x+1][y-1]!=0){
                    _Grid[x+1][y-1]++;
                }
                if(_Grid[x-1][y-1]!=0){
                    _Grid[x-1][y-1]++;
                }
                if(_Grid[x][y+1]!=0){
                    _Grid[x][y+1]++;
                }
                if(_Grid[x+1][y+1]!=0){
                    _Grid[x+1][y+1]++;
                }
                if(_Grid[x-1][y+1]!=0){
                    _Grid[x-1][y+1]++;
                }

            }
        }
        return _Grid;
    }

    public static void main(String[] args){
        int[][] Grid = {{5,4,8,3,1,4,3,2,2,3},
                        {2,7,4,5,8,5,4,7,1,1},
                        {5,2,6,4,5,5,6,1,7,3},
                        {6,1,4,1,3,3,6,1,4,6},
                        {6,3,5,7,3,8,5,4,7,8},
                        {4,1,6,7,5,2,4,6,4,5},
                        {2,1,7,6,8,4,1,7,2,1},
                        {6,8,8,2,8,8,1,1,3,4},
                        {4,8,4,6,8,4,8,5,5,4},
                        {5,2,8,3,7,5,1,5,2,6}
        };

        
        System.out.println("Before any step:");
        PrintGrid(Grid);
        int flashes=0;
        for(int i=1;i<=100;i++){
            
            for(int j=0;j<Grid.length;j++){                 //First step add +1
                for (int k=0;k<Grid[j].length;k++){
                        Grid[j][k]++;
                }
            }

            for(int j=0;j<Grid.length;j++){                 
                for (int k=0;k<Grid[j].length;k++){
                        if(Grid[j][k]>9){
                            Grid[j][k]=0;
                            flashedX.addLast(j);
                            flashedY.addLast(k);
                            flashes++;
                        }
                }
            }

            while(flashedX.size() + flashedY.size() > 0){
                
                Grid=AddAdjacents(Grid);
                
                for(int j=0;j<Grid.length;j++){                 
                    for (int k=0;k<Grid[j].length;k++){
                            if(Grid[j][k]>9){
                                Grid[j][k]=0;
                                flashedX.addLast(j);
                                flashedY.addLast(k);
                                flashes++;
                            }
                    }
                }
            }

            
            
            System.out.println("After step " + i + ":");
            PrintGrid(Grid);
        }

        System.out.println("Total flashes : " + flashes);
    }



}