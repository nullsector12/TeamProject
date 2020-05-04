//All living things in the game (The Player, NPCs, and monsters) inherit this class
//모든 살아있는 객체들이 상속하는 클래스
//하위 클래스들이 공통적으로 갖는 기본값들 초기화
package game;

public class Entity {
    private String name;
    private int baseHealth, currentHealth, maxHealth;//기본, 현재, 최대 체력
    private int baseMana, currentMana, maxMana;//기본, 현재, 최대 마나
    private int baseStrength, currentStrength;//기본, 현재 힘
    private int baseMagic, currentMagic;//기본, 현재 마력
    private int baseAgility, currentAgility;//기본, 현재 민첩성
    private int baseDefense, currentDefense;//기본, 현재 방어력
    private int baseMagicDefense, currentMagicDefense;//기본, 현재 마법 방어력
    
    public String getName(){return name;}//이름 반환
    public void setName(String input){name = input;}
    
    public int getCurrentHealth() {//현재 체력 반환
        if (currentHealth < 0) {
            return 0;
        }
        return currentHealth;
    }
    public void setCurrentHealth(int input){currentHealth = input;} 
    public int getBaseHealth(){return baseHealth;}
    public void setBaseHealth(int input){baseHealth = input;}
    public int getMaxHealth(){return maxHealth;}
    public void setMaxHealth(int input){maxHealth = input;}
    
    public int getCurrentMana() {
        if (currentMana < 0) {
            return 0;
        }
        return currentMana;
    }
    public void setCurrentMana(int input){currentMana = input;}
    public int getBaseMana(){return baseMana;}
    public void setBaseMana(int input){baseMana = input;}
    public int getMaxMana(){return maxMana;}
    public void setMaxMana(int input){maxMana = input;}
    
    public int getCurrentStrength() {
        if (currentStrength < 0) {
            return 0;
        }
        return currentStrength;
    }
    public void setCurrentStrength(int input){currentStrength = input;}
    public int getBaseStrength(){return baseStrength;}
    public void setBaseStrength(int input){baseStrength = input;}
    
    public int getCurrentMagic() {
        if (currentMagic < 0) {
            return 0;
        }
        return currentMagic;
    }
    public void setCurrentMagic(int input){currentMagic = input;}
    public int getBaseMagic(){return baseMagic;}
    public void setBaseMagic(int input){baseMagic = input;}
    
    public int getCurrentAgility() {
        if (currentAgility < 0) {
            return 0;
        }
        return currentAgility;
    }
    public void setCurrentAgility(int input){currentAgility = input;}
    public int getBaseAgility(){return baseAgility;}
    public void setBaseAgility(int input){baseAgility = input;}
    
    public int getCurrentDefense() {
        if (currentDefense < 0) {
            return 0;
        }
        return currentDefense;
    }
    public void setCurrentDefense(int input){currentDefense = input;}
    public int getBaseDefense(){return baseDefense;}
    public void setBaseDefense(int input){baseDefense = input;}
    
    public int getCurrentMagicDefense() {
        if (currentMagicDefense < 0) {
            return 0;
        }
        return currentMagicDefense;
    }
    public void setCurrentMagicDefense(int input){currentMagicDefense = input;}
    public int getBaseMagicDefense(){return baseMagicDefense;}
    public void setBaseMagicDefense(int input){baseMagicDefense = input;}
    
    public void initCurrentStats(){//현재 스탯 초기화
        currentHealth = baseHealth;
        currentMana = baseMana;
        currentStrength = baseStrength;
        currentMagic = baseMagic;
        currentAgility = baseAgility;
        currentDefense = baseDefense;
        currentMagicDefense = baseMagicDefense;
    }
}