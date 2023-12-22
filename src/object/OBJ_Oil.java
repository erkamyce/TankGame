package object;

import java.io.IOException;

import javax.imageio.ImageIO;

public class OBJ_Oil extends SuperObject {

	public OBJ_Oil () {
		
		name = "Oil";
		try {
			image = ImageIO.read(getClass().getResourceAsStream("/objects/oil.png"));
		}catch(IOException e) {
			e.printStackTrace();
		}
	}
	
}
