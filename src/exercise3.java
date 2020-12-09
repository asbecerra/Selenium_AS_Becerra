import java.util.Scanner;

public class exercise3 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int num;
        System.out.println("Enter a number");
        num = input.nextInt();
        System.out.println("The double of the number is " +doubleNumber(num));

    }

    public static int doubleNumber (int aNumber){
        return(int) (aNumber * 2);
    }
}
