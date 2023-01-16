package enemies;


import main.GamePanel;
import object.misc.OBJ_HPPack;
import object.misc.OBJ_Money;

import java.util.Random;

public class Bug1 extends Enemy {

    public Bug1(GamePanel gp) {
        this.gp = gp;
        type = typeEnemy;
        name = "Green bug";

        defaultSpeed = 1;
        speed = defaultSpeed;
        maxHP = 4;
        life = maxHP;
        attack = 5;
        defense = 0;
        exp = 10;

        solidArea.x = 0;
        solidArea.y = 0;
        solidArea.width = 24;
        solidArea.height = 24;
        solidAreaDefaultX = solidArea.x;
        solidAreaDefaultY = solidArea.y;
        getImage();


    }
    public Bug1 (GamePanel gp, int col, int row){
        super(gp,col,row);

        type = typeEnemy;
        name = "Green bug";

        defaultSpeed = 1;
        speed = defaultSpeed;
        maxHP = 4;
        life = maxHP;
        attack = 5;
        defense = 0;
        exp = 10;

        solidArea.x = 0;
        solidArea.y = 0;
        solidArea.width = 24;
        solidArea.height = 24;
        solidAreaDefaultX = solidArea.x;
        solidAreaDefaultY = solidArea.y;
        getImage();



    }




    public void getImage() {
        int size = gp.tileSize - 20;
        up1 = setup("enemies/bug1/up1", size, size);
        up2 = setup("enemies/bug1/up2", size, size);
        up3 = setup("enemies/bug1/up3", size, size);

        down1 = setup("enemies/bug1/down1", size, size);
        down2 = setup("enemies/bug1/down3", size, size);
        down3 = setup("enemies/bug1/down2", size, size);

        left1 = setup("enemies/bug1/left1", size, size);
        left2 = setup("enemies/bug1/left2", size, size);
        left3 = setup("enemies/bug1/left3", size, size);

        right1 = setup("enemies/bug1/right1", size, size);
        right2 = setup("enemies/bug1/right2", size, size);
        right3 = setup("enemies/bug1/right3", size, size);

    }

    public void setAction() {

        if (onPath) {
            //Search the direction
            searchPath(getGoalCol(gp.player), getGoalCRow(gp.player));
            //Check stop chasing
            checkStopChasing(gp.player, 15, 100);
        } else {
            getRandomDirection(50);
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
