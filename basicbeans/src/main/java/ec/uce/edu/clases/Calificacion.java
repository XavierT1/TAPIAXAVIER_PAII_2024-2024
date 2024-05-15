package ec.uce.edu.clases;

public class Calificacion {

    private String estudiante;
    private String curso;
    private double nota;

    public Calificacion(String estudiante, String curso, double nota) {
        this.estudiante = estudiante;
        this.curso = curso;
        this.nota = nota;
    }

    public Calificacion() {

    }
    public String getEstudiante() {
        return estudiante;
    }

    public void setEstudiante(String estudiante) {
        this.estudiante = estudiante;
    }

    public String getCurso() {
        return curso;
    }

    public void setCurso(String curso) {
        this.curso = curso;
    }

    public double getNota() {
        return nota;
    }

    public void setNota(double nota) {
        this.nota = nota;
    }

    @Override
    public String toString() {
        return "Calificacion{" +
                "estudiante=" + estudiante +
                ", curso=" + curso +
                ", nota=" + nota +
                '}';
    }
}
