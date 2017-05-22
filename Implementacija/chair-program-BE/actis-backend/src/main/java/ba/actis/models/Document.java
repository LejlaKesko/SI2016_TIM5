package ba.actis.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class Document {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@OneToOne(targetEntity= User.class)
	@JoinColumn(name="user_id")
	private User userId;
	
	private String documentLink;
	private Integer review;
	
	@OneToOne(targetEntity= User.class)
	@JoinColumn(name="reviewer_id")
	private User reviewerId;
	
	private Boolean isApproved;
	
	Document (){}
	public Long getId() {
		return id;
	}

	public void setId(Long ID) {
		this.id = ID;
	}

	public User getUserId() {
		return userId;
	}
	
	public void setUserId(User userId) {
		this.userId = userId;
	}

	public User getReviewerId() {
		return reviewerId;
	}
	
	public void setReviewerId(User reviewerId) {
		this.reviewerId = reviewerId;
	}
	
	public String getDocumentLink() {
		return documentLink;
	}
	
	public void setDocumentLink(String documentLink) {
		this.documentLink = documentLink;
	}
	
	public Boolean getIsApproved() {
		return isApproved;
	}
	
	public void setIsApproved(Boolean isApproved) {
		this.isApproved = isApproved;
	}
	public Integer getReview() {
		return review;
	}
	public void setReview(Integer review) {
		this.review = review;
	} 
	
	
}
