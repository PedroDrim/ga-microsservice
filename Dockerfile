FROM gradle:jdk23-graal

WORKDIR /app
COPY ./ /app/

EXPOSE 8080

# Configurando proxy no gradle e executando build native
RUN ./gradlew nativeBuild

RUN mv build/native/nativeCompile/GeneticAlgorithmDocker .


RUN chmod +x GeneticAlgorithmDocker

# Ativando ponto de entrada
ENTRYPOINT ["./GeneticAlgorithmDocker"]

# sudo docker build -t ga .
# sudo docker run -d -p 8080:8080 ga


