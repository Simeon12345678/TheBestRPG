import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        initBeginning(); // governs the pre battle phase
    }

    public static void initBeginning() {
        Scanner in = new Scanner(System.in);
        System.out.println("Welcome to the most epic turn-based text based rpg ever made!");
        System.out.println("Press any key to continue");
        String ans = in.nextLine();
        System.out.println("Create your character!");
        String name;
        String currentWeapon = "default";
        try {
            System.out.print("Write a name: ");
            ans = in.nextLine();
            name = ans;
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

            Player MainPlayer = new Player(name, currentWeapon);
        } catch (Exception e) {
            System.err.println("ERROR INVALID");
        }


    }
}