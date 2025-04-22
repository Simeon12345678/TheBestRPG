import java.util.ArrayList;
import java.util.Scanner;

public class Player extends Character {
    private String weapons[] = {"Axe", "Sword", "Bow", "Pike"};
    private String currentWeapon;
    private String previousAtk;
    private boolean canMultiHit;
    private boolean canChargeAttack;
    private boolean isCharging = false;

    private Scanner in = new Scanner(System.in);

    Player(String inName, String weapon) {
        super(inName, "player", 150, 20, 15, 5);
        currentWeapon = weapon;
        if (currentWeapon.equals(weapons[0])) { // axe
            this.atk = 70;
            this.canChargeAttack = true;
            this.canMultiHit = false;
        } else if (currentWeapon.equals(weapons[1])) { // sword
            this.atk = 50;
            this.canChargeAttack = false;
            this.canMultiHit = true;
        } else if (currentWeapon.equals(weapons[2])) { // bow
            this.atk = 60;
            this.canChargeAttack = true;
            this.canMultiHit = false;
        } else { // pike
            this.atk = 40;
            this.canChargeAttack = true;
            this.canMultiHit = true;
        }
    }
    @Override
    public void guard(String name, String npcType) {
        isGuarding = true;
        System.out.println("You have raised your weapon and are ready to receive the next blow.\nNext hits damage will be reduced");
    }

    public void resetGuard() {
        isGuarding = false;
    }
    @Override
    public void attack(BaseNPC ms, String currentAtk) {
        ms.receiveDMG(atk, ms.getDef());
        System.out.println("You attack the " + ms.getName() + " the " + ms.getNpcType() + " with a great strike from your " + currentAtk + " and they took " + (atk - ms.getDef()) + " damage");
    }

    @Override
    public void special(Monster ms) {
        if (canMultiHit && canChargeAttack) {
            System.out.println("Charge your attack or perform a multi attack?\n charge : 1\n multi : 2");
            System.out.print("choice:");
            String ans = in.nextLine();
            if (ans.equalsIgnoreCase("1")) {
                chargeAttack();
            } else {
                multiHit(ms);
            }
        } else if (canMultiHit) {
            multiHit(ms);
        } else {
            chargeAttack();
        }
    }

    @Override
    public void multiAttack(BaseNPC npc1, BaseNPC npc2) {
        npc1.receiveDMG(atk, npc1.getHP());
        npc2.receiveDMG(atk, npc2.getHP());
        System.out.println(npc1.getName() + " the " + npc1.getNpcType() + " and " + npc2.getName() + " the " + npc2.getNpcType() + " were both hit by your area attack and took " + (atk - npc1.getDef()) + " and " + (atk - npc2.getDef()) + " respective damage!");
    }

    public void multiHit(Monster ms) {
        int currentAtk = (int)(atk * 0.4);
        System.out.println("unleashing multiple weaker hits!");
        int hits = utils.generateRandomNumber(1, 4);
        int totalDmg = atk * hits;
        for (int i = 0; i < hits; i++) {
            ms.receiveDMG(currentAtk, ms.getDef());
        }
        System.out.println(ms.getName() + " the " + ms.getNpcType() + " was hit a total of " + hits + " times and took " + totalDmg + " damage total!");
    }

    @Override
    public void chargeAttack() {
        System.out.println("You charge an attack readying it to be unleashed on the next turn");
        isCharging = true;
    }

    @Override
    public void unleashChargeAttack(Monster ms) {
        System.out.println("You finished charging!");
        ms.receiveDMG((atk + 50), ms.getDef());
        System.out.println(ms.getName() + " the " + ms.getNpcType() + " Was hit by your mighty attack and took " + ((atk + 40) - ms.getDef()) + " damage!");

        if (utils.generateRandomNumber(0, 16) == 16) {
            ms.setStatusEffect(statusEffects[2]);
            System.out.println(ms.getName() + " the " + ms.getNpcType() + " Was stunned by your mighty blow!");
        }
    }
}