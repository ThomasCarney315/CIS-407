public class Alligator extends Animal{
    Alligator () {
        count = 0;
    }
    @Override
    void incrementCount(Animal sheep) {
        count += 1;
        if(sheep.count > 0) {
            sheep.count -= 1;
        }
    }
}
