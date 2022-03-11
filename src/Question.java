
import java.util.ArrayList;

public class Question {

	int dif;// Store difficulty of question
	String q;// Store question of question
	String ans;// Store the answer of question
	String image1_i = "-1";// Store the index of img1
	String image2_i = "-1";// Store the index of img
	// Constructor

	public Question(int difficulty, String question, String answer, String image_index) {
		this.dif = difficulty;
		this.q = question;
		this.ans = answer;
		// If the image_index is image
		if (image_index.equals("-1")) {
			this.image1_i = "-1";
			this.image2_i = "-1";
		} else {
			int c_location = image_index.indexOf(",");// Find the location of comma
			if (c_location != -1) {// If there is comma, means there is two images
				this.image1_i = image_index.substring(0, c_location);// Get string before comma
				this.image2_i = image_index.substring(c_location + 1, image_index.length());// Get string after
																							// comma
				image1_i = image1_i.replace(" ", "");// Get rid of spaces
				image2_i = image2_i.replace(" ", "");// Get rid of spaces

			} else {// If there is no comma, means there is only one image
				this.image1_i = image_index;// Set up img1 index
				this.image2_i = "-1";// Set up img2 index -1 means there is no image
				image1_i = image1_i.replace(" ", "");// Get rid of spaces
			}
		}
	}

	public ArrayList<String> giveElement(String s) {
		ArrayList<String> al = new ArrayList<String>();
		int[] indexStart = new int[100];
		int[] indexEnd = new int[100];
		int scnt = 0, ecnt = 0;
		for (int i = 0; i < 100; i++) {
			indexStart[i] = -1;
			indexEnd[i] = -1;
		}
		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) == '(')
				indexStart[scnt++] = i;
			else if (s.charAt(i) == ')')
				indexEnd[ecnt++] = i;
		}
		if (indexStart[0] == -1) {
			al.add(s);
			return deepCopy(al);
		}
		if (indexStart[0] != 0)
			al.add(s.substring(0, indexStart[0]));
		int range = (scnt < ecnt) ? scnt : ecnt;
		for (int i = 0; i < range; i++) {
			if (indexStart[i] < indexEnd[i]) {
				String str = s.substring(indexStart[i], indexStart[i + 1] + 1);
				al.add(str);
			}
		}
		al.add(s.substring(indexStart[range]));
		return deepCopy(al);

	}

	public ArrayList<String> deepCopy(ArrayList<String> a) {
		ArrayList<String> copy = new ArrayList<String>();
		for (String s : a) {
			copy.add(s);
		}
		return copy;
	}

	public boolean answer_check(String user_answer) {
		if (ans.indexOf("(") != ans.lastIndexOf("(")) {//If there is brackets
			ArrayList<String> ans_numerator = new ArrayList<String>();//Create numerator for ans
			ArrayList<String> ans_denomenator = new ArrayList<String>();//Create denomenator for ans
			ArrayList<String> user_numerator = new ArrayList<String>();//Create numerator for user_ans
			ArrayList<String> user_denomenator = new ArrayList<String>();//Create denomenator for user_ans
			String newans = ans.replaceAll("\\s+", "");//Create a string for newAns, getting rid of spaces
			user_answer = user_answer.replaceAll("\\s+", "");//Get rid of spaces
			if (ans.indexOf("/") != -1) {//If there is  division
				int indexDiv = newans.indexOf("/");//Find index of /
				ans_numerator = giveElement(newans.substring(0, indexDiv));//Input element of numerator
				ans_denomenator = giveElement(newans.substring(indexDiv) + 1);//Input element of denomenator
			} else {
				ans_numerator = giveElement(newans);
			}
			//Follow the same process above for the user_answer as well
			if (user_answer.indexOf("/") != -1) {
				int indexDiv = user_answer.indexOf("/");
				user_numerator = giveElement(user_answer.substring(0, indexDiv));
				user_denomenator = giveElement(user_answer.substring(indexDiv + 1));
			} else {
				user_numerator = giveElement(user_answer);
			}
			//Go through elements in the numerator of ans and user_ans
			for (String ans_s : ans_numerator) {
				boolean isCorrect = false;
				for (String user_s : user_numerator) {
					if (ans_s.equals(user_s)) {
						isCorrect = true;
						break;
					}
				}
				//If there is element in the user_numerator that is not in the answer_numerator
				if (!isCorrect) {
					return false;//return false
				}
			}
			//Go through elements in the denomenator of ans and user_ans
			for (String ans_s : ans_denomenator) {
				boolean isCorrect = false;
				for (String user_s : user_denomenator) {
					if (ans_s.equals(user_s)) {
						isCorrect = true;
						break;
					}
				}
				//If there is element in the user_denomenator that is not in the answer_denomenator
				if (!isCorrect) {
					return false;
				}
			}
			return true;
		} else
			return ans.replaceAll("\\s+", "").equalsIgnoreCase(user_answer.replaceAll("\\s+", ""));
	}
}
