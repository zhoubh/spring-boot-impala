package com.creativearts.bigdata;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
 public class SpringBootImpalaApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootImpalaApplication.class, args);
	}

	/*public CommandLineRunner commandLineRunner(final DataSource abstractDataSource) {
		return new CommandLineRunner() {
			@Override
			public void run(String... strings) throws Exception {
				Connection connection = abstractDataSource.getConnection();
				PreparedStatement statement = connection.prepareStatement("INSERT INTO default.WebLogs VALUES (?,?,?,?,?,?,?)");
				statement.setFetchSize(5);
				statement.setString(1,"NA");
				statement.setString(2,"ZHOU.COM");
				statement.setTimestamp(3, TimestampTz.valueOf(LocalDateTime.now()));
				statement.setString(4,"testFeature");
				statement.setInt(5, 2);
				statement.setInt(6, 6);
				statement.setInt(7, 7);
				statement.execute();
				statement.close();
				connection.close();
				connection = abstractDataSource.getConnection();
				Statement statement1 = connection.createStatement();
				ResultSet resultSet = statement1.executeQuery("SELECT * FROM default.WebLogs");
				long currentTimeMillis = System.currentTimeMillis();
				while (resultSet.next()){
					System.out.println(resultSet.getInt(1));
					System.out.println(resultSet.getString(2));
				}
				long currentTimeMillis1 = System.currentTimeMillis();
				System.out.println("Total time taken: "+(currentTimeMillis1-currentTimeMillis));
				System.out.println("Done");
				connection.commit();
				statement1.close();
				connection.close();
			}
		};
	}
*/

}
