public class Senjata {
    private String name;
    private int ap;

    public Senjata(String name, int ap) {
        this.name = name;
        this.ap = ap;
    }

    public void setName(String name){
        this.name = name;
    }

    public String getName(){
        return name;
    }

    public void setAp(int ap){
        this.ap = ap;
    }

    public int getAp(){
        return ap;
    }
}