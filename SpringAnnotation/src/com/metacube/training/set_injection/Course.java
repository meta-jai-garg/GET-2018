package com.metacube.training.set_injection;

import java.util.Set;

public class Course {

    private Set<String> setOfSubjects;

    
    /**
     * @return the setOfSubjects
     */
    public Set<String> getSetOfSubjects() {
        return setOfSubjects;
    }

    
    /**
     * @param setOfSubjects the setOfSubjects to set
     */
    public void setSetOfSubjects(Set<String> setOfSubjects) {
        this.setOfSubjects = setOfSubjects;
    }  
}
