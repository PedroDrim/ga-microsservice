package org.springframework.boot.autoconfigure.web.embedded;

import org.springframework.aot.generate.Generated;
import org.springframework.beans.factory.aot.BeanInstanceSupplier;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.RootBeanDefinition;
import org.springframework.boot.autoconfigure.web.ServerProperties;
import org.springframework.core.env.Environment;

/**
 * Bean definitions for {@link EmbeddedWebServerFactoryCustomizerAutoConfiguration}.
 */
@Generated
public class EmbeddedWebServerFactoryCustomizerAutoConfiguration__BeanDefinitions {
  /**
   * Get the bean definition for 'embeddedWebServerFactoryCustomizerAutoConfiguration'.
   */
  public static BeanDefinition getEmbeddedWebServerFactoryCustomizerAutoConfigurationBeanDefinition(
      ) {
    RootBeanDefinition beanDefinition = new RootBeanDefinition(EmbeddedWebServerFactoryCustomizerAutoConfiguration.class);
    beanDefinition.setInstanceSupplier(EmbeddedWebServerFactoryCustomizerAutoConfiguration::new);
    return beanDefinition;
  }

  /**
   * Bean definitions for {@link EmbeddedWebServerFactoryCustomizerAutoConfiguration.UndertowWebServerFactoryCustomizerConfiguration}.
   */
  @Generated
  public static class UndertowWebServerFactoryCustomizerConfiguration {
    /**
     * Get the bean definition for 'undertowWebServerFactoryCustomizerConfiguration'.
     */
    public static BeanDefinition getUndertowWebServerFactoryCustomizerConfigurationBeanDefinition(
        ) {
      RootBeanDefinition beanDefinition = new RootBeanDefinition(EmbeddedWebServerFactoryCustomizerAutoConfiguration.UndertowWebServerFactoryCustomizerConfiguration.class);
      beanDefinition.setInstanceSupplier(EmbeddedWebServerFactoryCustomizerAutoConfiguration.UndertowWebServerFactoryCustomizerConfiguration::new);
      return beanDefinition;
    }

    /**
     * Get the bean instance supplier for 'undertowWebServerFactoryCustomizer'.
     */
    private static BeanInstanceSupplier<UndertowWebServerFactoryCustomizer> getUndertowWebServerFactoryCustomizerInstanceSupplier(
        ) {
      return BeanInstanceSupplier.<UndertowWebServerFactoryCustomizer>forFactoryMethod(EmbeddedWebServerFactoryCustomizerAutoConfiguration.UndertowWebServerFactoryCustomizerConfiguration.class, "undertowWebServerFactoryCustomizer", Environment.class, ServerProperties.class)
              .withGenerator((registeredBean, args) -> registeredBean.getBeanFactory().getBean("org.springframework.boot.autoconfigure.web.embedded.EmbeddedWebServerFactoryCustomizerAutoConfiguration$UndertowWebServerFactoryCustomizerConfiguration", EmbeddedWebServerFactoryCustomizerAutoConfiguration.UndertowWebServerFactoryCustomizerConfiguration.class).undertowWebServerFactoryCustomizer(args.get(0), args.get(1)));
    }

    /**
     * Get the bean definition for 'undertowWebServerFactoryCustomizer'.
     */
    public static BeanDefinition getUndertowWebServerFactoryCustomizerBeanDefinition() {
      RootBeanDefinition beanDefinition = new RootBeanDefinition(UndertowWebServerFactoryCustomizer.class);
      beanDefinition.setFactoryBeanName("org.springframework.boot.autoconfigure.web.embedded.EmbeddedWebServerFactoryCustomizerAutoConfiguration$UndertowWebServerFactoryCustomizerConfiguration");
      beanDefinition.setInstanceSupplier(getUndertowWebServerFactoryCustomizerInstanceSupplier());
      return beanDefinition;
    }
  }
}
