package object.exterior;

import entity.LightSource;
import environment.Light;
import main.GamePanel;
import object.Object;

public class OBJ_Campfire2 extends LightSource {
    GamePanel gp;
    public final static String objName = "Campfire2";

    public OBJ_Campfire2(GamePanel gp, int col , int row) {
        super(gp,col,row);
        this.gp = gp;
        name = objName;
        speed = 0;
        direction = "down";
        type = typeObstacle;
        lightRadius = 300;
        collision = true;
        updateLight = true;
        getImage();
        setAction();

        solidArea.x = 8;
        solidArea.y = 8;
        solidArea.width = 24;
        solidArea.height = 24;

        solidAreaDefaultX = solidArea.x;
        solidAreaDefaultY = solidArea.y;
    }

    public void getImage() {
        int width = gp.tileSize-12;
        int height = gp.tileSize-12;

        down1 = setup("tiles/exterior/campfire", width, height);


    }
    public void interact(){
        gp.player.attackCanceled = false;
        gp.player.shotCanceled = false;
    }
}
