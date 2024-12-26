import java.util.Scanner;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        boolean whileWindowShouldClose = true;
        initBeginning();
        String charName = name();
        String charWeapon = getWeapon();
        Player MainPlayer = new Player(charName, charWeapon);
        while (!whileWindowShouldClose) {
            combatPhase(MainPlayer);
        }
    }

    public static void initBeginning() {
        Scanner in = new Scanner(System.in);
        System.out.println("Welcome to the best and most epic rpg ever made!\nPress any key to continue");
        String ans = in.nextLine();
    }

    public static String name() {
        Scanner in = new Scanner(System.in);
        String ans;
        String name = "default";
        System.out.println("Create your character!");
        try {
            System.out.print("Write a name: ");
            ans = in.nextLine();
            name = ans;
        } catch (Exception e) {
            System.err.println("ERROR INVALID");
        }
        return name;
    }

    public static String getWeapon() {
        Scanner in = new Scanner(System.in);
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
            System.err.println("ERROR INVALID");
        }

        return currentWeapon;
    }

    public static void selectPartners() {
        Scanner in = new Scanner(System.in);
        String ans;
        try {
            System.out.println("No party is complete with only one member. (duh)\nSo create some friends or have us do it for you.\n make my own : 1\n you do it : 2");
            System.out.print("Type the number after the choice to select: ");
            ans = in.nextLine();
            if (ans.equalsIgnoreCase("1")) {
                // code goes here
            } else if (ans.equalsIgnoreCase("2")) {

            } else {
                System.err.println("Invalid choice");
            }
        } catch (Exception e) {
            System.err.println("ERROR INVALID");
        }
    }

    public static ArrayList enemySelection() {
        ArrayList<Monster> enemyList = new ArrayList<>();

        return enemyList;
    }

    public static void combatPhase(Player player) {

    }
}
