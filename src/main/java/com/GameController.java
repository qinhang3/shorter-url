package com;

import com.exception.GameException;
import com.exception.ResultCode;
import com.game.Game;
import com.game.Location;
import com.google.gson.Gson;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.json.GsonJsonParser;
import org.springframework.http.converter.json.GsonFactoryBean;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/**
 * Created by hang on 17/1/16.
 */
@Controller
public class GameController {

    private Logger logger = LoggerFactory.getLogger(getClass());

    @Resource
    private Gson gson;

    private static final Map<String,Game> session = new HashMap<>();


    @RequestMapping("/game/gobang")
    public String gobang(){
        return "gobang";
    }

    @RequestMapping("/newGame/{type}")
    @ResponseBody
    public Response<String> newGame(@PathVariable String type){

        Game game = null;
        try {
            Class clazz = Class.forName("com.game.impl." + type);
            if (!Game.class.isAssignableFrom(clazz)){
                throw new ClassNotFoundException();
            }
            game = (Game) clazz.newInstance();
        } catch (Exception e) {
            logger.error("init Game failed.",e);
            throw new RuntimeException();
        }

        String id = UUID.randomUUID().toString();
        session.put(id, game);
        return Response.asSuccess(id);
    }

    @RequestMapping("/getMap/{sessionId}")
    @ResponseBody
    public Response getMap(@PathVariable String sessionId){
        Game game = session.get(sessionId);
        if(game == null){
            return Response.asResultCode(ResultCode.NO_SUCH_GAME);
        }
        try {
            return Response.asSuccess(game.getMap());
        } catch (GameException e) {
            logger.error("getMap error",e);
            return Response.asException(e);
        }
    }

    @RequestMapping("/play/{sessionId}")
    @ResponseBody
    public Response play(@PathVariable String sessionId, @RequestParam Long playId, @RequestParam String location){
        Location l = gson.fromJson(location, Location.class);
        Game game = session.get(sessionId);
        if (game == null){
            return Response.asResultCode(ResultCode.NO_SUCH_GAME);
        }
        try {
            Integer winnerId = game.play(playId, l);
            return Response.asSuccess(winnerId);
        } catch (GameException e) {
            return Response.asException(e);
        }
    }
}
