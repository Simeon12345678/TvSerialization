import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        TvMain tv = new TvMain();
        Scanner in = new Scanner(System.in);
        boolean whileWindowOpen = true;

        while (whileWindowOpen) {
            System.out.println("Here are the shows: ");
            for (int i = 0; i < tv.getShows().size(); i++) {
                System.out.println(tv.getShows().get(i) + "\n");
            }

            System.out.print("Would you like to add more Y/N: ");
            try {
                String input = in.nextLine();
                if (input.equalsIgnoreCase("Y")) {
                    System.out.print("Enter name: ");
                    String name = in.nextLine();
                    System.out.print("Enter rating: ");
                    String rating = in.nextLine();
                    int conRating = Integer.parseInt(rating);
                    System.out.print("Enter which season: ");
                    String season = in.nextLine();
                    int conSeason = Integer.parseInt(season);
                    System.out.print("Enter how many episodes: ");
                    String episodes = in.nextLine();
                    int conEpisodes = Integer.parseInt(episodes);
                    // add the show
                    tv.createCustomData(conRating, name, conSeason, conEpisodes);
                }  else if (input.equalsIgnoreCase("N")) {
                    whileWindowOpen = false;
                }
            } catch(Exception e) {
                System.out.println("ERR invalid input!");
            }
        }
    }
}