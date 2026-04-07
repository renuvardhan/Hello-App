public class HelloApp {
    public static void main(String[] args) {
        String message;

        if (args.length == 0) {
            message = "World";
        } else {
            message = String.join(", ", args);
        }

        System.out.println("Hello, " + message + "!");
    }
}