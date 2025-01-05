public class Fighter extends Character {
    private String weapon = "Sword";
    private String defaultNames[] = {"Arthur", "Aragorn", "Ornstein", "Saber", "Link"};
    private String possibleAttackNames[] = {"Slash", "Stab", "Sweep"};

    Fighter(String inName) {
        this.maxHp = 100;
        this.hp = 100;
        this.def = 15;
        this.atk = 80;
        this.charType = "Fighter";
        if (inName.equals("default")) {
            this.name = defaultNames[(int)(Math.random() * defaultNames.length)];
        } else {
            this.name = inName;
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
