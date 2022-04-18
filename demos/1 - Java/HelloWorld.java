public class HelloWorld {

    //the main method is the entry point that JVM will read our code
    //method = function = useds to execute behavior in our objects
    //parameter = arguments/inputs that we add to our methods
    public static void main(String[] args){
        int num = 10;
        //System.out.println("Hello world. My secret number is: " + addNumbers(1, 2) + ".");
        spyName(num);
    }

    //void = returns nothing
    //int method return integers
    public static int addNumbers(int x, int y){
        return x + y;
    }

    public static void spyName(int x){
        int counter = 0;

        while(x != counter){
            System.out.println("Bob " + counter);
            counter++;
        }
    }

    /*
    Primitive Datatypes:
    - boolean <= true, false - either 0 or 1
    - byte <= smallest unit of measurement <= 8 bits make a byte
    - int <= integer, whole numbers = 1, 2, 3, etc.
    - short ""
    - long ""
    - double <= decimal numbers
    - float <= decimals
    - char <= single-character

    Not primitives: arrays, collections, strings, objects
    */
}