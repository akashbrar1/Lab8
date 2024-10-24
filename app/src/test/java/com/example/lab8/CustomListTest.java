package com.example.lab8;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;


//import org.junit.Before;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

public class CustomListTest {
    private CustomList list;

    public CustomList MockCityList() {
        list = new CustomList(null, new ArrayList<>());
        return list;
    }

    @Test
    public void addCityTest() {
        list = MockCityList();
        int listSize = list.getCount();
        list.addCity(new City("Edmonton", "AB"));
        assertEquals(listSize + 1, list.getCount());
    }

    @Test
    void hasCityTest() {
        list = MockCityList();
        City city = new City("Regina", "Saskatchewan");
        assertFalse(list.hasCity(city));
        list.addCity(city);
        assertTrue(list.hasCity(city));
    }

    @Test
    void removeCityTest(){
        list = MockCityList();
        City city = new City("Regina", "Saskatchewan");
        assertThrows(IllegalArgumentException.class, () -> {
            list.removeCity(city);
        });
        list.addCity(city);
        assertEquals(1, list.getCount());
        list.removeCity(city);
        assertEquals(0, list.getCount());
        assertFalse(list.hasCity(city));
    }

}
