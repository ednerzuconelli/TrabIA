
public class Converter {
   	public int Converter(String letra, int index) {
		
		int in = 0;
		switch (index){
		case 0:
			if (letra == "A")
				in = 100;
			if (letra == "B")
				in = 200;
			if (letra == "C")
				in = 300;
			if (letra == "D")
				in = 400;
			break;
		case 1:
			if (letra == "A")
				in = 50;
			if (letra == "B")
				in = 75;
			if (letra == "C")
				in = 100;
			if (letra == "D")
				in = 125;
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
				in = 200;
			if (letra == "B")
				in = 500;
			if (letra == "C")
				in = 750;
			if (letra == "D")
				in = 1000;
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
