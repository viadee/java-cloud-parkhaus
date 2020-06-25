package de.viadee.parkhaus.manager.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration(proxyBeanMethods = false)
@EnableConfigurationProperties
@ConfigurationProperties("parkhaus")
public class ParkhausConfig {

   private double gebuehr;

   private long toleranceBtwPaymentAndExit;

   public double getGebuehr() {
      return gebuehr;
   }

   public void setGebuehr(double gebuehr) {
      this.gebuehr = gebuehr;
   }

   public long getToleranceBtwPaymentAndExit() {
      return toleranceBtwPaymentAndExit;
   }

   public void setToleranceBtwPaymentAndExit(long toleranceBtwPaymentAndExit) {
      this.toleranceBtwPaymentAndExit = toleranceBtwPaymentAndExit;
   }
}
