package view;

import java.util.Vector;

import com.mobrna.sampleview.R;

import methods.AndroidGraphics;
import methods.Bullet;
import methods.Enemy;
import methods.Hero;
import methods.Mines;
import methods.NormalBullet;
import methods.ParticleGenerator;
import android.content.Context;
import android.graphics.Color;
import android.graphics.Point;
import android.graphics.Rect;
import android.media.MediaPlayer;
import android.media.MediaPlayer.OnCompletionListener;
import android.view.MotionEvent;
import android.view.SurfaceView;
import constants.Constant;
import constants.LevelLoader;

public class GameView extends SurfaceView implements Runnable {

	private int heroFrameCounter = 0;

	public GameView(Context context) {
		super(context);
		// TODO Auto-generated constructor stub
		Constant.context = context;
		Constant.surfaceholder = getHolder();
		Constant.graphics = new AndroidGraphics(null);
		Constant.hero = new Hero(Constant.getWidthPercentage(50),
				Constant.getHeightPercentage(40),
				Constant.getWidthPercentage(26), Constant.handgun_selected,
				Constant.leftSideHeroFacing, 2, 2, 2, 2, 1, false);

		Constant.rightKnifeRectangleX = Constant.getWidthPercentage(62);
		Constant.rightKnifeRectangleY = Constant.getHeightPercentage(50);
		Constant.rightKnifeRectangleWidth = Constant.getWidthPercentage(25);
		Constant.rightknifeRectangleHeight = Constant.getHeightPercentage(50);

		Constant.leftKnifeRectangleX = Constant.getWidthPercentage(20);
		Constant.leftKnifeRectangleY = Constant.getHeightPercentage(50);
		Constant.leftKnifeRectangleWidth = Constant.getWidthPercentage(25);
		Constant.leftKnifeRectangleHeight = Constant.getHeightPercentage(50);

		loadBitMap();
		MenuButtonXY();
		GamePlayButtonXY();
		PauseButtonXY();
		ShopButtonXY();
		WinStateButtonXY();
		LoseStatebuttonXY();

		Constant.veryStartTime = System.currentTimeMillis();
	}

	private void LoseStatebuttonXY() {
		// TODO Auto-generated method stub
		Constant.loseStateHomeBtn_X = Constant.getWidthPercentage(50);
		Constant.loseStateHomeBtn_Y = Constant.getHeightPercentage(100)
				- Constant.homebtn.getHeight();
		Constant.loseStateReplayBtn_X = Constant.getWidthPercentage(10);
		Constant.loseStateReplayBtn_Y = Constant.getHeightPercentage(100)
				- Constant.replaybtn.getHeight();

		Constant.Lose_State_BUTTON_ARRAY = new int[][] {
				{ Constant.loseStateHomeBtn_X, Constant.loseStateHomeBtn_Y,
						Constant.homebtn.getWidth(),
						Constant.homebtn.getHeight() },
				{ Constant.loseStateReplayBtn_X, Constant.loseStateReplayBtn_Y,
						Constant.replaybtn.getWidth(),
						Constant.replaybtn.getHeight() }

		};

	}

	private void WinStateButtonXY() {
		// TODO Auto-generated method stub
		Constant.winStateHomeBtn_X = Constant.getWidthPercentage(50);
		Constant.winStateHomeBtn_Y = Constant.getHeightPercentage(100)
				- Constant.homebtn.getHeight();
		Constant.winStateReplayBtn_X = Constant.getWidthPercentage(10);
		Constant.winStateReplayBtn_Y = Constant.getHeightPercentage(100)
				- Constant.replaybtn.getHeight();

		Constant.Win_State_BUTTON_ARRAY = new int[][] {
				{ Constant.winStateHomeBtn_X, Constant.winStateHomeBtn_Y,
						Constant.homebtn.getWidth(),
						Constant.homebtn.getHeight() },
				{ Constant.winStateReplayBtn_X, Constant.winStateReplayBtn_Y,
						Constant.replaybtn.getWidth(),
						Constant.replaybtn.getHeight() }

		};

	}

	private void ShopButtonXY() {
		// TODO Auto-generated method stub
		Constant.shopTotalStripX = Constant.getWidthPercentage(0);
		Constant.shopTotalStripY = Constant.getHeightPercentage(10);

		Constant.shopBuyButtonX = Constant.getWidthPercentage(58);
		Constant.shopBuyButtonY = Constant.getHeightPercentage(85);

		Constant.shopBackButtonX = Constant.getWidthPercentage(83);
		Constant.shopBackButtonY = Constant.getHeightPercentage(85);

		Constant.shopHealthIconX = Constant.getWidthPercentage(3);
		Constant.shopHealthIconY = Constant.getHeightPercentage(32);

		Constant.shopLauncherIconX = Constant.getWidthPercentage(27);
		Constant.shopLauncherIconY = Constant.getHeightPercentage(72);

		Constant.shopShotGunIconX = Constant.getWidthPercentage(28);
		Constant.shopShotGunIconY = Constant.getHeightPercentage(35);

		Constant.shopBombIconX = Constant.getWidthPercentage(0);
		Constant.shopBombIconY = Constant.getHeightPercentage(72);

		Constant.SHOP_BUTTON_ARRAY = new int[][] {
				{ Constant.shopHealthIconX, Constant.shopHealthIconY,
						Constant.shopHealthIcon.getWidth(),
						Constant.shopHealthIcon.getHeight() },
				{ Constant.shopShotGunIconX, Constant.shopShotGunIconY,
						Constant.shopShotGunIcon.getWidth(),
						Constant.shopShotGunIcon.getHeight() },
				{ Constant.shopBombIconX, Constant.shopBombIconY,
						Constant.shopBombIcon.getWidth(),
						Constant.shopBombIcon.getHeight() },
				{ Constant.shopLauncherIconX, Constant.shopLauncherIconY,
						Constant.shopLauncherIcon.getWidth(),
						Constant.shopLauncherIcon.getHeight() },
				{ Constant.shopBuyButtonX, Constant.shopBuyButtonY,
						Constant.shopBuyButton.getWidth(),
						Constant.shopBuyButton.getHeight() },
				{ Constant.shopBackButtonX, Constant.shopBackButtonY,
						Constant.shopBackButton.getWidth(),
						Constant.shopBackButton.getHeight() } };
	}

	private void PauseButtonXY() {
		// TODO Auto-generated method stub
		Constant.resumeButtonX = Constant.getWidthPercentage(35);
		Constant.resumeButtonY = Constant.getHeightPercentage(17);

		Constant.shopButtonX = Constant.getWidthPercentage(35);
		Constant.shopButtonY = Constant.getHeightPercentage(34);

		Constant.homeButtonX = Constant.getWidthPercentage(35);
		Constant.homeButtonY = Constant.getHeightPercentage(51);

		Constant.pauseExitButtonX = Constant.getWidthPercentage(35);
		Constant.pauseExitButtonY = Constant.getHeightPercentage(68);

		Constant.PAUSE_BUTTON_ARRAY = new int[][] {
				{ Constant.resumeButtonX, Constant.resumeButtonY,
						Constant.resumeButton.getWidth(),
						Constant.resumeButton.getHeight() },
				{ Constant.shopButtonX, Constant.shopButtonY,
						Constant.shopButton.getWidth(),
						Constant.shopButton.getHeight() },
				{ Constant.homeButtonX, Constant.homeButtonY,
						Constant.homeButton.getWidth(),
						Constant.homeButton.getHeight() },
				{ Constant.pauseExitButtonX, Constant.pauseExitButtonY,
						Constant.pauseExitButton.getWidth(),
						Constant.pauseExitButton.getHeight() }, };
	}

	private void GamePlayButtonXY() {
		// TODO Auto-generated method stub
		Constant.handGunIconX = Constant.getWidthPercentage(0);
		Constant.handGunIconY = Constant.getHeightPercentage(1);

		Constant.knifeIconX = Constant.getWidthPercentage(9);
		Constant.knifeIconY = Constant.getHeightPercentage(1);

		Constant.launcherIconX = Constant.getWidthPercentage(18);
		Constant.launcherIconY = Constant.getHeightPercentage(1);

		Constant.minesIconX = Constant.getWidthPercentage(27);
		Constant.minesIconY = Constant.getHeightPercentage(1);

		Constant.shotgunIconX = Constant.getWidthPercentage(36);
		Constant.shotgunIconY = Constant.getHeightPercentage(1);

		Constant.pauseButtonX = Constant.getWidthPercentage(90);
		Constant.pauseButtonY = Constant.getHeightPercentage(90);

		Constant.GAME_BUTTON_ARRAY = new int[][] {
				{ Constant.handGunIconX, Constant.handGunIconY,
						Constant.handGunIcon.getWidth(),
						Constant.handGunIcon.getHeight() },
				{ Constant.knifeIconX, Constant.knifeIconY,
						Constant.knifeIcon.getWidth(),
						Constant.knifeIcon.getHeight() },
				{ Constant.launcherIconX, Constant.launcherIconY,
						Constant.launcherIcon.getWidth(),
						Constant.launcherIcon.getHeight() },
				{ Constant.minesIconX, Constant.minesIconY,
						Constant.minesIcon.getWidth(),
						Constant.minesIcon.getHeight() },
				{ Constant.shotgunIconX, Constant.shotgunIconY,
						Constant.shotgunIcon.getWidth(),
						Constant.shotgunIcon.getHeight() },
				{ Constant.pauseButtonX, Constant.pauseButtonY,
						Constant.pauseButton.getWidth(),
						Constant.pauseButton.getHeight() }, };

		Constant.passport_size_photo_X = Constant.getWidthPercentage(100)
				- Constant.heroPassportSize.getWidth();
		Constant.passport_size_photo_Y = 0;
		Constant.health_bar_X = Constant.passport_size_photo_X
				- Constant.heroHealthBar.getWidth();
		Constant.health_bar_Y = 0;
		Constant.coin_bar_X = Constant.passport_size_photo_X
				- Constant.heroCoinBar.getWidth();
		Constant.coin_bar_Y = Constant.health_bar_Y
				+ Constant.heroHealthBar.getHeight();

	}

	private void levelLoader(int current_Level) {
		// TODO Auto-generated method stub
		Constant.enemyVectorLeft = new Vector<Enemy>();
		Constant.enemyVectorRight = new Vector<Enemy>();

		for (int i = 0; i < LevelLoader.enemiesWaveFromLeft[Constant.current_Level].length; i++) {
			switch (LevelLoader.enemiesWaveFromLeft[Constant.current_Level][i][Constant.enemy_Type_Index]) {
			case Constant.enemy_Type1_Left:
				Enemy enemy1 = new Enemy(
						LevelLoader.enemiesWaveFromLeft[Constant.current_Level][i][Constant.enemy_Type_Index],
						-(Constant.Enemy_Type_1_Left_Bitmap_Frame_Walk
								.getWidth() / Constant.Enemy_1_Walk_Frame_Count),
						Constant.getHeightPercentage(LevelLoader.enemiesWaveFromLeft[Constant.current_Level][i][Constant.enemy_Y_Pos_Index]),
						(Constant.Enemy_Type_1_Left_Bitmap_Frame_Walk
								.getWidth() / Constant.Enemy_1_Walk_Frame_Count),
						Constant.Enemy_Type_1_Left_Bitmap_Frame_Walk
								.getHeight(),
						LevelLoader.enemiesWaveFromLeft[Constant.current_Level][i][Constant.enemy_Health_Index],
						Constant.Enemy_1_Walk_Frame_Count,
						Constant.Enemy_1_Attack_Frame_Count,
						Constant.Enemy_1_Dead_Frame_Count,
						Constant.enemy_Walking_State,
						LevelLoader.enemiesWaveFromLeft[Constant.current_Level][i][Constant.enemy_Time_Lag_Index],
						LevelLoader.enemiesWaveFromLeft[Constant.current_Level][i][Constant.enemy_Speed_Index],
						0, 0, 0, 0, Constant.enemy1_Attack);
				Constant.enemyVectorLeft.add(enemy1);
				break;

			case Constant.enemy_Type2_Left:
				Enemy enemy2 = new Enemy(
						LevelLoader.enemiesWaveFromLeft[Constant.current_Level][i][Constant.enemy_Type_Index],
						-(Constant.Enemy_Type_2_Left_Bitmap_Frame_Walk
								.getWidth() / Constant.Enemy_2_Walk_Frame_Count),
						Constant.getHeightPercentage(LevelLoader.enemiesWaveFromLeft[Constant.current_Level][i][Constant.enemy_Y_Pos_Index]),
						(Constant.Enemy_Type_2_Left_Bitmap_Frame_Walk
								.getWidth() / Constant.Enemy_2_Walk_Frame_Count),
						Constant.Enemy_Type_2_Left_Bitmap_Frame_Walk
								.getHeight(),
						LevelLoader.enemiesWaveFromLeft[Constant.current_Level][i][Constant.enemy_Health_Index],
						Constant.Enemy_2_Walk_Frame_Count,
						Constant.Enemy_2_Attack_Frame_Count,
						Constant.Enemy_2_Dead_Frame_Count,
						Constant.enemy_Walking_State,
						LevelLoader.enemiesWaveFromLeft[Constant.current_Level][i][Constant.enemy_Time_Lag_Index],
						LevelLoader.enemiesWaveFromLeft[Constant.current_Level][i][Constant.enemy_Speed_Index],
						0, 0, 0, 0, Constant.enemy2_Attack);
				Constant.enemyVectorLeft.add(enemy2);
				break;

			case Constant.enemy_Type3_Left:
				Enemy enemy3 = new Enemy(
						LevelLoader.enemiesWaveFromLeft[Constant.current_Level][i][Constant.enemy_Type_Index],
						-(Constant.Enemy_Type_3_Left_Bitmap_Frame_Walk
								.getWidth() / Constant.Enemy_3_Walk_Frame_Count),
						Constant.getHeightPercentage(LevelLoader.enemiesWaveFromLeft[Constant.current_Level][i][Constant.enemy_Y_Pos_Index]),
						(Constant.Enemy_Type_3_Left_Bitmap_Frame_Walk
								.getWidth() / Constant.Enemy_3_Walk_Frame_Count),
						Constant.Enemy_Type_3_Left_Bitmap_Frame_Walk
								.getHeight(),
						LevelLoader.enemiesWaveFromLeft[Constant.current_Level][i][Constant.enemy_Health_Index],
						Constant.Enemy_3_Walk_Frame_Count,
						Constant.Enemy_3_Attack_Frame_Count,
						Constant.Enemy_3_Dead_Frame_Count,
						Constant.enemy_Walking_State,
						LevelLoader.enemiesWaveFromLeft[Constant.current_Level][i][Constant.enemy_Time_Lag_Index],
						LevelLoader.enemiesWaveFromLeft[Constant.current_Level][i][Constant.enemy_Speed_Index],
						0, 0, 0, 0, Constant.enemy3_Attack);
				Constant.enemyVectorLeft.add(enemy3);
				break;

			case Constant.enemy_Type4_Left:
				Enemy enemy4 = new Enemy(
						LevelLoader.enemiesWaveFromLeft[Constant.current_Level][i][Constant.enemy_Type_Index],
						-(Constant.Enemy_Type_4_Left_Bitmap_Frame_Walk
								.getWidth() / Constant.Enemy_4_Walk_Frame_Count),
						Constant.getHeightPercentage(LevelLoader.enemiesWaveFromLeft[Constant.current_Level][i][Constant.enemy_Y_Pos_Index]),
						(Constant.Enemy_Type_4_Left_Bitmap_Frame_Walk
								.getWidth() / Constant.Enemy_4_Walk_Frame_Count),
						Constant.Enemy_Type_4_Left_Bitmap_Frame_Walk
								.getHeight(),
						LevelLoader.enemiesWaveFromLeft[Constant.current_Level][i][Constant.enemy_Health_Index],
						Constant.Enemy_4_Walk_Frame_Count,
						Constant.Enemy_4_Attack_Frame_Count,
						Constant.Enemy_4_Dead_Frame_Count,
						Constant.enemy_Walking_State,
						LevelLoader.enemiesWaveFromLeft[Constant.current_Level][i][Constant.enemy_Time_Lag_Index],
						LevelLoader.enemiesWaveFromLeft[Constant.current_Level][i][Constant.enemy_Speed_Index],
						0, 0, 0, 0, Constant.enemy4_Attack);
				Constant.enemyVectorLeft.add(enemy4);
				break;

			case Constant.enemy_Type5_Left:
				Enemy enemy5 = new Enemy(
						LevelLoader.enemiesWaveFromLeft[Constant.current_Level][i][Constant.enemy_Type_Index],
						-(Constant.Enemy_Type_5_Left_Bitmap_Frame_Walk
								.getWidth() / Constant.Enemy_5_Walk_Frame_Count),
						Constant.getHeightPercentage(LevelLoader.enemiesWaveFromLeft[Constant.current_Level][i][Constant.enemy_Y_Pos_Index]),
						(Constant.Enemy_Type_5_Left_Bitmap_Frame_Walk
								.getWidth() / Constant.Enemy_5_Walk_Frame_Count),
						Constant.Enemy_Type_5_Left_Bitmap_Frame_Walk
								.getHeight(),
						LevelLoader.enemiesWaveFromLeft[Constant.current_Level][i][Constant.enemy_Health_Index],
						Constant.Enemy_5_Walk_Frame_Count,
						Constant.Enemy_5_Attack_Frame_Count,
						Constant.Enemy_5_Dead_Frame_Count,
						Constant.enemy_Walking_State,
						LevelLoader.enemiesWaveFromLeft[Constant.current_Level][i][Constant.enemy_Time_Lag_Index],
						LevelLoader.enemiesWaveFromLeft[Constant.current_Level][i][Constant.enemy_Speed_Index],
						0, 0, 0, 0, Constant.enemy5_Attack);
				Constant.enemyVectorLeft.add(enemy5);
				break;

			default:
				break;
			}
		}

		for (int i = 0; i < LevelLoader.enemiesWaveFromRight[Constant.current_Level].length; i++) {
			switch (LevelLoader.enemiesWaveFromRight[Constant.current_Level][i][Constant.enemy_Type_Index]) {
			case Constant.enemy_Type1_Right:
				Enemy enemy1 = new Enemy(
						LevelLoader.enemiesWaveFromRight[Constant.current_Level][i][Constant.enemy_Type_Index],
						Constant.getWidthPercentage(100)
								+ (Constant.Enemy_Type_1_Right_Bitmap_Frame_Walk
										.getWidth() / Constant.Enemy_1_Walk_Frame_Count),
						Constant.getHeightPercentage(LevelLoader.enemiesWaveFromRight[Constant.current_Level][i][Constant.enemy_Y_Pos_Index]),
						(Constant.Enemy_Type_1_Right_Bitmap_Frame_Walk
								.getWidth() / Constant.Enemy_1_Walk_Frame_Count),
						Constant.Enemy_Type_1_Right_Bitmap_Frame_Walk
								.getHeight(),
						LevelLoader.enemiesWaveFromRight[Constant.current_Level][i][Constant.enemy_Health_Index],
						Constant.Enemy_1_Walk_Frame_Count,
						Constant.Enemy_1_Attack_Frame_Count,
						Constant.Enemy_1_Dead_Frame_Count,
						Constant.enemy_Walking_State,
						LevelLoader.enemiesWaveFromRight[Constant.current_Level][i][Constant.enemy_Time_Lag_Index],
						LevelLoader.enemiesWaveFromRight[Constant.current_Level][i][Constant.enemy_Speed_Index],
						0, 0, 0, 0, Constant.enemy1_Attack);
				Constant.enemyVectorRight.add(enemy1);
				break;

			case Constant.enemy_Type2_Right:
				Enemy enemy2 = new Enemy(
						LevelLoader.enemiesWaveFromRight[Constant.current_Level][i][Constant.enemy_Type_Index],
						Constant.getWidthPercentage(100)
								+ (Constant.Enemy_Type_2_Right_Bitmap_Frame_Walk
										.getWidth() / Constant.Enemy_2_Walk_Frame_Count),
						Constant.getHeightPercentage(LevelLoader.enemiesWaveFromRight[Constant.current_Level][i][Constant.enemy_Y_Pos_Index]),
						(Constant.Enemy_Type_2_Right_Bitmap_Frame_Walk
								.getWidth() / Constant.Enemy_2_Walk_Frame_Count),
						Constant.Enemy_Type_2_Right_Bitmap_Frame_Walk
								.getHeight(),
						LevelLoader.enemiesWaveFromRight[Constant.current_Level][i][Constant.enemy_Health_Index],
						Constant.Enemy_2_Walk_Frame_Count,
						Constant.Enemy_2_Attack_Frame_Count,
						Constant.Enemy_2_Dead_Frame_Count,
						Constant.enemy_Walking_State,
						LevelLoader.enemiesWaveFromRight[Constant.current_Level][i][Constant.enemy_Time_Lag_Index],
						LevelLoader.enemiesWaveFromRight[Constant.current_Level][i][Constant.enemy_Speed_Index],
						0, 0, 0, 0, Constant.enemy2_Attack);
				Constant.enemyVectorRight.add(enemy2);
				break;

			case Constant.enemy_Type3_Right:
				Enemy enemy3 = new Enemy(
						LevelLoader.enemiesWaveFromRight[Constant.current_Level][i][Constant.enemy_Type_Index],
						Constant.getWidthPercentage(100)
								+ (Constant.Enemy_Type_3_Right_Bitmap_Frame_Walk
										.getWidth() / Constant.Enemy_3_Walk_Frame_Count),
						Constant.getHeightPercentage(LevelLoader.enemiesWaveFromRight[Constant.current_Level][i][Constant.enemy_Y_Pos_Index]),
						(Constant.Enemy_Type_3_Right_Bitmap_Frame_Walk
								.getWidth() / Constant.Enemy_3_Walk_Frame_Count),
						Constant.Enemy_Type_3_Right_Bitmap_Frame_Walk
								.getHeight(),
						LevelLoader.enemiesWaveFromRight[Constant.current_Level][i][Constant.enemy_Health_Index],
						Constant.Enemy_3_Walk_Frame_Count,
						Constant.Enemy_3_Attack_Frame_Count,
						Constant.Enemy_3_Dead_Frame_Count,
						Constant.enemy_Walking_State,
						LevelLoader.enemiesWaveFromRight[Constant.current_Level][i][Constant.enemy_Time_Lag_Index],
						LevelLoader.enemiesWaveFromRight[Constant.current_Level][i][Constant.enemy_Speed_Index],
						0, 0, 0, 0, Constant.enemy3_Attack);
				Constant.enemyVectorRight.add(enemy3);
				break;

			case Constant.enemy_Type4_Right:
				Enemy enemy4 = new Enemy(
						LevelLoader.enemiesWaveFromRight[Constant.current_Level][i][Constant.enemy_Type_Index],
						Constant.getWidthPercentage(100)
								+ (Constant.Enemy_Type_4_Right_Bitmap_Frame_Walk
										.getWidth() / Constant.Enemy_4_Walk_Frame_Count),
						Constant.getHeightPercentage(LevelLoader.enemiesWaveFromRight[Constant.current_Level][i][Constant.enemy_Y_Pos_Index]),
						(Constant.Enemy_Type_4_Right_Bitmap_Frame_Walk
								.getWidth() / Constant.Enemy_4_Walk_Frame_Count),
						Constant.Enemy_Type_4_Right_Bitmap_Frame_Walk
								.getHeight(),
						LevelLoader.enemiesWaveFromRight[Constant.current_Level][i][Constant.enemy_Health_Index],
						Constant.Enemy_4_Walk_Frame_Count,
						Constant.Enemy_4_Attack_Frame_Count,
						Constant.Enemy_4_Dead_Frame_Count,
						Constant.enemy_Walking_State,
						LevelLoader.enemiesWaveFromRight[Constant.current_Level][i][Constant.enemy_Time_Lag_Index],
						LevelLoader.enemiesWaveFromRight[Constant.current_Level][i][Constant.enemy_Speed_Index],
						0, 0, 0, 0, Constant.enemy4_Attack);
				Constant.enemyVectorRight.add(enemy4);
				break;

			case Constant.enemy_Type5_Right:
				Enemy enemy5 = new Enemy(
						LevelLoader.enemiesWaveFromRight[Constant.current_Level][i][Constant.enemy_Type_Index],
						Constant.getWidthPercentage(100)
								+ (Constant.Enemy_Type_5_Right_Bitmap_Frame_Walk
										.getWidth() / Constant.Enemy_5_Walk_Frame_Count),
						Constant.getHeightPercentage(LevelLoader.enemiesWaveFromRight[Constant.current_Level][i][Constant.enemy_Y_Pos_Index]),
						(Constant.Enemy_Type_5_Right_Bitmap_Frame_Walk
								.getWidth() / Constant.Enemy_5_Walk_Frame_Count),
						Constant.Enemy_Type_5_Right_Bitmap_Frame_Walk
								.getHeight(),
						LevelLoader.enemiesWaveFromRight[Constant.current_Level][i][Constant.enemy_Health_Index],
						Constant.Enemy_5_Walk_Frame_Count,
						Constant.Enemy_5_Attack_Frame_Count,
						Constant.Enemy_5_Dead_Frame_Count,
						Constant.enemy_Walking_State,
						LevelLoader.enemiesWaveFromRight[Constant.current_Level][i][Constant.enemy_Time_Lag_Index],
						LevelLoader.enemiesWaveFromRight[Constant.current_Level][i][Constant.enemy_Speed_Index],
						0, 0, 0, 0, Constant.enemy5_Attack);
				Constant.enemyVectorRight.add(enemy5);
				break;

			default:
				break;
			}
		}

	}

	private void MenuButtonXY() {
		// TODO Auto-generated method stub
		Constant.playButtonX = Constant.getWidthPercentage(15);
		Constant.playButtonY = Constant.getHeightPercentage(25);

		Constant.soundButtonX = Constant.getWidthPercentage(15);
		Constant.soundButtonY = Constant.getHeightPercentage(40);

		Constant.exitButtonX = Constant.getWidthPercentage(15);
		Constant.exitButtonY = Constant.getHeightPercentage(55);

		Constant.MENU_BUTTON_ARRAY = new int[][] {
				{ Constant.playButtonX, Constant.playButtonY,
						Constant.playButton.getWidth(),
						Constant.playButton.getHeight() },
				{ Constant.soundButtonX, Constant.soundButtonY,
						Constant.soundButton.getWidth(),
						Constant.soundButton.getHeight() },
				{ Constant.exitButtonX, Constant.exitButtonY,
						Constant.exitButton.getWidth(),
						Constant.exitButton.getHeight() }, };
	}

	@Override
	public boolean onTouchEvent(MotionEvent event) {
		// TODO Auto-generated method stub
		int x = (int) event.getX();
		int y = (int) event.getY();

		switch (event.getAction()) {

		case MotionEvent.ACTION_DOWN:
			switch (Constant.current_State) {
			case Constant.state_Menu:
				if (isPointInRect(
						x,
						y,
						Constant.MENU_BUTTON_ARRAY[Constant.Menu_play_button_id])) {
					Constant.playButtonPressed = true;
				}
				break;
			case Constant.state_GamePlay:
				if (isPointInRect(x, y,
						Constant.GAME_BUTTON_ARRAY[Constant.Game_hand_gun_id])) {
					Constant.handGunIconPressed = true;
				}

				if (isPointInRect(x, y,
						Constant.GAME_BUTTON_ARRAY[Constant.Game_knife_id])) {
					Constant.knifeIconPressed = true;
				}

				if (isPointInRect(x, y,
						Constant.GAME_BUTTON_ARRAY[Constant.Game_launcher_id])) {
					Constant.launcherIconPressed = true;
				}

				if (isPointInRect(x, y,
						Constant.GAME_BUTTON_ARRAY[Constant.Game_mine_id])) {
					Constant.minesIconPressed = true;
				}

				if (isPointInRect(x, y,
						Constant.GAME_BUTTON_ARRAY[Constant.Game_shot_gun_id])) {
					Constant.shotgunIconPressed = true;
				}

				if (isPointInRect(
						x,
						y,
						Constant.GAME_BUTTON_ARRAY[Constant.Game_pause_button_id])) {
					Constant.pauseButtonPressed = true;
				}

				switch (Constant.hero.whichWeaponIsSelected) {
				case Constant.knife_selected:
					Constant.knifePointerDownX = x;
					Constant.knifePointerDownY = y;
					if (Constant.knifePointerDownX > Constant.leftKnifeRectangleX
							&& Constant.knifePointerDownX < (Constant.leftKnifeRectangleX + Constant.leftKnifeRectangleWidth)) {
						if (Constant.knifePointerDownY > Constant.leftKnifeRectangleY
								&& Constant.knifePointerDownY < (Constant.leftKnifeRectangleY + Constant.leftKnifeRectangleHeight)) {
							Constant.knifeLeftRectSelected = true;
							Constant.knifeRightRectSelected = false;
						}
					}
					if (Constant.knifePointerDownX > Constant.rightKnifeRectangleX
							&& Constant.knifePointerDownX < (Constant.rightKnifeRectangleX + Constant.rightKnifeRectangleWidth)) {
						if (Constant.knifePointerDownY > Constant.rightKnifeRectangleY
								&& Constant.knifePointerDownY < (Constant.rightKnifeRectangleY + Constant.rightknifeRectangleHeight)) {
							Constant.knifeLeftRectSelected = false;
							Constant.knifeRightRectSelected = true;
						}
					}

					break;

				default:
					break;
				}

				break;
			case Constant.state_Pause:
				if (isPointInRect(
						x,
						y,
						Constant.PAUSE_BUTTON_ARRAY[Constant.Pause_resume_button_id])) {
					Constant.resumeButtonPressed = true;
				}

				if (isPointInRect(
						x,
						y,
						Constant.PAUSE_BUTTON_ARRAY[Constant.Pause_shop_button_id])) {
					Constant.shopButtonPressed = true;
				}

				if (isPointInRect(
						x,
						y,
						Constant.PAUSE_BUTTON_ARRAY[Constant.Pause_home_button_id])) {
					Constant.homeButtonPressed = true;
				}

				if (isPointInRect(
						x,
						y,
						Constant.PAUSE_BUTTON_ARRAY[Constant.Pause_exit_button_id])) {
					Constant.pauseExitButtonPressed = true;
				}

				break;
			case Constant.state_shop:
				if (isPointInRect(
						x,
						y,
						Constant.SHOP_BUTTON_ARRAY[Constant.Shop_health_icon_id])) {
					Constant.shopHealthIconPressed = true;
				}

				if (isPointInRect(
						x,
						y,
						Constant.SHOP_BUTTON_ARRAY[Constant.Shop_shotgun_icon_id])) {
					Constant.shopShotGunIconPressed = true;
				}

				if (isPointInRect(x, y,
						Constant.SHOP_BUTTON_ARRAY[Constant.Shop_bomb_icon_id])) {
					Constant.shopBombIconPressed = true;
				}

				if (isPointInRect(
						x,
						y,
						Constant.SHOP_BUTTON_ARRAY[Constant.Shop_launcher_icon_id])) {
					Constant.shopLauncherIconPressed = true;
				}

				if (isPointInRect(x, y,
						Constant.SHOP_BUTTON_ARRAY[Constant.Shop_buy_button_id])) {
					Constant.shopBuyButtonPressed = true;
				}

				if (isPointInRect(
						x,
						y,
						Constant.SHOP_BUTTON_ARRAY[Constant.Shop_back_button_id])) {
					Constant.shopBackButtonPressed = true;
				}

				break;

			case Constant.state_GameOver:
				if (isPointInRect(x, y,
						Constant.Lose_State_BUTTON_ARRAY[Constant.homeBtnId])) {
					Constant.loseHomeBtnPressed = true;
				}
				if (isPointInRect(x, y,
						Constant.Lose_State_BUTTON_ARRAY[Constant.replayBtnId])) {
					Constant.loseReplayBtnPressed = true;
				}
				break;

			case Constant.state_win:
				if (isPointInRect(x, y,
						Constant.Win_State_BUTTON_ARRAY[Constant.homeBtnId])) {
					Constant.winHomeBtnPressed = true;
				}
				if (isPointInRect(x, y,
						Constant.Win_State_BUTTON_ARRAY[Constant.replayBtnId])) {
					Constant.winReplayBtnPressed = true;
				}
				break;

			default:
				break;
			}

			break;
		case MotionEvent.ACTION_MOVE:
			switch (Constant.current_State) {
			case Constant.state_GamePlay:

				switch (Constant.hero.whichWeaponIsSelected) {
				case Constant.knife_selected:
					if (Constant.knifeLeftRectSelected
							|| Constant.knifeRightRectSelected) {
						Constant.knifeDrag = true;
					}

					else {
						Constant.knifeDrag = false;
						Constant.knifeLeftRectSelected = false;
						Constant.knifeRightRectSelected = false;
					}
					break;

				default:
					break;
				}
				break;

			default:
				break;
			}
			break;

		case MotionEvent.ACTION_UP:

			switch (Constant.current_State) {
			case Constant.state_Menu:
				if (Constant.playButtonPressed) {
					if (isPointInRect(
							x,
							y,
							Constant.MENU_BUTTON_ARRAY[Constant.Menu_play_button_id])) {
						levelLoader(Constant.current_Level);
						Constant.gameStartTime = System.currentTimeMillis();
						Constant.setCurrent_State(Constant.state_GamePlay);
					}
					Constant.playButtonPressed = false;

				}
				break;
			case Constant.state_GamePlay:
				if (Constant.handGunIconPressed) {
					if (isPointInRect(
							x,
							y,
							Constant.GAME_BUTTON_ARRAY[Constant.Game_hand_gun_id])) {
						Constant.hero
								.setWhichWeaponIsSelected(Constant.handgun_selected);
					}
					Constant.handGunIconPressed = false;
				}
				if (Constant.knifeIconPressed) {
					if (isPointInRect(x, y,
							Constant.GAME_BUTTON_ARRAY[Constant.Game_knife_id])) {
						Constant.hero
								.setWhichWeaponIsSelected(Constant.knife_selected);
					}
					Constant.knifeIconPressed = false;
				}
				if (Constant.launcherIconPressed) {
					if (isPointInRect(
							x,
							y,
							Constant.GAME_BUTTON_ARRAY[Constant.Game_launcher_id])) {
						Constant.hero
								.setWhichWeaponIsSelected(Constant.launcher_selected);
					}
					Constant.launcherIconPressed = false;
				}
				if (Constant.minesIconPressed) {
					if (isPointInRect(x, y,
							Constant.GAME_BUTTON_ARRAY[Constant.Game_mine_id])) {
						Constant.hero
								.setWhichWeaponIsSelected(Constant.mines_selected);
					}
					Constant.minesIconPressed = false;
				}
				if (Constant.shotgunIconPressed) {
					if (isPointInRect(
							x,
							y,
							Constant.GAME_BUTTON_ARRAY[Constant.Game_shot_gun_id])) {
						Constant.hero
								.setWhichWeaponIsSelected(Constant.shotgun_selected);
					}
					Constant.shotgunIconPressed = false;
				}
				if (Constant.pauseButtonPressed) {
					if (isPointInRect(
							x,
							y,
							Constant.GAME_BUTTON_ARRAY[Constant.Game_pause_button_id])) {
						Constant.setCurrent_State(Constant.state_Pause);
					}
					Constant.pauseButtonPressed = false;
				}

				if (y > Constant.getHeightPercentage(16)
						&& y < Constant.getHeightPercentage(100)) {
					switch (Constant.hero.whichWeaponIsSelected) {

					case Constant.handgun_selected:
						Point p1 = new Point(x, y);
						NormalBullet normalbullet = new NormalBullet(
								p1.x,
								p1.y,
								MediaPlayer
										.create(Constant.context,
												com.mobrna.sampleview.R.raw.handgunfire));

						heroFrameCounter = 0;
						Constant.hero.setAnimationStart(true);
						Constant.handGunBulletVector.add(normalbullet);

						if (x < Constant.hero.getHero_x()) {
							Constant.hero
									.setWhichSideHeroFacing(Constant.rightSideHeroFacing);
						} else {
							Constant.hero
									.setWhichSideHeroFacing(Constant.leftSideHeroFacing);
						}
						break;

					case Constant.knife_selected:
						if (Constant.knifeDrag
								&& Constant.knifeLeftRectSelected) {
							checkLeftSideKnifeAttack();
							Constant.knifeDrag = false;
							Constant.knifeLeftRectSelected = false;
							Constant.knifeRightRectSelected = false;

						}
						if (Constant.knifeDrag
								&& Constant.knifeRightRectSelected) {
							checkRightSideKnifeAttack();
							Constant.knifeDrag = false;
							Constant.knifeLeftRectSelected = false;
							Constant.knifeRightRectSelected = false;
						}

						heroFrameCounter = 0;
						Constant.hero.setAnimationStart(true);
						if (x < Constant.hero.getHero_x()) {
							Constant.hero
									.setWhichSideHeroFacing(Constant.rightSideHeroFacing);
						} else {
							Constant.hero
									.setWhichSideHeroFacing(Constant.leftSideHeroFacing);
						}

						break;

					case Constant.shotgun_selected:
						if (Constant.number_Of_Shotgun_Emmo > 0) {
							Point p2 = new Point(x, y);
							NormalBullet normalshotgunbullet = new NormalBullet(
									p2.x,
									p2.y,
									MediaPlayer
											.create(Constant.context,
													com.mobrna.sampleview.R.raw.shotgunsound));
							Constant.shotGunBulletVector
									.add(normalshotgunbullet);
							Constant.number_Of_Shotgun_Emmo--;
						}

						heroFrameCounter = 0;
						Constant.hero.setAnimationStart(true);

						if (x < Constant.hero.getHero_x()) {
							Constant.hero
									.setWhichSideHeroFacing(Constant.rightSideHeroFacing);
						} else {
							Constant.hero
									.setWhichSideHeroFacing(Constant.leftSideHeroFacing);
						}
						break;

					case Constant.launcher_selected:
						if (Constant.number_Of_Launcher > 0) {
							double roughRange = Math.abs(x
									- Constant.hero.getHero_x());
							Bullet launcherBullet = new Bullet(x, y,
									Constant.hero.getHero_x(),
									Constant.hero.getHero_y(), roughRange,
									MediaPlayer.create(Constant.context,
											R.raw.launcherbomb));
							Constant.launcherVector.add(launcherBullet);
							Constant.number_Of_Launcher--;
							heroFrameCounter = 0;
							Constant.hero.setAnimationStart(true);

							if (x < Constant.hero.getHero_x()) {
								Constant.hero
										.setWhichSideHeroFacing(Constant.rightSideHeroFacing);
							} else {
								Constant.hero
										.setWhichSideHeroFacing(Constant.leftSideHeroFacing);
							}
						}
						break;

					case Constant.mines_selected:
						if (y > Constant.getHeightPercentage(100)
								- (2 * Constant.getHeightPercentage(25))) {
							if (Constant.number_Of_mines > 0) {
								Point p3 = new Point(x, y);
								Mines mines = new Mines(
										p3.x,
										p3.y,
										System.currentTimeMillis(),
										MediaPlayer
												.create(Constant.context,
														com.mobrna.sampleview.R.raw.launcherbomb));
								Constant.minesVector.add(mines);
								Constant.number_Of_mines--;
							}
							heroFrameCounter = 0;
							Constant.hero.setAnimationStart(true);
						}
						if (x < Constant.hero.getHero_x()) {
							Constant.hero
									.setWhichSideHeroFacing(Constant.rightSideHeroFacing);
						} else {
							Constant.hero
									.setWhichSideHeroFacing(Constant.leftSideHeroFacing);
						}
						break;
					}
				}
				break;
			case Constant.state_Pause:
				if (Constant.resumeButtonPressed) {
					if (isPointInRect(
							x,
							y,
							Constant.PAUSE_BUTTON_ARRAY[Constant.Pause_resume_button_id])) {

						Constant.setCurrent_State(Constant.state_GamePlay);
					}
					Constant.resumeButtonPressed = false;
				}

				if (Constant.shopButtonPressed) {
					if (isPointInRect(
							x,
							y,
							Constant.PAUSE_BUTTON_ARRAY[Constant.Pause_shop_button_id])) {
						Constant.setCurrent_State(Constant.state_shop);
					}
					Constant.shopButtonPressed = false;
				}

				if (Constant.homeButtonPressed) {
					if (isPointInRect(
							x,
							y,
							Constant.PAUSE_BUTTON_ARRAY[Constant.Pause_home_button_id])) {
						Constant.setCurrent_State(Constant.state_Menu);
					}
					Constant.homeButtonPressed = false;
				}

				if (Constant.pauseExitButtonPressed) {
					if (isPointInRect(
							x,
							y,
							Constant.PAUSE_BUTTON_ARRAY[Constant.Pause_exit_button_id])) {
						new MainActivity().FINISH_MY_GAME();					}
					Constant.pauseExitButtonPressed = false;
				}

				break;
			case Constant.state_shop:
				if (Constant.shopHealthIconPressed) {
					if (isPointInRect(
							x,
							y,
							Constant.SHOP_BUTTON_ARRAY[Constant.Shop_health_icon_id])) {
						Constant.setShopitemscreenstate(Constant.shop_health);
						Constant.WhichItemPriceToShow = Constant.HEALTH_KIT_PRICE;
					}
					Constant.shopHealthIconPressed = false;
				}

				if (Constant.shopShotGunIconPressed) {
					if (isPointInRect(
							x,
							y,
							Constant.SHOP_BUTTON_ARRAY[Constant.Shop_shotgun_icon_id])) {
						Constant.setShopitemscreenstate(Constant.shop_shotgun);
						Constant.WhichItemPriceToShow = Constant.SHOTGUN_AMMO_PRICE;
					}
					Constant.shopShotGunIconPressed = false;
				}

				if (Constant.shopBombIconPressed) {
					if (isPointInRect(
							x,
							y,
							Constant.SHOP_BUTTON_ARRAY[Constant.Shop_bomb_icon_id])) {
						Constant.setShopitemscreenstate(Constant.shop_bomb);
						Constant.WhichItemPriceToShow = Constant.MINES_PRICE;
					}
					Constant.shopBombIconPressed = false;
				}

				if (Constant.shopLauncherIconPressed) {
					if (isPointInRect(
							x,
							y,
							Constant.SHOP_BUTTON_ARRAY[Constant.Shop_launcher_icon_id])) {
						Constant.setShopitemscreenstate(Constant.shop_launcher);
						Constant.WhichItemPriceToShow = Constant.LAUNCHER_PRICE;
					}
					Constant.shopLauncherIconPressed = false;
				}

				if (Constant.shopBuyButtonPressed) {
					if (isPointInRect(
							x,
							y,
							Constant.SHOP_BUTTON_ARRAY[Constant.Shop_buy_button_id])) {

						switch (Constant.WhichItemPriceToShow) {
						case Constant.HEALTH_KIT_PRICE:
							if (Constant.total_Money >= Constant.HEALTH_KIT_PRICE) {
								Constant.total_Money = Constant.total_Money
										- Constant.HEALTH_KIT_PRICE;
								Constant.hero.setHealth(Constant
										.getWidthPercentage(26));
							}
							break;
						case Constant.SHOTGUN_AMMO_PRICE:
							if (Constant.total_Money >= Constant.SHOTGUN_AMMO_PRICE) {
								Constant.total_Money = Constant.total_Money
										- Constant.SHOTGUN_AMMO_PRICE;
								Constant.number_Of_Shotgun_Emmo = Constant.number_Of_Shotgun_Emmo + 10;
							}
							break;
						case Constant.LAUNCHER_PRICE:
							if (Constant.total_Money >= Constant.LAUNCHER_PRICE) {
								Constant.total_Money = Constant.total_Money
										- Constant.LAUNCHER_PRICE;
								Constant.number_Of_Launcher = Constant.number_Of_Launcher + 2;
							}
							break;
						case Constant.MINES_PRICE:
							if (Constant.total_Money >= Constant.MINES_PRICE) {
								Constant.total_Money = Constant.total_Money
										- Constant.MINES_PRICE;
								Constant.number_Of_mines = Constant.number_Of_mines + 2;
							}
							break;

						default:
							break;

						}

					}
					Constant.shopBuyButtonPressed = false;
				}

				if (Constant.shopBackButtonPressed) {
					if (isPointInRect(
							x,
							y,
							Constant.SHOP_BUTTON_ARRAY[Constant.Shop_back_button_id])) {
						Constant.setCurrent_State(Constant.state_Pause);
					}
					Constant.shopBackButtonPressed = false;
				}
				break;

			case Constant.state_Level_Loader:
				Constant.current_Level++;
				levelLoader(Constant.current_Level);
				Constant.gameStartTime = System.currentTimeMillis();
				Constant.setCurrent_State(Constant.state_GamePlay);
				break;

			case Constant.state_GameOver:
				if (Constant.loseHomeBtnPressed) {
					if (isPointInRect(
							x,
							y,
							Constant.Lose_State_BUTTON_ARRAY[Constant.homeBtnId])) {
						Constant.current_State = Constant.state_Menu;
					}
					Constant.loseHomeBtnPressed = false;
				}
				if (Constant.loseReplayBtnPressed) {
					if (isPointInRect(
							x,
							y,
							Constant.Lose_State_BUTTON_ARRAY[Constant.replayBtnId])) {
						Constant.current_Level = 0;
						levelLoader(Constant.current_Level);
						Constant.gameStartTime = System.currentTimeMillis();
						Constant.number_Of_Launcher = 10;
						Constant.number_Of_mines = 5;
						Constant.number_Of_Shotgun_Emmo = 10;
						Constant.total_Money = 0;
						Constant.hero
								.setHealth(Constant.getWidthPercentage(26));
						Constant.current_State = Constant.state_GamePlay;
					}
					Constant.loseReplayBtnPressed = false;
				}
				break;
			case Constant.state_win:
				if (Constant.winHomeBtnPressed) {
					if (isPointInRect(x, y,
							Constant.Win_State_BUTTON_ARRAY[Constant.homeBtnId])) {
						Constant.current_State = Constant.state_Menu;
					}
					Constant.winHomeBtnPressed = false;
				}
				if (Constant.winReplayBtnPressed) {
					if (isPointInRect(
							x,
							y,
							Constant.Win_State_BUTTON_ARRAY[Constant.replayBtnId])) {
						Constant.current_Level = 0;
						levelLoader(Constant.current_Level);
						Constant.gameStartTime = System.currentTimeMillis();
						Constant.number_Of_Launcher = 10;
						Constant.number_Of_mines = 5;
						Constant.number_Of_Shotgun_Emmo = 10;
						Constant.total_Money = 0;
						Constant.hero
								.setHealth(Constant.getWidthPercentage(26));
						Constant.current_State = Constant.state_GamePlay;
					}
					Constant.winReplayBtnPressed = false;
				}
				break;

			default:
				break;
			}
		}
		return true;
	}

	private void checkRightSideKnifeAttack() {
		// TODO Auto-generated method stub
		if (!Constant.enemyVectorRight.isEmpty()) {
			for (int i = 0; i < Constant.enemyVectorRight.size(); i++) {
				Enemy tempEnemy = (Enemy) Constant.enemyVectorRight
						.elementAt(i);
				if (tempEnemy.getEnemy_X() > Constant.rightKnifeRectangleX
						&& (tempEnemy.getEnemy_X() + tempEnemy.getEnemy_Width()) < (Constant.rightKnifeRectangleX + Constant.rightKnifeRectangleWidth)) {
					checkEnemyHealth(tempEnemy, 0, Constant.knifeAttack);
				}
			}
		}

	}

	private void checkLeftSideKnifeAttack() {
		// TODO Auto-generated method stub
		if (!Constant.enemyVectorLeft.isEmpty()) {
			for (int i = 0; i < Constant.enemyVectorLeft.size(); i++) {
				Enemy tempEnemy = (Enemy) Constant.enemyVectorLeft.elementAt(i);
				if (tempEnemy.getEnemy_X() > Constant.leftKnifeRectangleX
						&& (tempEnemy.getEnemy_X() + tempEnemy.getEnemy_Width()) < (Constant.leftKnifeRectangleX + Constant.leftKnifeRectangleWidth)) {
					checkEnemyHealth(tempEnemy, 0, Constant.knifeAttack);
				}
			}
		}

	}

	private void checkEnemyHealth(Enemy tempEnemy, int whichPartBodyShoot,
			int Attack_Type) {
		// TODO Auto-generated method stub
		switch (Attack_Type) {
		case Constant.handGunAttack:
			if (tempEnemy.getEnemy_Health() >= 1) {
				if (whichPartBodyShoot == Constant.enemy_Head_Shoot) {
					tempEnemy.setEnemy_Health(tempEnemy.getEnemy_Health()
							- (2 * Constant.handGunAttack));
					if (tempEnemy.getEnemy_Health() < 1) {
						tempEnemy.setEnemy_State(Constant.enemy_Dead_State);
						switch (tempEnemy.getEnemy_Type()) {
						case Constant.enemy_Type1_Left:
							Constant.total_Money = Constant.total_Money
									+ Constant.zombie_1_Headshoot_Price;
							break;
						case Constant.enemy_Type1_Right:
							Constant.total_Money = Constant.total_Money
									+ Constant.zombie_1_Headshoot_Price;
							break;

						case Constant.enemy_Type2_Left:
							Constant.total_Money = Constant.total_Money
									+ Constant.zombie_2_Headshoot_Price;
							break;
						case Constant.enemy_Type2_Right:
							Constant.total_Money = Constant.total_Money
									+ Constant.zombie_2_Headshoot_Price;
							break;
						case Constant.enemy_Type3_Left:
							Constant.total_Money = Constant.total_Money
									+ Constant.zombie_3_Headshoot_Price;
							break;
						case Constant.enemy_Type3_Right:
							Constant.total_Money = Constant.total_Money
									+ Constant.zombie_3_Headshoot_Price;
							break;
						case Constant.enemy_Type4_Left:
							Constant.total_Money = Constant.total_Money
									+ Constant.zombie_4_Headshoot_Price;
							break;
						case Constant.enemy_Type4_Right:
							Constant.total_Money = Constant.total_Money
									+ Constant.zombie_4_Headshoot_Price;
							break;
						case Constant.enemy_Type5_Left:
							Constant.total_Money = Constant.total_Money
									+ Constant.zombie_5_Headshoot_Price;
							break;
						case Constant.enemy_Type5_Right:
							Constant.total_Money = Constant.total_Money
									+ Constant.zombie_5_Headshoot_Price;
							break;

						default:
							break;
						}
					}
				}

				if (whichPartBodyShoot == Constant.enemy_Body_Shoot) {
					tempEnemy.setEnemy_Health(tempEnemy.getEnemy_Health()
							- Constant.handGunAttack);
					if (tempEnemy.getEnemy_Health() < 1) {
						tempEnemy.setEnemy_State(Constant.enemy_Dead_State);
						switch (tempEnemy.getEnemy_Type()) {
						case Constant.enemy_Type1_Left:
							Constant.total_Money = Constant.total_Money
									+ Constant.zombie_1_Bodyshoot_Price;
							break;
						case Constant.enemy_Type1_Right:
							Constant.total_Money = Constant.total_Money
									+ Constant.zombie_1_Bodyshoot_Price;
							break;

						case Constant.enemy_Type2_Left:
							Constant.total_Money = Constant.total_Money
									+ Constant.zombie_2_Bodyshoot_Price;
							break;
						case Constant.enemy_Type2_Right:
							Constant.total_Money = Constant.total_Money
									+ Constant.zombie_2_Bodyshoot_Price;
							break;
						case Constant.enemy_Type3_Left:
							Constant.total_Money = Constant.total_Money
									+ Constant.zombie_3_Bodyshoot_Price;
							break;
						case Constant.enemy_Type3_Right:
							Constant.total_Money = Constant.total_Money
									+ Constant.zombie_3_Bodyshoot_Price;
							break;
						case Constant.enemy_Type4_Left:
							Constant.total_Money = Constant.total_Money
									+ Constant.zombie_4_Bodyshoot_Price;
							break;
						case Constant.enemy_Type4_Right:
							Constant.total_Money = Constant.total_Money
									+ Constant.zombie_4_Bodyshoot_Price;
							break;
						case Constant.enemy_Type5_Left:
							Constant.total_Money = Constant.total_Money
									+ Constant.zombie_5_Bodyshoot_Price;
							break;
						case Constant.enemy_Type5_Right:
							Constant.total_Money = Constant.total_Money
									+ Constant.zombie_5_Bodyshoot_Price;
							break;

						default:
							break;
						}
					}
				}
			}

			else {
				tempEnemy.setEnemy_State(Constant.enemy_Dead_State);
				Constant.total_Money = Constant.total_Money
						+ Constant.zombie_1_Bodyshoot_Price;
			}
			break;

		case Constant.knifeAttack:
			if (tempEnemy.getEnemy_Health() >= 1) {
				tempEnemy.setEnemy_Health(tempEnemy.getEnemy_Health()
						- Constant.knifeAttack);
				if (tempEnemy.getEnemy_Health() < 1) {
					tempEnemy.setEnemy_Health(0);
					tempEnemy.setEnemy_State(Constant.enemy_Dead_State);
					Constant.total_Money = Constant.total_Money
							+ Constant.zombie_1_Bodyshoot_Price;
				}
			} else {
				tempEnemy.setEnemy_State(Constant.enemy_Dead_State);
				Constant.total_Money = Constant.total_Money
						+ Constant.zombie_1_Bodyshoot_Price;
			}
			break;
		case Constant.shotGunAttack:
			if (tempEnemy.getEnemy_Health() >= 1) {
				if (whichPartBodyShoot == Constant.enemy_Head_Shoot) {
					tempEnemy.setEnemy_Health(tempEnemy.getEnemy_Health()
							- (2 * Constant.shotGunAttack));
					if (tempEnemy.getEnemy_Health() < 1) {
						tempEnemy.setEnemy_State(Constant.enemy_Dead_State);
						switch (tempEnemy.getEnemy_Type()) {
						case Constant.enemy_Type1_Left:
							Constant.total_Money = Constant.total_Money
									+ Constant.zombie_1_Headshoot_Price;
							break;
						case Constant.enemy_Type1_Right:
							Constant.total_Money = Constant.total_Money
									+ Constant.zombie_1_Headshoot_Price;
							break;

						case Constant.enemy_Type2_Left:
							Constant.total_Money = Constant.total_Money
									+ Constant.zombie_2_Headshoot_Price;
							break;
						case Constant.enemy_Type2_Right:
							Constant.total_Money = Constant.total_Money
									+ Constant.zombie_2_Headshoot_Price;
							break;
						case Constant.enemy_Type3_Left:
							Constant.total_Money = Constant.total_Money
									+ Constant.zombie_3_Headshoot_Price;
							break;
						case Constant.enemy_Type3_Right:
							Constant.total_Money = Constant.total_Money
									+ Constant.zombie_3_Headshoot_Price;
							break;
						case Constant.enemy_Type4_Left:
							Constant.total_Money = Constant.total_Money
									+ Constant.zombie_4_Headshoot_Price;
							break;
						case Constant.enemy_Type4_Right:
							Constant.total_Money = Constant.total_Money
									+ Constant.zombie_4_Headshoot_Price;
							break;
						case Constant.enemy_Type5_Left:
							Constant.total_Money = Constant.total_Money
									+ Constant.zombie_5_Headshoot_Price;
							break;
						case Constant.enemy_Type5_Right:
							Constant.total_Money = Constant.total_Money
									+ Constant.zombie_5_Headshoot_Price;
							break;

						default:
							break;
						}
					}
				}

				if (whichPartBodyShoot == Constant.enemy_Body_Shoot) {
					tempEnemy.setEnemy_Health(tempEnemy.getEnemy_Health()
							- Constant.shotGunAttack);
					if (tempEnemy.getEnemy_Health() < 1) {
						tempEnemy.setEnemy_State(Constant.enemy_Dead_State);
						switch (tempEnemy.getEnemy_Type()) {
						case Constant.enemy_Type1_Left:
							Constant.total_Money = Constant.total_Money
									+ Constant.zombie_1_Bodyshoot_Price;
							break;
						case Constant.enemy_Type1_Right:
							Constant.total_Money = Constant.total_Money
									+ Constant.zombie_1_Bodyshoot_Price;
							break;

						case Constant.enemy_Type2_Left:
							Constant.total_Money = Constant.total_Money
									+ Constant.zombie_2_Bodyshoot_Price;
							break;
						case Constant.enemy_Type2_Right:
							Constant.total_Money = Constant.total_Money
									+ Constant.zombie_2_Bodyshoot_Price;
							break;
						case Constant.enemy_Type3_Left:
							Constant.total_Money = Constant.total_Money
									+ Constant.zombie_3_Bodyshoot_Price;
							break;
						case Constant.enemy_Type3_Right:
							Constant.total_Money = Constant.total_Money
									+ Constant.zombie_3_Bodyshoot_Price;
							break;
						case Constant.enemy_Type4_Left:
							Constant.total_Money = Constant.total_Money
									+ Constant.zombie_4_Bodyshoot_Price;
							break;
						case Constant.enemy_Type4_Right:
							Constant.total_Money = Constant.total_Money
									+ Constant.zombie_4_Bodyshoot_Price;
							break;
						case Constant.enemy_Type5_Left:
							Constant.total_Money = Constant.total_Money
									+ Constant.zombie_5_Bodyshoot_Price;
							break;
						case Constant.enemy_Type5_Right:
							Constant.total_Money = Constant.total_Money
									+ Constant.zombie_5_Bodyshoot_Price;
							break;

						default:
							break;
						}
					}
				}
			}

			else {
				tempEnemy.setEnemy_State(Constant.enemy_Dead_State);
				Constant.total_Money = Constant.total_Money
						+ Constant.zombie_1_Bodyshoot_Price;
			}

			break;
		case Constant.LauncherAttack:

			tempEnemy.setEnemy_Health(0);
			tempEnemy.setEnemy_State(Constant.enemy_Dead_State);
			switch (tempEnemy.getEnemy_Type()) {
			case Constant.enemy_Type1_Left:
				Constant.total_Money = Constant.total_Money
						+ Constant.zombie_1_Bodyshoot_Price;
				break;
			case Constant.enemy_Type1_Right:
				Constant.total_Money = Constant.total_Money
						+ Constant.zombie_1_Bodyshoot_Price;
				break;

			case Constant.enemy_Type2_Left:
				Constant.total_Money = Constant.total_Money
						+ Constant.zombie_2_Bodyshoot_Price;
				break;
			case Constant.enemy_Type2_Right:
				Constant.total_Money = Constant.total_Money
						+ Constant.zombie_2_Bodyshoot_Price;
				break;
			case Constant.enemy_Type3_Left:
				Constant.total_Money = Constant.total_Money
						+ Constant.zombie_3_Bodyshoot_Price;
				break;
			case Constant.enemy_Type3_Right:
				Constant.total_Money = Constant.total_Money
						+ Constant.zombie_3_Bodyshoot_Price;
				break;
			case Constant.enemy_Type4_Left:
				Constant.total_Money = Constant.total_Money
						+ Constant.zombie_4_Bodyshoot_Price;
				break;
			case Constant.enemy_Type4_Right:
				Constant.total_Money = Constant.total_Money
						+ Constant.zombie_4_Bodyshoot_Price;
				break;
			case Constant.enemy_Type5_Left:
				Constant.total_Money = Constant.total_Money
						+ Constant.zombie_5_Bodyshoot_Price;
				break;
			case Constant.enemy_Type5_Right:
				Constant.total_Money = Constant.total_Money
						+ Constant.zombie_5_Bodyshoot_Price;
				break;

			default:
				break;
			}
			break;

		case Constant.minesAttack:
			tempEnemy.setEnemy_Health(0);
			tempEnemy.setEnemy_State(Constant.enemy_Dead_State);
			switch (tempEnemy.getEnemy_Type()) {
			case Constant.enemy_Type1_Left:
				Constant.total_Money = Constant.total_Money
						+ Constant.zombie_1_Bodyshoot_Price;
				break;
			case Constant.enemy_Type1_Right:
				Constant.total_Money = Constant.total_Money
						+ Constant.zombie_1_Bodyshoot_Price;
				break;

			case Constant.enemy_Type2_Left:
				Constant.total_Money = Constant.total_Money
						+ Constant.zombie_2_Bodyshoot_Price;
				break;
			case Constant.enemy_Type2_Right:
				Constant.total_Money = Constant.total_Money
						+ Constant.zombie_2_Bodyshoot_Price;
				break;
			case Constant.enemy_Type3_Left:
				Constant.total_Money = Constant.total_Money
						+ Constant.zombie_3_Bodyshoot_Price;
				break;
			case Constant.enemy_Type3_Right:
				Constant.total_Money = Constant.total_Money
						+ Constant.zombie_3_Bodyshoot_Price;
				break;
			case Constant.enemy_Type4_Left:
				Constant.total_Money = Constant.total_Money
						+ Constant.zombie_4_Bodyshoot_Price;
				break;
			case Constant.enemy_Type4_Right:
				Constant.total_Money = Constant.total_Money
						+ Constant.zombie_4_Bodyshoot_Price;
				break;
			case Constant.enemy_Type5_Left:
				Constant.total_Money = Constant.total_Money
						+ Constant.zombie_5_Bodyshoot_Price;
				break;
			case Constant.enemy_Type5_Right:
				Constant.total_Money = Constant.total_Money
						+ Constant.zombie_5_Bodyshoot_Price;
				break;

			default:
				break;

			}

			break;
		default:
			break;
		}
	}

	private void loadBitMap() {
		// TODO Auto-generated method stub

		LOAD_SPLASH_RESOURCE();
		LOAD_MAIN_MENU_RESOURCE();
		LOAD_GAME_PLAY_ICONS();
		LOAD_PAUSE_STATE_ICONS();
		LOAD_SHOP_STATE_ICONS();
		LOAD_WIN_LOSE_STATE_ICONS();

	}

	private void LOAD_WIN_LOSE_STATE_ICONS() {
		// TODO Auto-generated method stub
		Constant.gameOverBitmap = Constant.graphics.newPixmap("gameover.png",
				Constant.getWidthPercentage(67),
				Constant.getHeightPercentage(21));
		Constant.gameWinBitmap = Constant.graphics.newPixmap(
				"congratulation.png", Constant.getWidthPercentage(50),
				Constant.getHeightPercentage(27));
		Constant.replaybtn = Constant.graphics.newPixmap("replay.png",
				Constant.getWidthPercentage(34),
				Constant.getHeightPercentage(18));
		Constant.homebtn = Constant.graphics.newPixmap("home.png",
				Constant.getWidthPercentage(34),
				Constant.getHeightPercentage(18));
		Constant.totalWinLoseBitmap = Constant.graphics.newPixmap(
				"totalwinlose.png", Constant.getWidthPercentage(40),
				Constant.getHeightPercentage(11));

	}

	private void LOAD_SHOP_STATE_ICONS() {
		// TODO Auto-generated method stub

		Constant.shopBackGround = Constant.graphics.newPixmap("pausebg.png",
				Constant.getWidthPercentage(100),
				Constant.getHeightPercentage(100));
		Constant.shopHeading = Constant.graphics.newPixmap("shopheading.png",
				Constant.getWidthPercentage(100),
				Constant.getHeightPercentage(10));
		Constant.shopTotalStrip = Constant.graphics.newPixmap(
				"shoptotalstrip.png", Constant.getWidthPercentage(100),
				Constant.getHeightPercentage(10));
		Constant.shopShowCase = Constant.graphics.newPixmap("shopshowcase.png",
				Constant.getWidthPercentage(55),
				Constant.getHeightPercentage(80));
		Constant.shopItemScreen = Constant.graphics.newPixmap(
				"shopitemscreen.png", Constant.getWidthPercentage(40),
				Constant.getHeightPercentage(40));
		Constant.shopPriceTag = Constant.graphics.newPixmap("shoppricetag.png",
				Constant.getWidthPercentage(40),
				Constant.getHeightPercentage(10));
		Constant.shopBuyButton = Constant.graphics.newPixmap("buybtn.png",
				Constant.getWidthPercentage(15),
				Constant.getHeightPercentage(10));
		Constant.shopBackButton = Constant.graphics.newPixmap("backbtn.png",
				Constant.getWidthPercentage(15),
				Constant.getHeightPercentage(10));
		Constant.shopHealthIcon = Constant.graphics.newPixmap(
				"shophealthicon.png", Constant.getWidthPercentage(25),
				Constant.getHeightPercentage(25));
		Constant.shopLauncherIcon = Constant.graphics.newPixmap(
				"shoplaunchericon.png", Constant.getWidthPercentage(25),
				Constant.getHeightPercentage(25));
		Constant.shopShotGunIcon = Constant.graphics.newPixmap(
				"shopshotgunicon.png", Constant.getWidthPercentage(25),
				Constant.getHeightPercentage(25));
		Constant.shopBombIcon = Constant.graphics.newPixmap("shopbombicon.png",
				Constant.getWidthPercentage(25),
				Constant.getHeightPercentage(25));

	}

	private void LOAD_PAUSE_STATE_ICONS() {
		// TODO Auto-generated method stub

		Constant.pauseBackGround = Constant.graphics.newPixmap("pausebg.png",
				Constant.getWidthPercentage(70),
				Constant.getHeightPercentage(70));

		Constant.resumeButton = Constant.graphics.newPixmap("resumebtn.png",
				Constant.getWidthPercentage(30),
				Constant.getHeightPercentage(15));
		Constant.shopButton = Constant.graphics.newPixmap("shopbtn.png",
				Constant.getWidthPercentage(30),
				Constant.getHeightPercentage(15));
		Constant.homeButton = Constant.graphics.newPixmap("homebtn.png",
				Constant.getWidthPercentage(30),
				Constant.getHeightPercentage(15));
		Constant.pauseExitButton = Constant.graphics.newPixmap("exitbtn.png",
				Constant.getWidthPercentage(30),
				Constant.getHeightPercentage(15));

	}

	private void LOAD_GAME_PLAY_ICONS() {
		// TODO Auto-generated method stub

		Constant.heroPassportSize = Constant.graphics.newPixmap(
				"heropassportsize.png", Constant.getWidthPercentage(9),
				Constant.getHeightPercentage(15));
		Constant.heroHealthBar = Constant.graphics.newPixmap("healthbar.png",
				Constant.getWidthPercentage(26),
				Constant.getHeightPercentage(5));
		Constant.heroCoinBar = Constant.graphics.newPixmap("coinbar.png",
				Constant.getWidthPercentage(19),
				Constant.getHeightPercentage(10));
		Constant.iconStrip = Constant.graphics.newPixmap("iconstrip.png",
				Constant.getWidthPercentage(46),
				Constant.getHeightPercentage(17));
		Constant.handGunIcon = Constant.graphics.newPixmap("handgunicon.png",
				Constant.getWidthPercentage(9),
				Constant.getHeightPercentage(15));
		Constant.knifeIcon = Constant.graphics.newPixmap("knifeicon.png",
				Constant.getWidthPercentage(9),
				Constant.getHeightPercentage(15));
		Constant.launcherIcon = Constant.graphics.newPixmap("launchericon.png",
				Constant.getWidthPercentage(9),
				Constant.getHeightPercentage(15));
		Constant.minesIcon = Constant.graphics.newPixmap("minesicon.png",
				Constant.getWidthPercentage(9),
				Constant.getHeightPercentage(15));
		Constant.shotgunIcon = Constant.graphics.newPixmap("shotgunicon.png",
				Constant.getWidthPercentage(9),
				Constant.getHeightPercentage(15));
		Constant.pauseButton = Constant.graphics.newPixmap("pauseicon.png",
				Constant.getWidthPercentage(10),
				Constant.getHeightPercentage(10));

		Constant.heroHandGunLeft = Constant.graphics.newPixmap(
				"hero/herohandgunleft.png", Constant.getWidthPercentage(20),
				Constant.getHeightPercentage(30));
		Constant.heroKnifeLeft = Constant.graphics.newPixmap(
				"hero/heroknifeleft.png", Constant.getWidthPercentage(22),
				Constant.getHeightPercentage(35));
		Constant.herolauncherLeft = Constant.graphics.newPixmap(
				"hero/herolauncherleft.png", Constant.getWidthPercentage(20),
				Constant.getHeightPercentage(30));
		Constant.heromineLeft = Constant.graphics.newPixmap(
				"hero/heromineleft.png", Constant.getWidthPercentage(10),
				Constant.getHeightPercentage(30));
		Constant.heroShotGunLeft = Constant.graphics.newPixmap(
				"hero/heroshotgunleft.png", Constant.getWidthPercentage(22),
				Constant.getHeightPercentage(30));

		Constant.heroHandGunRight = Constant.graphics.newPixmap(
				"hero/herohandgunright.png", Constant.getWidthPercentage(20),
				Constant.getHeightPercentage(30));
		Constant.heroKnifeRight = Constant.graphics.newPixmap(
				"hero/herokniferight.png", Constant.getWidthPercentage(22),
				Constant.getHeightPercentage(35));
		Constant.herolauncherRight = Constant.graphics.newPixmap(
				"hero/herolauncherright.png", Constant.getWidthPercentage(20),
				Constant.getHeightPercentage(30));
		Constant.heromineRight = Constant.graphics.newPixmap(
				"hero/heromineright.png", Constant.getWidthPercentage(10),
				Constant.getHeightPercentage(30));
		Constant.heroShotGunRight = Constant.graphics.newPixmap(
				"hero/heroshotgunright.png", Constant.getWidthPercentage(22),
				Constant.getHeightPercentage(30));

		Constant.Enemy_Type_1_Left_Bitmap_Frame_Walk = Constant.graphics
				.newPixmap("zombie/greenzombiewalkleft.png",
						Constant.getWidthPercentage(72),
						Constant.getHeightPercentage(25));
		Constant.Enemy_Type_1_Right_Bitmap_Frame_Walk = Constant.graphics
				.newPixmap("zombie/greenzombiewalkright.png",
						Constant.getWidthPercentage(72),
						Constant.getHeightPercentage(25));
		Constant.Enemy_Type_1_Left_Bitmap_Frame_Attack = Constant.graphics
				.newPixmap("zombie/greenzombieattackleft.png",
						Constant.getWidthPercentage(42),
						Constant.getHeightPercentage(30));
		Constant.Enemy_Type_1_Right_Bitmap_Frame_Attack = Constant.graphics
				.newPixmap("zombie/greenzombieattackright.png",
						Constant.getWidthPercentage(42),
						Constant.getHeightPercentage(30));
		Constant.Enemy_Type_1_Bitmap_Frame_Dead = Constant.graphics.newPixmap(
				"zombie/greenzombiedead.png", Constant.getWidthPercentage(36),
				Constant.getHeightPercentage(25));

		Constant.Enemy_Type_3_Left_Bitmap_Frame_Walk = Constant.graphics
				.newPixmap("zombie/birjuzombiewalkleft.png",
						Constant.getWidthPercentage(90),
						Constant.getHeightPercentage(30));
		Constant.Enemy_Type_3_Right_Bitmap_Frame_Walk = Constant.graphics
				.newPixmap("zombie/birjuzombiewalkright.png",
						Constant.getWidthPercentage(90),
						Constant.getHeightPercentage(30));
		Constant.Enemy_Type_3_Left_Bitmap_Frame_Attack = Constant.graphics
				.newPixmap("zombie/birjuzombieattackleft.png",
						Constant.getWidthPercentage(36),
						Constant.getHeightPercentage(32));
		Constant.Enemy_Type_3_Right_Bitmap_Frame_Attack = Constant.graphics
				.newPixmap("zombie/birjuzombieattackright.png",
						Constant.getWidthPercentage(36),
						Constant.getHeightPercentage(32));
		Constant.Enemy_Type_3_Bitmap_Frame_Dead = Constant.graphics.newPixmap(
				"zombie/birjuzombiedead.png", Constant.getWidthPercentage(30),
				Constant.getHeightPercentage(30));

		Constant.Enemy_Type_2_Left_Bitmap_Frame_Walk = Constant.graphics
				.newPixmap("zombie/policezombiewalkleft.png",
						Constant.getWidthPercentage(40),
						Constant.getHeightPercentage(25));
		Constant.Enemy_Type_2_Right_Bitmap_Frame_Walk = Constant.graphics
				.newPixmap("zombie/policezombiewalkright.png",
						Constant.getWidthPercentage(40),
						Constant.getHeightPercentage(25));
		Constant.Enemy_Type_2_Left_Bitmap_Frame_Attack = Constant.graphics
				.newPixmap("zombie/policezombieattackleft.png",
						Constant.getWidthPercentage(50),
						Constant.getHeightPercentage(25));
		Constant.Enemy_Type_2_Right_Bitmap_Frame_Attack = Constant.graphics
				.newPixmap("zombie/policezombieattackright.png",
						Constant.getWidthPercentage(50),
						Constant.getHeightPercentage(25));
		Constant.Enemy_Type_2_Left_Bitmap_Frame_Dead = Constant.graphics
				.newPixmap("zombie/policezombiedeadleft.png",
						Constant.getWidthPercentage(50),
						Constant.getHeightPercentage(25));
		Constant.Enemy_Type_2_Right_Bitmap_Frame_Dead = Constant.graphics
				.newPixmap("zombie/policezombiedeadright.png",
						Constant.getWidthPercentage(50),
						Constant.getHeightPercentage(25));

		Constant.Enemy_Type_4_Left_Bitmap_Frame_Walk = Constant.graphics
				.newPixmap("zombie/oldzombiewalkleft.png",
						Constant.getWidthPercentage(50),
						Constant.getHeightPercentage(25));
		Constant.Enemy_Type_4_Right_Bitmap_Frame_Walk = Constant.graphics
				.newPixmap("zombie/oldzombiewalkright.png",
						Constant.getWidthPercentage(50),
						Constant.getHeightPercentage(25));
		Constant.Enemy_Type_4_Left_Bitmap_Frame_Attack = Constant.graphics
				.newPixmap("zombie/oldzombieattackleft.png",
						Constant.getWidthPercentage(48),
						Constant.getHeightPercentage(35));
		Constant.Enemy_Type_4_Right_Bitmap_Frame_Attack = Constant.graphics
				.newPixmap("zombie/oldzombieattackright.png",
						Constant.getWidthPercentage(48),
						Constant.getHeightPercentage(35));
		Constant.Enemy_Type_4_Left_Bitmap_Frame_Dead = Constant.graphics
				.newPixmap("zombie/oldzombiedeadleft.png",
						Constant.getWidthPercentage(50),
						Constant.getHeightPercentage(35));
		Constant.Enemy_Type_4_Right_Bitmap_Frame_Dead = Constant.graphics
				.newPixmap("zombie/oldzombiedeadright.png",
						Constant.getWidthPercentage(50),
						Constant.getHeightPercentage(35));

		Constant.Enemy_Type_5_Left_Bitmap_Frame_Walk = Constant.graphics
				.newPixmap("zombie/dogwalkleft.png",
						Constant.getWidthPercentage(192),
						Constant.getHeightPercentage(20));
		Constant.Enemy_Type_5_Right_Bitmap_Frame_Walk = Constant.graphics
				.newPixmap("zombie/dogwalkright.png",
						Constant.getWidthPercentage(192),
						Constant.getHeightPercentage(20));
		Constant.Enemy_Type_5_Left_Bitmap_Frame_Attack = Constant.graphics
				.newPixmap("zombie/dogattackleft.png",
						Constant.getWidthPercentage(39),
						Constant.getHeightPercentage(25));
		Constant.Enemy_Type_5_Right_Bitmap_Frame_Attack = Constant.graphics
				.newPixmap("zombie/dogattackright.png",
						Constant.getWidthPercentage(39),
						Constant.getHeightPercentage(25));
		Constant.Enemy_Type_5_Left_Bitmap_Frame_Dead = Constant.graphics
				.newPixmap("zombie/dogdeadleft.png",
						Constant.getWidthPercentage(48),
						Constant.getHeightPercentage(20));
		Constant.Enemy_Type_5_Right_Bitmap_Frame_Dead = Constant.graphics
				.newPixmap("zombie/dogdeadright.png",
						Constant.getWidthPercentage(48),
						Constant.getHeightPercentage(20));

		Constant.mine = Constant.graphics
				.newPixmap("bomb.png", Constant.getWidthPercentage(3),
						Constant.getHeightPercentage(3));

		Constant.blastLauncher = Constant.graphics.newPixmap(
				"blastlauncher.png", Constant.getWidthPercentage(464),
				Constant.getHeightPercentage(16));

	}

	private void LOAD_MAIN_MENU_RESOURCE() {
		// TODO Auto-generated method stub
		Constant.backGroundleft = Constant.graphics.newPixmap("bg1.png",
				Constant.getWidthPercentage(50),
				Constant.getHeightPercentage(100));
		Constant.backGroundright = Constant.graphics.newPixmap("bg2.png",
				Constant.getWidthPercentage(50),
				Constant.getHeightPercentage(100));
		Constant.menuGirl = Constant.graphics.newPixmap("menu/menugirl.png",
				Constant.getWidthPercentage(100),
				Constant.getHeightPercentage(100));
		Constant.playButton = Constant.graphics.newPixmap("menu/menustart.png",
				Constant.getWidthPercentage(25),
				Constant.getHeightPercentage(10));
		Constant.soundButton = Constant.graphics.newPixmap(
				"menu/menusoundon.png", Constant.getWidthPercentage(25),
				Constant.getHeightPercentage(10));
		Constant.exitButton = Constant.graphics.newPixmap("menu/menuexit.png",
				Constant.getWidthPercentage(25),
				Constant.getHeightPercentage(10));

	}

	private void LOAD_SPLASH_RESOURCE() {
		// TODO Auto-generated method stub

		Constant.logo = Constant.graphics.newPixmap("menu/gamename.png",
				Constant.getWidthPercentage(60),
				Constant.getHeightPercentage(12));
		Constant.splashmain = Constant.graphics.newPixmap("menu/splash.png",
				Constant.getWidthPercentage(100),
				Constant.getHeightPercentage(100));
		Constant.splashleft = Constant.graphics.newPixmap("menu/splashbg1.png",
				Constant.getWidthPercentage(50),
				Constant.getHeightPercentage(100));
		Constant.splashright = Constant.graphics.newPixmap(
				"menu/splashbg2.png", Constant.getWidthPercentage(50),
				Constant.getHeightPercentage(100));
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		while (Constant.running) {
			if (!Constant.surfaceholder.getSurface().isValid())
				continue;

			Constant.canvas = Constant.surfaceholder.lockCanvas();
			runUpdate();
			draw(Constant.graphics);
			if (!Constant.particleVector.isEmpty()) {
				for (int i = 0; i < Constant.particleVector.size(); i++) {
					Constant.particleVector.elementAt(i).nextStep();
				}
			}

			Constant.surfaceholder.unlockCanvasAndPost(Constant.canvas);
			try {
				Constant.rendorthread.sleep(75);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	private void runUpdate() {
		// TODO Auto-generated method stub
		if (Constant.getCurrent_State() == Constant.state_Logo) {
			if ((System.currentTimeMillis() - Constant.veryStartTime) > Constant.logoDelayTime) {
				Constant.setCurrent_State(Constant.state_Splash);
			}
		}
		if (Constant.getCurrent_State() == Constant.state_Splash) {
			if ((System.currentTimeMillis() - Constant.veryStartTime) > Constant.splashDelayTime) {
				Constant.setCurrent_State(Constant.state_Menu);
			}
		}
	}

	private void draw(AndroidGraphics g) {
		// TODO Auto-generated method stub
		switch (Constant.current_State) {
		case Constant.state_Logo:
			g.drawBitmap(Constant.logo, Constant.getWidthPercentage(20),
					Constant.getHeightPercentage(44));
			break;
		case Constant.state_Menu:
			g.drawBitmap(Constant.splashleft, Constant.getWidthPercentage(0),
					Constant.getHeightPercentage(0));
			g.drawBitmap(Constant.splashright, Constant.getWidthPercentage(50),
					Constant.getHeightPercentage(0));
			g.drawBitmap(Constant.menuGirl, Constant.getWidthPercentage(0),
					Constant.getHeightPercentage(0));
			g.drawBitmap(Constant.playButton, Constant.playButtonX,
					Constant.playButtonY);
			g.drawBitmap(Constant.soundButton, Constant.soundButtonX,
					Constant.soundButtonY);
			g.drawBitmap(Constant.exitButton, Constant.exitButtonX,
					Constant.exitButtonY);

			break;
		case Constant.state_GamePlay:

			g.drawBitmap(Constant.backGroundleft,
					Constant.getWidthPercentage(0),
					Constant.getHeightPercentage(0));
			g.drawBitmap(Constant.backGroundright,
					Constant.getWidthPercentage(50),
					Constant.getHeightPercentage(0));

			drawGamePlayButtons(g);

			g.drawBitmap(Constant.heroPassportSize,
					Constant.passport_size_photo_X,
					Constant.passport_size_photo_Y);

			drawHeroHealth(g);

			g.drawBitmap(Constant.heroHealthBar, Constant.health_bar_X,
					Constant.health_bar_Y);
			g.drawBitmap(Constant.heroCoinBar, Constant.coin_bar_X,
					Constant.coin_bar_Y);

			drawHeroFrame(g);

			checkCollisionBulets(g);

			if (!Constant.particleVector.isEmpty()) {
				for (int i = 0; i < Constant.particleVector.size(); i++) {
					Constant.particleVector.elementAt(i).paint(g);
					if (Constant.particleVector.elementAt(i).totalParticleStep == Constant.particleVector
							.elementAt(i).particleStep) {
						Constant.particleVector.removeElementAt(i);
					}
				}
			}

			drawMines(g);
			drawLauncherGranede(g);
			drawEnemy(g);
			enemyUpdate();
			drawMoney(g);
			checkWinLoseState();
			checkWhichWaveIsComing();
			if (Constant.hero.whichWeaponIsSelected == Constant.knife_selected) {
				drawKnifeRect(g);
			}

			break;
		case Constant.state_Splash:
			g.drawBitmap(Constant.splashleft, Constant.getWidthPercentage(0),
					Constant.getHeightPercentage(0));
			g.drawBitmap(Constant.splashright, Constant.getWidthPercentage(50),
					Constant.getHeightPercentage(0));
			g.drawBitmap(Constant.splashmain, Constant.getWidthPercentage(0),
					Constant.getHeightPercentage(0));
			break;

		case Constant.state_Pause:
			g.drawBitmap(Constant.splashleft, Constant.getWidthPercentage(0),
					Constant.getHeightPercentage(0));
			g.drawBitmap(Constant.splashright, Constant.getWidthPercentage(50),
					Constant.getHeightPercentage(0));
			g.drawBitmap(Constant.pauseBackGround,
					Constant.getWidthPercentage(15),
					Constant.getHeightPercentage(15));
			g.drawBitmap(Constant.resumeButton, Constant.resumeButtonX,
					Constant.resumeButtonY);
			g.drawBitmap(Constant.shopButton, Constant.shopButtonX,
					Constant.shopButtonY);
			g.drawBitmap(Constant.homeButton, Constant.homeButtonX,
					Constant.homeButtonY);
			g.drawBitmap(Constant.pauseExitButton, Constant.pauseExitButtonX,
					Constant.pauseExitButtonY);
			break;

		case Constant.state_shop:
			g.drawBitmap(Constant.shopBackGround,
					Constant.getWidthPercentage(0),
					Constant.getHeightPercentage(0));
			g.drawBitmap(Constant.shopHeading, Constant.getWidthPercentage(0),
					Constant.getHeightPercentage(0));
			g.drawBitmap(Constant.shopTotalStrip, Constant.shopTotalStripX,
					Constant.shopTotalStripY);
			g.drawBitmap(Constant.shopShowCase, Constant.getWidthPercentage(0),
					Constant.getHeightPercentage(20));
			g.drawBitmap(Constant.shopItemScreen,
					Constant.getWidthPercentage(58),
					Constant.getHeightPercentage(25));
			g.drawBitmap(Constant.shopPriceTag,
					Constant.getWidthPercentage(58),
					Constant.getHeightPercentage(70));
			g.drawBitmap(Constant.shopBuyButton, Constant.shopBuyButtonX,
					Constant.shopBuyButtonY);
			g.drawBitmap(Constant.shopBackButton, Constant.shopBackButtonX,
					Constant.shopBackButtonY);
			g.drawBitmap(Constant.shopHealthIcon, Constant.shopHealthIconX,
					Constant.shopHealthIconY);
			g.drawBitmap(Constant.shopLauncherIcon, Constant.shopLauncherIconX,
					Constant.shopLauncherIconY);
			g.drawBitmap(Constant.shopShotGunIcon, Constant.shopShotGunIconX,
					Constant.shopShotGunIconY);
			g.drawBitmap(Constant.shopBombIcon, Constant.shopBombIconX,
					Constant.shopBombIconY);
			drawWeaponIcon(g);
			break;

		case Constant.state_Level_Loader:
			g.drawBitmap(Constant.backGroundleft,
					Constant.getWidthPercentage(0),
					Constant.getHeightPercentage(0));
			g.drawBitmap(Constant.backGroundright,
					Constant.getWidthPercentage(50),
					Constant.getHeightPercentage(0));
			g.drawText("Next Wave is Coming",
					(Constant.getWidthPercentage(100) - g.getStringWidth(
							"Next Wave is Coming",
							Constant.getWidthPercentage(3))) / 2, Constant
							.getHeightPercentage(50), Color.WHITE, Constant
							.getWidthPercentage(3));
			g.drawText("Tap Screen to Continue",
					(Constant.getWidthPercentage(100) - g.getStringWidth(
							"Tap Screen to Continue",
							Constant.getWidthPercentage(3))) / 2, Constant
							.getHeightPercentage(60), Color.WHITE, Constant
							.getWidthPercentage(3));
			break;

		case Constant.state_GameOver:
			g.drawBitmap(Constant.splashleft, Constant.getWidthPercentage(0),
					Constant.getHeightPercentage(0));
			g.drawBitmap(Constant.splashright, Constant.getWidthPercentage(50),
					Constant.getHeightPercentage(0));
			g.drawBitmap(Constant.gameOverBitmap, (Constant
					.getWidthPercentage(100) - Constant.gameOverBitmap
					.getWidth()) / 2, Constant.getHeightPercentage(5));
			g.drawBitmap(
					Constant.totalWinLoseBitmap,
					(Constant.getWidthPercentage(100) - Constant.totalWinLoseBitmap
							.getWidth()) / 2,
					(Constant.getHeightPercentage(100) - Constant.totalWinLoseBitmap
							.getHeight()) / 2);
			g.drawBitmap(Constant.replaybtn, Constant.loseStateReplayBtn_X,
					Constant.loseStateReplayBtn_Y);
			g.drawBitmap(Constant.homebtn, Constant.loseStateHomeBtn_X,
					Constant.loseStateHomeBtn_Y);
			g.drawText(
					"" + Constant.total_Money,
					((Constant.getWidthPercentage(100) - Constant.totalWinLoseBitmap
							.getWidth()) / 2)
							+ Constant.totalWinLoseBitmap.getWidth()
							+ Constant.getWidthPercentage(3),
					((Constant.getHeightPercentage(100) - Constant.totalWinLoseBitmap
							.getHeight()) / 2)
							+ Constant.getHeightPercentage(8), Color.WHITE,
					Constant.getWidthPercentage(7));

			break;

		case Constant.state_win:
			g.drawBitmap(Constant.splashleft, Constant.getWidthPercentage(0),
					Constant.getHeightPercentage(0));
			g.drawBitmap(Constant.splashright, Constant.getWidthPercentage(50),
					Constant.getHeightPercentage(0));
			g.drawBitmap(Constant.gameWinBitmap, (Constant
					.getWidthPercentage(100) - Constant.gameWinBitmap
					.getWidth()) / 2, Constant.getHeightPercentage(5));
			g.drawBitmap(
					Constant.totalWinLoseBitmap,
					(Constant.getWidthPercentage(100) - Constant.totalWinLoseBitmap
							.getWidth()) / 2,
					(Constant.getHeightPercentage(100) - Constant.totalWinLoseBitmap
							.getHeight()) / 2);
			g.drawBitmap(Constant.replaybtn, Constant.winStateReplayBtn_X,
					Constant.winStateReplayBtn_Y);
			g.drawBitmap(Constant.homebtn, Constant.winStateHomeBtn_X,
					Constant.winStateHomeBtn_Y);
			g.drawText(
					"" + Constant.total_Money,
					((Constant.getWidthPercentage(100) - Constant.totalWinLoseBitmap
							.getWidth()) / 2)
							+ Constant.totalWinLoseBitmap.getWidth()
							+ Constant.getWidthPercentage(3),
					((Constant.getHeightPercentage(100) - Constant.totalWinLoseBitmap
							.getHeight()) / 2)
							+ Constant.getHeightPercentage(8), Color.WHITE,
					Constant.getWidthPercentage(7));

			break;
		default:
			break;
		}

	}

	private void drawGamePlayButtons(AndroidGraphics g) {
		// TODO Auto-generated method stub
		g.drawBitmap(Constant.iconStrip, Constant.getWidthPercentage(0),
				Constant.getHeightPercentage(0));
		g.drawBitmap(Constant.pauseButton, Constant.pauseButtonX,
				Constant.pauseButtonY);
		g.drawBitmap(Constant.handGunIcon, Constant.handGunIconX,
				Constant.handGunIconY);
		g.drawBitmap(Constant.knifeIcon, Constant.knifeIconX,
				Constant.knifeIconY);
		g.drawBitmap(Constant.launcherIcon, Constant.launcherIconX,
				Constant.launcherIconY);
		g.drawBitmap(Constant.minesIcon, Constant.minesIconX,
				Constant.minesIconY);
		g.drawBitmap(Constant.shotgunIcon, Constant.shotgunIconX,
				Constant.shotgunIconY);

		g.drawText("" + Constant.number_Of_Launcher,
				Constant.launcherIconX + Constant.launcherIcon.getWidth()
						- Constant.getWidthPercentage(3),
				Constant.launcherIconY + Constant.launcherIcon.getHeight()
						- Constant.getHeightPercentage(2), Color.WHITE,
				Constant.getWidthPercentage(2));
		g.drawText("" + Constant.number_Of_Shotgun_Emmo,
				Constant.shotgunIconX + Constant.shotgunIcon.getWidth()
						- Constant.getWidthPercentage(3),
				Constant.shotgunIconY + Constant.shotgunIcon.getHeight()
						- Constant.getHeightPercentage(2), Color.WHITE,
				Constant.getWidthPercentage(2));
		g.drawText(
				"" + Constant.number_Of_mines,
				Constant.minesIconX + Constant.minesIcon.getWidth()
						- Constant.getWidthPercentage(3),
				Constant.minesIconY + Constant.minesIcon.getHeight()
						- Constant.getHeightPercentage(2), Color.WHITE,
				Constant.getWidthPercentage(2));

	}

	private void checkWhichWaveIsComing() {
		// TODO Auto-generated method stub
		if (Constant.enemyVectorLeft.isEmpty()
				&& Constant.enemyVectorRight.isEmpty()) {
			if (Constant.current_Level <= 1) {
				Constant.setCurrent_State(Constant.state_Level_Loader);
			} else {
				Constant.setCurrent_State(Constant.state_win);
			}
		}
	}

	private void checkWinLoseState() {
		// TODO Auto-generated method stub
		if (Constant.hero.getHealth() < 1) {
			Constant.setCurrent_State(Constant.state_GameOver);
		}

	}

	private void drawKnifeRect(AndroidGraphics g) {
		// TODO Auto-generated method stub
		g.drawRect(
				Constant.leftKnifeRectangleX,
				Constant.leftKnifeRectangleY,
				Constant.leftKnifeRectangleX + Constant.leftKnifeRectangleWidth,
				Constant.leftKnifeRectangleY
						+ Constant.leftKnifeRectangleHeight,
				Color.argb(20, 255, 0, 0));
		g.drawRect(Constant.rightKnifeRectangleX,
				Constant.rightKnifeRectangleY, Constant.rightKnifeRectangleX
						+ Constant.rightKnifeRectangleWidth,
				Constant.rightKnifeRectangleY
						+ Constant.rightknifeRectangleHeight,
				Color.argb(20, 255, 0, 0));
	}

	private void drawMoney(AndroidGraphics g) {
		// TODO Auto-generated method stub
		g.drawText(
				"" + Constant.total_Money,
				(Constant.coin_bar_X + Constant.heroCoinBar.getWidth())
						- Constant.heroCoinBar.getWidth() / 2,
				Constant.coin_bar_Y
						+ Constant.getHeightPercentage(4)
						+ (Constant.heroCoinBar.getHeight() - Constant
								.getHeightPercentage(5)) / 2, Color.WHITE,
				Constant.getHeightPercentage(5));

	}

	private void drawHeroHealth(AndroidGraphics g) {
		// TODO Auto-generated method stub
		g.drawRect(Constant.health_bar_X, Constant.health_bar_Y,
				Constant.health_bar_X + Constant.hero.getHealth(),
				Constant.health_bar_Y + Constant.heroHealthBar.getHeight(),
				Color.GREEN);

	}

	private void drawLauncherGranede(AndroidGraphics g) {
		// TODO Auto-generated method stub
		if (!Constant.launcherVector.isEmpty()) {
			for (int i = 0; i < Constant.launcherVector.size(); i++) {
				if (Constant.launcherVector.elementAt(i).pointX > Constant.launcherVector
						.elementAt(i).bullet_X) {
					if (Constant.launcherVector.elementAt(i).getY() < (Constant
							.getHeightPercentage(75))) {
						Constant.launcherVector.elementAt(i).moveBulletRight();
					}
				}

				if (Constant.launcherVector.elementAt(i).pointX < Constant.launcherVector
						.elementAt(i).bullet_X) {
					if (Constant.launcherVector.elementAt(i).getY() < Constant
							.getHeightPercentage(75)) {
						Constant.launcherVector.elementAt(i).moveBulletLeft();
					}
				}

				if (Constant.launcherVector.elementAt(i).getY() < Constant
						.getHeightPercentage(75)) {
					g.drawCircle(
							(float) Constant.launcherVector.elementAt(i).getX(),
							(float) Constant.launcherVector.elementAt(i).getY(),
							5, Color.BLACK);
				} else if (Constant.launcherVector.elementAt(i).getY() >= Constant
						.getHeightPercentage(75)) {
					g.drawBitmap(
							Constant.blastLauncher,
							new Rect(
									Constant.launcherVector.elementAt(i).blastFrameCounter
											* (Constant.blastLauncher
													.getWidth() / Constant.no_of_blast_Frame),
									0,
									(Constant.launcherVector.elementAt(i).blastFrameCounter + 1)
											* (Constant.blastLauncher
													.getWidth() / Constant.no_of_blast_Frame),
									Constant.blastLauncher.getHeight()),
							new Rect(
									(int) Constant.launcherVector.elementAt(i)
											.getX()
											- (Constant.blastLauncher
													.getWidth() / Constant.no_of_blast_Frame)
											/ 2,
									(int) (Constant.getHeightPercentage(75) - Constant.blastLauncher
											.getHeight() / 2),
									(int) ((int) (Constant.launcherVector
											.elementAt(i).getX() - (Constant.blastLauncher
											.getWidth() / Constant.no_of_blast_Frame) / 2) + Constant.blastLauncher
											.getWidth()
											/ Constant.no_of_blast_Frame),
									(int) (Constant.getHeightPercentage(75) - Constant.blastLauncher
											.getHeight() / 2)
											+ Constant.blastLauncher
													.getHeight()));

					if (Constant.launcherVector.elementAt(i).blastFrameCounter > 2) {
						if (Constant.launcherVector.elementAt(i).isLauncherSoundPlaying) {
							Constant.launcherVector.elementAt(i).launcherBlastSound
									.start();
							checkLauncherCollision(Constant.launcherVector
									.elementAt(i));
							Constant.launcherVector.elementAt(i).isLauncherSoundPlaying = false;
						}

					}
					Constant.launcherVector.elementAt(i).blastFrameCounter++;
					if (Constant.launcherVector.elementAt(i).blastFrameCounter > (Constant.no_of_blast_Frame - 1)) {
						Constant.launcherVector.removeElementAt(i);
					}
				}
			}

		}
	}

	private void drawMines(AndroidGraphics g) {
		// TODO Auto-generated method stub
		if (!Constant.minesVector.isEmpty()) {
			for (int i = 0; i < Constant.minesVector.size(); i++) {
				Mines tempMines = (Mines) Constant.minesVector.elementAt(i);
				if (System.currentTimeMillis()
						- tempMines.getMine_time_of_plant() < 5000) {
					g.drawBitmap(Constant.mine, tempMines.getX(),
							tempMines.getY());
				} else {
					g.drawBitmap(
							Constant.blastLauncher,
							new Rect(
									tempMines.mine_blast_frame_counter
											* (Constant.blastLauncher
													.getWidth() / Constant.no_of_blast_Frame),
									0,
									(tempMines.mine_blast_frame_counter + 1)
											* (Constant.blastLauncher
													.getWidth() / Constant.no_of_blast_Frame),
									Constant.blastLauncher.getHeight()),
							new Rect(
									(int) tempMines.getX()
											- (Constant.blastLauncher
													.getWidth() / Constant.no_of_blast_Frame)
											/ 2,
									(int) (tempMines.getY() - Constant.blastLauncher
											.getHeight() / 2),
									(int) ((int) tempMines.getX() - (Constant.blastLauncher
											.getWidth() / Constant.no_of_blast_Frame) / 2)
											+ (Constant.blastLauncher
													.getWidth() / Constant.no_of_blast_Frame),
									(int) (tempMines.getY() - Constant.blastLauncher
											.getHeight() / 2)
											+ Constant.blastLauncher
													.getHeight()));
					tempMines.mine_blast_frame_counter++;
					if (tempMines.mine_blast_frame_counter > 2) {
						if (tempMines.ismineblastsoundplaying) {
							tempMines.minesblastsound.start();
							checkMinesCollision(tempMines);
							tempMines.ismineblastsoundplaying = false;
						}
					}

					if (tempMines.mine_blast_frame_counter > (Constant.no_of_blast_Frame - 1)) {
						Constant.minesVector.removeElementAt(i);
					}
				}
			}
		}

	}

	private void checkMinesCollision(Mines bullet) {
		// TODO Auto-generated method stub
		int bullet_left_top_X = (int) (bullet.getX() - Constant.blastLauncher
				.getWidth() / Constant.no_of_blast_Frame / 2);
		int bullet_left_top_Y = (int) (bullet.getY() - (Constant.blastLauncher
				.getHeight() / 2));
		int bullet_right_top_X = (int) (bullet.getX()
				- (Constant.blastLauncher.getWidth()
						/ Constant.no_of_blast_Frame / 2) + Constant.blastLauncher
				.getWidth() / Constant.no_of_blast_Frame);
		int bullet_right_top_Y = (int) (bullet.getY() - (Constant.blastLauncher
				.getHeight() / 2));

		int bullet_left_down_X = (int) (bullet.getX() - Constant.blastLauncher
				.getWidth() / Constant.no_of_blast_Frame / 2);
		int bullet_left_down_Y = (int) ((bullet.getY() - (Constant.blastLauncher
				.getHeight() / 2)) + Constant.blastLauncher.getHeight());
		int bullet_right_down_X = (int) (bullet.getX()
				- (Constant.blastLauncher.getWidth()
						/ Constant.no_of_blast_Frame / 2) + Constant.blastLauncher
				.getWidth() / Constant.no_of_blast_Frame);
		int bullet_right_down_Y = (int) ((bullet.getY() - (Constant.blastLauncher
				.getHeight() / 2)) + Constant.blastLauncher.getHeight());

		if (bullet.getX() < Constant.hero.getHero_x()) {
			for (int i = 0; i < Constant.enemyVectorLeft.size(); i++) {
				Enemy tempEnemy = (Enemy) Constant.enemyVectorLeft.elementAt(i);

				if (bullet_left_top_X >= tempEnemy.getEnemy_X()
						&& bullet_left_top_X <= (tempEnemy.getEnemy_X() + tempEnemy
								.getEnemy_Width())
						&& bullet_left_top_Y >= tempEnemy.getEnemy_Y()
						&& bullet_left_top_Y <= (tempEnemy.getEnemy_Y() + tempEnemy
								.getEnemy_Height())) {
					checkEnemyHealth(tempEnemy, 0, Constant.minesAttack);
				} else if (bullet_right_top_X >= tempEnemy.getEnemy_X()
						&& bullet_right_top_X <= (tempEnemy.getEnemy_X() + tempEnemy
								.getEnemy_Width())
						&& bullet_right_top_Y >= tempEnemy.getEnemy_Y()
						&& bullet_right_top_Y <= (tempEnemy.getEnemy_Y() + tempEnemy
								.getEnemy_Height())) {
					checkEnemyHealth(tempEnemy, 0, Constant.minesAttack);

				} else if (bullet_left_down_X >= tempEnemy.getEnemy_X()
						&& bullet_left_down_X <= (tempEnemy.getEnemy_X() + tempEnemy
								.getEnemy_Width())
						&& bullet_left_down_Y >= tempEnemy.getEnemy_Y()
						&& bullet_left_down_Y <= (tempEnemy.getEnemy_Y() + tempEnemy
								.getEnemy_Height())) {
					checkEnemyHealth(tempEnemy, 0, Constant.minesAttack);
				} else if (bullet_right_down_X >= tempEnemy.getEnemy_X()
						&& bullet_right_down_X <= (tempEnemy.getEnemy_X() + tempEnemy
								.getEnemy_Width())
						&& bullet_right_down_Y >= tempEnemy.getEnemy_Y()
						&& bullet_right_down_Y <= (tempEnemy.getEnemy_Y() + tempEnemy
								.getEnemy_Height())) {
					checkEnemyHealth(tempEnemy, 0, Constant.minesAttack);

				} else if (bullet_left_top_X <= tempEnemy.getEnemy_X()
						&& bullet_left_top_Y >= tempEnemy.getEnemy_Y()
						&& bullet_left_down_X <= tempEnemy.getEnemy_X()
						&& bullet_left_down_Y <= (tempEnemy.getEnemy_Y() + tempEnemy
								.getEnemy_Height())
						&& bullet_right_top_X >= (tempEnemy.getEnemy_X() + tempEnemy
								.getEnemy_Width())
						&& bullet_right_top_Y <= tempEnemy.getEnemy_Y()
						&& bullet_right_down_X >= (tempEnemy.getEnemy_X() + tempEnemy
								.getEnemy_Width())
						&& bullet_right_down_Y <= (tempEnemy.getEnemy_Y() + tempEnemy
								.getEnemy_Height())) {
					checkEnemyHealth(tempEnemy, 0, Constant.minesAttack);
				} else if (bullet_left_top_X <= tempEnemy.getEnemy_X()
						&& bullet_left_top_Y <= tempEnemy.getEnemy_Y()
						&& bullet_left_down_X <= tempEnemy.getEnemy_X()
						&& bullet_left_down_Y >= tempEnemy.getEnemy_Y()
						&& bullet_right_top_X >= (tempEnemy.getEnemy_X() + tempEnemy
								.getEnemy_Width())
						&& bullet_right_top_Y <= tempEnemy.getEnemy_Y()
						&& bullet_right_down_X >= (tempEnemy.getEnemy_X() + tempEnemy
								.getEnemy_Width())
						&& bullet_right_down_Y >= tempEnemy.getEnemy_Y()) {
					checkEnemyHealth(tempEnemy, 0, Constant.minesAttack);
				} else if (bullet_left_top_X <= tempEnemy.getEnemy_X()
						&& bullet_left_top_Y <= (tempEnemy.getEnemy_Y() + tempEnemy
								.getEnemy_Height())
						&& bullet_left_down_X <= tempEnemy.getEnemy_X()
						&& bullet_left_down_Y >= (tempEnemy.getEnemy_Y() + tempEnemy
								.getEnemy_Height())
						&& bullet_right_top_X >= (tempEnemy.getEnemy_X() + tempEnemy
								.getEnemy_Width())
						&& bullet_right_top_Y <= (tempEnemy.getEnemy_Y() + tempEnemy
								.getEnemy_Height())
						&& bullet_right_down_X >= (tempEnemy.getEnemy_X() + tempEnemy
								.getEnemy_Width())
						&& bullet_right_down_Y >= (tempEnemy.getEnemy_Y() + tempEnemy
								.getEnemy_Height())) {
					checkEnemyHealth(tempEnemy, 0, Constant.minesAttack);
				}
				// ---------------------------
			}
		}

		if (bullet.getX() > (Constant.hero.getHero_x() + Constant.heromineRight
				.getWidth())) {
			for (int i = 0; i < Constant.enemyVectorRight.size(); i++) {
				Enemy tempEnemy = (Enemy) Constant.enemyVectorRight
						.elementAt(i);

				if (bullet_left_top_X >= tempEnemy.getEnemy_X()
						&& bullet_left_top_X <= (tempEnemy.getEnemy_X() + tempEnemy
								.getEnemy_Width())
						&& bullet_left_top_Y >= tempEnemy.getEnemy_Y()
						&& bullet_left_top_Y <= (tempEnemy.getEnemy_Y() + tempEnemy
								.getEnemy_Height())) {
					checkEnemyHealth(tempEnemy, 0, Constant.minesAttack);
				} else if (bullet_right_top_X >= tempEnemy.getEnemy_X()
						&& bullet_right_top_X <= (tempEnemy.getEnemy_X() + tempEnemy
								.getEnemy_Width())
						&& bullet_right_top_Y >= tempEnemy.getEnemy_Y()
						&& bullet_right_top_Y <= (tempEnemy.getEnemy_Y() + tempEnemy
								.getEnemy_Height())) {
					checkEnemyHealth(tempEnemy, 0, Constant.minesAttack);

				} else if (bullet_left_down_X >= tempEnemy.getEnemy_X()
						&& bullet_left_down_X <= (tempEnemy.getEnemy_X() + tempEnemy
								.getEnemy_Width())
						&& bullet_left_down_Y >= tempEnemy.getEnemy_Y()
						&& bullet_left_down_Y <= (tempEnemy.getEnemy_Y() + tempEnemy
								.getEnemy_Height())) {
					checkEnemyHealth(tempEnemy, 0, Constant.minesAttack);
				} else if (bullet_right_down_X >= tempEnemy.getEnemy_X()
						&& bullet_right_down_X <= (tempEnemy.getEnemy_X() + tempEnemy
								.getEnemy_Width())
						&& bullet_right_down_Y >= tempEnemy.getEnemy_Y()
						&& bullet_right_down_Y <= (tempEnemy.getEnemy_Y() + tempEnemy
								.getEnemy_Height())) {
					checkEnemyHealth(tempEnemy, 0, Constant.minesAttack);

				} else if (bullet_left_top_X <= tempEnemy.getEnemy_X()
						&& bullet_left_top_Y >= tempEnemy.getEnemy_Y()
						&& bullet_left_down_X <= tempEnemy.getEnemy_X()
						&& bullet_left_down_Y <= (tempEnemy.getEnemy_Y() + tempEnemy
								.getEnemy_Height())
						&& bullet_right_top_X >= (tempEnemy.getEnemy_X() + tempEnemy
								.getEnemy_Width())
						&& bullet_right_top_Y <= tempEnemy.getEnemy_Y()
						&& bullet_right_down_X >= (tempEnemy.getEnemy_X() + tempEnemy
								.getEnemy_Width())
						&& bullet_right_down_Y <= (tempEnemy.getEnemy_Y() + tempEnemy
								.getEnemy_Height())) {
					checkEnemyHealth(tempEnemy, 0, Constant.minesAttack);
				} else if (bullet_left_top_X <= tempEnemy.getEnemy_X()
						&& bullet_left_top_Y <= tempEnemy.getEnemy_Y()
						&& bullet_left_down_X <= tempEnemy.getEnemy_X()
						&& bullet_left_down_Y >= tempEnemy.getEnemy_Y()
						&& bullet_right_top_X >= (tempEnemy.getEnemy_X() + tempEnemy
								.getEnemy_Width())
						&& bullet_right_top_Y <= tempEnemy.getEnemy_Y()
						&& bullet_right_down_X >= (tempEnemy.getEnemy_X() + tempEnemy
								.getEnemy_Width())
						&& bullet_right_down_Y >= tempEnemy.getEnemy_Y()) {
					checkEnemyHealth(tempEnemy, 0, Constant.minesAttack);
				} else if (bullet_left_top_X <= tempEnemy.getEnemy_X()
						&& bullet_left_top_Y <= (tempEnemy.getEnemy_Y() + tempEnemy
								.getEnemy_Height())
						&& bullet_left_down_X <= tempEnemy.getEnemy_X()
						&& bullet_left_down_Y >= (tempEnemy.getEnemy_Y() + tempEnemy
								.getEnemy_Height())
						&& bullet_right_top_X >= (tempEnemy.getEnemy_X() + tempEnemy
								.getEnemy_Width())
						&& bullet_right_top_Y <= (tempEnemy.getEnemy_Y() + tempEnemy
								.getEnemy_Height())
						&& bullet_right_down_X >= (tempEnemy.getEnemy_X() + tempEnemy
								.getEnemy_Width())
						&& bullet_right_down_Y >= (tempEnemy.getEnemy_Y() + tempEnemy
								.getEnemy_Height())) {
					checkEnemyHealth(tempEnemy, 0, Constant.minesAttack);
				}
				// ---------------------------
			}
		}

	}

	private void checkLauncherCollision(Bullet bullet) {
		// TODO Auto-generated method stub
		int bullet_left_top_X = (int) (bullet.getX() - Constant.blastLauncher
				.getWidth() / Constant.no_of_blast_Frame / 2);
		int bullet_left_top_Y = (int) (bullet.getY() - (Constant.blastLauncher
				.getHeight() / 2));
		int bullet_right_top_X = (int) (bullet.getX()
				- (Constant.blastLauncher.getWidth()
						/ Constant.no_of_blast_Frame / 2) + Constant.blastLauncher
				.getWidth() / Constant.no_of_blast_Frame);
		int bullet_right_top_Y = (int) (bullet.getY() - (Constant.blastLauncher
				.getHeight() / 2));

		int bullet_left_down_X = (int) (bullet.getX() - Constant.blastLauncher
				.getWidth() / Constant.no_of_blast_Frame / 2);
		int bullet_left_down_Y = (int) ((bullet.getY() - (Constant.blastLauncher
				.getHeight() / 2)) + Constant.blastLauncher.getHeight());
		int bullet_right_down_X = (int) (bullet.getX()
				- (Constant.blastLauncher.getWidth()
						/ Constant.no_of_blast_Frame / 2) + Constant.blastLauncher
				.getWidth() / Constant.no_of_blast_Frame);
		int bullet_right_down_Y = (int) ((bullet.getY() - (Constant.blastLauncher
				.getHeight() / 2)) + Constant.blastLauncher.getHeight());

		if (bullet.getX() < Constant.hero.getHero_x()) {
			for (int i = 0; i < Constant.enemyVectorLeft.size(); i++) {
				Enemy tempEnemy = (Enemy) Constant.enemyVectorLeft.elementAt(i);

				if (bullet_left_top_X >= tempEnemy.getEnemy_X()
						&& bullet_left_top_X <= (tempEnemy.getEnemy_X() + tempEnemy
								.getEnemy_Width())
						&& bullet_left_top_Y >= tempEnemy.getEnemy_Y()
						&& bullet_left_top_Y <= (tempEnemy.getEnemy_Y() + tempEnemy
								.getEnemy_Height())) {
					checkEnemyHealth(tempEnemy, 0, Constant.LauncherAttack);
				} else if (bullet_right_top_X >= tempEnemy.getEnemy_X()
						&& bullet_right_top_X <= (tempEnemy.getEnemy_X() + tempEnemy
								.getEnemy_Width())
						&& bullet_right_top_Y >= tempEnemy.getEnemy_Y()
						&& bullet_right_top_Y <= (tempEnemy.getEnemy_Y() + tempEnemy
								.getEnemy_Height())) {
					checkEnemyHealth(tempEnemy, 0, Constant.LauncherAttack);

				} else if (bullet_left_down_X >= tempEnemy.getEnemy_X()
						&& bullet_left_down_X <= (tempEnemy.getEnemy_X() + tempEnemy
								.getEnemy_Width())
						&& bullet_left_down_Y >= tempEnemy.getEnemy_Y()
						&& bullet_left_down_Y <= (tempEnemy.getEnemy_Y() + tempEnemy
								.getEnemy_Height())) {
					checkEnemyHealth(tempEnemy, 0, Constant.LauncherAttack);
				} else if (bullet_right_down_X >= tempEnemy.getEnemy_X()
						&& bullet_right_down_X <= (tempEnemy.getEnemy_X() + tempEnemy
								.getEnemy_Width())
						&& bullet_right_down_Y >= tempEnemy.getEnemy_Y()
						&& bullet_right_down_Y <= (tempEnemy.getEnemy_Y() + tempEnemy
								.getEnemy_Height())) {
					checkEnemyHealth(tempEnemy, 0, Constant.LauncherAttack);

				} else if (bullet_left_top_X <= tempEnemy.getEnemy_X()
						&& bullet_left_top_Y >= tempEnemy.getEnemy_Y()
						&& bullet_left_down_X <= tempEnemy.getEnemy_X()
						&& bullet_left_down_Y <= (tempEnemy.getEnemy_Y() + tempEnemy
								.getEnemy_Height())
						&& bullet_right_top_X >= (tempEnemy.getEnemy_X() + tempEnemy
								.getEnemy_Width())
						&& bullet_right_top_Y <= tempEnemy.getEnemy_Y()
						&& bullet_right_down_X >= (tempEnemy.getEnemy_X() + tempEnemy
								.getEnemy_Width())
						&& bullet_right_down_Y <= (tempEnemy.getEnemy_Y() + tempEnemy
								.getEnemy_Height())) {
					checkEnemyHealth(tempEnemy, 0, Constant.LauncherAttack);
				} else if (bullet_left_top_X <= tempEnemy.getEnemy_X()
						&& bullet_left_top_Y <= tempEnemy.getEnemy_Y()
						&& bullet_left_down_X <= tempEnemy.getEnemy_X()
						&& bullet_left_down_Y >= tempEnemy.getEnemy_Y()
						&& bullet_right_top_X >= (tempEnemy.getEnemy_X() + tempEnemy
								.getEnemy_Width())
						&& bullet_right_top_Y <= tempEnemy.getEnemy_Y()
						&& bullet_right_down_X >= (tempEnemy.getEnemy_X() + tempEnemy
								.getEnemy_Width())
						&& bullet_right_down_Y >= tempEnemy.getEnemy_Y()) {
					checkEnemyHealth(tempEnemy, 0, Constant.LauncherAttack);
				} else if (bullet_left_top_X <= tempEnemy.getEnemy_X()
						&& bullet_left_top_Y <= (tempEnemy.getEnemy_Y() + tempEnemy
								.getEnemy_Height())
						&& bullet_left_down_X <= tempEnemy.getEnemy_X()
						&& bullet_left_down_Y >= (tempEnemy.getEnemy_Y() + tempEnemy
								.getEnemy_Height())
						&& bullet_right_top_X >= (tempEnemy.getEnemy_X() + tempEnemy
								.getEnemy_Width())
						&& bullet_right_top_Y <= (tempEnemy.getEnemy_Y() + tempEnemy
								.getEnemy_Height())
						&& bullet_right_down_X >= (tempEnemy.getEnemy_X() + tempEnemy
								.getEnemy_Width())
						&& bullet_right_down_Y >= (tempEnemy.getEnemy_Y() + tempEnemy
								.getEnemy_Height())) {
					checkEnemyHealth(tempEnemy, 0, Constant.LauncherAttack);
				}
				// ---------------------------
			}
		}

		if (bullet.getX() > (Constant.hero.getHero_x() + Constant.herolauncherRight
				.getWidth())) {
			for (int i = 0; i < Constant.enemyVectorRight.size(); i++) {
				Enemy tempEnemy = (Enemy) Constant.enemyVectorRight
						.elementAt(i);

				if (bullet_left_top_X >= tempEnemy.getEnemy_X()
						&& bullet_left_top_X <= (tempEnemy.getEnemy_X() + tempEnemy
								.getEnemy_Width())
						&& bullet_left_top_Y >= tempEnemy.getEnemy_Y()
						&& bullet_left_top_Y <= (tempEnemy.getEnemy_Y() + tempEnemy
								.getEnemy_Height())) {
					checkEnemyHealth(tempEnemy, 0, Constant.LauncherAttack);
				} else if (bullet_right_top_X >= tempEnemy.getEnemy_X()
						&& bullet_right_top_X <= (tempEnemy.getEnemy_X() + tempEnemy
								.getEnemy_Width())
						&& bullet_right_top_Y >= tempEnemy.getEnemy_Y()
						&& bullet_right_top_Y <= (tempEnemy.getEnemy_Y() + tempEnemy
								.getEnemy_Height())) {
					checkEnemyHealth(tempEnemy, 0, Constant.LauncherAttack);

				} else if (bullet_left_down_X >= tempEnemy.getEnemy_X()
						&& bullet_left_down_X <= (tempEnemy.getEnemy_X() + tempEnemy
								.getEnemy_Width())
						&& bullet_left_down_Y >= tempEnemy.getEnemy_Y()
						&& bullet_left_down_Y <= (tempEnemy.getEnemy_Y() + tempEnemy
								.getEnemy_Height())) {
					checkEnemyHealth(tempEnemy, 0, Constant.LauncherAttack);
				} else if (bullet_right_down_X >= tempEnemy.getEnemy_X()
						&& bullet_right_down_X <= (tempEnemy.getEnemy_X() + tempEnemy
								.getEnemy_Width())
						&& bullet_right_down_Y >= tempEnemy.getEnemy_Y()
						&& bullet_right_down_Y <= (tempEnemy.getEnemy_Y() + tempEnemy
								.getEnemy_Height())) {
					checkEnemyHealth(tempEnemy, 0, Constant.LauncherAttack);

				} else if (bullet_left_top_X <= tempEnemy.getEnemy_X()
						&& bullet_left_top_Y >= tempEnemy.getEnemy_Y()
						&& bullet_left_down_X <= tempEnemy.getEnemy_X()
						&& bullet_left_down_Y <= (tempEnemy.getEnemy_Y() + tempEnemy
								.getEnemy_Height())
						&& bullet_right_top_X >= (tempEnemy.getEnemy_X() + tempEnemy
								.getEnemy_Width())
						&& bullet_right_top_Y <= tempEnemy.getEnemy_Y()
						&& bullet_right_down_X >= (tempEnemy.getEnemy_X() + tempEnemy
								.getEnemy_Width())
						&& bullet_right_down_Y <= (tempEnemy.getEnemy_Y() + tempEnemy
								.getEnemy_Height())) {
					checkEnemyHealth(tempEnemy, 0, Constant.LauncherAttack);
				} else if (bullet_left_top_X <= tempEnemy.getEnemy_X()
						&& bullet_left_top_Y <= tempEnemy.getEnemy_Y()
						&& bullet_left_down_X <= tempEnemy.getEnemy_X()
						&& bullet_left_down_Y >= tempEnemy.getEnemy_Y()
						&& bullet_right_top_X >= (tempEnemy.getEnemy_X() + tempEnemy
								.getEnemy_Width())
						&& bullet_right_top_Y <= tempEnemy.getEnemy_Y()
						&& bullet_right_down_X >= (tempEnemy.getEnemy_X() + tempEnemy
								.getEnemy_Width())
						&& bullet_right_down_Y >= tempEnemy.getEnemy_Y()) {
					checkEnemyHealth(tempEnemy, 0, Constant.LauncherAttack);
				} else if (bullet_left_top_X <= tempEnemy.getEnemy_X()
						&& bullet_left_top_Y <= (tempEnemy.getEnemy_Y() + tempEnemy
								.getEnemy_Height())
						&& bullet_left_down_X <= tempEnemy.getEnemy_X()
						&& bullet_left_down_Y >= (tempEnemy.getEnemy_Y() + tempEnemy
								.getEnemy_Height())
						&& bullet_right_top_X >= (tempEnemy.getEnemy_X() + tempEnemy
								.getEnemy_Width())
						&& bullet_right_top_Y <= (tempEnemy.getEnemy_Y() + tempEnemy
								.getEnemy_Height())
						&& bullet_right_down_X >= (tempEnemy.getEnemy_X() + tempEnemy
								.getEnemy_Width())
						&& bullet_right_down_Y >= (tempEnemy.getEnemy_Y() + tempEnemy
								.getEnemy_Height())) {
					checkEnemyHealth(tempEnemy, 0, Constant.LauncherAttack);
				}
				// ---------------------------
			}
		}

	}

	private void checkCollisionBulets(AndroidGraphics g) {
		// TODO Auto-generated method stub
		switch (Constant.hero.whichWeaponIsSelected) {
		case Constant.handgun_selected:
			if (!Constant.handGunBulletVector.isEmpty()) {
				for (int i = 0; i < Constant.handGunBulletVector.size(); i++) {
					NormalBullet temp_Point = (NormalBullet) Constant.handGunBulletVector
							.elementAt(i);
					temp_Point.isBulletSoundPlaying = true;

					if (temp_Point.bullet_X < Constant.hero.getHero_x()
							&& temp_Point.bullet_X > 0) {
						for (int j = 0; j < Constant.enemyVectorLeft.size(); j++) {
							Enemy temp_left_enemy = (Enemy) Constant.enemyVectorLeft
									.elementAt(j);
							if (temp_Point.bullet_X < (temp_left_enemy
									.getEnemy_X() + temp_left_enemy
									.getEnemy_Width())
									&& temp_Point.bullet_X > temp_left_enemy
											.getEnemy_X()) {

								if (temp_Point.bullet_Y < (temp_left_enemy
										.getEnemy_Y() + temp_left_enemy
										.getEnemy_Height())
										&& temp_Point.bullet_Y > temp_left_enemy
												.getEnemy_Y()) {
									if (temp_Point.bullet_Y > temp_left_enemy
											.getEnemy_Y()
											&& (temp_Point.bullet_Y < temp_left_enemy
													.getEnemy_X()
													+ (temp_left_enemy
															.getEnemy_Height() * 5)
													/ 100)) {

										Constant.particleG = new ParticleGenerator(
												temp_Point.bullet_X,
												temp_Point.bullet_Y,
												temp_Point.bullet_X + 50,
												temp_Point.bullet_Y + 50);
										Constant.particleVector
												.add(Constant.particleG);

										checkEnemyHealth(temp_left_enemy,
												Constant.enemy_Head_Shoot,
												Constant.handGunAttack);

										if (temp_Point.isBulletSoundPlaying) {
											temp_Point.bulletSound.start();
											temp_Point.bulletSound
													.setOnCompletionListener(new OnCompletionListener() {

														@Override
														public void onCompletion(
																MediaPlayer mp) {
															// TODO
															// Auto-generated
															// method stub
															mp.release();
														}

													});
										}

										Constant.handGunBulletVector
												.remove(temp_Point);
									} else {
										Constant.particleG = new ParticleGenerator(
												temp_Point.bullet_X,
												temp_Point.bullet_Y,
												temp_Point.bullet_X + 50,
												temp_Point.bullet_Y + 50);
										Constant.particleVector
												.add(Constant.particleG);

										checkEnemyHealth(temp_left_enemy,
												Constant.enemy_Body_Shoot,
												Constant.handGunAttack);

										if (temp_Point.isBulletSoundPlaying) {
											temp_Point.bulletSound.start();
											temp_Point.bulletSound
													.setOnCompletionListener(new OnCompletionListener() {

														@Override
														public void onCompletion(
																MediaPlayer mp) {
															// TODO
															// Auto-generated
															// method stub
															mp.release();
														}

													});
										}

										Constant.handGunBulletVector
												.remove(temp_Point);
									}
									break;
								} else {
									Constant.handGunBulletVector
											.remove(temp_Point);
								}
							}
						}
					}// ----------left close

					if (temp_Point.bullet_X > (Constant.hero.getHero_x() + Constant.heroHandGunRight
							.getWidth())
							&& temp_Point.bullet_X < Constant
									.getWidthPercentage(100)) {
						for (int j = 0; j < Constant.enemyVectorRight.size(); j++) {
							Enemy temp_right_enemy = (Enemy) Constant.enemyVectorRight
									.elementAt(j);
							if (temp_Point.bullet_X < (temp_right_enemy
									.getEnemy_X() + temp_right_enemy
									.getEnemy_Width())
									&& temp_Point.bullet_X > temp_right_enemy
											.getEnemy_X()) {

								if (temp_Point.bullet_Y < (temp_right_enemy
										.getEnemy_Y() + temp_right_enemy
										.getEnemy_Height())
										&& temp_Point.bullet_Y > temp_right_enemy
												.getEnemy_Y()) {
									if (temp_Point.bullet_Y > temp_right_enemy
											.getEnemy_Y()
											&& (temp_Point.bullet_Y < temp_right_enemy
													.getEnemy_X()
													+ (temp_right_enemy
															.getEnemy_Height() * 5)
													/ 100)) {
										Constant.particleG = new ParticleGenerator(
												temp_Point.bullet_X,
												temp_Point.bullet_Y,
												temp_Point.bullet_X - 50,
												temp_Point.bullet_Y + 50);
										Constant.particleVector
												.add(Constant.particleG);

										checkEnemyHealth(temp_right_enemy,
												Constant.enemy_Head_Shoot,
												Constant.handGunAttack);

										if (temp_Point.isBulletSoundPlaying) {
											temp_Point.bulletSound.start();
											temp_Point.bulletSound
													.setOnCompletionListener(new OnCompletionListener() {

														@Override
														public void onCompletion(
																MediaPlayer mp) {
															// TODO
															// Auto-generated
															// method stub
															mp.release();
														}

													});
										}

										Constant.handGunBulletVector
												.remove(temp_Point);
									} else {
										Constant.particleG = new ParticleGenerator(
												temp_Point.bullet_X,
												temp_Point.bullet_Y,
												temp_Point.bullet_X - 50,
												temp_Point.bullet_Y + 50);
										Constant.particleVector
												.add(Constant.particleG);

										checkEnemyHealth(temp_right_enemy,
												Constant.enemy_Body_Shoot,
												Constant.handGunAttack);

										if (temp_Point.isBulletSoundPlaying) {
											temp_Point.bulletSound.start();
											temp_Point.bulletSound
													.setOnCompletionListener(new OnCompletionListener() {

														@Override
														public void onCompletion(
																MediaPlayer mp) {
															// TODO
															// Auto-generated
															// method stub
															mp.release();
														}

													});
										}

										Constant.handGunBulletVector
												.remove(temp_Point);
									}
									break;
								} else {
									Constant.handGunBulletVector
											.remove(temp_Point);
								}
							}
						}
					}// -----right close
				}
			}
			break;

		case Constant.shotgun_selected:
			if (!Constant.shotGunBulletVector.isEmpty()) {
				for (int i = 0; i < Constant.shotGunBulletVector.size(); i++) {
					NormalBullet temp_Point = (NormalBullet) Constant.shotGunBulletVector
							.elementAt(i);
					temp_Point.isBulletSoundPlaying = true;

					if (temp_Point.bullet_X < Constant.hero.getHero_x()
							&& temp_Point.bullet_X > 0) {
						for (int j = 0; j < Constant.enemyVectorLeft.size(); j++) {
							Enemy temp_left_enemy = (Enemy) Constant.enemyVectorLeft
									.elementAt(j);
							if (temp_Point.bullet_X < (temp_left_enemy
									.getEnemy_X() + temp_left_enemy
									.getEnemy_Width())
									&& temp_Point.bullet_X > temp_left_enemy
											.getEnemy_X()) {

								if (temp_Point.bullet_Y < (temp_left_enemy
										.getEnemy_Y() + temp_left_enemy
										.getEnemy_Height())
										&& temp_Point.bullet_Y > temp_left_enemy
												.getEnemy_Y()) {
									if (temp_Point.bullet_Y > temp_left_enemy
											.getEnemy_Y()
											&& (temp_Point.bullet_Y < temp_left_enemy
													.getEnemy_X()
													+ (temp_left_enemy
															.getEnemy_Height() * 5)
													/ 100)) {
										Constant.particleG = new ParticleGenerator(
												temp_Point.bullet_X,
												temp_Point.bullet_Y,
												temp_Point.bullet_X + 50,
												temp_Point.bullet_Y + 50);
										Constant.particleVector
												.add(Constant.particleG);

										checkEnemyHealth(temp_left_enemy,
												Constant.enemy_Head_Shoot,
												Constant.shotGunAttack);

										if (temp_Point.isBulletSoundPlaying) {
											temp_Point.bulletSound.start();
											temp_Point.bulletSound
													.setOnCompletionListener(new OnCompletionListener() {

														@Override
														public void onCompletion(
																MediaPlayer mp) {
															// TODO
															// Auto-generated
															// method stub
															mp.release();
														}

													});
										}

										Constant.shotGunBulletVector
												.remove(temp_Point);
									} else {
										Constant.particleG = new ParticleGenerator(
												temp_Point.bullet_X,
												temp_Point.bullet_Y,
												temp_Point.bullet_X + 50,
												temp_Point.bullet_Y + 50);
										Constant.particleVector
												.add(Constant.particleG);

										checkEnemyHealth(temp_left_enemy,
												Constant.enemy_Body_Shoot,
												Constant.shotGunAttack);

										if (temp_Point.isBulletSoundPlaying) {
											temp_Point.bulletSound.start();
											temp_Point.bulletSound
													.setOnCompletionListener(new OnCompletionListener() {

														@Override
														public void onCompletion(
																MediaPlayer mp) {
															// TODO
															// Auto-generated
															// method stub
															mp.release();
														}

													});
										}

										Constant.shotGunBulletVector
												.remove(temp_Point);
									}
									break;
								} else {
									Constant.shotGunBulletVector
											.remove(temp_Point);
								}
							}
						}
					}// ----------left close

					if (temp_Point.bullet_X > (Constant.hero.getHero_x() + Constant.heroShotGunRight
							.getWidth())
							&& temp_Point.bullet_X < Constant
									.getWidthPercentage(100)) {
						for (int j = 0; j < Constant.enemyVectorRight.size(); j++) {
							Enemy temp_right_enemy = (Enemy) Constant.enemyVectorRight
									.elementAt(j);
							if (temp_Point.bullet_X < (temp_right_enemy
									.getEnemy_X() + temp_right_enemy
									.getEnemy_Width())
									&& temp_Point.bullet_X > temp_right_enemy
											.getEnemy_X()) {

								if (temp_Point.bullet_Y < (temp_right_enemy
										.getEnemy_Y() + temp_right_enemy
										.getEnemy_Height())
										&& temp_Point.bullet_Y > temp_right_enemy
												.getEnemy_Y()) {
									if (temp_Point.bullet_Y > temp_right_enemy
											.getEnemy_Y()
											&& (temp_Point.bullet_Y < temp_right_enemy
													.getEnemy_X()
													+ (temp_right_enemy
															.getEnemy_Height() * 5)
													/ 100)) {
										Constant.particleG = new ParticleGenerator(
												temp_Point.bullet_X,
												temp_Point.bullet_Y,
												temp_Point.bullet_X - 50,
												temp_Point.bullet_Y + 50);
										Constant.particleVector
												.add(Constant.particleG);

										checkEnemyHealth(temp_right_enemy,
												Constant.enemy_Head_Shoot,
												Constant.shotGunAttack);

										if (temp_Point.isBulletSoundPlaying) {
											temp_Point.bulletSound.start();
											temp_Point.bulletSound
													.setOnCompletionListener(new OnCompletionListener() {

														@Override
														public void onCompletion(
																MediaPlayer mp) {
															// TODO
															// Auto-generated
															// method stub
															mp.release();
														}

													});
										}

										Constant.shotGunBulletVector
												.remove(temp_Point);
									} else {
										Constant.particleG = new ParticleGenerator(
												temp_Point.bullet_X,
												temp_Point.bullet_Y,
												temp_Point.bullet_X - 50,
												temp_Point.bullet_Y + 50);
										Constant.particleVector
												.add(Constant.particleG);

										checkEnemyHealth(temp_right_enemy,
												Constant.enemy_Body_Shoot,
												Constant.shotGunAttack);

										if (temp_Point.isBulletSoundPlaying) {
											temp_Point.bulletSound.start();
											temp_Point.bulletSound
													.setOnCompletionListener(new OnCompletionListener() {

														@Override
														public void onCompletion(
																MediaPlayer mp) {
															// TODO
															// Auto-generated
															// method stub
															mp.release();
														}

													});
										}

										Constant.shotGunBulletVector
												.remove(temp_Point);
									}
									break;
								} else {
									Constant.shotGunBulletVector
											.remove(temp_Point);
								}
							}
						}
					}// -----right close
				}
			}

			break;
		default:
			break;
		}

	}

	private void drawEnemy(AndroidGraphics g) {
		// TODO Auto-generated method stub

		for (int i = 0; i < Constant.enemyVectorLeft.size(); i++) {
			Enemy tempEnemy = (Enemy) Constant.enemyVectorLeft.elementAt(i);

			switch (tempEnemy.getEnemy_Type()) {
			case Constant.enemy_Type1_Left:
				switch (tempEnemy.getEnemy_State()) {
				case Constant.enemy_Walking_State:
					if ((System.currentTimeMillis() - Constant.gameStartTime) > tempEnemy.generation_Lag) {
						g.drawBitmap(
								Constant.Enemy_Type_1_Left_Bitmap_Frame_Walk,
								new Rect(
										tempEnemy.getEnemy_Frame_Counter_Walk()
												* (Constant.Enemy_Type_1_Left_Bitmap_Frame_Walk
														.getWidth() / Constant.Enemy_1_Walk_Frame_Count),
										0,
										(tempEnemy
												.getEnemy_Frame_Counter_Walk() + 1)
												* (Constant.Enemy_Type_1_Left_Bitmap_Frame_Walk
														.getWidth() / Constant.Enemy_1_Walk_Frame_Count),
										Constant.Enemy_Type_1_Left_Bitmap_Frame_Walk
												.getHeight()),
								new Rect(
										tempEnemy.getEnemy_X(),
										tempEnemy.getEnemy_Y(),
										tempEnemy.getEnemy_X()
												+ (Constant.Enemy_Type_1_Left_Bitmap_Frame_Walk
														.getWidth() / Constant.Enemy_1_Walk_Frame_Count),
										tempEnemy.getEnemy_Y()
												+ tempEnemy.getEnemy_Height()));
						tempEnemy.setEnemy_Frame_Counter_Walk(tempEnemy
								.getEnemy_Frame_Counter_Walk() + 1);
						if (tempEnemy.getEnemy_Frame_Counter_Walk() > (Constant.Enemy_1_Walk_Frame_Count - 1)) {
							tempEnemy.setEnemy_Frame_Counter_Walk(0);
						}

						if (tempEnemy.getEnemy_X()
								+ (Constant.Enemy_Type_1_Left_Bitmap_Frame_Walk
										.getWidth() / Constant.Enemy_1_Walk_Frame_Count) < Constant
									.getWidthPercentage(40)) {
							tempEnemy.setEnemy_X(tempEnemy.getEnemy_X()
									+ tempEnemy.getEnemy_Speed());
						} else {
							tempEnemy
									.setEnemy_State(Constant.enemy_Attacking_State);
						}
						g.drawRect(
								tempEnemy.getEnemy_X()
										+ (tempEnemy.getEnemy_Width() - tempEnemy
												.getEnemy_Health()) / 2,
								tempEnemy.getEnemy_Y()
										- Constant.getHeightPercentage(1),
								(tempEnemy.getEnemy_X() + (tempEnemy
										.getEnemy_Width() - tempEnemy
										.getEnemy_Health()) / 2)
										+ tempEnemy.getEnemy_Health(),
								tempEnemy.getEnemy_Y(), Color.RED);
					}
					break;

				case Constant.enemy_Dead_State:
					g.drawBitmap(
							Constant.Enemy_Type_1_Bitmap_Frame_Dead,
							new Rect(
									tempEnemy.getEnemy_Frame_Counter_Dead()
											* (Constant.Enemy_Type_1_Bitmap_Frame_Dead
													.getWidth() / Constant.Enemy_1_Dead_Frame_Count),
									0,
									(tempEnemy.getEnemy_Frame_Counter_Dead() + 1)
											* (Constant.Enemy_Type_1_Bitmap_Frame_Dead
													.getWidth() / Constant.Enemy_1_Dead_Frame_Count),
									Constant.Enemy_Type_1_Bitmap_Frame_Dead
											.getHeight()),
							new Rect(
									tempEnemy.getEnemy_X(),
									tempEnemy.getEnemy_Y()
											- (Constant.Enemy_Type_1_Bitmap_Frame_Dead
													.getHeight() - Constant.Enemy_Type_1_Left_Bitmap_Frame_Walk
													.getHeight()),
									tempEnemy.getEnemy_X()
											+ (Constant.Enemy_Type_1_Bitmap_Frame_Dead
													.getWidth() / Constant.Enemy_1_Dead_Frame_Count),
									tempEnemy.getEnemy_Y()
											- (Constant.Enemy_Type_1_Bitmap_Frame_Dead
													.getHeight() - Constant.Enemy_Type_1_Left_Bitmap_Frame_Walk
													.getHeight())
											+ Constant.Enemy_Type_1_Bitmap_Frame_Dead
													.getHeight()));

					tempEnemy.setEnemy_Frame_Counter_Dead(tempEnemy
							.getEnemy_Frame_Counter_Dead() + 1);
					if (tempEnemy.getEnemy_Frame_Counter_Dead() > (Constant.Enemy_1_Dead_Frame_Count - 1)) {
						Constant.enemyVectorLeft.remove(tempEnemy);
					}
					break;
				case Constant.enemy_Attacking_State:
					g.drawBitmap(
							Constant.Enemy_Type_1_Left_Bitmap_Frame_Attack,
							new Rect(
									tempEnemy.getEnemy_Frame_Counter_Attack()
											* (Constant.Enemy_Type_1_Left_Bitmap_Frame_Attack
													.getWidth() / Constant.Enemy_1_Attack_Frame_Count),
									0,
									(tempEnemy.getEnemy_Frame_Counter_Attack() + 1)
											* (Constant.Enemy_Type_1_Left_Bitmap_Frame_Attack
													.getWidth() / Constant.Enemy_1_Attack_Frame_Count),
									Constant.Enemy_Type_1_Left_Bitmap_Frame_Attack
											.getHeight()),
							new Rect(
									tempEnemy.getEnemy_X(),
									tempEnemy.getEnemy_Y()
											- (Constant.Enemy_Type_1_Left_Bitmap_Frame_Attack
													.getHeight() - Constant.Enemy_Type_1_Left_Bitmap_Frame_Walk
													.getHeight()),
									tempEnemy.getEnemy_X()
											+ (Constant.Enemy_Type_1_Left_Bitmap_Frame_Attack
													.getWidth() / Constant.Enemy_1_Attack_Frame_Count),
									tempEnemy.getEnemy_Y()
											- (Constant.Enemy_Type_1_Left_Bitmap_Frame_Attack
													.getHeight() - Constant.Enemy_Type_1_Left_Bitmap_Frame_Walk
													.getHeight())
											+ Constant.Enemy_Type_1_Left_Bitmap_Frame_Attack
													.getHeight()));

					if ((System.currentTimeMillis() - tempEnemy.getAttack_Lag()) > 2000) {
						tempEnemy.setEnemy_Frame_Counter_Attack(tempEnemy
								.getEnemy_Frame_Counter_Attack() + 1);
					}
					if (tempEnemy.getEnemy_Frame_Counter_Attack() > (Constant.Enemy_1_Attack_Frame_Count - 1)) {
						if (Constant.hero.getHealth() >= 1) {
							Constant.hero.setHealth(Constant.hero.getHealth()
									- tempEnemy.getEnemy_Attack());
						} else {
							Constant.hero.setHealth(0);
						}
						tempEnemy.setEnemy_Frame_Counter_Attack(0);
						tempEnemy.setAttack_Lag(System.currentTimeMillis());
					}

					g.drawRect(
							tempEnemy.getEnemy_X()
									+ (tempEnemy.getEnemy_Width() - tempEnemy
											.getEnemy_Health()) / 2,
							tempEnemy.getEnemy_Y()
									- Constant.getHeightPercentage(1),
							(tempEnemy.getEnemy_X() + (tempEnemy
									.getEnemy_Width() - tempEnemy
									.getEnemy_Health()) / 2)
									+ tempEnemy.getEnemy_Health(), tempEnemy
									.getEnemy_Y(), Color.RED);
					break;
				default:
					break;
				}
				break;

			case Constant.enemy_Type2_Left:
				switch (tempEnemy.getEnemy_State()) {
				case Constant.enemy_Walking_State:
					if ((System.currentTimeMillis() - Constant.gameStartTime) > tempEnemy.generation_Lag) {
						g.drawBitmap(
								Constant.Enemy_Type_2_Left_Bitmap_Frame_Walk,
								new Rect(
										tempEnemy.getEnemy_Frame_Counter_Walk()
												* (Constant.Enemy_Type_2_Left_Bitmap_Frame_Walk
														.getWidth() / Constant.Enemy_2_Walk_Frame_Count),
										0,
										(tempEnemy
												.getEnemy_Frame_Counter_Walk() + 1)
												* (Constant.Enemy_Type_2_Left_Bitmap_Frame_Walk
														.getWidth() / Constant.Enemy_2_Walk_Frame_Count),
										Constant.Enemy_Type_2_Left_Bitmap_Frame_Walk
												.getHeight()),
								new Rect(
										tempEnemy.getEnemy_X(),
										tempEnemy.getEnemy_Y(),
										tempEnemy.getEnemy_X()
												+ (Constant.Enemy_Type_2_Left_Bitmap_Frame_Walk
														.getWidth() / Constant.Enemy_2_Walk_Frame_Count),
										tempEnemy.getEnemy_Y()
												+ tempEnemy.getEnemy_Height()));
						tempEnemy.setEnemy_Frame_Counter_Walk(tempEnemy
								.getEnemy_Frame_Counter_Walk() + 1);
						if (tempEnemy.getEnemy_Frame_Counter_Walk() > (Constant.Enemy_2_Walk_Frame_Count - 1)) {
							tempEnemy.setEnemy_Frame_Counter_Walk(0);
						}

						if (tempEnemy.getEnemy_X()
								+ (Constant.Enemy_Type_2_Left_Bitmap_Frame_Walk
										.getWidth() / Constant.Enemy_2_Walk_Frame_Count) < Constant
									.getWidthPercentage(40)) {
							tempEnemy.setEnemy_X(tempEnemy.getEnemy_X()
									+ tempEnemy.getEnemy_Speed());
						} else {
							tempEnemy
									.setEnemy_State(Constant.enemy_Attacking_State);
						}
						g.drawRect(
								tempEnemy.getEnemy_X()
										+ (tempEnemy.getEnemy_Width() - tempEnemy
												.getEnemy_Health()) / 2,
								tempEnemy.getEnemy_Y()
										- Constant.getHeightPercentage(1),
								(tempEnemy.getEnemy_X() + (tempEnemy
										.getEnemy_Width() - tempEnemy
										.getEnemy_Health()) / 2)
										+ tempEnemy.getEnemy_Health(),
								tempEnemy.getEnemy_Y(), Color.RED);
					}
					break;

				case Constant.enemy_Dead_State:
					g.drawBitmap(
							Constant.Enemy_Type_2_Left_Bitmap_Frame_Dead,
							new Rect(
									tempEnemy.getEnemy_Frame_Counter_Dead()
											* (Constant.Enemy_Type_2_Left_Bitmap_Frame_Dead
													.getWidth() / Constant.Enemy_2_Dead_Frame_Count),
									0,
									(tempEnemy.getEnemy_Frame_Counter_Dead() + 1)
											* (Constant.Enemy_Type_2_Left_Bitmap_Frame_Dead
													.getWidth() / Constant.Enemy_2_Dead_Frame_Count),
									Constant.Enemy_Type_2_Left_Bitmap_Frame_Dead
											.getHeight()),
							new Rect(
									tempEnemy.getEnemy_X(),
									tempEnemy.getEnemy_Y()
											- (Constant.Enemy_Type_2_Left_Bitmap_Frame_Dead
													.getHeight() - Constant.Enemy_Type_2_Left_Bitmap_Frame_Walk
													.getHeight()),
									tempEnemy.getEnemy_X()
											+ (Constant.Enemy_Type_2_Left_Bitmap_Frame_Dead
													.getWidth() / Constant.Enemy_2_Dead_Frame_Count),
									tempEnemy.getEnemy_Y()
											- (Constant.Enemy_Type_2_Left_Bitmap_Frame_Dead
													.getHeight() - Constant.Enemy_Type_2_Left_Bitmap_Frame_Walk
													.getHeight())
											+ Constant.Enemy_Type_2_Left_Bitmap_Frame_Dead
													.getHeight()));

					tempEnemy.setEnemy_Frame_Counter_Dead(tempEnemy
							.getEnemy_Frame_Counter_Dead() + 1);
					if (tempEnemy.getEnemy_Frame_Counter_Dead() > (Constant.Enemy_2_Dead_Frame_Count - 1)) {
						Constant.enemyVectorLeft.remove(tempEnemy);
					}
					break;
				case Constant.enemy_Attacking_State:
					g.drawBitmap(
							Constant.Enemy_Type_2_Left_Bitmap_Frame_Attack,
							new Rect(
									tempEnemy.getEnemy_Frame_Counter_Attack()
											* (Constant.Enemy_Type_2_Left_Bitmap_Frame_Attack
													.getWidth() / Constant.Enemy_2_Attack_Frame_Count),
									0,
									(tempEnemy.getEnemy_Frame_Counter_Attack() + 1)
											* (Constant.Enemy_Type_2_Left_Bitmap_Frame_Attack
													.getWidth() / Constant.Enemy_2_Attack_Frame_Count),
									Constant.Enemy_Type_2_Left_Bitmap_Frame_Attack
											.getHeight()),
							new Rect(
									tempEnemy.getEnemy_X(),
									tempEnemy.getEnemy_Y()
											- (Constant.Enemy_Type_2_Left_Bitmap_Frame_Attack
													.getHeight() - Constant.Enemy_Type_2_Left_Bitmap_Frame_Walk
													.getHeight()),
									tempEnemy.getEnemy_X()
											+ (Constant.Enemy_Type_2_Left_Bitmap_Frame_Attack
													.getWidth() / Constant.Enemy_2_Attack_Frame_Count),
									tempEnemy.getEnemy_Y()
											- (Constant.Enemy_Type_2_Left_Bitmap_Frame_Attack
													.getHeight() - Constant.Enemy_Type_2_Left_Bitmap_Frame_Walk
													.getHeight())
											+ Constant.Enemy_Type_2_Left_Bitmap_Frame_Attack
													.getHeight()));

					if ((System.currentTimeMillis() - tempEnemy.getAttack_Lag()) > 2000) {
						tempEnemy.setEnemy_Frame_Counter_Attack(tempEnemy
								.getEnemy_Frame_Counter_Attack() + 1);
					}
					if (tempEnemy.getEnemy_Frame_Counter_Attack() > (Constant.Enemy_2_Attack_Frame_Count - 1)) {
						if (Constant.hero.getHealth() >= 1) {
							Constant.hero.setHealth(Constant.hero.getHealth()
									- tempEnemy.getEnemy_Attack());
						} else {
							Constant.hero.setHealth(0);
						}
						tempEnemy.setEnemy_Frame_Counter_Attack(0);
						tempEnemy.setAttack_Lag(System.currentTimeMillis());
					}

					g.drawRect(
							tempEnemy.getEnemy_X()
									+ (tempEnemy.getEnemy_Width() - tempEnemy
											.getEnemy_Health()) / 2,
							tempEnemy.getEnemy_Y()
									- Constant.getHeightPercentage(1),
							(tempEnemy.getEnemy_X() + (tempEnemy
									.getEnemy_Width() - tempEnemy
									.getEnemy_Health()) / 2)
									+ tempEnemy.getEnemy_Health(), tempEnemy
									.getEnemy_Y(), Color.RED);
					break;
				default:
					break;
				}
				break;

			case Constant.enemy_Type3_Left:
				switch (tempEnemy.getEnemy_State()) {
				case Constant.enemy_Walking_State:
					if ((System.currentTimeMillis() - Constant.gameStartTime) > tempEnemy.generation_Lag) {
						g.drawBitmap(
								Constant.Enemy_Type_3_Left_Bitmap_Frame_Walk,
								new Rect(
										tempEnemy.getEnemy_Frame_Counter_Walk()
												* (Constant.Enemy_Type_3_Left_Bitmap_Frame_Walk
														.getWidth() / Constant.Enemy_3_Walk_Frame_Count),
										0,
										(tempEnemy
												.getEnemy_Frame_Counter_Walk() + 1)
												* (Constant.Enemy_Type_3_Left_Bitmap_Frame_Walk
														.getWidth() / Constant.Enemy_3_Walk_Frame_Count),
										Constant.Enemy_Type_3_Left_Bitmap_Frame_Walk
												.getHeight()),
								new Rect(
										tempEnemy.getEnemy_X(),
										tempEnemy.getEnemy_Y(),
										tempEnemy.getEnemy_X()
												+ (Constant.Enemy_Type_3_Left_Bitmap_Frame_Walk
														.getWidth() / Constant.Enemy_3_Walk_Frame_Count),
										tempEnemy.getEnemy_Y()
												+ tempEnemy.getEnemy_Height()));
						tempEnemy.setEnemy_Frame_Counter_Walk(tempEnemy
								.getEnemy_Frame_Counter_Walk() + 1);
						if (tempEnemy.getEnemy_Frame_Counter_Walk() > (Constant.Enemy_3_Walk_Frame_Count - 1)) {
							tempEnemy.setEnemy_Frame_Counter_Walk(0);
						}

						if (tempEnemy.getEnemy_X()
								+ (Constant.Enemy_Type_3_Left_Bitmap_Frame_Walk
										.getWidth() / Constant.Enemy_3_Walk_Frame_Count) < Constant
									.getWidthPercentage(40)) {
							tempEnemy.setEnemy_X(tempEnemy.getEnemy_X()
									+ tempEnemy.getEnemy_Speed());
						} else {
							tempEnemy
									.setEnemy_State(Constant.enemy_Attacking_State);
						}
						g.drawRect(
								tempEnemy.getEnemy_X()
										+ (tempEnemy.getEnemy_Width() - tempEnemy
												.getEnemy_Health()) / 2,
								tempEnemy.getEnemy_Y()
										- Constant.getHeightPercentage(1),
								(tempEnemy.getEnemy_X() + (tempEnemy
										.getEnemy_Width() - tempEnemy
										.getEnemy_Health()) / 2)
										+ tempEnemy.getEnemy_Health(),
								tempEnemy.getEnemy_Y(), Color.RED);
					}
					break;

				case Constant.enemy_Dead_State:
					g.drawBitmap(
							Constant.Enemy_Type_3_Bitmap_Frame_Dead,
							new Rect(
									tempEnemy.getEnemy_Frame_Counter_Dead()
											* (Constant.Enemy_Type_3_Bitmap_Frame_Dead
													.getWidth() / Constant.Enemy_1_Dead_Frame_Count),
									0,
									(tempEnemy.getEnemy_Frame_Counter_Dead() + 1)
											* (Constant.Enemy_Type_3_Bitmap_Frame_Dead
													.getWidth() / Constant.Enemy_3_Dead_Frame_Count),
									Constant.Enemy_Type_3_Bitmap_Frame_Dead
											.getHeight()),
							new Rect(
									tempEnemy.getEnemy_X(),
									tempEnemy.getEnemy_Y()
											- (Constant.Enemy_Type_3_Bitmap_Frame_Dead
													.getHeight() - Constant.Enemy_Type_3_Left_Bitmap_Frame_Walk
													.getHeight()),
									tempEnemy.getEnemy_X()
											+ (Constant.Enemy_Type_3_Bitmap_Frame_Dead
													.getWidth() / Constant.Enemy_3_Dead_Frame_Count),
									tempEnemy.getEnemy_Y()
											- (Constant.Enemy_Type_3_Bitmap_Frame_Dead
													.getHeight() - Constant.Enemy_Type_3_Left_Bitmap_Frame_Walk
													.getHeight())
											+ Constant.Enemy_Type_3_Bitmap_Frame_Dead
													.getHeight()));

					tempEnemy.setEnemy_Frame_Counter_Dead(tempEnemy
							.getEnemy_Frame_Counter_Dead() + 1);
					if (tempEnemy.getEnemy_Frame_Counter_Dead() > (Constant.Enemy_3_Dead_Frame_Count - 1)) {
						Constant.enemyVectorLeft.remove(tempEnemy);
					}
					break;
				case Constant.enemy_Attacking_State:
					g.drawBitmap(
							Constant.Enemy_Type_3_Left_Bitmap_Frame_Attack,
							new Rect(
									tempEnemy.getEnemy_Frame_Counter_Attack()
											* (Constant.Enemy_Type_3_Left_Bitmap_Frame_Attack
													.getWidth() / Constant.Enemy_1_Attack_Frame_Count),
									0,
									(tempEnemy.getEnemy_Frame_Counter_Attack() + 1)
											* (Constant.Enemy_Type_3_Left_Bitmap_Frame_Attack
													.getWidth() / Constant.Enemy_3_Attack_Frame_Count),
									Constant.Enemy_Type_3_Left_Bitmap_Frame_Attack
											.getHeight()),
							new Rect(
									tempEnemy.getEnemy_X(),
									tempEnemy.getEnemy_Y()
											- (Constant.Enemy_Type_3_Left_Bitmap_Frame_Attack
													.getHeight() - Constant.Enemy_Type_3_Left_Bitmap_Frame_Walk
													.getHeight()),
									tempEnemy.getEnemy_X()
											+ (Constant.Enemy_Type_3_Left_Bitmap_Frame_Attack
													.getWidth() / Constant.Enemy_3_Attack_Frame_Count),
									tempEnemy.getEnemy_Y()
											- (Constant.Enemy_Type_3_Left_Bitmap_Frame_Attack
													.getHeight() - Constant.Enemy_Type_3_Left_Bitmap_Frame_Walk
													.getHeight())
											+ Constant.Enemy_Type_3_Left_Bitmap_Frame_Attack
													.getHeight()));

					if ((System.currentTimeMillis() - tempEnemy.getAttack_Lag()) > 2000) {
						tempEnemy.setEnemy_Frame_Counter_Attack(tempEnemy
								.getEnemy_Frame_Counter_Attack() + 1);
					}
					if (tempEnemy.getEnemy_Frame_Counter_Attack() > (Constant.Enemy_3_Attack_Frame_Count - 1)) {
						if (Constant.hero.getHealth() >= 1) {
							Constant.hero.setHealth(Constant.hero.getHealth()
									- tempEnemy.getEnemy_Attack());
						} else {
							Constant.hero.setHealth(0);
						}
						tempEnemy.setEnemy_Frame_Counter_Attack(0);
						tempEnemy.setAttack_Lag(System.currentTimeMillis());
					}

					g.drawRect(
							tempEnemy.getEnemy_X()
									+ (tempEnemy.getEnemy_Width() - tempEnemy
											.getEnemy_Health()) / 2,
							tempEnemy.getEnemy_Y()
									- Constant.getHeightPercentage(1),
							(tempEnemy.getEnemy_X() + (tempEnemy
									.getEnemy_Width() - tempEnemy
									.getEnemy_Health()) / 2)
									+ tempEnemy.getEnemy_Health(), tempEnemy
									.getEnemy_Y(), Color.RED);
					break;
				default:
					break;
				}
				break;

			case Constant.enemy_Type4_Left:
				switch (tempEnemy.getEnemy_State()) {
				case Constant.enemy_Walking_State:
					if ((System.currentTimeMillis() - Constant.gameStartTime) > tempEnemy.generation_Lag) {
						g.drawBitmap(
								Constant.Enemy_Type_4_Left_Bitmap_Frame_Walk,
								new Rect(
										tempEnemy.getEnemy_Frame_Counter_Walk()
												* (Constant.Enemy_Type_4_Left_Bitmap_Frame_Walk
														.getWidth() / Constant.Enemy_4_Walk_Frame_Count),
										0,
										(tempEnemy
												.getEnemy_Frame_Counter_Walk() + 1)
												* (Constant.Enemy_Type_4_Left_Bitmap_Frame_Walk
														.getWidth() / Constant.Enemy_4_Walk_Frame_Count),
										Constant.Enemy_Type_4_Left_Bitmap_Frame_Walk
												.getHeight()),
								new Rect(
										tempEnemy.getEnemy_X(),
										tempEnemy.getEnemy_Y(),
										tempEnemy.getEnemy_X()
												+ (Constant.Enemy_Type_4_Left_Bitmap_Frame_Walk
														.getWidth() / Constant.Enemy_4_Walk_Frame_Count),
										tempEnemy.getEnemy_Y()
												+ tempEnemy.getEnemy_Height()));
						tempEnemy.setEnemy_Frame_Counter_Walk(tempEnemy
								.getEnemy_Frame_Counter_Walk() + 1);
						if (tempEnemy.getEnemy_Frame_Counter_Walk() > (Constant.Enemy_4_Walk_Frame_Count - 1)) {
							tempEnemy.setEnemy_Frame_Counter_Walk(0);
						}

						if (tempEnemy.getEnemy_X()
								+ (Constant.Enemy_Type_4_Left_Bitmap_Frame_Walk
										.getWidth() / Constant.Enemy_4_Walk_Frame_Count) < Constant
									.getWidthPercentage(40)) {
							tempEnemy.setEnemy_X(tempEnemy.getEnemy_X()
									+ tempEnemy.getEnemy_Speed());
						} else {
							tempEnemy
									.setEnemy_State(Constant.enemy_Attacking_State);
						}
						g.drawRect(
								tempEnemy.getEnemy_X()
										+ (tempEnemy.getEnemy_Width() - tempEnemy
												.getEnemy_Health()) / 2,
								tempEnemy.getEnemy_Y()
										- Constant.getHeightPercentage(1),
								(tempEnemy.getEnemy_X() + (tempEnemy
										.getEnemy_Width() - tempEnemy
										.getEnemy_Health()) / 2)
										+ tempEnemy.getEnemy_Health(),
								tempEnemy.getEnemy_Y(), Color.RED);
					}
					break;

				case Constant.enemy_Dead_State:
					g.drawBitmap(
							Constant.Enemy_Type_4_Left_Bitmap_Frame_Dead,
							new Rect(
									tempEnemy.getEnemy_Frame_Counter_Dead()
											* (Constant.Enemy_Type_4_Left_Bitmap_Frame_Dead
													.getWidth() / Constant.Enemy_2_Dead_Frame_Count),
									0,
									(tempEnemy.getEnemy_Frame_Counter_Dead() + 1)
											* (Constant.Enemy_Type_4_Left_Bitmap_Frame_Dead
													.getWidth() / Constant.Enemy_2_Dead_Frame_Count),
									Constant.Enemy_Type_4_Left_Bitmap_Frame_Dead
											.getHeight()),
							new Rect(
									tempEnemy.getEnemy_X(),
									tempEnemy.getEnemy_Y()
											- (Constant.Enemy_Type_4_Left_Bitmap_Frame_Dead
													.getHeight() - Constant.Enemy_Type_4_Left_Bitmap_Frame_Walk
													.getHeight()),
									tempEnemy.getEnemy_X()
											+ (Constant.Enemy_Type_4_Left_Bitmap_Frame_Dead
													.getWidth() / Constant.Enemy_4_Dead_Frame_Count),
									tempEnemy.getEnemy_Y()
											- (Constant.Enemy_Type_4_Left_Bitmap_Frame_Dead
													.getHeight() - Constant.Enemy_Type_4_Left_Bitmap_Frame_Walk
													.getHeight())
											+ Constant.Enemy_Type_4_Left_Bitmap_Frame_Dead
													.getHeight()));

					tempEnemy.setEnemy_Frame_Counter_Dead(tempEnemy
							.getEnemy_Frame_Counter_Dead() + 1);
					if (tempEnemy.getEnemy_Frame_Counter_Dead() > (Constant.Enemy_4_Dead_Frame_Count - 1)) {
						Constant.enemyVectorLeft.remove(tempEnemy);
					}
					break;
				case Constant.enemy_Attacking_State:
					g.drawBitmap(
							Constant.Enemy_Type_4_Left_Bitmap_Frame_Attack,
							new Rect(
									tempEnemy.getEnemy_Frame_Counter_Attack()
											* (Constant.Enemy_Type_4_Left_Bitmap_Frame_Attack
													.getWidth() / Constant.Enemy_4_Attack_Frame_Count),
									0,
									(tempEnemy.getEnemy_Frame_Counter_Attack() + 1)
											* (Constant.Enemy_Type_4_Left_Bitmap_Frame_Attack
													.getWidth() / Constant.Enemy_4_Attack_Frame_Count),
									Constant.Enemy_Type_4_Left_Bitmap_Frame_Attack
											.getHeight()),
							new Rect(
									tempEnemy.getEnemy_X(),
									tempEnemy.getEnemy_Y()
											- (Constant.Enemy_Type_4_Left_Bitmap_Frame_Attack
													.getHeight() - Constant.Enemy_Type_4_Left_Bitmap_Frame_Walk
													.getHeight()),
									tempEnemy.getEnemy_X()
											+ (Constant.Enemy_Type_4_Left_Bitmap_Frame_Attack
													.getWidth() / Constant.Enemy_4_Attack_Frame_Count),
									tempEnemy.getEnemy_Y()
											- (Constant.Enemy_Type_4_Left_Bitmap_Frame_Attack
													.getHeight() - Constant.Enemy_Type_4_Left_Bitmap_Frame_Walk
													.getHeight())
											+ Constant.Enemy_Type_4_Left_Bitmap_Frame_Attack
													.getHeight()));

					if ((System.currentTimeMillis() - tempEnemy.getAttack_Lag()) > 2000) {
						tempEnemy.setEnemy_Frame_Counter_Attack(tempEnemy
								.getEnemy_Frame_Counter_Attack() + 1);
					}
					if (tempEnemy.getEnemy_Frame_Counter_Attack() > (Constant.Enemy_4_Attack_Frame_Count - 1)) {
						if (Constant.hero.getHealth() >= 1) {
							Constant.hero.setHealth(Constant.hero.getHealth()
									- tempEnemy.getEnemy_Attack());
						} else {
							Constant.hero.setHealth(0);
						}
						tempEnemy.setEnemy_Frame_Counter_Attack(0);
						tempEnemy.setAttack_Lag(System.currentTimeMillis());
					}

					g.drawRect(
							tempEnemy.getEnemy_X()
									+ (tempEnemy.getEnemy_Width() - tempEnemy
											.getEnemy_Health()) / 2,
							tempEnemy.getEnemy_Y()
									- Constant.getHeightPercentage(1),
							(tempEnemy.getEnemy_X() + (tempEnemy
									.getEnemy_Width() - tempEnemy
									.getEnemy_Health()) / 2)
									+ tempEnemy.getEnemy_Health(), tempEnemy
									.getEnemy_Y(), Color.RED);
					break;
				default:
					break;
				}
				break;
			case Constant.enemy_Type5_Left:
				switch (tempEnemy.getEnemy_State()) {
				case Constant.enemy_Walking_State:
					if ((System.currentTimeMillis() - Constant.gameStartTime) > tempEnemy.generation_Lag) {
						g.drawBitmap(
								Constant.Enemy_Type_5_Left_Bitmap_Frame_Walk,
								new Rect(
										tempEnemy.getEnemy_Frame_Counter_Walk()
												* (Constant.Enemy_Type_5_Left_Bitmap_Frame_Walk
														.getWidth() / Constant.Enemy_5_Walk_Frame_Count),
										0,
										(tempEnemy
												.getEnemy_Frame_Counter_Walk() + 1)
												* (Constant.Enemy_Type_5_Left_Bitmap_Frame_Walk
														.getWidth() / Constant.Enemy_5_Walk_Frame_Count),
										Constant.Enemy_Type_5_Left_Bitmap_Frame_Walk
												.getHeight()),
								new Rect(
										tempEnemy.getEnemy_X(),
										tempEnemy.getEnemy_Y(),
										tempEnemy.getEnemy_X()
												+ (Constant.Enemy_Type_5_Left_Bitmap_Frame_Walk
														.getWidth() / Constant.Enemy_5_Walk_Frame_Count),
										tempEnemy.getEnemy_Y()
												+ tempEnemy.getEnemy_Height()));
						tempEnemy.setEnemy_Frame_Counter_Walk(tempEnemy
								.getEnemy_Frame_Counter_Walk() + 1);
						if (tempEnemy.getEnemy_Frame_Counter_Walk() > (Constant.Enemy_5_Walk_Frame_Count - 1)) {
							tempEnemy.setEnemy_Frame_Counter_Walk(0);
						}

						if (tempEnemy.getEnemy_X()
								+ (Constant.Enemy_Type_5_Left_Bitmap_Frame_Walk
										.getWidth() / Constant.Enemy_5_Walk_Frame_Count) < Constant
									.getWidthPercentage(40)) {
							tempEnemy.setEnemy_X(tempEnemy.getEnemy_X()
									+ tempEnemy.getEnemy_Speed());
						} else {
							tempEnemy
									.setEnemy_State(Constant.enemy_Attacking_State);
						}
						g.drawRect(
								tempEnemy.getEnemy_X()
										+ (tempEnemy.getEnemy_Width() - tempEnemy
												.getEnemy_Health()) / 2,
								tempEnemy.getEnemy_Y()
										- Constant.getHeightPercentage(1),
								(tempEnemy.getEnemy_X() + (tempEnemy
										.getEnemy_Width() - tempEnemy
										.getEnemy_Health()) / 2)
										+ tempEnemy.getEnemy_Health(),
								tempEnemy.getEnemy_Y(), Color.RED);
					}
					break;

				case Constant.enemy_Dead_State:
					g.drawBitmap(
							Constant.Enemy_Type_5_Left_Bitmap_Frame_Dead,
							new Rect(
									tempEnemy.getEnemy_Frame_Counter_Dead()
											* (Constant.Enemy_Type_5_Left_Bitmap_Frame_Dead
													.getWidth() / Constant.Enemy_5_Dead_Frame_Count),
									0,
									(tempEnemy.getEnemy_Frame_Counter_Dead() + 1)
											* (Constant.Enemy_Type_5_Left_Bitmap_Frame_Dead
													.getWidth() / Constant.Enemy_5_Dead_Frame_Count),
									Constant.Enemy_Type_5_Left_Bitmap_Frame_Dead
											.getHeight()),
							new Rect(
									tempEnemy.getEnemy_X(),
									tempEnemy.getEnemy_Y()
											- (Constant.Enemy_Type_5_Left_Bitmap_Frame_Dead
													.getHeight() - Constant.Enemy_Type_5_Left_Bitmap_Frame_Walk
													.getHeight()),
									tempEnemy.getEnemy_X()
											+ (Constant.Enemy_Type_5_Left_Bitmap_Frame_Dead
													.getWidth() / Constant.Enemy_5_Dead_Frame_Count),
									tempEnemy.getEnemy_Y()
											- (Constant.Enemy_Type_5_Left_Bitmap_Frame_Dead
													.getHeight() - Constant.Enemy_Type_5_Left_Bitmap_Frame_Walk
													.getHeight())
											+ Constant.Enemy_Type_5_Left_Bitmap_Frame_Dead
													.getHeight()));

					tempEnemy.setEnemy_Frame_Counter_Dead(tempEnemy
							.getEnemy_Frame_Counter_Dead() + 1);
					if (tempEnemy.getEnemy_Frame_Counter_Dead() > (Constant.Enemy_5_Dead_Frame_Count - 1)) {
						Constant.enemyVectorLeft.remove(tempEnemy);
					}
					break;
				case Constant.enemy_Attacking_State:
					g.drawBitmap(
							Constant.Enemy_Type_5_Left_Bitmap_Frame_Attack,
							new Rect(
									tempEnemy.getEnemy_Frame_Counter_Attack()
											* (Constant.Enemy_Type_5_Left_Bitmap_Frame_Attack
													.getWidth() / Constant.Enemy_5_Attack_Frame_Count),
									0,
									(tempEnemy.getEnemy_Frame_Counter_Attack() + 1)
											* (Constant.Enemy_Type_5_Left_Bitmap_Frame_Attack
													.getWidth() / Constant.Enemy_5_Attack_Frame_Count),
									Constant.Enemy_Type_5_Left_Bitmap_Frame_Attack
											.getHeight()),
							new Rect(
									tempEnemy.getEnemy_X(),
									tempEnemy.getEnemy_Y()
											- (Constant.Enemy_Type_5_Left_Bitmap_Frame_Attack
													.getHeight() - Constant.Enemy_Type_5_Left_Bitmap_Frame_Walk
													.getHeight()),
									tempEnemy.getEnemy_X()
											+ (Constant.Enemy_Type_5_Left_Bitmap_Frame_Attack
													.getWidth() / Constant.Enemy_5_Attack_Frame_Count),
									tempEnemy.getEnemy_Y()
											- (Constant.Enemy_Type_5_Left_Bitmap_Frame_Attack
													.getHeight() - Constant.Enemy_Type_5_Left_Bitmap_Frame_Walk
													.getHeight())
											+ Constant.Enemy_Type_5_Left_Bitmap_Frame_Attack
													.getHeight()));

					if ((System.currentTimeMillis() - tempEnemy.getAttack_Lag()) > 2000) {
						tempEnemy.setEnemy_Frame_Counter_Attack(tempEnemy
								.getEnemy_Frame_Counter_Attack() + 1);
					}
					if (tempEnemy.getEnemy_Frame_Counter_Attack() > (Constant.Enemy_5_Attack_Frame_Count - 1)) {
						if (Constant.hero.getHealth() >= 1) {
							Constant.hero.setHealth(Constant.hero.getHealth()
									- tempEnemy.getEnemy_Attack());
						} else {
							Constant.hero.setHealth(0);
						}
						tempEnemy.setEnemy_Frame_Counter_Attack(0);
						tempEnemy.setAttack_Lag(System.currentTimeMillis());
					}

					g.drawRect(
							tempEnemy.getEnemy_X()
									+ (tempEnemy.getEnemy_Width() - tempEnemy
											.getEnemy_Health()) / 2,
							tempEnemy.getEnemy_Y()
									- (Constant.Enemy_Type_5_Left_Bitmap_Frame_Attack
											.getHeight() - Constant.Enemy_Type_5_Left_Bitmap_Frame_Walk
											.getHeight())
									- Constant.getHeightPercentage(1),
							(tempEnemy.getEnemy_X() + (tempEnemy
									.getEnemy_Width() - tempEnemy
									.getEnemy_Health()) / 2)
									+ tempEnemy.getEnemy_Health(),
							tempEnemy.getEnemy_Y()
									- (Constant.Enemy_Type_5_Left_Bitmap_Frame_Attack
											.getHeight() - Constant.Enemy_Type_5_Left_Bitmap_Frame_Walk
											.getHeight()), Color.RED);
					break;
				default:
					break;
				}
				break;
			default:
				break;
			}

		}
		for (int i = 0; i < Constant.enemyVectorRight.size(); i++) {
			Enemy tempEnemy = (Enemy) Constant.enemyVectorRight.elementAt(i);

			switch (tempEnemy.getEnemy_Type()) {
			case Constant.enemy_Type1_Right:
				switch (tempEnemy.getEnemy_State()) {
				case Constant.enemy_Walking_State:
					if ((System.currentTimeMillis() - Constant.gameStartTime) > tempEnemy.generation_Lag) {
						g.drawBitmap(
								Constant.Enemy_Type_1_Right_Bitmap_Frame_Walk,
								new Rect(
										tempEnemy.getEnemy_Frame_Counter_Walk()
												* (Constant.Enemy_Type_1_Right_Bitmap_Frame_Walk
														.getWidth() / Constant.Enemy_1_Walk_Frame_Count),
										0,
										(tempEnemy
												.getEnemy_Frame_Counter_Walk() + 1)
												* (Constant.Enemy_Type_1_Right_Bitmap_Frame_Walk
														.getWidth() / Constant.Enemy_1_Walk_Frame_Count),
										Constant.Enemy_Type_1_Right_Bitmap_Frame_Walk
												.getHeight()),
								new Rect(
										tempEnemy.getEnemy_X(),
										tempEnemy.getEnemy_Y(),
										tempEnemy.getEnemy_X()
												+ (Constant.Enemy_Type_1_Right_Bitmap_Frame_Walk
														.getWidth() / Constant.Enemy_1_Walk_Frame_Count),
										tempEnemy.getEnemy_Y()
												+ tempEnemy.getEnemy_Height()));
						tempEnemy.setEnemy_Frame_Counter_Walk(tempEnemy
								.getEnemy_Frame_Counter_Walk() + 1);
						if (tempEnemy.getEnemy_Frame_Counter_Walk() > (Constant.Enemy_1_Walk_Frame_Count - 1)) {
							tempEnemy.setEnemy_Frame_Counter_Walk(0);
						}

						if (tempEnemy.getEnemy_X() > Constant
								.getWidthPercentage(70)) {
							tempEnemy.setEnemy_X(tempEnemy.getEnemy_X()
									- tempEnemy.getEnemy_Speed());
						} else {
							tempEnemy
									.setEnemy_State(Constant.enemy_Attacking_State);
						}
						g.drawRect(
								tempEnemy.getEnemy_X()
										+ (tempEnemy.getEnemy_Width() - tempEnemy
												.getEnemy_Health()) / 2,
								tempEnemy.getEnemy_Y()
										- Constant.getHeightPercentage(1),
								(tempEnemy.getEnemy_X() + (tempEnemy
										.getEnemy_Width() - tempEnemy
										.getEnemy_Health()) / 2)
										+ tempEnemy.getEnemy_Health(),
								tempEnemy.getEnemy_Y(), Color.RED);
					}
					break;

				case Constant.enemy_Dead_State:
					g.drawBitmap(
							Constant.Enemy_Type_1_Bitmap_Frame_Dead,
							new Rect(
									tempEnemy.getEnemy_Frame_Counter_Dead()
											* (Constant.Enemy_Type_1_Bitmap_Frame_Dead
													.getWidth() / Constant.Enemy_1_Dead_Frame_Count),
									0,
									(tempEnemy.getEnemy_Frame_Counter_Dead() + 1)
											* (Constant.Enemy_Type_1_Bitmap_Frame_Dead
													.getWidth() / Constant.Enemy_1_Dead_Frame_Count),
									Constant.Enemy_Type_1_Bitmap_Frame_Dead
											.getHeight()),
							new Rect(
									tempEnemy.getEnemy_X(),
									tempEnemy.getEnemy_Y()
											- (Constant.Enemy_Type_1_Bitmap_Frame_Dead
													.getHeight() - Constant.Enemy_Type_1_Right_Bitmap_Frame_Walk
													.getHeight()),
									tempEnemy.getEnemy_X()
											+ (Constant.Enemy_Type_1_Bitmap_Frame_Dead
													.getWidth() / Constant.Enemy_1_Dead_Frame_Count),
									tempEnemy.getEnemy_Y()
											- (Constant.Enemy_Type_1_Bitmap_Frame_Dead
													.getHeight() - Constant.Enemy_Type_1_Right_Bitmap_Frame_Walk
													.getHeight())
											+ Constant.Enemy_Type_1_Bitmap_Frame_Dead
													.getHeight()));

					tempEnemy.setEnemy_Frame_Counter_Dead(tempEnemy
							.getEnemy_Frame_Counter_Dead() + 1);
					if (tempEnemy.getEnemy_Frame_Counter_Dead() > (Constant.Enemy_1_Dead_Frame_Count - 1)) {
						Constant.enemyVectorRight.remove(tempEnemy);
					}
					break;
				case Constant.enemy_Attacking_State:
					g.drawBitmap(
							Constant.Enemy_Type_1_Right_Bitmap_Frame_Attack,
							new Rect(
									tempEnemy.getEnemy_Frame_Counter_Attack()
											* (Constant.Enemy_Type_1_Right_Bitmap_Frame_Attack
													.getWidth() / Constant.Enemy_1_Attack_Frame_Count),
									0,
									(tempEnemy.getEnemy_Frame_Counter_Attack() + 1)
											* (Constant.Enemy_Type_1_Right_Bitmap_Frame_Attack
													.getWidth() / Constant.Enemy_1_Attack_Frame_Count),
									Constant.Enemy_Type_1_Right_Bitmap_Frame_Attack
											.getHeight()),
							new Rect(
									tempEnemy.getEnemy_X(),
									tempEnemy.getEnemy_Y()
											- (Constant.Enemy_Type_1_Right_Bitmap_Frame_Attack
													.getHeight() - Constant.Enemy_Type_1_Right_Bitmap_Frame_Walk
													.getHeight()),
									tempEnemy.getEnemy_X()
											+ (Constant.Enemy_Type_1_Right_Bitmap_Frame_Attack
													.getWidth() / Constant.Enemy_1_Attack_Frame_Count),
									tempEnemy.getEnemy_Y()
											- (Constant.Enemy_Type_1_Right_Bitmap_Frame_Attack
													.getHeight() - Constant.Enemy_Type_1_Right_Bitmap_Frame_Walk
													.getHeight())
											+ Constant.Enemy_Type_1_Right_Bitmap_Frame_Attack
													.getHeight()));

					if ((System.currentTimeMillis() - tempEnemy.getAttack_Lag()) > 2000) {
						tempEnemy.setEnemy_Frame_Counter_Attack(tempEnemy
								.getEnemy_Frame_Counter_Attack() + 1);
					}
					if (tempEnemy.getEnemy_Frame_Counter_Attack() > (Constant.Enemy_1_Attack_Frame_Count - 1)) {
						if (Constant.hero.getHealth() >= 1) {
							Constant.hero.setHealth(Constant.hero.getHealth()
									- tempEnemy.getEnemy_Attack());
						} else {
							Constant.hero.setHealth(0);
						}
						tempEnemy.setEnemy_Frame_Counter_Attack(0);
						tempEnemy.setAttack_Lag(System.currentTimeMillis());
					}

					g.drawRect(
							tempEnemy.getEnemy_X()
									+ (tempEnemy.getEnemy_Width() - tempEnemy
											.getEnemy_Health()) / 2,
							tempEnemy.getEnemy_Y()
									- Constant.getHeightPercentage(1),
							(tempEnemy.getEnemy_X() + (tempEnemy
									.getEnemy_Width() - tempEnemy
									.getEnemy_Health()) / 2)
									+ tempEnemy.getEnemy_Health(), tempEnemy
									.getEnemy_Y(), Color.RED);
					break;
				default:
					break;
				}
				break;

			case Constant.enemy_Type2_Right:
				switch (tempEnemy.getEnemy_State()) {
				case Constant.enemy_Walking_State:
					if ((System.currentTimeMillis() - Constant.gameStartTime) > tempEnemy.generation_Lag) {
						g.drawBitmap(
								Constant.Enemy_Type_2_Right_Bitmap_Frame_Walk,
								new Rect(
										tempEnemy.getEnemy_Frame_Counter_Walk()
												* (Constant.Enemy_Type_2_Right_Bitmap_Frame_Walk
														.getWidth() / Constant.Enemy_2_Walk_Frame_Count),
										0,
										(tempEnemy
												.getEnemy_Frame_Counter_Walk() + 1)
												* (Constant.Enemy_Type_2_Right_Bitmap_Frame_Walk
														.getWidth() / Constant.Enemy_2_Walk_Frame_Count),
										Constant.Enemy_Type_2_Right_Bitmap_Frame_Walk
												.getHeight()),
								new Rect(
										tempEnemy.getEnemy_X(),
										tempEnemy.getEnemy_Y(),
										tempEnemy.getEnemy_X()
												+ (Constant.Enemy_Type_2_Right_Bitmap_Frame_Walk
														.getWidth() / Constant.Enemy_2_Walk_Frame_Count),
										tempEnemy.getEnemy_Y()
												+ tempEnemy.getEnemy_Height()));
						tempEnemy.setEnemy_Frame_Counter_Walk(tempEnemy
								.getEnemy_Frame_Counter_Walk() + 1);
						if (tempEnemy.getEnemy_Frame_Counter_Walk() > (Constant.Enemy_2_Walk_Frame_Count - 1)) {
							tempEnemy.setEnemy_Frame_Counter_Walk(0);
						}

						if (tempEnemy.getEnemy_X() > Constant
								.getWidthPercentage(70)) {
							tempEnemy.setEnemy_X(tempEnemy.getEnemy_X()
									- tempEnemy.getEnemy_Speed());
						} else {
							tempEnemy
									.setEnemy_State(Constant.enemy_Attacking_State);
						}
						g.drawRect(
								tempEnemy.getEnemy_X()
										+ (tempEnemy.getEnemy_Width() - tempEnemy
												.getEnemy_Health()) / 2,
								tempEnemy.getEnemy_Y()
										- Constant.getHeightPercentage(1),
								(tempEnemy.getEnemy_X() + (tempEnemy
										.getEnemy_Width() - tempEnemy
										.getEnemy_Health()) / 2)
										+ tempEnemy.getEnemy_Health(),
								tempEnemy.getEnemy_Y(), Color.RED);
					}
					break;

				case Constant.enemy_Dead_State:
					g.drawBitmap(
							Constant.Enemy_Type_2_Right_Bitmap_Frame_Dead,
							new Rect(
									tempEnemy.getEnemy_Frame_Counter_Dead()
											* (Constant.Enemy_Type_2_Right_Bitmap_Frame_Dead
													.getWidth() / Constant.Enemy_2_Dead_Frame_Count),
									0,
									(tempEnemy.getEnemy_Frame_Counter_Dead() + 1)
											* (Constant.Enemy_Type_2_Right_Bitmap_Frame_Dead
													.getWidth() / Constant.Enemy_2_Dead_Frame_Count),
									Constant.Enemy_Type_2_Right_Bitmap_Frame_Dead
											.getHeight()),
							new Rect(
									tempEnemy.getEnemy_X(),
									tempEnemy.getEnemy_Y()
											- (Constant.Enemy_Type_2_Right_Bitmap_Frame_Dead
													.getHeight() - Constant.Enemy_Type_2_Right_Bitmap_Frame_Walk
													.getHeight()),
									tempEnemy.getEnemy_X()
											+ (Constant.Enemy_Type_2_Right_Bitmap_Frame_Dead
													.getWidth() / Constant.Enemy_2_Dead_Frame_Count),
									tempEnemy.getEnemy_Y()
											- (Constant.Enemy_Type_2_Right_Bitmap_Frame_Dead
													.getHeight() - Constant.Enemy_Type_2_Right_Bitmap_Frame_Walk
													.getHeight())
											+ Constant.Enemy_Type_2_Right_Bitmap_Frame_Dead
													.getHeight()));

					tempEnemy.setEnemy_Frame_Counter_Dead(tempEnemy
							.getEnemy_Frame_Counter_Dead() + 1);
					if (tempEnemy.getEnemy_Frame_Counter_Dead() > (Constant.Enemy_2_Dead_Frame_Count - 1)) {
						Constant.enemyVectorRight.remove(tempEnemy);
					}
					break;
				case Constant.enemy_Attacking_State:
					g.drawBitmap(
							Constant.Enemy_Type_2_Right_Bitmap_Frame_Attack,
							new Rect(
									tempEnemy.getEnemy_Frame_Counter_Attack()
											* (Constant.Enemy_Type_2_Right_Bitmap_Frame_Attack
													.getWidth() / Constant.Enemy_2_Attack_Frame_Count),
									0,
									(tempEnemy.getEnemy_Frame_Counter_Attack() + 1)
											* (Constant.Enemy_Type_2_Right_Bitmap_Frame_Attack
													.getWidth() / Constant.Enemy_2_Attack_Frame_Count),
									Constant.Enemy_Type_2_Right_Bitmap_Frame_Attack
											.getHeight()),
							new Rect(
									tempEnemy.getEnemy_X(),
									tempEnemy.getEnemy_Y()
											- (Constant.Enemy_Type_2_Right_Bitmap_Frame_Attack
													.getHeight() - Constant.Enemy_Type_2_Right_Bitmap_Frame_Walk
													.getHeight()),
									tempEnemy.getEnemy_X()
											+ (Constant.Enemy_Type_2_Right_Bitmap_Frame_Attack
													.getWidth() / Constant.Enemy_2_Attack_Frame_Count),
									tempEnemy.getEnemy_Y()
											- (Constant.Enemy_Type_2_Right_Bitmap_Frame_Attack
													.getHeight() - Constant.Enemy_Type_2_Right_Bitmap_Frame_Walk
													.getHeight())
											+ Constant.Enemy_Type_2_Right_Bitmap_Frame_Attack
													.getHeight()));

					if ((System.currentTimeMillis() - tempEnemy.getAttack_Lag()) > 2000) {
						tempEnemy.setEnemy_Frame_Counter_Attack(tempEnemy
								.getEnemy_Frame_Counter_Attack() + 1);
					}
					if (tempEnemy.getEnemy_Frame_Counter_Attack() > (Constant.Enemy_2_Attack_Frame_Count - 1)) {
						if (Constant.hero.getHealth() >= 1) {
							Constant.hero.setHealth(Constant.hero.getHealth()
									- tempEnemy.getEnemy_Attack());
						} else {
							Constant.hero.setHealth(0);
						}
						tempEnemy.setEnemy_Frame_Counter_Attack(0);
						tempEnemy.setAttack_Lag(System.currentTimeMillis());
					}

					g.drawRect(
							tempEnemy.getEnemy_X()
									+ (tempEnemy.getEnemy_Width() - tempEnemy
											.getEnemy_Health()) / 2,
							tempEnemy.getEnemy_Y()
									- Constant.getHeightPercentage(1),
							(tempEnemy.getEnemy_X() + (tempEnemy
									.getEnemy_Width() - tempEnemy
									.getEnemy_Health()) / 2)
									+ tempEnemy.getEnemy_Health(), tempEnemy
									.getEnemy_Y(), Color.RED);
					break;
				default:
					break;
				}
				break;

			case Constant.enemy_Type3_Right:
				switch (tempEnemy.getEnemy_State()) {
				case Constant.enemy_Walking_State:
					if ((System.currentTimeMillis() - Constant.gameStartTime) > tempEnemy.generation_Lag) {
						g.drawBitmap(
								Constant.Enemy_Type_3_Right_Bitmap_Frame_Walk,
								new Rect(
										tempEnemy.getEnemy_Frame_Counter_Walk()
												* (Constant.Enemy_Type_3_Right_Bitmap_Frame_Walk
														.getWidth() / Constant.Enemy_3_Walk_Frame_Count),
										0,
										(tempEnemy
												.getEnemy_Frame_Counter_Walk() + 1)
												* (Constant.Enemy_Type_3_Right_Bitmap_Frame_Walk
														.getWidth() / Constant.Enemy_3_Walk_Frame_Count),
										Constant.Enemy_Type_3_Right_Bitmap_Frame_Walk
												.getHeight()),
								new Rect(
										tempEnemy.getEnemy_X(),
										tempEnemy.getEnemy_Y(),
										tempEnemy.getEnemy_X()
												+ (Constant.Enemy_Type_3_Right_Bitmap_Frame_Walk
														.getWidth() / Constant.Enemy_3_Walk_Frame_Count),
										tempEnemy.getEnemy_Y()
												+ tempEnemy.getEnemy_Height()));
						tempEnemy.setEnemy_Frame_Counter_Walk(tempEnemy
								.getEnemy_Frame_Counter_Walk() + 1);
						if (tempEnemy.getEnemy_Frame_Counter_Walk() > (Constant.Enemy_3_Walk_Frame_Count - 1)) {
							tempEnemy.setEnemy_Frame_Counter_Walk(0);
						}

						if (tempEnemy.getEnemy_X() > Constant
								.getWidthPercentage(70)) {
							tempEnemy.setEnemy_X(tempEnemy.getEnemy_X()
									- tempEnemy.getEnemy_Speed());
						} else {
							tempEnemy
									.setEnemy_State(Constant.enemy_Attacking_State);
						}
						g.drawRect(
								tempEnemy.getEnemy_X()
										+ (tempEnemy.getEnemy_Width() - tempEnemy
												.getEnemy_Health()) / 2,
								tempEnemy.getEnemy_Y()
										- Constant.getHeightPercentage(1),
								(tempEnemy.getEnemy_X() + (tempEnemy
										.getEnemy_Width() - tempEnemy
										.getEnemy_Health()) / 2)
										+ tempEnemy.getEnemy_Health(),
								tempEnemy.getEnemy_Y(), Color.RED);
					}
					break;

				case Constant.enemy_Dead_State:
					g.drawBitmap(
							Constant.Enemy_Type_3_Bitmap_Frame_Dead,
							new Rect(
									tempEnemy.getEnemy_Frame_Counter_Dead()
											* (Constant.Enemy_Type_3_Bitmap_Frame_Dead
													.getWidth() / Constant.Enemy_1_Dead_Frame_Count),
									0,
									(tempEnemy.getEnemy_Frame_Counter_Dead() + 1)
											* (Constant.Enemy_Type_3_Bitmap_Frame_Dead
													.getWidth() / Constant.Enemy_3_Dead_Frame_Count),
									Constant.Enemy_Type_3_Bitmap_Frame_Dead
											.getHeight()),
							new Rect(
									tempEnemy.getEnemy_X(),
									tempEnemy.getEnemy_Y()
											- (Constant.Enemy_Type_3_Bitmap_Frame_Dead
													.getHeight() - Constant.Enemy_Type_3_Right_Bitmap_Frame_Walk
													.getHeight()),
									tempEnemy.getEnemy_X()
											+ (Constant.Enemy_Type_3_Bitmap_Frame_Dead
													.getWidth() / Constant.Enemy_3_Dead_Frame_Count),
									tempEnemy.getEnemy_Y()
											- (Constant.Enemy_Type_3_Bitmap_Frame_Dead
													.getHeight() - Constant.Enemy_Type_3_Right_Bitmap_Frame_Walk
													.getHeight())
											+ Constant.Enemy_Type_3_Bitmap_Frame_Dead
													.getHeight()));

					tempEnemy.setEnemy_Frame_Counter_Dead(tempEnemy
							.getEnemy_Frame_Counter_Dead() + 1);
					if (tempEnemy.getEnemy_Frame_Counter_Dead() > (Constant.Enemy_3_Dead_Frame_Count - 1)) {
						Constant.enemyVectorRight.remove(tempEnemy);
					}
					break;
				case Constant.enemy_Attacking_State:
					g.drawBitmap(
							Constant.Enemy_Type_3_Right_Bitmap_Frame_Attack,
							new Rect(
									tempEnemy.getEnemy_Frame_Counter_Attack()
											* (Constant.Enemy_Type_3_Right_Bitmap_Frame_Attack
													.getWidth() / Constant.Enemy_1_Attack_Frame_Count),
									0,
									(tempEnemy.getEnemy_Frame_Counter_Attack() + 1)
											* (Constant.Enemy_Type_3_Right_Bitmap_Frame_Attack
													.getWidth() / Constant.Enemy_3_Attack_Frame_Count),
									Constant.Enemy_Type_3_Right_Bitmap_Frame_Attack
											.getHeight()),
							new Rect(
									tempEnemy.getEnemy_X(),
									tempEnemy.getEnemy_Y()
											- (Constant.Enemy_Type_3_Right_Bitmap_Frame_Attack
													.getHeight() - Constant.Enemy_Type_3_Right_Bitmap_Frame_Walk
													.getHeight()),
									tempEnemy.getEnemy_X()
											+ (Constant.Enemy_Type_3_Right_Bitmap_Frame_Attack
													.getWidth() / Constant.Enemy_3_Attack_Frame_Count),
									tempEnemy.getEnemy_Y()
											- (Constant.Enemy_Type_3_Right_Bitmap_Frame_Attack
													.getHeight() - Constant.Enemy_Type_3_Right_Bitmap_Frame_Walk
													.getHeight())
											+ Constant.Enemy_Type_3_Right_Bitmap_Frame_Attack
													.getHeight()));

					if ((System.currentTimeMillis() - tempEnemy.getAttack_Lag()) > 2000) {
						tempEnemy.setEnemy_Frame_Counter_Attack(tempEnemy
								.getEnemy_Frame_Counter_Attack() + 1);
					}
					if (tempEnemy.getEnemy_Frame_Counter_Attack() > (Constant.Enemy_3_Attack_Frame_Count - 1)) {
						if (Constant.hero.getHealth() >= 1) {
							Constant.hero.setHealth(Constant.hero.getHealth()
									- tempEnemy.getEnemy_Attack());
						} else {
							Constant.hero.setHealth(0);
						}
						tempEnemy.setEnemy_Frame_Counter_Attack(0);
						tempEnemy.setAttack_Lag(System.currentTimeMillis());
					}

					g.drawRect(
							tempEnemy.getEnemy_X()
									+ (tempEnemy.getEnemy_Width() - tempEnemy
											.getEnemy_Health()) / 2,
							tempEnemy.getEnemy_Y()
									- Constant.getHeightPercentage(1),
							(tempEnemy.getEnemy_X() + (tempEnemy
									.getEnemy_Width() - tempEnemy
									.getEnemy_Health()) / 2)
									+ tempEnemy.getEnemy_Health(), tempEnemy
									.getEnemy_Y(), Color.RED);
					break;
				default:
					break;
				}
				break;

			case Constant.enemy_Type4_Right:
				switch (tempEnemy.getEnemy_State()) {
				case Constant.enemy_Walking_State:
					if ((System.currentTimeMillis() - Constant.gameStartTime) > tempEnemy.generation_Lag) {
						g.drawBitmap(
								Constant.Enemy_Type_4_Right_Bitmap_Frame_Walk,
								new Rect(
										tempEnemy.getEnemy_Frame_Counter_Walk()
												* (Constant.Enemy_Type_4_Right_Bitmap_Frame_Walk
														.getWidth() / Constant.Enemy_4_Walk_Frame_Count),
										0,
										(tempEnemy
												.getEnemy_Frame_Counter_Walk() + 1)
												* (Constant.Enemy_Type_4_Right_Bitmap_Frame_Walk
														.getWidth() / Constant.Enemy_4_Walk_Frame_Count),
										Constant.Enemy_Type_4_Right_Bitmap_Frame_Walk
												.getHeight()),
								new Rect(
										tempEnemy.getEnemy_X(),
										tempEnemy.getEnemy_Y(),
										tempEnemy.getEnemy_X()
												+ (Constant.Enemy_Type_4_Right_Bitmap_Frame_Walk
														.getWidth() / Constant.Enemy_4_Walk_Frame_Count),
										tempEnemy.getEnemy_Y()
												+ tempEnemy.getEnemy_Height()));
						tempEnemy.setEnemy_Frame_Counter_Walk(tempEnemy
								.getEnemy_Frame_Counter_Walk() + 1);
						if (tempEnemy.getEnemy_Frame_Counter_Walk() > (Constant.Enemy_4_Walk_Frame_Count - 1)) {
							tempEnemy.setEnemy_Frame_Counter_Walk(0);
						}

						if (tempEnemy.getEnemy_X() > Constant
								.getWidthPercentage(70)) {
							tempEnemy.setEnemy_X(tempEnemy.getEnemy_X()
									- tempEnemy.getEnemy_Speed());
						} else {
							tempEnemy
									.setEnemy_State(Constant.enemy_Attacking_State);
						}
						g.drawRect(
								tempEnemy.getEnemy_X()
										+ (tempEnemy.getEnemy_Width() - tempEnemy
												.getEnemy_Health()) / 2,
								tempEnemy.getEnemy_Y()
										- Constant.getHeightPercentage(1),
								(tempEnemy.getEnemy_X() + (tempEnemy
										.getEnemy_Width() - tempEnemy
										.getEnemy_Health()) / 2)
										+ tempEnemy.getEnemy_Health(),
								tempEnemy.getEnemy_Y(), Color.RED);
					}
					break;

				case Constant.enemy_Dead_State:
					g.drawBitmap(
							Constant.Enemy_Type_4_Right_Bitmap_Frame_Dead,
							new Rect(
									tempEnemy.getEnemy_Frame_Counter_Dead()
											* (Constant.Enemy_Type_4_Right_Bitmap_Frame_Dead
													.getWidth() / Constant.Enemy_2_Dead_Frame_Count),
									0,
									(tempEnemy.getEnemy_Frame_Counter_Dead() + 1)
											* (Constant.Enemy_Type_4_Right_Bitmap_Frame_Dead
													.getWidth() / Constant.Enemy_2_Dead_Frame_Count),
									Constant.Enemy_Type_4_Right_Bitmap_Frame_Dead
											.getHeight()),
							new Rect(
									tempEnemy.getEnemy_X(),
									tempEnemy.getEnemy_Y()
											- (Constant.Enemy_Type_4_Right_Bitmap_Frame_Dead
													.getHeight() - Constant.Enemy_Type_4_Right_Bitmap_Frame_Walk
													.getHeight()),
									tempEnemy.getEnemy_X()
											+ (Constant.Enemy_Type_4_Right_Bitmap_Frame_Dead
													.getWidth() / Constant.Enemy_4_Dead_Frame_Count),
									tempEnemy.getEnemy_Y()
											- (Constant.Enemy_Type_4_Right_Bitmap_Frame_Dead
													.getHeight() - Constant.Enemy_Type_4_Right_Bitmap_Frame_Walk
													.getHeight())
											+ Constant.Enemy_Type_4_Right_Bitmap_Frame_Dead
													.getHeight()));

					tempEnemy.setEnemy_Frame_Counter_Dead(tempEnemy
							.getEnemy_Frame_Counter_Dead() + 1);
					if (tempEnemy.getEnemy_Frame_Counter_Dead() > (Constant.Enemy_4_Dead_Frame_Count - 1)) {
						Constant.enemyVectorRight.remove(tempEnemy);
					}
					break;
				case Constant.enemy_Attacking_State:
					g.drawBitmap(
							Constant.Enemy_Type_4_Right_Bitmap_Frame_Attack,
							new Rect(
									tempEnemy.getEnemy_Frame_Counter_Attack()
											* (Constant.Enemy_Type_4_Right_Bitmap_Frame_Attack
													.getWidth() / Constant.Enemy_4_Attack_Frame_Count),
									0,
									(tempEnemy.getEnemy_Frame_Counter_Attack() + 1)
											* (Constant.Enemy_Type_4_Right_Bitmap_Frame_Attack
													.getWidth() / Constant.Enemy_4_Attack_Frame_Count),
									Constant.Enemy_Type_4_Right_Bitmap_Frame_Attack
											.getHeight()),
							new Rect(
									tempEnemy.getEnemy_X(),
									tempEnemy.getEnemy_Y()
											- (Constant.Enemy_Type_4_Right_Bitmap_Frame_Attack
													.getHeight() - Constant.Enemy_Type_4_Right_Bitmap_Frame_Walk
													.getHeight()),
									tempEnemy.getEnemy_X()
											+ (Constant.Enemy_Type_4_Right_Bitmap_Frame_Attack
													.getWidth() / Constant.Enemy_4_Attack_Frame_Count),
									tempEnemy.getEnemy_Y()
											- (Constant.Enemy_Type_4_Right_Bitmap_Frame_Attack
													.getHeight() - Constant.Enemy_Type_4_Right_Bitmap_Frame_Walk
													.getHeight())
											+ Constant.Enemy_Type_4_Right_Bitmap_Frame_Attack
													.getHeight()));

					if ((System.currentTimeMillis() - tempEnemy.getAttack_Lag()) > 2000) {
						tempEnemy.setEnemy_Frame_Counter_Attack(tempEnemy
								.getEnemy_Frame_Counter_Attack() + 1);
					}
					if (tempEnemy.getEnemy_Frame_Counter_Attack() > (Constant.Enemy_4_Attack_Frame_Count - 1)) {
						if (Constant.hero.getHealth() >= 1) {
							Constant.hero.setHealth(Constant.hero.getHealth()
									- tempEnemy.getEnemy_Attack());
						} else {
							Constant.hero.setHealth(0);
						}
						tempEnemy.setEnemy_Frame_Counter_Attack(0);
						tempEnemy.setAttack_Lag(System.currentTimeMillis());
					}

					g.drawRect(
							tempEnemy.getEnemy_X()
									+ (tempEnemy.getEnemy_Width() - tempEnemy
											.getEnemy_Health()) / 2,
							tempEnemy.getEnemy_Y()
									- Constant.getHeightPercentage(1),
							(tempEnemy.getEnemy_X() + (tempEnemy
									.getEnemy_Width() - tempEnemy
									.getEnemy_Health()) / 2)
									+ tempEnemy.getEnemy_Health(), tempEnemy
									.getEnemy_Y(), Color.RED);
					break;
				default:
					break;
				}
				break;
			case Constant.enemy_Type5_Right:
				switch (tempEnemy.getEnemy_State()) {
				case Constant.enemy_Walking_State:
					if ((System.currentTimeMillis() - Constant.gameStartTime) > tempEnemy.generation_Lag) {
						g.drawBitmap(
								Constant.Enemy_Type_5_Right_Bitmap_Frame_Walk,
								new Rect(
										tempEnemy.getEnemy_Frame_Counter_Walk()
												* (Constant.Enemy_Type_5_Right_Bitmap_Frame_Walk
														.getWidth() / Constant.Enemy_5_Walk_Frame_Count),
										0,
										(tempEnemy
												.getEnemy_Frame_Counter_Walk() + 1)
												* (Constant.Enemy_Type_5_Right_Bitmap_Frame_Walk
														.getWidth() / Constant.Enemy_5_Walk_Frame_Count),
										Constant.Enemy_Type_5_Right_Bitmap_Frame_Walk
												.getHeight()),
								new Rect(
										tempEnemy.getEnemy_X(),
										tempEnemy.getEnemy_Y(),
										tempEnemy.getEnemy_X()
												+ (Constant.Enemy_Type_5_Right_Bitmap_Frame_Walk
														.getWidth() / Constant.Enemy_5_Walk_Frame_Count),
										tempEnemy.getEnemy_Y()
												+ tempEnemy.getEnemy_Height()));
						tempEnemy.setEnemy_Frame_Counter_Walk(tempEnemy
								.getEnemy_Frame_Counter_Walk() + 1);
						if (tempEnemy.getEnemy_Frame_Counter_Walk() > (Constant.Enemy_5_Walk_Frame_Count - 1)) {
							tempEnemy.setEnemy_Frame_Counter_Walk(0);
						}

						if (tempEnemy.getEnemy_X() > Constant
								.getWidthPercentage(70)) {
							tempEnemy.setEnemy_X(tempEnemy.getEnemy_X()
									- tempEnemy.getEnemy_Speed());
						} else {
							tempEnemy
									.setEnemy_State(Constant.enemy_Attacking_State);
						}
						g.drawRect(
								tempEnemy.getEnemy_X()
										+ (tempEnemy.getEnemy_Width() - tempEnemy
												.getEnemy_Health()) / 2,
								tempEnemy.getEnemy_Y()
										- Constant.getHeightPercentage(1),
								(tempEnemy.getEnemy_X() + (tempEnemy
										.getEnemy_Width() - tempEnemy
										.getEnemy_Health()) / 2)
										+ tempEnemy.getEnemy_Health(),
								tempEnemy.getEnemy_Y(), Color.RED);
					}
					break;

				case Constant.enemy_Dead_State:
					g.drawBitmap(
							Constant.Enemy_Type_5_Right_Bitmap_Frame_Dead,
							new Rect(
									tempEnemy.getEnemy_Frame_Counter_Dead()
											* (Constant.Enemy_Type_5_Right_Bitmap_Frame_Dead
													.getWidth() / Constant.Enemy_5_Dead_Frame_Count),
									0,
									(tempEnemy.getEnemy_Frame_Counter_Dead() + 1)
											* (Constant.Enemy_Type_5_Right_Bitmap_Frame_Dead
													.getWidth() / Constant.Enemy_5_Dead_Frame_Count),
									Constant.Enemy_Type_5_Right_Bitmap_Frame_Dead
											.getHeight()),
							new Rect(
									tempEnemy.getEnemy_X(),
									tempEnemy.getEnemy_Y()
											- (Constant.Enemy_Type_5_Right_Bitmap_Frame_Dead
													.getHeight() - Constant.Enemy_Type_5_Right_Bitmap_Frame_Walk
													.getHeight()),
									tempEnemy.getEnemy_X()
											+ (Constant.Enemy_Type_5_Right_Bitmap_Frame_Dead
													.getWidth() / Constant.Enemy_5_Dead_Frame_Count),
									tempEnemy.getEnemy_Y()
											- (Constant.Enemy_Type_5_Right_Bitmap_Frame_Dead
													.getHeight() - Constant.Enemy_Type_5_Right_Bitmap_Frame_Walk
													.getHeight())
											+ Constant.Enemy_Type_5_Right_Bitmap_Frame_Dead
													.getHeight()));

					tempEnemy.setEnemy_Frame_Counter_Dead(tempEnemy
							.getEnemy_Frame_Counter_Dead() + 1);
					if (tempEnemy.getEnemy_Frame_Counter_Dead() > (Constant.Enemy_5_Dead_Frame_Count - 1)) {
						Constant.enemyVectorRight.remove(tempEnemy);
					}
					break;
				case Constant.enemy_Attacking_State:
					g.drawBitmap(
							Constant.Enemy_Type_5_Right_Bitmap_Frame_Attack,
							new Rect(
									tempEnemy.getEnemy_Frame_Counter_Attack()
											* (Constant.Enemy_Type_5_Right_Bitmap_Frame_Attack
													.getWidth() / Constant.Enemy_5_Attack_Frame_Count),
									0,
									(tempEnemy.getEnemy_Frame_Counter_Attack() + 1)
											* (Constant.Enemy_Type_5_Right_Bitmap_Frame_Attack
													.getWidth() / Constant.Enemy_5_Attack_Frame_Count),
									Constant.Enemy_Type_5_Right_Bitmap_Frame_Attack
											.getHeight()),
							new Rect(
									tempEnemy.getEnemy_X(),
									tempEnemy.getEnemy_Y()
											- (Constant.Enemy_Type_5_Right_Bitmap_Frame_Attack
													.getHeight() - Constant.Enemy_Type_5_Right_Bitmap_Frame_Walk
													.getHeight()),
									tempEnemy.getEnemy_X()
											+ (Constant.Enemy_Type_5_Right_Bitmap_Frame_Attack
													.getWidth() / Constant.Enemy_5_Attack_Frame_Count),
									tempEnemy.getEnemy_Y()
											- (Constant.Enemy_Type_5_Right_Bitmap_Frame_Attack
													.getHeight() - Constant.Enemy_Type_5_Right_Bitmap_Frame_Walk
													.getHeight())
											+ Constant.Enemy_Type_5_Right_Bitmap_Frame_Attack
													.getHeight()));

					if ((System.currentTimeMillis() - tempEnemy.getAttack_Lag()) > 2000) {
						tempEnemy.setEnemy_Frame_Counter_Attack(tempEnemy
								.getEnemy_Frame_Counter_Attack() + 1);
					}
					if (tempEnemy.getEnemy_Frame_Counter_Attack() > (Constant.Enemy_5_Attack_Frame_Count - 1)) {
						if (Constant.hero.getHealth() >= 1) {
							Constant.hero.setHealth(Constant.hero.getHealth()
									- tempEnemy.getEnemy_Attack());

						} else {
							Constant.hero.setHealth(0);
						}
						tempEnemy.setEnemy_Frame_Counter_Attack(0);
						tempEnemy.setAttack_Lag(System.currentTimeMillis());
					}

					g.drawRect(
							tempEnemy.getEnemy_X()
									+ (tempEnemy.getEnemy_Width() - tempEnemy
											.getEnemy_Health()) / 2,
							tempEnemy.getEnemy_Y()
									- (Constant.Enemy_Type_5_Right_Bitmap_Frame_Attack
											.getHeight() - Constant.Enemy_Type_5_Right_Bitmap_Frame_Walk
											.getHeight())
									- Constant.getHeightPercentage(1),
							(tempEnemy.getEnemy_X() + (tempEnemy
									.getEnemy_Width() - tempEnemy
									.getEnemy_Health()) / 2)
									+ tempEnemy.getEnemy_Health(),
							tempEnemy.getEnemy_Y()
									- (Constant.Enemy_Type_5_Right_Bitmap_Frame_Attack
											.getHeight() - Constant.Enemy_Type_5_Right_Bitmap_Frame_Walk
											.getHeight()), Color.RED);
					break;
				default:
					break;
				}
				break;
			default:
				break;
			}

		}
	}

	private void drawWeaponIcon(AndroidGraphics g) {
		// TODO Auto-generated method stub
		switch (Constant.shopitemscreenstate) {

		case Constant.shop_health:
			g.drawBitmap(Constant.shopHealthIcon,
					Constant.getWidthPercentage(65),
					Constant.getHeightPercentage(35));
			g.drawText("" + Constant.HEALTH_KIT_PRICE,
					Constant.getWidthPercentage(75),
					Constant.getHeightPercentage(77), Color.WHITE, Constant.getHeightPercentage(8));
			break;

		case Constant.shop_shotgun:
			g.drawBitmap(Constant.shopShotGunIcon,
					Constant.getWidthPercentage(68),
					Constant.getHeightPercentage(35));
			g.drawText("" + Constant.SHOTGUN_AMMO_PRICE,
					Constant.getWidthPercentage(75),
					Constant.getHeightPercentage(77), Color.WHITE, Constant.getHeightPercentage(8));
			break;

		case Constant.shop_bomb:
			g.drawBitmap(Constant.shopBombIcon,
					Constant.getWidthPercentage(63),
					Constant.getHeightPercentage(35));
			g.drawText("" + Constant.MINES_PRICE,
					Constant.getWidthPercentage(75),
					Constant.getHeightPercentage(77), Color.WHITE, Constant.getHeightPercentage(8));
			break;

		case Constant.shop_launcher:
			g.drawBitmap(Constant.shopLauncherIcon,
					Constant.getWidthPercentage(68),
					Constant.getHeightPercentage(35));
			g.drawText("" + Constant.LAUNCHER_PRICE,
					Constant.getWidthPercentage(75),
					Constant.getHeightPercentage(77), Color.WHITE, Constant.getHeightPercentage(8));
			break;

		default:
			break;
		}

		g.drawText(
				"" + Constant.total_Money,
				Constant.shopTotalStripX + Constant.shopTotalStrip.getWidth()
						/ 2 + Constant.getWidthPercentage(2),
				Constant.shopTotalStripY
						+ Constant.getHeightPercentage(6)
						+ (Constant.shopTotalStrip.getHeight() - Constant
								.getHeightPercentage(8)) / 2, Color.WHITE,
				Constant.getHeightPercentage(8));

	}

	private void drawHeroFrame(AndroidGraphics g) {
		// TODO Auto-generated method stub

		switch (Constant.hero.whichWeaponIsSelected) {

		case Constant.handgun_selected:
			switch (Constant.hero.whichSideHeroFacing) {
			case Constant.leftSideHeroFacing:
				g.drawBitmap(
						Constant.heroHandGunLeft,
						new Rect(
								(heroFrameCounter * (Constant.heroHandGunLeft
										.getWidth() / Constant.hero
										.getNumberOfHandgunFrames())),
								0,
								((heroFrameCounter + 1) * (Constant.heroHandGunLeft
										.getWidth() / Constant.hero
										.getNumberOfHandgunFrames())),
								Constant.heroHandGunLeft.getHeight()),
						new Rect(
								(int) (Constant.hero.getHero_x()),
								Constant.hero.getHero_y(),
								(int) ((Constant.hero.getHero_x()) + Constant.heroHandGunLeft
										.getWidth()
										/ Constant.hero
												.getNumberOfHandgunFrames()),
								Constant.hero.getHero_y()

								+ Constant.heroHandGunLeft.getHeight()));

				if (Constant.hero.isAnimationStart()) {
					heroFrameCounter++;
				}
				if (heroFrameCounter > Constant.hero.getNumberOfHandgunFrames() - 1) {
					heroFrameCounter = 0;
					Constant.hero.setAnimationStart(false);
				}
				break;

			case Constant.rightSideHeroFacing:
				g.drawBitmap(
						Constant.heroHandGunRight,
						new Rect(
								(heroFrameCounter * (Constant.heroHandGunRight
										.getWidth() / Constant.hero
										.getNumberOfHandgunFrames())),
								0,
								((heroFrameCounter + 1) * (Constant.heroHandGunRight
										.getWidth() / Constant.hero
										.getNumberOfHandgunFrames())),
								Constant.heroHandGunRight.getHeight()),
						new Rect(
								(int) (Constant.hero.getHero_x()),
								Constant.hero.getHero_y(),
								(int) ((Constant.hero.getHero_x()) + Constant.heroHandGunRight
										.getWidth()
										/ Constant.hero
												.getNumberOfHandgunFrames()),
								Constant.hero.getHero_y()

								+ Constant.heroHandGunRight.getHeight()));

				if (Constant.hero.isAnimationStart()) {
					heroFrameCounter++;
				}
				if (heroFrameCounter > Constant.hero.getNumberOfHandgunFrames() - 1) {
					heroFrameCounter = 0;
					Constant.hero.setAnimationStart(false);
				}

				break;

			default:
				break;
			}

			break;

		case Constant.knife_selected:
			switch (Constant.hero.whichSideHeroFacing) {
			case Constant.leftSideHeroFacing:
				g.drawBitmap(
						Constant.heroKnifeLeft,
						new Rect(
								(heroFrameCounter * (Constant.heroKnifeLeft
										.getWidth() / Constant.hero
										.getNumberOfKnifeFrames())),
								0,
								((heroFrameCounter + 1) * (Constant.heroKnifeLeft
										.getWidth() / Constant.hero
										.getNumberOfKnifeFrames())),
								Constant.heroKnifeLeft.getHeight()),
						new Rect(
								(int) (Constant.hero.getHero_x()),
								Constant.hero.getHero_y()
										- Constant.getHeightPercentage(5),
								(int) ((Constant.hero.getHero_x()) + Constant.heroKnifeLeft
										.getWidth()
										/ Constant.hero
												.getNumberOfKnifeFrames()),
								Constant.hero.getHero_y()
										- Constant.getHeightPercentage(5)
										+ Constant.heroKnifeLeft.getHeight()));

				if (Constant.hero.isAnimationStart()) {
					heroFrameCounter++;
				}
				if (heroFrameCounter > Constant.hero.getNumberOfKnifeFrames() - 1) {
					heroFrameCounter = 0;
					Constant.hero.setAnimationStart(false);
				}

				break;

			case Constant.rightSideHeroFacing:
				g.drawBitmap(
						Constant.heroKnifeRight,
						new Rect(
								(heroFrameCounter * (Constant.heroKnifeRight
										.getWidth() / Constant.hero
										.getNumberOfKnifeFrames())),
								0,
								((heroFrameCounter + 1) * (Constant.heroKnifeRight
										.getWidth() / Constant.hero
										.getNumberOfKnifeFrames())),
								Constant.heroKnifeRight.getHeight()),
						new Rect(
								(int) (Constant.hero.getHero_x()),
								Constant.hero.getHero_y()
										- Constant.getHeightPercentage(5),
								(int) ((Constant.hero.getHero_x())
										+ Constant.getWidthPercentage(2) + Constant.heroKnifeRight
										.getWidth()
										/ Constant.hero
												.getNumberOfKnifeFrames()),
								Constant.hero.getHero_y()
										- Constant.getHeightPercentage(5)
										+ Constant.heroKnifeRight.getHeight()));

				if (Constant.hero.isAnimationStart()) {
					heroFrameCounter++;
				}
				if (heroFrameCounter > Constant.hero.getNumberOfKnifeFrames() - 1) {
					heroFrameCounter = 0;
					Constant.hero.setAnimationStart(false);
				}

				break;

			default:
				break;
			}
			break;

		case Constant.launcher_selected:
			switch (Constant.hero.whichSideHeroFacing) {
			case Constant.leftSideHeroFacing:
				g.drawBitmap(
						Constant.herolauncherLeft,
						new Rect(
								(heroFrameCounter * (Constant.herolauncherLeft
										.getWidth() / Constant.hero
										.getNumberOfLauncherFrames())),
								0,
								((heroFrameCounter + 1) * (Constant.herolauncherLeft
										.getWidth() / Constant.hero
										.getNumberOfLauncherFrames())),
								Constant.herolauncherLeft.getHeight()),
						new Rect(
								(int) (Constant.hero.getHero_x()),
								Constant.hero.getHero_y(),
								(int) ((Constant.hero.getHero_x()) + Constant.herolauncherLeft
										.getWidth()
										/ Constant.hero
												.getNumberOfLauncherFrames()),
								Constant.hero.getHero_y()

								+ Constant.herolauncherLeft.getHeight()));

				if (Constant.hero.isAnimationStart()) {
					heroFrameCounter++;
				}
				if (heroFrameCounter > Constant.hero
						.getNumberOfLauncherFrames() - 1) {
					heroFrameCounter = 0;
					Constant.hero.setAnimationStart(false);
				}

				break;

			case Constant.rightSideHeroFacing:
				g.drawBitmap(
						Constant.herolauncherRight,
						new Rect(
								(heroFrameCounter * (Constant.herolauncherRight
										.getWidth() / Constant.hero
										.getNumberOfLauncherFrames())),
								0,
								((heroFrameCounter + 1) * (Constant.herolauncherRight
										.getWidth() / Constant.hero
										.getNumberOfLauncherFrames())),
								Constant.herolauncherRight.getHeight()),
						new Rect(
								(int) (Constant.hero.getHero_x()),
								Constant.hero.getHero_y(),
								(int) ((Constant.hero.getHero_x()) + Constant.herolauncherRight
										.getWidth()
										/ Constant.hero
												.getNumberOfLauncherFrames()),
								Constant.hero.getHero_y()
										+ Constant.herolauncherRight
												.getHeight()));

				if (Constant.hero.isAnimationStart()) {
					heroFrameCounter++;
				}
				if (heroFrameCounter > Constant.hero
						.getNumberOfLauncherFrames() - 1) {
					heroFrameCounter = 0;
					Constant.hero.setAnimationStart(false);
				}

				break;

			default:
				break;
			}
			break;

		case Constant.shotgun_selected:
			switch (Constant.hero.whichSideHeroFacing) {
			case Constant.leftSideHeroFacing:
				g.drawBitmap(
						Constant.heroShotGunLeft,
						new Rect(
								(heroFrameCounter * (Constant.heroShotGunLeft
										.getWidth() / Constant.hero
										.getNumberOfShotgunFrames())),
								0,
								((heroFrameCounter + 1) * (Constant.heroShotGunLeft
										.getWidth() / Constant.hero
										.getNumberOfShotgunFrames())),
								Constant.heroShotGunLeft.getHeight()),
						new Rect(
								(int) (Constant.hero.getHero_x()),
								Constant.hero.getHero_y(),
								(int) ((Constant.hero.getHero_x()) + Constant.heroShotGunLeft
										.getWidth()
										/ Constant.hero
												.getNumberOfShotgunFrames()),
								Constant.hero.getHero_y()

								+ Constant.heroShotGunLeft.getHeight()));

				if (Constant.hero.isAnimationStart()) {
					heroFrameCounter++;
				}
				if (heroFrameCounter > Constant.hero.getNumberOfShotgunFrames() - 1) {
					heroFrameCounter = 0;
					Constant.hero.setAnimationStart(false);
				}

				break;

			case Constant.rightSideHeroFacing:
				g.drawBitmap(
						Constant.heroShotGunRight,
						new Rect(
								(heroFrameCounter * (Constant.heroShotGunRight
										.getWidth() / Constant.hero
										.getNumberOfShotgunFrames())),
								0,
								((heroFrameCounter + 1) * (Constant.heroShotGunRight
										.getWidth() / Constant.hero
										.getNumberOfShotgunFrames())),
								Constant.heroShotGunRight.getHeight()),
						new Rect(
								(int) (Constant.hero.getHero_x()),
								Constant.hero.getHero_y(),
								(int) ((Constant.hero.getHero_x()) + Constant.heroShotGunRight
										.getWidth()
										/ Constant.hero
												.getNumberOfShotgunFrames()),
								Constant.hero.getHero_y()
										+ Constant.heroShotGunRight.getHeight()));

				if (Constant.hero.isAnimationStart()) {
					heroFrameCounter++;
				}
				if (heroFrameCounter > Constant.hero.getNumberOfShotgunFrames() - 1) {
					heroFrameCounter = 0;
					Constant.hero.setAnimationStart(false);
				}

				break;

			default:
				break;
			}
			break;

		case Constant.mines_selected:

			switch (Constant.hero.whichSideHeroFacing) {
			case Constant.leftSideHeroFacing:
				g.drawBitmap(
						Constant.heromineLeft,
						new Rect(
								(0 * (Constant.heromineLeft.getWidth() / Constant.hero
										.getNumberOfMinesFrames())),
								0,
								((0 + 1) * (Constant.heromineLeft.getWidth() / Constant.hero
										.getNumberOfMinesFrames())),
								Constant.heromineLeft.getHeight()),
						new Rect(
								(int) (Constant.hero.getHero_x()),
								Constant.hero.getHero_y(),
								(int) ((Constant.hero.getHero_x()) + Constant.heromineLeft
										.getWidth()
										/ Constant.hero
												.getNumberOfMinesFrames()),
								Constant.hero.getHero_y()

								+ Constant.heromineLeft.getHeight()));

				break;

			case Constant.rightSideHeroFacing:
				g.drawBitmap(
						Constant.heromineRight,
						new Rect(
								(0 * (Constant.heromineRight.getWidth() / Constant.hero
										.getNumberOfMinesFrames())),
								0,
								((0 + 1) * (Constant.heromineRight.getWidth() / Constant.hero
										.getNumberOfMinesFrames())),
								Constant.heromineRight.getHeight()),
						new Rect(
								(int) (Constant.hero.getHero_x()),
								Constant.hero.getHero_y(),
								(int) ((Constant.hero.getHero_x()) + Constant.heromineRight
										.getWidth()
										/ Constant.hero
												.getNumberOfMinesFrames()),
								Constant.hero.getHero_y()
										+ Constant.heromineRight.getHeight()));

				break;

			default:
				break;
			}
			break;

		default:
			break;
		}
	}

	private void enemyUpdate() {
		// TODO Auto-generated method stub

	}

	public void onResume() {
		Constant.running = true;
		Constant.rendorthread = new Thread(this);
		Constant.rendorthread.start();
	}

	public void onPause() {
		Constant.running = false;
		while (true) {
			try {
				Constant.rendorthread.join();
				break;
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	public boolean isPointInRect(int iX_Position, int iY_Position,
			int[] iRectCoordinate) {
		if ((iX_Position > iRectCoordinate[0])
				&& (iX_Position < (iRectCoordinate[0] + iRectCoordinate[2]))
				&& (iY_Position > iRectCoordinate[1])
				&& (iY_Position < (iRectCoordinate[1] + iRectCoordinate[3]))) {
			return true;
		} else {
			return false;
		}
	}
}