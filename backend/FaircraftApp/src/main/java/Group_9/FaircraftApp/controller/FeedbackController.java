package Group_9.FaircraftApp.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import Group_9.FaircraftApp.dto.FeedbackDTO;
import Group_9.FaircraftApp.model.Feedback;
import Group_9.FaircraftApp.repository.FeedbackRepository;
import Group_9.FaircraftApp.service.FeedbackService;


@RestController

public class FeedbackController {
	@Autowired
	private FeedbackRepository FeedbackRepository;
	@Autowired
	FeedbackService FeedbackService;
	public FeedbackController(FeedbackService feedbackService) {
		this.FeedbackService = feedbackService;
	}
	@PostMapping("/myapi")
	public ResponseEntity<String> rateProduct (@RequestBody FeedbackDTO FeedbackDTO){
		return FeedbackService.submitFeedback(FeedbackDTO);



	}
	@GetMapping("/display")
	public ResponseEntity<List<Feedback>> displayFeedback() {
		Iterable<Feedback> feedbackIterable = FeedbackRepository.findAll();
		List<Feedback> feedbackList = new ArrayList<>();
		feedbackIterable.forEach(feedbackList::add);

		if (feedbackList.isEmpty()) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<>(feedbackList, HttpStatus.OK);
	}

}
