import java.lang.reflect.GenericArrayType;
import java.util.Map;

public class WorldConsoleRenderer {
    Coordinates coordinates;

    public static final String ANSI_RESET = "\u001B[0m";

    public void render(WorldMap worldMap) {

        for (int rank = 9; rank >= 0; rank--) {
            //System.out.println("Зашел в луп 1");
            String line = "";
            //System.out.println("Инициировал пустую line");

            for (int file = 0; file <= 9; file++) {
                //System.out.println("Зашел в луп 2");
                // if (worldMap.entities.get(new Coordinates(rank, file)) != null) {
                if (worldMap.getEntity(new Coordinates(rank, file)) != null) {
                    line += getSprite(worldMap.entities.get(new Coordinates(rank, file)));
                    //System.out.println("Добавил сущность к line");
                } else {
                    line += "\u2B1B";
                  //  System.out.println("Добавил пустое поле к line");
                }
            }

            line += ANSI_RESET;
            //System.out.println("добавил ANSI_RESET к line");
            System.out.println(line);
            //System.out.println("Вывел line");
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
