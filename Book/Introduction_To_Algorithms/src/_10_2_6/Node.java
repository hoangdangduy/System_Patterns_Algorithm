package _10_2_6;

public class Node {
    private String value;
    private int np;

    public Node(String value) {
        this.value = value;
        this.np = 0;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public int getNp() {
        return np;
    }

    public void setNp(int np) {
        this.np = np;
    }
}
