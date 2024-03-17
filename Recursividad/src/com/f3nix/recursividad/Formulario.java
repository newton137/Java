package com.f3nix.recursividad;
import javax.swing.*;
public class Formulario extends JFrame{
Formulario(){
	setLayout(null);
}
public static void main(String [] args){
	Formulario form1 = new Formulario();
	form1.setBounds(0,0,1024,800);
	form1.setResizable(false);
	form1.setVisible(true);
}
}
