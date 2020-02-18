package nuclear_submarine;

import nuclear_submarine.annotations.Submarine;
import nuclear_submarine.annotations.SubmarineMovement;
import nuclear_submarine.annotations.SubmarineStop;

@Submarine(name = "yellow_submarine")
public class NuclearSubmarine {

    private String color;
    private NuclearSubarineEngine engine;
    private int maxDeep;

    public NuclearSubmarine(String color, int maxDeep, int engineCapacity) {
        this.color = color;
        this.maxDeep = maxDeep;

        this.engine = new NuclearSubarineEngine(engineCapacity);
        System.out.println("Построена подводная лодка. Цает - " + this.color);
    }

    @SubmarineMovement
    public void goDown() {
        engine.startWorking();
        System.out.println("Подводная лодка начала движение под воду");
    }

    @SubmarineMovement
    public void goUp() {
        engine.startWorking();
        System.out.println("Подводная лодка начала движение из под воды");
    }

    @SubmarineStop
    public void stop() {
        engine.stopWorking();
        System.out.println("Подводная лодка остановилась");
    }

    private class NuclearSubarineEngine {
        private int engineCapacity;

        public NuclearSubarineEngine(int engineCapacity) {
            this.engineCapacity = engineCapacity;
            System.out.println("Построен движок для подводной лодки, мощностью - " +
                    this.engineCapacity);
        }

        public void startWorking() {
            System.out.println("Двигатель завелся ... ");
            System.out.println("Двигатель прогрелся ... ");
        }

        public void stopWorking() {
            System.out.println("Двигатель выключился ... ");
        }
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public NuclearSubarineEngine getEngine() {
        return engine;
    }

    public void setEngine(NuclearSubarineEngine engine) {
        this.engine = engine;
    }

    public int getMaxDeep() {
        return maxDeep;
    }

    public void setMaxDeep(int maxDeep) {
        this.maxDeep = maxDeep;
    }
}

