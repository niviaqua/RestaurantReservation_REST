package egen.nivedita.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import egen.nivedita.exception.AppException;
import egen.nivedita.model.Reservation;
import egen.nivedita.util.DBUtils;

public class ReservationDAO {

	public List<Reservation> fetchAll() throws AppException {
			
		List<Reservation> resList = new ArrayList<Reservation>();
		Connection con = DBUtils.getConnection();
		PreparedStatement ps = null;
		ResultSet rs= null;
		
		try {
			ps = con.prepareStatement("SELECT * FROM reservation");
			rs= ps.executeQuery();
		
			while (rs.next()) {
			Reservation res= new Reservation();
			res.setConfid(rs.getInt("CONFID"));
			res.setHostname(rs.getString("HOST_NAME"));
			res.setEmail(rs.getString("EMAIL"));
			res.setPhone(rs.getString("PHONE"));
			res.setPartysize(rs.getInt("PARTY_SIZE"));
			res.setDate(rs.getDate("DATE"));
			res.setTime(rs.getTime("TIME"));
			res.setTable_assigned(rs.getString("TABLE_ASSIGNED"));
			res.setStatus(rs.getString("TABLE_STATUS"));
			
			resList.add(res);
			
			}
				}
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new AppException(e.getMessage(), e.getCause());
		}
		finally {
			DBUtils.closeResources(ps, rs, con);
		}

		
		return resList;
	}

public Reservation fetchOne(int confid) throws AppException {
		
	Reservation resOne = null;
	Connection con = DBUtils.getConnection();
	PreparedStatement ps = null;
	ResultSet rs= null;
	
	try {
		ps = con.prepareStatement("SELECT * FROM reservation where CONFID=?");
		ps.setInt(1, confid);
		rs= ps.executeQuery();
		
		while (rs.next()) {
		resOne = new Reservation();
		resOne.setConfid(rs.getInt("CONFID"));
		resOne.setHostname(rs.getString("HOST_NAME"));
		resOne.setEmail(rs.getString("EMAIL"));
		resOne.setPhone(rs.getString("PHONE"));
		resOne.setPartysize(rs.getInt("PARTY_SIZE"));
		resOne.setDate(rs.getDate("DATE"));
		resOne.setTime(rs.getTime("TIME"));
		resOne.setTable_assigned(rs.getString("TABLE_ASSIGNED"));
		resOne.setStatus(rs.getString("TABLE_STATUS"));
		
		}
			}
	catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		throw new AppException(e.getMessage(), e.getCause());
	}
	finally {
		DBUtils.closeResources(ps, rs, con);
	}

	
	return resOne;
	}


public Reservation create(Reservation res) throws AppException {

Connection con = DBUtils.getConnection();
PreparedStatement ps = null;
ResultSet rs = null;

try {
	ps = con.prepareStatement("INSERT INTO reservation (HOST_NAME, EMAIL, PHONE, PARTY_SIZE, DATE, TIME, TABLE_ASSIGNED, TABLE_STATUS) VALUES (?,?,?,?,?,?,?)", PreparedStatement.RETURN_GENERATED_KEYS);
	ps.setString(1, res.getHostname());
	ps.setString(2, res.getEmail());
	ps.setString(3, res.getPhone());
	ps.setInt(4, res.getPartysize());
	ps.setDate(5, res.getDate());
	ps.setTime(6, res.getTime());
	ps.setString(7, res.getTable_assigned());
	ps.setString(8, res.getStatus());
	
	ps.executeUpdate();
	
	rs= ps.getGeneratedKeys();
	if (rs.next()) {
		res.setConfid(rs.getInt(1));
	}
		
} catch (SQLException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
	throw new AppException(e.getMessage(), e.getCause());
}
finally {
	DBUtils.closeResources(ps, rs, con);
}

return res;
}




public Reservation delete(int confid) throws AppException {

Reservation reserve = new Reservation();
Connection con = DBUtils.getConnection();
PreparedStatement ps = null;
ResultSet rs = null;

try {
	ps = con.prepareStatement("UPDATE reservation SET TABLE_STATUS= ?  WHERE CONFID=?");
	ps.setString(1, "Cancelled");
	ps.setInt(2, confid);
	int row = ps.executeUpdate();
	if(row>0){
		reserve.setStatus("Reservation Cancelled");
	}else{
		reserve.setStatus("Reservation Updated");
	}
	
		
} catch (SQLException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
	throw new AppException(e.getMessage(), e.getCause());
}
finally {
	DBUtils.closeResources(ps, rs, con);
}
return reserve;

}




public Reservation update(Reservation reservation) throws AppException {

//Reservation reserve = new Reservation();
Connection con = DBUtils.getConnection();
PreparedStatement ps = null;
ResultSet rs = null;

try {
	ps = con.prepareStatement("UPDATE reservation SET HOST_NAME=?, EMAIL=?, PHONE = ?, DATE=?, TIME = ?, PARTY_SIZE = ?, TABLE_ASSIGNED=?, TABLE_STATUS=?  WHERE CONFID = ? ");
	ps.setString(1, reservation.getHostname());
	ps.setString(2, reservation.getEmail());
	ps.setString(3, reservation.getPhone());
	ps.setDate(4, reservation.getDate());
	ps.setTime(5, reservation.getTime());
	ps.setInt(6, reservation.getPartysize());
	ps.setString(7, reservation.getTable_assigned());
	ps.setString(8, reservation.getStatus());
	ps.setInt(9, reservation.getConfid());
	
	
	ps.executeUpdate();
		
} catch (SQLException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
	throw new AppException(e.getMessage(), e.getCause());
}
finally {
	DBUtils.closeResources(ps, rs, con);
}

return reservation;
}




}

