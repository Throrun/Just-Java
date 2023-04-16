package recursion_excercises;

public class main {
    public static double pow(double base, double index){
        if(index == 0){
            return 1;
        }
        if(index>1){
            return base*pow(base, index-1);
        } else {
            return base;
        }

    }
    public static void main(String[] args){
        double result = pow(2,10);
        System.out.print(result);
    }
}
