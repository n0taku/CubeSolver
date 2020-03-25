package pl.n0taku;


import java.util.ArrayList;

enum Direction {
    RIGHT("R"),LEFT("L"),UP("U"),DOWN("D"),FRONT("F"),BACK("B");
    private String symbol;
    Direction(String symbol){
        this.symbol=symbol;
    }
    public String getSymbol(){
        return symbol;
    }
}

public class Cube {
    ArrayList<Face> face;
    enum Color {
        YELLOW("\033[33mY\033[0m"),BLUE("\033[34mB\033[0m"),RED("\033[31mR\033[0m"),GREEN("\033[32mG\033[0m"),ORANGE("\033[35mO\033[0m"),WHITE("W");
        private String symbol;
        Color(String symbol){
            this.symbol=symbol;
        }
        public String getSymbol(){
            return symbol;
        }
    }

    Cube(){
        face = new ArrayList<Face>();
        face.add(new Face(Color.YELLOW));  //0
        face.add(new Face(Color.BLUE));    //1
        face.add(new Face(Color.RED));     //2
        face.add(new Face(Color.GREEN));   //3
        face.add(new Face(Color.ORANGE));  //4
        face.add(new Face(Color.WHITE));   //5
    }
    public void print(){
        System.out.println("      "+face.get(0).getRow(0));
        System.out.println("      "+face.get(0).getRow(1));
        System.out.println("      "+face.get(0).getRow(2));

        System.out.print(face.get(1).getRow(0)+" ");
        System.out.print(face.get(2).getRow(0)+" ");
        System.out.print(face.get(3).getRow(0)+" ");
        System.out.println(face.get(4).getRow(0));

        System.out.print(face.get(1).getRow(1)+" ");
        System.out.print(face.get(2).getRow(1)+" ");
        System.out.print(face.get(3).getRow(1)+" ");
        System.out.println(face.get(4).getRow(1));

        System.out.print(face.get(1).getRow(2)+" ");
        System.out.print(face.get(2).getRow(2)+" ");
        System.out.print(face.get(3).getRow(2)+" ");
        System.out.println(face.get(4).getRow(2));

        System.out.println("      "+face.get(5).getRow(0));
        System.out.println("      "+face.get(5).getRow(1));
        System.out.println("      "+face.get(5).getRow(2));

    }
    private void copyC(int from,int to,int x,int y){
        face.get(to).setCublet(x,y,face.get(from).getCublet(x,y));
    }
    private void copyC(Face from,int to,int x,int y){
        face.get(to).setCublet(x,y,from.getCublet(x,y));
    }
    private void copyC(int from,Face to,int x,int y){
        to.setCublet(x,y,face.get(from).getCublet(x,y));
    }
    private void copyC(int from,int to,int x,int y, int x2, int y2){
        face.get(to).setCublet(x2,y2,face.get(from).getCublet(x,y));
    }
    private void copyC(Face from,int to,int x,int y, int x2, int y2){
        face.get(to).setCublet(x2,y2,from.getCublet(x,y));
    }
    public void move(String move){
        String[] moves = move.split(" ");
        for (String s : moves){
            switch(s){
                case "R":
                    move(Direction.RIGHT,true);
                    break;
                case "R2":
                    move(Direction.RIGHT,true);
                    move(Direction.RIGHT,true);
                    break;
                case "R'":
                    move(Direction.RIGHT,false);
                    break;
                case "R2'":
                    move(Direction.RIGHT,false);
                    move(Direction.RIGHT,false);
                    break;
                case "L":
                    move(Direction.LEFT,true);
                    break;
                case "L2":
                    move(Direction.LEFT,true);
                    move(Direction.LEFT,true);
                    break;
                case "L'":
                    move(Direction.LEFT,false);
                    break;
                case "L2'":
                    move(Direction.LEFT,false);
                    move(Direction.LEFT,false);
                    break;
                case "U":
                    move(Direction.UP,true);
                    break;
                case "U2":
                    move(Direction.UP,true);
                    move(Direction.UP,true);
                    break;
                case "U'":
                    move(Direction.UP,false);
                    break;
                case "U2'":
                    move(Direction.UP,false);
                    move(Direction.UP,false);
                    break;
                case "D":
                    move(Direction.DOWN,true);
                    break;
                case "D2":
                    move(Direction.DOWN,true);
                    move(Direction.DOWN,true);
                    break;
                case "D'":
                    move(Direction.DOWN,false);
                    break;
                case "D2'":
                    move(Direction.DOWN,false);
                    move(Direction.DOWN,false);
                    break;
                case "F":
                    move(Direction.FRONT,true);
                    break;
                case "F2":
                    move(Direction.FRONT,true);
                    move(Direction.FRONT,true);
                    break;
                case "F'":
                    move(Direction.FRONT,false);
                    break;
                case "F2'":
                    move(Direction.FRONT,false);
                    move(Direction.FRONT,false);
                    break;
                case "B":
                    move(Direction.BACK,true);
                    break;
                case "B2":
                    move(Direction.BACK,true);
                    move(Direction.BACK,true);
                    break;
                case "B'":
                    move(Direction.BACK,false);
                    break;
                case "B2'":
                    move(Direction.BACK,false);
                    move(Direction.BACK,false);
                    break;
                default:
                    System.out.println("error input");
                    break;
            }
        }
    }

    public void move(Direction direction,boolean clockwise){
        Face temp;
        switch (direction){
            case UP:
                temp = new Face(face.get(1));
                if(clockwise) {
                    //blue to red
                    copyC(2,1,0,0);
                    copyC(2,1,1,0);
                    copyC(2,1,2,0);
                    //red to green
                    copyC(3,2,0,0);
                    copyC(3,2,1,0);
                    copyC(3,2,2,0);
                    //red to orange
                    copyC(4,3,0,0);
                    copyC(4,3,1,0);
                    copyC(4,3,2,0);
                    //red to blue
                    copyC(temp,4,0,0);
                    copyC(temp,4,1,0);
                    copyC(temp,4,2,0);
                    //rotate yellow
                    face.get(0).rotate(true);
                }else{
                    //blue to orange
                    copyC(4,1,0,0);
                    copyC(4,1,1,0);
                    copyC(4,1,2,0);
                    //orange to green
                    copyC(3,4,0,0);
                    copyC(3,4,1,0);
                    copyC(3,4,2,0);
                    //green to red
                    copyC(2,3,0,0);
                    copyC(2,3,1,0);
                    copyC(2,3,2,0);
                    //red to blue
                    copyC(temp,2,0,0);
                    copyC(temp,2,1,0);
                    copyC(temp,2,2,0);
                    //rotate yellow
                    face.get(0).rotate(false);
                }
                break;
            case RIGHT:
                temp = new Face(face.get(2));
                if(clockwise) {
                    //white to red
                    copyC(5,2,2,0);
                    copyC(5,2,2,1);
                    copyC(5,2,2,2);
                    //orange to white
                    copyC(4,5,0,0,2,2);
                    copyC(4,5,0,1,2,1);
                    copyC(4,5,0,2,2,0);
                    //yellow to orange
                    copyC(0,4,2,2,0,0);
                    copyC(0,4,2,1,0,1);
                    copyC(0,4,2,0,0,2);
                    //red to yellow
                    copyC(temp,0,2,0);
                    copyC(temp,0,2,1);
                    copyC(temp,0,2,2);
                    //rotate green
                    face.get(3).rotate(true);
                }else{
                    //yellow to red
                    copyC(0,2,2,0);
                    copyC(0,2,2,1);
                    copyC(0,2,2,2);
                    //orange to yellow
                    copyC(4,0,0,0,2,2);
                    copyC(4,0,0,1,2,1);
                    copyC(4,0,0,2,2,0);
                    //white to orange
                    copyC(5,4,2,0,0,2);
                    copyC(5,4,2,1,0,1);
                    copyC(5,4,2,2,0,0);
                    //red to yellow
                    copyC(temp,5,2,0);
                    copyC(temp,5,2,1);
                    copyC(temp,5,2,2);
                    //rotate green
                    face.get(3).rotate(false);
                }
                break;
            case LEFT:
                temp = new Face(face.get(2));
                if(!clockwise) {
                    //white to red
                    copyC(5,2,0,0);
                    copyC(5,2,0,1);
                    copyC(5,2,0,2);
                    //orange to white
                    copyC(4,5,2,0,0,2);
                    copyC(4,5,2,1,0,1);
                    copyC(4,5,2,2,0,0);
                    //yellow to orange
                    copyC(0,4,0,0,2,2);
                    copyC(0,4,0,1,2,1);
                    copyC(0,4,0,2,2,0);
                    //red to yellow
                    copyC(temp,0,0,0);
                    copyC(temp,0,0,1);
                    copyC(temp,0,0,2);
                    //rotate blue
                    face.get(1).rotate(false);
                }else{
                    //yellow to red
                    copyC(0,2,0,0);
                    copyC(0,2,0,1);
                    copyC(0,2,0,2);
                    //orange to yellow
                    copyC(4,0,2,0,0,2);
                    copyC(4,0,2,1,0,1);
                    copyC(4,0,2,2,0,0);
                    //white to orange
                    copyC(5,4,0,0,2,2);
                    copyC(5,4,0,1,2,1);
                    copyC(5,4,0,2,2,0);
                    //red to yellow
                    copyC(temp,5,0,0);
                    copyC(temp,5,0,1);
                    copyC(temp,5,0,2);
                    //rotate blue
                    face.get(1).rotate(true);
                }
                break;
            case DOWN:
                temp = new Face(face.get(1));
                if(!clockwise) {
                    //red to blue
                    copyC(2,1,0,2);
                    copyC(2,1,1,2);
                    copyC(2,1,2,2);
                    //green to red
                    copyC(3,2,0,2);
                    copyC(3,2,1,2);
                    copyC(3,2,2,2);
                    //orange to green
                    copyC(4,3,0,2);
                    copyC(4,3,1,2);
                    copyC(4,3,2,2);
                    //blue to orange
                    copyC(temp,4,0,2);
                    copyC(temp,4,1,2);
                    copyC(temp,4,2,2);
                    //rotate white
                    face.get(5).rotate(false );
                }else{
                    //blue to orange
                    copyC(4,1,0,2);
                    copyC(4,1,1,2);
                    copyC(4,1,2,2);
                    //orange to green
                    copyC(3,4,0,2);
                    copyC(3,4,1,2);
                    copyC(3,4,2,2);
                    //green to red
                    copyC(2,3,0,2);
                    copyC(2,3,1,2);
                    copyC(2,3,2,2);
                    //red to blue
                    copyC(temp,2,0,2);
                    copyC(temp,2,1,2);
                    copyC(temp,2,2,2);
                    //rotate white
                    face.get(5).rotate(true);
                }
                break;
            case FRONT:
                temp = new Face(face.get(1));
                if(clockwise){
                    //white to blue
                    copyC(5,1,0,0,2,0);
                    copyC(5,1,1,0,2,1);
                    copyC(5,1,2,0,2,2);
                    //green to whote
                    copyC(3,5,0,2,0,0);
                    copyC(3,5,0,1,1,0);
                    copyC(3,5,0,0,2,0);
                    //yellow to green
                    copyC(0,3,2,2,0,2);
                    copyC(0,3,1,2,0,1);
                    copyC(0,3,0,2,0,0);
                    //blue to yellow
                    copyC(temp,0,2,0,2,2);
                    copyC(temp,0,2,1,1,2);
                    copyC(temp,0,2,2,0,2);

                    //rotate red
                    face.get(2).rotate(true);
                }else{
                    //yellow to blue
                    copyC(0,1,0,2,2,2);
                    copyC(0,1,1,2,2,1);
                    copyC(0,1,2,2,2,0);
                    //green to yellow
                    copyC(3,0,0,0,0,2);
                    copyC(3,0,0,1,1,2);
                    copyC(3,0,0,2,2,2);
                    //white to green
                    copyC(5,3,0,0,0,2);
                    copyC(5,3,1,0,0,1);
                    copyC(5,3,2,0,0,0);
                    //blue to white
                    copyC(temp,5,2,0,0,0);
                    copyC(temp,5,2,1,1,0);
                    copyC(temp,5,2,2,2,0);

                    //rotate red
                    face.get(2).rotate(false);
                }
                break;
            case BACK:
                temp = new Face(face.get(1));
                if(!clockwise){
                    //white to blue
                    copyC(5,1,2,2,0,2);
                    copyC(5,1,1,2,0,1);
                    copyC(5,1,0,2,0,0);
                    //green to white
                    copyC(3,5,2,0,2,2);
                    copyC(3,5,2,1,1,2);
                    copyC(3,5,2,2,0,2);
                    //yellow to green
                    copyC(0,3,2,0,2,2);
                    copyC(0,3,1,0,2,1);
                    copyC(0,3,0,0,2,0);
                    //blue to yellow
                    copyC(temp,0,0,0,2,0);
                    copyC(temp,0,0,1,1,0);
                    copyC(temp,0,0,2,0,0);

                    //rotate orange
                    face.get(4).rotate(false);
                }else{
                    //yellow to blue
                    copyC(0,1,0,0,0,2);
                    copyC(0,1,1,0,0,1);
                    copyC(0,1,2,0,0,0);
                    //green to yellow
                    copyC(3,0,2,0,0,0);
                    copyC(3,0,2,1,1,0);
                    copyC(3,0,2,2,2,0);
                    //white to green
                    copyC(5,3,0,2,2,2);
                    copyC(5,3,1,2,2,1);
                    copyC(5,3,2,2,2,0);
                    //blue to white
                    copyC(temp,5,0,0,0,2);
                    copyC(temp,5,0,1,1,2);
                    copyC(temp,5,0,2,2,2);

                    //rotate orange
                    face.get(4).rotate(true);
                }
                break;
        }
    }

    public class Face{
        private Color[][] cublet;
        private int width;
        private int height;

        public int getWidth() {
            return width;
        }

        public int getHeight() {
            return height;
        }

        Face() {
            this(Color.WHITE);
        }
        Face(Color color){
            width=height=3;
            cublet =new Color[width][height];
            for(int i=0;i<height;i++){
                for (int j=0;j<width;j++){
                    cublet[j][i]=color;
                }
            }
        }
        Face(Face f){
            width=height=3;
            cublet =new Color[width][height];
            for(int i=0;i<height;i++){
                for (int j=0;j<width;j++){
                    cublet[j][i]=f.getCublet(j,i);
                }
            }
        }

        public Color getCublet(int x, int y){
            return cublet[x][y];
        }

        protected  void setCublet(int x, int y, Color color){
            cublet[x][y]=color;
        }

        public String getRow(int row){
            return cublet[0][row].getSymbol()+" "+cublet[1][row].getSymbol()+" "+cublet[2][row].getSymbol();
        }

        public void rotate(boolean clockwise){
            Face temp = new Face(this);
            int x,y;
            if (clockwise) {
                x = 0;
                y = 2;
            }else{
                x = 2;
                y = 0;
            }
            cublet[0][0]=temp.getCublet(x,y);
            cublet[1][0]=temp.getCublet(x,1);
            cublet[2][0]=temp.getCublet(x,x);
            cublet[2][1]=temp.getCublet(1,x);
            cublet[2][2]=temp.getCublet(y,x);
            cublet[1][2]=temp.getCublet(y,1);
            cublet[0][2]=temp.getCublet(y,y);
            cublet[0][1]=temp.getCublet(1,y);

        }

        public void print(){
            for(int i=0;i<height;i++){
                for (int j=0;j<width;j++){
                    System.out.print(cublet[j][i]+" ");
                }
                System.out.println();
            }
        }
        public void printShort(){
            for(int i=0;i<height;i++){
                for (int j=0;j<width;j++){
                    System.out.print(cublet[j][i].getSymbol()+" ");
                }
                System.out.println();
            }
        }
    }

}
