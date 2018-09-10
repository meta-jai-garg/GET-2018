package com.metacube.training.list_injection;

import java.util.List;

public class Course {

    private List<String> listOfSubjects;

    /**
     * @return the listOfSubjects
     */
    public List<String> getListOfSubjects() {
        return listOfSubjects;
    }

    /**
     * @param listOfSubjects the listOfSubjects to set
     */
    public void setListOfSubjects(List<String> listOfSubjects) {
        this.listOfSubjects = listOfSubjects;
    }
    
}
