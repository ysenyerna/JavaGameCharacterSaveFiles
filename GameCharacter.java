public class GameCharacter {

	String characterName;
	String characterClass;
	int level;
	int health;
	int attackPower;
	int gold;

	public GameCharacter(String characterName, String characterClass, int level, int health, int attackPower, int gold) {
		this.characterName = characterName;
		this.characterClass = characterClass;
		this.level = level;
		this.health = health;
		this.attackPower = attackPower;
		this.gold = gold;
	}

	public String toString() {
		return characterName + " | " + characterClass + " | Level " + level +
		" | Health: " + health + " | Attack: " + attackPower + " | Gold: " + gold;
	}

	public String getCharacterName() {
		return characterName;
	}

	public String getCharacterClass() {
		return characterClass;
	}

	public int getLevel() {
		return level;
	}

	public int getHealth() {
		return health;
	}

	public int getAttackPower() {
		return attackPower;
	}

	public int getGold() {
		return gold;
	}

}
