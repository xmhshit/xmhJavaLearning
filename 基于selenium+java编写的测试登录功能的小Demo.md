# test
#         基于selenium+Java的测试登录功能的小Demo

##### **项目简介**：

通过Page Object设计模式，对界面交互细节进行封装，增加代码复用性，提高测试用例的可维护性，以下是一个测试登录功能的简单demo。

##### **一、应用技术**

工具：IntelliJ IDEA

环境：JDK1.8、selenium、maven

##### **二、功能**

这是一个简单登录的测试脚本，通过selenium

##### **三、具体实现**

1、对driver、url、username、password变量进行封装，代码如下：

```java
public class LoginPage {
    private WebDriver driver;
    private String url;

    public LoginPage(WebDriver driver, String url) {
        this.driver = driver;
        this.url = url;
        this.driver.get(this.url);
    }

    public String getTitle() {
        return this.driver.getTitle();
    }

    public boolean isLoaded() {
        System.out.println(this.getTitle());
        return "我的这个小管家是没有 title的，我也不知道怎么处理，因为将title设置为 null 会报空指针错误，那就这样吧".equals(this.getTitle());
    }

    public boolean login(String username, String password) {
        this.driver.findElement(By.xpath(".//*[@id='username']")).sendKeys(new CharSequence[]{username});
        this.driver.findElement(By.xpath(".//*[@id='password']")).sendKeys(new CharSequence[]{password});
        this.driver.findElement(By.xpath(".//*[@id='login']")).click();
        return "我的这个小管家是没有 title的，我也不知道怎么处理，因为将title设置为 null 会报空指针错误，那就这样吧".equals(this.getTitle());
    }

    public static class Contants {
        public static final String TITLE = "我的这个小管家是没有 title的，我也不知道怎么处理，因为将title设置为 null 会报空指针错误，那就这样吧";
        public static final String USERNAME_XPATH = ".//*[@id='username']";
        public static final String PASSWORD_XPATH = ".//*[@id='password']";
        public static final String LOGIN_BUTTON_XPATH = ".//*[@id='login']";

        public Contants() {
        }
    }
}
```

2、通过4组数据对登录流程进行测试，验证登录功能，代码如下：

```java
public class LoginPageTest {
    private static final String URL = "http://47.98.101.146:8080/xgj/page/login.jsp";
    private WebDriver driver;
    private LoginPage loginPage;

    public LoginPageTest() {
    }

    @BeforeMethod
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "c:\\Program Files (x86)\\Google\\Chrome\\Application\\chromedriver.exe");
        this.driver = new ChromeDriver();
        this.loginPage = new LoginPage(this.driver, "http://47.98.101.146:8080/xgj/page/login.jsp");
    }

    @Test
    public void testLogin0() throws InterruptedException {
        Assert.assertEquals(false, this.loginPage.login("1", "1"));
        Thread.sleep(8000L);
    }

    @Test
    public void testLogin1() throws InterruptedException {
        Assert.assertEquals(false, this.loginPage.login("123456", "123456"));
        Thread.sleep(8000L);
    }

    @Test
    public void testLogin2() throws InterruptedException {
        Assert.assertEquals(false, this.loginPage.login("1", "123456"));
        Thread.sleep(8000L);
    }

    @Test
    public void testLogin3() throws InterruptedException {
        Assert.assertEquals(false, this.loginPage.login("123456789", "123456789"));
        Thread.sleep(8000L);
    }

    @AfterMethod
    public void shutDown() {
        System.out.println("关闭浏览器");
        this.driver.quit();
    }
}
```

