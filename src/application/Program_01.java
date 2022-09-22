package application;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import db.Conexao;
import db.exception.DBIntegrityException;

public class Program_01 {

	public static void main(String[] args) {

		Connection connection = null;
		PreparedStatement preparedStatement = null;
		try {
			connection = Conexao.getConnection();
			preparedStatement = connection.prepareStatement("DELETE FROM department WHERE id = ?");
            preparedStatement.setInt(1, 5);
			int rowsAffected = preparedStatement.executeUpdate();
			System.out.println("Done! " + rowsAffected);
		} catch (SQLException error) {
            throw new DBIntegrityException(error.getMessage());
		} finally {
           Conexao.closeStatement(preparedStatement);
           Conexao.closeConnection();
		}
	}
}
