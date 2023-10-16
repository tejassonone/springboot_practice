package com.abhi.quizapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.abhi.quizapp.dao.QuestionDao;
import com.abhi.quizapp.model.Question;

@Service
public class QuestionService {
	
	@Autowired
	QuestionDao questionDao;
	
	public List<Question> getAllQuestions() {
		System.out.println("this is all....! " + questionDao.findAll().toString());
		return questionDao.findAll();
	}

}
