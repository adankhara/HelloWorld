import java.util.Scanner;

public class Test1 {
    public static void main(String[] args) {

        int firstnum = 4;
        int lastnum = 104;
        int evncnt, oddcnt;
        int count;


        System.out.println("First number is " + firstnum);
        System.out.println("Last number is " + lastnum);

        count = lastnum - firstnum + 1;

        System.out.println("Total numbers are " + count);

        if (count % 2 == 0) {
            System.out.println("Total even numbers are " + count / 2);
            System.out.println("Total odd numbers are " + count / 2);

        } else {
            if (firstnum % 2 == 0) {
                System.out.println("Total Even numbers are ");
                System.out.println((count + 1) / 2);

                System.out.println("Total Odd numbers are ");

                System.out.println((count - 1) / 2);
            } else {
                System.out.println("Total even numbers are ");
                System.out.println((count - 1) / 2);
                System.out.println("Total odd numbers are ");

                System.out.println((count + 1) / 2);

            }
        }
    }
}

