public class Skill {
    private String name;
    private int mpCost;
    private int damage;

    public Skill(String name, int mpCost, int damage) {
        this.name = name;
        this.mpCost = mpCost;
        this.damage = damage;
    }

    public void setNameSkill(String name){
        this.name = name;
    }

    public String getNameSkill(){
        return name;
    }

    public void setMpCost(int mpCost){
        this.mpCost = mpCost;
    }

    public int getMpCost(){
        return mpCost;
    }

    public void setDamage(int damage){
        this.damage = damage;
    }

    public int getDamage(){
        return damage;
    }
}