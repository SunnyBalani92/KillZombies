package constants;

import java.util.Vector;

import view.GameView;

import methods.AndroidGraphics;
import methods.Bullet;
import methods.Enemy;
import methods.Hero;
import methods.Mines;
import methods.NormalBullet;
import methods.ParticleGenerator;

import android.content.Context;
import android.content.res.AssetManager;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.view.SurfaceHolder;

public class Constant {
	
public static ParticleGenerator particleG=null;
public static Vector<ParticleGenerator> particleVector=new Vector<ParticleGenerator>();
	
public static int screen_width;
public static int screen_height;
public static GameView gameview;
public static Canvas canvas;
public static Bitmap framebuffer=null;
public static SurfaceHolder surfaceholder;
public static Thread rendorthread;
public static boolean running=false;
public static Context context;
public static Paint paint = null;
public static System system=null;

public static AssetManager assets;
public static Rect srcRect= new Rect();
public static Rect dstRect=new Rect();
public static RectF dstRectF=new RectF();
public static AndroidGraphics graphics;
public static Bitmap backGroundleft=null;
public static Bitmap backGroundright=null;
public static Bitmap logo=null;
public static Bitmap splashmain=null;
public static Bitmap splashleft=null;
public static Bitmap splashright=null;
public static Bitmap menuGirl=null;

public static Bitmap playButton=null;
public static int playButtonX;
public static int playButtonY;
public static boolean playButtonPressed=false;

public static Bitmap soundButton=null;
public static int soundButtonX;
public static int soundButtonY;
public static boolean soundButtonPressed=false;

public static Bitmap exitButton=null;
public static int exitButtonX;
public static int exitButtonY;
public static boolean exitButtonPressed=false;

public static int[][] MENU_BUTTON_ARRAY;
public static final int Menu_play_button_id=0;
public static final int Menu_sound_button_id=1;
public static final int Menu_exit_button_id=2;

public static int[][] GAME_BUTTON_ARRAY;
public static final int Game_pause_button_id=5;
public static final int Game_hand_gun_id=0;
public static final int Game_knife_id=1;
public static final int Game_launcher_id=2;
public static final int Game_mine_id=3;
public static final int Game_shot_gun_id=4;

public static int[][] PAUSE_BUTTON_ARRAY;
public static final int Pause_resume_button_id=0;
public static final int Pause_shop_button_id=1;
public static final int Pause_home_button_id=2;
public static final int Pause_exit_button_id=3;

public static int[][] SHOP_BUTTON_ARRAY;
public static final int Shop_health_icon_id=0;
public static final int Shop_shotgun_icon_id=1;
public static final int Shop_bomb_icon_id=2;
public static final int Shop_launcher_icon_id=3;
public static final int Shop_buy_button_id=4;
public static final int Shop_back_button_id=5;

public static Bitmap menuBackGround=null;
public static long veryStartTime;
public static final long splashDelayTime=10000; 
public static final long logoDelayTime=5000;

public static int current_State=0;
public static final int state_Logo=0;
public static final int state_Splash=1;
public static final int state_Menu=2;
public static final int state_GamePlay=3;
public static final int state_Pause=4;
public static final int state_shop=5;
public static final int state_GameOver=6;
public static final int state_win=7;
public static final int state_Level_Loader=8;

public static int current_Level=0;

public static int getWidthPercentage(int x)
  {
  	int xx=(x*screen_width)/100;
  	return xx;
  }
public static int getHeightPercentage(int y)
{
	int yy=(y*screen_height)/100;
	return yy;
}
public static int getCurrent_State() {
	return current_State;
}
public static void setCurrent_State(int current_State) {
	Constant.current_State = current_State;
}
//------------------variables------------

public static Bitmap heroHandGunLeft=null;
public static Bitmap heroKnifeLeft=null;
public static Bitmap herolauncherLeft=null;
public static Bitmap heromineLeft=null;
public static Bitmap heroShotGunLeft=null;

public static Bitmap heroHandGunRight=null;
public static Bitmap heroKnifeRight=null;
public static Bitmap herolauncherRight=null;
public static Bitmap heromineRight=null;
public static Bitmap heroShotGunRight=null;

public static Bitmap heroPassportSize=null;
public static Bitmap heroHealthBar=null;
public static Bitmap heroCoinBar=null;
public static Bitmap iconStrip=null;

public static Bitmap handGunIcon=null;
public static int handGunIconX;
public static int handGunIconY;
public static boolean handGunIconPressed=false;

public static Bitmap knifeIcon=null;
public static int knifeIconX;
public static int knifeIconY;
public static boolean knifeIconPressed=false;

public static Bitmap launcherIcon=null;
public static int launcherIconX;
public static int launcherIconY;
public static boolean launcherIconPressed=false;

public static Bitmap minesIcon=null;
public static int minesIconX;
public static int minesIconY;
public static boolean minesIconPressed=false;

public static Bitmap shotgunIcon=null;
public static int shotgunIconX;
public static int shotgunIconY;
public static boolean shotgunIconPressed=false;

public static Bitmap pauseButton=null;
public static int pauseButtonX;
public static int pauseButtonY;
public static boolean pauseButtonPressed=false;

public static Bitmap pauseBackGround=null;

public static Bitmap resumeButton=null;
public static int resumeButtonX;
public static int resumeButtonY;
public static boolean resumeButtonPressed=false;

public static Bitmap shopButton=null;
public static int shopButtonX;
public static int shopButtonY;
public static boolean shopButtonPressed=false;

public static Bitmap homeButton=null;
public static int homeButtonX;
public static int homeButtonY;
public static boolean homeButtonPressed=false;

public static Bitmap pauseExitButton=null;
public static int pauseExitButtonX;
public static int pauseExitButtonY;
public static boolean pauseExitButtonPressed=false;

public static Bitmap shopBackGround=null;
public static Bitmap shopHeading=null; 
public static Bitmap shopTotalStrip=null;
public static int shopTotalStripX;
public static int shopTotalStripY;

public static Bitmap shopItemScreen=null;
public static Bitmap shopShowCase=null;
public static Bitmap shopPriceTag=null;

public static Bitmap shopHealthIcon=null;
public static int shopHealthIconX;
public static int shopHealthIconY;
public static boolean shopHealthIconPressed=false;

public static Bitmap shopShotGunIcon=null;
public static int shopShotGunIconX;
public static int shopShotGunIconY;
public static boolean shopShotGunIconPressed=false;

public static Bitmap shopLauncherIcon=null;
public static int shopLauncherIconX;
public static int shopLauncherIconY;
public static boolean shopLauncherIconPressed=false;

public static Bitmap shopBombIcon=null;
public static int shopBombIconX;
public static int shopBombIconY;
public static boolean shopBombIconPressed=false;

public static Bitmap shopBuyButton=null;
public static int shopBuyButtonX;
public static int shopBuyButtonY;
public static boolean shopBuyButtonPressed=false;

public static Bitmap shopBackButton=null;
public static int shopBackButtonX;
public static int shopBackButtonY;
public static boolean shopBackButtonPressed=false;

public static int shopitemscreenstate=0;
public static int getShopitemscreenstate() {
	return shopitemscreenstate;
}
public static void setShopitemscreenstate(int shopitemscreenstate) {
	Constant.shopitemscreenstate = shopitemscreenstate;
}
public static final int shop_health=0;
public static final int shop_shotgun=1;
public static final int shop_bomb=2;
public static final int shop_launcher=3;

public static int heropositionstate=0;
public static int getHeropositionstate() {
	return heropositionstate;
}
public static void setHeropositionstate(int heropositionstate) {
	Constant.heropositionstate = heropositionstate;
}
public static final int leftpositionstate=0;
public static boolean leftPositionPressed=false;
public static final int rightpositionstate=1;
public static boolean rightPositionPressed=false;

public static int heroWeaponState=0;
public static final int handGunState=0;
public static final int knifeState=1;
public static final int launcherState=2;
public static final int minesState=3;
public static final int shotGunState=4;

public static int getHeroWeaponState() {
	return heroWeaponState;
}
public static void setHeroWeaponState(int heroWeaponState) {
	Constant.heroWeaponState = heroWeaponState;
}


//------------------enemy atributes--------------

public static Bitmap Enemy_Type_1_Left_Bitmap_Frame_Walk=null;
public static Bitmap Enemy_Type_2_Left_Bitmap_Frame_Walk=null;
public static Bitmap Enemy_Type_3_Left_Bitmap_Frame_Walk=null;
public static Bitmap Enemy_Type_4_Left_Bitmap_Frame_Walk=null;
public static Bitmap Enemy_Type_5_Left_Bitmap_Frame_Walk=null;
public static Bitmap Enemy_Type_1_Right_Bitmap_Frame_Walk=null;
public static Bitmap Enemy_Type_2_Right_Bitmap_Frame_Walk=null;
public static Bitmap Enemy_Type_3_Right_Bitmap_Frame_Walk=null;
public static Bitmap Enemy_Type_4_Right_Bitmap_Frame_Walk=null;
public static Bitmap Enemy_Type_5_Right_Bitmap_Frame_Walk=null;

public static Bitmap Enemy_Type_1_Left_Bitmap_Frame_Attack=null;
public static Bitmap Enemy_Type_2_Left_Bitmap_Frame_Attack=null;
public static Bitmap Enemy_Type_3_Left_Bitmap_Frame_Attack=null;
public static Bitmap Enemy_Type_4_Left_Bitmap_Frame_Attack=null;
public static Bitmap Enemy_Type_5_Left_Bitmap_Frame_Attack=null;
public static Bitmap Enemy_Type_1_Right_Bitmap_Frame_Attack=null;
public static Bitmap Enemy_Type_2_Right_Bitmap_Frame_Attack=null;
public static Bitmap Enemy_Type_3_Right_Bitmap_Frame_Attack=null;
public static Bitmap Enemy_Type_4_Right_Bitmap_Frame_Attack=null;
public static Bitmap Enemy_Type_5_Right_Bitmap_Frame_Attack=null;

public static Bitmap Enemy_Type_1_Bitmap_Frame_Dead=null;
public static Bitmap Enemy_Type_2_Left_Bitmap_Frame_Dead=null;
public static Bitmap Enemy_Type_2_Right_Bitmap_Frame_Dead=null;
public static Bitmap Enemy_Type_3_Bitmap_Frame_Dead=null;
public static Bitmap Enemy_Type_4_Left_Bitmap_Frame_Dead=null;
public static Bitmap Enemy_Type_4_Right_Bitmap_Frame_Dead=null;
public static Bitmap Enemy_Type_5_Left_Bitmap_Frame_Dead=null;
public static Bitmap Enemy_Type_5_Right_Bitmap_Frame_Dead=null;

public static final int Enemy_1_Walk_Frame_Count=6;
public static final int Enemy_1_Attack_Frame_Count=3;
public static final int Enemy_1_Dead_Frame_Count=3;

public static final int Enemy_2_Walk_Frame_Count=4;
public static final int Enemy_2_Attack_Frame_Count=5;
public static final int Enemy_2_Dead_Frame_Count=5;

public static final int Enemy_3_Walk_Frame_Count=9;
public static final int Enemy_3_Attack_Frame_Count=3;
public static final int Enemy_3_Dead_Frame_Count=3;

public static final int Enemy_4_Walk_Frame_Count=5;
public static final int Enemy_4_Attack_Frame_Count=4;
public static final int Enemy_4_Dead_Frame_Count=5;

public static final int Enemy_5_Walk_Frame_Count=16;
public static final int Enemy_5_Attack_Frame_Count=3;
public static final int Enemy_5_Dead_Frame_Count=4;

public static int Enemy_Type;
public static final int enemy_Type1_Left=0;
public static final int enemy_Type2_Left=1;
public static final int enemy_Type3_Left=2;
public static final int enemy_Type4_Left=3;
public static final int enemy_Type5_Left=4;
public static final int enemy_Type1_Right=5;
public static final int enemy_Type2_Right=6;
public static final int enemy_Type3_Right=7;
public static final int enemy_Type4_Right=8;
public static final int enemy_Type5_Right=9;

public static Vector<Enemy> enemyVectorLeft=new Vector<Enemy>();
public static Vector<Enemy> enemyVectorRight=new Vector<Enemy>();

public static final int enemy_1_speed=2;
public static final int enemy_2_speed=2;
public static final int enemy_3_speed=2;
public static final int enemy_4_speed=2;
public static final int enemy_5_speed=2;

public static final int enemy_1_health=50;
public static final int enemy_2_health=50;
public static final int enemy_3_health=50;
public static final int enemy_4_health=50;
public static final int enemy_5_health=50;

public static final int enemy_Type_Index=0;
public static final int enemy_Speed_Index=1;
public static final int enemy_Health_Index=2;
public static final int enemy_Time_Lag_Index=3;
public static final int enemy_Y_Pos_Index=4;

public static final int enemy_Walking_State=0;
public static final int enemy_Attacking_State=1;
public static final int enemy_Dead_State=2;

public static final int enemy_Head_Shoot=0;
public static final int enemy_Body_Shoot=1;

public static final int enemy1_Attack=2;
public static final int enemy2_Attack=2;
public static final int enemy3_Attack=3;
public static final int enemy4_Attack=3;
public static final int enemy5_Attack=3;

public static long gameStartTime;

//----------

public static int heroBaseHeight;
public static final int leftSideHeroFacing = 0;
public static final int rightSideHeroFacing = 1;
public static final int handgun_selected =0;
public static final int knife_selected =1;
public static final int shotgun_selected=2;
public static final int launcher_selected=3;
public static final int mines_selected=4;
public static Hero hero = null;

public static Vector<NormalBullet> handGunBulletVector=new Vector<NormalBullet>();
public static Vector<NormalBullet> shotGunBulletVector=new Vector<NormalBullet>();
public static Vector<Bullet> launcherVector=new Vector<Bullet>();
public static Vector<Mines> minesVector=new Vector<Mines>();
public static int number_Of_Shotgun_Emmo=10;
public static int number_Of_Launcher=10;
public static int number_Of_mines=5;

public static int leftKnifeRectangleX;
public static int leftKnifeRectangleY;
public static int leftKnifeRectangleWidth;
public static int leftKnifeRectangleHeight;

public static int rightKnifeRectangleX;
public static int rightKnifeRectangleY;
public static int rightKnifeRectangleWidth;
public static int rightknifeRectangleHeight;

public static int knifePointerDownX;
public static int knifePointerDownY;
public static boolean knifeLeftRectSelected=false;
public static boolean knifeRightRectSelected=false;

public static boolean knifeDrag=false;

public static final int knifeAttack=5;
public static final int handGunAttack=6;
public static final int LauncherAttack=100;
public static final int shotGunAttack=12;
public static final int minesAttack=110;

public static int total_Money=0;
public static final int zombie_1_Bodyshoot_Price=10;
public static final int zombie_1_Headshoot_Price=20;
public static final int zombie_2_Bodyshoot_Price=10;
public static final int zombie_2_Headshoot_Price=20;
public static final int zombie_3_Bodyshoot_Price=10;
public static final int zombie_3_Headshoot_Price=20;
public static final int zombie_4_Bodyshoot_Price=10;
public static final int zombie_4_Headshoot_Price=20;
public static final int zombie_5_Bodyshoot_Price=10;
public static final int zombie_5_Headshoot_Price=20;


public static Bitmap mine=null;
public static Bitmap blastLauncher=null;
public static final int no_of_blast_Frame=29;

public static int health_bar_X;
public static int health_bar_Y;
public static int passport_size_photo_X;
public static int passport_size_photo_Y;
public static int coin_bar_X;
public static int coin_bar_Y;

public static Bitmap gameOverBitmap=null;
public static Bitmap gameWinBitmap=null;
public static Bitmap totalWinLoseBitmap=null;
public static Bitmap replaybtn=null;
public static Bitmap homebtn=null;

public static int winStateHomeBtn_X;
public static int winStateHomeBtn_Y;
public static int winStateReplayBtn_X;
public static int winStateReplayBtn_Y;

public static int loseStateHomeBtn_X;
public static int loseStateHomeBtn_Y;
public static int loseStateReplayBtn_X;
public static int loseStateReplayBtn_Y;

public static int[][] Lose_State_BUTTON_ARRAY;
public static int[][] Win_State_BUTTON_ARRAY;
public static boolean loseHomeBtnPressed=false;
public static boolean loseReplayBtnPressed=false;

public static boolean winHomeBtnPressed=false;
public static boolean winReplayBtnPressed=false;


public final static int homeBtnId=0;
public final static int replayBtnId=1;

public static int WhichItemPriceToShow = 100;
public static final int HEALTH_KIT_PRICE = 100;
public static final int SHOTGUN_AMMO_PRICE = 150;
public static final int LAUNCHER_PRICE = 200;
public static final int MINES_PRICE = 300;
}