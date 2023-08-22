import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
public class Songs {
    public static class Song {
        private String typeList;
        private String name;
        private String time;

        public String getTypeList() {
            return this.typeList;
        }

        public void setTypeList(String typeList) {
            this.typeList = typeList;
        }

        public String getName() {
            return this.name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getTime() {
            return this.time;
        }

        public void setTime(String time) {
            this.time = time;
        }
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Song> songs = new ArrayList<>();
        int n = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < n; i++) {
            String[] input = scanner.nextLine().split("_");

            Song song = new Song();
            song.setTypeList(input[0]);
            song.setName(input[1]);
            song.setTime(input[2]);

            songs.add(song);
        }

        String input = scanner.nextLine();
        if (input.equals("all")) {
            for (Song song : songs) {
                System.out.printf("%s\n", song.getName());
            }
        } else {
            for (Song song : songs) {
                if (input.equals(song.getTypeList())) {
                    System.out.printf("%s\n", song.getName());
                }
            }
        }
    }
}