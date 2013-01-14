package netdb.courses.softwarestudio.asksite.mvc.model.domain;

import javax.persistence.Id;

import com.googlecode.objectify.annotation.Indexed;

public class Comment {
	@Id
	private Long id;
    @Indexed private String title;
    private String text;
    private long stamp;
    private String passwd;

    public Comment(){
    	super();
    }
    
    public Comment(String title, String text, String passwd) {
    	this.title = title;
    	this.text = text;
    	this.passwd = passwd;
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
		return stamp;
	}

	public void setStamp(long stamp) {
		this.stamp = stamp;
	}
	
	public Boolean checkPasswd(String passwd){
		return this.passwd.equalsIgnoreCase(passwd);
	}
	
	public String getPasswd(){
		return this.passwd;
	}
	
	public String setPasswd(String passwd){
		return this.passwd = passwd;
	}
	
	public String toString(){
		return "[" + this.id + "]" + this.title + ":" + this.text;
	}
}
