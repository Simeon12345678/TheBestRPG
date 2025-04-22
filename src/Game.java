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
        // initiative();
        System.out.println(party.get(1).getNpcType());
        System.out.println(party.get(2).getNpcType());
        fightSequence();
        // playerTurn();
    }

    public void fightSequence() {
        System.out.println("The battle begins and we roll initiative to see who goes first!\n round: " + round);

        while (true) {
            party.get(0).applyStatus();
            playerTurn();
            party.get(1).applyStatus();
            if (party.get(1).isDefeated) {
                System.out.println("unable to fight");
            } else {
                npcTurn(1);
            }

            party.get(2).applyStatus();
            if (party.get(2).isDefeated) {
                System.out.println("unable to fight");
            } else {
                npcTurn(2);
            }

            enemyParty.get(0).applyStatus();
            if (enemyParty.get(0).isDefeated) {
                System.out.println("the enemy is dead");
            } else {
                enemyTurn(0);
            }
            enemyParty.get(1).applyStatus();
            if (enemyParty.get(1).isDefeated) {
                System.out.println("the enemy is dead");
            } else {
                enemyTurn(1);
            }
            enemyParty.get(2).applyStatus();
            if (enemyParty.get(2).isDefeated) {
                System.out.println("the enemy is dead");
            } else {
                enemyTurn(2);
            }

            for (int i = 0; i < party.size(); i++) {
                if (party.get(i).getHP() <= 0) {
                    System.out.println(party.get(i).getName() + " the " + party.get(i).getNpcType() + " has fainted and will no longer be able to fight");
                    party.get(i).setDefeatStatus(true);
                }
            }

            for (int i = 0; i < enemyParty.size(); i++) {
                if (enemyParty.get(i).getHP() <= 0) {
                    System.out.println(enemyParty.get(i).getName() + " the " + enemyParty.get(i).getNpcType() + "has died!");
                    enemyParty.get(i).setDefeatStatus(true);
                }
            }

            if (party.get(0).getHP() <= 0) {
                System.out.println("You have died and thus lost the game");
                break;
            } else if (enemyParty.get(0).isDefeated && enemyParty.get(1).isDefeated && enemyParty.get(2).isDefeated) {
                System.out.println("All the enemies have died and your team has reached victory");
                break;
            }
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
        while (true) {
            try {
                System.out.println("Select a weapon\n Axe : 1\n Sword : 2\n Bow : 3\n Pike : 4\n");
                System.out.println("Information: The axe can do a charge attack as its special, the sword can do a multihit as its special, the bow can do a charge attack as its special and the pike can do both");
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
                        System.out.println(ANSI_CYAN + "\n\n\n\n\n---[Partner " + (i + 1) + "]---" + ANSI_RESET);
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

    public int initiative() {
        int first = utils.generateRandomNumber(1, 6);
        if (first > 3) {
            System.out.println(ANSI_GREEN + "The player and their party will go first!" + ANSI_RESET);
            playerTurn();
            npcTurn(1);
            npcTurn(2);
        } else {
            System.out.println(ANSI_RED + "The enemies will go first!" + ANSI_RESET);
            enemyTurn(0);
            enemyTurn(1);
            enemyTurn(2);
        }
        return first;
    }

    public void playerTurn() {
        while (true) {
            System.out.println("Options\nAttack : 1\nMulti Attack : 2\nSpecial: 3\nGuard: 4");
            System.out.print(":");
            int ans = in.nextInt();
            try {
                if (ans >= 5 || ans <= 0) {
                    throw new ArithmeticException("please select one of the listed numbers");
                }
                switch (ans) {
                    case 1:
                        // attack
                        party.get(0).attack(enemyParty.get(utils.generateRandomNumber(0, enemyParty.size() - 1)), "slash");
                        break;
                    case 2:
                        // multiattack 2x
                        int option1 = utils.generateRandomNumber(0, enemyParty.size() - 1); // first target monster
                        int option2 = utils.generateRandomNumber(0, enemyParty.size() -1); // second target monster
                        if (option2 == option1) { // so we don't hit the same one twice
                            if (option2 == 0) {
                                option2++; // prevent index out of bounds
                            } else {
                                option2--;
                            }
                        }
                        party.get(0).multiAttack(enemyParty.get(option1), enemyParty.get(option2));
                        break;
                    case 3:
                        // special (charge or multihit)
                        party.get(0).special(enemyParty.get(utils.generateRandomNumber(0, enemyParty.size() - 1)));
                        break;
                    case 4:
                        // guard
                        party.get(0).guard(party.get(0).getName(), party.get(0).getNpcType());
                        break;
                }
                break;
            } catch (Exception e) {
                in.nextLine();
                System.err.println("ERROR INVALID " + e);
            }
        }

    }

    public void npcTurn(int rotation) {
        int moves = party.get(rotation).numOfAtks; // determines possible usable moves

        party.get(rotation).selectAttacks(
            utils.generateRandomNumber(1, moves),
            party.get(utils.generateRandomNumber(0, (party.size() - 1))),
            enemyParty.get(utils.generateRandomNumber(0, enemyParty.size() - 1)),
            enemyParty.get(0),
            enemyParty.get(1),
            enemyParty.get(2)
        );

    }

    public void enemyTurn(int rotation) {
        int moves = enemyParty.get(rotation).numOfAtks;

        enemyParty.get(rotation).selectAttacks(
            utils.generateRandomNumber(1, moves),
            enemyParty.get(utils.generateRandomNumber(0, enemyParty.size() - 1)),
            party.get(utils.generateRandomNumber(0, enemyParty.size() - 1)),
            party.get(0),
            party.get(1),
            party.get(2)
        );
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
