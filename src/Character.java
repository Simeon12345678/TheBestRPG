public class Character {
    protected int hp;
    protected int atk;
    protected int def; // def is subtracted from incoming damage to produce total damage taken
    protected int guard;
    protected String name;
    protected String currentStatusEffect;
    protected String charType;
    protected boolean isGuarding;

    public void setHp(int hp) {
        this.hp = hp;
    }

    public void setAtk(int atk) {
        this.atk = atk;
    }

    public void setDef(int def) {
        this.def = def;
    }

    public int getDef() {
        return def;
    }

    public int getGuard() {
        return guard;
    }

    public String getName() {
        return name;
    }

    public boolean getGuardStatus() {
        return isGuarding;
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

    public void attack(Monster ms) {
        ms.receiveDMG(atk, ms.getHP());
    }

    public void guard() {
        isGuarding = true;
    }
}
