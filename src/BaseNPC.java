// features the universal things for monsters, npc's and players such as stats
import com.sun.istack.internal.NotNull;

public abstract class BaseNPC {
    protected String name;
    protected String npcType;
    protected String statusEffects[] = {"Burn", "Frozen", "Stun"};
    protected String currentStatusEffect = ""; // blank
    protected boolean isDefeated = false;

    protected int hp;
    protected int maxHp;
    protected int atk;
    protected int def;
    protected int numOfAtks;
    protected int statusCounter = 3;

    protected final Utils<Integer> utils = new Utils<>();

    public void setHp(int hp) {
        this.hp = hp;
    }

    public void setDefeatStatus(boolean isDefeated) {
        this.isDefeated = isDefeated;
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
        this.currentStatusEffect = status;
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

    public boolean getIsDefeated() {
        return isDefeated;
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
    public void attack(BaseNPC npc, String currentAtk) {
        npc.receiveDMG(atk, npc.getHP());
        System.out.println(npc.getName() + " the " + npc.getNpcType() +  " was hit by the " + currentAtk + " and took " + (atk - npc.getDef()) + " damage!");
    }

    @NotNull
    public void multiAttack(BaseNPC npc1, BaseNPC npc2) {
        npc1.receiveDMG(atk, npc1.getHP());
        npc2.receiveDMG(atk, npc2.getHP());
        System.out.println(npc2.getName() + " and " + npc2.getName() + " were both hit and took " + (atk - npc1.getDef()) + " and " + (atk - npc2.getDef()) + " respective damage!");
    }

    public void applyStatus() {
        if (currentStatusEffect.equalsIgnoreCase("Burn")) {
            this.hp -= 5;
            System.out.println(name + " the " + npcType + " was hurt by their burn");
            this.statusCounter--;
            if (statusCounter <= 0) {
                System.out.println(name + " the " + npcType + " has put out their burn and will no longer take damage over time!");
                this.currentStatusEffect = "";
                this.statusCounter = 3;
            }
        } else if (currentStatusEffect.equalsIgnoreCase("Frozen")) {
            System.out.println(name + " the " + npcType + " is frozen solid");
            this.isDefeated = true;
            this.statusCounter--;
            if (statusCounter <= 0) {
                System.out.println(name + " the " + npcType + " has thawed out and can move again");
                this.isDefeated = false;
                this.currentStatusEffect = "";
                this.statusCounter = 3;
            }
        } else if (currentStatusEffect.equalsIgnoreCase("Stun")) {
            if (utils.generateRandomNumber(0, 16) == 16) {
                this.isDefeated = true;
            } else {
                this.isDefeated = false;
            }
            this.statusCounter--;
            if (statusCounter <= 0) {
                System.out.println(name + " the " + npcType + " has regained their senses and snapped out of the stun");
                this.isDefeated = false;
                this.currentStatusEffect = "";
                this.statusCounter = 3;
            }
        }
    }

}
