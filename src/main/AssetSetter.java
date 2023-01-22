package main;

import data.Progress;
import enemies.*;
import entity.*;
import object.exterior.barrels.*;
import object.exterior.*;
import object.exterior.doors.*;
import object.exterior.fences.*;
import object.exterior.toilets.*;
import object.exterior.fridges.*;
import object.misc.*;
import object.exterior.trash.*;
import object.trees.*;
import object.exterior.walls.*;
import tile_interactive.*;


public class AssetSetter {


    GamePanel gp;

    public AssetSetter(GamePanel gp) {
        this.gp = gp;
    }

    public void setObject() {

        //LEVEL 1
        int mapNum = 0;
        int i =0;

        //FENCE
        gp.obj[mapNum][i] = new OBJ_Fence1(gp,81,48);i++;
        gp.obj[mapNum][i] = new OBJ_Fence1(gp,83,48);i++;
        gp.obj[mapNum][i] = new OBJ_Fence1(gp,85,48);i++;
        gp.obj[mapNum][i] = new OBJ_Fence1(gp,79,48);i++;
        gp.obj[mapNum][i] = new OBJ_Fence1(gp,77,48);i++;
        gp.obj[mapNum][i] = new OBJ_Fence1(gp,75,48);i++;
        gp.obj[mapNum][i] = new OBJ_Fence2(gp,73,48);i++;
        gp.obj[mapNum][i] = new OBJ_Fence1(gp,71,48);i++;
        gp.obj[mapNum][i] = new OBJ_Fence1(gp,69,48);i++;
        gp.obj[mapNum][i] = new OBJ_Fence1(gp,67,48);i++;
        gp.obj[mapNum][i] = new OBJ_Fence1(gp,65,48);i++;
        gp.obj[mapNum][i] = new OBJ_Fenceside1(gp,87,49);i++;
        gp.obj[mapNum][i] = new OBJ_Fenceside1(gp,87,51);i++;
        gp.obj[mapNum][i] = new OBJ_Fenceside1(gp,87,53);i++;
        gp.obj[mapNum][i] = new OBJ_Fenceside1(gp,87,55);i++;
        gp.obj[mapNum][i] = new OBJ_Fenceside1(gp,87,57);i++;
        gp.obj[mapNum][i] = new OBJ_Fenceside1(gp,87,59);i++;
        gp.obj[mapNum][i] = new OBJ_Fenceside1(gp,87,61);i++;
        gp.obj[mapNum][i] = new OBJ_Fenceside1(gp,87,63);i++;
        gp.obj[mapNum][i] = new OBJ_Fenceside1(gp,87,65);i++;
        gp.obj[mapNum][i] = new OBJ_Fenceside1(gp,87,67);i++;

//
        gp.obj[mapNum][i] = new OBJ_Fence3(gp,81,68);i++;
        gp.obj[mapNum][i] = new OBJ_Fence4(gp,83,68);i++;
        gp.obj[mapNum][i] = new OBJ_Fence3(gp,85,68);i++;
        gp.obj[mapNum][i] = new OBJ_Fence3(gp,79,68);i++;
        gp.obj[mapNum][i] = new OBJ_Fence3(gp,77,68);i++;
        gp.obj[mapNum][i] = new OBJ_Fence3(gp,75,68);i++;
        gp.obj[mapNum][i] = new OBJ_Fence4(gp,73,68);i++;
        gp.obj[mapNum][i] = new OBJ_Fence3(gp,71,68);i++;
        gp.obj[mapNum][i] = new OBJ_Fence3(gp,69,68);i++;
        gp.obj[mapNum][i] = new OBJ_Fence3(gp,67,68);i++;
        gp.obj[mapNum][i] = new OBJ_Fence3(gp,65,68);i++;
        gp.obj[mapNum][i] = new OBJ_Fenceside1(gp,65,49);i++;
        gp.obj[mapNum][i] = new OBJ_Fenceside1(gp,65,51);i++;
        gp.obj[mapNum][i] = new OBJ_Fenceside1(gp,65,53);i++;
        gp.obj[mapNum][i] = new OBJ_Fenceside1(gp,65,55);i++;
        gp.obj[mapNum][i] = new OBJ_Fenceside1(gp,65,57);i++;
        gp.obj[mapNum][i] = new OBJ_Fenceside1(gp,65,59);i++;
        gp.obj[mapNum][i] = new OBJ_Fenceside1(gp,65,60);i++;
        gp.obj[mapNum][i] = new OBJ_Fenceside1(gp,65,63);i++;
        gp.obj[mapNum][i] = new OBJ_Fenceside1(gp,65,65);i++;
        gp.obj[mapNum][i] = new OBJ_Fenceside1(gp,65,67);i++;

        //
        gp.obj[mapNum][i] = new OBJ_Fenceside1(gp,13,13);i++;
        gp.obj[mapNum][i] = new OBJ_Fenceside1(gp,13,15);i++;
        gp.obj[mapNum][i] = new OBJ_Fenceside1(gp,13,17);i++;
        gp.obj[mapNum][i] = new OBJ_Fenceside1(gp,13,19);i++;
        gp.obj[mapNum][i] = new OBJ_Fenceside1(gp,13,20);i++;

        gp.obj[mapNum][i] = new OBJ_Fenceside1(gp,23,13);i++;
        gp.obj[mapNum][i] = new OBJ_Fenceside1(gp,23,15);i++;
        gp.obj[mapNum][i] = new OBJ_Fenceside1(gp,23,18);i++;
        gp.obj[mapNum][i] = new OBJ_Fenceside1(gp,23,19);i++;
        gp.obj[mapNum][i] = new OBJ_Fenceside1(gp,23,20);i++;

        gp.obj[mapNum][i] = new OBJ_Fence1(gp,13,12);i++;
        gp.obj[mapNum][i] = new OBJ_Fence2(gp,15,12);i++;
        gp.obj[mapNum][i] = new OBJ_Fence1(gp,17,12);i++;
        gp.obj[mapNum][i] = new OBJ_Fence1(gp,19,12);i++;
        gp.obj[mapNum][i] = new OBJ_Fence1(gp,21,12);i++;

        gp.obj[mapNum][i] = new OBJ_Fence3(gp,13,21);i++;
        gp.obj[mapNum][i] = new OBJ_Fence4(gp,15,21);i++;
        gp.obj[mapNum][i] = new OBJ_Fence3(gp,17,21);i++;
        gp.obj[mapNum][i] = new OBJ_Fence4(gp,19,21);i++;
        gp.obj[mapNum][i] = new OBJ_Fence3(gp,21,21);i++;



        //BUILDINGS
        gp.obj[mapNum][i] = new WL_Sidewall(gp,31,85);i++;
        gp.obj[mapNum][i] = new WL_Sidewall(gp,31,83);i++;
        gp.obj[mapNum][i] = new WL_Sidewall(gp,31,82);i++;
        gp.obj[mapNum][i] = new WL_Sidewall(gp,42,85);i++;
        gp.obj[mapNum][i] = new WL_Sidewall(gp,42,83);i++;
        gp.obj[mapNum][i] = new WL_Sidewall(gp,42,82);i++;
        gp.obj[mapNum][i] = new WL_Barn(gp,31,86);i++;
        gp.obj[mapNum][i] = new WL_BarnBD(gp,31,81);i++;

        gp.obj[mapNum][i] = new WL_Sidewall(gp,76,12);i++;
        gp.obj[mapNum][i] = new WL_Sidewall(gp,76,14);i++;
        gp.obj[mapNum][i] = new WL_Sidewall(gp,87,12);i++;
        gp.obj[mapNum][i] = new WL_Sidewall(gp,87,14);i++;
        gp.obj[mapNum][i] = new WL_Brick2(gp,76,11);i++;
        gp.obj[mapNum][i] = new WL_BrickFD(gp,76,15);i++;
        gp.obj[mapNum][i] = new OBJ_Door2(gp,76,15);i++;
        gp.obj[mapNum][i] = new WL_Sidewall(gp,48,11);i++;
        gp.obj[mapNum][i] = new WL_Sidewall(gp,48,12);i++;
        gp.obj[mapNum][i] = new WL_Sidewall(gp,48,14);i++;
        gp.obj[mapNum][i] = new WL_Sidewall(gp,59,11);i++;
        gp.obj[mapNum][i] = new WL_Sidewall(gp,59,12);i++;
        gp.obj[mapNum][i] = new WL_Sidewall(gp,59,14);i++;
        gp.obj[mapNum][i] = new WL_Brick3(gp,48,10);i++;
        gp.obj[mapNum][i] = new WL_BrickFD(gp,48,15);i++;
        gp.obj[mapNum][i] = new OBJ_Door2(gp,48,15);i++;
        gp.obj[mapNum][i] = new WL_Sidewall(gp,70,23);i++;
        gp.obj[mapNum][i] = new WL_Sidewall(gp,70,25);i++;
        gp.obj[mapNum][i] = new WL_Sidewall(gp,70,27);i++;
        gp.obj[mapNum][i] = new WL_Sidewall(gp,60,23);i++;
        gp.obj[mapNum][i] = new WL_Sidewall(gp,60,25);i++;
        gp.obj[mapNum][i] = new WL_Sidewall(gp,60,27);i++;
        gp.obj[mapNum][i] = new WL_RuinedWallFD(gp,60,28);i++;
        gp.obj[mapNum][i] = new OBJ_Door(gp, 60,28);i++;
        gp.obj[mapNum][i] = new WL_RuinedWall2(gp,60,22);i++;

        gp.obj[mapNum][i] = new WL_Factory1(gp,17,60);i++;
        gp.obj[mapNum][i] = new WL_Factory3(gp,23,60);i++;
        gp.obj[mapNum][i] = new WL_Factory1(gp,28,60);i++;
        gp.obj[mapNum][i] = new OBJ_FactoryDoor(gp,33,60);i++;
        gp.obj[mapNum][i] = new WL_FactoryWall5(gp,22,60);i++;
        gp.obj[mapNum][i] = new WL_Factory1(gp,34,60);i++;
        gp.obj[mapNum][i] = new WL_Factory3(gp,39,60);i++;

        gp.obj[mapNum][i] = new WL_Factory2(gp,17,37);i++;
        gp.obj[mapNum][i] = new WL_Factory4(gp,23,37);i++;
        gp.obj[mapNum][i] = new WL_Factory2(gp,28,37);i++;
        gp.obj[mapNum][i] = new WL_FactoryWall6(gp,33,37);i++;
        gp.obj[mapNum][i] = new WL_FactoryWall6(gp,22,37);i++;
        gp.obj[mapNum][i] = new WL_Factory4(gp,34,37);i++;
        gp.obj[mapNum][i] = new WL_Factory2(gp,39,37);i++;


        gp.obj[mapNum][i] = new WL_Oldwall(gp,17,42);i++;
        gp.obj[mapNum][i] = new WL_Oldwall2(gp,24,42);i++;
        gp.obj[mapNum][i] = new WL_Oldwall(gp,31,42);i++;
        gp.obj[mapNum][i] = new WL_Oldwall(gp,37,47);i++;
        gp.obj[mapNum][i] = new WL_Oldwall2(gp,30,47);i++;
        gp.obj[mapNum][i] = new WL_Oldwall(gp,23,47);i++;
        gp.obj[mapNum][i] = new WL_Oldwall(gp,17,52);i++;
        gp.obj[mapNum][i] = new WL_Oldwall2(gp,24,52);i++;
        gp.obj[mapNum][i] = new WL_Oldwall(gp,31,52);i++;
        gp.obj[mapNum][i] = new WL_Oldwall(gp,37,57);i++;
        gp.obj[mapNum][i] = new WL_Oldwall2(gp,30,57);i++;
        gp.obj[mapNum][i] = new WL_Oldwall(gp,23,57);i++;
        gp.obj[mapNum][i] = new WL_Brickpart2(gp,22,57);i++;
        gp.obj[mapNum][i] = new WL_Brickpart2(gp,22,47);i++;
        gp.obj[mapNum][i] = new WL_Brickpart1(gp,38,42);i++;
        gp.obj[mapNum][i] = new WL_Brickpart1(gp,38,52);i++;

        gp.obj[mapNum][i] = new WL_Sidewall(gp,17,38);i++;
        gp.obj[mapNum][i] = new WL_Sidewall(gp,17,40);i++;
        gp.obj[mapNum][i] = new WL_Sidewall(gp,17,42);i++;
        gp.obj[mapNum][i] = new WL_Sidewall(gp,17,44);i++;
        gp.obj[mapNum][i] = new WL_Sidewall(gp,17,46);i++;
        gp.obj[mapNum][i] = new WL_Sidewall(gp,17,48);i++;
        gp.obj[mapNum][i] = new WL_Sidewall(gp,17,50);i++;
        gp.obj[mapNum][i] = new WL_Sidewall(gp,17,52);i++;
        gp.obj[mapNum][i] = new WL_Sidewall(gp,17,54);i++;
        gp.obj[mapNum][i] = new WL_Sidewall(gp,17,56);i++;
        gp.obj[mapNum][i] = new WL_Sidewall(gp,17,58);i++;
        gp.obj[mapNum][i] = new WL_Sidewall(gp,17,59);i++;
        gp.obj[mapNum][i] = new WL_Sidewall(gp,44,38);i++;
        gp.obj[mapNum][i] = new WL_Sidewall(gp,44,40);i++;
        gp.obj[mapNum][i] = new WL_Sidewall(gp,44,42);i++;
        gp.obj[mapNum][i] = new WL_Sidewall(gp,44,44);i++;
        gp.obj[mapNum][i] = new WL_Sidewall(gp,44,46);i++;
        gp.obj[mapNum][i] = new WL_Sidewall(gp,44,48);i++;
        gp.obj[mapNum][i] = new WL_Sidewall(gp,44,50);i++;
        gp.obj[mapNum][i] = new WL_Sidewall(gp,44,52);i++;
        gp.obj[mapNum][i] = new WL_Sidewall(gp,44,54);i++;
        gp.obj[mapNum][i] = new WL_Sidewall(gp,44,56);i++;
        gp.obj[mapNum][i] = new WL_Sidewall(gp,44,58);i++;
        gp.obj[mapNum][i] = new WL_Sidewall(gp,44,59);i++;

        //BUNKER DOOR
        gp.obj[mapNum][i] = new OBJ_BunkerDoor(gp,36,8);i++;


        //BARRELS
        gp.obj[mapNum][i] = new OBJ_ToxicBarrels1(gp, 80,54);i++;
        gp.obj[mapNum][i] = new OBJ_ToxicBarrels2(gp,67,50);i++;
        gp.obj[mapNum][i] = new OBJ_ToxicBarrels3(gp,76,54);i++;
        gp.obj[mapNum][i] = new OBJ_ToxicBarrels4(gp,84,50);i++;
        gp.obj[mapNum][i] = new OBJ_ToxicBarrels5(gp,84,59);i++;
        gp.obj[mapNum][i] = new OBJ_ToxicBarrels6(gp,77,56);i++;
        gp.obj[mapNum][i] = new OBJ_ToxicBarrels1(gp,83,64);i++;
        gp.obj[mapNum][i] = new OBJ_ToxicBarrels10(gp,78,61);i++;
        gp.obj[mapNum][i] = new OBJ_ToxicBarrels2(gp,72,64);i++;
        gp.obj[mapNum][i] = new OBJ_ToxicBarrels3(gp,67,59);i++;
        gp.obj[mapNum][i] = new OBJ_ToxicBarrels7(gp,80,54);i++;
        gp.obj[mapNum][i] = new OBJ_ToxicBarrels9(gp,72,59);i++;
        gp.obj[mapNum][i] = new OBJ_ToxicBarrels1(gp,70,54);i++;
        gp.obj[mapNum][i] = new OBJ_ToxicBarrels8(gp,73,56);i++;
        gp.obj[mapNum][i] = new OBJ_ToxicBarrels12(gp,84,54);i++;
        gp.obj[mapNum][i] = new OBJ_ToxicBarrels4(gp,78,66);i++;
        gp.obj[mapNum][i] = new OBJ_ToxicBarrels3(gp,66,64);i++;

        //FRIDGES
        gp.obj[mapNum][i] = new OBJ_Fridge1(gp,49,16);
        gp.obj[mapNum][i].setLoot(new OBJ_SweetBubaleh(gp));i++;
        gp.obj[mapNum][i] = new OBJ_Fridge3(gp,50,16);
        gp.obj[mapNum][i].setLoot(new OBJ_SweetBubaleh(gp));i++;
        gp.obj[mapNum][i] = new OBJ_Fridge2(gp,77,16);
        gp.obj[mapNum][i].setLoot(new OBJ_SweetBubaleh(gp));i++;
        gp.obj[mapNum][i] = new OBJ_Fridge4(gp,78,16);
        gp.obj[mapNum][i].setLoot(new OBJ_SweetBubaleh(gp));i++;


        //TRASH

        gp.obj[mapNum][i] = new OBJ_Bath1(gp,64,30);i++;
        gp.obj[mapNum][i] = new OBJ_Garbage1(gp,34,88);i++;
        gp.obj[mapNum][i] = new OBJ_Garbage2(gp,31,69);i++;
        gp.obj[mapNum][i] = new OBJ_Garbage3(gp,27,69);i++;


        //OBJECTS
        gp.obj[mapNum][i] = new OBJ_Toilet2(gp,25,70);i++;
        gp.obj[mapNum][i] = new OBJ_GarbageTrunkr(gp,44,59);
        gp.obj[mapNum][i].setLoot(new OBJ_Tent(gp));i++;
        gp.obj[mapNum][i] = new OBJ_GarbageTrunkl(gp,16,59);
        gp.obj[mapNum][i].setLoot(new OBJ_Tent(gp));i++;

        gp.obj[mapNum][i] = new OBJ_WarningSign(gp,63,63);i++;
        gp.obj[mapNum][i] = new OBJ_Pipes(gp,16,15);i++;
        gp.obj[mapNum][i] = new OBJ_Locker(gp,34,81);
        gp.obj[mapNum][i].setLoot(new OBJ_Tent(gp));i++;


        //LEVEL 2
        mapNum =1;
        i=0;
        gp.obj[mapNum][i] = new OBJ_IronDoor(gp,89,48);i++;



        //LEVEL 3
        mapNum = 2;
        i=0;
        gp.obj[mapNum][i] = new OBJ_IronDoor(gp,98,57);i++;



        //LEVEL 4
        mapNum = 3;
        i=0;
        gp.obj[mapNum][i] = new OBJ_IronDoor(gp,98,48);i++;
        gp.obj[mapNum][i] = new OBJ_Locker(gp,13,39);
        gp.obj[mapNum][i].setLoot(new OBJ_HPPack(gp));i++;

    }

    public void setInteractiveTile(){
        int mapNum = 0;
        int i =0;
        gp.iTile[mapNum][i] = new IT_Box(gp,54,14);i++;
        gp.iTile[mapNum][i] = new IT_Box(gp,55,14);i++;
        gp.iTile[mapNum][i] = new IT_Box(gp,56,14);i++;
        gp.iTile[mapNum][i] = new IT_Box(gp,54,15);i++;
        gp.iTile[mapNum][i] = new IT_Box(gp,55,15);i++;
        gp.iTile[mapNum][i] = new IT_Box(gp,56,15);i++;
        gp.iTile[mapNum][i] = new IT_Box(gp,19,77);i++;
        gp.iTile[mapNum][i] = new IT_Box(gp,20,76);i++;
        gp.iTile[mapNum][i] = new IT_Box(gp,21,75);i++;
        gp.iTile[mapNum][i] = new IT_Vase(gp,28,78);i++;
        gp.iTile[mapNum][i] = new IT_Vase(gp,27,78);i++;
        gp.iTile[mapNum][i] = new IT_Vase(gp,27,79);i++;
        gp.iTile[mapNum][i] = new IT_Box(gp,46,12);i++;
        gp.iTile[mapNum][i] = new IT_Box(gp,46,13);i++;
        gp.iTile[mapNum][i] = new IT_Box(gp,46,14);i++;
        gp.iTile[mapNum][i] = new IT_Vase(gp,19,83);i++;
        gp.iTile[mapNum][i] = new IT_Vase(gp,18,83);i++;
        gp.iTile[mapNum][i] = new IT_Vase(gp,20,83);i++;
        gp.iTile[mapNum][i] = new IT_Vase(gp,18,84);i++;
        gp.iTile[mapNum][i] = new IT_Vase(gp,20,84);i++;
        gp.iTile[mapNum][i] = new IT_Vase(gp,18,85);i++;
        gp.iTile[mapNum][i] = new IT_Vase(gp,20,85);i++;


        mapNum = 1;
        i=0;
        gp.iTile[mapNum][i] = new IT_Vase(gp,16,41);i++;
        gp.iTile[mapNum][i] = new IT_Vase(gp,17,41);i++;
        gp.iTile[mapNum][i] = new IT_Vase(gp,18,41);i++;
        gp.iTile[mapNum][i] = new IT_MetalPlate(gp,11,12);i++;
        gp.iTile[mapNum][i] = new IT_MetalPlate(gp,34,84);i++;
        gp.iTile[mapNum][i] = new IT_MetalPlate(gp,87,59);
    }
    public void setNPC() {
        int mapNum = 0;
        int i =0;
        gp.npc[mapNum][i] = new NPC_Nick(gp,37,83);i++;

        //TREES
        gp.npc[mapNum][i] = new OBJ_Tree1(gp,17,70);i++;
        //LIGHT
        gp.npc[mapNum][i] = new OBJ_CampFire(gp,31,79);i++;
        gp.npc[mapNum][i] = new OBJ_Trashbin(gp,80,19);i++;
        gp.npc[mapNum][i] = new OBJ_Trashbin(gp,63,30);i++;


        mapNum = 1;
        i=0;
        gp.npc[mapNum][i] = new NPC_Ghoul(gp,14,41);

        mapNum = 3;
        i=0;

    }

    public void setEnemy() {


        //LEVEL 1
        int mapNum = 0;
        int i = 0;

//        gp.enemy[mapNum][i] = new Bug1(gp,34,82);i++;
//        gp.enemy[mapNum][i] = new GreenSlime(gp,77,82);i++;
//        gp.enemy[mapNum][i] = new GreenSlime(gp,78,85);i++;
//        gp.enemy[mapNum][i] = new GreenSlime(gp,75,83);i++;
//        gp.enemy[mapNum][i] = new GreenSlime(gp,74,83);i++;
//
//        gp.enemy[mapNum][i] = new Punk(gp,49,13);i++;
//        gp.enemy[mapNum][i] = new Punk(gp,50,13);i++;
//        gp.enemy[mapNum][i] = new Punk(gp,63,13);i++;
//        gp.enemy[mapNum][i] = new Punk(gp,46,28);i++;
//        gp.enemy[mapNum][i] = new Punk(gp,47,28);i++;
//        gp.enemy[mapNum][i] = new Punk(gp,60,13);i++;
//        gp.enemy[mapNum][i] = new Punk(gp,30,18);i++;
//        gp.enemy[mapNum][i] = new Punk(gp,30,19);i++;
//        gp.enemy[mapNum][i] = new Ghoul(gp,75,46);i++;
//        gp.enemy[mapNum][i] = new Ghoul(gp,69,40);i++;
//        gp.enemy[mapNum][i] = new Ghoul(gp,78,50);i++;
//        gp.enemy[mapNum][i] = new Ghoul(gp,69,50);i++;
//        gp.enemy[mapNum][i] = new Ghoul(gp,70,43);i++;
//        gp.enemy[mapNum][i] = new DeathClaw(gp,29,48);

        //LEVEL2

        mapNum =1;
        i=0;
        gp.enemy[mapNum][i] = new Spider(gp,35,79);i++;

        gp.enemy[mapNum][i] = new Bug1(gp,10,14);i++;
        gp.enemy[mapNum][i] = new Bug2(gp,13,14);i++;
        gp.enemy[mapNum][i] = new Bug3(gp,15,14);

        mapNum =3;
        i=0;
        if(!Progress.slimeBossDefeated) {
            gp.enemy[mapNum][i] = new SlimeBoss(gp,52,44);
        }
    }

}
