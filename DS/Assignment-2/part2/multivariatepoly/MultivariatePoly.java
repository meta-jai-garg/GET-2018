package part2.multivariatepoly;

import java.util.ArrayList;
import java.util.List;

public class MultivariatePoly {
    List<Term> listOfTerms;

    public MultivariatePoly() {
        listOfTerms = new ArrayList<Term>();
    }

    public boolean addTerm(Term term) {
        return listOfTerms.add(term);
    }

    public boolean removeTerm(Term term) {
        return listOfTerms.remove(term);
    }

    public List<Term> getPolynomial() {
        return this.listOfTerms;
    }

    /**
     * creating the polynomial string by adding all the terms in the list
     *
     * @return
     */
    public String getPolyNomial() {
        String polynomial = "";
        for (Term term : listOfTerms) {
            polynomial = polynomial + term.getTerm();
        }
        return polynomial;
    }
}
