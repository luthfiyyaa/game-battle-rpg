public class Item {
    String name;
    int hpIncrease;
    int mpIncrease;

    public Item(String name, int hpIncrease, int mpIncrease) {
        this.name = name;
        this.hpIncrease = hpIncrease;
        this.mpIncrease = mpIncrease;
    }

    public String getName() {
        return name;
    }

    public void setName(String name){
        this.name = name;
    }

    public int getHpIncrease() {
        return hpIncrease;
    }

    public void setHpIncrease (int hpIncrease){
        this.hpIncrease = hpIncrease;
    }

    public int getMp() {
        return mpIncrease;
    }

    public void setMpIncrease (int mpIncrease){
        this.mpIncrease = mpIncrease;
    }

    public boolean isRemedy() {
        return name.equalsIgnoreCase("Remedy");
    }

    public boolean isAntidote() {
        return name.equalsIgnoreCase("Antidote");
    }

    public boolean isPotion() {
        return name.equalsIgnoreCase("Potion");
    }

    public boolean isEther() {
        return name.equalsIgnoreCase("Ether");
    }

    public boolean isElixir() {
        return name.equalsIgnoreCase("Elixir");
    }
}