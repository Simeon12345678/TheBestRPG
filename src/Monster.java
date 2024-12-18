public class Monster {
    protected String name;
    protected String monsterType; // unlike names this one will not be unique per instance
    protected int hp;
    protected int atk;
    // def is subtracted from incoming damage to produce total damage taken
    protected int def;
    // status debuffs can be applied and each have a negative
    protected String statusEffects[] = {"Burn", "Frozen", "Stun"};
    protected String currentStatusEffect;

    public void setHp(int hp) {
        this.hp = hp;
    }

    public void setAtk(int atk) {
        this.atk = atk;
    }

    public void setDef(int def) {
        this.def = def;
    }

    public int getHP() {
        return hp;
    }

    public void receiveDMG(int atk, int def) {
        int DMGtoTake;
        // so that the dmg doesn't reach negative and heal you ie if high defence and low incoming attack
        if (def > atk) {
            DMGtoTake = 0;
        } else {
            DMGtoTake = atk - def;
        }
        this.hp -= DMGtoTake;
    }

    public void attack(Character ch) {
        ch.receiveDMG(atk, ch.getDef());
        System.out.println(ch.getName() + " was hit and took " + (atk - ch.getDef()) + " damage!");
    }

    public void multiAttack(Character ch, Character ch2) {
        ch2.receiveDMG(atk, ch.getDef());
        ch.receiveDMG(def, ch2.getDef());
        System.out.println(ch.getName() + " and " + ch2.getName() + "were both hit and took " + (atk - ch.getDef()) + (atk - ch2.getDef()) + "respective damage each!");
    }
}
