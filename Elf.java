public class Elf extends Foe implements Healable{

    public Elf(String name, String race, Senjata senjata, Armor armor, int hp, int mp, Skill skill, int level){
        super(name, race, senjata, armor, hp, mp, skill, level);
    }

    @Override
    public void attack(Character hero){
        if (hero.armor.getValue() > 0) {
            hero.armor.setValue(this.armor.getValue() - this.senjata.getAp());
            if (hero.armor.getValue() < 0) {
                hero.hp += hero.armor.getValue();
                hero.armor.setValue(0);;
            }
            System.out.println(this.name + " menyerang " + hero.name + " dengan " + this.senjata.getName() + " dan mengurangi " + this.senjata.getAp() + " Armor");
        } else {
            int damage = this.senjata.getAp();
            hero.hp -= damage;
            System.out.println(this.name + " menyerang " + hero.name + " dengan " + this.senjata.getName() + " dan mengurangi " + damage + " HP");
        }
    }

    @Override
    public void useSkill(Character hero){
        if (this.skill.getNameSkill().equals("Recover")) {
            if (this.mp >= this.skill.getMpCost()) {
                this.mp -= this.skill.getMpCost();
                hero.hp += this.skill.getDamage();
                System.out.println(this.name + " menggunakan skill 'Recover' pada dirinya sendiri");
                this.mp += 10;
            }
        } else if (this.skill.getNameSkill().equals("Lullaby")){
            if (this.mp >= this.skill.getMpCost()) {
                this.mp -= this.skill.getMpCost();
                hero.addStatus("Sleep");
                System.out.println(this.name + " menggunakan skill 'Lullaby' pada " + hero.name);
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
