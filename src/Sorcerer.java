public class Sorcerer extends Character {
    private String weapon = "Staff";
    // in case player does not pick one
    private String defaultNames[] = {"Miriam", "Merlin", "Calamitas", "JohnMagic", "Marisa"};

    Sorcerer(String inName) {
        hp = 70;
        def = 5;
        atk = 100;
        charType = "Sorcerer";
        if (inName.equals("default")) {
            name = defaultNames[(int)(Math.random() * defaultNames.length)];
        } else {
            name = inName;
        }
    }

    // sorcerer is the only npc who can heal others
    public void healSpell() {

    }
}
