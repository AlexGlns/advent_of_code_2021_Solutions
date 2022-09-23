/* advent of code 2 */
#include <stdio.h>
#include <stdlib.h>
#define NUM_COMMANDS 6 

typedef struct CommandList *Commands;

struct CommandList {
    int value;
    char* command;
    Commands next;
};

int empty(Commands);       //returns 1 if list commands is empty else return 0
void insert(Commands*);   //Insert random command to list
void compute(Commands, int *, int *);   //Computes final horizontal position and depth
void printC(Commands);       //Prints list of submarine's commands

int main(void)
{Commands cmd;
 cmd=NULL;
 int depth=0;
 int horizon=0;
 time_t t;
 srand((unsigned) time(&t));     //initialize random generator for submarine's commands

 for (int i=0;i<NUM_COMMANDS;i++){
     insert(&cmd);               //insert 6 random commands
 }
 
 printC(cmd);

 compute(cmd,&horizon,&depth);
 printf("Final horizontal Position:%d \n",horizon);
 printf("Final Depth:%d \n",depth);
}

int empty(Commands cm){
    if (cm == NULL){
        return 1;
    }else{
        return 0;
    }
}

void insert(Commands *cm){
    while (*cm!=NULL){
        cm=&((*cm)->next);
    }
    *cm=malloc(sizeof(struct CommandList));
    int randomCommand=rand() % 3;
    if (randomCommand==0){
        (*cm)->command="up";
    }else if(randomCommand==1){
        (*cm)->command="down";
    }else{
        (*cm)->command="forward";
    }
    int randomvalue=(rand() % 10)+1; //range 1-10
    (*cm)->value=randomvalue;
    (*cm)->next=NULL;
}

void compute(Commands cm,int *h,int *d){
    while (cm !=NULL){
        if (cm->command=="up"){
            *d+=cm->value;
        }else if(cm->command=="down"){
            *d=*d-(cm->value);
        }else{
            *h+=cm->value;
        }
        cm=cm->next;
    }
}

void printC(Commands cm){
    while(cm!=NULL){
        printf("%s : %d \n",cm->command,cm->value);
        cm=cm->next;
    }
}