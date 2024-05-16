public class Archer extends Hero {
    public Archer (String name, String race, Senjata senjata, Armor armor, int hp, int mp, Skill skill, int level){
        super(name, race, senjata, armor, hp, mp, skill, level);
    }

    @Override
    public void attack(Character foe){
        if (foe.armor.value > 0) {
            foe.armor.value -= this.senjata.ap;
            if (foe.armor.value < 0) {
                foe.hp += foe.armor.value;
                foe.armor.value = 0;
            }
            System.out.println(this.name + " menyerang " + foe.name + " dengan " + this.senjata.name +  " dan mengurangi " + this.senjata.ap + " Armor");
        } else {
            int damage = this.senjata.ap;
            foe.hp -= damage;
            System.out.println(this.name + " menyerang " + foe.name + " dengan " + this.senjata.name + " dan mengurangi " + damage + " HP");
        }
    }

    @Override
    public void useSkill(Character foe) {
        if (this.skill.name.equals("Kemampuan Khusus")) {
            foe.hp -= this.skill.damage;
            System.out.println(this.name + " menggunakan " + this.skill.damage + " dan mengurangi " + this.skill.damage + " HP");
        }
    }
}
