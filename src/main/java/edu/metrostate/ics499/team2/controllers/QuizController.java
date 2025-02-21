package edu.metrostate.ics499.team2.controllers;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import edu.metrostate.ics499.team2.model.Quiz;
import edu.metrostate.ics499.team2.services.QuizService;

@RestController
@RequestMapping("/quiz")
public class QuizController {
	
	private final Logger LOG = LoggerFactory.getLogger(getClass());

	
	@Autowired
	private QuizService quizService;
	
	@GetMapping(value = "/all")
	public List<Quiz> list() {
	    return quizService.list();
	}
	@GetMapping(value = "{gameId}")
	public Quiz getQuizById(String id) {
		return this.quizService.getQuizById(id);
	}
	@GetMapping(value = "/questions")
	public List<Quiz> queryQuestions(String question) {
		LOG.info("Getting all quiz that match the question");
		return quizService.queryQuestions(question);
	} 
	@GetMapping(value = "/answers")
	public List<Quiz> queryAnswers(String answer) {
		LOG.info("Getting all quiz");
		return quizService.queryAnswers(answer);
	}
	
	
	@PostMapping("/add")
	public Quiz create(@RequestBody final Quiz quiz) {
		return quizService.createQuiz(quiz);
		
	}
}
	