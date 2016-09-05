package view;

import constants.Constant;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.os.Bundle;
import android.view.Display;
import android.view.Window;
import android.view.WindowManager;

public class MainActivity extends Activity {
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
				WindowManager.LayoutParams.FLAG_FULLSCREEN);
	
	Display display=getWindowManager().getDefaultDisplay();
	Constant.screen_width=display.getWidth();
	Constant.screen_height=display.getHeight();
	Constant.framebuffer=Bitmap.createBitmap(Constant.screen_width,Constant.screen_height,Config.ARGB_8888);
	Constant.assets=getAssets();
	 Constant.gameview=new GameView(this);
	 setContentView(Constant.gameview);
	 
	}

	@Override
	protected void onPause() {
		// TODO Auto-generated method stub
		super.onPause();
		Constant.gameview.onPause();
	}
	@Override
	protected void onResume() {
		// TODO Auto-generated method stub
		super.onResume();
		Constant.gameview.onResume();
	}
	
	@Override
	public void onBackPressed() {
		// TODO Auto-generated method stub
		
		create_back_press_dialog_box();
	}

	private void create_back_press_dialog_box() {
		// TODO Auto-generated method stub
		AlertDialog.Builder alertdialogbuilder=new AlertDialog.Builder(MainActivity.this);
		
		alertdialogbuilder.setTitle("Are you sure you want to quit the game ?");
		alertdialogbuilder.setCancelable(false);
		alertdialogbuilder.setPositiveButton("Quit", new DialogInterface.OnClickListener() {
			
			@Override
			public void onClick(DialogInterface dialog, int id) {
				// TODO Auto-generated method stub
				MainActivity.this.finish();
				int pid=android.os.Process.myPid();
				android.os.Process.killProcess(pid);
			}
		});
		
		alertdialogbuilder.setNegativeButton("Return", new DialogInterface.OnClickListener() {
			
			@Override
			public void onClick(DialogInterface dialog, int id) {
				// TODO Auto-generated method stub
				
			}
		});
		
		AlertDialog alertDialog=alertdialogbuilder.create();
		alertDialog.show();
	}
	
	public void FINISH_MY_GAME(){
		MainActivity.this.finish();
		 int pid = android.os.Process.myPid();
		 android.os.Process.killProcess(pid);
	}
	
}
