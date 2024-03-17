package com.fenix.InteligenciaArtificial;

import java.util.ArrayList;

public class Sort {
    
//NOTE: Please copy and paste this code into your Java IDE because code playground says "time limit exceeded" if the runtime test takes too long". 
    
    
    // To use this program just follow the advise "How to use" in the main method at the bottom
    public static final int INSERTION = 1;
    static final int SELECTION = 2;
    static final int BUBBLE = 3;
    static final int MERGE = 4;
    static final int QUICK = 5;
    static final int ASC = 1;
    static final int DESC = 2;
    static final int RAND = 3;
    /**
     * Sortieren durch Einfügen in eine sortierte Liste
     * @param array
     */
    public static void insertionSort(ArrayList<Integer> array){
        
        
        for(int i = 1; i < array.size(); i ++){
            int buffer = array.get(i);
            int j;
            for(j = i ; j > 0 && array.get(j-1) > buffer; j--){
                array.set(j, array.get(j-1));        
            }
             array.set(j, buffer);
        }    
    }
    
    /**
     * Sortieren durch Auswahl des kleinsten Elements.
     * @param array
     */
    public static void selectionSort(ArrayList<Integer> array){
        
        int iterator = 0;
        while(iterator < array.size()){
        int min = iterator;
            for(int i = iterator + 1; i < array.size(); i ++){
                if(array.get(i) < array.get(min)){
                min = i;
                }
            }
            int buffer = array.get(iterator);
            array.set(iterator, array.get(min));
            array.set(min, buffer);
            iterator ++;
        }
        
        
    }
    
    
    public static void bubbleSort(ArrayList<Integer> array){
        for (int i = array.size(); i > 1; i--){
            
            for(int j = 0; j < i-1; j++ ){
                
                if(array.get(j) > array.get(j+1)){
                    int buffer = array.get(j);
                    array.set(j, array.get(j+1));
                    array.set(j+1, buffer);
                }
            }
        }
    
    }
    
    /**
     * Sortierung über rekursive Aufteilung und Zusammenfügen per Reißverschlussverfahren
     * @param array
     */
    public static void mergeSort(ArrayList<Integer> array){
        
        msort(array,0,array.size()-1);
        
        
    }
    
    public static void msort(ArrayList<Integer> array,int left, int right){
        int i, j , k;
        //Hilfsarray
        int[] b = new int[array.size()];
        
        
        //Solange die Teilliste noch mehr als ein Element hat
        if(right > left){
            //Teillisten teilen
            int mid = (left + right) / 2;
            //linke Liste
            msort(array,left,mid);
            //rechte Liste
            msort(array,mid +1, right);
            
            //Hilfsarray befüllen
            //Linkes Seite des Hilfsarrays wird von links nach rechts befüllt
            for(k  = left; k <= mid; k++ ){
                b[k] = array.get(k);
            }
            //Rechtes Array wird von rechts nach links befüllt
            for(k = mid; k <right; k++){
                b[right + mid - k] = array.get(k+1);
            }
            
            i = left;
            j = right;
            for( k = left;  k <= right; k ++){
                if(b[i] <  b[j]){
                    array.set(k, b[i++]);
                }else{
                    array.set(k, b[j--]);
                }
            }
        }
    }
    /**
     * Sortiert eine Liste indem Werte mit einem Pivotelement verglichen werden.
     * @param array - Zu sortierende Liste
     */
    public static void quickSort(ArrayList<Integer> array){
    
        qsort(array, 0, array.size()-1);
        
    }
    
    public static void qsort(ArrayList<Integer> array, int left, int right){
        int low = left;
        int high = right;
        if(high > low){
            
            int pivot = array.get((left + right) / 2);
            
            while( low <= high){
                while(low < right && array.get(low) < pivot){
                    ++ low;
                }
                
                
                while( high > left && array.get(high) > pivot){
                    --high;
                }
                
                if(low <= high){
                    int temp = array.get(low);
                    array.set(low, array.get(high));
                    array.set(high, temp);
                    ++low;
                    --high;
                }
            }
            
            
            if(left < high){
                qsort(array, left, high);
                
            }
            
            if(low < right){
                qsort(array, low, right);
            }
        }
    }
    /**
     * Gibt die Laufzeit des ausgewählten Sortieralgorithmus in Millisekunden zurück
     * @param params - Anzahl der zu sotierenden Werte
     * @param iterations - Durchläufe pro Test
     * @param order - <code>ASC</code> für aufsteigend sortierte Liste, <code>DESC</code>
     * für absteigend sortierte Liste und <code>RANDOM</code> für zufällig generierte Werte.
     * @param sort - Auswahl des Sortieralgorithmus
     */
    public static void getRuntime(int params,int iterations,int order, int sort){
        ArrayList<Integer> list = new ArrayList<Integer>();
        
        System.out.println(">>>>>STARTING TEST<<<<<");
        System.out.println("Repeats: " + iterations + " time(s)");
        if(order == 1){
        
            System.out.println("List order: ASCENDING");
        }else if(order == 2){
        
            System.out.println("List order: DESCENDING");
        }else{
            
            System.out.println("List order: RANDOM");
        }
        
        long duration = 0;
        int avg = iterations;
        long start;
        long end;
        long time;
        
        switch(sort){
        case 1:
            
            System.out.println("InsertionSort Test:");    
            System.out.println("Parameters n = " + params + ":");
            
            switch(order){
            case 1:
                for (int i = 0; i < iterations; i++){
                    
                    //Creating unsorted list in ascending order
                    for(int j = 0; j < params; j++){
                        list.add(j);
                    }    
                    start = System.currentTimeMillis();
                    Sort.insertionSort(list); 
                    end = System.currentTimeMillis();
                    time = end - start;
                    duration += time;
            }
                break;
            case 2:
                for (int i = 0; i < iterations; i++){
                    //Creating unsorted list in ascending order
                    
                    for(int j = params; j > 0; j--){
                        list.add(j);
                    }
                    start = System.currentTimeMillis();
                    Sort.insertionSort(list); 
                    end = System.currentTimeMillis();
                    time = end - start;
                    duration += time;
            }
                break;
            case 3:
                for (int i = 0; i < iterations; i++){
                    //Creating unsorted list
                    
                    for(int j = 0; j < params; j++){
                        
                        int random = (int)(Math.random() * params);
                        list.add(random);
                    }
                    
                    start = System.currentTimeMillis();
                    Sort.insertionSort(list); 
                    end = System.currentTimeMillis();
                    time = end - start;
                    duration += time;
                }
                break;
            }
            
            
            System.out.println("Test finished:  Average runtime: " + duration / avg + " millisecs");
            System.out.println("");
            break;
        case 2:
            System.out.println("SelectionSort Test:");    
            System.out.println("Parameters n = " + params + ":");
            
            
            switch(order){
            case 1:
                
                    for (int i = 0; i < iterations; i++){
                    
                        //Creating unsorted list in ascending order
                        for(int j = 0; j < params; j++){
                            list.add(j);
                        }    
                        start = System.currentTimeMillis();
                        Sort.selectionSort(list); 
                        end = System.currentTimeMillis();
                        time = end - start;
                        duration += time;
                    }
                break;
            case 2:
                
                for (int i = 0; i < iterations; i++){
                
                //Creating unsorted list in descending order
                for(int j = params; j > 0; j--){
                    list.add(j);
                }
                
                
                start = System.currentTimeMillis();
                Sort.selectionSort(list); 
                end = System.currentTimeMillis();
                time = end - start;
                duration += time;
        }
                break;
            case 3:
                for (int i = 0; i < iterations; i++){
                    
                    //Creating unsorted list
                    for(int j = 0; j < params; j++){
                        
                        int random = (int)(Math.random() * params);
                        list.add(random);
                    }
                    
                    start = System.currentTimeMillis();
                    Sort.selectionSort(list); 
                    end = System.currentTimeMillis();
                    time = end - start;
                    duration += time;
                }
                break;
            }
            System.out.println("Test finished:  Average runtime: " + duration / avg + " millisecs");
            System.out.println("");
        
            break;
        case 3:
            System.out.println("BubbleSort Test:");    
            System.out.println("Parameters n = " + params + ":");
            
            
            switch(order){
            case 1:
                for (int i = 0; i < iterations; i++){
                    
                    //Creating unsorted list in ascending order
                    for(int j = 0; j < params; j++){
                        list.add(j);
                    }    
                    start = System.currentTimeMillis();
                    Sort.bubbleSort(list); 
                    end = System.currentTimeMillis();
                    time = end - start;
                    duration += time;
            }
                break;
            case 2:
                for (int i = 0; i < iterations; i++){
                    
                    //Creating unsorted list in descending order
                    for(int j = params; j > 0; j--){
                        list.add(j);
                    }
                    start = System.currentTimeMillis();
                    Sort.bubbleSort(list); 
                    end = System.currentTimeMillis();
                    time = end - start;
                    duration += time;
            }
                break;
            case 3:
                for (int i = 0; i < iterations; i++){
                    //Creating unsorted list
            
                    for(int j = 0; j < params; j++){
                        
                        int random = (int)(Math.random() * params);
                        list.add(random);
                    }
                    
                    start = System.currentTimeMillis();
                    Sort.bubbleSort(list); 
                    end = System.currentTimeMillis();
                    time = end - start;
                    duration += time;
                }
                break;
            }
            System.out.println("Test finished:  Average runtime: " + duration / avg + " millisecs");
            System.out.println("");
            break;
        case 4:
            System.out.println("Mergesort Test:");    
            System.out.println("Parameters n = " + params + ":");
        
            
            switch(order){
            case 1:
                for (int i = 0; i < iterations; i++){
                    
                    //Creating unsorted list in ascending order
                    for(int j = 0; j < params; j++){
                        list.add(j);
                    }    
                    start = System.currentTimeMillis();
                    Sort.mergeSort(list); 
                    end = System.currentTimeMillis();
                    time = end - start;
                    duration += time;
            }
                break;
            case 2:
                for (int i = 0; i < iterations; i++){
                    
                    //Creating unsorted list in descending order
                    for(int j = params; j > 0; j--){
                        list.add(j);
                    }
                    start = System.currentTimeMillis();
                    Sort.mergeSort(list); 
                    end = System.currentTimeMillis();
                    time = end - start;
                    duration += time;
            }
                break;
            case 3:
                for (int i = 0; i < iterations; i++){
                    //Creating unsorted list
                    
                    for(int j = 0; j < params; j++){
                        
                        int random = (int)(Math.random() * params);
                        list.add(random);
                    }
                    
                    start = System.currentTimeMillis();
                    Sort.mergeSort(list); 
                    end = System.currentTimeMillis();
                    time = end - start;
                    duration += time;
                }
                break;
            }
            System.out.println("Test finished:  Average runtime: " + duration / avg + " millisecs");
            System.out.println("");
            break;
        case 5:
            System.out.println("Quicksort Test:");    
            System.out.println("Parameters n = " + params + ":");
            
            switch(order){
            case 1:
                for (int i = 0; i < iterations; i++){
                    
                    //Creating unsorted list in ascending order
                    for(int j = 0; j < params; j++){
                        list.add(j);
                    }    
                    start = System.currentTimeMillis();
                    Sort.quickSort(list); 
                    end = System.currentTimeMillis();
                    time = end - start;
                    duration += time;
            }
                break;
            case 2:
                for (int i = 0; i < iterations; i++){
                    
                    //Creating unsorted list in descending order
                    for(int j = params; j > 0; j--){
                        list.add(j);
                    }
                    start = System.currentTimeMillis();
                    Sort.quickSort(list); 
                    end = System.currentTimeMillis();
                    time = end - start;
                    duration += time;
            }
                break;
            case 3:
                for (int i = 0; i < iterations; i++){
                    
                    //Creating unsorted list
                    for(int j = 0; j < params; j++){
                        
                        int random = (int)(Math.random() * params);
                        list.add(random);
                    }
                    
                    start = System.currentTimeMillis();
                    Sort.quickSort(list); 
                    end = System.currentTimeMillis();
                    time = end - start;
                    duration += time;
                }
                break;
            }
            System.out.println("Test finished:  Average runtime: " + duration / avg + " millisecs");
            System.out.println("");
        }    
    }
    
    public static void main (String [] args){
        
        //HOW TO USE:
        
          /*Program for analyzing the runtime of sorting algorithms.
     * Had to do this during my studies.
     * To call the method getRuntime(int params, int iterations, int order, int sort)
     * you first have to enter the amount of parameters that will be inserted in the unsorted ArrayList.
     * The second parameter takes the amount of how often you want to sort the given list.
     * The third parameter takes whether your list will be sorted ascending, descending or random.
     * You can choose between Sort.ASC, Sort.DESC and Sort.RAND
     * The last parameter defines the sorting algorithm you want to test.
     * Though the sorting methods are static you can call them by Sort."ALGORITHM".
     * You can choose between Sort.INSERTION, Sort.SELECTION, Sort.BUBBLE, 
     * Sort.MERGE, Sort.QUICK.     
    */
    
    //Example for usage
    Sort.getRuntime(1000, 5, Sort.RAND, Sort.SELECTION);
    }
}
