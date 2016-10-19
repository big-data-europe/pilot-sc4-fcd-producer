package eu.bde.sc4pilot.fcd;

import java.io.IOException;

/**
 * Pick whether we want to run as producer or consumer. This lets us
 * have a single executable as a build target.
 */
public class Main {
    public static void main(String[] args) throws IOException {
        if (args.length < 2) {
            throw new IllegalArgumentException("Must have either 'producer' or 'consumer' as first argument \n"
                + "a Kafka topic as second argument, and a source URI as third argument for a producer. \n"
                + "A consumer of a Kafka topic will send the send to the console.");
        }
        
        try {
		    switch (args[0]) {
		        case "producer":
		            FcdProducer.main(args);
		            break;
		        case "consumer":
		            FcdConsumer.main(args);
		            break;
		        default:
		            throw new IllegalArgumentException("Don't know how to do " + args[0]);
		    }
        }
        catch(Exception e){
        	e.printStackTrace();
        }
    }
}
