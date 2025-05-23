// moveset
// freeze
// heal
// attack
// multi hit 2 targets

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Wraith extends Monster {
    private final String names[] = {"Johnny", "Scary", "Spooky", "Deamon", "Banshee", "Bloody mary"};
    private String possibleAttackNames[] = {"Dark orb", "Icicles", "Death rancor"};

    Wraith() {
        super("default", "Wraith", 70, 40, 0, 4);
        this.name = names[utils.generateRandomNumber(0, names.length - 1)];
    }

    public void freeze(Character ch) {
        if (ch.getCurrentStatusEffect() == statusEffects[0]) {
            // special msg if burned
            ch.setStatusEffect(statusEffects[1]);;
            System.out.println(ch.getName() + " was frozen by " + npcType + " the " + name + "their burn has now subsided as they are frozen instead!\n They can no longer move");
        } else if (ch.getCurrentStatusEffect() == statusEffects[1]) {
            System.out.println(name + " the " + npcType + " Failed to freeze " + ch.getName() + "with their freeze attack because they were stunned!");
        } else {
            ch.setStatusEffect(statusEffects[1]);
            System.out.println(ch.getName() + " was frozen by " + name + " the " + npcType + "!\n They can no longer move");
        }
    }

    public void heal(Monster ms) {
        System.out.println(name + " the " + npcType + " used a horrid chant");
        if (utils.generateRandomNumber(0, 16) == 16 || ms.getHP() >= ms.getMaxHp()) {
            System.out.println("but it failed!");
        } else {
            System.out.println(ms.getName() + " the " + ms.getNpcType() + " was healed");
            ms.setHp(ms.getHP() + 25);
        }
    }

    @Override
    public void selectAttacks(int num, Monster ms, Character ch1, Character ch2, Character ch3, Character ch4) {
        switch (num) {
            case 1:
                attack(ch1, possibleAttackNames[utils.generateRandomNumber(0, possibleAttackNames.length - 1)]);
                break;
            case 2:
                heal(ms);
                break;
            case 3:
                freeze(ch1);
                break;
            case 4:
                List<Character> temp = Arrays.asList(ch1, ch2, ch3);
                int option1 = utils.generateRandomNumber(0, 2);
                int option2 = utils.generateRandomNumber(0, 2);
                if (option2 == option1) { // so we don't hit the same one twice
                    if (option2 == 0) {
                        option2++; // prevent index out of bounds
                    } else {
                        option2--;
                    }
                }
                multiAttack(temp.get(option1), temp.get(option2));
                break;
        }
    }
}
