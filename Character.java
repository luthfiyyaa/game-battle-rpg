import java.util.ArrayList;
import java.util.List;

public abstract class Character {
    String name;
    String race;
    Senjata senjata;
    Armor armor;
    int hp;
    int mp;
    int level;
    boolean isWeak;
    boolean isPoison;
    boolean isSleep;
    List<String> statusEffect;

    public Character(String name, String race, Senjata senjata, Armor armor, int hp, int mp, int level) {
        this.name = name;
        this.race = race;
        this.senjata = senjata;
        this.armor = armor;
        this.hp = hp;
        this.mp = mp;
        this.level = level;
        this.isWeak = false;
        this.isPoison = false;
        this.isSleep = false;
        this.statusEffect = new ArrayList<>();
    }

    public abstract void attack(Character foe);

    public abstract void useSkill (Character foe);

    public void useItem(Item item) {
        if (item.isRemedy()) {
            // remove all status effects
            this.statusEffect.clear();
            System.out.println("All status effects removed!");
        } else if (item.isAntidote()) {
            // remove poison status effect
            this.statusEffect.remove("Poison");
            System.out.println("Poison status effect removed!");
        } else {
            this.hp += item.hpIncrease;
        this.mp += item.mpIncrease;
        System.out.println("HP/MP restored!");
        }
    }

    public void displayStatus() {
        System.out.println("Status " + name + " (Level " + level + "):");
        System.out.println("HP: " + hp + "/" + calculateMaxHP());
        System.out.println("MP: " + mp + "/" + calculateMaxMP());
        System.out.println("Armor: " + armor.value);
        System.out.println("=====================");
    }

    private int calculateMaxHP() {
        return level * 100; // contoh formula untuk HP maksimum
    }

    private int calculateMaxMP() {
        return level * 50; // contoh formula untuk MP maksimum
    }

    public void addStatus(String status) {
        switch (status) {
            case "Weak":
                this.isWeak = true;
                break;
            case "Poison":
                this.isPoison = true;
                break;
            case "Sleep":
                this.isSleep = true;
                break;
        }
    }

    public void removeStatus(String status) {
        switch (status) {
            case "Weak":
                this.isWeak = false;
                break;
            case "Poison":
                this.isPoison = false;
                break;
            case "Sleep":
                this.isSleep = false;
                break;
        }
    }

    public void applyStatusDamage(){
        if (isWeak){
            this.hp -= 10;
        }
        if (isPoison){
            this.hp -= 5;
        }
    }

    public void applyStatusSleep(){
        if (isSleep){
            System.out.println(this.name + " tidak dapat menyerang karena tertidur!");
        } else {
            // this.attack(foe);
        }
    }

}