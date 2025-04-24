package com.gestion;
import java.util.ArrayList;
/**
 *
 * @author Djenidi
 */
public class ValuePassed {
    public static int idTrajet = 0;
    public static int idTrain = 0;
    public static int page = 0;
    public static ArrayList<String> place = new ArrayList<String>();
    public static ArrayList<Integer> idPlace = new ArrayList<Integer>();
    public static String listToString()
    {
        String listPlace = "";
        for (int i = 0; i < ValuePassed.place.size(); i++)
        {
            if (i > 0)
                listPlace += " , ";
            listPlace += ValuePassed.place.get(i);
        }
        return listPlace;
    }
}
