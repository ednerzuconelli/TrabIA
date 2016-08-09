
public class Converter {
   	public int Converter(String letra, int index) {
		
		int in = 0;
		switch (index){
		case 0:
			if (letra == "A")
				in = 15;
			if (letra == "B")
				in = 30;
			if (letra == "C")
				in = 60;
			if (letra == "D")
				in = 80;
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
				in = 500;
			if (letra == "B")
				in = 1000;
			if (letra == "C")
				in = 1500;
			if (letra == "D")
				in = 2000;
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
