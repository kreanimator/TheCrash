package entity;

import main.GamePanel;

import java.awt.*;

public class Projectiles extends  Entity{

    Entity user;
    public Projectiles(GamePanel gp) {
        super(gp);
    }

    public void set(int worldX , int worldY, String direction, boolean alive, Entity user ) {
        this.worldX = worldX;
        this.worldY = worldY;
        this.direction = direction;
        this.alive = alive;
        this.solidArea.x = solidAreaDefaultX;
        this.solidArea.y = solidAreaDefaultY;

        this.user = user;
        this.life = this.maxHP;

    }
        public void update(){

        if(user == gp.player){

            int enemyIndex = gp.cDetector.checkEntity(this,gp.enemy);
            if(enemyIndex != 999){
                gp.player.damageEnemy(enemyIndex,this,attack, knockBackPower);
                generateParticle(user.projectiles,gp.enemy[gp.currentMap][enemyIndex]);
                alive = false;
            }
            int objIndex = gp.cDetector.checkEntity(this,gp.obj);
            if(objIndex != 999){
                Color color = new Color(63, 29, 1);
                generateParticle(user.projectiles,user.projectiles);
                alive = false;
            }
            int iTIndex = gp.cDetector.checkEntity(this,gp.iTile);
            if(iTIndex != 999){
                generateParticle(user.projectiles,user.projectiles);
                alive = false;
            }
            int npcIndex = gp.cDetector.checkEntity(this,gp.npc);
            if(npcIndex != 999){
                generateParticle(user.projectiles,gp.npc[gp.currentMap][npcIndex]);
                alive = false;
            }
        }
        if(user != gp.player ){

            boolean contactPlayer = gp.cDetector.checkPlayer(this);
            if(!gp.player.invincible && contactPlayer){
                damagePlayer(attack);
                generateParticle(user.projectiles,gp.player);
                alive = false;
            }
            int objIndex = gp.cDetector.checkEntity(this,gp.obj);
            if(objIndex != 999){
                //generateParticle(user.projectiles,gp.obj[gp.currentMap][objIndex]);
                alive = false;
            }
            int iTIndex = gp.cDetector.checkEntity(this,gp.iTile);
            if(iTIndex != 999){
                generateParticle(user.projectiles,gp.iTile[gp.currentMap][iTIndex]);
                alive = false;
            }
            int npcIndex = gp.cDetector.checkEntity(this,gp.npc);
            if(npcIndex != 999){
                generateParticle(user.projectiles,gp.npc[gp.currentMap][npcIndex]);
                alive = false;
            }
        }

        switch (direction){
            case "up" -> worldY -= speed;
            case "down" -> worldY += speed;
            case "left" -> worldX -= speed;
            case "right" -> worldX += speed;
        }
        life--;
        if (life <= 0){
            alive = false;
        }
        spriteCounter ++;

        if(spriteCounter > 12){
            if (spriteNumber == 1){
                spriteNumber =2;
            }else if(spriteNumber ==2){
                spriteNumber = 1;
            }
            spriteCounter = 0;

        }

        }
    public boolean haveResource(Entity user){
        return false;
    }
    public boolean action(Entity user){
        boolean action = false;
        return action;
    }
    public void subtractResource(Entity user){
        if(user.currentWeapon.type == typePistol) {
            user.pistolAmmo -= useCost;
        }
        if(user.currentWeapon.type == typeShotgun) {
            user.shotgunAmmo -= useCost;
        }
    }


}
