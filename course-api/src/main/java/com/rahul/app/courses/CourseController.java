package com.rahul.app.courses;

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

import com.rahul.app.topic.Topic;

@RestController
public class CourseController {
	@Autowired
	CourseService courseserv;
	
	@RequestMapping("/topics/{id}/courses")
	public List<Course> getAllCourses(@PathVariable String id)
	{
		return courseserv.getAllCourses(id);
	} 
	@RequestMapping("/topics/{topicId}/courses/{id}")
	public Optional<Course> getTopic(@PathVariable String id)
	{
		return courseserv.getCourse(id);
	}
	
	@PostMapping(path="/topics/{topicId}/courses/{id}", consumes="application/json")
	public void addTopics(@RequestBody Course course, @PathVariable String topicId)
	{
		course.setTopic(new Topic(topicId,"",""));
		courseserv.addCourses(course);
		
	}
	@PutMapping(path="/topics/{topicId}/courses/{id}", consumes="application/json")
	public void updateTopic(@RequestBody Course course,@PathVariable String topicId,@PathVariable String id)
	{
		course.setTopic(new Topic(topicId,"",""));
		courseserv.updateCourse(course);
		
	}
	
	@DeleteMapping(path="/topics/{topicId}/courses/{id}")
	public void deleteTopic(@PathVariable String id)
	{
		courseserv.deleteCourse(id);
	}

}
