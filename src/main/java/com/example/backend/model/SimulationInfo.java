package com.example.backend.model;

/**
 * Classe de dados das informacoes da simulacao
 * @param seed Semente de geracao
 * @param currentRound Rodada atual
 * @param maxPopulation Populacao maxima da simulacao
 * @param mutationRate Taxade mutacao
 */
public record SimulationInfo(long seed, int currentRound, int maxPopulation, int mutationRate) {}
