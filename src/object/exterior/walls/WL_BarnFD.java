package object.exterior.walls;

import main.GamePanel;
import object.Object;

public class WL_BarnFD extends Object {
    GamePanel gp;
    public final static String objName = "BarnFD";

    public WL_BarnFD(GamePanel gp, int col, int row) {
        super(gp, col , row);
        this.gp = gp;
        name = objName;
        speed = 0;
        direction = "down";
        type = typeObstacle;


        collision = true;
        getImage();


        solidArea.x = gp.tileSize+12;
        solidArea.y = 48;
        solidArea.width = (gp.tileSize * 9)+32;
        solidArea.height = 12;

        solidAreaDefaultX = solidArea.x;
        solidAreaDefaultY = solidArea.y;
    }

    public void getImage() {
        int height = (gp.tileSize*2)-24 ;
        int width = (gp.tileSize * 11)+12;

        down1 = setup("tiles/wall/barnfd", width, height);

    }

    public void interact(){
        gp.player.attackCanceled = false;
        gp.player.shotCanceled = false;
    }
}
