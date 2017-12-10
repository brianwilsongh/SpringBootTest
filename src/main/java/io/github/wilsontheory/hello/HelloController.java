package io.github.wilsontheory.hello;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.github.wilsontheory.topic.TopicService;

@RestController //this and other annotations found during class path scan
public class HelloController {

	@RequestMapping("/hello")
	public String sayHi() {
		return "Hi there";
	}
}
