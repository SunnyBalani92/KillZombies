package methods;

public class Enemy {

	public int enemy_Type,enemy_X,enemy_Y,enemy_Width,enemy_Height,enemy_Health,
	   no_Of_Walk_Frame,no_Of_Attack_Frame,no_Of_Dead_Frame,enemy_State;
	public long generation_Lag;
	public int enemy_Speed;
	public int enemy_Frame_Counter_Walk;
	public int enemy_Frame_Counter_Attack;
	public int enemy_Frame_Counter_Dead;
	public long attack_Lag;
	public int enemy_Attack;
	public Enemy(int enemy_Type, int enemy_X, int enemy_Y, int enemy_Width,
			int enemy_Height, int enemy_Health, int no_Of_Walk_Frame,
			int no_Of_Attack_Frame, int no_Of_Dead_Frame, int enemy_State,
			long generation_Lag, int enemy_Speed, int enemy_Frame_Counter_Walk,
			int enemy_Frame_Counter_Attack, int enemy_Frame_Counter_Dead,
			long attack_Lag, int enemy_Attack) {
		super();
		this.enemy_Type = enemy_Type;
		this.enemy_X = enemy_X;
		this.enemy_Y = enemy_Y;
		this.enemy_Width = enemy_Width;
		this.enemy_Height = enemy_Height;
		this.enemy_Health = enemy_Health;
		this.no_Of_Walk_Frame = no_Of_Walk_Frame;
		this.no_Of_Attack_Frame = no_Of_Attack_Frame;
		this.no_Of_Dead_Frame = no_Of_Dead_Frame;
		this.enemy_State = enemy_State;
		this.generation_Lag = generation_Lag;
		this.enemy_Speed = enemy_Speed;
		this.enemy_Frame_Counter_Walk = enemy_Frame_Counter_Walk;
		this.enemy_Frame_Counter_Attack = enemy_Frame_Counter_Attack;
		this.enemy_Frame_Counter_Dead = enemy_Frame_Counter_Dead;
		this.attack_Lag = attack_Lag;
		this.enemy_Attack = enemy_Attack;
	}
	public int getEnemy_Type() {
		return enemy_Type;
	}
	public void setEnemy_Type(int enemy_Type) {
		this.enemy_Type = enemy_Type;
	}
	public int getEnemy_X() {
		return enemy_X;
	}
	public void setEnemy_X(int enemy_X) {
		this.enemy_X = enemy_X;
	}
	public int getEnemy_Y() {
		return enemy_Y;
	}
	public void setEnemy_Y(int enemy_Y) {
		this.enemy_Y = enemy_Y;
	}
	public int getEnemy_Width() {
		return enemy_Width;
	}
	public void setEnemy_Width(int enemy_Width) {
		this.enemy_Width = enemy_Width;
	}
	public int getEnemy_Height() {
		return enemy_Height;
	}
	public void setEnemy_Height(int enemy_Height) {
		this.enemy_Height = enemy_Height;
	}
	public int getEnemy_Health() {
		return enemy_Health;
	}
	public void setEnemy_Health(int enemy_Health) {
		this.enemy_Health = enemy_Health;
	}
	public int getNo_Of_Walk_Frame() {
		return no_Of_Walk_Frame;
	}
	public void setNo_Of_Walk_Frame(int no_Of_Walk_Frame) {
		this.no_Of_Walk_Frame = no_Of_Walk_Frame;
	}
	public int getNo_Of_Attack_Frame() {
		return no_Of_Attack_Frame;
	}
	public void setNo_Of_Attack_Frame(int no_Of_Attack_Frame) {
		this.no_Of_Attack_Frame = no_Of_Attack_Frame;
	}
	public int getNo_Of_Dead_Frame() {
		return no_Of_Dead_Frame;
	}
	public void setNo_Of_Dead_Frame(int no_Of_Dead_Frame) {
		this.no_Of_Dead_Frame = no_Of_Dead_Frame;
	}
	public int getEnemy_State() {
		return enemy_State;
	}
	public void setEnemy_State(int enemy_State) {
		this.enemy_State = enemy_State;
	}
	public long getGeneration_Lag() {
		return generation_Lag;
	}
	public void setGeneration_Lag(long generation_Lag) {
		this.generation_Lag = generation_Lag;
	}
	public int getEnemy_Speed() {
		return enemy_Speed;
	}
	public void setEnemy_Speed(int enemy_Speed) {
		this.enemy_Speed = enemy_Speed;
	}
	public int getEnemy_Frame_Counter_Walk() {
		return enemy_Frame_Counter_Walk;
	}
	public void setEnemy_Frame_Counter_Walk(int enemy_Frame_Counter_Walk) {
		this.enemy_Frame_Counter_Walk = enemy_Frame_Counter_Walk;
	}
	public int getEnemy_Frame_Counter_Attack() {
		return enemy_Frame_Counter_Attack;
	}
	public void setEnemy_Frame_Counter_Attack(int enemy_Frame_Counter_Attack) {
		this.enemy_Frame_Counter_Attack = enemy_Frame_Counter_Attack;
	}
	public int getEnemy_Frame_Counter_Dead() {
		return enemy_Frame_Counter_Dead;
	}
	public void setEnemy_Frame_Counter_Dead(int enemy_Frame_Counter_Dead) {
		this.enemy_Frame_Counter_Dead = enemy_Frame_Counter_Dead;
	}
	public long getAttack_Lag() {
		return attack_Lag;
	}
	public void setAttack_Lag(long attack_Lag) {
		this.attack_Lag = attack_Lag;
	}
	public int getEnemy_Attack() {
		return enemy_Attack;
	}
	public void setEnemy_Attack(int enemy_attack) {
		this.enemy_Attack = enemy_attack;
	}
	
	
}
