public class Fairy extends Hero implements Healable {
    public Fairy (String name, String race, Senjata senjata, Armor armor, int hp, int mp, Skill skill, int level){
        super(name, race, senjata, armor, hp, mp, skill, level);
    }

    @Override
    public void attack (Character foe){
        if (foe.armor.getValue() > 0) {
            foe.armor.setValue(this.armor.getValue() - this.senjata.getAp());
            if (foe.armor.getValue() < 0) {
                foe.hp += foe.armor.getValue();
                foe.armor.setValue(0);;
            }
            System.out.println(this.name + " menyerang " + foe.name + " dengan " + this.senjata.getName() + " dan mengurangi " + this.senjata.getAp() + " Armor");
        } else {
            int damage = this.senjata.getAp();
            foe.hp -= damage;
            System.out.println(this.name + " menyerang " + foe.name + " dengan " + this.senjata.getName() + " dan mengurangi " + damage + " HP");
        }
    }

    @Override
    public void useSkill(Character foe){
        if (this.skill.getNameSkill() == "Healing") {
            if (this.mp >= this.skill.getMpCost()) {
                this.mp -= this.skill.getMpCost();
                foe.hp += 10;
                System.out.println(this.name + " menggunakan " + this.skill.getNameSkill() + " dan mengembalikan " + this.skill.getDamage() + " HP");
                } else {
                    System.out.println(this.name + " tidak memiliki MP untuk menggunakan " + this.skill.getNameSkill());
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
