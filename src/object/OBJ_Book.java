package object;

import java.io.IOException;

import javax.imageio.ImageIO;

public class OBJ_Book extends SuperObject {

public OBJ_Book () {
		
		name = "Book";
		try {
			image = ImageIO.read(getClass().getResourceAsStream("/objects/kitap.png"));
		}catch(IOException e) {
			e.printStackTrace();
		}
	}

}
