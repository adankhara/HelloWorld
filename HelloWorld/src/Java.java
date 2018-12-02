public class Java {

    public static void main(String[] args) {

        Product p1 = new Product(1, "pen");

        p1.printStatus();
        Product p4 = new Product(1, "pen");
        p4.printStatus();
        Product p2 = new Product(10, "pencil");
        p2.printStatus();
        Product p3 = new Product(20, "notebook");

        System.out.println("total at p3: " + p3.getTotal());

        p3.printStatus();

    }
}