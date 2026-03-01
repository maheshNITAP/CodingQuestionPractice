package LLD.bridgeDesignPattern;

public class Client {
    public static void main(String[] args) {
        System.out.println("======= Bridge Design Pattern - Solution Demo ======");

        LivingThings dog = new Dog(new LungBreathing());
        LivingThings fish = new Fish(new GillBreathing());
        LivingThings tree = new Tree(new Photosynthesis());

        dog.breath(); // Output: Dog is Breathing through lungs.
        fish.breath(); // Output: Fish is Breathing through gills.
        tree.breath(); // Output: Tree is Breathing through process of photosynthesis. Releases Oxygen through leaves.
    }
}
