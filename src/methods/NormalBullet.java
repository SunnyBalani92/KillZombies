package methods;

import android.media.MediaPlayer;

public class NormalBullet {
	
	public int bullet_X,bullet_Y;
	public boolean isBulletSoundPlaying=false;
	public MediaPlayer bulletSound=null;
	public NormalBullet(int bullet_X, int bullet_Y, MediaPlayer bulletSound) {
		super();
		this.bullet_X = bullet_X;
		this.bullet_Y = bullet_Y;
		this.bulletSound = bulletSound;
	}
	
	public int getBullet_X() {
		return bullet_X;
	}
	public void setBullet_X(int bullet_X) {
		this.bullet_X = bullet_X;
	}
	public int getBullet_Y() {
		return bullet_Y;
	}
	public void setBullet_Y(int bullet_Y) {
		this.bullet_Y = bullet_Y;
	}
	
	

}
