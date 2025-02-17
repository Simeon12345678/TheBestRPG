// moveset
// charge attack
// multi attack 2 targets (no override)
// attack (no override)
// guard (no override)


public class Fighter extends Character {
    private String weapon = "Sword";
    private String defaultNames[] = {"Arthur", "Aragorn", "Ornstein", "Saber", "Link"};
    private String possibleAttackNames[] = {"Slash", "Stab", "Sweep"};

    Fighter(String inName) {
        super(inName,"fighter",100,80,15, 4);
        if (inName.equals("default")) {
            this.name = defaultNames[utils.generateRandomNumber(0, defaultNames.length)];
        } else {
            this.name = inName;
        }
    }

    public void chargeAttack() {
        System.out.println(name + "Is charging an attack! It will be unleashed next turn.");
    }

    public void unleashChargeAttack(Monster ms) {
        System.out.println(name + "Finished charging!");
        ms.receiveDMG((atk + 40), ms.getDef());
        System.out.println(ms.getName() + " the " + ms.getNpcType() + " Was hit by the mighty attack and took " + ((atk + 40) - ms.getDef()) + " damage!");

        if (utils.generateRandomNumber(0, 16) == 16) {
            ms.setStatusEffect(statusEffects[2]);
            System.out.println(ms.getName() + " the " + ms.getNpcType() + " Was stunned by the blow!");
        }
    }
}
