#mobliletest8.homework.week7
*   [作业1：用Python Requests模块模拟GET和POST请求](#hw1)
    *   [1. Create a class extends unittest.TestCase, add two methods(test_get and test_post):](#hw1-1)
    *   [2. Run the test:](#hw1-2)
*   [作业2：用Rest Assured模拟GET和POST请求](#hw2)
    *   [1. Create a maven project, add necessary dependencies in pom.xml:](#hw2-1)
    *   [2. Create a test class and 3 methods:](#hw2-2)
*   [作业3：在项目中实践Maven, TestNG, Data Provider](#hw3)
    *   [1. Create a class with data provider method:](#hw3-1)
    *   [2. Run the test: Right click on the RestAssuredTest.java, select Run As > TestNG Test:](#hw3-2)


<h2 id="hw1">作业1：用Python Requests模块模拟GET和POST请求</h2>        
*__Pecondition__: Python Eclipse env is ready.*  
In my case, the APIs are:  
http://httpbin.org/get  
http://httpbin.org/post  


###<h3 id="hw1-1">1. Create a class extends unittest.TestCase, add two methods(test_get and test_post):</h3>

```python  
#!/usr/bin/env python
# -*- coding: utf-8 -*-
import unittest
import requests
import json
 
class PythonRequestsTest(unittest.TestCase):
    def setUp(self):
        #预置环境
        print '--------------Python Requests Test SetUp--------------\n'
    def tearDown(self): 
        #清理环境
        print '--------------Python Requests Test Clear--------------\n' 
         
    def test_get(self):
        print 'test_get:'
        url = "http://httpbin.org/get"  #测试的接口url
        headers = {'content-type': 'application/json'}
        r = requests.get(url=url, headers=headers)
        self.assertEqual(url, r.url, "url is wrong")
    
    def test_post(self):              
        print 'test_post:'
        pqyload = {'a':'homework1','b':'post test'}
        r = requests.post('http://httpbin.org/post',params = pqyload)
        data = r.json()
        self.assertEqual("homework1", data['args']['a'], "The value of 'a' is wrong")
        self.assertEqual("post test", data['args']['b'], "The value of 'b' is wrong")
        
        
def suite():
    suite = unittest.TestSuite()
    suite.addTest(PythonRequestsTest("test_get"))
    suite.addTest(PythonRequestsTest("test_post"))
    unittest.TextTestRunner().run(suite)
     
if __name__ == '__main__':
    suite()#执行suite
    
```
See [PythonRequestsTest.py] as well.

###<h3 id="hw1-2">2. Run the test</h3>

Right click on the [PythonRequestsTest.py], select Run As > Python unit-test:  
    
    


    Finding files... done.
    Importing test modules ... done.
    
    --------------Python Requests Test SetUp--------------
    
    test_get:
    --------------Python Requests Test Clear--------------
    
    --------------Python Requests Test SetUp--------------
    
    test_post:
    --------------Python Requests Test Clear--------------
    
    ----------------------------------------------------------------------
    Ran 2 tests in 5.574s
    
    OK

<h2 id="hw2">作业2：用Rest Assured模拟GET和POST请求</h2>		

###<h3 id="hw2-1">1. Create a maven project, add necessary dependencies in pom.xml:</h3>
```xml
<dependencies>
    <dependency>
      <groupId>junit</groupId>
      <artifactId>junit</artifactId>
      <version>4.1</version>
      <scope>test</scope>
    </dependency>
    <dependency>
		<groupId>org.testng</groupId>
		<artifactId>testng</artifactId>
		<version>6.9.10</version>
		<scope>test</scope>
	</dependency>
    <dependency>
      <groupId>com.jayway.restassured</groupId>
      <artifactId>rest-assured</artifactId>
      <version>2.8.0</version>
    </dependency>
    <dependency>
      <groupId>org.hamcrest</groupId>
      <artifactId>hamcrest-core</artifactId>
      <version>1.3</version>
    </dependency>
    <dependency>
      <groupId>com.jayway.restassured</groupId>
      <artifactId>json-schema-validator</artifactId>
      <version>2.8.0</version>
    </dependency>
  </dependencies>
```
See [pom.xml] as well.

###<h3 id="hw2-2">2. Create a test class and 3 methods:</h3>
```java
public class RestAssuredTest {
	@BeforeClass
    public void before() {
        RestAssured.baseURI = "http://httpbin.org";
        //RestAssured.port = 80;
    }

    @Test
    //URL为http://httpbin.org/get
    //判断Json中的返回信息url
    public void testGet() {
        get("/get").then().body("url", equalTo("http://httpbin.org/get"));
    }

    @Test(dataProvider="dataprovider1",dataProviderClass=DataProviderMethod.class)
  //URL为http://httpbin.org/post
    public void testPost(String a, String b) {
    	ValidatableResponse resp = given().param("a", a).param("b", b).when().post("/post").then();
    	resp.body("form.a", equalTo(a), "form.b", equalTo(b));
    }
/*    public void testPost() {
    	ValidatableResponse resp = given().param("a", "homework2").param("b", "rest assured").when().post("/post").then();
    	resp.body("form.a", equalTo("homework2"), "form.b", equalTo("rest assured"));
    }*/

    @Test
    public void testJsonScheme() {
        given().headers("content-type","application/json").when().get("/get").then().assertThat().body(matchesJsonSchemaInClasspath("httpbin.json"));
    }

    @AfterClass
    public void after() {
    }
}
```
See [RestAssuredTest.java] and [httpbin.json] as well.


<h2 id="hw3">作业3：在项目中实践Maven, TestNG, Data Provider</h2>		
*__Note__: Please refer to the project of homework2.*

###<h3 id="hw3-1">1. Create a class with data provider method:</h3>
```java
public class DataProviderMethod {
	@DataProvider(name="dataprovider1")
	public static Object[][] dataProvider1(){
		return new Object[][]{
				{"a1", "b1"},
				{"a2", "b2"},
				{"a3", "b3"}
		};
	}
}
```
See [DataProviderMethod.java] as well.

###<h3 id="hw3-2">2. Run the test: Right click on the RestAssuredTest.java, select Run As > TestNG Test:</h3>

    [TestNG] Running:
    C:\Users\Michael\AppData\Local\Temp\testng-eclipse-1052233306\testng-customsuite.xml
    
    PASSED: testGet
    PASSED: testJsonScheme
    PASSED: testPost("a1", "b1")
    PASSED: testPost("a2", "b2")
    PASSED: testPost("a3", "b3")
    
    ===============================================
    Default test
    Tests run: 5, Failures: 0, Skips: 0
    ===============================================
    
    
    ===============================================
    Default suite
    Total tests run: 5, Failures: 0, Skips: 0
    ===============================================
    
    [TestNG] Time taken by org.testng.reporters.jq.Main@11028347: 178 ms
    [TestNG] Time taken by org.testng.reporters.XMLReporter@2437c6dc: 21 ms
    [TestNG] Time taken by org.testng.reporters.JUnitReportReporter@2e5c649: 13 ms
    [TestNG] Time taken by org.testng.reporters.SuiteHTMLReporter@ed17bee: 84 ms
    [TestNG] Time taken by [FailedReporter passed=0 failed=0 skipped=0]: 13 ms
    [TestNG] Time taken by org.testng.reporters.EmailableReporter2@383534aa: 13 ms



[PythonRequestsTest.py]: https://github.com/mobiletest8/mobiletest8.homework.wanmich/blob/master/week7/python-requests-test/src/com/wanmich/python_requests_test/pythonrequeststest.py
[pom.xml]: https://github.com/mobiletest8/mobiletest8.homework.wanmich/blob/master/week7/rest-assured-test/pom.xml
[RestAssuredTest.java]: https://github.com/mobiletest8/mobiletest8.homework.wanmich/blob/master/week7/rest-assured-test/src/test/java/com/wanmich/rest_assured_test/RestAssuredTest.java
[httpbin.json]: https://github.com/mobiletest8/mobiletest8.homework.wanmich/blob/master/week7/rest-assured-test/src/test/resources/httpbin.json
[DataProviderMethod.java]: https://github.com/mobiletest8/mobiletest8.homework.wanmich/blob/master/week7/rest-assured-test/src/test/java/com/wanmich/rest_assured_test/DataProviderMethod.java

