/* advent of code 4 */

#include <stdio.h>
#include <stdlib.h>
#define NUMS_INPUT 27
#define GRID 5

//  Function definition  //

int CheckWinner(int array[GRID][GRID],int array1[GRID][GRID],int array2[GRID][GRID]);
void printArrays(int array[GRID][GRID],int array1[GRID][GRID],int array2[GRID][GRID]);
int calulateScore(int array[GRID][GRID],int );

//   -----------------   //

int main(){
    time_t t;
    srand((unsigned) time(&t));     //initialize random generator for submarine's commands
    int input_array[NUMS_INPUT];
    
    //initiallize input array     
    for (int i=0; i<NUMS_INPUT; i++){
        int RandomNum=rand() % 30;  //random number 0-29
        input_array[i]=RandomNum;
    }
    
    int array1[GRID][GRID];
    int array2[GRID][GRID];
    int array3[GRID][GRID];

    //initialize arrays
    for (int i=0; i<GRID; i++){
        int RandomNum;
        for (int j=0; j<GRID; j++){
            RandomNum=rand() % 30;
            array1[i][j]=RandomNum;
            
            RandomNum=rand() % 30;
            array2[i][j]=RandomNum;
            
            RandomNum=rand() % 30;
            array3[i][j]=RandomNum;
        }
    }
    
    //print input array //
    for (int i=0;i<NUMS_INPUT;i++){
        printf("%d ", input_array[i]);
    }
    
    printf("\n");
    printArrays(array1,array2,array3);

    int winner=0;       //Store Winner grid
    int lastNum=-1;     //Store last number
    
    for (int num=0;num<NUMS_INPUT;num++){
        for (int i=0;i<GRID;i++){
            for (int j=0;j<GRID;j++){
                if (array1[i][j]==input_array[num]){
                    array1[i][j]=30;
                }
                if (array2[i][j]==input_array[num]){
                    array2[i][j]=30;
                }
                if (array2[i][j]==input_array[num]){
                    array2[i][j]=30;
                }
            }
        }
        if (num>=4){
            winner=CheckWinner(array1,array2,array3);
        }
        if (winner!=0){
            lastNum=input_array[num];   
            break;
        }
    }

    printArrays(array1,array2,array3);
    if (winner==1){
        printf("The score of the winning board is %d \n", calulateScore(array1,lastNum));
    }else if(winner==2){
        printf("The score of the winning board is %d \n", calulateScore(array2,lastNum));
    }else if(winner==3){
        printf("The score of the winning board is %d \n", calulateScore(array3,lastNum));
    }else{
        printf("There is no winner. \n");
    }
    return 0;
}

int CheckWinner(int grid1[GRID][GRID],int grid2[GRID][GRID],int grid3[GRID][GRID]){
        
        for (int i=0;i<GRID;i++){
                int countw1=0;
                int countw2=0;
                int countw3=0;
            for (int j=0;j<GRID;j++){
                    //check if row WINS       
                    if ((grid1[i][0]==30 && j==0)==1){
                        for (int k=0;k<GRID;k++){
                            if (grid1[i][k]==30){
                                countw1++;
                            }else{
                                break;
                            }
                        }
                        if (countw1==5){
                            printf("First board wins! \n");
                            return 1;
                        }
                    }else if(grid2[i][0]==30){
                        for (int k=0;k<GRID;k++){
                            if (grid2[i][k]==30){
                                countw2++;
                            }else{
                                break;
                            }
                        }
                        if (countw2==5){
                            printf("Second board wins! \n");
                            return 2;
                        }
                    }else if(grid3[i][0]){
                        for (int k=0;k<GRID;k++){
                            if (grid3[i][k]==30){
                                countw3++;
                            }else{
                                break;
                            }
                        }
                        if (countw3==5){
                            printf("Third board wins! \n");
                            return 3;
                        }
                    }
                    countw1=0;
                    countw2=0;
                    countw3=0;
                     //check if column WINS
                    if ((grid1[i][j]==30 && i==0)==1){
                        for (int l=0;l<GRID;l++){
                            if (grid1[l][j]==30){
                                countw1++;
                            }else{
                                break;
                            }
                        }
                        if (countw1==5){
                            printf("First board wins! \n");
                            return 1;
                        }
                    }else if((grid2[i][j]==30 && i==0)==1){
                        for (int l=0;l<GRID;l++){
                            if (grid2[l][j]==30){
                                countw2++;
                            }else{
                                break;
                            }
                        }
                        if (countw2==5){
                            printf("Second board wins! \n");
                            return 2;
                        }
                    }else if((grid3[i][j]==30 && i==0)==1){
                        for (int l=0;l<GRID;l++){
                            if (grid3[l][j]==30){
                                countw3++;
                            }else{
                                break;
                            }
                        }
                        if (countw3==5){
                            printf("Third board wins! \n");
                            return 3;
                        }
                    }
            }
        }
        return 0;
}

void printArrays(int grid1[GRID][GRID],int grid2[GRID][GRID],int grid3[GRID][GRID]){
        for (int ar=1; ar<=3; ar++){
        printf("\n");
        for (int i=0; i<GRID; i++){
            for (int j=0; j<GRID; j++){
                if (ar==1){
                    printf("%d " , grid1[i][j]);
                }else if(ar==2){
                    printf("%d " , grid2[i][j]);
                }else{
                    printf("%d " , grid3[i][j]);
                }
            }
            printf("\n");
        }
        printf("\n");
    }
}

int calulateScore(int winner[GRID][GRID],int finalNUM){
    int sum=0;
    
    for (int i=0;i<GRID;i++){
        for(int j=0;j<GRID;j++){
            if (winner[i][j]!=30){
                sum=sum+winner[i][j];
            }   
        }
    }

    return sum*finalNUM;
}