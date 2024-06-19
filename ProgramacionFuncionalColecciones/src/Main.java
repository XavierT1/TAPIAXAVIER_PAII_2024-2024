import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.stream.Collectors;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        //Declarar un array, no son dinamicos
    //    int[] myArray = new int [3];
    //    int [] myArray2 = new int [5];

     //   List<Integer> myList = new ArrayList<>();
     //   myList.add(1);
     //   myList.add(2);
     //   myList.add(3);


        //otro metodo para listas pero con list.of son inmutables
        List<Persona> myList = List.of(new Persona("Pepe",10),
        new Persona("luis",15),
        new Persona("Pedro",25),
        new Persona("Juan",12)
    );


        //Los objetos Stream
        //Crear nuevos objetos mediante Stream para poder manipularlos a la lista sobre el stream
        //Es un flujo de trabajo

        //Obtengo los datos directamente desde mi coleccion
        //myList.forEach(s -> System.out.println(s));

        //tengo un flujo de datos mediantre stream
        //forEach
        //myList.stream().forEach(s -> System.out.println(s));

        //Filter
        List<Persona>resultado = myList.stream().filter(persona -> persona.getEdad()>10 && persona.getNombre().startsWith("P"))
                .collect(Collectors.toList());

        for (Persona persona : resultado){
          System.out.println(persona.getNombre());
        }




        //1)
        //Recorrer una lista

        //for (int i=0;i<myList.size();i++){
        //System.out.println(myList.get(i));
        //}

        //2)
        //Con for mejorado

        //for (String nombre : myList){
        //  System.out.println(nombre);
        //}

        //3)
        //Consumer

        //myList.forEach(s -> System.out.println(s));


    }
}