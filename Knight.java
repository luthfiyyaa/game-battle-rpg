public class Knight extends Hero {
    public Knight (String name, String race, Senjata senjata, Armor armor, int hp, int mp, Skill skill, int level){
        super(name, race, senjata, armor, hp, mp, skill, level);
    }

    @Override
    public void attack (Character foe){
        if (foe.armor.getValue() > 0) {
            foe.armor.setValue(this.armor.getValue() - this.senjata.getAp());
            if (foe.armor.getValue() < 0) {
                foe.hp += foe.armor.getValue();
                foe.armor.setValue(0);
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
        if (this.skill.getNameSkill().equals("Shield")) {
            foe.armor.setValue(this.armor.getValue() + this.skill.getDamage());
            System.out.println(this.name + " menggunakan " + this.skill.getNameSkill() + " dan menambahkan " + this.skill.getDamage() + " Armor");
        }
    }
}
