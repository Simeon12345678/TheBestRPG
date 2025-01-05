import java.util.Scanner;
import java.util.ArrayList;

public class Game {
    private final Scanner in = new Scanner(System.in);
    private ArrayList<Character> party = new ArrayList<>();
    private ArrayList<Monster> enemyParty = new ArrayList<>();

    // colors
    private final String ANSI_RESET = "\u001B[0m";
    private final String ANSI_BLACK = "\u001B[30m";
    private final String ANSI_RED = "\u001B[31m";
    private final String ANSI_GREEN = "\u001B[32m";
    private final String ANSI_YELLOW = "\u001B[33m";
    private final String ANSI_BLUE = "\u001B[34m";
    private final String ANSI_PURPLE = "\u001B[35m";
    private final String ANSI_CYAN = "\u001B[36m";

    // background colors


    Character npc1 = new Character();
    Character npc2 = new Character();

    public void run() {
        boolean whileWindowShouldClose = true;
        initBeginning();
        String charName = name();
        String charWeapon = getWeapon();
        Player MainPlayer = new Player(charName, charWeapon);
        party.add(MainPlayer);
        selectPartners();



        while (!whileWindowShouldClose) {
        }
    }

    public void initBeginning() {
        System.out.println(ANSI_PURPLE + "Welcome to the best and most epic rpg ever made!\nPress any key to continue" + ANSI_RESET);
        String ans = in.nextLine();
    }

    public String name() {
        String ans;
        String name = "default";
        System.out.println("Create your character!");
        try {
            System.out.print("Write a name: ");
            ans = in.nextLine();
            name = ans;
        } catch (Exception e) {
            System.err.println("ERROR INVALID " + e);
        }
        return name;
    }

    public String getWeapon() {
        String ans;
        String currentWeapon = "default";
        try {
            System.out.println("Select a weapon\n Axe : 1\n Sword : 2\n Bow : 3\n Pike : 4\n");
            System.out.print("Type the number after the weapon to select: ");
            ans = in.nextLine();
            switch (ans) {
                case "1":
                    currentWeapon = "Axe";
                    System.out.println("Selected the Axe!");
                    break;
                case "2":
                    currentWeapon = "Sword";
                    System.out.println("Selected the Sword");
                    break;
                case "3":
                    currentWeapon = "Bow";
                    System.out.println("Selected the Bow");
                    break;
                case "4":
                    currentWeapon = "Pike";
                    System.out.println("Selected the Pike");
                    break;
                default:
                    System.err.println("Invalid input");
                    break;
            }
        } catch(Exception e) {
            System.err.println("ERROR INVALID " + e);
        }

        return currentWeapon;
    }

    // randomly chooses partner for user
    public void initNpcClass(String name, int selection) {
        if (selection == 1) {
            Fighter fight = new Fighter(name);
            party.add(fight);
        } else {
            Sorcerer sorcerer = new Sorcerer(name);
            party.add(sorcerer);
        }
    }

    public void selectPartners() {
        Scanner in = new Scanner(System.in);
        String ans;
        try {
            System.out.println("\n\n\nNo party is complete with only one member. (duh)\nSo create 2 friends or have us do it for you.\n make my own : 1\n you do it : 2");
            System.out.print("Type the number after the choice to select: ");
            ans = in.nextLine();
            if (ans.equalsIgnoreCase("1")) {
                for (int i = 0; i < 2; i++) {
                    System.out.println("\n\n\n\n\n---[Partner " + (i + 1) + "]---");
                    System.out.println("Do you want a fighter or sorcerer. \nFighter: 1 \nSorcerer: 2");
                    System.out.print("type the number after the choice to select: ");
                    ans = in.nextLine();
                    int selection = Integer.parseInt(ans);
                    System.out.print("Type a name for your partner: ");
                    ans = in.nextLine();
                    String name = ans;
                    initNpcClass(name, selection);
                }
            } else if (ans.equalsIgnoreCase("2")) {
                initNpcClass("default", (int)(Math.random() * 2 + 1));
                initNpcClass("default", (int)(Math.random() * 2 + 1));
            } else {
                System.err.println("Invalid choice");
            }
            System.out.println("Ok so you got: \n" + party.get(1).getName() + " the " + party.get(1).getCharType() + "\n" + party.get(2).getName() + " the " + party.get(2).getCharType());
        } catch (Exception e) {
            System.err.println("ERROR INVALID " + e);
        }
    }

    public void addMonsters(ArrayList<Monster> arr, int roundDifficulty) {

    }


}
