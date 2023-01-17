package object.exterior.streetlights;

import main.GamePanel;
import object.Object;

public class OBJ_Streetlight6 extends Object {

    GamePanel gp;
    public final static String objName = "Streetlight6";

    public OBJ_Streetlight6(GamePanel gp, int col , int row) {
        super(gp,col,row);
        this.gp = gp;
        name = objName;
        speed = 0;
        direction = "down";
        type = typeObstacle;
        collision = true;
        getImage();
        setAction();

        solidArea.x = 20;
        solidArea.y = 50;
        solidArea.width = 8;
        solidArea.height = 36;

        solidAreaDefaultX = solidArea.x;
        solidAreaDefaultY = solidArea.y;
    }

    public void getImage() {
        int width = gp.tileSize;
        int height = (gp.tileSize*2);

        down1 = setup("tiles/exterior/streetlight6", width, height);
    }
    public void interact(){
        gp.player.attackCanceled = false;
        gp.player.shotCanceled = false;
    }
}
