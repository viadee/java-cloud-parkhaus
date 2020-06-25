package de.viadee.parkhaus.manager.config;


import io.quarkus.arc.config.ConfigProperties;

@ConfigProperties(prefix = "parkhaus")
public class ParkhausConfig {

   private double gebuehr;

   private long toleranceBtwPaymentAndExit;

   public ParkhausConfig() {
   }

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
