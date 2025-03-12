// features the universal things for monsters, npc's and players such as stats
import com.sun.istack.internal.NotNull;

public abstract class baseNPC {
    protected String name;
    protected String npcType;
    protected String statusEffects[] = {"Burn", "Frozen", "Stun"};
    protected String currentStatusEffect;

    protected int hp;
    protected int maxHp;
    protected int atk;
    protected int def;
    protected int numOfAtks;

    protected final Utils<Integer> utils = new Utils<>();

    public void setHp(int hp) {
        this.hp = hp;
    }

    public void setNumOfAtks(int numOfAtks) {
        this.numOfAtks = numOfAtks;
    }

    public void setAtk(int atk) {
        this.atk = atk;
    }

    public void setDef(int def) {
        this.def = def;
    }

    public void setStatusEffect(String status) {
        currentStatusEffect = status;
    }

    public int getAtk() {
        return this.atk;
    }

    public int getNumOfAtks() {
        return numOfAtks;
    }

    public int getDef() {
        return def;
    }

    public int getHP() {
        return hp;
    }

    public int getMaxHp() {
        return maxHp;
    }

    public String getName() {
        return name;
    }

    public String getNpcType() {
        return npcType;
    }

    public String getCurrentStatusEffect() {
        return currentStatusEffect;
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

    @NotNull
    public void attack(baseNPC npc, String currentAtk) {
        npc.receiveDMG(atk, npc.getHP());
        System.out.println(npc.getName() + " the " + npc.getNpcType() +  " was hit by the " + currentAtk + " and took " + (atk - npc.getDef()) + " damage!");
    }

    @NotNull
    public void multiAttack(baseNPC npc1, baseNPC npc2) {
        npc1.receiveDMG(atk, npc1.getHP());
        npc2.receiveDMG(atk, npc2.getHP());
        System.out.println(npc2.getName() + " and " + npc2.getName() + " were both hit and took " + (atk - npc1.getDef()) + " and " + (atk - npc2.getDef()) + " respective damage!");
    }

}
