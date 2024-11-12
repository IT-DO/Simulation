import java.lang.reflect.GenericArrayType;
import java.util.Map;

public class WorldConsoleRenderer {
    Coordinates coordinates;

    public static final String ANSI_RESET = "\u001B[0m";

    public void render(WorldMap worldMap) {

        for (int rank = 10; rank > 1; rank--) {
            String line = "";
            for (int file = 1; file < 10; file++) {
                if (worldMap.entities.get(new Coordinates(rank, file)) != null) {
                    line += getSprite(worldMap.entities.get(new Coordinates(rank, file)));
                } else {
                    line += "\u2B1B";
                }
            }
            line += ANSI_RESET;

            System.out.println(line);
        }
    }

    public String getSprite(Entity entity) {
        String s = switch (entity.getClass().getSimpleName()) {
            case "Grass" -> "\uD83C\uDF3F";
            case "Tree" -> "\uD83C\uDF33";
            case "Rock" -> "\u26F0";
            case "Predator" -> "\uD83D\uDC3A";
            case "Herbivore" -> "\uD83D\uDC11";
            default -> "\u2B1B";
        };
        return s;
    }
}
