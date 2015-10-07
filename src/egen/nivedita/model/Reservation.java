package egen.nivedita.model;

import java.sql.Timestamp;
import java.sql.Date;
import java.sql.Time;

public class Reservation {

	private int confid;
	private String hostname;
	private String email;
	private String phone;
	private int partysize;
	private Date date;
	private Time time;
	private String table_assigned;
	private String status;
	public int getConfid() {
		return confid;
	}
	public void setConfid(int confid) {
		this.confid = confid;
	}
	public String getHostname() {
		return hostname;
	}
	public void setHostname(String hostname) {
		this.hostname = hostname;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public int getPartysize() {
		return partysize;
	}
	public void setPartysize(int partysize) {
		this.partysize = partysize;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public Time getTime() {
		return time;
	}
	public void setTime(Time time) {
		this.time = time;
	}
	public String getTable_assigned() {
		return table_assigned;
	}
	public void setTable_assigned(String table_assigned) {
		this.table_assigned = table_assigned;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
	
}
