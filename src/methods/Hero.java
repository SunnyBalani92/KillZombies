package methods;

public class Hero {
	
	public int hero_x,hero_y;
	public int Health;
	public int whichWeaponIsSelected;
	public int whichSideHeroFacing;
	public int numberOfKnifeFrames;
	public int numberOfHandgunFrames;
	public int numberOfShotgunFrames;
	public int numberOfLauncherFrames;
	public int numberOfMinesFrames;
	
	boolean animationStart;

	public Hero(int hero_x, int hero_y, int health, int whichWeaponIsSelected,
			int whichSideHeroFacing, int numberOfKnifeFrames,
			int numberOfHandgunFrames, int numberOfShotgunFrames,
			int numberOfLauncherFrames, int numberOfMinesFrames,
			boolean animationStart) {
		super();
		this.hero_x = hero_x;
		this.hero_y = hero_y;
		Health = health;
		this.whichWeaponIsSelected = whichWeaponIsSelected;
		this.whichSideHeroFacing = whichSideHeroFacing;
		this.numberOfKnifeFrames = numberOfKnifeFrames;
		this.numberOfHandgunFrames = numberOfHandgunFrames;
		this.numberOfShotgunFrames = numberOfShotgunFrames;
		this.numberOfLauncherFrames = numberOfLauncherFrames;
		this.numberOfMinesFrames = numberOfMinesFrames;
		this.animationStart = animationStart;
	}

	public int getHero_x() {
		return hero_x;
	}

	public void setHero_x(int hero_x) {
		this.hero_x = hero_x;
	}

	public int getHero_y() {
		return hero_y;
	}

	public void setHero_y(int hero_y) {
		this.hero_y = hero_y;
	}

	public int getHealth() {
		return Health;
	}

	public void setHealth(int health) {
		Health = health;
	}

	public int getWhichWeaponIsSelected() {
		return whichWeaponIsSelected;
	}

	public void setWhichWeaponIsSelected(int whichWeaponIsSelected) {
		this.whichWeaponIsSelected = whichWeaponIsSelected;
	}

	public int getWhichSideHeroFacing() {
		return whichSideHeroFacing;
	}

	public void setWhichSideHeroFacing(int whichSideHeroFacing) {
		this.whichSideHeroFacing = whichSideHeroFacing;
	}

	public int getNumberOfKnifeFrames() {
		return numberOfKnifeFrames;
	}

	public void setNumberOfKnifeFrames(int numberOfKnifeFrames) {
		this.numberOfKnifeFrames = numberOfKnifeFrames;
	}

	public int getNumberOfHandgunFrames() {
		return numberOfHandgunFrames;
	}

	public void setNumberOfHandgunFrames(int numberOfHandgunFrames) {
		this.numberOfHandgunFrames = numberOfHandgunFrames;
	}

	public int getNumberOfShotgunFrames() {
		return numberOfShotgunFrames;
	}

	public void setNumberOfShotgunFrames(int numberOfShotgunFrames) {
		this.numberOfShotgunFrames = numberOfShotgunFrames;
	}

	public int getNumberOfLauncherFrames() {
		return numberOfLauncherFrames;
	}

	public void setNumberOfLauncherFrames(int numberOfLauncherFrames) {
		this.numberOfLauncherFrames = numberOfLauncherFrames;
	}

	public int getNumberOfMinesFrames() {
		return numberOfMinesFrames;
	}

	public void setNumberOfMinesFrames(int numberOfMinesFrames) {
		this.numberOfMinesFrames = numberOfMinesFrames;
	}

	public boolean isAnimationStart() {
		return animationStart;
	}

	public void setAnimationStart(boolean animationStart) {
		this.animationStart = animationStart;
	}
	
	
	
	
	
}
