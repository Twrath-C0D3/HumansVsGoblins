
    public class Human extends Object {
        String p = "\uD83D\uDE2C";
        private int agility = 0;
        private int strength = 10;
        private int health = 100;

        public int getRow() {
            return row;
        }

        public void setRow(int row) {
            this.row = row;
        }

        public int getColumn() {
            return column;
        }

        public void setColumn(int column) {
            this.column = column;
        }

        private int row = 0;

        private int column = 0;

        // Default Constructor
        public Human() {
        }

        public Human(int column, int row) {
            this.column = column;
            this.row = row;
        }

        public Human(int agility, int strength,int health) {
            this.agility = agility;
            this.strength = strength;;
            this.health = health;

        }

        public int getHealth() {
            return health;
        }

        public void setHealth(int health) {
            this.health = health;
        }

        public int getStrength() {
            return strength;
        }

        public void setStrength(int strength) {
            this.strength = strength;
        }


        public Object attack(Object o){

            //generate attack power based on strength
            int attackPower = (int) (Math.random() * this.getStrength());
            System.out.println("Hitting with " + attackPower + " attack power!");
            Goblin g = (Goblin) o;
            //kill
            if (g.getHealth() <= attackPower) {
                //killed goblin, turned into land
                o = new Land();
                System.out.println("Killed the goblin!!");
            }
            //attack
            else {
                //reduce goblin health
                g.setHealth(g.getHealth() - attackPower);
                o = g;
                System.out.println("Smacked him, but he's still standing! Health: " + g.getHealth());
            }
            return o;
        }


        public boolean checkForGoblins(Object[][] gameBoard) {
            boolean goblinsAround = false;
            //looking for goblin either U/D/L/R
            if (this.getRow() > 0) {
                Object u = gameBoard[row - 1][column];
                if (u instanceof Goblin) {
                    System.out.println("found goblin at " + (row - 1) + ":" + column + " attacking!!");
                    Object o = attack(u);
                    if (o instanceof Goblin) {
                        Goblin g = (Goblin) o;
                        Object go = g.attack(this);
                        if (go instanceof Human) {
                            Human temp = (Human) go;
                            this.setHealth(temp.getHealth());
                        }
                        if (this.getHealth() > 0 ){
                            goblinsAround = true;
                        }
                    }
                    gameBoard[row-1][column] = o;
                }
            }
            if (this.getRow() < 9) {
                Object d = gameBoard[row + 1][column];
                if (d instanceof Goblin) {
                    System.out.println("found goblin at " + (row + 1) + ":" + column + " attacking!!");
                    Object o = attack(d);
                    if (o instanceof Goblin) {
                        Goblin g = (Goblin) o;
                        Object go = g.attack(this);
                        if (go instanceof Human) {
                            Human temp = (Human) go;
                            this.setHealth(temp.getHealth());
                        }
                        if (this.getHealth() > 0 ){
                            goblinsAround = true;
                        }
                    }
                    gameBoard[row + 1][column] = o;
                }
            }
            if (this.getColumn() > 0) {
                Object l = gameBoard[row][column - 1];
                if (l instanceof Goblin) {
                    System.out.println("found goblin at " + row + ":" + (column - 1) + " attacking!!");
                    Object o = attack(l);
                    if (o instanceof Goblin) {
                        Goblin g = (Goblin) o;
                        Object go = g.attack(this);
                        if (go instanceof Human) {
                            Human temp = (Human) go;
                            this.setHealth(temp.getHealth());
                        }
                        if (this.getHealth() > 0 ){
                            goblinsAround = true;
                        }
                    }
                    gameBoard[row][column - 1] = o;
                }
            }
            if (this.getColumn() < 8) {
                Object r = gameBoard[row][column + 1];
                if (r instanceof Goblin) {
                    System.out.println("found goblin at " + row + ":" + (column + 1) + " attacking!!");
                    Object o = attack(r);
                    if (o instanceof Goblin) {
                        Goblin g = (Goblin) o;
                        Object go = g.attack(this);
                        if (go instanceof Human) {
                            Human temp = (Human) go;
                            this.setHealth(temp.getHealth());
                        }
                        if (this.getHealth() > 0 ){
                            goblinsAround = true;
                        }
                    }
                    gameBoard[row][column + 1] = o;
                }
            }

            return goblinsAround;
        }


        //aye yo for goblins take out the input switch on randnumgen 1-4
        public boolean move(String input, Map displayMap) {
            boolean hasReachedPromisedLand = false;
            int i = this.row;
            int j = this.column;
            switch (input) {
                case "w":
                    Land lw = (Land) displayMap.gameBoard[i-1][j];
                    if (lw.isPromisedLand()) {
                        hasReachedPromisedLand = true;

                    }
                    displayMap.gameBoard[i-1][j] = this;
                    this.setColumn(j);
                    this.setRow(i-1);
                    displayMap.gameBoard[i][j] = new Land();
                    break;
                case "a":
                    Land la = (Land) displayMap.gameBoard[i][j-1];
                    if (la.isPromisedLand()) {
                        hasReachedPromisedLand = true;

                    }
                    displayMap.gameBoard[i][j-1] = this;
                    this.setColumn(j-1);
                    this.setRow(i);
                    displayMap.gameBoard[i][j] = new Land();
                    break;
                case "s":
                    Land ls = (Land) displayMap.gameBoard[i+1][j];
                    if (ls.isPromisedLand()) {
                        hasReachedPromisedLand = true;

                    }
                    displayMap.gameBoard[i+1][j] = this;
                    this.setColumn(j);
                    this.setRow(i+1);
                    displayMap.gameBoard[i][j] = new Land();
                    break;
                case "d":
                    Land ld = (Land) displayMap.gameBoard[i][j+1];
                    if (ld.isPromisedLand()) {
                        hasReachedPromisedLand = true;

                    }
                    displayMap.gameBoard[i][j+1] = this;
                    this.setColumn(j+1);
                    this.setRow(i);
                    displayMap.gameBoard[i][j] = new Land();
                    break;
                default:
                    System.out.println("Can't move in that direction!");
                    break;
            }
            //System.out.println("Moved to " + this.row + ":" + this.column + ". Reached the promised land? " + hasReachedPromisedLand);
            return hasReachedPromisedLand;
        }

        @Override
        public String toString() {


            return "\uD83D\uDE2C";
        }

    }


