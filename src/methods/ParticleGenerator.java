package methods;

import java.util.Random;
import java.util.Vector;

import constants.Constant;

import android.graphics.Bitmap;

public class ParticleGenerator {
	public Vector particles;
	public int pID = 0;
	public float startX, startY, endX, endY;
	public static int totalParticleStep = 30;
	public int particleStep =0;
	public float stepSizeX, stepSizeY;
	public Random rnd;
	public Bitmap blood[];
	public static int BLOOD_IMAGES = 4;
	public float maximumVelocity = 0;
	public int totalParticles = 100;
    public ParticleGenerator(int _startX, int _startY, int _endX, int _endY)
    {
        try{
           
            blood = new Bitmap[BLOOD_IMAGES];
              
            for (int i = 0; i < BLOOD_IMAGES; i++) {
             if(blood[i]==null){
//                blood[i] = Bitmap.createImage("/blood0" + (i + 1) + ".png");}
            	 blood[i] = Constant.graphics.newPixmap("blood0" + (i + 1) + ".png");
             }
               
            }
        }
        catch(Exception e)
                {
                   
        }

        rnd = new Random();
        particles = new Vector();
        startX = _startX;
        startY = _startY;
        endX = _endX;
        endY = _endY;
        

        stepSizeX = (startX-endX)/totalParticles;
        stepSizeY = (startY-endY)/totalParticles;
        for(int i = 0;i<totalParticles;i++)
        {
            int rX = rnd.nextInt(2);
            int rY = rnd.nextInt(2);

            if(rX == 0)
                rX = -1;
            else
                rX = 1;
            if(rY == 0)
                rY = -1;
            else
                rY = 1;
            
            float x = startX + (i*stepSizeX)+ (rX * rnd.nextFloat()*5);
            float y = startY + (i*stepSizeY)+ (rY * rnd.nextFloat()*5) ;
           //if()
           //Particle p = new Particle(startX+ (stepSizeX*i),startY+ (stepSizeY*i), startX+(i*rnd.nextFloat()* stepSizeX)/5, startY+(i*rnd.nextFloat()*stepSizeY)/5, pID,blood );
           int blood =  BLOOD_IMAGES - ((BLOOD_IMAGES * i)/totalParticles)-1;
           
            Particle p = new Particle(startX,startY, x, y, pID,blood);
           
           //System.out.println(i+"   "+((stepSizeX*rnd.nextFloat()*(totalStep-i))/10)+"     "+(+(stepSizeY*rnd.nextFloat()*(totalStep-i))/10));
           
           particles.addElement(p);
           
           pID++;
        }
    }


    


   float abs(float n) {
       if (n < 0) {
           return n * -1;
       } else {
           return n;
       }
   }
  public void nextStep()
   {
       //if(particleStep<totalParticleStep)
       {
           //System.out.println(particleStep+"    "+particles.size());
            particleStep++;
            for (int i = particles.size() - 1; i >= 0; i--) {
               Particle p = (Particle) particles.elementAt(i);
               
               // experiment w/ different friction coefficients
             // applyDissipativeForce(p, 0.001f);
               if (!p.exist(particleStep)) {
                   particles.removeElementAt(i);
               }
           }
       }
   }

   public void  paint(AndroidGraphics g)
   {
       if(particleStep<totalParticleStep)
       {
          // g.setColor(255,255,255);
         //  g.fillRect(0, 0, 240, 320);
         //   g.setColor(0,0,0);
               for (int i = particles.size() - 1; i >= 0; i--) {
           Particle p = (Particle) particles.elementAt(i);
           // experiment w/ different friction coefficients
           //System.out.println(p.bloodID);
           

          
          
           if(blood[p.bloodID]!=null)
           g.drawBitmap(blood[p.bloodID], (int)p.location.x, (int)p.location.y);
           //g.drawArc((int)p.location.x, (int)p.location.y, 5, 5, 0, 360);

           }
       }
  }
}
