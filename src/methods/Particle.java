package methods;

public class Particle {
	PVector location;
	  PVector velocity;
	  PVector acceleration =  new PVector(0f, 0.4f);
	  
	  float mass;
	  int pID;
	  int bloodID = 0;
	  public Particle(float _mouseX, float _mouseY, float _pmouseX, float _pmouseY, int _pID, int _bloodID) {
	      pID = _pID;
	      bloodID = _bloodID;
	      location = new PVector(_mouseX, _mouseY);
	      //get velocity from direction and speed of mouse movement
	      velocity = new PVector((_mouseX-_pmouseX)/2, (_mouseY-_pmouseY)/2);
	      
	      
	      mass = 5;
	  }

	  public boolean exist(int step) {
//	         /System.out.println(pID+"     "+velocity.x);
	      
	     //when it comes to a rest, get rid of it
	     if (step >  ParticleGenerator.totalParticleStep) {
	       return false;
	     }
	 
	     if(bloodID>(ParticleGenerator.BLOOD_IMAGES*3*step)/ParticleGenerator.totalParticleStep)
	               bloodID --;
	     
	     velocity.add(acceleration);
	     location.add(velocity);
	     //ellipse(location.x, location.y, 10, 10);

	     return true;
	  }


	  float abs(float n)
	    {
	      if(n<0)
	          return n*-1;
	      else
	          return n;
	  }
}
