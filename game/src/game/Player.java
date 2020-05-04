//Need to make quests and have objects associated in here n such ya know

package game;

import java.util.ArrayList;
import java.util.List;

public class Player extends Entity {

	public Player() {
		super.setName("플레이어");
		super.setBaseHealth(2000);
		super.setBaseStrength(5);
		super.setBaseAgility(3);

		super.initCurrentStats();
	}

	@Override
	public String toString() {
		return "Player [getName()=" + getName() + ", getCurrentHealth()=" + getCurrentHealth() + ", getBaseHealth()="
				+ getBaseHealth() + ", getMaxHealth()=" + getMaxHealth() + ", getCurrentMana()=" + getCurrentMana()
				+ ", getBaseMana()=" + getBaseMana() + ", getMaxMana()=" + getMaxMana() + ", getCurrentStrength()="
				+ getCurrentStrength() + ", getBaseStrength()=" + getBaseStrength() + ", getCurrentMagic()="
				+ getCurrentMagic() + ", getBaseMagic()=" + getBaseMagic() + ", getCurrentAgility()="
				+ getCurrentAgility() + ", getBaseAgility()=" + getBaseAgility() + ", getCurrentDefense()="
				+ getCurrentDefense() + ", getBaseDefense()=" + getBaseDefense() + ", getCurrentMagicDefense()="
				+ getCurrentMagicDefense() + ", getBaseMagicDefense()=" + getBaseMagicDefense() + ", getClass()="
				+ getClass() + ", hashCode()=" + hashCode() + ", toString()=" + super.toString() + "]";
	}

	public void damage(int damage) {
	}

}
