
public class Converter {
   	public int Converter(String letra, int index) {
		
		int in = 0;
		switch (index){
		case 0:
			if (letra == "A")
				in = 100;
			if (letra == "B")
				in = 300;
			if (letra == "C")
				in = 600;
			if (letra == "D")
				in = 900;
			break;
		case 1:
			if (letra == "A")
				in = 5;
			if (letra == "B")
				in = 10;
			if (letra == "C")
				in = 15;
			if (letra == "D")
				in = 20;
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
