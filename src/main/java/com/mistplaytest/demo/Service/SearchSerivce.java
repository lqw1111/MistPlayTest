package com.mistplaytest.demo.Service;

import com.mistplaytest.demo.Model.Game;
import com.mistplaytest.demo.Utils.AutocompleteSystem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SearchSerivce {

    @Autowired
    private AutocompleteSystem autocompleteSystem;

    public List<Game> search(String name) {
        return autocompleteSystem.input(name);
    }
}
