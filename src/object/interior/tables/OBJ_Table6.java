package object.interior.tables;

import main.GamePanel;
import object.Object;

public class OBJ_Table6 extends Object {
    GamePanel gp;
    public final static String objName = "Table6";

    public OBJ_Table6(GamePanel gp, int col , int row) {
        super(gp,col,row);
            this.gp = gp;
            name = objName;
            speed = 0;
            direction = "down";
            type = typeObstacle;
            collision = true;
            getImage();


            solidArea.x = 0;
            solidArea.y = 10;
            solidArea.width = 32;
            solidArea.height = 12;

            solidAreaDefaultX = solidArea.x;
            solidAreaDefaultY = solidArea.y;
        }

        public void getImage() {
            int width = 32;
            int height = 32;

            down1 = setup("tiles/interior/tables/table6", width, height);
        }
        public void interact(){
            gp.player.attackCanceled = false;
            gp.player.shotCanceled = false;
        }
}
