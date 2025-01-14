public class Wraith extends Monster {
    private final String names[] = {"Johnny", "Slimer", "Spooky"};

    Wraith() {
        hp = 70;
        name = names[(int)(Math.random() * names.length)];
        monsterType = "Wraith";
        atk = 40;
        def = 0;
    }

    public void freeze(Character ch) {
        if (ch.getCurrentStatusEffect() == statusEffects[0]) {
            // special msg if burned
            ch.setStatusEffect(statusEffects[1]);;
            System.out.println(ch.getName() + " was frozen by " + monsterType + " the " + name + "their burn has now subsided as they are frozen instead!\n They can no longer move");
        } else if (ch.getCurrentStatusEffect() == statusEffects[1]) {
            System.out.println(name + " the " + monsterType + " Failed to freeze " + ch.getName() + "with their freeze attack because they were stunned!");
        } else {
            ch.setStatusEffect(statusEffects[1]);
            System.out.println(ch.getName() + " was frozen by " + monsterType + " the " + name + "!\n They can no longer move");
        }
    }

    public void heal(Monster ms) {
        System.out.println(name + " the " + monsterType + " used a horrid chant");
        if ((int)(Math.random() * 16) == 16 || ms.getHP() >= ms.getMaxHp()) {
            System.out.println("but it failed!");
        } else {
            ms.setHp(ms.getHP() + 25);
        }
    }
}
