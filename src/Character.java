// class for the players and their allies

public abstract class Character extends baseNPC{
    protected int guard;
    protected String previousAtks[] = {"guard", "attack", "multiAttack", "multiHit", "charge", "heal", "healStat"};
    protected boolean isGuarding;

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

    public void guard() {
        isGuarding = true;
        System.out.println("this is a guard");
    }

    // used for the combat of the game to select an attack which the npcs use
    public void selectAttacks(int num, Character ch, Monster ms1, Monster ms2, Monster ms3, Monster ms4) {
        System.out.println("my purpose is to be overriden");
    }
}
