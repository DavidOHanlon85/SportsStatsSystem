/**
 * 
 */
package p3;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * 
 */
public class WriteToFile implements Runnable {

	@Override
	public void run() {

		List<Player> localCopy = StartApp.players;

		File file2 = new File("playstats_updated.csv");

		try {
			FileWriter fw = new FileWriter(file2, false);
			BufferedWriter bw = new BufferedWriter(fw);

			bw.write("Last name, First name, Country");
			bw.newLine();
			for (Player p : localCopy) {
				String line = String.format("%s,  %s, %s", p.getLastName().toUpperCase(), p.getFirstName(),
						p.getCountry());
				bw.write(line);
				bw.newLine();
			}

			if (Thread.currentThread().isInterrupted()) {
				bw.close();
				fw.close();
			}

			bw.close();
			fw.close();

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
