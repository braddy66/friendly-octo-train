/*****************************************************************************
 *  Compilation:  javac GuitarHeroLite.java
 *  Execution:    java  GuitarHeroLite
 *  Dependencies: StdAudio.java StdDraw.java GuitarString.java
 *
 *  Plays two guitar strings (concert A and concert C) when the user
 *  types the lowercase letters 'a' and 'c', respectively in the 
 *  standard drawing window.
 *
 ****************************************************************************/

public class GuitarHero {

    public static void main(String[] args) throws Exception {

        String keyboard = "q2we4r5ty7u8i9op-[=zxdcfvgbnjmk,.;/' ";
        GuitarString arr [] = new GuitarString [37];
        for(int i = 0; i < 37;i++){
            arr[i] = new GuitarString(440 * Math.pow(1.05956, i-24));
        }

        // the main input loop
        while (true) {

            // check if the user has typed a key, and, if so, process it
            if (StdDraw.hasNextKeyTyped()) {
                char key = StdDraw.nextKeyTyped();
                // the user types the netKeyTyped which is then plucked
                if(keyboard.indexOf(String.valueOf(key)) != -1)
                arr[keyboard.indexOf(key)].pluck();
            }

            // compute the superposition of the samples
            double sample = 0;
            for(GuitarString gs: arr){
                sample+=gs.sample();
            }


            // send the result to standard audio
            StdAudio.play(sample);

            // advance the simulation of each guitar string by one step
           for(GuitarString gs: arr){
            gs.tic();
           }
        }
    }

}
