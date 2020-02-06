package pl.n0taku;

public class Main {

    public static void main(String[] args) {

        Cube cube = new Cube();
        //cube.print();
        cube.move("D' U F D2 U2 L' D L' D' L2 R2 D U2 L D2");

        cube.print();
    }
}
