package com.example.game;

public class Country {
    private String name;
    private String capital;
    private int pop;

    public Country(String name, String capital, int pop) {
        this.name = name;
        this.capital = capital;
        this.pop = pop;
    }

    public String getName() {
        return this.name;
    }

    public String getCapital() {
        return this.capital;
    }

    public int getPop() {
        return this.pop;
    }

    public String toString() {
        return "Country{name='" + this.name + '\'' + ", capital='" + this.capital + '\'' + ", pop=" + this.pop + '}';
    }
}
