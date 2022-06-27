public class Goblin {

    int strength = 10;

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    int health = 10;
    String stamina;
    String name;

    public Goblin() {
        this.health = 10;
    }
    public Goblin(int strength){
        this.strength = strength;
    }


    public int getStrength() {
        return strength;
    }

    //mine
    public Object attack(Object other){
        int attackPower = (int) (Math.random() * this.getStrength());
        System.out.println("Hitting with " + attackPower + " attack power!");
        Human h = (Human) other;
        if (h.getHealth() <= attackPower) {
            //killed human, turned into land
            other = new Land();
            System.out.println("Killed the Human!!");
        }
        //attack
        else {
            //reduce human health
            h.setHealth(h.getHealth() - attackPower);
            other = h;
            System.out.println("Smacked him, but he's still standing! Health: " + h.getHealth());
        }
        return other;
    }

    @Override
    public String toString() {
        return "\uD83D\uDC7A";
    }
}


