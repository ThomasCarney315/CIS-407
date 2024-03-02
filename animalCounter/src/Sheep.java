public class Sheep extends Animal{
    Sheep () {
        count = 0;
    }
    @Override
    void incrementCount(Animal otherAnimal) {
        count += 2;
    }
}
