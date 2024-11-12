import java.util.Objects;

public class Coordinates {
    public final Integer file; //вертикали
    public final Integer rank; //горизонтали

    public Coordinates(Integer file, Integer rank) {
        this.file = file;
        this.rank = rank;
    }
    public Coordinates getCoordinates(Integer file, Integer rank){
        return new Coordinates(this.file, this.rank);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Coordinates that)) return false;
        return Objects.equals(file, that.file) && Objects.equals(rank, that.rank);
    }

    @Override
    public int hashCode() {
        return Objects.hash(file, rank);
    }
}
