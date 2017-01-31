package com.game;

import com.exception.GameException;

import java.util.Collection;

/**
 * Created by hang.qin on 2016/12/8.
 */
public interface Game {

    Integer play(Long playId, Location l) throws GameException;

    Collection getMap() throws GameException;
}
