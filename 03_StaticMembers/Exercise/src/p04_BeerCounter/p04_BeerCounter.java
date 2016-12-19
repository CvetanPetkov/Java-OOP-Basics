package p04_BeerCounter;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class BeerCounter {
    private Integer beersBought;
    private Integer beersDrank;
    static Integer beerInStock = 0;
    static Integer beerDrankCount = 0;

    public BeerCounter (Integer beersBought, Integer beersDrank) {
        this.beersBought = beersBought;
        this.beersDrank = beersDrank;
    }

    public static void drinkBeer (Integer beers) {
        beerDrankCount += beers;
        beerInStock -= beers;
    }

    public static void buyBeer (Integer beers) {
        beerInStock += beers;
    }
}

public class p04_BeerCounter {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        while (true) {
            String[] input = reader.readLine().split("[\\s]+");
            if (input[0].equals("End")) {
                break;
            } else {
                Integer beersBought = Integer.valueOf(input[0]);
                Integer beersDrank = Integer.valueOf(input[1]);
                BeerCounter beerCounter = new BeerCounter(beersBought, beersDrank);
                BeerCounter.buyBeer(beersBought);
                BeerCounter.drinkBeer(beersDrank);
            }
        }

        System.out.println(BeerCounter.beerInStock + " " + BeerCounter.beerDrankCount);
    }
}
