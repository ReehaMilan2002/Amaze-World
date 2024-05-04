package Group_9.FaircraftApp.dto;

public class FeedbackDTO {

    private long feedbackid;
    private String feedbackContent;
    private String feedbackRating;
   

    // Constructors, getters, and setters

    // Default constructor
    public FeedbackDTO() {
    }

    // Constructor with parameters
    public FeedbackDTO(long feedbackid, String feedbackContent, String feedbackRating) {
        this.feedbackid = feedbackid;
        this.feedbackContent = feedbackContent;
        this.feedbackRating = feedbackRating;
        
    }

    // Getters and setters
    public long getFeedbackid() {
        return feedbackid;
    }

    public void setFeedbackid(long feedbackid) {
        this.feedbackid = feedbackid;
    }

    public String getFeedbackContent() {
        return feedbackContent;
    }

    public void setFeedbackContent(String feedbackContent) {
        this.feedbackContent = feedbackContent;
    }

    public String getFeedbackRating() {
        return feedbackRating;
    }

    public void setFeedbackRating(String feedbackRating) {
        this.feedbackRating = feedbackRating;
    }


}
