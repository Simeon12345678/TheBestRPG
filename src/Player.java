public class Player extends Character {
    private String weapons[] = {"Axe", "Sword", "Bow", "Pike"};
    private String currentWeapon;
    private boolean canMultiHit;
    private boolean canChargeAttack;

    Player(String inName, String weapon) {
        hp = 150;
        def = 10;
        name = inName;
        currentWeapon = weapon;
        if (currentWeapon.equals(weapons[0])) { // axe
            atk = 70;
            canChargeAttack = true;
            canMultiHit = false;
        } else if (currentWeapon.equals(weapons[1])) { // sword
            atk = 50;
            canChargeAttack = false;
            canMultiHit = true;
        } else if (currentWeapon.equals(weapons[2])) { // bow
            atk = 60;
            canChargeAttack = true;
            canMultiHit = false;
        } else { // pike
            atk = 40;
            canChargeAttack = true;
            canMultiHit = true;
        }
    }
}