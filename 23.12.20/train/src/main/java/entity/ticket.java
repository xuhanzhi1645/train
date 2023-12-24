package entity;

import java.time.LocalDateTime;

public class ticket {

	private String tid;
	private LocalDateTime tdate;
	private String tstart;
	private String tend;
	private int tprice;
	private int tsurplus;
	private String tnumber;
	public ticket(String tid, LocalDateTime tdate, String tstart, String tend, int tprice, int tsurplus,
			String tnumber) {
		super();
		this.tid = tid;
		this.tdate = tdate;
		this.tstart = tstart;
		this.tend = tend;
		this.tprice = tprice;
		this.tsurplus = tsurplus;
		this.tnumber = tnumber;
	}
	public String getTid() {
		return tid;
	}
	public void setTid(String tid) {
		this.tid = tid;
	}
	public LocalDateTime getTdate() {
		return tdate;
	}
	public void setTdate(LocalDateTime tdate) {
		this.tdate = tdate;
	}
	public String getTstart() {
		return tstart;
	}
	public void setTstart(String tstart) {
		this.tstart = tstart;
	}
	public String getTend() {
		return tend;
	}
	public void setTend(String tend) {
		this.tend = tend;
	}
	public int getTprice() {
		return tprice;
	}
	public void setTprice(int tprice) {
		this.tprice = tprice;
	}
	public int getTsurplus() {
		return tsurplus;
	}
	public void setTsurplus(int tsurplus) {
		this.tsurplus = tsurplus;
	}
	public String getTnumber() {
		return tnumber;
	}
	public void setTnumber(String tnumber) {
		this.tnumber = tnumber;
	}
	
}
