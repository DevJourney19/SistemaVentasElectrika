package com.electrika.tech.util;


public class Ordenamiento {
    
    
    //quickSort String
    public static void quickSort(Object[] rows, int low, int high, int columnIndex, String type) {
        if (low < high) {
            int partitionIndex = partition(rows, low, high, columnIndex, type);
            quickSort(rows, low, partitionIndex - 1, columnIndex, type);
            quickSort(rows, partitionIndex + 1, high, columnIndex, type);
        }
    }
    
    public static int partition(Object[] rows, int low, int high, int columnIndex, String type) {
        //calcula el pivot es el ultimo numero
        Object[] pivot = (Object[]) rows[high];
        int i = low - 1;
        for (int j = low; j < high; j++) {
            //es ascendente ya que se haria el cambio si la fila 1 es menor a la fila 2 que es el pivot, entonces se intercambia el anterior con el siguiente indice
            if (compare((Object[]) rows[j], pivot, columnIndex) < 0 && type=="ascendente") {
                i++;
                swap(rows, i, j);
            }
            
            if (compare((Object[]) rows[j], pivot, columnIndex) > 0 && type=="descendente") {
                i++;
                swap(rows, i, j);
            }
            
        }
        swap(rows, i + 1, high);
        return i + 1;
    }

    public static int compare(Object[] row1, Object[] row2, int columnIndex) {
        //compara dos filas la fila de un cierto inice y el pivot basandose en el valor de una columna
        Comparable<Object> value1 = (Comparable<Object>) row1[columnIndex];
        Comparable<Object> value2 = (Comparable<Object>) row2[columnIndex];
        //devuelve un numero negativo si value1 es menor y un numero positivo si es mayor
        return value1.compareTo(value2);
    }

    public static void swap(Object[] rows, int i, int j) {
        Object temp = rows[i];
        rows[i] = rows[j];
        rows[j] = temp;
    }
    
    
    //Merge Sort datos numericos
    public static void sort(Object arr[], int l, int r, int columnIndex, String tipo) {
        if (l < r) {
            int m = l + (r - l) / 2;
            sort(arr, l, m, columnIndex, tipo);
            sort(arr, m + 1, r, columnIndex, tipo);
            merge(arr, l, m, r, columnIndex, tipo);
        }
    }
    
    public static void merge(Object arr[], int l, int m, int r, int columnIndex, String tipo) {
        int n1 = m - l + 1;
        int n2 = r - m;

        Object L[] = new Object[n1];
        Object R[] = new Object[n2];

        for (int i = 0; i < n1; ++i) {
            L[i] = arr[l + i];
        }
        for (int j = 0; j < n2; ++j) {
            R[j] = arr[m + 1 + j];
        }

        int i = 0, j = 0;
        int k = l;
        if (tipo.equals("ascendente")) {
            while (i < n1 && j < n2) {
                if (compareMerge(L[i], R[j], columnIndex) <= 0) {
                    arr[k] = L[i];
                    i++;
                } else {
                    arr[k] = R[j];
                    j++;
                }
                k++;
            }
        } else if (tipo.equals("descendente")) {
            while (i < n1 && j < n2) {
                if (compareMerge(L[i], R[j], columnIndex) >= 0) {
                    arr[k] = L[i];
                    i++;
                } else {
                    arr[k] = R[j];
                    j++;
                }
                k++;
            }
        }

        while (i < n1) {
            arr[k] = L[i];
            i++;
            k++;
        }

        while (j < n2) {
            arr[k] = R[j];
            j++;
            k++;
        }
    }

    // Método para comparar dos objetos en función de un índice específico
    private static int compareMerge(Object obj1, Object obj2, int columnIndex) {
        Comparable<Object> comp1 = (Comparable<Object>) ((Object[]) obj1)[columnIndex];
        Comparable<Object> comp2 = (Comparable<Object>) ((Object[]) obj2)[columnIndex];
        return comp1.compareTo(comp2);
    }
}
