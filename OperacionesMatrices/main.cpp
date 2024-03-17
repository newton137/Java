#include <iostream>
#include <stdlib.h>
#include <conio.h>
using namespace std;

int main()
{
    int tamano;
    int i,j,auxiliar;
    cout << "Ingrese el tamaño del arreglo: " << endl;
    cin >> tamano;
    int arreglo1[tamano];
    int arreglo2[tamano];
    int arreglo3[tamano*2];
    int arreglo4[tamano*2];
    cout << "Ingrese Primer Vector: " << endl;
    for (i = 0; i < tamano; i++){
        cin >> arreglo1[i];
    }
    cout << "Ingrese Segundo Vector: " << endl;
    for (i = 0; i < tamano; i++){
        cin >> arreglo2[i];
    }
    for (i = 0; i < tamano; i++){
        arreglo3[i] = arreglo1[i];
    }
    for (i = tamano; i < tamano*2; i++){
        arreglo3[i] = arreglo2[i-tamano];
    }
    cout << "La unión de los vectores es: ";
    for (i = 0; i < tamano * 2; i++){
        cout << arreglo3[i] << " , ";
    }
    cout << "\n" << "Su Intersección es: " ;
    for (i = 0; i < tamano; i++){
        for (j = 0; j < tamano; j++){
            if (arreglo1[i] == arreglo2[j]){
                cout << arreglo2[j] << " , ";
            }
        }
    }
    for (i = 0; i < tamano*2; i++){
        arreglo4[i] = arreglo3[i];
    }
    for (i = 0; i < tamano*2-1; i++){
        for (j = 0; j < tamano*2-1; j++){
            if (arreglo4[j] > arreglo4[j+1]){
                auxiliar = arreglo4[j];
                arreglo4[j] = arreglo4[j+1];
                arreglo4[j+1] = auxiliar;
            }
        }
    }
    cout << "\n" << "El vector ordenado es: ";
    for (i = 0; i < tamano * 2; i++){
        cout << arreglo4[i] << " , ";
    }
    return 0;
}
