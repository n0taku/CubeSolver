package pl.n0taku;

public class CFOPSolver {
    private Cube cube;
    private Cube.Face yellow;
    private Cube.Face white;
    private Cube.Face blue;
    private Cube.Face red;
    private Cube.Face green;
    private Cube.Face orange;
    String solve;

    CFOPSolver(Cube cube){
        this.cube = cube;
        yellow  = cube.face.get(0);
        white  = cube.face.get(5);
        blue  = cube.face.get(1);
        red  = cube.face.get(2);
        green  = cube.face.get(3);
        orange  = cube.face.get(4);
        solve="";
    }
    public void move(String move){
        cube.move(move);
        solve+=move+" ";
    }

    public boolean checkWhiteCross(){
        if(white.getCublet(1,0)== Cube.Color.WHITE&&
           white.getCublet(2,1)== Cube.Color.WHITE&&
           white.getCublet(1,2)== Cube.Color.WHITE&&
           white.getCublet(0,1)== Cube.Color.WHITE){
            return true;
        }
        return false;
    }
    public boolean doWhiteCross(){
        if(checkWhiteCross()){
            return true;
        }
        if(yellow.getCublet(1,0)== Cube.Color.WHITE) {
            switch (orange.getCublet(1, 0)) {
                case ORANGE:
                    move("B2");
                    return doWhiteCross();
                case RED:
                    move("U2 F2");
                    return doWhiteCross();
                case GREEN:
                    move("U R2");
                    return doWhiteCross();
                case BLUE:
                    move("U' L2");
                    return doWhiteCross();
            }
        }
        if(yellow.getCublet(2,1)== Cube.Color.WHITE) {
            switch (green.getCublet(1, 0)) {
                case GREEN:
                    move("R2");
                    return doWhiteCross();
                case RED:
                    move("U F2");
                    return doWhiteCross();
                case ORANGE:
                    move("U' R2");
                    return doWhiteCross();
                case BLUE:
                    cube.move("U2 L2");
                    return doWhiteCross();
            }
        }
        if(yellow.getCublet(1,2)== Cube.Color.WHITE) {
            switch (red.getCublet(1, 0)) {
                case ORANGE:
                    move("U2 B2");
                    return doWhiteCross();
                case RED:
                    cube.move("F2");
                    return doWhiteCross();
                case GREEN:
                    cube.move("U' R2");
                    return doWhiteCross();
                case BLUE:
                    move("U L2");
                    return doWhiteCross();
            }
        }
        if(yellow.getCublet(0,1)== Cube.Color.WHITE) {
            switch (blue.getCublet(1, 0)) {
                case ORANGE:
                    move("U B2");
                    return doWhiteCross();
                case RED:
                    move("U' F2");
                    return doWhiteCross();
                case GREEN:
                    move("U2 R2");
                    return doWhiteCross();
                case BLUE:
                    move("L2");
                    return doWhiteCross();
            }
        }
        if(blue.getCublet(1,0)== Cube.Color.WHITE) {
            switch (yellow.getCublet(0, 1)) {
                case ORANGE:
                    move("L' B");
                    if (red.getCublet(0,1)== Cube.Color.WHITE)
                        move("L");
                    return doWhiteCross();
                case RED:
                    move("L F'");
                    if (orange.getCublet(2,1)== Cube.Color.WHITE)
                        move("L'");
                    return doWhiteCross();
                case GREEN:
                    move("U F R'");
                    if (blue.getCublet(2,1)== Cube.Color.WHITE)
                        move("F'");
                    return doWhiteCross();
                case BLUE:
                    move("U' F' L");
                    if (green.getCublet(0,1)== Cube.Color.WHITE)
                        move("L'");
                    return doWhiteCross();
            }
        }
        if(blue.getCublet(2,1)== Cube.Color.WHITE) {
            switch (red.getCublet(0, 1)) {
                case ORANGE:
                    move("L2 B");
                    if (yellow.getCublet(0,1)== Cube.Color.WHITE)
                        move("L2");
                    return doWhiteCross();
                case RED:
                    move("F'");
                    return doWhiteCross();
                case GREEN:
                    move("D' F' D");
                    if (blue.getCublet(2,1)== Cube.Color.WHITE)
                        move("F'");
                    return doWhiteCross();
                case BLUE:
                    move("D F' D'");
                    return doWhiteCross();
            }
        }
        if(blue.getCublet(1,2)== Cube.Color.WHITE) {
            if(white.getCublet(1,0)== Cube.Color.ORANGE)
                move("L");
            else
                move("L'");
            doWhiteCross();
        }
        if(blue.getCublet(0,1)== Cube.Color.WHITE) {
            switch (orange.getCublet(2, 1)) {
                case ORANGE:
                    move("B");
                    return doWhiteCross();
                case RED:
                    move("L2 F");
                    if (yellow.getCublet(0,1)== Cube.Color.WHITE)
                        move("L2");
                    return doWhiteCross();
                case GREEN:
                    move("D B D'");
                    if (blue.getCublet(2,1)== Cube.Color.WHITE)
                        move("F'");
                    return doWhiteCross();
                case BLUE:
                    move("D' B D");
                    return doWhiteCross();
            }
        }
        if(red.getCublet(1,0)== Cube.Color.WHITE) {
            switch (yellow.getCublet(1, 2)) {
                case ORANGE:
                    move("U R B'");
                    if (red.getCublet(2,1)== Cube.Color.WHITE)
                        move("R'");
                    return doWhiteCross();
                case RED:
                    move("F' D' L D'");
                    return doWhiteCross();
                case GREEN:
                    move("F R'");
                    if (blue.getCublet(2,1)== Cube.Color.WHITE)
                        move("F'");
                    return doWhiteCross();
                case BLUE:
                    move("F' L");
                    if (green.getCublet(0,1)== Cube.Color.WHITE)
                        move("F");
                    return doWhiteCross();
            }
        }
        if(red.getCublet(2,1)== Cube.Color.WHITE) {
            switch (green.getCublet(0, 1)) {
                case ORANGE:
                    move("D' R' D");
                    
                case RED:
                    move("F'");
                    move("D R' D'");
                    return doWhiteCross();
                case GREEN:
                    move("R'");
                    return doWhiteCross();
                case BLUE:
                    move("F2 L");
                    if (yellow.getCublet(1,2)== Cube.Color.WHITE)
                        move("F2");
                    return doWhiteCross();
            }
        }
        if(red.getCublet(1,2)== Cube.Color.WHITE) {
            if(white.getCublet(1, 0)== Cube.Color.BLUE)
                move("F");
            else
                move("F'");
            return doWhiteCross();
        }
        if(red.getCublet(0,1)== Cube.Color.WHITE) {
            switch (orange.getCublet(2, 1)) {
                case ORANGE:
                    move("D L D'");
                    return doWhiteCross();
                case RED:
                    move("D' L D");
                    if (yellow.getCublet(0,1)== Cube.Color.WHITE)
                        move("L2");
                    return doWhiteCross();
                case GREEN:
                    move("F2 R'");
                    if (yellow.getCublet(1,2)== Cube.Color.WHITE)
                        move("F2");
                    return doWhiteCross();
                case BLUE:
                    move("L");
                    return doWhiteCross();
            }
        }
        //////////////////////////////////////////////////////////////////////////////////////////////////////////
        if(green.getCublet(1,0)== Cube.Color.WHITE) {
            switch (orange.getCublet(0, 1)) {
                case ORANGE:
                    move("B'");
                    return doWhiteCross();
                case RED:
                    move("R2 F");
                    if (yellow.getCublet(2,1)== Cube.Color.WHITE)
                        move("R2");
                    return doWhiteCross();
                case GREEN:
                    move("R' U' F U");
                    return doWhiteCross();
                case BLUE:
                    move("R' U F U'");
                    if (orange.getCublet(0,1)== Cube.Color.WHITE)
                        move("R");
                    return doWhiteCross();
            }
        }
        if(green.getCublet(2,1)== Cube.Color.WHITE) {
            switch (green.getCublet(0, 1)) {
                case ORANGE:
                    move("D' R' D");

                case RED:
                    move("F'");
                    move("D R' D'");
                    return doWhiteCross();
                case GREEN:
                    move("R'");
                    return doWhiteCross();
                case BLUE:
                    move("F2 L");
                    if (yellow.getCublet(1,2)== Cube.Color.WHITE)
                        move("F2");
                    return doWhiteCross();
            }
        }
        if(red.getCublet(1,2)== Cube.Color.WHITE) {
            if(white.getCublet(1, 0)== Cube.Color.BLUE)
                move("F");
            else
                move("F'");
            return doWhiteCross();
        }
        if(red.getCublet(0,1)== Cube.Color.WHITE) {
            switch (orange.getCublet(2, 1)) {
                case ORANGE:
                    move("D L D'");
                    return doWhiteCross();
                case RED:
                    move("D' L D");
                    if (yellow.getCublet(0,1)== Cube.Color.WHITE)
                        move("L2");
                    return doWhiteCross();
                case GREEN:
                    move("F2 R'");
                    if (yellow.getCublet(1,2)== Cube.Color.WHITE)
                        move("F2");
                    return doWhiteCross();
                case BLUE:
                    move("L");
                    return doWhiteCross();
            }
        }
        return false;
    }
    public void printSolve(){
        System.out.println(solve.replace("F' F'","F2")
                .replace("F F", "F2")
                .replace("R R","R2")
                .replace("R' R'","R2")
                .replace("L L","L2")
                .replace("L' L'","L2")
                .replace("U U","U2")
                .replace("U' U'","U2")
                .replace("D D","D2")
                .replace("D' D'","D2")
                .replace("B B","B2")
                .replace("B' B'","B2")
                .replace("F2 F2","")
                .replace("R2 R2","")
                .replace("L2 L2","")
                .replace("U2 U2","")
                .replace("D2 D2","")
                .replace("B2 B2",""));
    }
}
