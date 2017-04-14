package com.jdk8.test;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.Test;

public class OptionalTest {

	@Test
	public void test() {
		String str = "hello";
		Optional<String> optional = Optional.ofNullable(str);
		optional.ifPresent(System.out::println);
		System.out.println(optional.orElse("11"));
		System.out.println(optional.orElseGet(String::new));
	}
	
	@Test
	public void test2() {
		Stream<String> stream = Stream.of("hello", "world", "welcome");
		//List<String> list = stream.collect(() -> new ArrayList<String>(), (result, item) -> result.add(item), (list1, list2) -> list1.addAll(list2));
		//List<String> list = stream.collect(ArrayList::new, ArrayList::add, ArrayList::addAll);
		List<String> list = stream.collect(Collectors.toList());
		list.forEach(System.out::println);
		
		Stream<String> stream2 = Stream.of("hello", "world", "welcome");
		String name = stream2.collect(StringBuffer::new, StringBuffer::append, StringBuffer::append).toString();
		System.out.println(name);
	}
}
