public class Fighter extends Character {
    private String weapon = "Sword";
    private String defaultNames[] = {"Arthur", "Aragorn", "Ornstein", "Saber", "Link"};
    private String possibleAttackNames[] = {"Slash", "Stab", "Sweep"};

    Fighter(String inName) {
        maxHp = 100;
        hp = 100;
        def = 15;
        atk = 80;
        charType = "Fighter";
        if (inName.equals("default")) {
            name = defaultNames[(int)(Math.random() * defaultNames.length)];
        } else {
            name = inName;
        }
    }

    public void attack(Monster ms) {

    }

    public void chargeAttack() {
        System.out.println(name + "Is charging an attack! It will be unleashed next turn.");
    }

    public void unleashChargeAttack(Monster ms) {
        System.out.println(name + "Finished charging!");
        ms.receiveDMG((atk + 40), ms.getDef());
        System.out.println(ms.getName() + " the " + ms.getMonsterType() + " Was hit by the mighty attack and took " + ((atk + 40) - ms.getDef()) + " damage!");

        if ((int)(Math.random() * 16) == 16) {
            ms.setStatusEffects(statusEffects[2]);
            System.out.println(ms.getName() + " the " + ms.getMonsterType() + " Was stunned by the blow!");
        }
    }
}
