package com.game;

import com.exception.GameException;

/**
 * Created by Administrator on 2016/12/8.
 */


public class GameLogic implements Game {
    private final int LEN = 15;
    private final int BLACK = 1;
    private final int WHITE = -1;

    private int chessMap[][] = new int[LEN][LEN];
    private int cnt = 0;

    private void isBlackRound() throws GameException {
        if (cnt % 2 != 0) {
            throw new GameException(GameException.ResultCode.NOT_YOUR_ROUND);
        }
    }

    private void isWhiteRound() throws GameException {
        if (cnt % 2 != 1) {
            throw new GameException(GameException.ResultCode.NOT_YOUR_ROUND);
        }
    }

    private void checkLegal(int x, int y) throws GameException {
        if (x > LEN || y > LEN) {
            throw new GameException(GameException.ResultCode.OUT_OF_INDEX);
        }
        if (chessMap[x][y] != 0) {
            throw new GameException(GameException.ResultCode.POS_HAS_SET);
        }
    }

    /**
     * 这里可以改成return谁赢了。。
     * 比较有拓展性
     * @return
     */
    private boolean isWin(int x, int y) {
        int color  = chessMap[x][y];

        int sum = 0;
        for (int xx=x-1; xx>=0; xx--){
            if (chessMap[xx][y] != color)
                break;
            sum ++;
        }
        for (int xx=x+1; xx<LEN; xx++){
            if (chessMap[xx][y] != color)
                break;
            sum ++;
        }
        if (sum >= 5)
            return true;

        sum = 0;
        for (int yy=y-1; yy>=0; yy--){
            if (chessMap[x][yy] != color)
                break;
            sum ++;
        }
        for (int yy=y+1; yy<LEN; yy++){
            if (chessMap[x][yy] != color)
                break;
            sum ++;
        }
        if (sum >= 5)
            return true;

        sum = 0;
        for (int xx=x-1, yy=y-1; xx>=0 && yy>=0; xx--, yy--){
            if (chessMap[xx][yy] != color)
                break;
            sum ++;
        }
        for (int xx=x+1, yy=y+1; xx<LEN && yy<LEN; xx++, yy++){
            if (chessMap[xx][yy] != color)
                break;
            sum++;
        }
        if (sum >= 5)
            return true;

        sum = 0;
        for (int xx=x+1, yy=y-1; xx<LEN && yy>=0; xx++, yy--){
            if (chessMap[xx][yy] != color)
                break;
            sum ++;
        }
        for (int xx=x-1, yy=y+1; xx>=0 && yy<LEN; xx--, yy++){
            if (chessMap[xx][yy] != color)
                break;
            sum ++;
        }
        if (sum >= 5)
            return true;

        return false;
    }

    /**
     *
     * @param x
     * @param y
     * @return return用来专心做处理这次操作造成的结果（谁赢了）
     * @throws GameException （异常流用来处理其他无关的情况）
     */
    @Override
    public boolean addBlack(int x, int y) throws GameException {
        checkLegal(x, y);
        isBlackRound();
        chessMap[x][y] = BLACK;
        cnt++;
        return isWin(x, y);
    }

    @Override
    public boolean addWhite(int x, int y) throws GameException {
        checkLegal(x, y);
        isWhiteRound();
        chessMap[x][y] = WHITE;
        cnt++;
        return isWin(x, y);
    }
}
