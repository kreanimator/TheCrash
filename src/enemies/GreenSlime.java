package enemies;

import entity.Entity;
import main.GamePanel;
import object.misc.OBJ_HPPack;
import object.misc.OBJ_Money;

import java.util.Random;

public class GreenSlime extends Enemy {

    GamePanel gp;


    public GreenSlime(GamePanel gp, int col, int row) {
        super(gp, col, row);
        this.gp = gp;
        type = typeEnemy;
        name = "Green Slime";

        defaultSpeed = 1;
        speed = defaultSpeed;
        maxHP = 4;
        life = maxHP;
        attack = 5;
        defense = 0;
        exp = 10;

        solidArea.x = 9;
        solidArea.y = 18;
        solidArea.width = 16;
        solidArea.height = 16;
        solidAreaDefaultX = solidArea.x;
        solidAreaDefaultY = solidArea.y;
        getImage();



    }

    public void getImage() {
        up1 = setup("enemies/slime/1", gp.tileSize - 10, gp.tileSize - 10);
        up2 = setup("enemies/slime/2", gp.tileSize - 10, gp.tileSize - 10);
        up3 = setup("enemies/slime/3", gp.tileSize - 10, gp.tileSize - 10);

        down1 = setup("enemies/slime/4", gp.tileSize - 10, gp.tileSize - 10);
        down2 = setup("enemies/slime/5", gp.tileSize - 10, gp.tileSize - 10);
        down3 = setup("enemies/slime/6", gp.tileSize - 10, gp.tileSize - 10);

        left1 = setup("enemies/slime/1", gp.tileSize - 10, gp.tileSize - 10);
        left2 = setup("enemies/slime/2", gp.tileSize - 10, gp.tileSize - 10);
        left3 = setup("enemies/slime/3", gp.tileSize - 10, gp.tileSize - 10);

        right1 = setup("enemies/slime/4", gp.tileSize - 10, gp.tileSize - 10);
        right2 = setup("enemies/slime/5", gp.tileSize - 10, gp.tileSize - 10);
        right3 = setup("enemies/slime/6", gp.tileSize - 10, gp.tileSize - 10);

    }

    public void setAction() {

        if (onPath) {
            //Search the direction
            searchPath(getGoalCol(gp.player), getGoalCRow(gp.player));
            //Check stop chasing
            checkStopChasing(gp.player, 15, 100);
        } else {
            getRandomDirection(100);
        }
    }

    public void damageReaction() {
        actionLockCounter = 0;
        onPath = true;
    }

    public void playSE() {
        gp.playSE(5);

    }

    public void checkDrop() {
        int i = new Random().nextInt(100) + 1;

        //SET THE MONSTER DROP

        if (i < 50) {
            dropItem(new OBJ_Money(gp));
        }
        if (i >= 50 && i < 100) {
            dropItem(new OBJ_HPPack(gp));
        }

    }
}
