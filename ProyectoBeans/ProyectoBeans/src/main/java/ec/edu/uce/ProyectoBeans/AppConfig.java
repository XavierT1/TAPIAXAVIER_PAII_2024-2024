package ec.edu.uce.ProyectoBeans;

import ec.edu.uce.ProyectoBeans.controllers.Container;
import ec.edu.uce.ProyectoBeans.models.Hero;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan("ec.edu.uce.ProyectoBeans.*")
public class AppConfig {

    @Bean
    public Hero hero (){
        return new Hero();
    }

    @Bean
    public Container container (){
        return new Container();
    }

}
