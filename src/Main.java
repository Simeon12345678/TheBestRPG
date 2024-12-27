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

}
