package com.fenix.InteligenciaArtificial;

import java.util.*;

public class NeuralNetwork
{
    
    static double[][] weights = new double[2][1];
    
    
    public static double[][] sott_matr(double a[][], double[][] b){
        double[][] c= new double[a.length][a[0].length];
        for( int r=0; r<a.length; r++)
            {for (int col=0; col<a[0].length; col++){
            c[r][col]=a[r][col]-b[r][col];
        }}
        
        return c;
    }
    
    public static double[][] somm_matr(double a[][], double[][] b){
        double[][] c= new double[a.length][a[0].length];
        for( int r=0; r<a.length; r++)
            {for (int col=0; col<a[0].length; col++){
            c[r][col]=a[r][col]+b[r][col];
        }}
        
        return c;
    }
    
    public static double[][] trasposta(double[][] iniz){
        double[][] T= new double[iniz[0].length][iniz.length];
        for( int r=0; r<iniz.length; r++)
            {for (int c=0; c<iniz[0].length; c++){
                T[c][r]=iniz[r][c];}}
        return T;
    }
    
    public static double[][] prodotto_scalare(double [][]a, double[][] b)
    {
        double[][] c =new double[a.length][b[0].length];
        for(int i=0; i<a.length;i++){
            for(int n=0; n<b[0].length;n++){
            for(int f=0; f< a[0].length; f++){
                c[i][n]+=a[i][f]*b[f][n];
            }}
        }
        return c;    
    }
    
    public static double[][] rid(double[][] a){
        double[][] b=new double[a.length][a[0].length];
        for(int i=0; i<a.length;i++){
            for(int n=0; n<a[0].length;n++){
                b[i][n]=0.01*a[i][n];
            }
        }
        return b;
    }
    
    public void train(double[][] inputs, double[][] outputs,int rep){
            double[][] output;
            double[][] error;
            double[][] adjustment;
            for(int i=0;i<rep;i++){
            output=this.think(inputs);
            error=sott_matr(outputs,output);
            adjustment=prodotto_scalare(trasposta(inputs),error);
            adjustment=rid(adjustment);
            weights=somm_matr(weights,adjustment);
            
            
        }
    }
    
    public double[][] think(double[][] inputs){
        double ris[][];
        ris= prodotto_scalare(inputs,weights);
        return ris;
    }
    
    public static void print(double[][] c){
        for(int r=0;r<2;r++)
        for(int col=0;col<2;col++)
            System.out.println(c[r][col]);
    }
    
    public static void main(String[] args){
        weights[0][0]=Math.random();
        weights[1][0]=Math.random();
        double[][] inputs={{2,3},{1,1},{5,2},{12,3}};
        double[][] outputs={{10,4,14,30}};
        double[][] n_input={{15,2}};
        NeuralNetwork n_ntw =new NeuralNetwork();
        n_ntw.train(inputs,trasposta(outputs), 10000);
        double[][] d=n_ntw.think(n_input);

        System.out.println(d[0][0]);
       
    }
}
