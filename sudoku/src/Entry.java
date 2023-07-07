public class Entry {
    private int number;
    private boolean isPossible;
    private boolean isOnlyPossible;
    public Entry(int number, boolean isPossible, boolean isOnlyPossible) {
        this.number = number;
        this.isPossible = isPossible;
        this.isOnlyPossible = isOnlyPossible;
    }
    public int getNumber() {
        return number;
    }
}
