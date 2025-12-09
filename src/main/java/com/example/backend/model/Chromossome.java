package com.example.backend.model;

import java.util.Random;

/**
 * Classe repsonsavel por abstrair um cromossomo
 */
public class Chromossome {

    /**
     * Array de valores do cromossomo de 0 á 100
     */
    private final double[] chromossome = new double[2];

    /**
     * Valor de fitness do cromossomo
     */
    private double fitness = 0;

    /**
     * Construtor publico da classe
     * @param random Classe de aleatoriedade do Java
     */
    public Chromossome(Random random) {
        this.chromossome[0] = Utils.ceilBy3(random.nextDouble());
        this.chromossome[1] = Utils.ceilBy3(random.nextDouble());
    }

    /**
     * Metodo responsavel por retornar o vetor do cromossomo
     * @return Vetor do cromossomo
     */
    public double[] getChromossome() {
        return this.chromossome;
    }

    /**
     * Metodo responsavel por retornar o valor de fitness
     * @return Valor de fitness
     */
    public double getFitness() {
        return this.fitness;
    }

    /**
     * Metodo responsavel por atualizar o valor de fitness
     * @param fitness Novo valor de fitness
     */
    public void setFitness(double fitness) {
        this.fitness = Utils.ceilBy3(fitness);
    }

    /**
     * Metodo responsavel por aplicar a mutacao em um slot do cromossomo
     * @param index Indice do slot do cromossomo
     * @param value Multiplicador de mutacao
     */
    public void mutate(int index, double value) {
        this.chromossome[index] = Utils.ceilBy3(this.chromossome[index] * value);
    }

    /**
     * Metodo responsavel por substituir um slot do cromossomo
     * @param index Indice do slot do cromossomo
     * @param value Novo valor do slot
     */
    public void replace(int index, double value) {
        this.chromossome[index] = value;
    }

    /**
     * Metodo responsavel por cruzar este cromossomo com outro
     * @param random Classe de aleatoriedade do Java
     * @param otherChromossome O cromossomo do cruzamento
     * @return Novo cromossomo resultante da juncao dos anteriores
     */
    public Chromossome cross(Random random, Chromossome otherChromossome) {
        double value;

        Chromossome newChromossome = new Chromossome(random);
        for(int index = 0; index < this.chromossome.length; index++) {
            value = (random.nextBoolean()? this.chromossome[index] : otherChromossome.getChromossome()[index]);
            newChromossome.replace(index, value);
        }

        return newChromossome;
    }

    /**
     * Metodo responsavel por transformar o chromossomo em uma string
     * @return String do chromossomo
     */
    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append(this.fitness).append(";");
        for (double v : this.chromossome) {
            builder.append(v).append(";");
        }
        int lastComma = builder.toString().lastIndexOf(";");
        return builder.substring(0, lastComma - 1);
    }
}
