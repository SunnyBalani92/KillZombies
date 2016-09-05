package methods;

import android.media.MediaPlayer;

public class Mines {
	public int x,y;
	public long mine_time_of_plant;
	 public int mine_blast_frame_counter;
	 public MediaPlayer minesblastsound=null;
	 public boolean ismineblastsoundplaying=true;
	public Mines(int x, int y, long mine_time_of_plant,
			MediaPlayer minesblastsound) {
		super();
		this.x = x;
		this.y = y;
		this.mine_time_of_plant = mine_time_of_plant;
		mine_blast_frame_counter=0;
		this.minesblastsound = minesblastsound;
		this.minesblastsound.setLooping(false);
		this.ismineblastsoundplaying=true;
	}
	public int getX() {
		return x;
	}
	public void setX(int x) {
		this.x = x;
	}
	public int getY() {
		return y;
	}
	public void setY(int y) {
		this.y = y;
	}
	public long getMine_time_of_plant() {
		return mine_time_of_plant;
	}
	public void setMine_time_of_plant(long mine_time_of_plant) {
		this.mine_time_of_plant = mine_time_of_plant;
	}
	
}
