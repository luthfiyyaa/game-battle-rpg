public abstract class Character {
    String name;
    String race;
    Senjata senjata;
    Armor armor;
    int hp;
    int mp;
    int level;

    public Character(String name, String race, Senjata senjata, Armor armor, int hp, int mp, int level) {
        this.name = name;
        this.race = race;
        this.senjata = senjata;
        this.armor = armor;
        this.hp = hp;
        this.mp = mp;
        this.level = level;
    }

    public abstract void attack(Character foe);

    public abstract void useSkill (Character foe);

    public void useItem(Item item) {
        this.hp += item.hpIncrease;
        this.mp += item.mpIncrease;
        System.out.println(this.name + " menggunakan " + item.name + " dan menambahkan " + item.hpIncrease + " HP dan " + item.mpIncrease + " MP");
    }

    public void displayStatus() {
        System.out.println("Status " + name + " (Level " + level + "):");
        System.out.println("HP: " + hp + "/" + calculateMaxHP());
        System.out.println("MP: " + mp + "/" + calculateMaxMP());
        System.out.println("Armor: " + armor.value);
    }

    private int calculateMaxHP() {
        return level * 100; // contoh formula untuk HP maksimum
    }

    private int calculateMaxMP() {
        return level * 50; // contoh formula untuk MP maksimum
    }
}