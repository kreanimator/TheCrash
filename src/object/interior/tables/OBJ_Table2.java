package object.interior.tables;

import main.GamePanel;
import object.Object;

public class OBJ_Table2 extends Object {
    GamePanel gp;
    public final static String objName = "Table2";

    public OBJ_Table2(GamePanel gp, int col , int row) {
        super(gp,col,row);
        this.gp = gp;
        name = objName;
        speed = 0;
        direction = "down";
        type = typeObstacle;
        collision = true;
        getImage();


        solidArea.x = 0;
        solidArea.y = 14;
        solidArea.width = 40;
        solidArea.height = 12;

        solidAreaDefaultX = solidArea.x;
        solidAreaDefaultY = solidArea.y;
    }

    public void getImage() {
        int width = 40;
        int height = 40;

        down1 = setup("tiles/interior/tables/table2", width, height);
    }
    public void interact(){
        gp.player.attackCanceled = false;
        gp.player.shotCanceled = false;
    }
}
