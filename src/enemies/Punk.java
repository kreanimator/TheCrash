package enemies;

import entity.Entity;
import main.GamePanel;
import object.misc.OBJ_HPPack;
import object.misc.OBJ_Money;
import object.weapon.OBJ_Ammo_Pistol;
import object.weapon.OBJ_Ammo_Shotgun;
import object.projectiles.OBJ_Bullet;

import java.util.Random;

public class Punk extends Enemy {
    GamePanel gp;


    public Punk(GamePanel gp, int col, int row) {
        super(gp, col,row);
        this.gp = gp;
        type = typeEnemy;
        name = "Punk";

        defaultSpeed = 1;
        speed = defaultSpeed;
        maxHP = 6;
        life = maxHP;
        attack = 5;
        defense = 2;
        exp = 15;
        projectiles = new OBJ_Bullet(gp);

        solidArea.x = 14;
        solidArea.y = 16;
        solidArea.width = 24;
        solidArea.height = 32;
        solidAreaDefaultX = solidArea.x;
        solidAreaDefaultY = solidArea.y;
        attackArea.width = 48;
        attackArea.height = 48;
        knockBackPower = 5;
        motion1Duration = 20;
        motion2Duration = 40;
        motion3Duration = 60;
        getImage();
        getAtkImage();
    }

    public void getImage() {
        up1 = setup("enemies/punk/up1", gp.tileSize , gp.tileSize );
        up2 = setup("enemies/punk/up2", gp.tileSize , gp.tileSize );
        up3 = setup("enemies/punk/up3", gp.tileSize , gp.tileSize);

        down1 = setup("enemies/punk/down1", gp.tileSize , gp.tileSize );
        down2 = setup("enemies/punk/down2", gp.tileSize , gp.tileSize );
        down3 = setup("enemies/punk/down3", gp.tileSize , gp.tileSize );

        left1 = setup("enemies/punk/left1", gp.tileSize , gp.tileSize);
        left2 = setup("enemies/punk/left2", gp.tileSize , gp.tileSize );
        left3 = setup("enemies/punk/left3", gp.tileSize , gp.tileSize);

        right1 = setup("enemies/punk/right1", gp.tileSize , gp.tileSize);
        right2 = setup("enemies/punk/right2", gp.tileSize , gp.tileSize );
        right3 = setup("enemies/punk/right3", gp.tileSize , gp.tileSize );

    }
    public void getAtkImage() {
        atkup1 = setup("enemies/punk/attack/up1", gp.tileSize, gp.tileSize*2);
        atkup2 = setup("enemies/punk/attack/up2", gp.tileSize, gp.tileSize*2);
        atkup3 = setup("enemies/punk/attack/up3", gp.tileSize, gp.tileSize*2);

        atkdown1 = setup("enemies/punk/attack/down1", gp.tileSize, gp.tileSize*2);
        atkdown2 = setup("enemies/punk/attack/down2", gp.tileSize, gp.tileSize*2);
        atkdown3 = setup("enemies/punk/attack/down3", gp.tileSize, gp.tileSize*2);

        atkleft1 = setup("enemies/punk/attack/left1", gp.tileSize*2, gp.tileSize );
        atkleft2 = setup("enemies/punk/attack/left2", gp.tileSize*2, gp.tileSize );
        atkleft3 = setup("enemies/punk/attack/left3", gp.tileSize*2, gp.tileSize );

        atkright1 = setup("enemies/punk/attack/right1", gp.tileSize*2, gp.tileSize );
        atkright2 = setup("enemies/punk/attack/right2", gp.tileSize*2, gp.tileSize );
        atkright3 = setup("enemies/punk/attack/right3", gp.tileSize*2, gp.tileSize );

    }

    public void setAction() {

        //Check if stops chasing
        if (onPath) {
            //Check if stops chasing
            checkStopChasing(gp.player, 15, 50);
            //Search the direction
            speed = 2;
            searchPath(getGoalCol(gp.player), getGoalCRow(gp.player));
            //Shoots
            //checkShoot(100, 30, 12);

        }
        else {
            //Check if it starts chasing
            checkStartChasing(gp.player, 5, 50);
            getRandomDirection(50);

        }
        //Check if it attacks


        if(!attacking){
            checkAttacking(30,gp.tileSize*4,gp.tileSize);
        }
    }


    public void damageReaction() {
        actionLockCounter = 0;
        direction = gp.player.direction;

    }

    public void playSE() {
        gp.playSE(7);

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
