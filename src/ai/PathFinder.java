package ai;

import entity.Entity;
import main.GamePanel;

import java.util.ArrayList;

public class PathFinder {

    GamePanel gp;
    Node[][] node;
    ArrayList<Node> openList = new ArrayList<>();
    public ArrayList<Node> pathList = new ArrayList<>();

    Node startNode, goalNode, currentNode;
    boolean goalReached = false;
    int step = 0;

    public PathFinder(GamePanel gp) {
        this.gp = gp;
        instantiateNode();
    }

    public void instantiateNode() {
        node = new Node[gp.maxWorldCol][gp.maxWorldRow];
        int col = 0;
        int row = 0;

        while (col < gp.maxWorldCol && row < gp.maxWorldRow) {
            node[col][row] = new Node(col, row);
            col++;
            if (col == gp.maxWorldCol) {
                col = 0;
                row++;
            }
        }
    }

    public void resetNode() {
        int col = 0;
        int row = 0;

        while (col < gp.maxWorldCol && row < gp.maxWorldRow) {
            //Reset open, checked and solid states

            node[col][row].open = false;
            node[col][row].checked = false;
            node[col][row].solid = false;
            col++;
            if (col == gp.maxWorldCol) {
                col = 0;
                row++;

            }
        }
        //Reset other settings

        openList.clear();
        pathList.clear();
        goalReached = false;
        step = 0;
    }

    public void setNode(int startCol, int startRow, int goalCol, int goalRow, Entity entity) {

        resetNode();
        //Set start and goal nodes
        startNode = node[startCol][startRow];
        currentNode = startNode;
        goalNode = node[goalCol][goalRow];
        openList.add(currentNode);

        int col = 0;
        int row = 0;

        //CHECK OBJECTS
        for (int i = 0; i < gp.obj[1].length; i++) {
            if (gp.obj[gp.currentMap][i] != null && gp.obj[gp.currentMap][i].collision) {
                int oCol = (gp.obj[gp.currentMap][i].worldX +gp.obj[gp.currentMap][i].solidAreaDefaultX) / gp.tileSize;
                int oRow = (gp.obj[gp.currentMap][i].worldY+gp.obj[gp.currentMap][i].solidAreaDefaultY) / gp.tileSize;

                //Getting how many tiles solid area is occupying
                int oSizeCol = gp.obj[gp.currentMap][i].solidArea.width / gp.tileSize;
                int oSizeRow = gp.obj[gp.currentMap][i].solidArea.height / gp.tileSize;


                node[oCol][oRow].solid = true;

                //Assigning collision for additional tiles
                    for (int j = 0; j <= oSizeCol; j++){
                        for(int k = 0; k <= oSizeRow; k++){
                    int nextCol = oCol + j;
                    int nextRow = oRow +k;
                            node[nextCol][nextRow].solid = true;
                        }
                    }
            }
        }

        //CHECK INTERACTIVE TILES

        for (int i = 0; i < gp.iTile[1].length; i++) {
            if (gp.iTile[gp.currentMap][i] != null && gp.iTile[gp.currentMap][i].destructible) {
                int itCol = (gp.iTile[gp.currentMap][i].worldX +gp.iTile[gp.currentMap][i].solidAreaDefaultX) / gp.tileSize;
                int itRow = (gp.iTile[gp.currentMap][i].worldY+gp.iTile[gp.currentMap][i].solidAreaDefaultY) / gp.tileSize;

                int iTSizeCol = gp.iTile[gp.currentMap][i].solidArea.width / gp.tileSize;
                int iTSizeRow = gp.iTile[gp.currentMap][i].solidArea.height / gp.tileSize;

                node[itCol][itRow].solid = true;
                for (int j = 0; j <= iTSizeCol;j ++){
                    for(int k = 0; k <= iTSizeRow; k ++){
                        int nextCol = itCol + j;
                        int nextRow = itRow +k;
                        node[nextCol][nextRow].solid = true;
                    }
                }
            }
        }
        //CHECK NPC
        for (int i = 0; i < gp.npc[1].length; i++) {
            if (gp.npc[gp.currentMap][i] != null && gp.npc[gp.currentMap][i].collision) {
                int nCol = (gp.npc[gp.currentMap][i].worldX +gp.npc[gp.currentMap][i].solidAreaDefaultX) / gp.tileSize;
                int nRow = (gp.npc[gp.currentMap][i].worldY+gp.npc[gp.currentMap][i].solidAreaDefaultY ) / gp.tileSize;
                node[nCol][nRow].solid = true;

                int nSizeCol = gp.iTile[gp.currentMap][i].solidArea.width / gp.tileSize;
                int nSizeRow = gp.iTile[gp.currentMap][i].solidArea.height / gp.tileSize;

                for (int j = 0; j <= nSizeCol;j ++){
                    for(int k = 0; k <= nSizeRow; k ++){
                        int nextCol = nCol + j;
                        int nextRow = nRow +k;
                        node[nextCol][nextRow].solid = true;
                    }
                }
            }
        }

        while (col < gp.maxWorldCol && row < gp.maxWorldRow) {

            //SET SOLID NODE

            int tileNum = gp.tileM.mapTileNum[gp.currentMap][col][row];
            if (gp.tileM.tiles[tileNum].collision) {
                node[col][row].solid = true;
            }

//

            //SET COST
            getCost(node[col][row]);

            col++;
            if (col == gp.maxWorldCol) {
                col = 0;
                row++;
            }
        }
    }

    private void getCost(Node node) {

        //G COST

        int xDistance = Math.abs(node.col - startNode.col);
        int yDistance = Math.abs(node.row - startNode.row);
        node.gCost = xDistance + yDistance;

        //H COST
        xDistance = Math.abs(node.col - goalNode.col);
        yDistance = Math.abs(node.row - goalNode.row);
        node.hCost = xDistance + yDistance;

        //F COST

        node.fCost = node.gCost + node.hCost;
    }

    public boolean search() {
        while (!goalReached && step < 500) {
            int col = currentNode.col;
            int row = currentNode.row;

            //Check the current node
            currentNode.checked = true;
            openList.remove(currentNode);

            //OPEN THE UP NODE
            if (row - 1 >= 0) {
                openNode(node[col][row - 1]);
            }

            //OPEN THE LEFT NODE
            if (col - 1 >= 0) {
                openNode(node[col - 1][row]);
            }
            //OPEN THE DOWN NODE
            if (row + 1 < gp.maxWorldRow) {
                openNode(node[col][row + 1]);
            }
            //OPEN THE DOWN NODE
            if (col + 1 < gp.maxWorldCol) {
                openNode(node[col + 1][row]);
            }
            //FIND THE BEST NODE

            int bestNodeIndex = 0;
            int bestNodeFCost = 999;

            for (int i = 0; i < openList.size(); i++) {
                //Check if this node F.cost is better
                if (openList.get(i).fCost < bestNodeFCost) {
                    bestNodeIndex = i;
                    bestNodeFCost = openList.get(i).fCost;
                }
                //Check if F cost is equal check the G cost

                else if (openList.get(i).fCost == bestNodeFCost) {
                    if (openList.get(i).gCost < openList.get(bestNodeIndex).gCost) {
                        bestNodeIndex = i;
                    }

                }

            }
            //If there is no node in the open list, end the loop

            if (openList.size() == 0) {
                break;
            }
            //After the loop, openlist[bestNodeIndex}] is the next step (=currentNod)
            currentNode = openList.get(bestNodeIndex);
            if (currentNode == goalNode) {
                goalReached = true;
                trackThePath();
            }
            step++;

        }
        return goalReached;
    }

    private void trackThePath() {
        Node current = goalNode;

        while (current != startNode) {
            pathList.add(0, current);
            current = current.parent;
        }
    }

    private void openNode(Node node) {
        if (!node.open && !node.checked && !node.solid) {
            node.open = true;
            node.parent = currentNode;
            openList.add(node);

        }
    }
}

