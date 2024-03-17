#include <iostream>
using namespace std;
class formulaBellard{
public: double potencia(double numero){
    numero *= 4;
    double dos = 2;
for(double x = 1; x < numero; x++){
    dos *= 2;
}
return dos;
}
};
int main()
{
    formulaBellard objeto;
    double n = 0;
    double pi = (1/(objeto.potencia(n)))*((4/((8*n)+1))-(2/((8*n)+4))-(1/((8*n)+5))-(1/((8*n)+6)));
    cout << pi<< endl;
}

