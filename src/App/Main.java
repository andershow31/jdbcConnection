package App;

import java.sql.Connection;

import db.DB;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Connection conn = DB.getConnection();
		DB.closeConnection();

	}

}
