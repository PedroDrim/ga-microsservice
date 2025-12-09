package com.example.backend.service;

import com.example.backend.model.Chromossome;
import com.example.backend.model.SimpleChromossome;
import com.example.backend.model.SimulationInfo;
import com.example.backend.provider.GeneticAlgorithm;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.*;
import java.util.stream.Stream;

/**
 * Service responsavel por gerenciar as rotas de um GA
 */
@RestController
public class GaController {

    /**
     * Tamanho maximo da populacao (10 - N)
     */
    private final int defaultMaxPopulation = 100;

    /**
     * Taxa de mutacao (0 - 100)
     */
    private final int defaultMutationRate = 30;

    /**
     * Instancia do algoritmo genetico
     */
    private GeneticAlgorithm geneticAlgorithm = new GeneticAlgorithm(this.defaultMaxPopulation, this.defaultMutationRate);

    /**
     * Mapa de cromossomos por rodada
     */
    private final Map<Integer, Chromossome[]> populationMap = new HashMap<>();

    /**
     * Metodo http GET /
     * Responsavel por exibir as informacoes da simulacao
     * @throws RuntimeException Excessao de request
     * @return Informacoes da simulacao
     */
    @GetMapping("/")
    public SimulationInfo getInfo() throws RuntimeException {
        return this.geneticAlgorithm.getInfo();
    }

    /**
     * Metodo http GET /report
     * Responsavel por gerar um relatorio .csv de uma rodada
     * @param round Rodada a ser obtida
     * @throws RuntimeException Excessao de request
     * @return Valores da rodada no formato .csv
     */
    @GetMapping(value = "/report", produces = MediaType.TEXT_PLAIN_VALUE)
    public ResponseEntity<String> getReport(@RequestParam int round) throws RuntimeException {
        if(this.populationMap.containsKey(round)) {
            Chromossome[] population = this.populationMap.get(round);
            StringBuilder builder = new StringBuilder();
            for(int index = 0; index < population.length; index++) {
                builder.append(round).append(";").append(index).append(";").append(population[index].toString()).append("\n");
            }

            return new ResponseEntity<>(builder.toString(), HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }


    /**
     * Metodo http POST /
     * Responsavel por inserir as informacoes da simulacao, iniciando-a
     * @throws RuntimeException Excessao de request
     */
    @PostMapping("/")
    public ResponseEntity<Void> postInfo(@Validated @RequestBody SimulationInfo simulationInfo) throws  RuntimeException {
        if (this.geneticAlgorithm.getInfo().currentRound() == 0) {
            this.geneticAlgorithm = new GeneticAlgorithm(simulationInfo.seed(), simulationInfo.maxPopulation(), simulationInfo.mutationRate());
            return new ResponseEntity<>(HttpStatus.CREATED);
        }

        return new ResponseEntity<>(HttpStatus.CONFLICT);
    }

    /**
     * Metodo http GET /next
     * Responsavel por simular a proxima geracao
     * @throws RuntimeException Excessao de request
     * @return Lista de cromossomos simplificados
     */
    @GetMapping("/next")
    public Stream<SimpleChromossome> getNext() throws RuntimeException {
        int maxPopulation = this.geneticAlgorithm.getInfo().maxPopulation();
        int currentRound = this.geneticAlgorithm.getInfo().currentRound();
        Chromossome[] population = new Chromossome[maxPopulation];

        if (currentRound == 0) {
            int top20 = (int) Math.ceil(maxPopulation * .2);
            population = this.geneticAlgorithm.startSimulation(top20);
        } else {
            Chromossome[] previousPopulation = this.populationMap.get(currentRound - 1);
            population = this.geneticAlgorithm.nextRound(previousPopulation);
        }

        this.populationMap.put(currentRound, population);
        return Arrays.stream(population).map((Chromossome value) -> new SimpleChromossome(value.getChromossome()));
    }

    /**
     * Metodo http POST /fitness
     * Responsavel por analisar os fitness da rodada
     * @param roundFitness Vetor de fitness da rodada
     * @throws RuntimeException Excessao de request
     */
    @PostMapping("/fitness")
    public void postFitness(@RequestBody double[] roundFitness) throws RuntimeException {
        int currentRound = this.geneticAlgorithm.getInfo().currentRound();
        if(currentRound == 0) return;

        int maxPopulation = this.geneticAlgorithm.getInfo().maxPopulation();
        int minSize = Math.min(roundFitness.length, maxPopulation);

        Chromossome[] chromossome = this.populationMap.get(currentRound - 1);
        for(int index = 0; index < minSize; index++) {
            chromossome[index].setFitness(roundFitness[index]);
        }
        this.populationMap.put(currentRound - 1, chromossome);
    }

    /**
     * Metodo http DELETE /
     * Responsavel por limpar o historico de rodadas
     * @throws RuntimeException Excessao de request
     */
    @DeleteMapping("/")
    public void deleteInfo() throws RuntimeException {
        this.geneticAlgorithm = new GeneticAlgorithm(this.defaultMaxPopulation, this.defaultMutationRate);
        this.populationMap.clear();
    }
}