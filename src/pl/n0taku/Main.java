package pl.n0taku;

import java.util.concurrent.Callable;

public class Main {

    public static void main(String[] args) {

        Cube cube = new Cube();
        cube.print();

        System.out.println("Scramble: D2 B F2 L2 R' D' U2 F2 D' U");
        cube.move("D2 B F2 L2 R' D' U2 F2 D' U");
        cube.print();

//        CFOPSolver solver = new CFOPSolver(cube);
//        System.out.println(solver.doWhiteCross());
//        solver.printSolve();


    }
}
