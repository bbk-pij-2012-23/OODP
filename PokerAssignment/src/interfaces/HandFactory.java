package interfaces;

import java.util.ArrayList;

/**
 * 
 * @author eleanormann
 *
 * @param <T>
 */
public interface HandFactory<T> {
	ArrayList<T> calculateHand(ArrayList<T> hand);
}

