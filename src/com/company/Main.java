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
import java.net.MalformedURLException;
import java.util.*;

public class Main {

    public static void main(String[] args) {
        // write your code here

        //  Instantiate a hashmap
        Map<String, Integer> boy_map_2001 = new HashMap<String, Integer>();
        Map<String, Integer> girl_map_2001 = new HashMap<String, Integer>();

        List<HashMap<String, Integer>> list_of_boy_maps = new ArrayList<HashMap<String, Integer>>();
        List<HashMap<String, Integer>> list_of_girl_maps = new ArrayList<HashMap<String, Integer>>();

        /*
        Each ArrayList has 10 elements each.
        Each element's index corresponds to a HashMap of a certain year:
        Index 0 - Year 2001
        Index 1 - Year 2002
        .
        .
        Index 9 - Year 2010
         */
        for (int i = 0; i < 10; i++) {
            list_of_boy_maps.add(new HashMap<String, Integer>());
            list_of_girl_maps.add(new HashMap<String, Integer>());
        }

        String[] URLs = new String[]{
                "http://liveexample.pearsoncmg.com/data/babynameranking2001.txt",
                "http://liveexample.pearsoncmg.com/data/babynamesranking2002.txt",
                "http://liveexample.pearsoncmg.com/data/babynamesranking2003.txt",
                "http://liveexample.pearsoncmg.com/data/babynamesranking2004.txt",
                "http://liveexample.pearsoncmg.com/data/babynamesranking2005.txt",
                "http://liveexample.pearsoncmg.com/data/babynamesranking2006.txt",
                "http://liveexample.pearsoncmg.com/data/babynamesranking2007.txt",
                "http://liveexample.pearsoncmg.com/data/babynamesranking2008.txt",
                "http://liveexample.pearsoncmg.com/data/babynamesranking2009.txt",
                "http://liveexample.pearsoncmg.com/data/babynamesranking2010.txt"
        };


        for (int i = 0; i < 10; i++) {
            try (java.util.Scanner input = new java.util.Scanner(new java.net.URL(
                    URLs[i]
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
                    list_of_boy_maps.get(i).put(boy_name, ranking);
                    list_of_girl_maps.get(i).put(girl_name, ranking);

                }

            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            } catch (NoSuchElementException e) {

            }
        }
        //After the try block, a populated hashmap should exist.

//        for (int i = 0; i < 10; i++) {
//            System.out.println(list_of_boy_maps.get(i).get("Joseph"));
//        }

        /*
        Ask the user for input
         */

        // Variables stored from user input
        int user_year;
        String user_gender;
        String user_name; // User must type in name case sensitive. Capital first letter.

        // Create a Scanner object

        Scanner in = new Scanner(System.in);

        System.out.print("Please enter a year [2001 - 2010]: ");
        user_year = in.nextInt();
        in.nextLine();
        System.out.print("\nPlease enter a gender [B/G]: ");
        user_gender = in.nextLine();
        System.out.print("\nPlease enter a name (case sensitive. Capitalize the first letter): ");
        user_name = in.nextLine();

        /*
        Assuming correct input from the user, the index of the ArrayList that corresponds
        to the year is:
        user_year - 2001
         */

        if (user_gender.equalsIgnoreCase("B")) { // Boy
            System.out.print("The ranking of the boy name for your chosen year is: ");
            System.out.print(list_of_boy_maps.get(user_year - 2001).get(user_name));
        } else {
            System.out.print("The ranking of the girl name for your chosen year is: ");
            System.out.print(list_of_girl_maps.get(user_year - 2001).get(user_name));
        }




    }
}