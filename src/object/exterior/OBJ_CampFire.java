package object.exterior;

import entity.Entity;
import entity.LightSource;
import entity.NPC;
import environment.Light;
import main.GamePanel;
import object.Object;
import tile_interactive.InteractiveTile;

public class OBJ_CampFire extends Object {
    GamePanel gp;
    public final static String objName = "Campfire";

    public OBJ_CampFire(GamePanel gp, int col , int row) {
        super(gp,col,row);
        this.gp = gp;

        name = objName;
        speed = 0;
        direction = "down";
        type = typeLight;
        lightRadius = 300;
        collision = true;
        updateLight = true;
        getImage();
        setAction();

        solidArea.x = 18;
        solidArea.y = 30;
        solidArea.width = 24;
        solidArea.height = 24;

        solidAreaDefaultX = solidArea.x;
        solidAreaDefaultY = solidArea.y;
    }

    public void getImage() {
        int width = gp.tileSize +12;
        int height = gp.tileSize +12;

        down1 = setup("objects/campfire/1", width, height);
        down2 = setup("objects/campfire/2",width, height);
        down3 = setup("objects/campfire/3", width, height);
        down1 = setup("objects/campfire/4", width, height);
        down2 = setup("objects/campfire/5", width, height);
        down3 = setup("objects/campfire/6", width, height);
        down1 = setup("objects/campfire/1", width, height);
        down2 = setup("objects/campfire/2",width, height);
        down3 = setup("objects/campfire/3", width, height);
        down1 = setup("objects/campfire/4", width, height);
        down2 = setup("objects/campfire/5", width, height);
        down3 = setup("objects/campfire/6", width, height);

    }
    public void interact(){
        gp.player.attackCanceled = false;
        gp.player.shotCanceled = false;
    }


}


