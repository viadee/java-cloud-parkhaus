package de.viadee.parkhaus.manager.provider;

import javax.ws.rs.ext.ParamConverter;
import javax.ws.rs.ext.ParamConverterProvider;
import javax.ws.rs.ext.Provider;
import java.lang.annotation.Annotation;
import java.lang.reflect.Type;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Provider
public class LocalDateTimeParamConverterProvider implements ParamConverterProvider {

  @SuppressWarnings("unchecked")
  @Override
  public <T> ParamConverter<T> getConverter(Class<T> rawType, Type genericType, Annotation[] annotations) {
    if (rawType.equals(LocalDateTime.class)) {
      return (ParamConverter<T>) LocalDateTimeParamConverter.INSTANCE;
    }

    return null;
  }

  private static enum LocalDateTimeParamConverter implements ParamConverter<LocalDateTime> {
    INSTANCE;

    @Override
    public LocalDateTime fromString(String value) {
      return value != null ? LocalDateTime.parse(value, DateTimeFormatter.ISO_DATE_TIME) : null;
    }

    @Override
    public String toString(LocalDateTime value) {
      return value != null ? value.format(DateTimeFormatter.ISO_DATE_TIME) : null;
    }

  }
}
