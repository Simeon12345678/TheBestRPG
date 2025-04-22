// moveset
// charge attack
// normal attack
// fire buff

public class EvilKnight extends Monster {
    private final String names[] = {"Sauron", "Morgoth", "Raime", "Messmer", "Mirae", "Boralis", "Velstadt"};
    private final String possibleAttackNames[] = {"Slash", "Stab", "Double rend"};
    private int swordBuff = 0;
    private boolean isCharging = false;

    EvilKnight() {
        super("default", "Evil Knight", 60, 50, 20, 3);
        this.name = names[utils.generateRandomNumber(0, names.length - 1)];
    }

    public void attack(Character ch) {
        checkBuffStatus();
        int currentAttack;
        if (ch.getGuardStatus()) {
            currentAttack = atk - ch.getGuard();
        } else {
            currentAttack = atk;
        }

        ch.receiveDMG(currentAttack, ch.getDef());
        System.out.println(ch.getName() + " was hit by " + name + " the " + npcType + " and took " + (currentAttack - ch.getDef() + " damage!"));


        if (utils.generateRandomNumber(0, 16) == 16 && swordBuff > 0) {
            ch.setStatusEffect(statusEffects[0]);
            System.out.println(ch.getName() + " Was burned by the knights blade!");
            swordBuff--;
        }
    }

    public void chargeAttack() {
        System.out.println(name + " the " + npcType + " is charging an attack! It will be unleashed next turn.");
        isCharging = true;
    }

    public void unleashChargeAttack(Character ch, int currentAttack) {
        checkBuffStatus();
        System.out.println(name + "Finished charging!");
        ch.receiveDMG((currentAttack + 40), ch.getDef());
        System.out.println(ch.getName() + " Was hit by the mighty attack and took " + ((atk + 40) - ch.getDef()) + " damage!");

        if (utils.generateRandomNumber(0, 16) == 16 && swordBuff > 0) {
            ch.setStatusEffect(statusEffects[0]);
            System.out.println(ch.getName() + " Was burned by the knights blade!");
            swordBuff--;
        }
        isCharging = false;
    }

    public void imbueSwordWithFlames() {
        if (swordBuff == 0) {
            swordBuff = 5;
            System.out.println(name + " the " + npcType + " imbued his sword with flames, the attacks are stronger and may cause burn!");
        } else {
            System.out.println(name + " the " + npcType + " tried to imbue his sword with flames but it was already on fire");
        }
        atk += 10;
    }

    public void checkBuffStatus() {
        if (swordBuff > 0) {
            System.out.println("the knights sword is on fire so extra damage will be received");
            swordBuff--;
        } else if (swordBuff == 0) {
            System.out.println("The flames subside from the knights blade");
            atk -= 10;
            swordBuff = -1; // means deactivated and will not display this msg with every attack and lower dmg
        }
    }

    @Override
    public void selectAttacks(int num, Monster ms, Character ch1, Character ch2, Character ch3, Character ch4) {

        if (isCharging) {
            unleashChargeAttack(ch1, atk);
        }

        switch (num) {
            case 1:
                attack(ch1, possibleAttackNames[utils.generateRandomNumber(0, possibleAttackNames.length - 1)]);
                break;
            case 2:
                chargeAttack();
                break;
            case 3:
                imbueSwordWithFlames();
                break;
        }
    }
}
