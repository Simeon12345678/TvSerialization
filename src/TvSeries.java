import java.util.ArrayList;
import java.util.Scanner;

// class creates individual tv shows with their own name, season, rating and episodes
public class TvSeries {
    private String name;
    private int rating;
    private ArrayList<Integer> episodes = new ArrayList<>();

    public TvSeries() {
        System.out.println("Write name: ");
        Scanner in = new Scanner(System.in);
        try {
            name = in.nextLine();
        } catch (Exception e) {
            System.out.println("error");
        }
    }

    public TvSeries(String inName) {
        name = inName;
    }

    void addEpisodes(int season, int numOfEpisodes) {
        for (int i = 0; i < season; i++) {
            // pushes 0 to the array in case user ie decides to add season 3 before 1 and 2 etc
            episodes.add(0);
        }

        episodes.add(season - 1, numOfEpisodes);
    }

    void changeRating(int newRating) {
        rating = newRating;
    }

    void printInfo() {
        System.out.println("Name: " + name + " Rating: " + rating);
    }
}
