package com.fenix.InteligenciaArtificial;

/**
 *   CREATED BY SECKAR
 *   
 *   A simple genetic algorithm using Holland's roulette wheel model for the testig of Rastrigin fitness landscape
 * 
 *   The output is designed for a wider screen so it might be a good idea to zoom out, there are three columns:
 *   * The binary interval division
 *   * The equivalent real number ( x )
 *   * The fitness function ( f(x) )
 * 
 *   EDIT: Apparently the code is too complex for the simple sololearn compiler and requires too much processing power, but feel free to copy and paste it in any other compiler.
 */


import java.util.Random;
import java.util.Vector;

@SuppressWarnings("ALL")

public class bitset {

    int[] bits = new int[100];
    int length;

    bitset(int len)                                             {

        length = len;

        for (int i : bits)
            i = 0;

    }
    bitset(int len, int sample_bit)                             {

        length = len;

        for (int i : bits)
            i = sample_bit;
    }
    bitset(int len, Random random_bit_generator)                {

        length = len;

        for (int i = 0; i < length; ++i)
            bits[i] = random_bit_generator.nextInt(2);
    }
    bitset(int[] sample_bitset)                                 {

        length = sample_bitset.length;

        for (int i : bits)
            i = 0;

        System.arraycopy(sample_bitset, 0, bits, 0, sample_bitset.length);
    }
    bitset(bitset source_bitset)                                {

        length = source_bitset.length;

        System.arraycopy(source_bitset.bits, 0, bits, 0, length);
    }

    void flip(int index)                                        {

        bits[index] = 1 - bits[index];
    }

    void copy_from(bitset source_bitset)                        {

        length = source_bitset.length;

        System.arraycopy(source_bitset.bits, 0, bits, 0, length);
    }
    public void interchange_with(bitset target_bitset)          {

        for (int i = 0; i < length; ++i){
            bits[i] = bits[i] + target_bitset.bits[i];
            target_bitset.bits[i] = bits[i] - target_bitset.bits[i];
            bits[i] = bits[i] - target_bitset.bits[i];
        }
    }

    private int to_int()                                        {

        int value = 0;

        for (int i = 0; i < length; ++i)
            value += bits[i] * Math.pow(2, length - (i + 1));

        return value;
    }
    public void from_int(int value)                             {

        if(value > Math.pow(2, length) - 1 || value < 0){
            System.out.print("\n================\nILLEGAL ARGUMENT\n================\n");
            return;
        }

        for(int i : bits)
            i = 0;

        for(int i = 0; i < length; ++i) {
            bits[length - (i + 1)] = value % 2;
            value /= 2;
        }
    }

    double to_decimal(double start, double stop, int precision) {

        final double n = Math.ceil(Math.log((stop - start) * Math.pow(10, precision))/Math.log(2));

        return (start + this.to_int() * (stop - start) / (Math.pow(2, n) - 1));
    }

    void display()                                              {
        for(int i=0; i <= length; ++i)
            System.out.print(bits[i]);
        System.out.print("\t");
    }
}
