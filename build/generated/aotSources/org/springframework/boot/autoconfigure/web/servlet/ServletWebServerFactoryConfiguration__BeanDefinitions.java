package org.springframework.boot.autoconfigure.web.servlet;

import org.springframework.aot.generate.Generated;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.beans.factory.aot.BeanInstanceSupplier;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.RootBeanDefinition;
import org.springframework.boot.autoconfigure.web.ServerProperties;
import org.springframework.boot.web.embedded.undertow.UndertowServletWebServerFactory;

/**
 * Bean definitions for {@link ServletWebServerFactoryConfiguration}.
 */
@Generated
public class ServletWebServerFactoryConfiguration__BeanDefinitions {
  /**
   * Bean definitions for {@link ServletWebServerFactoryConfiguration.EmbeddedUndertow}.
   */
  @Generated
  public static class EmbeddedUndertow {
    /**
     * Get the bean definition for 'embeddedUndertow'.
     */
    public static BeanDefinition getEmbeddedUndertowBeanDefinition() {
      RootBeanDefinition beanDefinition = new RootBeanDefinition(ServletWebServerFactoryConfiguration.EmbeddedUndertow.class);
      beanDefinition.setInstanceSupplier(ServletWebServerFactoryConfiguration.EmbeddedUndertow::new);
      return beanDefinition;
    }

    /**
     * Get the bean instance supplier for 'undertowServletWebServerFactory'.
     */
    private static BeanInstanceSupplier<UndertowServletWebServerFactory> getUndertowServletWebServerFactoryInstanceSupplier(
        ) {
      return BeanInstanceSupplier.<UndertowServletWebServerFactory>forFactoryMethod(ServletWebServerFactoryConfiguration.EmbeddedUndertow.class, "undertowServletWebServerFactory", ObjectProvider.class, ObjectProvider.class)
              .withGenerator((registeredBean, args) -> registeredBean.getBeanFactory().getBean("org.springframework.boot.autoconfigure.web.servlet.ServletWebServerFactoryConfiguration$EmbeddedUndertow", ServletWebServerFactoryConfiguration.EmbeddedUndertow.class).undertowServletWebServerFactory(args.get(0), args.get(1)));
    }

    /**
     * Get the bean definition for 'undertowServletWebServerFactory'.
     */
    public static BeanDefinition getUndertowServletWebServerFactoryBeanDefinition() {
      RootBeanDefinition beanDefinition = new RootBeanDefinition(UndertowServletWebServerFactory.class);
      beanDefinition.setFactoryBeanName("org.springframework.boot.autoconfigure.web.servlet.ServletWebServerFactoryConfiguration$EmbeddedUndertow");
      beanDefinition.setInstanceSupplier(getUndertowServletWebServerFactoryInstanceSupplier());
      return beanDefinition;
    }

    /**
     * Get the bean instance supplier for 'undertowServletWebServerFactoryCustomizer'.
     */
    private static BeanInstanceSupplier<UndertowServletWebServerFactoryCustomizer> getUndertowServletWebServerFactoryCustomizerInstanceSupplier(
        ) {
      return BeanInstanceSupplier.<UndertowServletWebServerFactoryCustomizer>forFactoryMethod(ServletWebServerFactoryConfiguration.EmbeddedUndertow.class, "undertowServletWebServerFactoryCustomizer", ServerProperties.class)
              .withGenerator((registeredBean, args) -> registeredBean.getBeanFactory().getBean("org.springframework.boot.autoconfigure.web.servlet.ServletWebServerFactoryConfiguration$EmbeddedUndertow", ServletWebServerFactoryConfiguration.EmbeddedUndertow.class).undertowServletWebServerFactoryCustomizer(args.get(0)));
    }

    /**
     * Get the bean definition for 'undertowServletWebServerFactoryCustomizer'.
     */
    public static BeanDefinition getUndertowServletWebServerFactoryCustomizerBeanDefinition() {
      RootBeanDefinition beanDefinition = new RootBeanDefinition(UndertowServletWebServerFactoryCustomizer.class);
      beanDefinition.setFactoryBeanName("org.springframework.boot.autoconfigure.web.servlet.ServletWebServerFactoryConfiguration$EmbeddedUndertow");
      beanDefinition.setInstanceSupplier(getUndertowServletWebServerFactoryCustomizerInstanceSupplier());
      return beanDefinition;
    }
  }
}
