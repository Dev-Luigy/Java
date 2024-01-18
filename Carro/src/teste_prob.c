#include <stdio.h>
#include <stdlib.h>

int * solver (int * Numeros, int * MinMax){

}

int main (){
    int modifier, quantNum = modifier = 0; scanf ("%d%d", &modifier, &quantNum);
    int Numeros[quantNum];
    int MinMax[2];
    for (int i = 0; i < quantNum; i ++) {
        scanf ("%d", &Numeros[i]);
        MinMax[0] = MinMax[0] > Numeros[i] ? Numeros[i] : MinMax[0];
        MinMax[1] = MinMax[1] < Numeros[i] ? Numeros[i] : MinMax[1];
    }

    //solver;
    
}