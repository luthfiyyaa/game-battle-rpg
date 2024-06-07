public class Armor {
    private String name;
    private int reduction;
    private int value;

    public Armor(String name, int reduction, int value) {
        this.name = name;
        this.reduction = reduction;
        this.value = value;
    }

    public void setNameArmor(String name){
        this.name = name;
    }

    public String getNameArmor(){
        return name;
    }

    public void setReduction(int reduction){
        this.reduction = reduction;
    }

    public int getReduction(){
        return reduction;
    }

    public void setValue(int value){
        this.value = value;
    }

    public int getValue(){
        return value;
    }
}