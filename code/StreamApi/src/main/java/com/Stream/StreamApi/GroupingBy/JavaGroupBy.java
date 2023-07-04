package com.Stream.StreamApi.GroupingBy;

import java.util.*;
import java.util.stream.*;

public class JavaGroupBy{
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();

        for(int i = 1;i<= 100;i++){
            list.add(i);
        }
        // Stream<Integer> s1 = list.stream().filter(n->n%2==0);
        // s1.forEach(n->System.out.println(n));

        Map<String,List<Integer>> list1 = list.stream().collect(Collectors.groupingBy(n->{
            if(n%20==0){
                if(n%30==0)
                    return "Divisible by 10,20 and 30";
                else
                    return "Divisible by 10 and 20";
            }
            else if(n%30==0)
                    return "Divisible by 10,20 and 30";
                else if(n%10==0 && n%20==0)
                    return "Divisible by 10 and 20";
                else if(n%10==0)
                    return "Divisible by 10";
                else
                    return "Not Divisible by 10,20 and 30";
        }
        ));
        List<Integer> list2 = list1.get("Divisible by 10");
        List<Integer> list3 = list1.get("Divisible by 10 and 20");
        List<Integer> list4 = list1.get("Divisible by 10,20 and 30");
        //List<Integer> list6 = list1.get("Not Divisible by 10,20 and 30");
        List<Integer> list5 = new ArrayList<>();
        list5.addAll(list2);
        list5.addAll(list3);
        list5.addAll(list4);
        // System.out.println(list5);
        // System.out.println(list3);
        // System.out.println(list4);

        List<Integer> list7 = list5.stream().sorted().collect(Collectors.toList());
        // System.out.println(list7);

        Map<Integer, List<Integer>> divideByTen = list7.stream().collect(Collectors.groupingBy(n->{
            if(n%10==0)
                return 10;
            else
                return 0;
        }));
        System.out.println(divideByTen);

        Map<Integer, List<Integer>> divideByTwen = list7.stream().collect(Collectors.groupingBy(n->{
            if(n%20!=0)
                return 0;
            else
                return 20;
        }));
        List<Integer> listofTwenty = divideByTwen.get(20);
        Map<Integer, List<Integer>> divideByTwenty = listofTwenty.stream().collect(Collectors.groupingBy(n->{
            if(n%20!=0)
                return 0;
            else
                return 20;
        }));
        System.out.println(divideByTwenty);

        Map<Integer, List<Integer>> divideByThir = list7.stream().collect(Collectors.groupingBy(n->{
            if(n%30!=0)
                return 0;
            else
                return 30;
        }));
        List<Integer> listofThirty = divideByThir.get(30);
        Map<Integer, List<Integer>> divideByThirty = listofThirty.stream().collect(Collectors.groupingBy(n->{
            if(n%30!=0)
                return 0;
            else
                return 30;
        }));
        System.out.println(divideByThirty);
        
    }
}
