package com.mistplaytest.demo.Model;

import lombok.Data;

@Data
public class Game {
    private String genre;
    private String imgURL;
    private String subgenre;
    private String title;
    private String pid;
    private String rating;
    private String rCount;

    @Override
    public String toString() {
        return "Game{" +
                "title='" + title + '\'' +
                '}';
    }
}
