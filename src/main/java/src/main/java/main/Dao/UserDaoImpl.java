package src.main.java.main.Dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import src.main.java.main.entity.Posted;
import src.main.java.main.entity.User;

@Component
public class UserDaoImpl {

	
	private static final String CREATE_SQL = "		CREATE TABLE `user` (\r\n" +
			"				  `user_id` int(11) NOT NULL,\r\n" +
			"				  `user_name` varchar(500) DEFAULT NULL,\r\n" +
			"				  `password` varchar(20) DEFAULT NULL,\r\n" +
			"				  PRIMARY KEY (`user_id`)\r\n" +
			"				) ENGINE=InnoDB DEFAULT CHARSET=utf8;";

	
	private static final String INSERT_SQL = "insert into user values(?,?,?);";

	private static final String GET_MAX_ID = "select max(user_id) from user ;";

	/*
	 * テーブルUSERをデータベースSNSに作成します。
	 * 実行結果をBooleanで返します
	 *
	 */
	public boolean createUser() throws SQLException {

		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/SNS","root","worksap");

		int rs ;

		try(PreparedStatement ste = conn.prepareStatement(CREATE_SQL)){

			rs = ste.executeUpdate();

		}catch(SQLException e) {
			return false;
		}

		return (rs==0) ? false : true;

	}
	
	public boolean registUser(User user,Connection conn) throws SQLException {

		int rs ;
		try(PreparedStatement ste = conn.prepareStatement(INSERT_SQL)){

			int userId = user.getUserId();
			if(userId==-1) {
				userId= getMaxUserId(conn)+1;
			}


			int index = 0;
			ste.setInt(++index,userId);
			ste.setString(++index, user.getUserName());
			ste.setString(++index, user.getPassword());

			System.out.println("Insert userにプリペアードステートメント"+ste);

			rs = ste.executeUpdate();

		}

		return (rs==0) ? false : true;
	}



	private int getMaxUserId(Connection conn) throws SQLException {
		try(PreparedStatement ste = conn.prepareStatement(GET_MAX_ID)){

			ResultSet rs = ste.executeQuery();

			rs.next();

			return rs.getInt(1);
		}

	}


}
