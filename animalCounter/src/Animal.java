public abstract class Animal {
    int count;
    void resetCount() {
        count = 0;
    }
    int getCount() {
        return count;
    }
    abstract void incrementCount(Animal otherAnimal);
}
