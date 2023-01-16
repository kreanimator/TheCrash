package object.exterior.crates;

import main.GamePanel;
import object.Object;

public class OBJ_Crates6 extends Object {
    GamePanel gp;
    public final static String objName = "Crates6";

    public OBJ_Crates6(GamePanel gp, int col , int row) {
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

        solidArea.x = 16;
        solidArea.y = 12;
        solidArea.width = 32;
        solidArea.height = 32;

        solidAreaDefaultX = solidArea.x;
        solidAreaDefaultY = solidArea.y;
    }

    public void getImage() {
        int width = gp.tileSize+12;
        int height = gp.tileSize+12;

        down1 = setup("tiles/exterior/crates6", width, height);


    }
}
