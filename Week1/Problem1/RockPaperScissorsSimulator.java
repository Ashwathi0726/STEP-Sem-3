import java.util.Random;
import java.util.Scanner;

public class RockPaperScissorsSimulator {

    
    public static String playRound(String playerMove, String computerMove) {
        playerMove = playerMove.trim().toLowerCase();
        computerMove = computerMove.trim().toLowerCase();

        if (playerMove.equals(computerMove)) {
            return "Draw";
        }

        if ((playerMove.equals("rock") && computerMove.equals("scissors")) ||
            (playerMove.equals("paper") && computerMove.equals("rock")) ||
            (playerMove.equals("scissors") && computerMove.equals("paper"))) {
            return "Player Wins";
        } else {
            return "Computer Wins";
        }
    }

    public static void main(String[] args) {
        int totalRounds = 5;
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        String[] choices = {"Rock", "Paper", "Scissors"};
        
        
        String[] roundHistory = new String[totalRounds];
        String[] playerMovesHistory = new String[totalRounds];
        String[] computerMovesHistory = new String[totalRounds];
        String[] resultsHistory = new String[totalRounds];

        int wins = 0;
        int losses = 0;
        int draws = 0;

        System.out.println("=== Welcome to The College Coding Arcade! ===");
        System.out.println("Playing " + totalRounds + " rounds of Rock-Paper-Scissors.\n");

        for (int i = 0; i < totalRounds; i++) {
            System.out.print("Round " + (i + 1) + " - Enter your move (Rock, Paper, or Scissors): ");
            String playerMove = scanner.nextLine();

           
            String formattedPlayerMove = playerMove.trim();
            if (!formattedPlayerMove.equalsIgnoreCase("Rock") && 
                !formattedPlayerMove.equalsIgnoreCase("Paper") && 
                !formattedPlayerMove.equalsIgnoreCase("Scissors")) {
                System.out.println("Invalid move! Defaulting to Rock.");
                formattedPlayerMove = "Rock";
            }

            
            String computerMove = choices[random.nextInt(choices.length)];

            
            String result = playRound(formattedPlayerMove, computerMove);

            
            if (result.equals("Player Wins")) {
                wins++;
            } else if (result.equals("Computer Wins")) {
                losses++;
            } else {
                draws++;
            }

            roundHistory[i] = "Round " + (i + 1);
            playerMovesHistory[i] = formattedPlayerMove;
            computerMovesHistory[i] = computerMove;
            resultsHistory[i] = result;

            System.out.println("Computer chose: " + computerMove);
            System.out.println("Result: " + result + "\n");
        }

        scanner.close();

       
        System.out.println("\n--- Summary Table ---");
        System.out.printf("%-10s | %-12s | %-14s | %s\n", "Round", "Player Move", "Computer Move", "Result");
        System.out.println("---------------------------------------------------------");
        for (int i = 0; i < totalRounds; i++) {
            System.out.printf("%-10s | %-12s | %-14s | %s\n", 
                    roundHistory[i], playerMovesHistory[i], computerMovesHistory[i], resultsHistory[i]);
        }

        
        double winPercentage = ((double) wins / totalRounds) * 100.0;

        
        System.out.println("\n--- Final Summary (after " + totalRounds + " rounds) ---");
        System.out.printf("Wins: %d | Losses: %d | Draws: %d | Win %% = %.1f%%\n", 
                wins, losses, draws, winPercentage);
    }
}
