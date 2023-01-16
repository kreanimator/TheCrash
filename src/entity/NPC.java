package entity;

import main.GamePanel;

public abstract class NPC extends Entity{

    public NPC() {

    }
    public NPC (GamePanel gp, int col, int row) {
        this.gp = gp;
        this.worldX = gp.tileSize * col;
        this.worldY = gp.tileSize * row;
    }
}
