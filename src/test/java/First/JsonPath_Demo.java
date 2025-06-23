package First;

import com.jayway.jsonpath.JsonPath;
public class JsonPath_Demo {
 
    public static void main(String args[]) {
 
        String jsonString = "{\n" +
                "                \"store\":\n" +
                "        {\n" +
                "            \"book\": [\n" +
                "            {\n" +
                "                \"category\":\"reference\",\n" +
                "                    \"author\":\"Nigel Rees\",\n" +
                "                    \"title\":\"Sayings of the Century\",\n" +
                "                    \"price\":8.95\n" +
                "            },\n" +
                "            {\n" +
                "                \"category\":\"fiction\",\n" +
                "                    \"author\":\"Evelyn Waugh\",\n" +
                "                    \"title\":\"Sword of Honour\",\n" +
                "                    \"price\":12.99\n" +
                "            },\n" +
                "            {\n" +
                "                \"category\":\"fiction\",\n" +
                "                    \"author\":\"Herman Melville\",\n" +
                "                    \"title\":\"Moby Dick\",\n" +
                "                    \"isbn\":\"0-553-21311-3\",\n" +
                "                    \"price\":8.99\n" +
                "            },\n" +
                "            {\n" +
                "                \"category\":\"fiction\",\n" +
                "                    \"author\":\"J. R. R. Tolkien\",\n" +
                "                    \"title\":\"The Lord of the Rings\",\n" +
                "                    \"isbn\":\"0-395-19395-8\",\n" +
                "                    \"price\":22.99\n" +
                "            }\n" +
                "        ],\n" +
                "            \"bicycle\":{\n" +
                "                \"color\":\"red\",\n" +
                "                    \"price\":19.95\n" +
                "            }\n" +
                "        },\n" +
                "        \"expensive\":10\n" +
                "    }";
 
 
        String allBooks = JsonPath.read(jsonString, "$..*").toString();
        System.out.println("--------------- All books in the store --------------");
        System.out.println(allBooks);
        
        String expensiveBook = JsonPath.read(jsonString, "$.store.book[?(@.price > 10)]").toString();
        System.out.println("--------------- All books in store costlier than 10 ---------------");
        System.out.println(expensiveBook);
        
        String pabook = JsonPath.read(jsonString, "$.store.book[?(@.author == \"J. R. R. Tolkien\" )].title").toString();
        System.out.println("--------------- Particular Book --------------");
        System.out.println(pabook);
 
    }
}
