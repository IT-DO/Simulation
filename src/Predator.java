public class Predator extends Creatrure {
    int attackPower;
    @Override
    void makeMove() {

    }

    public Predator(Coordinates coordinates, int hp, int speed, int attackPower) {
        super(coordinates, hp, speed);
        this.attackPower = attackPower;
    }
}
