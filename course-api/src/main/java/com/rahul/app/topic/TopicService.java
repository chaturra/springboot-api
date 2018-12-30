package com.rahul.app.topic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TopicService {
	
	@Autowired
	private TopicRepository topicRepository;
	
	public List<Topic> getAllTopics()
	{
		List<Topic> topics=new ArrayList<Topic>();
		topicRepository.findAll().forEach(top->topics.add(top));
		return topics;	
	}
	
	public Optional<Topic> getTopic(String id)
	{
		return topicRepository.findById(id);
		
	}

	public void addTopics(Topic topic) {
		topicRepository.save(topic);
	}

	public void updateTopic(Topic topic, String id) {
	    topicRepository.save(topic);
	}

	public void deleteTopic(String id) {
		topicRepository.deleteById(id);
		
	}
	

}
