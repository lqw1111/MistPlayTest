package com.mistplaytest.demo.Config;

import com.alibaba.fastjson.JSON;
import com.mistplaytest.demo.Model.Game;
import com.mistplaytest.demo.Utils.AutocompleteSystem;
import com.mistplaytest.demo.Utils.ReadJson;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class WebConfiguration {

    @Bean
    public AutocompleteSystem createIndex(){
        String path = ReadJson.class.getClassLoader().getResource("games.json").getPath();
        String s = ReadJson.readJsonFile(path);
        List<Game> games = JSON.parseArray(s, Game.class);
        AutocompleteSystem autocompleteSystem = new AutocompleteSystem(games);
        return autocompleteSystem;
    }
}
