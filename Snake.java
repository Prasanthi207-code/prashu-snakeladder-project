import java.util.*;

public class Snake {

    static Scanner sc = new Scanner(System.in);
    static Random random = new Random();

    static int player = 0;
    static int computer = 0;
    static int lastDice = 0;
    static String lastMessage = "Game started";

    static HashMap<Integer, Integer> snakes = new HashMap<>();
    static HashMap<Integer, Integer> ladders = new HashMap<>();

    // Colors
    static final String RED = "\u001B[31m";
    static final String GREEN = "\u001B[32m";
    static final String YELLOW = "\u001B[33m";
    static final String BLUE = "\u001B[34m";
    static final String RESET = "\u001B[0m";

    public static void main(String[] args) {
 
    resetGame();    
        System.out.println("==================================");
        System.out.println("      SNAKE AND LADDER GAME");
        System.out.println("==================================");

        System.out.println("Who should start?");
        System.out.println("1. Player");
        System.out.println("2. Computer");
int choice;

while (true) {
    System.out.print("Enter 1 for Player or 2 for Computer: ");
    choice = sc.nextInt();

    if (choice == 1 || choice == 2)
        break;

    System.out.println("Invalid choice! Please enter only 1 or 2.");
}

boolean playerTurn = (choice == 1);

        printBoard(playerTurn ? "YOUR TURN" : "COMPUTER TURN");

        while (true) {

            if (playerTurn) {

                System.out.println("\n=======================");
                System.out.println(" YOUR TURN");
                System.out.println("=======================");
                System.out.println("Press 1 to Roll Dice");

                int input = sc.nextInt();

                if (input != 1) {
                    System.out.println("Please enter only 1.");
                    continue;
                }

                int dice = rollDice();
                lastDice = dice;

                System.out.println(" You rolled : " + dice);
                System.out.println("Moving from " + player + " to " + (player + dice));

                player = move(player, dice);
                lastMessage = "You rolled " + dice + " and moved to " + player;
                printBoard("YOUR TURN");

                if (player == 100) {
                    System.out.println(GREEN + "\n YOU WON THE GAME " + RESET);
                    break;
                }

            } else {

                System.out.println("\n=======================");
                System.out.println(" COMPUTER TURN");
                System.out.println("=======================");

                try {
                    Thread.sleep(1500);
                } catch (Exception e) {
                }

                int dice = rollDice();
                lastDice = dice;

                System.out.println(" Computer rolled : " + dice);
                System.out.println("Computer moves from " + computer + " to " + (computer + dice));

                computer = move(computer, dice);
                lastMessage = "Computer rolled " + dice + " and moved to " + computer;
                printBoard("COMPUTER TURN");

                if (computer == 100) {
                    System.out.println(RED + "\n COMPUTER WON THE GAME" + RESET);
                    break;
                }
            }

            playerTurn = !playerTurn;
        }
    }

    static void generateBoard() {

    snakes.clear();
    ladders.clear();

    Set<Integer> used = new HashSet<>();

    // -------- SNAKES --------
    while (snakes.size() < 5) {

        int head = random.nextInt(90) + 10;   // 10-99
        int tail = random.nextInt(head - 1) + 1;

        if (head <= tail) continue;

        if (used.contains(head) || used.contains(tail)) continue;

        snakes.put(head, tail);
        used.add(head);
        used.add(tail);
    }

    // -------- LADDERS --------
    while (ladders.size() < 5) {

        int start = random.nextInt(90) + 1;
        int end = random.nextInt(100 - start) + start + 1;

        if (start >= end) continue;

        if (used.contains(start) || used.contains(end)) continue;

        ladders.put(start, end);
        used.add(start);
        used.add(end);
    }
}
    static int move(int position, int dice) {

        int newPos = position + dice;

        if (newPos > 100) {
            System.out.println("Need exact dice to reach 100!");
            return position;
        }

        try {
            Thread.sleep(800);
        } catch (Exception e) {
        }

        if (snakes.containsKey(newPos)) {

            System.out.println("\n SNAKE BITE!");
            System.out.println("Snake at : " + newPos);
            System.out.println("Going down to : " + snakes.get(newPos));

            newPos = snakes.get(newPos);

            try {
                Thread.sleep(1500);
            } catch (Exception e) {
            }
        }

        if (ladders.containsKey(newPos)) {

            System.out.println("\n🪜 LADDER!");
            System.out.println("Ladder at : " + newPos);
            System.out.println("Climbing to : " + ladders.get(newPos));

            newPos = ladders.get(newPos);

            try {
                Thread.sleep(1500);
            } catch (Exception e) {
            }
        }

        System.out.println("Current Position : " + newPos);

        return newPos;
    }  
    
    static void resetGame()
     {
    player = 0;
    computer = 0;
    generateBoard();
}
 static int rollDice() {
    return random.nextInt(6) + 1;
}
 static void printBoard(String turnLabel) {
        List<String> boardLines = new ArrayList<>();

        for (int row = 9; row >= 0; row--) {
            StringBuilder line = new StringBuilder();

            if (row % 2 == 0) {
                for (int col = 0; col < 10; col++) {
                    int num = row * 10 + col + 1;
                    line.append(padCell(formatCell(num)));
                }
            } else {
                for (int col = 9; col >= 0; col--) {
                    int num = row * 10 + col + 1;
                    line.append(padCell(formatCell(num)));
                }
            }

            boardLines.add(line.toString());
        }

        String[] statusLines = {
                "",
                YELLOW + "PLAYER POSITION : " + player + RESET,
                RED + "COMPUTER POSITION : " + computer + RESET
        };

        System.out.println();
        System.out.println("==============================================");
        System.out.println("           SNAKE AND LADDER ");
        System.out.println("==============================================");

        int lineCount = Math.max(boardLines.size(), statusLines.length);
        for (int i = 0; i < lineCount; i++) {
            String boardLine = i < boardLines.size() ? boardLines.get(i) : "";
            String statusLine = i < statusLines.length ? statusLines[i] : "";
            System.out.printf("%-55s   %s%n", boardLine, statusLine);
        }

        System.out.println();
    }

    static void printCell(int num) {
        System.out.print(padCell(formatCell(num)));
    }

    static String formatCell(int num) {
        if (player == 0 && computer == 0 && num == 1) {
            return BLUE + "[PC ]" + RESET;
        }

        else if (player == 0 && num == 1) {
            return YELLOW + "[ P ]" + RESET;
        }

        else if (computer == 0 && num == 1) {
            return RED + "[ C ]" + RESET;
        }

        else if (num == player && num == computer) {
            return BLUE + "[PC ]" + RESET;
        }

        else if (num == player) {
            return YELLOW + "[ P ]" + RESET;
        }

        else if (num == computer) {
            return RED + "[ C ]" + RESET;
        }

        else if (snakes.containsKey(num)) {
            return RED + String.format("[S:%02d]", snakes.get(num)) + RESET;
        }

        else if (ladders.containsKey(num)) {
            return GREEN + String.format("[L:%02d]", ladders.get(num)) + RESET;
        }

        else {
            return String.format("[%03d]", num);
        }
    }

    static String padCell(String cell) {
        String plainText = cell
                .replace(RED, "")
                .replace(GREEN, "")
                 .replace(YELLOW, "")
                .replace(BLUE, "")
                .replace(RESET, "");

        int visibleLength = plainText.length();
        int padding = Math.max(0, 7 - visibleLength);
        return cell + " ".repeat(padding) + " ";
    }
}