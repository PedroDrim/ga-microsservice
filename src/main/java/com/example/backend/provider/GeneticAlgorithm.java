package com.example.backend.provider;

import com.example.backend.model.Chromossome;
import com.example.backend.model.SimulationInfo;

import java.util.Arrays;
import java.util.Random;
import java.util.stream.Stream;

/**
 * Classe responsavel pelo funcionamento do Algoritmo Genetico
 */
public class GeneticAlgorithm {

    /**
     * Classe de aleatoriedade do Java
     */
    private final Random random;

    /**
     * Semente de geracao
     */
    private final long seed;

    /**
     * Tamanho maximo da populaaco
     */
    private final int maxPopulation;

    /**
     * Taxa de mutacao (20 --> 20%)
     */
    private final int mutationRate;

    /**
     * Geracao atual
     */
    private int currentGeneration = 0;

    /**
     * Corte de individuos para a proxima geracao
     */
    private int top = 0;

    /**
     * Construtor publico da classe com semente fixa
     * @param seed Semente de geracao
     * @param maxPopulation Tamanho maximo da populacao
     * @param mutationRate Taxa de mutacao
     */
    public GeneticAlgorithm(long seed, int maxPopulation, int mutationRate) {
        this.seed = seed;
        this.random = new Random(seed);
        this.maxPopulation = Math.max(10, maxPopulation);
        this.mutationRate = Math.clamp(mutationRate, 10, 100);
    }

    /**
     * Construtor publico da classe com semente aleatoria
     * @param maxPopulation Tamanho maximo da populacao
     * @param mutationRate Taxa de mutacao
     */
    public GeneticAlgorithm(int maxPopulation, int mutationRate) {
        this.random = new Random();
        this.seed = this.random.nextLong();
        this.random.setSeed(this.seed);
        this.maxPopulation = Math.max(10, maxPopulation);
        this.mutationRate = Math.clamp(mutationRate, 10, 100);
    }

    /**
     * Metodo responsavel por iniciar a primeira geracao da simulacao
     * @param top Ponto de corte da populacao
     * @return Primeira geracao
     */
    public Chromossome[] startSimulation(int top) {
        this.top = top;
        this.currentGeneration++;
        return this.generateInitialPopulation();
    }

    /**
     * Metodo responsavel por iniciar a proxima geracao da simulacao
     * @param survivors Sobreviventes (top) da rodada anterior
     * @return Nova geracao
     */
    public Chromossome[] nextRound(Chromossome[] survivors) {
        Chromossome[] topPopulation = this.filterByFitness(survivors);
        Chromossome[] newPopulation = this.crossBreeding(this.top, topPopulation);
        this.mutatePopulation(newPopulation);

        this.currentGeneration++;
        return newPopulation;
    }

    /**
     * Metodo responsavel por obter as informacoes da simulacao
     * @return Informacoes da simulaca
     */
    public SimulationInfo getInfo() {
        return new SimulationInfo(this.seed, this.currentGeneration, this.maxPopulation, this.mutationRate);
    }

    /**
     * Metodo responsavel por gerar a populacao inicial
     * @return Populacao inicial
     */
    private Chromossome[] generateInitialPopulation() {
        Chromossome[] littleGuysPopulation = new Chromossome[maxPopulation];

        for(int index = 0; index < this.maxPopulation; index++) {
            littleGuysPopulation[index] = new Chromossome(random);
        }

        return littleGuysPopulation;
    }

    /**
     * Metodo responsavel por aplicar mutacao na populacao
     * @param littleGuysPopulationRef Referencia da populacao
     */
    private void mutatePopulation(Chromossome[] littleGuysPopulationRef) {
        int chromossomeSize = littleGuysPopulationRef[0].getChromossome().length;

        for(int index = 0; index < this.maxPopulation; index++) {
            double mutationChance = this.random.nextInt(100);
            if(this.mutationRate > mutationChance) {
                int randomSlot = this.random.nextInt(chromossomeSize);
                double factor = 1.0 + ((this.random.nextDouble() * 2) - 1) * 0.1;
                littleGuysPopulationRef[index].mutate(randomSlot, factor);
            }
        }
    }

    /**
     * Metodo responsavel por filtrar os cromossomos por fitness
     * @param littleGuysPopulation Populacao da rodada
     * @return Populacao ordenada por fitness
     */
    private Chromossome[] filterByFitness(Chromossome[] littleGuysPopulation) {
        Stream<Chromossome> sorted = Arrays.stream(littleGuysPopulation).sorted(new ChromossomeSorter());
        return sorted.toArray(Chromossome[]::new);
    }

    /**
     * Metodo responsavel por realizar o cruzamento da populacao
     * @param top Ponto de corte da populacao
     * @param littleGuysPopulation Populacao da rodada
     * @return Nova populacao cruzada
     */
    private Chromossome[] crossBreeding(int top, Chromossome[] littleGuysPopulation) {
        int randomC1, randomC2;
        Chromossome[] newPopulation = new Chromossome[this.maxPopulation];

        for(int index = 0; index < this.maxPopulation; index++) {
            randomC1 = this.random.nextInt(top);
            randomC2 = this.random.nextInt(top);

            newPopulation[index] = littleGuysPopulation[randomC1].cross(this.random, littleGuysPopulation[randomC2]);
        }
        return newPopulation;
    }
}
