import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;

public class Main {

	static final String jsonFile = "characters.json";
	static final String xmlFile = "characters.xml";

	public static void main(String[] args) {
		System.out.println("Video Game Character Save Files");
		System.out.println("-------------------------------\n");

		// Create characters
		GameCharacter c1 = new GameCharacter("Brutus", "Warrior", 5, 120, 18, 250);
		GameCharacter c2 = new GameCharacter("Elara", "Mage", 7, 80, 25, 400);
		GameCharacter c3 = new GameCharacter("Rowan", "Archer", 4, 95, 16, 175);
		// Add the characters to list
		ArrayList<GameCharacter> characters = new ArrayList<GameCharacter>();
		characters.add(c1);
		characters.add(c2);
		characters.add(c3);

		// Print characters
		System.out.println("Characters created: ");
		for (int i = 0; i < characters.size(); i++) {
			System.out.println(characters.get(i).toString());
		}

		// Write characters to files
		System.out.println("\nSaving character data: ");

		// Build JSON
		StringBuilder json = new StringBuilder("[\n");
		for (int i = 0; i < characters.size(); i++) {
			GameCharacter character = characters.get(i);
			json.append("  {\n");
			json.append("    \"name\": \"" + character.getCharacterName() + "\",\n");
			json.append("    \"characterClass\": \"" + character.getCharacterClass() + "\",\n");
			json.append("    \"level\": " + character.getLevel() + ",\n");
			json.append("    \"health\": " + character.getHealth() + ",\n");
			json.append("    \"attackPower\": " + character.getAttackPower() + ",\n");
			json.append("    \"gold\": " + character.getGold() + "\n");
			json.append(i == characters.size() - 1 ? "  }\n" : "  },\n");
		}
		json.append("]");

		// Write JSON to file
		try {
			Files.writeString(Path.of(jsonFile), json.toString());
			System.out.println("characters.json created successfully.");
		}
		catch (IOException e) {
			System.err.println("Error writing to JSON file: " + e.getMessage());
		}

		// Build XML
		StringBuilder xml = new StringBuilder("<characters>\n");
		for (int i = 0; i < characters.size(); i++) {
			GameCharacter character = characters.get(i);
			xml.append("  <character>\n");
			xml.append("    <name>" + character.getCharacterName() + "</name>\n");
			xml.append("    <class>" + character.getCharacterClass() + "</class>\n");
			xml.append("    <level>" + character.getLevel() + "</level>\n");
			xml.append("    <health>" + character.getHealth() + "</health>\n");
			xml.append("    <attackPower>" + character.getAttackPower() + "</attackPower>\n");
			xml.append("    <gold>" + character.getGold() + "</gold>\n");
			xml.append("  </character>\n");
		}
		xml.append("</characters>");

		// Write XML to file
		try {
			Files.writeString(Path.of(xmlFile), xml.toString());
			System.out.println("characters.xml created successfully.");
		}
		catch (IOException e) {
			System.err.println("Error writing to XML file: " + e.getMessage());
		}


		// Read and display the data from the JSON file
		System.out.println("\nReading JSON file: ");
		try {
			String jsonContent = Files.readString(Path.of(jsonFile));
			System.out.println(jsonContent);
		}
		catch (IOException e) {
			System.err.println("Error reading JSON file: " + e.getMessage());
		}

		// Read and display the data from the XML file
		System.out.println("\nReading XML file: ");
		try {
			String xmlContent = Files.readString(Path.of(xmlFile));
			System.out.println(xmlContent);
		}
		catch (IOException e) {
			System.err.println("Error reading XML file: " + e.getMessage());
		}

	}

}
