package com.metacube.training.constructor_injection;

public class SpellChecker {
    private boolean status;
    
    /**
     * @param status
     */
    public SpellChecker(boolean status) {
        this.status = status;
    }
    
    /**
     * @return the status
     */
    public boolean isStatus() {
        return status;
    }
    
}
