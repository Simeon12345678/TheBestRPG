import java.util.ArrayList;

public class Sorcerer extends Character {
    private String weapon = "Staff";
    // in case player does not pick one
    private String defaultNames[] = {"Miriam", "Merlin", "Calamitas", "JohnMagic", "Marisa"};
    private String possibleAttackNames[] = {"Magic missile", "Fireball", "Thunderbolt"};

    Sorcerer(String inName) {
        this.maxHp = 70;
        this.hp = 70;
        this.def = 5;
        this.atk = 100;
        this.charType = "Sorcerer";
        if (inName.equals("default")) {
            this.name = defaultNames[(int)(Math.random() * defaultNames.length)];
        } else {
            this.name = inName;
        }
    }

    // sorcerer is the only npc who can heal others
    public void healSpell(Character ch) {
        if (ch.getHP() == ch.getMaxHp()) {
            System.out.println(name + " the " + charType + " used Heal spell! But " + ch.getName() + " was already at full health");
        } else {
            int healRange = (int)(Math.random() * 20);
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

    public void attack(Monster ms) {
        String currentATK = possibleAttackNames[(int)(Math.random() * possibleAttackNames.length)];
        ms.receiveDMG(atk, ms.getDef());
        System.out.println(ms.getName() + " the " + ms.getMonsterType() +  " was hit by the " + currentATK + " and took " + (atk - ms.getDef()) + " damage!");
    }

    public void multiAttack(Monster ms, Monster ms2, Monster ms3) {
        ArrayList<Monster> monsters = new ArrayList<>();
        monsters.add(ms);
        monsters.add(ms2);
        monsters.add(ms3);

        for (int i = 0; i < monsters.size(); i++) {
            monsters.get(i).receiveDMG(atk, monsters.get(i).getDef());
            System.out.println(monsters.get(i).getName() + " the " + monsters.get(i).getMonsterType() + " Was hit by " + name + " Hellfire spell and took " + (atk - monsters.get(i).getDef()) + " Damage!");
        }
    }
}
