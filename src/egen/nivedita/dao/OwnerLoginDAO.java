package egen.nivedita.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import egen.nivedita.exception.AppException;
import egen.nivedita.model.OwnerLogin;
import egen.nivedita.util.DBUtils;

public class OwnerLoginDAO {

	public List<OwnerLogin> ownerLogin() throws AppException {
			
		
		List<OwnerLogin> login = new ArrayList<OwnerLogin>();
		Connection con = DBUtils.getConnection();
		PreparedStatement ps = null;
		ResultSet rs= null;
		
		try {
			ps = con.prepareStatement("SELECT * FROM login");
			rs= ps.executeQuery();
			
			while (rs.next()) {
				OwnerLogin log= new OwnerLogin();
			log.setUsername(rs.getString("USERNAME"));
			log.setPassword(rs.getString("PASSWORD"));
			
			login.add(log);
			
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

		
		return login;
	}
}
