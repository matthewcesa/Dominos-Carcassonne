package Carcassonne;

public enum CardContent {
    FIELD, ROAD, CITY_BORDER, CHURCH, CARREFOUR;

    // compare les type et retourne true si ils sont le meme;
    public boolean equals(CardContent type){
        return this == type;
    }
}
