import java.awt.image.BufferedImage;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.ImageIcon;
/*
 * A Class to process all files of questions as a whole
 */
public class QuestionProcesser {
	//Create an arraylist for each question type
	ArrayList<Question> NumberSystem = new ArrayList<Question>();
	ArrayList<Question> Expand = new ArrayList<Question>();
	ArrayList<Question> Factorize = new ArrayList<Question>();
	ArrayList<Question> Simplify = new ArrayList<Question>();

	ArrayList<Question> Equation = new ArrayList<Question>();
	ArrayList<Question> Eqa_Application = new ArrayList<Question>();
	ArrayList<Question> Inequality = new ArrayList<Question>();

	ArrayList<Question> Exponents = new ArrayList<Question>();

	ArrayList<Question> Linear_f = new ArrayList<Question>();
	ArrayList<Question> Quadratic_f = new ArrayList<Question>();
	ArrayList<Question> Exponent_f = new ArrayList<Question>();
	ArrayList<Question> Trig_f = new ArrayList<Question>();
	ArrayList<Question> Hyperbole_f = new ArrayList<Question>();
	ArrayList<Question> Coordinate = new ArrayList<Question>();

	ArrayList<Question> Trignometry = new ArrayList<Question>();

	ArrayList<Question> Angle = new ArrayList<Question>();
	ArrayList<Question> Angle_Geo = new ArrayList<Question>();
	ArrayList<Question> Polygons = new ArrayList<Question>();
	//Constructor
	public QuestionProcesser() {
		this.NumberSystem = deepCopy(NumberSystem);
		this.Expand = deepCopy(Expand);
		this.Factorize = deepCopy(Factorize);
		this.Simplify = deepCopy(Simplify);

		this.Equation = deepCopy(Equation);
		this.Eqa_Application = deepCopy(Eqa_Application);
		this.Inequality = deepCopy(Inequality);

		this.Exponents = deepCopy(Exponents);

		this.Linear_f = deepCopy(Linear_f);
		this.Quadratic_f = deepCopy(Quadratic_f);
		this.Exponent_f = deepCopy(Exponent_f);
		this.Trig_f = deepCopy(Trig_f);
		this.Hyperbole_f = deepCopy(Hyperbole_f);
		this.Coordinate = deepCopy(Coordinate);

		this.Trignometry = deepCopy(Trignometry);

		this.Angle = deepCopy(Angle);
		this.Angle_Geo = deepCopy(Angle_Geo);
		this.Polygons = deepCopy(Polygons);
		try {
			fileRead();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	/**
	 * Deepcopy the given arrayList
	 * @param q
	 * @return
	 */
	public ArrayList<Question> deepCopy(ArrayList<Question> q) {
		ArrayList<Question> copy = new ArrayList<Question>();
		for (Question element : q) {
			copy.add(element);
		}
		return copy;
	}
	/**
	 * Get file and loop through all the files
	 * @param fileIn
	 * @return
	 * @throws IOException
	 */
	public ArrayList<Question> inputing(Scanner fileIn) throws IOException {
		ArrayList<Question> q = new ArrayList<Question>();

		int cnt = 0;
		while (fileIn.hasNextLine()) {// Loop through all lines in the file
			String line = fileIn.nextLine();// Store a line from a file
			
			if (!line.equals("")) {
				if (line.charAt(0) == '|') {//If the line starts with a |
					int[] pos = new int[5];//Create an array to store the index
					int p_cnt = 0;//Count how many | is in the line
					//Loop through and find all index of |
					for (int i = 0; i < line.length(); i++) {
						if (line.charAt(i) == '|')
							pos[p_cnt++] = i;
					}
					//If the line has correct number of |
					if (p_cnt == 5) {
						//Process through the line
						//Line format: |Difficulty|Question|Answer|Image_index|
						int difficulty = Integer.parseInt(line.substring(pos[0] + 1, pos[1]));
						String question = line.substring(pos[1] + 1, pos[2]);
						String answer = line.substring(pos[2] + 1, pos[3]);
						String image_index = line.substring(pos[3] + 1, pos[4]);
						q.add(new Question(difficulty, question, answer, image_index));		
					}
				}
			}
		}
		return deepCopy(q);//return the deepCopy
	}
	//Read the file and process them
	public void fileRead() throws IOException {
		Scanner fileIn = new Scanner(new File("./Questions/NumberSystem.txt"));
		NumberSystem = inputing(fileIn);
		fileIn = new Scanner(new File("./Questions/Expand.txt"));
		Expand = inputing(fileIn);
		fileIn = new Scanner(new File("./Questions/Factorize.txt"));
		Factorize = inputing(fileIn);
		fileIn = new Scanner(new File("./Questions/Simplify.txt"));
		Simplify = inputing(fileIn);

		fileIn = new Scanner(new File("./Questions/Equation.txt"));
		Equation = inputing(fileIn);
		fileIn = new Scanner(new File("./Questions/Eqa_Application.txt"));
		Eqa_Application = inputing(fileIn);
		fileIn = new Scanner(new File("./Questions/Inequality.txt"));
		Inequality = inputing(fileIn);

		fileIn = new Scanner(new File("./Questions/Exponents.txt"));
		Exponents = inputing(fileIn);

		fileIn = new Scanner(new File("./Questions/Linear.txt"));
		Linear_f = inputing(fileIn);
		fileIn = new Scanner(new File("./Questions/Quadratic.txt"));
		Quadratic_f = inputing(fileIn);
		fileIn = new Scanner(new File("./Questions/Exponent.txt"));
		Exponent_f = inputing(fileIn);
		fileIn = new Scanner(new File("./Questions/Hyperbole.txt"));
		Hyperbole_f = inputing(fileIn);
		fileIn = new Scanner(new File("./Questions/Coordinates.txt"));
		Coordinate = inputing(fileIn);
		fileIn = new Scanner(new File("./Questions/Trig.txt"));
		Trig_f = inputing(fileIn);

		fileIn = new Scanner(new File("./Questions/Trigonometry.txt"));
		Trignometry = inputing(fileIn);

		fileIn = new Scanner(new File("./Questions/Angle.txt"));
		Angle = inputing(fileIn);
		fileIn = new Scanner(new File("./Questions/Anlaytical Geo.txt"));
		Angle_Geo = inputing(fileIn);
		fileIn = new Scanner(new File("./Questions/Polygons.txt"));
		Polygons = inputing(fileIn);
	}
}
