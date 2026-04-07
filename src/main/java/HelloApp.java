public class HelloApp {
    public static void main(String[] args) {

        if (args.length == 0) {
            System.out.println("Hello, World!");
            return;
        }

        StringBuilder nameBuilder = new StringBuilder();

        for (String name : args) {
            nameBuilder.append(name).append(", ");
        }

        if (nameBuilder.length() > 0) {
            String names = nameBuilder.substring(0, nameBuilder.length() - 2);
            System.out.println("Hello, " + names + "!");
        }
    }
}