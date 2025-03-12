// moveset
// freeze
// heal
// attack
// multi hit 2 targets

public class Wraith extends Monster {
    private final String names[] = {"Johnny", "Scary", "Spooky"};


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
            System.out.println(ch.getName() + " was frozen by " + npcType + " the " + name + "!\n They can no longer move");
        }
    }

    public void heal(Monster ms) {
        System.out.println(name + " the " + npcType + " used a horrid chant");
        if (utils.generateRandomNumber(0, 16) == 16 || ms.getHP() >= ms.getMaxHp()) {
            System.out.println("but it failed!");
        } else {
            ms.setHp(ms.getHP() + 25);
        }
    }
}
