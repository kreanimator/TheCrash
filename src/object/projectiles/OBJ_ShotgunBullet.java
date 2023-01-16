package object.projectiles;

import entity.Entity;
import entity.Projectiles;
import main.GamePanel;

import java.awt.*;

public class OBJ_ShotgunBullet extends Projectiles {
    public final static String objName = "ShotgunBullet";


        GamePanel gp;
        public OBJ_ShotgunBullet(GamePanel gp) {
            super(gp);
            this.gp = gp;

            name = objName;
            speed = 10;
            maxHP = 80;
            life = maxHP;
            knockBackPower = 5;
            attack = 5;
            useCost = 1;
            alive = false;
            getImage();



        }



        public void getImage(){
            up1 = setup("objects/bullet/bulletup",gp.tileSize,gp.tileSize);
            up2 = setup("objects/bullet/bulletup",gp.tileSize,gp.tileSize);
            down1 = setup("objects/bullet/bulletdown",gp.tileSize,gp.tileSize);
            down2 = setup("objects/bullet/bulletdown",gp.tileSize,gp.tileSize);
            left1 = setup("objects/bullet/bulletleft",gp.tileSize,gp.tileSize);
            left2 = setup("objects/bullet/bulletleft",gp.tileSize,gp.tileSize);
            right1  = setup("objects/bullet/bulletright",gp.tileSize,gp.tileSize);
            right2 = setup("objects/bullet/bulletright",gp.tileSize,gp.tileSize);
        }

        public boolean haveResource(Entity user){
            boolean haveResource =false;
            if( user.shotgunAmmo >= useCost){
                haveResource = true;
            }
            return haveResource;

        }
        public void subtractResource(Entity user){

                user.shotgunAmmo -= useCost;
            }

        public Color getParticleColor(){
            Color color = new Color(220, 1, 44);
            return color;
        }
        public int getParticleSize(){
            int size = 8;
            return size;
        }
        public int getParticleSpeed(){
            int speed = 1;
            return speed;
        }
        public int getParticleLife(){
            int maxHP = 10;
            return maxHP;
        }
    }

