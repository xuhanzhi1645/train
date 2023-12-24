package entity;

public class user {

	private String uid;
	private String uname;
	private String upw;
	private String id;
	private int tel;
	public user(String uid, String uname, String upw, String id, int tel) {
		super();
		this.uid = uid;
		this.uname = uname;
		this.upw = upw;
		this.id = id;
		this.tel = tel;
	}
	public String getUid() {
		return uid;
	}
	public void setUid(String uid) {
		this.uid = uid;
	}
	public String getUname() {
		return uname;
	}
	public void setUname(String uname) {
		this.uname = uname;
	}
	public String getUpw() {
		return upw;
	}
	public void setUpw(String upw) {
		this.upw = upw;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public int getTel() {
		return tel;
	}
	public void setTel(int tel) {
		this.tel = tel;
	}
	
}
