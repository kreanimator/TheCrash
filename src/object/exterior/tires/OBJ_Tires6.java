package object.exterior.tires;

import main.GamePanel;
import object.Object;

public class OBJ_Tires6 extends Object {
    GamePanel gp;
    public final static String objName = "Tires6";

    public OBJ_Tires6(GamePanel gp, int col , int row) {
        super(gp,col,row);
        this.gp = gp;
        name = objName;
        speed = 0;
        direction = "down";
        type = typeObstacle;
        collision = true;
        getImage();
        setAction();

        solidArea.x = 8;
        solidArea.y = 8;
        solidArea.width = 12;
        solidArea.height = 12;

        solidAreaDefaultX = solidArea.x;
        solidAreaDefaultY = solidArea.y;
    }

    public void getImage() {
        int width = gp.tileSize-12;
        int height = gp.tileSize-12;

        down1 = setup("tiles/exterior/tires6", width, height);


    }
    public void interact(){
        gp.player.attackCanceled = false;
        gp.player.shotCanceled = false;
    }
}
