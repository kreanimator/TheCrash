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

public class TileManager {

    GamePanel gp;
    public Tiles[] tiles;

    public int[][][] mapTileNum;
    boolean drawPath = true;

    public TileManager(GamePanel gp) {
        this.gp = gp;
        tiles = new Tiles[1000];
        mapTileNum = new int[gp.maxMap][gp.maxWorldCol][gp.maxWorldRow];
        getTileImage();
        loadMap("/resources/maps/world1.txt",0);
        loadMap("/resources/maps/cave.txt", 1);
        loadMap("/resources/maps/bunker1.txt", 2);
        loadMap("/resources/maps/bunker2.txt", 3);
    }

    public void getTileImage() {


        setup(0, "0001", false);
        setup(1, "0002", false);
        setup(2, "0003", false);
        setup(3, "0004", false);
        setup(4, "0005", false);
        setup(5, "0006", false);
        setup(6, "0007", false);
        setup(7, "0008", false);
        setup(8, "0009", false);
        setup(9, "0010", false);
        setup(10, "0011", false);
        setup(11, "0012", false);
        setup(12, "0013", false);
        setup(13, "0014", false);
        setup(14, "0015", false);
        setup(15, "0016", false);
        setup(16, "0017", false);
        setup(17, "0018", false);
        setup(18, "0019", false);
        setup(19, "0020", false);
        setup(20, "0021", false);
        setup(21, "0022", false);
        setup(22, "0023", false);
        setup(23, "0024", false);
        setup(24, "0025", false);
        setup(25, "0026", false);
        setup(26, "0027", false);
        setup(27, "0028", false);
        setup(28, "0029", false);
        setup(29, "0030", false);
        setup(30, "0031", false);
        setup(31, "0032", false);
        setup(32, "0033", false);
        setup(33, "0034", false);
        setup(34, "0035", false);
        setup(35, "0036", false);
        setup(36, "0037", false);
        setup(37, "0038", false);
        setup(38, "0039", false);
        setup(39, "0040", false);
        setup(40, "0041", false);
        setup(41, "0042", false);
        setup(42, "0043", false);
        setup(43, "0044", false);
        setup(44, "0045", false);
        setup(45, "0046", false);
        setup(46, "0047", false);
        setup(47, "0048", false);
        setup(48, "0049", false);
        setup(49, "0050", false);
        setup(50, "0051", false);
        setup(51, "0052", false);
        setup(52,"0053", false);
        setup(53, "0054", false);
        setup(54, "0055", true);
        setup(55, "0056", false);
        setup(56, "0057", false);
        setup(57, "0058", false);
        setup(58, "0059", false);
        setup(59, "0060", false);
        setup(60, "0061", false);
        setup(61, "0062", false);
        setup(62, "0063", false);
        setup(63, "0064", false);
        setup(64, "0065", false);
        setup(65, "0066", false);
        setup(66, "0067", false);
        setup(67, "0068", false);
        setup(68, "0069", false);
        setup(69, "0070", false);
        setup(70, "0071", false);
        setup(71, "0072", false);
        setup(72,"0073", false);
        setup(73, "0074", false);
        setup(74, "0075", false);
        setup(75, "0076", false);
        setup(76, "0077", false);
        setup(77, "0078", false);
        setup(78, "0079", false);
        setup(79, "0080", false);
        setup(80, "0081", false);
        setup(81, "0082", false);
        setup(82, "0083", false);
        setup(83, "0084", false);
        setup(84, "0085", false);
        setup(85, "0086", false);
        setup(86, "0087", false);
        setup(87, "0088", false);
        setup(88, "0089", false);
        setup(89, "0090", false);
        setup(90, "0091", false);
        setup(91, "0092", false);
        setup(92, "0093", false);
        setup(93, "0094", false);
        setup(94, "0095", false);
        setup(95, "0096", false);
        setup(96, "0097", false);
        setup(97, "0098", false);
        setup(98, "0099", false);
        setup(99, "0100", false);
        setup(100, "0101", false);
        setup(101, "0102", false);
        setup(102, "0103", false);
        setup(103, "0104", false);
        setup(104, "0105", false);
        setup(105, "0106", false);
        setup(106, "0107", false);
        setup(107, "0108", false);
        setup(108, "0109", false);
        setup(109, "0110", false);
        setup(110, "0111", false);
        setup(111, "0112", false);
        setup(112, "0113", false);
        setup(113, "0114", false);
        setup(114, "0115", false);
        setup(115, "0116", false);
        setup(116, "0117", false);
        setup(117, "0118", false);
        setup(118, "0119", false);
        setup(119, "0120", false);
        setup(120, "0121", false);
        setup(121, "0122", false);
        setup(122, "0123", false);
        setup(123, "0124", false);
        setup(124, "0125", false);
        setup(125, "0126", false);
        setup(126, "0127", false);
        setup(127, "0128", false);
        setup(128, "0129", false);
        setup(129, "0130", false);
        setup(130, "0131", false);
        setup(131, "0132", false);
        setup(132, "0133", false);
        setup(133, "0134", false);
        setup(134, "0135", false);
        setup(135, "0136", false);
        setup(136, "0137", false);
        setup(137, "0138", false);
        setup(138, "0139", false);
        setup(139, "0140", false);
        setup(140, "0141", false);
        setup(141, "0142", false);
        setup(142, "0143", false);
        setup(143, "0144", false);
        setup(144, "0145", false);
        setup(145, "0146", false);
        setup(146, "0147", false);
        setup(147, "0148", false);
        setup(148, "0149", false);
        setup(149, "0150", false);
        setup(150, "0151", false);
        setup(151, "0152", false);
        setup(152,"0153", false);
        setup(153, "0154", false);
        setup(154, "0155", false);
        setup(155, "0156", false);
        setup(156, "0157", false);
        setup(157, "0158", false);
        setup(158, "0159", false);
        setup(159, "0160", false);
        setup(160, "0161", false);
        setup(161, "0162", false);
        setup(162, "0163", false);
        setup(163, "0164", false);
        setup(164, "0165", false);
        setup(165, "0166", false);
        setup(166, "0167", false);
        setup(167, "0168", false);
        setup(168, "0169", false);
        setup(169, "0170", false);
        setup(170, "0171", false);
        setup(171, "0172", false);
        setup(172, "0173", false);
        setup(173, "0174", true);
        setup(174, "0175", true);
        setup(175, "0176", false);
        setup(176, "0177", false);
        setup(177, "0178", false);
        setup(178, "0179", false);
        setup(179, "0180", false);
        setup(180, "0181", false);
        setup(181, "0182", false);
        setup(182, "0183", true);
        setup(183, "0184", true);
        setup(184, "0185", false);
        setup(185, "0186", false);
        setup(186, "0187", false);
        setup(187, "0188", false);
        setup(188, "0189", false);
        setup(189, "0190", false);
        setup(190, "0191", false);
        setup(191, "0192", false);
        setup(192, "0193", false);
        setup(193, "0194", false);
        setup(194, "0195", false);
        setup(195, "0196", false);
        setup(196, "0197", false);
        setup(197, "0198", false);
        setup(198, "0199", false);
        setup(199, "0200", false);
        setup(200, "0201", false);
        setup(201, "0202", false);
        setup(202, "0203", false);
        setup(203, "0204", false);
        setup(204, "0205", false);
        setup(205, "0206", false);
        setup(206, "0207", false);
        setup(207, "0208", false);
        setup(208, "0209", true);
        setup(209, "0210", true);
        setup(210, "0211", true);
        setup(211, "0212", true);
        setup(212, "0213", false);
        setup(213, "0214", true);
        setup(214, "0215", true);
        setup(215, "0216", true);
        setup(216, "0217", false);
        setup(217, "0218", false);
        setup(218, "0219", false);
        setup(219, "0220", true);
        setup(220, "0221", false);
        setup(221, "0222", false);
        setup(222, "0223", false);
        setup(223, "0224", false);
        setup(224, "0225", true);
        setup(225, "0226", false);
        setup(226, "0227", false);
        setup(227, "0228", false);
        setup(228, "0229", false);
        setup(229, "0230", false);
        setup(230, "0231", false);
        setup(231, "0232", false);
        setup(232, "0233", false);
        setup(233, "0234", false);
        setup(234, "0235", false);
        setup(235, "0236", false);
        setup(236, "0237", false);
        setup(237, "0238", false);
        setup(238, "0239", false);
        setup(239, "0240", false);
        setup(240, "0241", true);
        setup(241, "0242", false);
        setup(242, "0243", false);
        setup(243, "0244", false);
        setup(244, "0245", false);
        setup(245, "0246", false);
        setup(246, "0247", false);
        setup(247, "0248", false);
        setup(248, "0249", false);
        setup(249, "0250", false);
        setup(250, "0251", false);
        setup(251, "0252", false);
        setup(252, "0253", false);
        setup(253, "0254", false);
        setup(254, "0255", false);
        setup(255, "0256", false);
        setup(256, "0257", false);
        setup(257, "0258", false);
        setup(258, "0259", false);
        setup(259, "0260", false);
        setup(260, "0261", false);
        setup(261, "0262", false);
        setup(262, "0263", false);
        setup(263, "0264", false);
        setup(264, "0265", false);
        setup(265, "0266", false);
        setup(266, "0267", false);
        setup(267, "0268", false);
        setup(268, "0269", false);
        setup(269, "0270", false);
        setup(270, "0271", false);
        setup(271, "0272", false);
        setup(272, "0273", false);
        setup(273, "0274", false);
        setup(274, "0275", false);
        setup(275, "0276", false);
        setup(276, "0277", false);
        setup(277, "0278", false);
        setup(278, "0279", false);
        setup(279, "0280", false);
        setup(280, "0281", false);
        setup(281, "0282", false);
        setup(282, "0283", false);
        setup(283, "0284", false);
        setup(284, "0285", false);
        setup(285, "0286", false);
        setup(286, "0287", false);
        setup(287, "0288", false);
        setup(288, "0289", false);
        setup(289, "0290", false);
        setup(290, "0291", false);
        setup(291, "0292", false);
        setup(292, "0293", false);
        setup(293, "0294", false);
        setup(294, "0295", false);
        setup(295, "0296", false);
        setup(296, "0297", false);
        setup(297, "0298", false);
        setup(298, "0299", false);
        setup(299, "0300", false);
        setup(300, "0301", false);
        setup(301, "0302", false);
        setup(302, "0303", false);
        setup(303, "0304", false);
        setup(304, "0305", false);
        setup(305, "0306", false);
        setup(306, "0307", false);
        setup(307, "0308", false);
        setup(308, "0309", false);
        setup(309, "0310", false);
        setup(312, "0313", false);
        setup(313, "0314", false);
        setup(314, "0315", false);
        setup(315, "0316", false);
        setup(316, "0317", false);
        setup(317, "0318", false);
        setup(318, "0319", true);
        setup(319, "0320", true);
        setup(320, "0321", false);
        setup(321, "0322", false);
        setup(322, "0323", false);
        setup(323, "0324", false);
        setup(324, "0325", false);
        setup(325, "0326", false);
        setup(326, "0327", false);
        setup(327, "0328", false);
        setup(328, "0329", false);
        setup(329, "0330", false);
        setup(330, "0331", false);
        setup(331, "0332", true);
        setup(332, "0333", false);
        setup(333, "0334", true);
        setup(334, "0335", true);
        setup(335, "0336", true);
        setup(336, "0337", true);
        setup(337, "0338", true);
        setup(338, "0339", true);
        setup(339, "0340", true);
        setup(340, "0341", true);
        setup(341, "0342", true);
        setup(342, "0343", true);
        setup(343, "0344", true);
        setup(344, "0345", true);
        setup(345, "0346", true);
        setup(346, "0347", true);
        setup(347, "0348", true);
        setup(348, "0349", true);
        setup(349, "0350", true);
        setup(350, "0351", true);
        setup(351, "0352", true);
        setup(352, "0353", true);
        setup(353, "0354", true);
        setup(354, "0355", true);
        setup(355, "0356", true);
        setup(356, "0357", true);
        setup(357, "0358", true);
        setup(358, "0359", true);
        setup(359, "0360", true);
        setup(360, "0361", true);
        setup(361, "0362", true);
        setup(362, "0363", true);
        setup(363, "0364", false);
        setup(364, "0365", false);
        setup(365, "0366", false);
        setup(366, "0367", false);
        setup(367, "0368", false);
        setup(368, "0369", true);
        setup(369, "0370", false);
        setup(370, "0371", false);
        setup(371, "0372", true);
        setup(372, "0373", false);
        setup(373, "0374", false);
        setup(374, "0375", true);
        setup(375, "0376", true);
        setup(376, "0377", true);
        setup(377, "0378", true);
        setup(378, "0379", false);
        setup(379, "0380", true);
        setup(380, "0381", true);
        setup(381, "0382", true);
        setup(382, "0383", true);
        setup(383, "0384", true);
        setup(384, "0385", true);
        setup(385, "0386", true);
        setup(386, "0387", true);







    }

    public void setup(int index, String imageName, boolean collision) {

        UtilityTool uTool = new UtilityTool();

        try {
            tiles[index] = new Tiles();
            tiles[index].image = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/resources/tiles/" + imageName + ".png")));
            tiles[index].image = uTool.scaleImage(tiles[index].image, gp.tileSize, gp.tileSize);
            tiles[index].collision = collision;


        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public void loadMap(String filePath, int map) {
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
                    mapTileNum[map][col][row] = num;
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
            int tileNum = mapTileNum[gp.currentMap][worldCol][worldRow];

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
        if(drawPath){
            g2.setColor(new Color(255,0,0,70));

            for(int i = 0; i < gp.pFinder.pathList.size(); i ++){
                int worldX = gp.pFinder.pathList.get(i).col * gp.tileSize;
                int worldY = gp.pFinder.pathList.get(i).row * gp.tileSize;
                int screenX = worldX - gp.player.worldX + gp.player.screenX;
                int screenY = worldY - gp.player.worldY + gp.player.screenY;
                g2.fillRect(screenX,screenY,gp.tileSize,gp.tileSize);
            }
        }
        }

    public void update() {
    }
}

