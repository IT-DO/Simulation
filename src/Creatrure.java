abstract public class Creatrure extends Entity {
    int hp;
    int speed;
    abstract void makeMove();

    public Creatrure(Coordinates coordinates, int hp, int speed) {
        super(coordinates);
        this.hp = hp;
        this.speed = speed;
    }
}
