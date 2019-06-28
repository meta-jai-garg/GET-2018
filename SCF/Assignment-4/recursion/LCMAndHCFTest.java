package recursion;

import org.junit.Assert;
import org.junit.Test;

public class LCMAndHCFTest {
    @Test
    public void findLCM() {
        Assert.assertEquals("Failure", 18, LCMAndHCF.findLCM(6, 9));
        Assert.assertEquals("Failure", 8, LCMAndHCF.findLCM(4, 8));
        Assert.assertEquals("Failure", 15, LCMAndHCF.findLCM(3, 5));
    }

    @Test
    public void findHCF() {
        Assert.assertEquals("Failure", 12, LCMAndHCF.findHCF(24, 36));
        Assert.assertEquals("Failure", 1, LCMAndHCF.findHCF(13, 31));
        Assert.assertEquals("Failure", 1, LCMAndHCF.findHCF(2, 3));
    }
}
