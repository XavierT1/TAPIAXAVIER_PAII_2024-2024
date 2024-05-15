package ec.uce.edu.models;

public abstract class Role{


    //las variables deben ser private
    private int [] coordX;
    private int [] coordY;

    //Para que sea un bean debe tener un constructor por defecto
    public Role(){

    }
    public void Role(int size){
        this.coordX = new int[size];
        this.coordY = new int[size];
    }

    public Role(int[] coordX, int[] coordY) {
        this.coordX = coordX;
        this.coordY = coordY;
    }

    public int[] getCoordX() {
        return coordX;
    }

    public void setCoordX(int[] coordX) {
        this.coordX = coordX;
    }

    public int[] getCoordY() {
        return coordY;
    }

    public void setCoordY(int[] coordY) {
        this.coordY = coordY;
    }
}
