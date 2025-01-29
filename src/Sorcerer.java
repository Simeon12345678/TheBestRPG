import java.util.ArrayList;

// moveset
// heal spell
// heal status
// multi attack 3 targets (overload)
// attack (no override)


public class Sorcerer extends Character {
    private String weapon = "Staff";
    // in case player does not pick one
    private String defaultNames[] = {"Miriam", "Merlin", "Calamitas", "JohnMagic", "Marisa"};
    private String possibleAttackNames[] = {"Magic missile", "Fireball", "Thunderbolt"};

    Sorcerer(String inName) {
        super(inName, "Sorcerer", 70, 100, 5, 4);
        if (inName.equals("default")) {
            this.name = defaultNames[utils.generateRandomNumber(0, defaultNames.length)];
        } else {
            this.name = inName;
        }
    }

    // sorcerer is the only npc who can heal others
    public void healSpell(Character ch) {
        if (ch.getHP() == ch.getMaxHp()) {
            System.out.println(name + " the " + npcType + " used Heal spell! But " + ch.getName() + " was already at full health");
        } else {
            int healRange = utils.generateRandomNumber(0, 20);
            ch.setHp(healRange);
        }
    }

    public void healStatus(Character ch) {
        if (!(ch.getCurrentStatusEffect().isEmpty())) { // if ch has a status
            ch.setStatusEffect(" ");
            System.out.println("Cured the status applied to " + ch.getName());
        } else {
            System.out.println(ch.getName() + "had no status effect to cure!");
        }
    }

    // overloads the parent multi attack to target 3 enemies instead
    public void multiAttack(Monster ms, Monster ms2, Monster ms3) {
        ArrayList<Monster> monsters = new ArrayList<>();
        monsters.add(ms);
        monsters.add(ms2);
        monsters.add(ms3);

        for (int i = 0; i < monsters.size(); i++) {
            monsters.get(i).receiveDMG(atk, monsters.get(i).getDef());
            System.out.println(monsters.get(i).getName() + " the " + monsters.get(i).getNpcType() + " Was hit by " + name + " Hellfire spell and took " + (atk - monsters.get(i).getDef()) + " Damage!");
        }
    }
}
