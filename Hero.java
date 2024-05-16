public abstract class Hero extends Character {
    Skill skill;

    public Hero(String name, String race, Senjata senjata, Armor armor, int hp, int mp, Skill skill, int level) {
        super(name, race, senjata, armor, hp, mp, level);
        this.skill = skill;
    }

    @Override
    public abstract void attack(Character foe);

    @Override
    public abstract void useSkill(Character foe);
}