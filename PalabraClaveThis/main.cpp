#include <iostream>
using namespace std;
class PalabraClaveThis{
public: PalabraClaveThis(int a): variable(a){}
void imprimir(){
cout << variable << endl;
}
private: int variable;
};

int main()
{
    PalabraClaveThis objeto(55);
    objeto.imprimir();
    return 0;
}
