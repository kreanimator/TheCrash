package object.exterior;

import main.GamePanel;
import object.Object;

public class OBJ_Conuses extends Object {
    GamePanel gp;
    public final static String objName = "Conuses";

    public OBJ_Conuses(GamePanel gp, int col , int row) {
        super(gp,col,row);
        this.gp = gp;
        name = objName;
        speed = 0;
        direction = "down";
        type = typeObstacle;
        lightRadius = 300;
        collision = true;
        getImage();
        setAction();

        solidArea.x = 8;
        solidArea.y = 8;
        solidArea.width = 28;
        solidArea.height = 24;

        solidAreaDefaultX = solidArea.x;
        solidAreaDefaultY = solidArea.y;
    }

    public void getImage() {
        int width = gp.tileSize-6;
        int height = gp.tileSize-12;

        down1 = setup("tiles/exterior/conuses", width, height);


    }
}
