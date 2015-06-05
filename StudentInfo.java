import javax.persistence.*;

import java.io.*;

@Entity(name = "student_info")
public class StudentInfo implements Serializable{
	
	@Id
	@Column(name = "Name")
	private String name;
	  
	@Column(name = "basicLetterGameScore")
	private int basicLetterGameScore;
	  
	@Column(name = "basicNumberGameScore")
	private int basicNumberGameScore;
	
	@Column(name = "basicAnimalGameScore")
	private int basicAnimalGameScore;
	
	@Column(name = "advLetterGameScore")
	private int advLetterGameScore;
	
	@Column(name = "advCountingGameScore")
	private int advCountingGameScore;
	
	public StudentInfo(){
		this(null, 0, 0, 0, 0, 0);
	}

	public StudentInfo(String s, int i, int j, int k, int m, int n) {
		name = s;
		basicLetterGameScore = i;
		basicNumberGameScore = j;
		basicAnimalGameScore = k;
		advLetterGameScore = m;
		advCountingGameScore = n;
	}
	
	public String getStudentName(){
		return name;
	}
	
	public void setStudentName(String n){
		name = n;
	}
	
	public int getBasicLetterGameScore(){
		return basicLetterGameScore;
	}
	
	public void setBasicLetterGameScore(int s){
		basicLetterGameScore = s;
	}
	
	public int getBasicNumberGameScore(){
		return basicNumberGameScore;
	}
	
	public void setBasicNumberGameScore(int s){
		basicNumberGameScore = s;
	}
	
	public int getBasicAnimalGameScore(){
		return basicAnimalGameScore;
	}
	
	public void setBasicAnimalGameScore(int s){
		basicAnimalGameScore = s;
	}
	
	
	public int getAdvLetterGameScore(){
		return advLetterGameScore;
	}
	
	public void setAdvLetterGameScore(int s){
		advLetterGameScore = s;
	}
	
	public int getAdvCountingGameScore(){
		return advCountingGameScore;
	}
	
	public void setAdvCountingGameScore(int s){
		advCountingGameScore = s;
	}
	
}
