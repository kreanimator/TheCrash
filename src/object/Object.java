package object;

import entity.Entity;
import main.GamePanel;

public class Object extends Entity {

    public Object (GamePanel gp, int col, int row) {
        this.gp = gp;
        this.worldX = gp.tileSize * col;
        this.worldY = gp.tileSize * row;
    }

    public Object() {

    }

    public Object(GamePanel gp) {
        this.gp=gp;
    }
}
