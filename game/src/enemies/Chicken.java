package enemies;
import game.BasicInfo;
//1-2
import game.Monster;

//import items.*;

public class Chicken extends Monster {//should be resistant to physical attacks!

    public Chicken() {
//    	super.setEvasion(evasion);

        super.setName("닭");
        super.setBaseHealth(200);
//        super.setBaseMana(10);
        super.setBaseStrength(5);
//        super.setBaseMagic(2);
        super.setBaseAgility(3);
//        super.setBaseDefense(6);
//        super.setBaseMagicDefense(2);
        
        super.setGoldWorth(30);
        super.setExpWorth(25);
        super.setWeakness(1); //See Monster class for list of types
        super.setEscapable(true);
        
//        Item slimeE = new SlimeExtract();
//        super.getLoot().add(slimeE);
        
//        int[] chance = {80};//needs to map to same index
//        super.setLootChance(chance);
        
//        super.setRandomLoot();
        
        super.initCurrentStats();
    }
    public void showData() {
    	super.showData();
    	System.out.println("닭 선택");
    }
	@Override
	public String toString() {
		return "Chicken [getEvasion()=" + getEvasion() + ", getGoldWorth()=" + getGoldWorth() + ", getExpWorth()="
				+ getExpWorth() + ", getWeakness()=" + getWeakness() + ", isEscapable()=" + isEscapable()
				+ ", toString()=" + super.toString() + ", getName()=" + getName() + ", getCurrentHealth()="
				+ getCurrentHealth() + ", getBaseHealth()=" + getBaseHealth() + ", getMaxHealth()=" + getMaxHealth()
				+ ", getCurrentMana()=" + getCurrentMana() + ", getBaseMana()=" + getBaseMana() + ", getMaxMana()="
				+ getMaxMana() + ", getCurrentStrength()=" + getCurrentStrength() + ", getBaseStrength()="
				+ getBaseStrength() + ", getCurrentMagic()=" + getCurrentMagic() + ", getBaseMagic()=" + getBaseMagic()
				+ ", getCurrentAgility()=" + getCurrentAgility() + ", getBaseAgility()=" + getBaseAgility()
				+ ", getCurrentDefense()=" + getCurrentDefense() + ", getBaseDefense()=" + getBaseDefense()
				+ ", getCurrentMagicDefense()=" + getCurrentMagicDefense() + ", getBaseMagicDefense()="
				+ getBaseMagicDefense() + ", getClass()=" + getClass() + ", hashCode()=" + hashCode() + "]";
	}
    
    
    /*public int slash() {
        return (int)(super.getBaseStrength() * 0.5) + 10;
    }*/
}