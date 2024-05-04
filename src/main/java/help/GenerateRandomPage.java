package help;

import com.github.javafaker.Faker;
import java.util.Random;

public class GenerateRandomPage {

    public static String generateRockStarText() {
        Faker faker = new Faker();
        return faker.name().firstName();
    }

    public static int generateRandomNumber() {
        Random random = new Random();
        return random.nextInt(5);
    }
}
