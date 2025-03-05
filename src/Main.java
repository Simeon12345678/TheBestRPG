public class Main {
    public static void main(String[] args) {
        Game game = new Game();
        try {
            // the entire game bb
            game.run();
        } catch (Exception e) {
            System.err.println("See idk way too many things could have gone wrong " + e);
        }
    }

    // massive TODO (subject to change)
    // finish the basic rpg combat mechanic with enemy and party : priority
    // create inventory system for player to use mid battle : priority
    // generate maps just like the rogue video game if a bit simpler
    // add a possible god and hard mode that are unlocked upon first clear by writing to a file and reading from it at the start

}
