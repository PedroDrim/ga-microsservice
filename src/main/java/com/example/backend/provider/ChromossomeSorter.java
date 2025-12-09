package com.example.backend.provider;

import com.example.backend.model.Chromossome;

import java.util.Comparator;

/**
 * Classe responsavel por comparar dois cromossomos
 * @see Comparator
 */
public class ChromossomeSorter implements Comparator<Chromossome> {

    /**
     * Metodo responsavel por comparar dois cromossomos
     * @param x O primeiro cromossomo
     * @param y O segundo cromossomo
     * @return Valor de comparacao
     */
    public int compare(Chromossome x, Chromossome y){
        return Double.compare(y.getFitness(), x.getFitness());
    }
}
