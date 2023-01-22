package tiles;

import main.GamePanel;
import main.UtilityTool;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Objects;

public class RoofManager {
    GamePanel gp;
    public Tiles[] tiles;

    public int[][][] roofMapTileNum;


    public RoofManager(GamePanel gp) {
        this.gp = gp;
        tiles = new Tiles[1000];
        roofMapTileNum = new int[gp.maxRoofMap][gp.maxWorldCol][gp.maxWorldRow];
        getRoofImage();
        loadRoofMap("/resources/maps/roofmaps/world1.txt", 0);

    }

    public void getRoofImage() {


        setup(0, "0000");
        setup(1, "0001");
        setup(2, "0002");
        setup(3, "0003");
        setup(4, "0004");
        setup(5, "0005");
        setup(6, "0006");
        setup(7, "0007");
        setup(8, "0008");
        setup(9, "0009");
        setup(10, "0010");
        setup(11, "0011");
        setup(12, "0012");
        setup(13, "0013");
        setup(14, "0014");
        setup(15, "0015");
        setup(16, "0016");
        setup(17, "0017");
        setup(18, "0018");
        setup(19, "0019");
        setup(20, "0020");
        setup(21, "0021");
        setup(22, "0022");
        setup(23, "0023");
        setup(24, "0024");
        setup(25, "0025");
        setup(26, "0026");
        setup(27, "0027");
        setup(28, "0028");
        setup(29, "0029");
        setup(30, "0030");
        setup(31, "0031");
        setup(32, "0032");
        setup(33, "0033");
        setup(34, "0034");
        setup(35, "0035");
        setup(36, "0036");
        setup(37, "0037");
        setup(38, "0038");
        setup(39, "0039");
        setup(40, "0040");
        setup(41, "0041");
        setup(42, "0042");
        setup(43, "0043");
        setup(44, "0044");
        setup(45, "0045");
        setup(46, "0046");
        setup(47, "0047");
        setup(48, "0048");
        setup(49, "0049");
        setup(50, "0050");
        setup(51, "0051");
        setup(52, "0052");
        setup(53, "0053");
        setup(54, "0054");
        setup(55, "0055");
        setup(56, "0056");
        setup(57, "0057");
        setup(58, "0058");
        setup(59, "0059");
        setup(60, "0060");
        setup(61, "0061");
        setup(62, "0062");
        setup(63, "0063");
        setup(64, "0064");
        setup(65, "0065");
        setup(66, "0066");
        setup(67, "0067");
        setup(68, "0068");
        setup(69, "0069");
        setup(70, "0070");
        setup(71, "0071");
        setup(72, "0072");
        setup(73, "0073");
        setup(74, "0074");
        setup(75, "0075");
        setup(76, "0076");
        setup(77, "0077");
        setup(78, "0078");
        setup(79, "0079");
        setup(80, "0080");
        setup(81, "0081");
        setup(82, "0082");








    }

    public void setup(int index, String imageName) {

        UtilityTool uTool = new UtilityTool();

        try {
            tiles[index] = new Tiles();
            tiles[index].image = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/resources/tiles/roofs/" + imageName + ".png")));
            tiles[index].image = uTool.scaleImage(tiles[index].image, gp.tileSize, gp.tileSize);


        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public void loadRoofMap(String filePath, int map) {
        try {

            InputStream is = getClass().getResourceAsStream(filePath);
            assert is != null;
            BufferedReader br = new BufferedReader(new InputStreamReader(is));

            int col = 0;
            int row = 0;

            while (col < gp.maxWorldCol && row < gp.maxWorldRow) {

                String line = br.readLine();

                while (col < gp.maxWorldCol) {
                    String[] numbers = line.split(" ");

                    int num = Integer.parseInt(numbers[col]);
                    roofMapTileNum[map][col][row] = num;
                    col++;
                }
                if (col == gp.maxWorldCol) {
                    col = 0;
                    row++;
                }

            }
            br.close();

        } catch (Exception ignored) {

        }
    }

    public void draw(Graphics2D g2) {
        int worldCol = 0;
        int worldRow = 0;

        while (worldCol < gp.maxWorldCol && worldRow < gp.maxWorldRow) {
            int tileNum = roofMapTileNum[gp.currentMap][worldCol][worldRow];

            int worldX = worldCol * gp.tileSize;
            int worldY = worldRow * gp.tileSize;
            int screenX = worldX - gp.player.worldX + gp.player.screenX;
            int screenY = worldY - gp.player.worldY + gp.player.screenY;

            //Stop moving camera a t the edge

            if(gp.player.screenX > gp.player.worldX){
                screenX =worldX;
            }
            if(gp.player.screenY > gp.player.worldY){
                screenY = worldY;
            }
            int rightOffset = gp.screenWidth - gp.player.screenX;
            if(rightOffset > gp.worldWidth - gp.player.worldX){
                screenX = gp.screenWidth - (gp.worldWidth-worldX);
            }
            int bottomOffset = gp.screenHeight - gp.player.screenY;
            if(bottomOffset > gp.worldHeight-gp.player.worldY){
                screenY = gp.screenHeight - (gp.worldHeight-worldY);
            }

            if (worldX + gp.tileSize > gp.player.worldX - gp.player.screenX &&
                    worldX - gp.tileSize < gp.player.worldX + gp.player.screenX &&
                    worldY + gp.tileSize > gp.player.worldY - gp.player.screenY &&
                    worldY - gp.tileSize < gp.player.worldY + gp.player.screenY) {


                g2.drawImage(tiles[tileNum].image, screenX, screenY, gp.tileSize, gp.tileSize, null);
            }
            else if(gp.player.screenX > gp.player.worldX ||
                    gp.player.screenY > gp.player.worldY
                    || rightOffset > gp.worldWidth - gp.player.worldX ||
                    bottomOffset > gp.worldHeight-gp.player.worldY ){
                g2.drawImage(tiles[tileNum].image, screenX, screenY, gp.tileSize, gp.tileSize, null);

            }

            worldCol++;


            if (worldCol == gp.maxWorldCol) {
                worldCol = 0;
                worldRow++;


            }
        }

    }
}
