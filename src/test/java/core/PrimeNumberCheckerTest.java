package core;
import java.io.*;
import java.util.*;

import org.hamcrest.Matcher;
import org.testng.*;
import org.testng.annotations.*;
import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.*;
import java.lang.reflect.Method;
public class PrimeNumberCheckerTest implements ITest{
        String csvFile = "/Users/val/workspace/HW_35/src/test/java/core/primes.csv";  //path to primes.csv 
       //  String csvFile = System.getProperty("testcases");  // mvn site -Dtestcases="./input.csv"
       private String test_name = "";
       public String getTestName()        {return test_name;}
       private void setTestName(String a) {test_name = a;}

       @BeforeMethod(alwaysRun = true)
       public void beforemethod(Method method, Object[] parameters) {
              setTestName(method.getName());
              Override a = method.getAnnotation(Override.class);
              String testCaseId = (String) parameters[a.id()];
              setTestName(testCaseId);}

       @DataProvider(name = "prime number")
       public Iterator<String[]> data() throws IOException {
              String csvLine = "";
              String[] a = null;
              ArrayList<String[]> al = new ArrayList<>();
              BufferedReader br = new BufferedReader(new FileReader(csvFile));
              while ((csvLine = br.readLine()) != null) {a = csvLine.split(","); al.add(a);}
              br.close();
              return al.iterator();}
       @Override // @Override(id = 0)
       @Test(timeOut = 1000, dataProvider = "prime number")
       public void test(String a, String b, String c) {
              assertThat(PrimeNumberChecker.validate(Integer.parseInt(b)), equalTo(Boolean.parseBoolean(c)));}
	private void assertThat(boolean validate, Matcher<Boolean> equalTo) {
		
	}
}