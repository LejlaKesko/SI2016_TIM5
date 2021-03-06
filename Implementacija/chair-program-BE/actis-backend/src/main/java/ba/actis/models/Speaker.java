package ba.actis.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Speaker {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	private String firstName;
	private String lastName;
	private String cv;
	private String imageLink;
	private String info;
	private String link;

	public Long getId() {
		return id;
	}

	public void setId(Long ID) {
		this.id = ID;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getCv() {
		return cv;
	}

	public void setCv(String cv) {
		this.cv = cv;
	}

	public String getImageLink() {
		return imageLink;
	}

	public void setImageLink(String imageLink) {
		this.imageLink = imageLink;
	}

	public String getInfo() {
		return info;
	}

	public void setInfo(String info) {
		this.info = info;
	}

	public String getLink() {
		return link;
	}

	public void setLink(String link) {
		this.link = link;
	}

	public Speaker(Long ID, String f, String l, String CV, String il, String info, String link) {
		this.id = ID;
		this.firstName = f;
		this.lastName = l;
		this.cv = CV;
		this.imageLink = il;
		this.info = info;
		this.link = link;
	}

	public Speaker() {
	}

	@Override
	public String toString() {
		return "Speaker [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", cv=" + cv
				+ ", imageLink=" + imageLink + ", info=" + info + ", link=" + link + "]";
	}

}
