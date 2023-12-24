package entity;

public class order {
	private String oid;
	private String uid;
	private String tid;
	private String ostatus;
	public order(String oid, String uid, String tid, String ostatus) {
		super();
		this.oid = oid;
		this.uid = uid;
		this.tid = tid;
		this.ostatus = ostatus;
	}
	public String getOid() {
		return oid;
	}
	public void setOid(String oid) {
		this.oid = oid;
	}
	public String getUid() {
		return uid;
	}
	public void setUid(String uid) {
		this.uid = uid;
	}
	public String getTid() {
		return tid;
	}
	public void setTid(String tid) {
		this.tid = tid;
	}
	public String getOstatus() {
		return ostatus;
	}
	public void setOstatus(String ostatus) {
		this.ostatus = ostatus;
	}
	
}
