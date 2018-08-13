package part2;

import java.util.List;

public class GetValue {
    @SuppressWarnings("unchecked")
    /**
     * it returns value from specified index pattern
     * string “TH” states that go to the tail of the given nested list,
     * from that nested list pick up the first value.
     * If this first value is a list then the method should return an error.
     * @param nestedList first level of nested list
     * @param specifiedPosition string of position
     * @return value at specified position
     * @throws AssertionError when there is no integer at specified position
     */
    public int getValue(List<Object> nestedList,String specifiedPosition) {
        Object nestedListObject=nestedList;

        validate(nestedList,specifiedPosition);

        char specifiedPositionCahracter;
        for(int i=0;i<specifiedPosition.length();i++) {

            specifiedPositionCahracter=specifiedPosition.charAt(i);
            switch(specifiedPositionCahracter) {

                //if string character is T
                case 'T':
                    nestedListObject=((List<Object>) nestedListObject).get(((List<Object>) nestedListObject).size()-1);
                    if(i!=specifiedPosition.length()-1) {

                        //throws error if string has more character and object at specified position is an Integer
                        if(nestedListObject instanceof Integer) {
                            throw new AssertionError("Should be an instance of list");   					}
                    }
                    else {
                        if(nestedListObject instanceof Integer) {
                            return (int) nestedListObject;
                        }
                        //throws error if string doesn't have more character and object at specified position is a list
                        else {
                            throw new AssertionError("Should be an instance of Integer");
                        }
                    }



                    break;
                case 'H':
                    nestedListObject=((List<Object>) nestedListObject).get(0);
                    if(i!=specifiedPosition.length()-1) {
                        //throws error if string has more character and object at specified position is an Integer
                        if(nestedListObject instanceof Integer) {
                            throw new AssertionError("Should be an instance of list");
                        }
                    }
                    else {
                        if(nestedListObject instanceof Integer) {
                            return (int) nestedListObject;
                        }
                        //throws error if string doesn't have more character and object at specified position is a list
                        else {
                            throw new AssertionError("Should be an instance of Integer");
                        }
                    }
                    break;
                default:
                    throw new IllegalStateException("Wrong String Input");
            }
        }
        return 0;
    }
    /**
     * validate equation
     * @param nestedList
     * @param specifiedPosition
     */
    private void validate(List<Object> nestedList, String specifiedPosition){
        if(nestedList.size()==0){
            throw new NullPointerException("List is empty");
        }
        if(specifiedPosition.length()==0){
            throw new AssertionError("NoSpecified Position");
        }
    }
}
