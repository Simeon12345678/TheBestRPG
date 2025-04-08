// class for the enemies in the game

public abstract class Monster extends BaseNPC {

    Monster(String inName, String MonsterType, int hp, int atk, int def, int numOfAtks) {
        this.name = inName;
        this.maxHp = hp;
        this.hp = hp;
        this.atk = atk;
        this.def = def;
        this.npcType = MonsterType;
        this.numOfAtks = numOfAtks;
    }

    // attacks for monsters have slightly different print out thus the override

    @Override
    public void attack(BaseNPC ch, String currentAtk) {
        ch.receiveDMG(atk, ch.getHP());
        System.out.println(ch.getName() + " was hit by the enemies " + currentAtk + " and took " + (atk - ch.getDef()) + " damage!");
    }

    @Override
    public void multiAttack(BaseNPC ch1, BaseNPC ch2) {
        ch1.receiveDMG(atk, ch1.getHP());
        ch2.receiveDMG(atk, ch2.getHP());
        System.out.println(ch1.getName() + " and " + ch2.getName() + "were both hit by the enemies attack and took " + (atk - ch1.getDef()) + (atk - ch2.getDef()));
    }

    public void selectAttacks(int num, Monster ms, Character ch1, Character ch2, Character ch3, Character ch4) {
        System.out.println("my purpose is to be overriden");
    }
}
