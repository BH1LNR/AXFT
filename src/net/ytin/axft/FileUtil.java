package net.ytin.axft;

/**** List of All Imported Classes ***/

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.lang.Object;
import java.lang.String;
import java.util.ArrayList;
import java.util.List;
import net.ytin.axft.FileException;

// End of Import

public class FileUtil {

//  CLASS: net.ytin.axft.FileUtil:
	public static final List<String> readLine2List(String filePath) throws FileException {
		BufferedReader br = null;
		File file = null;
		IOException e = null;
		List list = null;
		String target = null;

		File JdecGenerated2 = new File(filePath);
		file = JdecGenerated2;
		ArrayList<String> JdecGenerated11 = new ArrayList<String>();
		list = JdecGenerated11;
		br = null;

		try {
			BufferedReader JdecGenerated21 = new BufferedReader(
					new InputStreamReader(new FileInputStream(file), "UTF-8"));
			br = JdecGenerated21;

			target = null;

			while (true)

			{
				target = (br.readLine());

				if (target != null) {

					if (target.trim().length() > 0) {
						list.add(target);

					}

				} else {
					break;
				}
			}
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		return JdecGenerated11;

	}
}