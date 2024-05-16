public abstract class Foe extends Character {
    Skill skill;

    public Foe(String name, String race, Senjata senjata, Armor armor, int hp, int mp, Skill skill, int level) {
        super(name, race, senjata, armor, hp, mp, level);
        this.skill = skill;
    }

    @Override
    public abstract void attack(Character hero);

    @Override
    public abstract void useSkill(Character hero);

    // @Override
    // public void displayStatus() {
    //     System.out.println("Status " + name + " (Level " + level + "):");
    //     System.out.println("HP: " + hp + "/" + calculateMaxHP());
    //     System.out.println("MP: " + mp + "/" + calculateMaxMP());
    //     System.out.println("Armor: " + armor.value);
    // }

    // private int calculateMaxHP() {
    //     return level * 100; // contoh formula untuk HP maksimum
    // }

    // private int calculateMaxMP() {
    //     return level * 50; // contoh formula untuk MP maksimum
    // }
}