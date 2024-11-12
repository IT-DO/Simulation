//Главный класс приложения, содержит в себе
//Карту
//Счётчик ходов
//Рендерер поля
//Actions - список действий, исполняемых перед стартом симуляции или на каждом ходу (детали ниже)
//Методы:
//
//nextTurn() - просимулировать и отрендерить один ход
//startSimulation() - запустить бесконечный цикл симуляции и рендеринга
//pauseSimulation() - приостановить бесконечный цикл симуляции и рендеринга

public class Simulation {
    int turnCounter = 0;


    public static void main(String[] args) {


        int a = 123;
        WorldMap wordlMap = new WorldMap();
        wordlMap.setupDefaultEntitiesPosition();
        WorldConsoleRenderer renderer = new WorldConsoleRenderer();
        renderer.render(wordlMap);
    }



}
