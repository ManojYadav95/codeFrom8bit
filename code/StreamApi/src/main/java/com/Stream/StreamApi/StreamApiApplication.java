package com.Stream.StreamApi;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.Stream.StreamApi.Entity.User;

@SpringBootApplication
public class StreamApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(StreamApiApplication.class, args);
		
		List<Integer> list1 =new ArrayList<Integer>();
		for(int i=0;i<=100;i++)
			list1.add(i);
		System.out.println(list1);

		List<User> user = Arrays.asList(
		        new User("John", "Smith", "Miami", 7.38, 19),
		        new User("Mike", "Miles", "New York", 8.4, 21),
		        new User("Michael", "Peterson", "New York", 7.5, 20),
		        new User("James", "Robertson", "Miami", 9.1, 20),
		        new User("Kyle", "Miller", "Miami", 9.83, 20)
		);
		
		Map<Object, User> map1 = user.stream().collect(Collectors.toMap(n->n.getCity(), Function.identity(),(n1, n2) -> {
            System.out.println("duplicate key found!");
            return n2;
        }));
		System.out.println(map1);
		
		List<User> list2 = user.stream().filter(n->n.getCity()=="New York").collect(Collectors.toList());
		System.out.println(list2);
		
		StringBuffer sb = new StringBuffer();
		
		List<Integer> list3 = list1.stream().filter(n->n%3==0).collect(Collectors.toList());
		sb.append(list3);
		 List<StringBuffer>list4 = Arrays.asList(sb);
		Map<Object,Object> map2 = list4.stream().collect(Collectors.toMap(n->n.charAt(4),n->n));
		System.out.println(map2);
		
		sb.delete(0, sb.length());
		List<Integer> list5 = list1.stream().filter(n->n%5==0).collect(Collectors.toList());
		sb.append(list5);
		 List<StringBuffer>list6 = Arrays.asList(sb);
		Map<Object,Object> map3 = list6.stream().collect(Collectors.toMap(n->n.charAt(4),n->n));
		System.out.println(map3);
		
		sb.delete(0, sb.length());
		List<Integer> list7 = list1.stream().filter(n->n%7==0).collect(Collectors.toList());
		sb.append(list7);
		 List<StringBuffer>list8 = Arrays.asList(sb);
		Map<Object,Object> map4 = list8.stream().collect(Collectors.toMap(n->n.charAt(4),n->n));
		System.out.println(map4);
		
//		By Grouping
//		Map<Object, List<Integer>> s1 = list.stream().collect(Collectors.groupingBy(n->n%3==0 ? true:false));
//		System.out.print("3 =" +s1.get(true));
		Map<Integer,Map<String,List<User>>> s2 = user.stream().filter(e->e.getAge()>19).collect(Collectors.groupingBy(e->e.getAge(),Collectors.groupingBy(e->e.getCity() )));
		System.out.println(s2);
		
//		manually implementing the Function interface
//		Function<Integer,Integer> fun = new Function<Integer,Integer>()
//				{
//					public Integer apply(Integer n) {
//						if(n%3==0)
//							return n;
//						else
//							return null;
//					}
//					
//				};
	}

}
