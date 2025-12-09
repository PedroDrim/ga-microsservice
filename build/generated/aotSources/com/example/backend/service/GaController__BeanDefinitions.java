package com.example.backend.service;

import org.springframework.aot.generate.Generated;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.RootBeanDefinition;

/**
 * Bean definitions for {@link GaController}.
 */
@Generated
public class GaController__BeanDefinitions {
  /**
   * Get the bean definition for 'gaController'.
   */
  public static BeanDefinition getGaControllerBeanDefinition() {
    RootBeanDefinition beanDefinition = new RootBeanDefinition(GaController.class);
    beanDefinition.setInstanceSupplier(GaController::new);
    return beanDefinition;
  }
}
