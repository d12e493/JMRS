package idv.jmrs.vo;

public class Message {

	private String code;
	private String content;
	private String type;
	private String icon;

	public Message() {
		
	}

	public Message(String code, String content, String type) {
		super();
		this.code = code;
		this.content = content;
		this.type = type;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getIcon() {
		return icon;
	}

	public void setIcon(String icon) {
		this.icon = icon;
	}
}
