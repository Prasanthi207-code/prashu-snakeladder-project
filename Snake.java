import java.util.HashMap;
import java.util.Random;
public class Snake {
    public static void main(String[] args) {
        HashMap<Integer, Integer> snakes = new HashMap<>();
        HashMap<Integer, Integer> ladders = new HashMap<>();
 
        snakes.put(99, 54);
        snakes.put(70, 55);
        snakes.put(52, 42);
        snakes.put(25, 2);

        
        ladders.put(6, 25);
        ladders.put(11, 40);
        ladders.put(46, 90);
        ladders.put(60, 85);

        int position = 0;
        Random random = new Random();

        System.out.println("=== Snake and Ladder Game ===");

        while (position<100) {

            int dice=random.nextInt(6)+1;
            System.out.println("\nDice: "+dice);

            if (position+dice<=100) {
                position+=dice;
            } else {
                System.out.println("Need exact number to reach 100.");
            }
 
            if (ladders.containsKey(position)) {
                System.out.println("Ladder! "+position+"->"+ladders.get(position));
                position=ladders.get(position);
            }

            // Check Snake
            if (snakes.containsKey(position)) {
                System.out.println("Snake!"+position+"->"+snakes.get(position));
                position=snakes.get(position);
            }
            System.out.println("Current Position:"+position);
        }

        System.out.println("\nCongratulations! You Won!");
    }
}