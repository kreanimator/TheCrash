package object.exterior.doors;

import entity.Entity;
import main.GamePanel;
import object.Object;

public class OBJ_BunkerDoor extends Object {
    GamePanel gp;
    public final static String objName ="Bunker Door";
    public OBJ_BunkerDoor(GamePanel gp, int col, int row) {
        super(gp,col,row);
        type = typeObstacle;
        name = objName;
        image = setup("tiles/exterior/doors/bunkerdoor", gp.tileSize, gp.tileSize);
        image2 = setup("tiles/exterior/doors/bunkerdoor2", gp.tileSize, gp.tileSize);
        down1 = image;
        collision = true;
        this.gp = gp;
        solidArea.x = 0;
        solidArea.y = 0;
        solidArea.width = 48;
        solidArea.height = 48;
        solidAreaDefaultX = solidArea.x;
        solidAreaDefaultY = solidArea.y;
        setDialog();

    }
    public void setDialog(){
        dialogues[0][0] = "You need a key card to open it!";
        dialogues[1][0] = "You've opened an old bunker!";

    }

    public void interact() {
        if (!opened){
            startDialogue(this,0);
        }
        else {
//            startDialogue(this,1);
//            gp.playSE(2);
            down1 = image2;
//
//            opened = true;
//            collision = false;
        }

    }
    }

