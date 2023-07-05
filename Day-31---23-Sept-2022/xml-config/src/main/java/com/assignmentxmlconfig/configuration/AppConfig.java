package com.assignmentxmlconfig.configuration;

import com.assignmentxmlconfig.Actor;
import com.assignmentxmlconfig.Movie;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

  Actor actor1;

  @Bean
  public Actor getActor() {
    actor1 = new Actor("Kritika", "Female", 21);
    return actor1;
  }

  @Bean
  public Movie getMovie() {
    return new Movie(actor1);
  }
}
