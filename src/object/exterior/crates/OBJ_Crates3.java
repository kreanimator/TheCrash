package object.exterior.crates;

import main.GamePanel;
import object.Object;

public class OBJ_Crates3 extends Object {
    GamePanel gp;
    public final static String objName = "Crates3";

    public OBJ_Crates3(GamePanel gp, int col , int row) {
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

        solidArea.x = 14;
        solidArea.y = 12;
        solidArea.width = 22;
        solidArea.height = 22;

        solidAreaDefaultX = solidArea.x;
        solidAreaDefaultY = solidArea.y;
    }

    public void getImage() {
        int width = gp.tileSize;
        int height = gp.tileSize;

        down1 = setup("tiles/exterior/crates3", width, height);


    }
}
