import java.util.ArrayList;

public class Slime extends Monster {
    // list of possible names
    private final String names[] = {"Goober", "Slungus", "Slimy", "Surly"};

    Slime() {
        // stats for the slime monster
        hp = 50;
        name = names[(int)(Math.random() * names.length)];
        monsterType = "Slime";
        atk = 30;
        def = 10;
    }

    // method that dictates attack directed at one player, slime can stun
    public void attack(Character ch) {
        int currentAttack;
        if (ch.getGuardStatus()) {
            currentAttack = atk - ch.getGuard();
        } else {
            currentAttack = atk;
        }

        ch.receiveDMG(currentAttack, ch.getDef());
        System.out.println(ch.getName() + " was hit by " + name + " the " + monsterType + " and took " + (currentAttack - ch.getDef()) + " damage!");

        if ((int)(Math.random() * 16) == 16 && ch.getGuardStatus()) {
            ch.setStatusEffect(statusEffects[2]); // stun player with 1/16 chance
            System.out.println(ch.getName() + " was stunned by the attack! They may be unable to move");
        }
    }
    // slime multi attack can hit all 3 players in the party
    public void multiAttack(Character ch, Character ch2, Character ch3) {
        int currentAttack;
        ArrayList<Character> characters = new ArrayList<>();
        characters.add(ch);
        characters.add(ch2);
        characters.add(ch3);

        for (int i = 0; i < characters.size(); i++) {
            // check for guard status
            if (characters.get(i).getGuardStatus()) {
                currentAttack = atk - characters.get(i).getGuard();
            } else {
                currentAttack = atk;
            }
            // take the damage
            characters.get(i).receiveDMG(currentAttack, characters.get(i).getDef());
            System.out.println(characters.get(i).getName() + "was hit and took" + (currentAttack - characters.get(i).getDef()) + " damage!");
        }
    }
}
