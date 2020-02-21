package com.mistplaytest.demo.Utils;

import com.mistplaytest.demo.Model.Game;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class AutocompleteSystem {

    class TrieNode{
        HashMap<Character, TrieNode> children;
        HashMap<String, Game> count;
        boolean is_word;
        public TrieNode(){
            children = new HashMap<Character, TrieNode>();
            count = new HashMap<String,Game>();
            is_word = false;
        }
    }

    class Pair{
        int time;
        String sentence;
        public Pair(int time, String sentence){
            this.time = time;
            this.sentence = sentence;
        }
    }
    TrieNode root;

    public AutocompleteSystem(List<Game> games) {
        root = new TrieNode();
        for(int i = 0 ; i < games.size() ; i ++){
            add(games.get(i));
        }
    }

    private void add(Game game){
        TrieNode cur = root;
        for(Character c : game.getTitle().toLowerCase().toCharArray()){
            TrieNode next = cur.children.get(c);
            if(next == null){
                next = new TrieNode();
                cur.children.put(c, next);
            }
            cur = next;
            cur.count.put(game.getTitle(), game);
        }
        cur.is_word = true;
    }

    public List<Game> input(String searchWord) {
        TrieNode cur = root;
        for(Character cc : searchWord.toLowerCase().toCharArray()){
            TrieNode next = cur.children.get(cc);
            if(next == null){
                return new ArrayList<>();
            }
            cur = next;
        }
        List<Game> res = new ArrayList<Game>();
        for(String sentence : cur.count.keySet()){
            res.add(cur.count.get(sentence));
        }
        return res;
    }

}
