public class BouncingSprite extends MobileSprite {

    BouncingSprite( double x, double y, int width, int height,String image,double vx, double vy){
        super(x,y,width,height,image,vx,vy);

    }
    private void bounce(){
        if(super.getX()-super.getWidth()/2 <= 0|| super.getX()+ super.getWidth()/2 >= 600) {
            super.setVx(super.getvx()*-1);
        }
        if(super.getY()-super.getHeight()/2 <= 0|| super.getY()+ super.getHeight()/2 >= 600) {
            super.setVy(super.getVy()*-1);
        }
    }
    private void newbounce(Sprite other){
        if(this.getX() > other.getX()){
            setVx(-1*getOrigvx());
        }
        else
            super.setVx(getOrigvx());
        if(this.getY() > other.getY())
             setVy(getOrigvy());
            
        else
            setVy(-1*getOrigvy());
       
           

    }

    @Override
    public void step(World world) {  
        

        
        bounce();
        super.step(world);
        for(int x = 0; x < world.getNumSprites();x++){
            if(this.overlaps(world.getSprite(x)) && world.getSprite(x)!=this){
                // System.out.println("hello");
                newbounce(this);
                newbounce(world.getSprite(x));

                break;
               
                
        }
        
    }
}
}