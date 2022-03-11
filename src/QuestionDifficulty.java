import java.util.ArrayList;
//A class that categorize questions based on their difficulty
public class QuestionDifficulty {
	ArrayList<Question> dif1 = new ArrayList<Question>();
	ArrayList<Question> dif2 = new ArrayList<Question>();
	ArrayList<Question> dif3 = new ArrayList<Question>();
	ArrayList<Question> dif4 = new ArrayList<Question>();
	ArrayList<Question> dif5 = new ArrayList<Question>();
	//Constructor
	public QuestionDifficulty() {
		this.dif1 = dif1;
		this.dif2 = dif2;
		this.dif3 = dif3;
		this.dif4 = dif5;
		this.dif5 = dif5;

	}
	/*
	 * Give the element of given index
	 */
	public Question giveElement(int level, int index) {
		Question q;//Get question
		switch (level) {
		case 1://if level is 1
			q = dif1.get(index);//give question in lv1 index
			dif1.remove(index);//remove question
			break;
		case 2:
			q = dif2.get(index);//give question in lv2 index
			dif2.remove(index);//remove question
			break;
		case 3:
			q = dif3.get(index);//give question in lv3 index
			dif3.remove(index);//remove question
			break;
		case 4:
			q = dif4.get(index);//give question in lv4 index
			dif4.remove(index);//remove question
			break;
		case 5:
			q = dif5.get(index);//give question in lv5 index
			dif5.remove(index);//remove question
			break;
		default:
			q = null;
			break;
		}
		return q;//Return question class
	}
	//Give how many elements are inside each difficulty arraylist
	public int giveSize(int level) {
		int size = 0;
		//Get level and return the size of the following level arraylist
		switch (level) {
		case 1:
			size = dif1.size();
			break;
		case 2:
			size = dif2.size();
			break;
		case 3:
			size = dif3.size();
			break;
		case 4:
			size = dif4.size();
			break;
		case 5:
			size = dif5.size();
			break;
		}
		return size;
	}
}