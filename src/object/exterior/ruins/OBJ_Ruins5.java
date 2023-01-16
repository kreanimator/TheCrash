package object.exterior.ruins;

import main.GamePanel;
import object.Object;

public class OBJ_Ruins5 extends Object {

    GamePanel gp;
    public final static String objName = "Ruins5";

    public OBJ_Ruins5(GamePanel gp, int col , int row) {
        super(gp,col,row);
        this.gp = gp;
        name = objName;
        speed = 0;
        direction = "down";
        type = typeObstacle;
        collision = true;
        getImage();
        setAction();

        solidArea.x = 10;
        solidArea.y = 20;
        solidArea.width = 30;
        solidArea.height = 12;

        solidAreaDefaultX = solidArea.x;
        solidAreaDefaultY = solidArea.y;
    }

    public void getImage() {
        int width = gp.tileSize;
        int height = gp.tileSize;

        down1 = setup("tiles/exterior/ruins5", width, height);


    }

}
