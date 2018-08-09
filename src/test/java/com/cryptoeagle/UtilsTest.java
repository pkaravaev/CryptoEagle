package com.cryptoeagle;

import org.junit.Test;

import static org.junit.Assert.*;

public class UtilsTest {

    @Test
    public void cut() {

        String test ="https://stackoverflow.com/questions/";

        String end =  Utils.cut(test);

    }
}