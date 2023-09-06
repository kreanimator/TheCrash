package object.quests;

import entity.Entity;
import main.GamePanel;

public class Q_KillBugs extends Entity {
    public final static String objName = "Kill Bugs";

    public Q_KillBugs(GamePanel gp) {
        super(gp);
        price = 200;
        name = objName;
        down1 = setup("enemies/bug1/up1",gp.tileSize/2,gp.tileSize/2);
        defenseValue = 1;
        description = "[" + name + "]\n" +
                "Nick is struggling with the pests on \nhis field Help him to get rid of them.";
    }
}
