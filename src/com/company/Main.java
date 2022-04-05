// Rafeeq Muhammad
// C00429103
// CMPS 261
//
// Program Description:
//
// Certificate of Authenticity:
//I certify that the code in the method functions including method function main of this project are entirely my own work.


package com.company;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.util.HashMap;
import java.util.Map;
import java.util.NoSuchElementException;

public class Main {

    public static void main(String[] args) {
        // write your code here

        //  Instantiate a hashmap
        Map<String, Integer> boy_map_2001 = new HashMap<String, Integer>();
        Map<String, Integer> girl_map_2001 = new HashMap<String, Integer>();


        /*
        http://liveexample.pearsoncmg.com/data/babynameranking2001.txt
        http://liveexample.pearsoncmg.com/data/babynamesranking2002.txt
        http://liveexample.pearsoncmg.com/data/babynamesranking2003.txt
        http://liveexample.pearsoncmg.com/data/babynamesranking2004.txt
        http://liveexample.pearsoncmg.com/data/babynamesranking2005.txt
        http://liveexample.pearsoncmg.com/data/babynamesranking2006.txt
        http://liveexample.pearsoncmg.com/data/babynamesranking2007.txt
        http://liveexample.pearsoncmg.com/data/babynamesranking2008.txt
        http://liveexample.pearsoncmg.com/data/babynamesranking2009.txt
        http://liveexample.pearsoncmg.com/data/babynamesranking2010.txt
         */


        try (java.util.Scanner input = new java.util.Scanner(new java.net.URL(
                "http://liveexample.pearsoncmg.com/data/babynameranking2001.txt"
        ).openStream())) {

            String inputLine;
            while ((inputLine = input.nextLine()) != null) {
//                System.out.println(inputLine);

                // Make an array that splits the input line by tokens
                String[] inputLine_tokens = inputLine.split("\\s+");

                /*
                inputLine_tokens:
                [0] is the ranking
                [1] is the boy name
                [3] is the girl name
                 */
                int ranking = Integer.parseInt(inputLine_tokens[0]);
                String boy_name = inputLine_tokens[1];
                String girl_name = inputLine_tokens[3];

                /*
                For each iteration of the loop...
                Store relevant information into relevant hashmaps
                 */
                boy_map_2001.put(boy_name, ranking);
                girl_map_2001.put(girl_name, ranking);

            }

        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (NoSuchElementException e) {

        }

        //After the try block, a populated hashmap should exist.

//        System.out.print(boy_map_2001.get("Roland"));
    }
}