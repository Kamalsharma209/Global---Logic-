import java.util.Scanner;

public class Hockey_Scores_Problem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome!");
        System.out.println("Enter the name of team 1.");
        String teamOne = scanner.nextLine();
        System.out.println("Enter the name of team 2.");
        String teamTwo = scanner.nextLine();
        System.out.println("Enter hockey scores for seven games.");
        String scores = scanner.nextLine();
        System.out.println("Enter the number of power play goals for both teams in each game.");
        String powerPlay = scanner.nextLine();
        scanner.close();

        // Game scores parsing (from starter code)
        int currentScoreIndex = 0;
        int[] teamOneScores = new int[7];
        int[] teamTwoScores = new int[7];

        for (int i = 0; i < 7; i++) {
            teamOneScores[i] = Integer.parseInt(scores.substring(currentScoreIndex, currentScoreIndex + 2));
            currentScoreIndex += 3;
            teamTwoScores[i] = Integer.parseInt(scores.substring(currentScoreIndex, currentScoreIndex + 2));
            currentScoreIndex += (i == 6 ? 2 : 3);
        }

        // Power play parsing (from starter code)
        int currentPowerPlayIndex = 0;
        int[] teamOnePP = new int[7];
        int[] teamTwoPP = new int[7];

        for (int i = 0; i < 7; i++) {
            teamOnePP[i] = Integer.parseInt(powerPlay.substring(currentPowerPlayIndex, currentPowerPlayIndex + 2));
            currentPowerPlayIndex += 3;
            teamTwoPP[i] = Integer.parseInt(powerPlay.substring(currentPowerPlayIndex, currentPowerPlayIndex + 2));
            currentPowerPlayIndex += (i == 6 ? 2 : 3);
        }

        // Variables to track results
        int teamOneWins = 0, teamTwoWins = 0;
        int totalGoalsOne = 0, totalGoalsTwo = 0;
        int totalPPGoalsOne = 0, totalPPGoalsTwo = 0;
        int shutoutsOne = 0, shutoutsTwo = 0;

        int maxGoals = -1;
        String maxTeam = "";
        int maxGame = 0;

        // Process all games
        for (int i = 0; i < 7; i++) {
            // Wins
            if (teamOneScores[i] > teamTwoScores[i]) {
                teamOneWins++;
            } else {
                teamTwoWins++;
            }

            // Totals
            totalGoalsOne += teamOneScores[i];
            totalGoalsTwo += teamTwoScores[i];
            totalPPGoalsOne += teamOnePP[i];
            totalPPGoalsTwo += teamTwoPP[i];

            // Shutouts
            if (teamTwoScores[i] == 0) shutoutsOne++;
            if (teamOneScores[i] == 0) shutoutsTwo++;

            // Max goals check
            if (teamOneScores[i] > maxGoals) {
                maxGoals = teamOneScores[i];
                maxTeam = teamOne;
                maxGame = i + 1;
            }
            if (teamTwoScores[i] > maxGoals) {
                maxGoals = teamTwoScores[i];
                maxTeam = teamTwo;
                maxGame = i + 1;
            }
        }

        // Series result
        String winner;
        int winnerWins, loserWins;
        if (teamOneWins > teamTwoWins) {
            winner = teamOne;
            winnerWins = teamOneWins;
            loserWins = teamTwoWins;
        } else {
            winner = teamTwo;
            winnerWins = teamTwoWins;
            loserWins = teamOneWins;
        }

        // Print outputs
        System.out.println("The " + winner + " won the series by a score of " + winnerWins + "-" + loserWins);
        System.out.println("The " + teamOne + " scored " + totalGoalsOne + " total goal" + (totalGoalsOne == 1 ? "" : "s"));
        System.out.println("The " + teamTwo + " scored " + totalGoalsTwo + " total goal" + (totalGoalsTwo == 1 ? "" : "s"));
        System.out.println("The " + teamOne + " scored " + totalPPGoalsOne + " power play goal" + (totalPPGoalsOne == 1 ? "" : "s"));
        System.out.println("The " + teamTwo + " scored " + totalPPGoalsTwo + " power play goal" + (totalPPGoalsTwo == 1 ? "" : "s"));
        System.out.println("The " + teamOne + " scored " + (totalGoalsOne - totalPPGoalsOne) + " standard goal" + ((totalGoalsOne - totalPPGoalsOne) == 1 ? "" : "s"));
        System.out.println("The " + teamTwo + " scored " + (totalGoalsTwo - totalPPGoalsTwo) + " standard goal" + ((totalGoalsTwo - totalPPGoalsTwo) == 1 ? "" : "s"));
        System.out.println("The " + teamOne + " recorded " + shutoutsOne + " shutout" + (shutoutsOne == 1 ? "" : "s"));
        System.out.println("The " + teamTwo + " recorded " + shutoutsTwo + " shutout" + (shutoutsTwo == 1 ? "" : "s"));
        System.out.println("The maximum number of goals scored was " + maxGoals + " by the " + maxTeam + " in game " + maxGame);
    }
}
