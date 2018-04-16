package com.example.android.miwok;


public class ReportCard {

    private double mBiologyGrade;
    private double mMathGrade;
    private double mHistoryGrade;
    private double mEnglishGrade;

    public ReportCard(double biologyGrade, double mathGrade, double historyGrade, double englishGrade){
        mBiologyGrade = biologyGrade;
        mMathGrade = mathGrade;
        mHistoryGrade = historyGrade;
        mEnglishGrade = englishGrade;
    }

    public String toString(){
        String output;

        output = "Biology: " + mBiologyGrade + "/n" +
                "Math: " + mMathGrade + "/n" +
                "Histroy: " + mHistoryGrade + "/n" +
                "English: " + mEnglishGrade;

        return output;
    }
}
