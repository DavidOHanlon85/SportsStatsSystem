/**
 * 
 */
package p3;

import java.util.Comparator;

/**
 * @author - Daithi O hAnluain - 15621049
 */
public class CompareByHeight implements Comparator<Player> {

	@Override
	public int compare(Player o1, Player o2) {

		if (o1.getHeightInMetres() > o2.getHeightInMetres()) {
			return 1;
		} else if (o1.getHeightInMetres() < o2.getHeightInMetres()) {
			return -1;
		} else {
			return 0;
		}

	}

}
