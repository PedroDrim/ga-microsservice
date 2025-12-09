package com.example.backend;

import org.springframework.aot.generate.Generated;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.RootBeanDefinition;
import org.springframework.context.annotation.ConfigurationClassUtils;

/**
 * Bean definitions for {@link GaBackendApplication}.
 */
@Generated
public class GaBackendApplication__BeanDefinitions {
  /**
   * Get the bean definition for 'gaBackendApplication'.
   */
  public static BeanDefinition getGaBackendApplicationBeanDefinition() {
    RootBeanDefinition beanDefinition = new RootBeanDefinition(GaBackendApplication.class);
    beanDefinition.setTargetType(GaBackendApplication.class);
    ConfigurationClassUtils.initializeConfigurationClass(GaBackendApplication.class);
    beanDefinition.setInstanceSupplier(GaBackendApplication$$SpringCGLIB$$0::new);
    return beanDefinition;
  }
}
