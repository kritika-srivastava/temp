package com.assignmentxmlconfig;

import com.assignmentxmlconfig.configuration.AppConfig;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class App {

  public static void main(String[] args) {
    ApplicationContext app = new AnnotationConfigApplicationContext(
      AppConfig.class
    );

    Actor a1 = app.getBean(Actor.class);
    System.out.println(a1.toString());

    Movie m1 = app.getBean(Movie.class);
    System.out.println(m1.toString());
    
    //((AnnotationConfigApplicationContext) app).close();
  }
}
