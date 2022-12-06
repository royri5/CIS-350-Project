public class Items {
    private String name;

    public Items() {
        name = "N/A";
    }

    public Items(String name) {
        setName(name);
    }

    public String getName() {
        return name;
    }

    public void setName(String n) {
        if(n == null) {
            name = "N/A";
        } else {
            name = n;
        }
    }


}