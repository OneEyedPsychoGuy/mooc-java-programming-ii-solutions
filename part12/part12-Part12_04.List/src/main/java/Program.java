public class Program {
    public static void main(String[] args) {
        List<String> strings = new List<>();
        System.out.println(strings.contains("Hello!"));
        strings.add("Hello!");
        System.out.println(strings.contains("Hello!"));
        strings.remove("Hello!");
        System.out.println(strings.contains("Hello!"));
    }
}