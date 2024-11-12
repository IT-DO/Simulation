import java.util.*;

//Карта, содержит в себе коллекцию для хранения существ и их расположения.
//Советую не спешить использовать двумерный массив или список списков, а подумать какие ещё коллекции могут подойти.
public class WorldMap {

    private int ROCK_COUNT = 3;
    private int GRASS_COUNT = 3;
    private int TREE_COUNT = 3;
    private int HERBIVORE_COUNT = 3;
    private int PREDATOR_COUNT = 3;
    private int WORLDMAP_FILES_SIZE = 10;
    private int WORLDMAP_RANKS_SIZE = 10;
    private Random r = new Random();
    HashSet<Coordinates> set = new HashSet<>();

    HashMap<Coordinates, Entity> entities = new HashMap<>();

    public void setEntities(Coordinates coordinates, Entity entitie) {
        entitie.coordinates = coordinates;
        entities.put(coordinates, entitie);
    }

    public Entity getEntity(Coordinates coordinates) {
        return entities.get(coordinates);
    }

    public void setupDefaultEntitiesPosition() {
        for (int i = 0; i < GRASS_COUNT; i++) {
            Coordinates coordinates = generateEmptyRandomCoordinates();
            setEntities(coordinates, new Grass(coordinates));
            //System.out.println("создал сущность");

        }

        for (int i = 0; i < TREE_COUNT; i++) {
            Coordinates coordinates = generateEmptyRandomCoordinates();
            setEntities(coordinates, new Tree(coordinates, 20));
            //System.out.println("создал сущность");
        }

        for (int i = 0; i < ROCK_COUNT; i++) {
            Coordinates coordinates = generateEmptyRandomCoordinates();
            setEntities(coordinates, new Rock(coordinates));
            //System.out.println("создал сущность");
        }

        for (int i = 0; i < PREDATOR_COUNT; i++) {
            Coordinates coordinates = generateEmptyRandomCoordinates();
            setEntities(coordinates, new Predator(coordinates, 20, 3, 20));
            //System.out.println("создал сущность");
        }

        for (int i = 0; i < HERBIVORE_COUNT; i++) {
            Coordinates coordinates = generateEmptyRandomCoordinates();
            setEntities(coordinates, new Herbivore(coordinates, 20, 3));
            //.out.println("создал сущность");
        }

    }



    private Coordinates generateEmptyRandomCoordinates() {
        int randomFile = r.nextInt(WORLDMAP_FILES_SIZE);
        int randomRank = r.nextInt(WORLDMAP_RANKS_SIZE);

        Coordinates coordinates = new Coordinates(randomFile,randomRank);
        if (set.contains(coordinates)) {
            return generateEmptyRandomCoordinates();
        } else {
            set.add(coordinates);
            return coordinates;
        }
    }
}
