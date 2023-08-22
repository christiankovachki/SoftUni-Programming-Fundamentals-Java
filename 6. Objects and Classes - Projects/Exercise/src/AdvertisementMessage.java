import java.util.*;

public class AdvertisementMessage {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<String> phrases = new ArrayList<>(Arrays.asList("Excellent product.", "Such a great product.", "I always use that product.",
                "Best product of its category.", "Exceptional product.", "I can’t live without this product."));
        List<String> events = new ArrayList<>(Arrays.asList("Now I feel good.", "I have succeeded with this product.", "Makes miracles. I am happy of the results!",
                "I cannot believe but now I feel awesome.", "Try it yourself, I am very satisfied.", "I feel great!"));
        List<String> authors = new ArrayList<>(Arrays.asList("Diana", "Petya", "Stella", "Elena", "Katya", "Iva", "Annie", "Eva"));
        List<String> cities = new ArrayList<>(Arrays.asList("Burgas", "Sofia", "Plovdiv", "Varna", "Ruse"));
        int n = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < n; i++) {
            Random rnd = new Random();
            int index = rnd.nextInt(cities.size());

            String phrase = phrases.get(index);
            String event = events.get(index);
            String author = authors.get(index);
            String city = cities.get(index);
            System.out.printf(phrase + " " + event + " " + author + " - " + city + " \n");
        }
    }
}