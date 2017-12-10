package io.github.wilsontheory.topic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class TopicService {
	//business service, singleton
	static List<Topic> topics = new ArrayList<>();
	static {
		topics.add(new Topic("Spring Framework", "Spring framework description", "spring"));
		topics.add(new Topic("Core Java", "Core Java description", "java"));
		topics.add(new Topic("JavaScript", "JavaScript description", "javascript"));
	}
	
	
	public List<Topic> getAllTopics(){
		return topics;
	}
	
	public Topic getTopic(String id) {
		return topics.stream().filter(topic -> topic.getId().equals(id)).findFirst().get();
	}
	
	public void addTopic(Topic topic) {
		topics.add(topic);
	}
	
	public void updateTopic(String id, Topic topic) {
		for (int idx = 0; idx < topics.size(); idx++) {
			if (id.equals(topics.get(idx).getId())) {
				topics.set(idx, topic);
				return;
			}
		}
	}
	
	public void deleteTopic(String id) {
		topics.removeIf(topic -> topic.getId().equals(id));
	}
	
	
}
