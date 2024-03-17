#include <iostream>

using namespace std;


class Madre{
    public:
Madre(){
cout << "Este es el constructor de la clase Madre" << endl;
}
~Madre(){
cout << "Este es el destructor de la clase Madre" << endl;
}
};


class Hija : public Madre{
public:
    Hija(){
cout << "Este es el constructor de la clase hija" << endl;
}
~Hija(){
cout << "Este es el destructor de la clase hija"  << endl;
}
};

int main()
{
    Hija objeto;
    return 0;
}
