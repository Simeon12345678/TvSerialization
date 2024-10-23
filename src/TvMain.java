import java.util.ArrayList;
import java.io.*;
import java.util.Random;

// collection of tv shows from TvSeries stores all TvSeries inside an ArrayList
public class TvMain {
    private ArrayList<TvSeries> shows = new ArrayList<>();

    public TvMain() {
        createData();
        writeToFile();
        readFromFile();
    }

    public ArrayList<TvSeries> getShows() {
        return shows;
    }

    void writeToFile() {
        try {
            FileOutputStream file = new FileOutputStream("TvSerialization.ser");
            ObjectOutputStream objectOut = new ObjectOutputStream(file);

            objectOut.writeObject(shows);

            file.close();
            objectOut.close();

            System.out.println("Done");
        } catch (IOException e) {
            System.out.println("Error writing to file");
        }
    }

    void readFromFile() {
        try {
            FileInputStream file = new FileInputStream("TvSerialization.ser");
            ObjectInputStream objectIn = new ObjectInputStream(file);

            shows = (ArrayList<TvSeries>)objectIn.readObject(); // hates my typecast

            file.close();
            objectIn.close();
        } catch (IOException e) {
            System.out.println("Error reading from file");
        } catch (ClassNotFoundException e) {
            System.out.println("Error not found class");
        }
    }

    void createCustomData(int rating, String name, int seasons, int episodes) {
        TvSeries tv = new TvSeries(name);
        shows.add(tv);
        tv.changeRating(rating);
        tv.addEpisodes(seasons, episodes);
        tv.printInfo();
    }

    void createData() {
        Random rand = new Random();
        String test[] = {"One Punch Man", "Bleach", "One Piece"};
        TvSeries tvSeries;
        for (String name : test) {
            tvSeries = new TvSeries(name); // init
            shows.add(tvSeries);
            // change the rating from 0 to 10
            tvSeries.changeRating(rand.nextInt(10));
            // add episodes between 1 and 25 and seasons between 1 and 5
            tvSeries.addEpisodes((rand.nextInt((5 - 1) + 1) + 1), (rand.nextInt((25 - 1) + 1) + 1));
            tvSeries.printInfo();
        }
    }
}
