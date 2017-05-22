package com.miku.web.tools;

import com.miku.web.entity.JoinGame;

import java.util.Comparator;

/**
 * Created by henrybit on 2017/5/22.
 */
public class JoinGameComparator implements Comparator {

    @Override
    public int compare(Object o1, Object o2) {
        if (o1 instanceof JoinGame && o2 instanceof JoinGame) {
            JoinGame joinGame1 = (JoinGame)o1;
            JoinGame joinGame2 = (JoinGame)o2;
            if (joinGame1.getTjtimes() > joinGame2.getTjtimes())
                return -1;
            else if (joinGame1.getTjtimes() < joinGame2.getTjtimes())
                return 1;
        }
        return 0;
    }
}
