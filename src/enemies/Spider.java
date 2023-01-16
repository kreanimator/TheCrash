package enemies;

import entity.Entity;
import main.GamePanel;
import object.misc.OBJ_HPPack;
import object.misc.OBJ_Money;
import object.projectiles.OBJ_Acid;
import object.projectiles.OBJ_Bullet;
import object.weapon.OBJ_Ammo_Pistol;
import object.weapon.OBJ_Ammo_Shotgun;

import java.util.Random;

public class Spider extends Enemy {
    GamePanel gp;


    public Spider(GamePanel gp, int col, int row) {
        super(gp, col, row);
        this.gp = gp;
        type = typeEnemy;
        name = "Spider";

        defaultSpeed = 2;
        speed = defaultSpeed;
        maxHP = 10;
        life = maxHP;
        attack = 5;
        defense = 2;
        exp = 50;
        projectiles = new OBJ_Acid(gp);
        knockBackPower = 3;


        solidArea.x = 3;
        solidArea.y = 10;
        solidArea.width = 42;
        solidArea.height = 30;
        solidAreaDefaultX = solidArea.x;
        solidAreaDefaultY = solidArea.y;
        getImage();



    }

    public void getImage() {
        up1 = setup("enemies/spider/up1", gp.tileSize , gp.tileSize );
        up2 = setup("enemies/spider/up2", gp.tileSize , gp.tileSize );
        up3 = setup("enemies/spider/up3", gp.tileSize , gp.tileSize );

        down1 = setup("enemies/spider/down1", gp.tileSize , gp.tileSize );
        down2 = setup("enemies/spider/down2", gp.tileSize , gp.tileSize );
        down3 = setup("enemies/spider/down3", gp.tileSize , gp.tileSize );

        left1 = setup("enemies/spider/left1", gp.tileSize , gp.tileSize );
        left2 = setup("enemies/spider/left2", gp.tileSize , gp.tileSize );
        left3 = setup("enemies/spider/left3", gp.tileSize , gp.tileSize );

        right1 = setup("enemies/spider/right1", gp.tileSize , gp.tileSize );
        right2 = setup("enemies/spider/right2", gp.tileSize , gp.tileSize );
        right3 = setup("enemies/spider/right3", gp.tileSize , gp.tileSize );

    }

    public void setAction() {

        if (onPath) {
            speed =3;

            //Check if stops chasing
            checkStopChasing(gp.player, 15, 100);

            //Search the direction
            searchPath(getGoalCol(gp.player), getGoalCRow(gp.player));
            //Shoots
            checkShoot(100, 30, 24);

        }
        else {
            //Check if it starts chasing
            checkStartChasing(gp.player, 5, 50);


                getRandomDirection(20);

            }
        }


    public void damageReaction() {
        actionLockCounter = 0;
        direction = gp.player.direction;
    }
    public void playSE() {
        gp.playSE(5);
    }

    public void checkDrop() {
        int i = new Random().nextInt(100) + 1;

        //SET THE MONSTER DROP

        if (i < 25) {
            dropItem(new OBJ_Money(gp));
        }
        if (i >= 25 && i < 50) {
            dropItem(new OBJ_HPPack(gp));
        }
        if (i >= 50 && i < 75) {
            dropItem(new OBJ_Ammo_Pistol(gp));
        }
        if (i >= 75 && i < 100) {
            dropItem(new OBJ_Ammo_Shotgun(gp));
        }

    }
}
