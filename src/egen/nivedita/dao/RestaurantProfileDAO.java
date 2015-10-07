package egen.nivedita.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import egen.nivedita.exception.AppException;
import egen.nivedita.model.RestaurantProfile;
import egen.nivedita.util.DBUtils;

public class RestaurantProfileDAO {


	public List<RestaurantProfile> profileDetails() throws AppException {
			
		List<RestaurantProfile> profile = new ArrayList<RestaurantProfile>();
		Connection con = DBUtils.getConnection();
		PreparedStatement ps = null;
		ResultSet rs= null;
		
		try {
			ps = con.prepareStatement("SELECT * FROM restaurantprofile");
			rs= ps.executeQuery();
		
			while (rs.next()) {
			RestaurantProfile res= new RestaurantProfile();
			res.setName(rs.getString("RESTAURANT_NAME"));
			res.setEmail(rs.getString("EMAIL"));
			res.setAddress1(rs.getString("ADDRESS1"));
			res.setAddress2(rs.getString("ADDRESS2"));
			res.setCity(rs.getString("CITY"));
			res.setState(rs.getString("STATE"));
			res.setZip(rs.getInt("ZIP"));
			res.setContactno(rs.getString("CONTACT_NO"));
			res.setTimings(rs.getString("TIMINGS"));
			res.setAutoassign(rs.getString("AUTO_ASSIGN"));
			
			profile.add(res);
			
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

		
		return profile;
	}
	

public RestaurantProfile update(RestaurantProfile restaurant) throws AppException {

	
Connection con = DBUtils.getConnection();
PreparedStatement ps = null;
ResultSet rs = null;

try {
	ps = con.prepareStatement("UPDATE restaurantprofile SET RESTAURANT_NAME=?, EMAIL=?, ADDRESS1 = ?, ADDRESS2=?, CITY = ?, STATE = ?, ZIP=?, CONTACT_NO=?, TIMINGS=?, AUTO_ASSIGN=?");
	ps.setString(1, restaurant.getName());
	ps.setString(2, restaurant.getEmail());
	ps.setString(3, restaurant.getAddress1());
	ps.setString(4, restaurant.getAddress2());
	ps.setString(5, restaurant.getCity());
	ps.setString(6, restaurant.getState());
	ps.setInt(7, restaurant.getZip());
	ps.setString(8, restaurant.getContactno());
	ps.setString(9, restaurant.getTimings());
	ps.setString(10, restaurant.getAutoassign());
	
	
	ps.executeUpdate();
		
} catch (SQLException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
	throw new AppException(e.getMessage(), e.getCause());
}
finally {
	DBUtils.closeResources(ps, rs, con);
}

return restaurant;
}


}
