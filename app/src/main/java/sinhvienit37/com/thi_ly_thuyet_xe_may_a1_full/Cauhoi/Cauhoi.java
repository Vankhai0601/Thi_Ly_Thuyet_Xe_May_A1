package sinhvienit37.com.thi_ly_thuyet_xe_may_a1_full.Cauhoi;

import java.io.Serializable;

/**
 * Created by ADMIN on 11/12/2016.
 */
public class Cauhoi implements Serializable{
    private  int _id;
    private  String question;
    private  String ans_1;
    private  String ans_2;
    private  String ans_3;
    private  String ans_4;
    private  String result;
    private  int num_exam;
    private  String subject;
    private  String image;
    private  String traloi="";
    public int choiID= -1;// Hỗ trợ check id của radioGrup

    public String getTraloi(){
        return traloi;

    }

    public void setTraloi(String traloi){
        this.traloi = traloi;
    }

    public Cauhoi(int _id, String question, String ans_1, String ans_2, String ans_3, String ans_4, String result, int num_exam, String subject, String image, String traloi) {
        this._id = _id;
        this.question = question;
        this.ans_1 = ans_1;
        this.ans_2 = ans_2;
        this.ans_3 = ans_3;
        this.ans_4 = ans_4;
        this.result = result;
        this.num_exam = num_exam;
        this.subject = subject;
        this.image = image;
        this.traloi = traloi;
    }

    public Cauhoi() {
    }

    public int get_id() {
        return _id;
    }

    public void set_id(int _id) {
        this._id = _id;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getAns_1() {
        return ans_1;
    }

    public void setAns_1(String ans_1) {
        this.ans_1 = ans_1;
    }

    public String getAns_2() {
        return ans_2;
    }

    public void setAns_2(String ans_2) {
        this.ans_2 = ans_2;
    }

    public String getAns_3() {
        return ans_3;
    }

    public void setAns_3(String ans_3) {
        this.ans_3 = ans_3;
    }

    public String getAns_4() {
        return ans_4;
    }

    public void setAns_4(String ans_d) {
        this.ans_4 = ans_4;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public int getNum_exam() {
        return num_exam;
    }

    public void setNum_exam(int num_exam) {
        this.num_exam = num_exam;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}
