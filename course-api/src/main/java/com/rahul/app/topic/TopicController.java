package com.rahul.app.topic;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TopicController {
	@Autowired
	TopicService topicserv;
	
	@RequestMapping("/topics")
	public List<Topic> getAlltopics()
	{
		return topicserv.getAllTopics();
	}
	@RequestMapping("/topics/{id}")
	public Optional<Topic> getTopic(@PathVariable String id)
	{
		return topicserv.getTopic(id);
	}
	
	@PostMapping(path="/topics", consumes="application/json")
	public void addTopics(@RequestBody Topic topic)
	{
		topicserv.addTopics(topic);
		
	}
	
	@PutMapping(path="/topics/{id}", consumes="application/json")
	public void updateTopic(@RequestBody Topic topic,@PathVariable String id)
	{
		topicserv.updateTopic(topic,id);
		
	}
	
	@DeleteMapping(path="/topics/{id}")
	public void deleteTopic(@PathVariable String id)
	{
		topicserv.deleteTopic(id);
	}

}
