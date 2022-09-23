/* Adevent Of Code 1 */
#include <stdio.h>
#include <stdlib.h>
#define SONNAR 10          //1= sonnar measurements

int main(){
    int sweeps[SONNAR];
    time_t t;
    srand((unsigned) time(&t));     //initialize random generator for sonnar sweeps
    
    /*10 random sweeps reports*/
    for (int i=0;i<SONNAR; i++){
        sweeps[i]=rand() % 1000;   //range 0-1000 
    }
    
    int sum=0;
    
    for (int i=1; i<SONNAR; i++){
        if (i==1){ printf("%d \n",sweeps[i-1]); }
        
        if (sweeps[i]>sweeps[i-1]){
            printf("%d (increased) \n",sweeps[i]);
            sum++;
        }else{
            printf("%d \n",sweeps[i]);
        }
    }
    printf("The number of times a depth measurement increases is: %d \n",sum);
}   