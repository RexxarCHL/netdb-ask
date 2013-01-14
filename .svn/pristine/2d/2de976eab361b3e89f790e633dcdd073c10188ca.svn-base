package netdb.courses.softwarestudio.asksite.mvc.model.domain;

import javax.persistence.Id;

public class Description {
	@Id private Long id;
	private String title;
	private String text;
	private long timeStamp;
	
	public Description(){
		super();
	}
	
	public Description(String title, String text){
		this.title = title;
		this.text = text;
	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public long getStamp() {
		return timeStamp;
	}

	public void setStamp(long stamp) {
		this.timeStamp = stamp;
	}
	
	public String toString(){
		return "[" + this.id + "]" + this.title + ":" + this.text;
	}
}
