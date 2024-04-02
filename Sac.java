package Carcassonne;

import java.util.ArrayList;
import java.util.Random;

public class Sac {
    private ArrayList<Tuille> sac;

    // 24 type of cards
    public Sac(){
        for(int i=1; i<=24; i++)
        {
            switch (i) {
                case 1:
                    for(int j = 0; j<9; j++){
                        sac.add(new Tuille(CardContent.FIELD, CardContent.ROAD, CardContent.FIELD, CardContent.ROAD, CardContent.FIELD, i, false));
                    }
                    break;
                case 2:
                    for(int j=0; j<3; j++){
                        sac.add(new Tuille(CardContent.CITY_BORDER, CardContent.ROAD, CardContent.FIELD, CardContent.ROAD, CardContent.FIELD, i, false));
                    }
                    break;
                case 3:
                    sac.add(new Tuille(CardContent.CITY_BORDER, CardContent.ROAD, CardContent.ROAD, CardContent.CITY_BORDER, CardContent.FIELD, i, true));
                    sac.add(new Tuille(CardContent.CITY_BORDER, CardContent.ROAD, CardContent.ROAD, CardContent.CITY_BORDER, CardContent.FIELD, i, true));
                    break;
                case 4:
                    sac.add(new Tuille(CardContent.CITY_BORDER, CardContent.ROAD, CardContent.CITY_BORDER, CardContent.CITY_BORDER, CardContent.CITY_BORDER, i, false));
                    break;
                case 5:
                    sac.add(new Tuille(CardContent.CITY_BORDER, CardContent.FIELD, CardContent.CITY_BORDER, CardContent.CITY_BORDER, CardContent.CITY_BORDER, i, true));
                    break;
                case 6:
                    for(int j=0; j<3; j++){
                        sac.add(new Tuille(CardContent.CITY_BORDER, CardContent.ROAD, CardContent.ROAD, CardContent.CITY_BORDER, CardContent.FIELD, i, false));
                    }
                    break;
                case 7:
                    for(int j=0; j<3; j++){
                        sac.add(new Tuille(CardContent.CITY_BORDER, CardContent.ROAD, CardContent.ROAD, CardContent.ROAD, CardContent.ROAD, i, false));
                    }
                    break;
                case 8:
                    for(int j=0; j<8; j++){
                        sac.add(new Tuille(CardContent.ROAD, CardContent.ROAD, CardContent.FIELD, CardContent.FIELD, CardContent.ROAD, i, false));
                    }
                    break;
                case 9:
                    for(int j=0; j<4; j++){
                        sac.add(new Tuille(CardContent.FIELD, CardContent.ROAD, CardContent.ROAD, CardContent.ROAD, CardContent.CARREFOUR, i, false));
                    }
                    break;
                case 10:
                    for(int j=0; j<5; j++){
                        sac.add(new Tuille(CardContent.CITY_BORDER, CardContent.FIELD, CardContent.FIELD, CardContent.FIELD, CardContent.FIELD, i, false));
                    }
                    break;
                case 11:
                    sac.add(new Tuille(CardContent.CITY_BORDER, CardContent.FIELD, CardContent.CITY_BORDER, CardContent.FIELD, CardContent.FIELD, i, false));
                    sac.add(new Tuille(CardContent.CITY_BORDER, CardContent.FIELD, CardContent.CITY_BORDER, CardContent.FIELD, CardContent.FIELD, i, false));
                    break;
                case 12:
                    for(int j=0; j<3; j++){
                        sac.add(new Tuille(CardContent.CITY_BORDER, CardContent.FIELD, CardContent.CITY_BORDER, CardContent.CITY_BORDER, CardContent.CITY_BORDER, i, false));
                    }
                    break;
                case 13:
                    for(int j=0; j<4; j++){
                        sac.add(new Tuille(CardContent.FIELD, CardContent.FIELD, CardContent.FIELD, CardContent.FIELD, CardContent.CHURCH, i, false));
                    }
                    break;
                case 14:
                    sac.add(new Tuille(CardContent.FIELD, CardContent.ROAD, CardContent.FIELD, CardContent.FIELD, CardContent.CHURCH, i, false));
                    sac.add(new Tuille(CardContent.FIELD, CardContent.ROAD, CardContent.FIELD, CardContent.FIELD, CardContent.CHURCH, i, false));
                    break;
                case 15:
                    for(int j=0; j<3; j++){
                        sac.add(new Tuille(CardContent.CITY_BORDER, CardContent.FIELD, CardContent.CITY_BORDER, CardContent.FIELD, CardContent.FIELD, i, false));
                    }
                    break;
                case 16:
                    sac.add(new Tuille(CardContent.FIELD, CardContent.FIELD, CardContent.CITY_BORDER, CardContent.CITY_BORDER, CardContent.CITY_BORDER, i, true));
                    sac.add(new Tuille(CardContent.FIELD, CardContent.FIELD, CardContent.CITY_BORDER, CardContent.CITY_BORDER, CardContent.CITY_BORDER, i, true));
                    break;
                case 17:
                    for(int j=0; j<4; j++){
                        sac.add(new Tuille(CardContent.CITY_BORDER, CardContent.FIELD, CardContent.ROAD, CardContent.ROAD, CardContent.CARREFOUR, i, false));
                    }
                    break;
                case 18:
                    for(int j=0; j<3; j++){
                        sac.add(new Tuille(CardContent.CITY_BORDER, CardContent.ROAD, CardContent.FIELD, CardContent.ROAD, CardContent.ROAD, i, false));
                    }
                    break;
                case 19:
                    sac.add(new Tuille(CardContent.FIELD, CardContent.FIELD, CardContent.CITY_BORDER, CardContent.CITY_BORDER, CardContent.CITY_BORDER, i, false));
                    break;
                case 20:
                    sac.add(new Tuille(CardContent.CITY_BORDER, CardContent.ROAD, CardContent.CITY_BORDER, CardContent.CITY_BORDER, CardContent.CITY_BORDER, i, true));
                    sac.add(new Tuille(CardContent.CITY_BORDER, CardContent.ROAD, CardContent.CITY_BORDER, CardContent.CITY_BORDER, CardContent.CITY_BORDER, i, true));
                    break;
                case 21:
                    sac.add(new Tuille(CardContent.CITY_BORDER, CardContent.CITY_BORDER, CardContent.CITY_BORDER, CardContent.CITY_BORDER, CardContent.CITY_BORDER, i, true));
                    break;
                case 22:
                    sac.add(new Tuille(CardContent.ROAD, CardContent.ROAD, CardContent.ROAD, CardContent.ROAD, CardContent.CARREFOUR, i, false));
                    break;
                case 23:
                    sac.add(new Tuille(CardContent.CITY_BORDER, CardContent.FIELD, CardContent.FIELD, CardContent.CITY_BORDER, CardContent.FIELD, i, true));
                    sac.add(new Tuille(CardContent.CITY_BORDER, CardContent.FIELD, CardContent.FIELD, CardContent.CITY_BORDER, CardContent.FIELD, i, true));
                    break;
                case 24:
                    for(int j=0; j<8; j++){
                        sac.add(new Tuille(null, null, null, null, null, i, false));
                    }
                    break;
            }
        }
    }

    public boolean isEmpty(){
        return sac.isEmpty();
    }

    public Tuille pioche(){
        Random rd = new Random();
        Tuille tPioche = sac.remove(rd.nextInt(sac.size()));
        return tPioche;
    }
}
