// moveset
// charge attack
// multi attack 2 targets (no override)
// attack (no override)
// guard (no override)


import java.util.Arrays;
import java.util.List;

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
                List<Monster> temp = Arrays.asList(ms2, ms3, ms4);
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
            case 3:
                guard(name, npcType);
                break;
            case 4:
                chargeAttack();
                break;
        }
    }
}
