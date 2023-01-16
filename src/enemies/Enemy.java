package enemies;

import entity.Entity;
import main.GamePanel;

public abstract class Enemy extends Entity {


    public Enemy() {

    }
    public Enemy (GamePanel gp,int col, int row) {
        this.gp = gp;
        this.worldX = gp.tileSize * col;
        this.worldY = gp.tileSize * row;
    }



}
