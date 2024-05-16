public class Goblin extends Foe {
    public Goblin (String name, String race, Senjata senjata, Armor armor, int hp, int mp, Skill skill, int level){
        super(name, race, senjata, armor, hp, mp, skill, level);
    }

    @Override
    public void attack (Character hero){
        if (hero.armor.value > 0) {
            hero.armor.value -= this.senjata.ap;
            if (hero.armor.value < 0) {
                hero.hp += hero.armor.value;
                hero.armor.value = 0;
            }
            System.out.println(this.name + " menyerang " + hero.name + " dengan " + this.senjata.name + " dan mengurangi " + this.senjata.ap + " Armor");
        } else {
            int damage = this.senjata.ap;
            hero.hp -= damage;
            System.out.println(this.name + " menyerang " + hero.name + " dengan " + this.senjata.name + " dan mengurangi " + damage + " HP");
        }
    }

    @Override
    public void useSkill (Character hero){
        if (this.skill.name.equals("Gigit")) {
            this.mp -= this.skill.mpCost;
            hero.addStatus("Poison");
            System.out.println(this.name + " menggunakan skill 'Gigit' pada " + hero.name);
        }
    }
}
