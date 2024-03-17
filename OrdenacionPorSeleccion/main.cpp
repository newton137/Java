#include <iostream>
#include <cstdio>
using namespace std;


void seleccion(int lista[], int tamano){
for(int x = 0; x < tamano-1; x++){
    int minj = x;
    int minx = lista[x];
    for(int y = x+1; y < tamano; y++){
        if(lista[y] < minx){
            minj = y;
            minx = lista[y];
        }
    }
    lista[minj] = lista[x];
    lista[x] = minx;
}
for(int z = 0; z < tamano; z++){
    cout << lista[z]<< endl;
}
}
int main()
{
    int listas[] = {5,7,3,7,9,1,4,5,32,54,24,34,56,72,10,56,2,3,1,22,45,68};
    seleccion(listas,22);
}
