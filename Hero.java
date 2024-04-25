public class Hero extends Character {
    Skill skill;

    public Hero(String name, String race, Senjata senjata, Armor armor, int hp, int mp, Skill skill, int level) {
        super(name, race, senjata, armor, hp, mp, level);
        this.skill = skill;
    }

    public void useSkill(Character foe) {
        if (mp >= skill.mpCost) {
            mp -= skill.mpCost;
            foe.hp -= skill.damage;
            System.out.println(name + " menggunakan " + skill.name + " dan mengurangi " + skill.damage + " HP kepada " + foe.name);
        } else {
            System.out.println("MP tidak cukup untuk menggunakan skill ini.");
        }
    }
}