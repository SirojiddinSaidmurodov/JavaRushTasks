package com.javarush.games.minesweeper;

import com.javarush.engine.cell.Color;
import com.javarush.engine.cell.Game;

import java.util.ArrayList;
import java.util.List;

public class MinesweeperGame extends Game {
    private static final int SIDE = 9;
    private static final String MINE = "\uD83D\uDCA3";
    private static final String FLAG = "\uD83D\uDEA9";
    private final GameObject[][] gameField = new GameObject[SIDE][SIDE];
    private int countMinesOnField;
    private int countFlags;
    private boolean isGameStopped;

    @Override
    public void initialize() {
        setScreenSize(SIDE, SIDE);
        createGame();
    }

    @Override
    public void onMouseLeftClick(int x, int y) {
        openTile(x, y);
    }

    @Override
    public void onMouseRightClick(int x, int y) {
        markTile(x, y);
    }

    private void createGame() {
        for (int y = 0; y < SIDE; y++) {
            for (int x = 0; x < SIDE; x++) {
                boolean isMine = getRandomNumber(10) < 1;
                if (isMine) {
                    countMinesOnField++;
                }
                gameField[y][x] = new GameObject(x, y, isMine);
                setCellColor(x, y, Color.ORANGE);
            }
        }
        countFlags = countMinesOnField;
        countMineNeighbors();
    }

    private List<GameObject> getNeighbors(GameObject gameObject) {
        List<GameObject> result = new ArrayList<>();
        for (int y = gameObject.y - 1; y <= gameObject.y + 1; y++) {
            for (int x = gameObject.x - 1; x <= gameObject.x + 1; x++) {
                if (y < 0 || y >= SIDE) {
                    continue;
                }
                if (x < 0 || x >= SIDE) {
                    continue;
                }
                if (gameField[y][x] == gameObject) {
                    continue;
                }
                result.add(gameField[y][x]);
            }
        }
        return result;
    }

    private void countMineNeighbors() {
        for (int y = 0; y < SIDE; y++) {
            for (int x = 0; x < SIDE; x++) {
                if (!gameField[y][x].isMine) {
                    gameField[y][x].countMineNeighbors = (int)
                            getNeighbors(gameField[y][x])
                                    .stream()
                                    .filter(gameObject -> gameObject.isMine)
                                    .count();
                }
            }
        }
    }

    private void openTile(int x, int y) {
        GameObject tile = gameField[y][x];
        tile.isOpen = true;
        setCellColor(x, y, Color.GREEN);
        if (tile.isMine) {
            setCellValue(x, y, MINE);
        } else {
            int minesCount = tile.countMineNeighbors;
            if (minesCount != 0) {
                setCellNumber(x, y, minesCount);
            } else {
                setCellValue(x, y, "");
                for (GameObject neighbor :
                        getNeighbors(tile)) {
                    if (!neighbor.isOpen) {
                        openTile(neighbor.x, neighbor.y);
                    }
                }
            }
        }
    }

    private void markTile(int x, int y) {
        GameObject tile = gameField[y][x];
        if (!tile.isOpen) {
            if (countFlags != 0 && !tile.isFlag) {
                tile.isFlag = true;
                countFlags--;
                setCellValue(x, y, FLAG);
                setCellColor(x, y, Color.YELLOW);
            }else if (tile.isFlag){
                tile.isFlag = false;
                countFlags++;
                setCellValue(x,y,"");
                setCellColor(x,y,Color.ORANGE);
            }
        }
    }
}