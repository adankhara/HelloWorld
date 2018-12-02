import java.util.Scanner;

public class PrimeNumber {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter any number: ");
        int givenNum;
        //boolean b = false;
        givenNum = scanner.nextInt();
        for (int i = 2; i <= givenNum/2 ; i++){
            if (!(givenNum % 2 == 0)){
            //    b = true;
                System.out.println(" It's a prime number:");
                break;
            }
            else {
                System.out.println(" It's not a prime number:");

            }

        }


    }
}
