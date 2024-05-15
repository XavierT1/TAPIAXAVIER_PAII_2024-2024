package ec.uce.edu.clases;

public class Curso {
    private String nombre;
    private int creditos;
    private String departamento;

    public Curso(String nombre, int creditos, String departamento) {
        this.nombre = nombre;
        this.creditos = creditos;
        this.departamento = departamento;
    }

    public Curso (){

    }
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getCreditos() {
        return creditos;
    }

    public void setCreditos(int creditos) {
        this.creditos = creditos;
    }

    public String getDepartamento() {
        return departamento;
    }

    public void setDepartamento(String departamento) {
        this.departamento = departamento;
    }

    @Override
    public String toString() {
        return "Curso{" +
                "nombre='" + nombre + '\'' +
                ", creditos=" + creditos +
                ", departamento='" + departamento + '\'' +
                '}';
    }
}
