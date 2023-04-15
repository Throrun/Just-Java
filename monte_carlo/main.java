package monte_carlo;

import java.util.Scanner;

public class main {
    public static double randomPoint(double a,double b){
        return a + Math.random()*Math.abs(a-b);
    }
    public static double func(double a,double b, double c, double x){
        return a*x*x + b*x + c;
    }
    public static void main(String[] args){

        Scanner input = new Scanner(System.in);
        //moj program będzie liczył całkę oznaczoną od r1 do r2 z funkcji kwadratowej
        System.out.println("f(x)= ax^2+bx+c");
        System.out.println("Podaj a:");
        float a = input.nextFloat();
        System.out.println("Podaj b:");
        float b = input.nextFloat();
        System.out.println("Podaj c:");
        float c = input.nextFloat();
        System.out.println("Podaj pierwszy zakres całki:");
        float r1 = input.nextFloat();
        System.out.println("Podaj drugi zakres całki:");
        float r2 = input.nextFloat();
        System.out.println("Podaj n:");
        int n = input.nextInt();

        double x,y, maxHeight = Math.max(func(a,b,c,r1), func(a,b,c,r2));
        int win=0, lose=0;
        while (n>0){
            x = randomPoint(r1,r2);
            y = randomPoint(0,maxHeight);
            if(y>0 && y < func(a,b,c,x)){
                win++;
            } else if(y<0 && y < func(a,b,c,x)){
                win++;
            } else {
                lose++;
            }
            n--;
        }
        System.out.println(a + "x^2 +" + b + "x + " + c);
        double result = (double) win /(win+lose)*maxHeight*(Math.abs(r2-r1));
        System.out.println("całka od " + Math.min(r1,r2) + " do " + Math.max(r1,r2) + " funkcji wynosi: " + result);
    }
}
