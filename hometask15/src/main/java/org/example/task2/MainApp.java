package org.example.task2;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class MainApp {
    public static void main(String[] args) {

        //а если у тебя массив будет из 1000 элементов, ты так же вручную будешь создавать map?
        //2) Есть массив слов.
        // Необходимо создать map где ключ - это слово из массива, а значение - это его длинна.
        Map<String, Integer> words = new HashMap<>();
        String[] arr = {"one", "two", "three", "four", "five"};
        words.put(Arrays.toString(arr), arr.length);
        System.out.println(words);
    }
//
//        Set<Map.Entry<String, Integer>> entries = words.entrySet();
//        words.put(Arrays.toString(arr), args.length);
//        System.out.println(words);
//        for (Map.Entry<String, Integer> item : entries) {
//            String key = item.getKey();
//            Integer val = item.getValue();
//            //System.out.println(item.getValue());


//            for (String word : arr) {
//                Integer words1 = arr.length;
//                System.out.println(words);
//
//
//            }


            //Set<Map.Entry<String, Integer>> entries = words.entrySet();

            // for(Map.Entry<String, Integer> item : entries){
            //   String key = item.getKey();
            // Integer  val = item.getValue();
            // System.out.println(item.getValue());

        }


//        for (Map.Entry<String, Integer> entry : words.entrySet()) {
//            for (String key : arr) {
//                Integer length = key.length();
//                System.out.println(words);

//            for (String key : arr) {
//                Integer length = key.length();
////                System.out.println(words);
//
        //  Map<Character, Integer> map = new HashMap<>();
        //  ArrayList<Character> chars = new ArrayList<>();
        // Map <Character, Integer> mapCounter = new TreeMap <>();
        //    for (char ch : text.toCharArray()) {

        //    }
        //    return mapCounter;




//        for (String key : arr) {
//            Integer length = key.length();
//            System.out.println(length);
            // for (Map.Entry<String, Integer> entry : words.entrySet()) {
//            for (String key : arr) {
//                Integer length = key.length();
//                System.out.println(words);
//
//            }
////
//        }


//
//
//            Set<String> keys = words.keySet();
//
//            for (String key : keys) {
//                Integer length = words.get(key);
//                System.out.println("Key - " + key + " : " + "length - " + length);
//            }








//        words.put(arr[0],arr[0].length());
//        words.put(arr[1],arr[1].length());
//        words.put(arr[2],arr[2].length());
//        words.put(arr[3],arr[3].length());
//        words.put(arr[4],arr[4].length());
