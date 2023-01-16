package object.misc;

import entity.Entity;
import main.GamePanel;

public class OBJ_Flashlight extends Entity {
    public final static String objName = "Flashlight";

    public OBJ_Flashlight(GamePanel gp) {
        super(gp);
        type = typeLight;
        name = objName;
        down1 = setup("objects/flashlight",gp.tileSize/2,gp.tileSize/2);
        description = "[FlashLight]\nLights your way\nEven in absolute darkness";
        price = 200;
        lightRadius = 400;
    }
}
