package com.game;

import com.exception.GameException;

/**
 * Created by hang.qin on 2016/12/8.
 */
public interface Game {
    boolean addBlack(int x, int y) throws GameException;

    boolean addWhite(int x, int y) throws GameException;
}
