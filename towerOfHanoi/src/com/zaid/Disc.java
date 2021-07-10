package com.zaid;

public class Disc {

    private Integer size;   // AKA diameter of the disc
    private String art; // How the disc looks lke accordingly with their respective diameter values

    // Constructor
    Disc (Integer size, String art) {
        setSize(size);
        setArt(art);
    }

    // Set size of respective disc
    void setSize(Integer s) {
        if ((s > -1) && (s < 4)){
            this.size = s;
        } else {
            this.size = 0;
        }
    }

    // Return size of respective disc
    int getSize() {
        return this.size;
    }

    // Set art of respective disc
    void setArt(String art) {
        if ((art.equals("-")) || (art.equals("--")) || (art.equals("---"))) {
            this.art = art;
        } else {
            this.art = "|";
        }
    }

    // Return art of respective disc
    String getArt() {
        return this.art;
    }
}
