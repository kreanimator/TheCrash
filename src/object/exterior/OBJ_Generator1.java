package object.exterior;

import main.GamePanel;
import object.Object;

public class OBJ_Generator1 extends Object {

    GamePanel gp;
    public final static String objName = "Generator1";



    public OBJ_Generator1(GamePanel gp, int col , int row) {
        super(gp,col,row);
        this.gp = gp;
        type = typeObstacle;
        name = objName;
        int height = gp.tileSize*2;
        int width = gp.tileSize*3;
        image = setup("tiles/exterior/generator1", width, height);

        down1 = image;
        collision = true;
        solidArea.x = gp.tileSize + 16;
        solidArea.y = 40;
        solidArea.width = gp.tileSize+20;
        solidArea.height = 36;
        solidAreaDefaultX = solidArea.x;
        solidAreaDefaultY = solidArea.y;

    }
}
