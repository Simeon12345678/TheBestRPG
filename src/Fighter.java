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
            this.name = defaultNames[utils.generateRandomNumber(0, defaultNames.length - 1)];
        } else {
            this.name = inName;
        }
        isCharging = false;
    }


    @Override
    public void selectAttacks(int num, Character ch, Monster ms1, Monster ms2, Monster ms3, Monster ms4) {
        // insures that the next attack will be the unleashing charge attack
        if (isCharging) {
            unleashChargeAttack(ms1);
        }

        switch (num) {
            case 1:
                attack(ms1, possibleAttackNames[utils.generateRandomNumber(0, possibleAttackNames.length)]);
                break;
            case 2:
                multiAttack(ms2, ms3);
                break;
            case 3:
                guard(name, npcType);
                break;
            case 4:
                chargeAttack();
                break;
        }
    }
}
