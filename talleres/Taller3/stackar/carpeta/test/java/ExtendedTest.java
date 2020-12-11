import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class ExtendedTest {

    @Test
    public void test0001() throws Throwable {
        org.autotest.StackAr stackAr1 = new org.autotest.StackAr((int) (short) 0);
        org.junit.Assert.assertTrue(stackAr1.repOK());
    }

    @Test
    public void test0002() throws Throwable {
        org.autotest.StackAr stackAr1 = new org.autotest.StackAr((int) (short) 0);
        int hashcode = stackAr1.hashCode();
        if (hashcode < 31*31) {
            org.junit.Assert.fail("Expected hashcode is not OK");
        }
    }

    @Test
    public void test0003() throws Throwable {
        org.autotest.StackAr stackAr1 = new org.autotest.StackAr((int) (short) 0);
        if (!stackAr1.equals(stackAr1)) {
            org.junit.Assert.fail("Expected equals");
        }
    }

    @Test
    public void test0004() throws Throwable {
        org.autotest.StackAr stackAr1 = new org.autotest.StackAr((int) 10);
        stackAr1.push(1);
        org.junit.Assert.assertTrue(stackAr1.repOK());
    }

    @Test
    public void test0005() throws Throwable {
        org.autotest.StackAr stackAr1 = new org.autotest.StackAr((int) 10);
        org.junit.Assert.assertTrue(stackAr1.repOK());
    }


    @Test
    public void test0006() throws Throwable {
        org.autotest.StackAr stackAr1 = new org.autotest.StackAr((int) 1);
        stackAr1.push(1);
        org.junit.Assert.assertTrue(stackAr1.repOK());
    }

    @Test
    public void test0007() throws Throwable {
        org.autotest.StackAr stackAr1 = new org.autotest.StackAr(1);
        int hashcode = stackAr1.hashCode();
        org.junit.Assert.assertTrue(hashcode == 1921);
    }

    public void test0008() throws Throwable {
        org.autotest.StackAr stackAr1 = new org.autotest.StackAr(1);
        stackAr1.push(1);
        int hashcode = stackAr1.hashCode();
        org.junit.Assert.assertTrue(hashcode == 1953);
    }
}