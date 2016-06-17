
public class Converter {
   	public int Converter(String letra, int index) {
		
		int in = 0;
		switch (index){
		case 0:
			if (letra == "A")
				in = 25;
			if (letra == "B")
				in = 50;
			if (letra == "C")
				in = 100;
			if (letra == "D")
				in = 150;
			break;
		case 1:
			if (letra == "A")
				in = 10;
			if (letra == "B")
				in = 20;
			if (letra == "C")
				in = 30;
			if (letra == "D")
				in = 40;
			break;
		case 2:
			if (letra == "A")
				in = 5000;
			if (letra == "B")
				in = 10000;
			if (letra == "C")
				in = 15000;
			if (letra == "D")
				in = 20000;
			break;
		case 3:
			if (letra == "A")
				in = 50;
			if (letra == "B")
				in = 100;
			if (letra == "C")
				in = 150;
			if (letra == "D")
				in = 200;
			break;
		case 4:
			if (letra == "A")
				in = 10;
			if (letra == "B")
				in = 25;
			if (letra == "C")
				in = 50;
			if (letra == "D")
				in = 80;
			break;
		}
		
		return in;
	}

	
    
	
}
