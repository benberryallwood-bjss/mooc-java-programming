public class Cat extends Animal implements NoiseCapable {
    public Cat(String name) {
        super(name);
    }

    public Cat() {
        super("Cat");
    }

    @Override
    public void makeNoise() {
        purr();
    }

    public void purr() {
        System.out.println(getName() + " purrs");
    }
}
