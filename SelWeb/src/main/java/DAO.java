import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DAO {

	
	public int insert(RegisterBean bean) throws ClassNotFoundException, SQLException {
		Connection con=DbUtil.dbConnection();
		String sql="insert into Register values(?,?)";
		PreparedStatement ps=con.prepareStatement(sql);
		ps.setString(1, bean.getName());
		ps.setString(2, bean.getEmail());
		return ps.executeUpdate();
	}

}
