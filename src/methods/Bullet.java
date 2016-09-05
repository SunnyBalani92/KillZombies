package methods;

import constants.Constant;
import android.media.MediaPlayer;

public class Bullet {
	
	public double x,y;
	public double bullet_X,bullet_Y;
	public double roughRange;
	public double velocity=50;
	
	public static final double gravity_Math=9.810000000000001D;
	public static double time_Interval_Math=0.75000000000000001D;
	public static int angle=45;
	public double timeMath;
	public int pointX,pointY;
	public int blastFrameCounter;
	public MediaPlayer launcherBlastSound;
	public boolean isLauncherSoundPlaying;
	
	public Bullet(int pointX, int pointY,double x, double y, double roughRange, 
			 MediaPlayer launcherBlastSound) {
		super();
		this.bullet_X= x;
		this.bullet_Y = y;
		this.roughRange = roughRange/2;
		Constant.heroBaseHeight=(Constant.herolauncherRight.getHeight()/2);
		this.pointX = pointX;
		this.pointY = pointY;
		this.launcherBlastSound = launcherBlastSound;
		this.launcherBlastSound.setLooping(false);
		isLauncherSoundPlaying=true;
		blastFrameCounter=0;
		this.calculateVelocity();
	}

	private void calculateVelocity() {
		// TODO Auto-generated method stub
		this.velocity = Math.sqrt((this.roughRange *this.roughRange * this.gravity_Math)
				/ ((this.roughRange * Math.sin(2 * angle)) + (2
						* Constant.heroBaseHeight * Math.cos(angle) * Math
							.cos(angle))));
		
	}
	
	public void moveBulletRight(){
		this.timeMath+=time_Interval_Math;
		this.x=+(int) ((this.velocity)*this.timeMath*Math.cos(angle));
		x=x+bullet_X;
		
		this.y=-(int) ((this.velocity)*this.timeMath*Math.sin(this.angle)-2.505D*this.timeMath*this.timeMath);
		y=y+bullet_Y;
	}

	public void moveBulletLeft(){
		this.timeMath+=time_Interval_Math;
		this.x=-(int) ((this.velocity)*this.timeMath*Math.cos(angle));
		x=x+bullet_X;
		
		this.y=-(int) ((this.velocity)*this.timeMath*Math.sin(this.angle)-2.505D*this.timeMath*this.timeMath);
		y=y+bullet_Y;
	}

	public double getX() {
		return x;
	}

	public void setX(double x) {
		this.x = x;
	}

	public double getY() {
		return y;
	}

	public void setY(double y) {
		this.y = y;
	}

	public double getBullet_X() {
		return bullet_X;
	}

	public void setBullet_X(double bullet_X) {
		this.bullet_X = bullet_X;
	}

	public double getBullet_Y() {
		return bullet_Y;
	}

	public void setBullet_Y(double bullet_Y) {
		this.bullet_Y = bullet_Y;
	}

	public double getRoughRange() {
		return roughRange;
	}

	public void setRoughRange(double roughRange) {
		this.roughRange = roughRange;
	}

	public double getVelocity() {
		return velocity;
	}

	public void setVelocity(double velocity) {
		this.velocity = velocity;
	}
	
}
