package com.example.backend;

import com.example.GeneticAlgorithmDocker.GeneticAlgorithmDockerApplication$$SpringCGLIB$$0;
import org.springframework.aot.generate.Generated;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.RootBeanDefinition;
import org.springframework.context.annotation.ConfigurationClassUtils;

/**
 * Bean definitions for {@link GeneticAlgorithmDockerApplication}.
 */
@Generated
public class GeneticAlgorithmDockerApplication__TestContext001_BeanDefinitions {
  /**
   * Get the bean definition for 'geneticAlgorithmDockerApplication'.
   */
  public static BeanDefinition getGeneticAlgorithmDockerApplicationBeanDefinition() {
    RootBeanDefinition beanDefinition = new RootBeanDefinition(GeneticAlgorithmDockerApplication.class);
    beanDefinition.setTargetType(GeneticAlgorithmDockerApplication.class);
    ConfigurationClassUtils.initializeConfigurationClass(GeneticAlgorithmDockerApplication.class);
    beanDefinition.setInstanceSupplier(GeneticAlgorithmDockerApplication$$SpringCGLIB$$0::new);
    return beanDefinition;
  }
}
