public class Shield extends Items {
    private int defense;

    public Shield() {
        setName("N/A");
        defense = 0;
    }

    public Shield(String name, int def) {
        setName(name);
        setDefense(def);
    }

    public int getDefense() {
        if(this.equals(null)) {
            return 0;
        } else {
            return defense;
        }
    }

    public void setDefense(int def) {
        if(def >= 0) {
            defense = def;
        } else {
            defense = 0;
        }
    }
}
