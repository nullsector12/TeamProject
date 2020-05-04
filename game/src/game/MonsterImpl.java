package game;

public interface MonsterImpl {

	public void Monster(int level);//주어진 레벨에 따라서 헬스와 데미지 설정

	public void damage(int damage) ;
	public void updateHealth() ;//최대 헬스를 설정하고 몬스터의 헬스를 풀로 회복함
	public boolean isDead() ;
	public void updateDamage();//레벨에 따라 최소/최대 데미지 값 설정

	public void attack(int damage, Player target) ;//공격을 가할 데미지와 타켓 플레이어를 설정해 공격
  
	public int getDefense() ;
  
	public void setDefense(int d) ;
	public String toString();

	public int getMaxDamage() ;

	public int getMinDamage();
}