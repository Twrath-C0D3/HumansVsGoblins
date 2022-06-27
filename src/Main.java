import java.util.Locale;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Map displayMap = new Map();
        Scanner playerInput = new Scanner(System.in);
        boolean running = true;
        System.out.println("W = north\nS= south\nA= west\nD= east");
        boolean hasReachedPromisedLand = false;


        //assumptions:
        //- only one human
        //- human can only move once
        //- need to still move all the goblins
        //- humans look for goblins
        //- goblins ignore humans
        displayMap.printMap();
        while (running){
            boolean humanHasMoved = false;
            System.out.println("\n");
            //main game logic (movement, finding enemies, end state)
            for (int i = 0; i < displayMap.gameBoard.length; i++) {
                for (int j = 0; j < displayMap.gameBoard[i].length; j++) {
                    Object o = displayMap.gameBoard[i][j];
                    if (o instanceof Human && !humanHasMoved) {
                        Human h = (Human) o;
                        boolean goblinsAround = h.checkForGoblins(displayMap.gameBoard);
                        while (goblinsAround) {
                            goblinsAround = h.checkForGoblins(displayMap.gameBoard);
                        }
                        if (h.getHealth() > 0) {
                            System.out.println("Your health is " + h.getHealth());
                            displayMap.printMap();
                            //ask for input
                            //move
                            System.out.println("No goblins around, let's move! [W/S/A/D]");
                            String input = playerInput.nextLine().toLowerCase();

                            hasReachedPromisedLand = h.move(input, displayMap);
                            //move goblins randomly
                        } else {
                            //we died
                            System.out.println("you done died");
                            hasReachedPromisedLand = true;
                        }
                        humanHasMoved = true;
                    } else if (o instanceof Goblin) {


                    }
                }
            }

            if (hasReachedPromisedLand) {
                displayMap.printMap();
                System.out.println("You made it! Enjoy a nice refreshing Coca-Cola... today's sponsor!");
                running = false;
            }



            }



        }
    }

//}
