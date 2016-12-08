package com;

/**
 * Created by Administrator on 2016/12/8.
 */



public class GameLogic {
    private final int LEN = 15;
    private final int BLACK = 1;
    private final int WHITE = -1;

    private int chessMap[][] = new int[LEN][LEN];
    private int cnt = 0;

    private boolean isBlackRound(){
        return cnt%2 == 0;
    }
    private boolean isWhiteRound(){
        return cnt%2 == 1;
    }
    private boolean isLegal(int x, int y){
        if (x <= LEN && y <= LEN){
            if (chessMap[x][y] == 0){
                return true;
            }
        }
        return false;
    }
    private boolean isWin(){
        //TODO
        return false;
    }

    public boolean addBlack(int x, int y){
        if(!isLegal(x, y)){
            //TODO
        }
        if(!isBlackRound()){
            //TODO
        }
        chessMap[x][y] = BLACK;
        cnt++;
        return isWin();
    }
    public boolean addWhite(int x, int y){
        if(!isLegal(x, y)){
            //TODO
        }
        if(!isWhiteRound()){
            //TODO
        }
        chessMap[x][y] = WHITE;
        cnt++;
        return isWin();
    }
}
