public abstract class Foe extends Character {
    Skill skill;

    public Foe(String name, String race, Senjata senjata, Armor armor, int hp, int mp, Skill skill, int level) {
        super(name, race, senjata, armor, hp, mp, level);
        this.skill = skill;
    }

    @Override
    public abstract void attack(Character hero);

    @Override
    public abstract void useSkill(Character hero);
}