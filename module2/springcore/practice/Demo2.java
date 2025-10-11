package com.abc.springcore.practice;

import java.util.*;
import java.util.stream.Stream;

public class Demo2 {
    public static  void main(String[] args) {

        TreeSet<String> set = new TreeSet<>();
        set.add(null);

        int[] arr = {10,20,30,40};
        int sum =  Arrays.stream(arr).reduce((a, b)->a+b).getAsInt();
        System.out.println("Sum: "+sum);

        Stream.of(100,200,300,400).forEach(x->System.out.println((2*x)));

        List<Integer> list = new ArrayList<>();
        list.add(10);
        list.add(20);
        list.stream().forEach(x->System.out.println(x));

        String[] words = {"hello", "how", "are", "you"};
        Optional<String> optionalS = Arrays.stream(words).reduce((a,b)-> a+" "+b);
        if(optionalS.isPresent()) {
            String s = optionalS.get();
            System.out.println(s);
        }
    }
}
