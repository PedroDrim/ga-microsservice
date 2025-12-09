package org.springframework.boot.autoconfigure.websocket.servlet;

import org.springframework.aot.generate.Generated;
import org.springframework.beans.factory.aot.BeanInstanceSupplier;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.RootBeanDefinition;

/**
 * Bean definitions for {@link WebSocketServletAutoConfiguration}.
 */
@Generated
public class WebSocketServletAutoConfiguration__BeanDefinitions {
  /**
   * Get the bean definition for 'webSocketServletAutoConfiguration'.
   */
  public static BeanDefinition getWebSocketServletAutoConfigurationBeanDefinition() {
    RootBeanDefinition beanDefinition = new RootBeanDefinition(WebSocketServletAutoConfiguration.class);
    beanDefinition.setInstanceSupplier(WebSocketServletAutoConfiguration::new);
    return beanDefinition;
  }

  /**
   * Bean definitions for {@link WebSocketServletAutoConfiguration.UndertowWebSocketConfiguration}.
   */
  @Generated
  public static class UndertowWebSocketConfiguration {
    /**
     * Get the bean definition for 'undertowWebSocketConfiguration'.
     */
    public static BeanDefinition getUndertowWebSocketConfigurationBeanDefinition() {
      RootBeanDefinition beanDefinition = new RootBeanDefinition(WebSocketServletAutoConfiguration.UndertowWebSocketConfiguration.class);
      beanDefinition.setInstanceSupplier(WebSocketServletAutoConfiguration.UndertowWebSocketConfiguration::new);
      return beanDefinition;
    }

    /**
     * Get the bean instance supplier for 'websocketServletWebServerCustomizer'.
     */
    private static BeanInstanceSupplier<UndertowWebSocketServletWebServerCustomizer> getWebsocketServletWebServerCustomizerInstanceSupplier(
        ) {
      return BeanInstanceSupplier.<UndertowWebSocketServletWebServerCustomizer>forFactoryMethod(WebSocketServletAutoConfiguration.UndertowWebSocketConfiguration.class, "websocketServletWebServerCustomizer")
              .withGenerator((registeredBean) -> registeredBean.getBeanFactory().getBean("org.springframework.boot.autoconfigure.websocket.servlet.WebSocketServletAutoConfiguration$UndertowWebSocketConfiguration", WebSocketServletAutoConfiguration.UndertowWebSocketConfiguration.class).websocketServletWebServerCustomizer());
    }

    /**
     * Get the bean definition for 'websocketServletWebServerCustomizer'.
     */
    public static BeanDefinition getWebsocketServletWebServerCustomizerBeanDefinition() {
      RootBeanDefinition beanDefinition = new RootBeanDefinition(UndertowWebSocketServletWebServerCustomizer.class);
      beanDefinition.setFactoryBeanName("org.springframework.boot.autoconfigure.websocket.servlet.WebSocketServletAutoConfiguration$UndertowWebSocketConfiguration");
      beanDefinition.setInstanceSupplier(getWebsocketServletWebServerCustomizerInstanceSupplier());
      return beanDefinition;
    }
  }
}
