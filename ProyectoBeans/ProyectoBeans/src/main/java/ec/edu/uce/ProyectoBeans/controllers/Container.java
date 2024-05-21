package ec.edu.uce.ProyectoBeans.controllers;

import ec.edu.uce.ProyectoBeans.models.Enemy;
import ec.edu.uce.ProyectoBeans.models.Hero;
import ec.edu.uce.ProyectoBeans.models.IDrawable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;

@Controller
public class Container {
    //@Autowired
//    @Autowired
//    //Hero hero;
//    IDrawable hero;
//    @Autowired
//    //Enemy enemy;
//    IDrawable enemy;
    //@Autowired
    /*public Container(Hero hero, Enemy enemy){
    this.hero = hero;
    this.enemy = enemy;
}*/

    @Autowired
    IDrawable hero;

    @Autowired
    IDrawable enemy;

    public Container(){

    }
public void draw(){
    System.out.println("Aqui inicio al dibujar en el container....");
    this.hero.draw();
    this.enemy.draw();

}
// o usar el @Autowired en los setters de los objetos
}
