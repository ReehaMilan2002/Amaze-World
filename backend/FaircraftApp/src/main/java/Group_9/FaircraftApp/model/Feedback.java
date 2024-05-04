package Group_9.FaircraftApp.model;

import jakarta.persistence.*;
@Entity

public class Feedback {
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
	public Customer getCustomer() {
		return customer;
	}
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private long feedbackid;
	private String feedbackContent;
	private String feedbackRating;
	@ManyToOne
    @JoinColumn(name = "customer_id")
    private Customer customer;

}
