package methods;

import java.io.IOException;
import java.io.InputStream;

import constants.Constant;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Paint.Align;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Typeface;

public class AndroidGraphics {
	public static final int FLIP_VERTICAL = 1;
	public final int FLIP_HORIZONTAL = 2;

	public AndroidGraphics(Typeface tf) {
//		this.assets = assets;
//		this.frameBuffer = frameBuffer;
		Constant.canvas = new Canvas(Constant.framebuffer);

		Constant.paint = new Paint();
		Constant.paint.setAntiAlias(true);
		Constant.paint.setTypeface(tf);
		Constant.paint.setStyle(Paint.Style.FILL);
		Constant.paint.setStrokeWidth(1);
		Constant.paint.setFakeBoldText(true);
		
		
		Constant.paint.setDither(true);

		// paint.setTextSize(30);
		Constant.paint.setTextAlign(Align.LEFT);
	}

	public Bitmap newPixmap(String fileName) {
		// TODO Auto-generated method stub
		Config config = null;
		config = Config.ARGB_8888;
		Options options = new Options();
		options.inPreferredConfig = config;
		InputStream in = null;
		Bitmap bitmap = null;
		try {
			in = Constant.assets.open(fileName);
			bitmap = BitmapFactory.decodeStream(in);
			if (bitmap == null)
				throw new RuntimeException("Couldn't load bitmap from asset '"
						+ fileName + "'");
		} catch (IOException e) {
			throw new RuntimeException("Couldn't load bitmap from asset '"
					+ fileName + "'");
		} finally {
			if (in != null) {
				try {
					in.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		return bitmap;
	}
	public Bitmap newPixmap(String fileName, int width, int height) {
		// TODO Auto-generated method stub
		// Config config = null;
		// config = Config.ARGB_8888;
		// Options options = new Options();
		// options.inPreferredConfig = config;
		InputStream in = null;
		Bitmap bitmap = null;
		try {
			in = Constant.assets.open(fileName);
			bitmap = BitmapFactory.decodeStream(in);
			if (bitmap == null)
				throw new RuntimeException("Couldn't load bitmap from asset '"
						+ fileName + "'");
		} catch (IOException e) {
			throw new RuntimeException("Couldn't load bitmap from asset '"
					+ fileName + "'");
		} finally {
			if (in != null) {
				try {
					in.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		bitmap = Bitmap.createScaledBitmap(bitmap, width, height, true);
		return bitmap;
	}

	// ---------------------RV D---------------------------------
	public Bitmap flip(Bitmap src, int type) {
		// create new matrix for transformation
		Matrix matrix = new Matrix();
		// if vertical
		if (type == FLIP_VERTICAL) {
			// y = y * -1
			matrix.preScale(1.0f, -1.0f);
		}
		// if horizonal
		else if (type == FLIP_HORIZONTAL) {
			// x = x * -1
			matrix.preScale(-1.0f, 1.0f);
			// unknown type
		} else {
			return null;
		}

		// return transformed image
		return Bitmap.createBitmap(src, 0, 0, src.getWidth(), src.getHeight(),
				matrix, true);
	}

	// ---------------------RV D---------------------------------
	public void setPaintStyle(Paint.Style style) {
		Constant.paint.setStyle(style);
	}

	public void clear(int color) {
		// TODO Auto-generated method stub
		Constant.canvas.drawRGB((color & 0xff0000) >> 16, (color & 0xff00) >> 8,
				(color & 0xff));
	}

	public void drawText(String string, int x, int y, int color, int size) {
		Constant.paint.setColor(color);
		Constant.paint.setTextSize(size);
		Constant.canvas.drawText(string, x, y, Constant.paint);
		// canvas.drawArc(oval, startAngle, sweepAngle, useCenter, paint)
		
	}

	public void drawPixel(int x, int y, int color) {
		// TODO Auto-generated method stub
		Constant.paint.setColor(color);
		Constant.canvas.drawPoint(x, y, Constant.paint);
	}

	public void drawLine(int x, int y, int x2, int y2, int color) {
		// TODO Auto-generated method stub
		Constant.paint.setColor(color);
		Constant.canvas.drawLine(x, y, x2, y2, Constant.paint);
	}

	public void drawRect(int x, int y, int width, int height, int color) {
		// TODO Auto-generated method stub
		Constant.paint.setColor(color);
		// paint.setStyle(Style.FILL);
		Constant.canvas.drawRect(x, y, width, height, Constant.paint);
	}

	public void drawBitmap(Bitmap pixmap, Rect srcRect1, Rect dstRect1) {
		// TODO Auto-generated method stub
		// srcRect.left = srcX;
		// srcRect.top = srcY;
		// srcRect.right = srcX + srcWidth - 1;
		// srcRect.bottom = srcY + srcHeight - 1;
		// dstRect.left = x;
		// dstRect.top = y;
		// dstRect.right = x + srcWidth - 1;
		// dstRect.bottom = y + srcHeight - 1;
		Constant.srcRect = srcRect1;
		Constant.dstRect = dstRect1;
		Constant.canvas.drawBitmap(pixmap, Constant.srcRect, Constant.dstRect, null);
	}
	
	public void drawBitmap(Bitmap pixmap, Rect srcRect1, RectF dstRect1) {
		// TODO Auto-generated method stub
		// srcRect.left = srcX;
		// srcRect.top = srcY;
		// srcRect.right = srcX + srcWidth - 1;
		// srcRect.bottom = srcY + srcHeight - 1;
		// dstRect.left = x;
		// dstRect.top = y;
		// dstRect.right = x + srcWidth - 1;
		// dstRect.bottom = y + srcHeight - 1;
		Constant.srcRect = srcRect1;
		Constant.dstRectF = dstRect1;
		Constant.canvas.drawBitmap(pixmap, Constant.srcRect, Constant.dstRect, null);
	}


	public void drawCircle(float x, float y, float radius, int color) {
		Constant.paint.setColor(color);
		Constant.canvas.drawCircle(x, y, radius, Constant.paint);
	}

	public void drawBitmap(Bitmap pixmap, float x, float y) {
		// TODO Auto-generated method stub
		Constant.canvas.drawBitmap(pixmap, x, y, null);

	}
	public void drawFlipBitmap(Bitmap pixmap, float x, float y) {
		// TODO Auto-generated method stub
		Matrix bmpmatrix = new Matrix();

		bmpmatrix.setScale(-1, 1);
		bmpmatrix.postTranslate(x, y);
		// bmpmatrix.setTranslate(x, y);
		// Constant.canvas.drawBitmap(pixmap, x, y, null);
		Constant.canvas.drawBitmap(pixmap, bmpmatrix, null);

	}

	// -----------------RV-----------------------------
	public void cropBitmap(Bitmap pixmap, int startX, int startY, int endX,
			int endY, int bitmapX, int bitmapY) {
		Bitmap croppedBitmap = Bitmap.createBitmap(pixmap, startX, startY,
				endX, endY);

		// Paint p = new Paint();
		// p.setXfermode(new PorterDuffXfermode(Mode.CLEAR));
		// Canvas c = new Canvas(bmOverlay);
		Constant.canvas.drawBitmap(croppedBitmap, bitmapX, bitmapY, null);
		// canvas.drawRect(startX, startY, endX, endY, p);
	}

	// -----------------RV-----------------------------

	public void drawArc(RectF oval, float startAngle, float sweepAngle,
			boolean useCenter) {
		// TODO Auto-generated method stub
		// canvas.drawBitmap(pixmap, x, y, null);
		Constant.canvas.drawArc(oval, startAngle, sweepAngle, useCenter, Constant.paint);
	}

	public int getWidth() {
		// TODO Auto-generated method stub
		return Constant.framebuffer.getWidth();
	}

	public int getHeight() {
		// TODO Auto-generated method stub
		return Constant.framebuffer.getHeight();
	}

	public int getStringWidth(String text, int textSize) {
		// TODO Auto-generated method stub
		Rect bounds = new Rect();
		Paint paint_temp = new Paint();
		paint_temp.setTextSize(textSize);
		paint_temp.getTextBounds(text, 0, text.length(), bounds);
		return bounds.width();
	}

	public int getStringHeight(String text, int textSize) {
		// TODO Auto-generated method stub
		Rect bounds = new Rect();
		Paint paint_temp = new Paint();
		paint_temp.setTextSize(textSize);
		paint_temp.getTextBounds(text, 0, text.length(), bounds);
		return Math.abs(bounds.height());
	}

	}
