public class Product {

    private int _quantity;
    private String _name;
    private static int _total;
    private static int _totalPen;

    public Product(int quantity, String name){
        _quantity = quantity;
        _name = name;
        _total += quantity;
        if (name.equals("pen")){
            _totalPen += quantity;
        }
    }

    public void printStatus(){
        System.out.println("Items: " + _quantity);
        System.out.println("Name: " + _name);
        System.out.println("Total Items: " + _total);
        System.out.println("Total Pen: " + _totalPen);
    }

    public int getTotal(){
        return _total;
    }
}
