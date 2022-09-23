// Advent of code 9 //

#include <stdio.h>
#include <stdlib.h>
#define LOWPOINTS 10    

int main(void){
    time_t t;
    srand((unsigned) time(&t));     //initialize random generator for submarine's commands
    int map[LOWPOINTS][LOWPOINTS];
    for (int i=0;i<LOWPOINTS;i++){
        for (int j=0;j<LOWPOINTS;j++){
            int random=rand() %10;
            map[i][j]=random;
            printf("%d ",map[i][j]);
        }
        printf("\n");
    }

    printf("\n");
    int totalLowPoints=0;
    int SumRisk=0;
    for (int i=0;i<LOWPOINTS;i++){
        for (int j=0;j<LOWPOINTS;j++){
            if(i==0){               //First Line
                if (j==0){          //First Row
                    if(map[i][j] < map[i+1][j] && map[i][j] < map[i][j+1]){
                        printf("Lowpoint found with value : %d \n",map[i][j]);
                        SumRisk=SumRisk+map[i][j]+1;
                        totalLowPoints++;
                    }
                }else if(j==LOWPOINTS-1){     //Last Row 
                        if (map[i][j] < map[i+1][j] && map[i][j] < map[i][j-1]){
                            printf("Lowpoint found with value : %d \n",map[i][j]);
                            SumRisk=SumRisk+map[i][j]+1;
                            totalLowPoints++;
                        }
                }else{
                        if(map[i][j] < map[i+1][j] && map[i][j] < map[i][j-1] &&
                            map[i][j] < map[i][j+1]){
                                printf("Lowpoint found with value : %d \n",map[i][j]);
                                SumRisk=SumRisk+map[i][j]+1;
                                totalLowPoints++;
                            }
                }
            }else if(i<LOWPOINTS-1){    //Lines between 0 and 9
                if(j==0){   //first Row
                    if(map[i][j] < map[i+1][j] && map[i][j] < map[i-1][j] &&
                            map[i][j] < map[i][j+1]){
                                printf("Lowpoint found with value : %d \n",map[i][j]);
                                SumRisk=SumRisk+map[i][j]+1;
                                totalLowPoints++;
                    }
                }else if(j==LOWPOINTS-1){
                    if(map[i][j] < map[i+1][j] && map[i][j] < map[i-1][j] &&
                        map[i][j] < map[i][j-1]){
                            printf("Lowpoint found with value : %d \n",map[i][j]);
                            SumRisk=SumRisk+map[i][j]+1;
                            totalLowPoints++;
                    }
                }else{
                    if(map[i][j] < map[i+1][j] && map[i][j] < map[i-1][j] &&
                        map[i][j] < map[i][j-1] && map[i][j] < map[i][j+1]){
                            printf("Lowpoint found with value : %d \n",map[i][j]);
                            SumRisk=SumRisk+map[i][j]+1;
                            totalLowPoints++;
                    }
                }
            }else{                      //Last Line
                if (j==0){          //First Row
                    if(map[i][j] < map[i-1][j] && map[i][j] < map[i][j+1]){
                        printf("Lowpoint found with value : %d \n",map[i][j]);
                        SumRisk=SumRisk+map[i][j]+1;
                        totalLowPoints++;
                    }
                }else if(j==LOWPOINTS-1){     //Last Row 
                        if (map[i][j] < map[i-1][j] && map[i][j] < map[i][j-1]){
                            printf("Lowpoint found with value : %d \n",map[i][j]);
                            SumRisk=SumRisk+map[i][j]+1;
                            totalLowPoints++;
                        }
                }else{
                        if(map[i][j] < map[i-1][j] && map[i][j] < map[i][j-1] &&
                            map[i][j] < map[i][j+1]){
                            printf("Lowpoint found with value : %d \n",map[i][j]);
                            SumRisk=SumRisk+map[i][j]+1;
                            totalLowPoints++;
                        }
                }
            }
        }
    }
    printf("\n");
    printf("Total Lowpoints found : %d \n", totalLowPoints);
    printf("Sum of the Risk is: %d \n", SumRisk);
}
