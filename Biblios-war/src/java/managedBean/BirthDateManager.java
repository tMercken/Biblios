/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package managedBean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import model.BirthDate;


@Named(value = "birthDateManager")
@SessionScoped
public class BirthDateManager implements Serializable {

     public BirthDateManager() {
        this.generateDays();
        this.generateEnglishMonths();
        this.generateYears();
    }
    
    public void generateDays() {
        this.days = new ArrayList<>();
        
        for (int i=1; i <= 31; i++) {
            BirthDate bd = new BirthDate(i+"","day"+i,i+"");
            this.days.add(bd);
        }            
    }
    
    public void generateEnglishMonths() {
        this.months = new ArrayList<>();
        this.months.add(new BirthDate("January","month1","1"));
        this.months.add(new BirthDate("February","month2","2"));
        this.months.add(new BirthDate("March","month3","3"));
        this.months.add(new BirthDate("April","month4","4"));
        this.months.add(new BirthDate("May","month5","5"));
        this.months.add(new BirthDate("June","month6","6"));
        this.months.add(new BirthDate("July","month7","7"));
        this.months.add(new BirthDate("August","month8","8"));
        this.months.add(new BirthDate("September","month9","9"));
        this.months.add(new BirthDate("October","month10","10"));
        this.months.add(new BirthDate("November","month11","11"));
        this.months.add(new BirthDate("December","month12","12"));
    }
    
    public void generateFrenchMonths() {
        this.months = new ArrayList<>();
        this.months.add(new BirthDate("Janvier","month1","1"));
        this.months.add(new BirthDate("Fevier","month2","2"));
        this.months.add(new BirthDate("Mars","month3","3"));
        this.months.add(new BirthDate("Avril","month4","4"));
        this.months.add(new BirthDate("Mai","month5","5"));
        this.months.add(new BirthDate("Juin","month6","6"));
        this.months.add(new BirthDate("Juillet","month7","7"));
        this.months.add(new BirthDate("Aout","month8","8"));
        this.months.add(new BirthDate("Septembre","month9","9"));
        this.months.add(new BirthDate("Octobre","month10","10"));
        this.months.add(new BirthDate("Novembre","month11","11"));
        this.months.add(new BirthDate("Decembre","month12","12"));
    }
    
    public void generateYears() { 
        this.years = new ArrayList<>();        
        int year = Calendar.getInstance().get(Calendar.YEAR);
        
        for (int i=year; i >= year-100; i--) {
             BirthDate bd = new BirthDate(i+"","year"+i,i+"");
            this.years.add(bd);
        }
    }

    public ArrayList<BirthDate> getDays() {
        return days;
    }

    public void setDays(ArrayList<BirthDate> days) {
        this.days = days;
    }

    public ArrayList<BirthDate> getMonths() {
        return months;
    }

    public void setMonths(ArrayList<BirthDate> months) {
        this.months = months;
    }

    public ArrayList<BirthDate> getYears() {
        return years;
    }

    public void setYears(ArrayList<BirthDate> years) {
        this.years = years;
    }
    
    private ArrayList <BirthDate> days;
    private ArrayList <BirthDate> months;
    private ArrayList <BirthDate> years;
    
}
