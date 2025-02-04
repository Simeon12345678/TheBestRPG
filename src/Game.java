import java.util.Scanner;
import java.util.ArrayList;

public class Game {
    private final Scanner in = new Scanner(System.in);
    private ArrayList<Character> party = new ArrayList<>();
    private ArrayList<Monster> enemyParty = new ArrayList<>();
    private final Utils<Integer> utils = new Utils<>();

    private int round = 1;

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


    public void run() {
        boolean whileWindowShouldClose = true;
        initBeginning();
        String charName = name();
        String charWeapon = selectWeapon();
        Player MainPlayer = new Player(charName, charWeapon);
        party.add(MainPlayer);
        selectPartners();
        addMonsters(enemyParty, 0);
        initiative();

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
        System.out.println(ANSI_CYAN + "Create your character!" + ANSI_RESET);
        while (true) {
            try {
                System.out.print("Write a name: ");
                ans = in.nextLine();
                name = ans;
                break;
            } catch (Exception e) {
                System.err.println("ERROR INVALID " + e);
            }
        }
        return name;
    }


    public String selectWeapon() {
        int ansInt;
        String currentWeapon = "default";
        while(true) {
            try {
                System.out.println("Select a weapon\n Axe : 1\n Sword : 2\n Bow : 3\n Pike : 4\n");
                System.out.print("Type the number after the weapon to select: ");
                ansInt = in.nextInt();
                if (ansInt <= 0 || ansInt >= 5) {
                    throw new ArithmeticException("Please select a number between 1 and 4");
                }
                switch (ansInt) {
                    case 1:
                        currentWeapon = "Axe";
                        System.out.println("Selected the Axe!");
                        break;
                    case 2:
                        currentWeapon = "Sword";
                        System.out.println("Selected the Sword");
                        break;
                    case 3:
                        currentWeapon = "Bow";
                        System.out.println("Selected the Bow");
                        break;
                    case 4:
                        currentWeapon = "Pike";
                        System.out.println("Selected the Pike");
                        break;
                }
                break;
            } catch(Exception e) {
                in.nextLine();
                System.err.println("ERROR INVALID " + e);
            }
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
        int ansInt;
        String ans;
        while (true) {
            try {
                System.out.println("\n\n\nNo party is complete with only one member. (duh)\nSo create 2 friends or have us do it for you.\n make my own : 1\n you do it : 2");
                System.out.print("Type the number after the choice to select: ");
                ansInt = in.nextInt();
                if (ansInt == 1) {

                    for (int i = 0; i < 2; i++) {
                        System.out.println(ANSI_CYAN + "\n\n\n\n\n---[Partner " + (i + 1) + "]---" + ANSI_BLACK);
                        System.out.println("Do you want a fighter or sorcerer. \nFighter: 1 \nSorcerer: 2");
                        System.out.print("type the number after the choice to select: ");
                        ansInt = in.nextInt();
                        in.nextLine();
                        System.out.print("Type a name for your partner: ");
                        ans = in.nextLine();
                        String name = ans;
                        initNpcClass(name, ansInt);
                    }
                    break;

                } else if (ansInt == 2) {
                    initNpcClass("default", utils.generateRandomNumber(1, 2));
                    initNpcClass("default", utils.generateRandomNumber(1, 2));
                    break;
                } else {
                    System.err.println("Invalid choice");
                }
                System.out.println("Ok so you got: \n" + party.get(1).getName() + " the " + party.get(1).getNpcType() + "\n" + party.get(2).getName() + " the " + party.get(2).getNpcType());
            } catch (Exception e) {
                in.nextLine();
                System.err.println("ERROR INVALID " + e);
            }
        }

    }

    public void initiative() {
        int first = utils.generateRandomNumber(1, 6);
        if (first > 3) {
            System.out.println(ANSI_GREEN + "The player and their party will go first!" + ANSI_RESET);
        } else {
            System.out.println(ANSI_RED + "The enemies will go first!" + ANSI_RESET);
        }
    }

    public void playerTurn() {
        System.out.println("Options\n Fight : 1\n Inventory : 2");
        String ans = in.nextLine();
        if (ans.equalsIgnoreCase("1")) {
            System.out.println("Options\nAttack : 1\nMulti Attack : 2\nSpecial: 3\nGuard: 4\nBack : 5");
        } else {

        }
    }

    public void enemyTurn() {

    }

    // generates an opposing party of enemies to battle
    // based on roundDifficulty an array will be made with numbers through (0-2 for now)
    // higher difficulty means harder enemies ie more 1's than 0's to get evil knights over slimes
    // TODO make roundDifficulty affect size
    public int[] addMonstersAlgorithm(ArrayList<Monster> arr, int roundDifficulty) {
        int size = 10 + roundDifficulty;
        int selection[] = new int[size];
        for (int i = 0; i < selection.length - 1; i++) {
            int rand = utils.generateRandomNumber(0, 2);
            if ((utils.generateRandomNumber(0, 16) + roundDifficulty) >= 16) { // 1 in 16 chance to up enemy difficulty higher odds per roundDiff
                if (rand + 1 == 3) {
                    selection[i] = 2;
                } else {
                    selection[i] = rand + 1;
                }
            } else {
                selection[i] = rand;
            }
        }
        return selection;
    }

    public void addMonsters(ArrayList<Monster> arr, int roundDifficulty) {
        int size = 10 + roundDifficulty;

        for (int i = 0; i < 3; i++) {
            int selection[] = addMonstersAlgorithm(enemyParty, roundDifficulty);
            Utils.insertionSort(selection);
            int choice = selection[size / 2]; // find median
            switch (choice) {
                case 0:
                    Slime slime = new Slime();
                    arr.add(slime);
                    break;
                case 1:
                    EvilKnight evilKnight = new EvilKnight();
                    arr.add(evilKnight);
                    break;
                case 2:
                    Wraith wraith = new Wraith();
                    arr.add(wraith);
                    break;
            }
        }
        System.out.println("you will be fighting " + enemyParty + " for round 1");
    }

}
