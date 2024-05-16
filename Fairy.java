public class Fairy extends Hero implements Healable {
    public Fairy (String name, String race, Senjata senjata, Armor armor, int hp, int mp, Skill skill, int level){
        super(name, race, senjata, armor, hp, mp, skill, level);
    }

    @Override
    public void attack (Character foe){
        if (foe.armor.value > 0) {
            foe.armor.value -= this.senjata.ap;
            if (foe.armor.value < 0) {
                foe.hp += foe.armor.value;
                foe.armor.value = 0;
            }
            System.out.println(this.name + " menyerang " + foe.name + " dengan " + this.senjata.name + " dan mengurangi " + this.senjata.ap + " Armor");
        } else {
            int damage = this.senjata.ap;
            foe.hp -= damage;
            System.out.println(this.name + " menyerang " + foe.name + " dengan " + this.senjata.name + " dan mengurangi " + damage + " HP");
        }
    }

    @Override
    public void useSkill(Character foe){
        if (this.skill.name == "Healing") {
            if (this.mp >= this.skill.mpCost) {
                this.mp -= this.skill.mpCost;
                foe.hp += 10;
                System.out.println(this.name + " menggunakan " + this.skill.name + " dan mengembalikan " + this.skill.damage + " HP");
                } else {
                    System.out.println(this.name + " tidak memiliki MP untuk menggunakan " + this.skill.name);
                }
        }
    }

    @Override
    public void heal(Character character){
        if (character instanceof Hero) {
            Hero hero = (Hero) character;
            hero.hp += 50;
            System.out.println("HP Hero bertambah 50.");
        } else if (character instanceof Foe) {
            Foe foe = (Foe) character;
            foe.hp += 50;
            System.out.println("HP Foe bertambah 50.");
        } else {
            System.out.println("Character tidak valid.");
        }
    }
}
