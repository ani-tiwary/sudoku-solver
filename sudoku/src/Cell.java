import java.util.ArrayList;
public class Cell {
    private final ArrayList<Entry> entries;
    private int number;
    private boolean isFilled;
    public Cell() {
        entries = new ArrayList<>();
        for (int i = 1; i <= 9; i++) {
            entries.add(new Entry(i, true, false));
        }
        number = 0;
        isFilled = false;
    }
    public ArrayList<Entry> getEntries() {
        return entries;
    }
    public int getNumber() {
        return number;
    }
    public void setNumber(int number) {
        this.number = number;
    }
    public boolean isFilled() {
        return isFilled;
    }
    public void setFilled(boolean filled) {
        isFilled = filled;
    }
}
