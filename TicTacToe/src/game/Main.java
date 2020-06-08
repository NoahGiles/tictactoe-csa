package game;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int playerLocation, computerLocation;
        boolean spotTaken, winner = true, playAgain = true;
        int count = 0;
        String theWinner = "";
        System.out.println("Would you like to play Tic Tac Toe? : (1 for yes, 0 for no)");
        while (playAgain == true) {
            int choice = input.nextInt();
            if (choice == 1) {
                playAgain = true;
                ArrayList<String> location = new ArrayList<>();
                Board.populateArraySizeToString(location);
                Board.displayBoard(location);
                while (winner) {
                    if (count % 2 == 0) {
                        do {
                            spotTaken = true;
                            System.out.println("\nPlayer's turn!\nChoose a location : (1 through 9)");
                            playerLocation = input.nextInt();
                            if (location.get(playerLocation).equals("O") || location.get(playerLocation).equals("X")) {
                                System.out.println("That spot is not available.");
                            } else {
                                location.set(playerLocation, "X");
                                spotTaken = false;
                            }
                        } while (spotTaken == true);
                    } else if (count % 2 != 0) {
                        System.out.println("\nComputer's turn!");
                        spotTaken = true;
                        while (spotTaken == true) {
                            computerLocation = (int) (Math.random() * 9 + 1);
                            if (location.get(computerLocation).equals("O") || location.get(computerLocation).equals("X")) {
                            } else {
                                location.set(computerLocation, "O");
                                spotTaken = false;
                            }
                        }
                        System.out.println("\n");
                    }
                    Board.displayBoard(location);
                    count++;
                    if (location.get(1).equals("X") && location.get(2).equals("X") && location.get(3).equals("X") ||
                            location.get(5).equals("X") && location.get(6).equals("X") && location.get(7).equals("X") ||
                            location.get(7).equals("X") && location.get(8).equals("X") && location.get(9).equals("X") ||
                            location.get(1).equals("X") && location.get(4).equals("X") && location.get(7).equals("X") ||
                            location.get(2).equals("X") && location.get(5).equals("X") && location.get(8).equals("X") ||
                            location.get(3).equals("X") && location.get(6).equals("X") && location.get(9).equals("X") ||
                            location.get(1).equals("X") && location.get(5).equals("X") && location.get(9).equals("X") ||
                            location.get(3).equals("X") && location.get(5).equals("X") && location.get(7).equals("X")) {
                        theWinner = "Player";
                    } else if (location.get(1).equals("O") && location.get(2).equals("O") && location.get(3).equals("O") ||
                            location.get(4).equals("O") && location.get(5).equals("O") && location.get(6).equals("O") ||
                            location.get(7).equals("O") && location.get(8).equals("O") && location.get(9).equals("O") ||
                            location.get(1).equals("O") && location.get(4).equals("O") && location.get(7).equals("O") ||
                            location.get(2).equals("O") && location.get(5).equals("O") && location.get(8).equals("O") ||
                            location.get(3).equals("O") && location.get(6).equals("O") && location.get(9).equals("O") ||
                            location.get(1).equals("O") && location.get(5).equals("O") && location.get(9).equals("O") ||
                            location.get(3).equals("O") && location.get(5).equals("O") && location.get(7).equals("O")) {
                        theWinner = "Computer";
                    } else {
                        System.out.println("\nNo winner yet.");
                    }

                    if (theWinner == "Player") {
                        System.out.println("\nPlayer wins!");
                        winner = false;
                    } else if (theWinner == "Computer") {
                        System.out.println("\nComputer wins!");
                        winner = false;
                    } else if (count == 9) {
                        System.out.println("\nIt's a tie!");
                        winner = false;
                    }

                }
                winner = true;
                theWinner = null;
                count = 0;
                System.out.println("Would you like to play again? (1 for yes, 0 for no)");
            }
        else
        {

            System.out.println("Goodbye!");
            playAgain = false;
        }
    }



    }

}
