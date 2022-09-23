/* advent of code 5 */

#include <stdio.h>
#include <stdlib.h>
#define GRID 10

struct Point{
    int x;
    int y;
};

typedef struct LinesList *Lines;

struct LinesList{
    struct Point p1;
    struct Point p2;
    Lines next;
};

int empty(Lines);       //returns 1 if lists Lines is empty else return 0
void Insert(Lines*);
void printLN(Lines);    //Print Lines
int DagerousPoints(int gr[GRID][GRID]);

int main(){
    Lines lns;
    lns=NULL;
    time_t t;
    srand((unsigned) time(&t));     //initialize random generator for submarine's commands
    for (int i=0;i<3;i++){
        insert(&lns);
    }

    PrintLN(lns);
    printf("\n");

    int grid[GRID][GRID];
    
    for (int i=0;i<GRID;i++){           //Initialize Grid
        for (int j=0;j<GRID;j++){
            grid[i][j]=0;
        }
    }

    while(lns!=NULL){
        int x1=lns->p1.x;
        int y1=lns->p1.y;
        int x2=lns->p2.x;
        int y2=lns->p2.y;
        if (x1 == x2){
            if (y1>y2){
                for (int p=y2;p<=y1;p++){
                    grid[p][x1]++;
                }
            }else{
                for (int p=y1;p<=y2;p++){
                    grid[p][x1]++;
                }
            }
        }else{
            if (x1>x2){
                for (int p=x2;p<=x1;p++){
                    grid[y1][p]++;
                }
            }else{
                for (int p=x1;p<=x2;p++){
                    grid[y1][p]++;
                }
            }
        }
        lns=lns->next;
    }

    for (int i=0;i<GRID;i++){           //Print Grid
        for (int j=0;j<GRID;j++){
            printf("%d ",grid[i][j]);
        }
        printf("\n");
    }

    printf("\n");

    printf("The number of dangerous points is %d. \n" , DagerousPoints(grid));

}


int empty(Lines ln){
    if (ln == NULL){
        return 1;
    }else{
        return 0;
    }
}

void insert(Lines *ln){
    while (*ln!=NULL){
        ln=&((*ln)->next);
    }

    *ln=malloc(sizeof(struct LinesList));
    int randomX1=rand() % 10;
    int randomY1=rand() % 10;
    if((randomX1-randomY1) % 2 == 0){
        int randomX2=randomX1;
        int randomY2=rand() % 10;
        (*ln)->p1.x=randomX1;
        (*ln)->p1.y=randomY1;
        (*ln)->p2.x=randomX2;
        (*ln)->p2.y=randomY2;
    }else{
        int randomY2=randomY1;
        int randomX2=rand() % 10;
        (*ln)->p1.x=randomX1;
        (*ln)->p1.y=randomY1;
        (*ln)->p2.x=randomX2;
        (*ln)->p2.y=randomY2;
    }

    (*ln)->next=NULL;
}

void PrintLN(Lines ln){
    while(ln!=NULL){
        printf("%d,%d -> %d,%d", ln->p1.x, ln->p1.y, ln->p2.x , ln->p2.y);
        printf("\n");
        ln=ln->next;
    }
}

int DagerousPoints(int gr[GRID][GRID]){
    int count=0;
    
    for (int i=0;i<GRID;i++){
        for (int j=0;j<GRID;j++){
            if (gr[i][j]>=2){
                count++;
            }
        }
    }

    return count;
}