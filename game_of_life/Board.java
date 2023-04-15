package game_of_life;

import java.util.Random;

public class Board {
    final private int width;
    final private int height;
    final private boolean[][] grid;
    final private int[][] gridPoints;

    public Board(int width, int height) {
        this.width = width;
        this.height = height;
        grid = new boolean[width][height];
        gridPoints = new int[width][height];

        resetBoard();
    }


    public void  resetBoard () {
        for(int i=0;i<height;i++){
            for(int j=0;j<width;j++){
                grid[j][i] = false;
                gridPoints[j][i] = 0;
            }
        }
    }
    public void  resetGridPoint () {
        for(int i=0;i<height;i++){
            for(int j=0;j<width;j++){
                gridPoints[j][i] = 0;
            }
        }
    }
    public void round(){
        for(int x=0;x<height;x++){
            for(int y=0;y<width;y++){
                countLiveNeighbour(x,y);
            }
        }
        for(int x=0;x<height;x++){
            for(int y=0;y<width;y++){
                if(grid[x][y]){
                    if(gridPoints[x][y]<2 || gridPoints[x][y]>3){
                        grid[x][y] = false;
                    }
                } else {
                    if(gridPoints[x][y]==3){
                        grid[x][y] = true;
                    }
                }
            }
        }
        resetGridPoint();
    }
    public void countLiveNeighbour(int r, int c){
        int i,j;
        for (i = r - 1; i <= r + 1; i++){
            for (j = c - 1 ; j <= c + 1; j++){
                if((i == r && j ==c) || (i<0 || j<0) || (i>=width || j>=height)){
                    continue;
                }
                if(grid[i][j]){
                    gridPoints[r][c]++;
                }
            }
        }
    }

    /**
     * Debug tools
     */
    public void setRandomSetup(){
        Random random = new Random();
        for(int i=0;i<width;i++){
            for(int j =0;j<height;j++){
                grid[i][j] = random.nextBoolean();
            }
        }
    }
    public void displayPointGrid(){
        for(int i=0;i<width;i++){
            for(int j =0;j<height;j++) {
                System.out.print(gridPoints[i][j] + "-");
            }
            System.out.println();
        }
        System.out.println();
    }
    public void displayGrid(){

        for(int i=0;i<width;i++){
            for(int j =0;j<height;j++) {
                if (grid[i][j]) {
                    System.out.print(1 + "-");
                } else {
                    System.out.print(0 + "-");
                }
            }
            System.out.println();
        }
        System.out.println();
    }
    public void setLife(final int x, final int y){
        if(x > width || x < 0 || y > height || y <0){
            System.out.print("ERROR bad argument on setLife method");
        }
        grid[x][y] = true;
    }
}
