package nuclear_submarine;

public class NuclearSubmarineLoader {
    public static void main(String[] args) {
        NuclearSubmarine submarine = new NuclearSubmarine("Желтый", 100, 1000);
        submarine.goDown();
        submarine.stop();
        submarine.goUp();
    }
}
