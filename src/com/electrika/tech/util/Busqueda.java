package com.electrika.tech.util;

import java.util.List;

public class Busqueda {

    public static Integer busquedaBinaria(List<String> list, String valor) {

        //Busqueda elementos ascendentes
        int li = 0;
        int ls = list.size() - 1;

        while (li <= ls) {
            int lm = (ls - li) / 2 + li;

            if ((list.get(lm).compareTo(valor)) < 0) {
                li = lm + 1;

            } else if ((list.get(lm).compareTo(valor)) > 0) {
                ls = lm - 1;
            } else {
                return lm;
            }
        }

        //Busqueda elementos descendentes
        li = 0;
        ls = list.size() - 1;
        while (li <= ls) {
            int lm = (ls - li) / 2 + li;
            if ((list.get(lm).compareTo(valor)) > 0) {
                li = lm + 1;
            } else if ((list.get(lm).compareTo(valor)) < 0) {
                ls = lm - 1;
            } else {
                return lm;
            }
        }

        return null; // Elemento no encontrado
    }

    public static Integer busquedaBinariaNumeric(List<String> list, double valor) {

        int li = 0;
        int ls = list.size() - 1;

        while (li <= ls) {
            int lm = li + (ls - li) / 2;
            double elementoMedio = Double.parseDouble(list.get(lm));

            if (elementoMedio == valor) {
                return lm; // Elemento encontrado
            } else if (elementoMedio < valor) {
                li = lm + 1; // Buscar en la mitad derecha
            } else {
                ls = lm - 1; // Buscar en la mitad izquierda
            }
        }

        li = 0;
        ls = list.size() - 1;

        while (li <= ls) {
            int lm = li + (ls - li) / 2;
            double elementoMedio = Double.parseDouble(list.get(lm));

            if (elementoMedio == valor) {
                return lm; // Elemento encontrado
            } else if (elementoMedio > valor) {
                li = lm + 1; // Buscar en la mitad derecha
            } else {
                ls = lm - 1; // Buscar en la mitad izquierda
            }
        }
        return null;
    }
}
