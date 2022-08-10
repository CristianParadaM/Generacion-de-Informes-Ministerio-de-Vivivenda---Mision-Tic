package connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 * @author CRISTIAN DAVID PARADA MARTINEZ
 * @date 8/08/2022
 */
public class ConnectionBD {

	private Connection connection;
	private Statement statement;
	private static final String URL_BD = "jdbc:sqlite:ProyectosConstruccion.db";

	/**
	 * Constructor de ConnectionBD
	 * 
	 */
	public ConnectionBD() {
		try {
			Class.forName("org.sqlite.JDBC");
			connection = DriverManager.getConnection(URL_BD);
			statement = connection.createStatement();
		} catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	public Object[] consultToBD(String sql_query) {
		ArrayList<Object[]> info = new ArrayList<Object[]>();
		try {
			ResultSet resultSet;
			resultSet = statement.executeQuery(sql_query);

			String[] columnNames = new String[resultSet.getMetaData().getColumnCount()];
			for (int i = 0; i < columnNames.length; i++) {
				columnNames[i] = resultSet.getMetaData().getColumnName(i + 1);
			}

			while (resultSet.next()) {
				Object[] datos = new Object[resultSet.getMetaData().getColumnCount()];
				for (int i = 1; i <= resultSet.getMetaData().getColumnCount(); i++) {
					datos[i-1] = resultSet.getObject(i);
				}
				info.add(datos);
			}

			return new Object[] { info, columnNames };
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

}
