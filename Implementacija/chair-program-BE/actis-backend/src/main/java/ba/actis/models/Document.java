package ba.actis.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
public class Document {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@OneToOne(targetEntity=User.class)
	@JoinColumn(name="id")
	private Long userId;
	private String documentLink;
	private Boolean isApproved;
	
	public Long getUserId() {
		return userId;
	}
	
	public void setUserId(Long userId) {
		this.userId = userId;
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
}