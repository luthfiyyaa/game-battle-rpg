public class Goblin extends Foe {
    public Goblin (String name, String race, Senjata senjata, Armor armor, int hp, int mp, Skill skill, int level){
        super(name, race, senjata, armor, hp, mp, skill, level);
    }

    @Override
    public void attack (Character hero){
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
    public void useSkill (Character hero){
        if (this.skill.getNameSkill().equals("Gigit")) {
            this.mp -= this.skill.getMpCost();
            hero.addStatus("Poison");
            System.out.println(this.name + " menggunakan skill 'Gigit' pada " + hero.name);
        }
    }
}
