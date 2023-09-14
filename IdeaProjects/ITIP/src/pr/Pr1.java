package pr;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Pr1 {
    public static void main(String[] args) {
        // Press Alt+Enter with your caret at the highlighted text to see how
        // IntelliJ IDEA suggests fixing it.
        System.out.println(convert(5));
        System.out.println("_________");
        System.out.println(gitCalc(15, 2));
        System.out.println("_________");
        System.out.println(containers(3, 4, 2));
        System.out.println("_________");
        System.out.println(triangleType(10,2,3));
        System.out.println("_________");
        System.out.println(ternaryEvaluation(8, 4));
        System.out.println("_________");
        System.out.println(howManyItems(22, 1.4f,2));
        System.out.println("_________");
        System.out.println(factorial(7));
        System.out.println("_________");
        System.out.println(gcd(52, 8));
        System.out.println("_________");
        System.out.println(ticketSaler(24, 950));
        System.out.println("_________");
        System.out.println(tables(5, 1));
    }
    public static float convert(int x){
        return x*3.785f;
    }
    public static int gitCalc(int x, int y){
        return x*y;
    }
    public static int containers(int x, int y, int z){
        return x*20+y*50+z*100;
    }
    public static String triangleType(int x, int y, int z){
        if ((x<(y+z)) && (y<(z+x)) && (z<(x+y))){
            if((x==y) & (x==z)){
                return "равносторонний";
            }
            else if((x==y) || (x==z) || (y==z)) {
                return "равнобедренный";
            }
            else{
                return "разносторонний";
            }
        }
        else {
            return "не треугольник";
        }
    }
    public static int ternaryEvaluation(int x, int y){
        return x>y?x:y;
    }
    public static int howManyItems(float n, float x, float y){
        return (int) (n/(2*x*y));
    }
    public static int factorial(int x){
        int count = 1;
        for(int i = 1; i<=x;i++){
            count *=i;
        }
        return count;
    }
    public static int gcd(int x, int y){
        int res = 1;
        for(int i=1; (i<=x) && (i<=y);i++){
            if((x%i==0) && (y%i==0)){
                res = i;
            }
        }
        return res;
    }
    public static int ticketSaler(int x, int y){
        return (int) (x*y*0.72);
    }
    public static int tables(int x, int y){
        int res = x-(y*2);
        if(res>0){
            return res;
        }
        else {
            return 0;
        }
    }
}