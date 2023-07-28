package service.interfaces;

import model.*;

import java.util.List;

public interface ILoadService {
    public List<Villain> loadVillains();
    public MarioBaseCharacter loadMario();
    public MarioBaseCharacter loadLuigi();
    public Map loadMap();

}
