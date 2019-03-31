package com.sherlock.thoughtgame;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import static org.junit.Assert.*;

public class Challenge4Test {

    private Challenge4 challenge4 = new Challenge4();

    @Test
    public void solve() throws IOException {
        String json = "[\n" +
                "            {\n" +
                "                \"name\": \"Stainless Steel Cutter Peeler Tool Pineapple Seed Clip Home Kitchen Gadgets\",\n" +
                "                \"category\": \"Kitchen\",\n" +
                "                \"price\": 260,\n" +
                "                \"startDate\": \"2017-01-30\",\n" +
                "                \"endDate\": \"2017-04-04\"\n" +
                "            },\n" +
                "            {\n" +
                "                \"name\": \"20.5cm Fruit Cutter Chef Kitchen Cutlery Knife Knives Choice - 07\",\n" +
                "                \"category\": \"Kitchen\",\n" +
                "                \"price\": 149,\n" +
                "                \"startDate\": \"2017-01-30\",\n" +
                "                \"endDate\": \"2019-12-04\"\n" +
                "            },\n" +
                "            {\n" +
                "                \"name\": \"LETV LeEco Le 2 32GB Rose Gold\",\n" +
                "                \"category\": \"Electronics\",\n" +
                "                \"price\": 1737,\n" +
                "                \"startDate\": \"2017-01-30\",\n" +
                "                \"endDate\": null\n" +
                "            },\n" +
                "            {\n" +
                "                \"name\": \"Nokia 1100\",\n" +
                "                \"category\": \"Electronics\",\n" +
                "                \"price\": 999,\n" +
                "                \"startDate\": \"2019-09-30\",\n" +
                "                \"endDate\": null\n" +
                "            },\n" +
                "            {\n" +
                "                \"name\": \"Homefab India Set of 2  Beautiful Marble Plain Black Curtains (HF342)\",\n" +
                "                \"category\": \"Furniture\",\n" +
                "                \"price\": 499,\n" +
                "                \"startDate\": \"2019-09-30\",\n" +
                "                \"endDate\": null\n" +
                "            }\n" +
                "        ]";

        ObjectMapper obj = new ObjectMapper();
        List<Input> inputList = (List<Input>)obj.readValue(json,new TypeReference<List<Input>>(){});


        HashMap<String, Integer> output= challenge4.solve(inputList);

        assertEquals(new Integer(1886),output.get("totalValue"));
    }

}