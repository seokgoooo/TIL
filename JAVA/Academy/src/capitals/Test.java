package capitals;

import java.sql.SQLException;

public class Test {
	private Manager mg;

	public Test(Manager mg) {
		super();
		this.mg = mg;
	}

	public static void main(String[] args) {
		Manager mg = new Manager();
		try {
			System.out.println(mg.read(1000));
			System.out.println(mg.read());
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
