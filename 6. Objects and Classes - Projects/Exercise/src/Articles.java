import java.util.Scanner;
public class Articles {
    static class Article {
        private String title;
        private String content;
        private String author;

        Article (String title, String content, String author) {
            this.title = title;
            this.content = content;
            this.author = author;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getTitle() {
            return this.title;
        }

        public void setContent(String content) {
            this.content = content;
        }

        public String getContent() {
            return this.content;
        }

        public void setAuthor(String author) {
            this.author = author;
        }

        public String getAuthor() {
            return this.author;
        }

        @Override
        public String toString() {
            return String.format("%s - %s: %s", getTitle(), getContent(), getAuthor());
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] articleInput = scanner.nextLine().split(", ");
        String title = articleInput[0];
        String content = articleInput[1];
        String author = articleInput[2];

        Article article = new Article(title, content, author);

        int n = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < n; i++) {
            String[] input = scanner.nextLine().split(" ", 2);
            String command = input[0];
            String articleUpdate = input[1];

            if (command.equals("Edit:")) {
                article.setContent(articleUpdate);
            } else if (command.equals("ChangeAuthor:")) {
                article.setAuthor(articleUpdate);
            } else if (command.equals("Rename:")) {
                article.setTitle(articleUpdate);
            }
        }

        System.out.println(article);
    }
}