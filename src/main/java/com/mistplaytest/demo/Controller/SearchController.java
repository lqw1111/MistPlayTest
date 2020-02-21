package com.mistplaytest.demo.Controller;

import com.mistplaytest.demo.Model.Game;
import com.mistplaytest.demo.Service.SearchSerivce;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class SearchController {

    @Autowired
    private SearchSerivce searchSerivce;

    @GetMapping("/search")
    public List<Game> search(@RequestParam("name") String name){
        return searchSerivce.search(name);
    }

}
