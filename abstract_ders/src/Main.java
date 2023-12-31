
import model.*;
import service.LoadService;
import service.MapService;
import service.interfaces.ILoadService;
import service.interfaces.IMapService;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        ILoadService iLoadService = new LoadService();
        IMapService iMapService = new MapService();

        Map map = iLoadService.loadMap();
        MarioBaseCharacter mario = iLoadService.loadMario();
        MarioBaseCharacter luigi = iLoadService.loadLuigi();
        List<Villain> villainList = iLoadService.loadVillains();

        iMapService.putVillainsToMap(map, villainList);

        System.out.println(map);
        System.out.println(mario);
        System.out.println(luigi);
        System.out.println(villainList);

        iMapService.printMap(map);
    }
}