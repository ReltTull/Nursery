package connectionMySQL;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import Animals.Cat;
import Animals.Dog;
import Animals.Horse;

public class Main {
	


	public static void main(String[] args) throws IOException, SQLException {

		Cat jones = new Cat("Jones", 3, new ArrayList<String>());
		jones.newSkill("Seat");
//		Connector.insertNewAnimal(jones);
		Connector.updateSkillInfo(jones);

	}

}
