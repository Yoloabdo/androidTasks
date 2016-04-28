package com.example.task1;

public class Q {
	String Text;
	String [] Options;
	public int CorrectIndex;
	public Q(String t, String [] os , int inx)
	{
		Text=t;
		Options = os;
		CorrectIndex=inx;
	}
	public boolean IsCorrect(String answer)
	{
		return Options[CorrectIndex].equals(answer);
	}
}
