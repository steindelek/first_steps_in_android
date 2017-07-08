package com.example.stein.dragndrop;


public class Ranking {

    private int _score;
    private String _player_name;

    public Ranking(String name, int score){
        this._player_name = name;
        this._score = score;
    }

    public Ranking(){

    }

    public void set_score(int _score) {
        this._score = _score;
    }

    public void set_player_name(String _player_name) {
        this._player_name = _player_name;
    }

    public int get_score() {
        return _score;
    }

    public String get_player_name() {
        return _player_name;
    }
}
