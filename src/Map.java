import java.util.ArrayList;
import java.util.List;

public class Map {
    Object [][] gameBoard = {
            {new Land(), new Land(), new Goblin(), new Human(3,0), new Goblin(), new Land(), new Land(), new Land(), new Land()},
            {new Land(), new Land(), new Land(), new Land(), new Land(), new Land(), new Land(), new Land(), new Land()},
            {new Land(), new Land(), new Land(), new Land(), new Land(), new Land(), new Land(), new Land(), new Land()},
            {new Land(), new Land(), new Land(), new Land(), new Land(), new Land(), new Land(), new Land(), new Land()},
            {new Land(), new Land(), new Land(), new Land(), new Land(), new Land(), new Land(), new Land(), new Land()},
            {new Land(), new Land(), new Land(), new Land(), new Land(), new Land(), new Land(), new Land(), new Land()},
            {new Land(), new Land(), new Land(), new Land(), new Land(), new Land(), new Land(), new Land(), new Land()},
            {new Land(), new Land(), new Land(), new Land(), new Land(), new Land(), new Land(), new Land(), new Land()},
            {new Land(), new Land(), new Land(), new Land(), new Land(), new Land(), new Land(), new Land(), new Land()},
            {new Land(), new Land(), new Land(), new Goblin(), new Goblin(), new Land(), new Land(), new Land(), new Land(true)}
    };
            public void printMap() {
                for (int i = 0; i < gameBoard.length; i++) {
                    for (int j = 0; j < gameBoard[i].length; j++) {
                        System.out.print(gameBoard[i][j].toString() + "\t");
                    }
                    System.out.println("\n");
                }
            }

    }





















