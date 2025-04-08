// class for the players and their allies

public abstract class Character extends BaseNPC {
    protected int guard;
    protected boolean isGuarding;
    protected boolean isCharging;

    Character(String inName, String charType, int hp, int atk, int def, int numOfAtks) {
        this.name = inName;
        this.maxHp = hp;
        this.hp = hp;
        this.atk = atk;
        this.def = def;
        this.npcType = charType;
        this.numOfAtks = numOfAtks;
    }

    public int getGuard() {
        return guard;
    }

    public boolean getGuardStatus() {
        return isGuarding;
    }

    public void guard(String name, String npcType) {
        isGuarding = true;
        System.out.println(name + " the " + npcType + " is guarding! They will take reduced damage from a hit now");
    }


    public void chargeAttack() {
        System.out.println(name + "Is charging an attack! It will be unleashed next turn.");
        isCharging = true;
    }

    public void unleashChargeAttack(Monster ms) {
        System.out.println(name + "Finished charging!");
        ms.receiveDMG((atk + 40), ms.getDef());
        System.out.println(ms.getName() + " the " + ms.getNpcType() + " Was hit by the mighty attack and took " + ((atk + 40) - ms.getDef()) + " damage!");

        if (utils.generateRandomNumber(0, 16) == 16) {
            ms.setStatusEffect(statusEffects[2]);
            System.out.println(ms.getName() + " the " + ms.getNpcType() + " Was stunned by the blow!");
        }
        isCharging = false;
    }

    // used for the combat of the game to select an attack which the npcs use
    public void selectAttacks(int num, Character ch, Monster ms1, Monster ms2, Monster ms3, Monster ms4) {
        System.out.println("my purpose is to be overriden");
    }

    public void special(Monster ms) {
        System.out.println("my purpose is to be overriden");
    }
}
