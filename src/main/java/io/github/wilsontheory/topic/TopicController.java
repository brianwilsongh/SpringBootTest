package io.github.wilsontheory.topic;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TopicController {
	
	@Autowired //inject the singleton as this dependency
	private TopicService topicService;

	@RequestMapping("/topics")
	public List<Topic> getAllTopics() {
		//List is auto-converted to JSON
		return topicService.getAllTopics();
	}
	
	@RequestMapping("/topics/{id}") //token is a variable
	public Topic getTopic(@PathVariable String id) {
//		@PathVariable("variableName") if the token doesn't match the argument name
		return topicService.getTopic(id);
	}
	
	/* test with something like:
	 curl -X POST -H "Content-Type: application/json" -d '{"name":"Curl command2","description":"Please work","id":"curl2"}' http://localhost:8080/topics/
	 */
	@RequestMapping(method=RequestMethod.POST, value="/topics")
	public void postTopic(@RequestBody Topic topic ) {
		//assume request payload will have JSON representation of topic
		System.out.println("Hit the topic post controller");
		topicService.addTopic(topic);
	}
	
	/*
	 curl -X PUT -H "Content-Type: application/json" -d '{"name":"Curl","description":"Update this","id":"curl"}' http://localhost:8080/topics/curl
	 */
	@RequestMapping(method=RequestMethod.PUT, value="/topics/{id}")
	public void updateTopic(@RequestBody Topic topic, @PathVariable String id) {
		System.out.println("Hit the topic post controller");
		topicService.updateTopic(id, topic);
	}
	
	
	 /*
	  curl -X DELETE http://localhost:8080/topics/curl
	  */
	@RequestMapping(method=RequestMethod.DELETE, value="/topics/{id}")
	public void deleteTopic(@PathVariable String id) {
		System.out.println("Hit the topic post controller");
		topicService.deleteTopic(id);
	}
}
