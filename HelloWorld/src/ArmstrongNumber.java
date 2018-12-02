public class ArmstrongNumber {

    public static void main(String[] args) {
        int digit,sum,num;
        System.out.println("Armstrong numbers between 1 to 500 are:");

        for (int i=1; i<=153;i++){
            sum =0;
            for (num = i;num>0;num/=10){
                digit=num%10;
                sum += digit*digit*digit;
                System.out.println("sum of" + i + " " + sum);
            }
            if (sum==i){

                System.out.println(i);
            }

        }

        }


}
