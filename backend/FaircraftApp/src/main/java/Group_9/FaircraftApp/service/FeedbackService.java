package Group_9.FaircraftApp.service;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import Group_9.FaircraftApp.dto.FeedbackDTO;
import Group_9.FaircraftApp.model.Feedback;
import Group_9.FaircraftApp.repository.FeedbackRepository;

@Service
public class FeedbackService {

    private final FeedbackRepository feedbackRepository;

    public FeedbackService(FeedbackRepository feedbackRepository) {
        this.feedbackRepository = feedbackRepository;
    }

    public ResponseEntity<String> submitFeedback(FeedbackDTO feedbackDTO) {
        Feedback feedback = new Feedback();
        feedback.setFeedbackContent(feedbackDTO.getFeedbackContent());

      
        switch (feedbackDTO.getFeedbackRating()) {
            case "1":
                feedbackDTO.setFeedbackRating("Very Poor");
                break;
            case "2":
                feedbackDTO.setFeedbackRating("Poor");
                break;
            case "3":
                feedbackDTO.setFeedbackRating("Average");
                break;
            case "4":
                feedbackDTO.setFeedbackRating("Good");
                break;
            case "5":
                feedbackDTO.setFeedbackRating("Very Good");
                break;
            default:
                
                break;
        }

        feedback.setFeedbackRating(feedbackDTO.getFeedbackRating());

        Feedback savedFeedback = feedbackRepository.save(feedback);
        if (savedFeedback != null) {
            return new ResponseEntity<>("Feedback submitted successfully", HttpStatus.CREATED);
        } else {
            return new ResponseEntity<>("Failed to submit feedback", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
