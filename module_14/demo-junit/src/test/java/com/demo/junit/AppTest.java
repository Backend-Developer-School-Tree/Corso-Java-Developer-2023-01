package com.demo.junit;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class AppTest {
    List<String> myStringList;

    @BeforeAll
    static void beforeAllMethods(){

        System.out.println("Before all methods");
    }

    @BeforeEach
    void setUpBeforeEach(){
        System.out.println("Hello World");

        String s = "new";
        s.length();
        myStringList = new ArrayList<>();

        myStringList.add("My value 1");
        myStringList.add("My value 2");
        myStringList.add("My value 3");

    }

    @Test
    void notNullListTest(){
        assertNotNull(myStringList);
    }

    @Test
    void sizeListTest(){
        assertEquals(myStringList.size(), 3);
    }

    @Test
    void addElement2ListTest(){
        myStringList.add("Value 4");

        assertTrue(myStringList.size() == 4);
    }
}
