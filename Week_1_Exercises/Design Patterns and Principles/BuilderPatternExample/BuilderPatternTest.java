
public class BuilderPatternTest {
    public static void main(String[] args) {
        // Creating a basic computer configuration
        Computer basicComputer = new Computer.Builder()
                .setCPU("Intel i3")
                .setRAM("8GB")
                .setStorage("256GB SSD")
                .build();

        System.out.println(basicComputer);

        // Creating a gaming computer configuration
        Computer gamingComputer = new Computer.Builder()
                .setCPU("Intel i7")
                .setRAM("16GB")
                .setStorage("1TB SSD")
                .setGPU("NVIDIA RTX 3080")
                .setCoolingSystem("Liquid Cooling")
                .build();

        System.out.println(gamingComputer);

        // Creating a high-performance computer configuration
        Computer highPerformanceComputer = new Computer.Builder()
                .setCPU("AMD Ryzen 9")
                .setRAM("32GB")
                .setStorage("2TB NVMe SSD")
                .setGPU("NVIDIA RTX 4090")
                .setMotherboard("MSI MEG X570")
                .setPowerSupply("1000W")
                .setCoolingSystem("Custom Liquid Cooling")
                .build();

        System.out.println(highPerformanceComputer);
    }
}

