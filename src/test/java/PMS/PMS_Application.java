package PMS;

import net.bytebuddy.asm.Advice;
import org.apache.commons.io.output.ByteArrayOutputStream;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import javax.swing.*;
import java.io.PrintStream;
import java.nio.charset.StandardCharsets;
import java.security.Key;
import java.sql.Driver;
import java.time.Duration;
import java.util.List;

import static PMS.Allure_Helper_Class.*;


public class PMS_Application {

    // Enter your Credential of PMS
    String PMS_UserName = "";
    String PMS_Password = "";

    // Enter Your Name
    String Name = "";
    String Exclametry = "!";

    @Test(priority = 1)
    public void Login_Test() throws InterruptedException {

        // This is for Print Outputs`
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        PrintStream originalOut = System.out;
        System.setOut(new PrintStream(baos));

        // To Disable Notification
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-notifications");

        WebDriver driver = new ChromeDriver(options);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));
        WebDriverWait wait7 = new WebDriverWait(driver, Duration.ofSeconds(7));
        // Sandbox

        // DEV Sandbox
        // URL
        System.out.println("\n");
        driver.get("https://test.pms.cloudprism.in/login.php");

        //Wait for the user id to appear
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//input[@type=\"email\"]")));

        // Maximize Window
        driver.manage().window().maximize();

        // Printing the Url
        String URL = driver.getCurrentUrl();
        System.out.println("URL: " + URL);

        // Taking Screenshot for login Page UI
        captureScreenshot(driver, "Login UI");

        // 1. Login with Invalid user id and password

        System.out.println("====================================================================\n");
        System.out.println("1. Login with Invalid user id and password");
        System.out.println("====================================================================\n");

        driver.findElement(By.name("email")).sendKeys("User@Name");
        driver.findElement(By.name("password")).sendKeys("Pass.word");
        driver.findElement(By.xpath("//button[@type=\"submit\"]")).click();

        // Actual and Expected Result

        WebElement Waring_Message = wait7.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class=\"alert alert-danger\"]")));
        String Warning_Message_Store = Waring_Message.getText();

        String Expected_For_Invalid_Cred = "Username or password is incorrect.";
        String Actual_For_Invalid_Cred = Warning_Message_Store;

        // Taking Screenshot for Toast Message
        captureScreenshot(driver, Actual_For_Invalid_Cred);

        try {
            Assert.assertEquals(Actual_For_Invalid_Cred, Expected_For_Invalid_Cred);
            System.out.println("Test Passed! ");
            System.out.println("Warning Toast Message : " + Actual_For_Invalid_Cred);
        } catch (AssertionError e) {
            System.out.println("Test Failed! \n Expected: " + Expected_For_Invalid_Cred + "\n But got: " + Actual_For_Invalid_Cred);
        }
        // System.out.println("====================================================================\n");

        // 2. Login with Invalid user id and password is Correct

        // Refresh the current page
        driver.navigate().refresh();

        //Wait for the user id to appear
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//input[@type=\"email\"]")));

        // Login Now
        System.out.println("====================================================================\n");
        System.out.println("2. Login with Invalid user id and password is Correct");
        System.out.println("====================================================================\n");

        driver.findElement(By.name("email")).sendKeys("User@Name");
        driver.findElement(By.name("password")).sendKeys(PMS_Password);
        driver.findElement(By.xpath("//button[@type=\"submit\"]")).click();

        // Actual and Expected Result

        WebElement Waring_Message_for_Wrong_password = wait7.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class=\"alert alert-danger\"]")));
        String Warning_Message_for_Wrong_password_Store = Waring_Message_for_Wrong_password.getText();

        String Expected_For_Invalid_Password = "Username or password is incorrect.";
        String Actual_For_Invalid_Password = Warning_Message_for_Wrong_password_Store;

        // Taking Screenshot for Toast Message
        captureScreenshot(driver, Actual_For_Invalid_Password);

        try {
            Assert.assertEquals(Actual_For_Invalid_Password, Expected_For_Invalid_Password);
            System.out.println("Test Passed! ");
            System.out.println("Warning Toast Message : " + Actual_For_Invalid_Password);
        } catch (AssertionError e) {
            System.out.println("Test Failed! \n Expected: " + Expected_For_Invalid_Password + "\n But got: " + Actual_For_Invalid_Password);
        }
        // System.out.println("====================================================================\n");

        // 3. Login with Invalid user id and password is Correct

        // Refresh the current page
        driver.navigate().refresh();

        //Wait for the user id to appear
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//input[@type=\"email\"]")));

        // Login Now

        System.out.println("====================================================================\n");
        System.out.println("3. Login with Correct userid and password is Wrong");
        System.out.println("====================================================================\n");

        driver.findElement(By.name("email")).sendKeys(PMS_UserName);
        driver.findElement(By.name("password")).sendKeys("Password");
        driver.findElement(By.xpath("//button[@type=\"submit\"]")).click();

        // Actual and Expected Result

        WebElement Waring_Message_for_Wrong_userId = wait7.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class=\"alert alert-danger\"]")));
        String Warning_Message_for_Wrong_userId_Store = Waring_Message_for_Wrong_userId.getText();

        String Expected_For_Invalid_userId = "Username or password is incorrect.";
        String Actual_For_Invalid_userId = Warning_Message_for_Wrong_userId_Store;

        // Taking Screenshot for Toast Message
        captureScreenshot(driver, Actual_For_Invalid_userId);

        try {
            Assert.assertEquals(Actual_For_Invalid_userId, Expected_For_Invalid_userId);
            System.out.println("Test Passed! ");
            System.out.println("Warning Toast Message : " + Actual_For_Invalid_userId);
        } catch (AssertionError e) {
            System.out.println("Test Failed! \n Expected: " + Expected_For_Invalid_userId + "\n But got: " + Actual_For_Invalid_userId);
        }
        // System.out.println("====================================================================\n");

        // 4. Login with Correct userid and Correct password

        // Refresh the current page
        driver.navigate().refresh();

        //Wait for the user id to appear
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//input[@type=\"email\"]")));

        // Login Now

        System.out.println("====================================================================\n");
        System.out.println("4. Login with Null userid and null password");
        System.out.println("====================================================================\n");

        WebElement Userid = driver.findElement(By.name("email"));
        Userid.sendKeys("USER@NULL");
        WebElement Password = driver.findElement(By.name("password"));
        Password.sendKeys("NULLNULL");
        driver.findElement(By.xpath("//button[@type=\"submit\"]")).click();

        // Now clear the field for userid and password

        Userid.clear();
        Password.clear();

        // Actual and Expected Result

        WebElement Waring_Message_for_Null = wait7.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class=\"alert alert-danger\"]")));
        String Warning_Message_for_Null = Waring_Message_for_Null.getText();

        String Expected_For_Null = "Username or password is incorrect.";
        String Actual_For_Null = Warning_Message_for_Null;

        // Taking Screenshot for Toast Message
        captureScreenshot(driver, Actual_For_Null);

        try {
            Assert.assertEquals(Actual_For_Null, Expected_For_Null);
            System.out.println("Test Passed! ");
            System.out.println("Warning Toast Message : " + Actual_For_Null);
        } catch (AssertionError e) {
            System.out.println("Test Failed! \n Expected: " + Expected_For_Null + "\n But got: " + Actual_For_Null);
        }
        // System.out.println("====================================================================\n");

        // 5. Login with Correct userid and Correct password

        // Refresh the current page
        driver.navigate().refresh();

        //Wait for the user id to appear
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//input[@type=\"email\"]")));

        // Login Now

        System.out.println("====================================================================\n");
        System.out.println("5. Login with Correct userid and Correct password");
        System.out.println("====================================================================\n");

        driver.findElement(By.name("email")).sendKeys(PMS_UserName);
        driver.findElement(By.name("password")).sendKeys(PMS_Password);
        driver.findElement(By.xpath("//button[@type=\"submit\"]")).click();

        // Actual and Expected Result

        WebElement Waring_Message_for_Correct_cred = wait7.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='card-body']")));
        String Warning_Message_for_Correct_cred_Store = Waring_Message_for_Correct_cred.getText();

        //String Expected_For_Correct_cred = "Welcome Mayank Jha!";
        String Expected_For_Correct_cred = "Welcome " + Name + Exclametry;
        String Actual_For_Correct_cred = Warning_Message_for_Correct_cred_Store;

//        // Debug this
//        System.out.println(" Print Message " + Warning_Message_for_Correct_cred_Store);
//
//        System.out.println("Expected: " + Expected_For_Correct_cred + " | Length: " + Expected_For_Correct_cred.length());
//        System.out.println("Actual: " + Actual_For_Correct_cred + " | Length: " + Actual_For_Correct_cred.length());

        // Taking Screenshot for Toast Message
        captureScreenshot(driver, Actual_For_Correct_cred);

        try {
            Assert.assertEquals(Actual_For_Correct_cred, Expected_For_Correct_cred);
            System.out.println("Test Passed! ");
            System.out.println("Warning Toast Message : " + Actual_For_Correct_cred);
        } catch (AssertionError e) {
            System.out.println("Test Failed! \n Expected: " + Expected_For_Correct_cred + "\n But got: " + Actual_For_Correct_cred);
        }
        System.out.println("====================================================================\n");

        // Allure Report Console Logs Attachment
        Allure_Helper_Class.attachConsoleLogs(driver, "ConsoleLogs");

        // This is for Console output in allure reports
        System.setOut(originalOut);
        String consoleOutput = baos.toString(StandardCharsets.UTF_8);
        Allure_Helper_Class.attachConsoleOutput(consoleOutput, "ConsoleOutput");

        driver.quit();

    }

    @Test(priority = 2)
    public void Dashboard() {

        // This is for Print Outputs
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        PrintStream originalOut = System.out;
        System.setOut(new PrintStream(baos));

        // To Disable Notification
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-notifications");

        WebDriver driver = new ChromeDriver(options);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));
        WebDriverWait wait7 = new WebDriverWait(driver, Duration.ofSeconds(7));
        // Sandbox

        // DEV Sandbox
        // URL
        System.out.println("\n");
        driver.get("https://test.pms.cloudprism.in/login.php");

        //Wait for the user id to appear
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//input[@type=\"email\"]")));

        // Maximize Window
        driver.manage().window().maximize();

        // Printing the Url
        String URL = driver.getCurrentUrl();
        System.out.println("URL: " + URL);

        driver.findElement(By.name("email")).sendKeys(PMS_UserName);
        driver.findElement(By.name("password")).sendKeys(PMS_Password);
        driver.findElement(By.xpath("//button[@type=\"submit\"]")).click();

        // Actual and Expected Result

        WebElement Waring_Message_for_Correct_cred = wait7.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='card-body']")));
        String Warning_Message_for_Correct_cred_Store = Waring_Message_for_Correct_cred.getText();

        //String Expected_For_Correct_cred = "Welcome Mayank Jha!";
        String Expected_For_Correct_cred = "Welcome " + Name + Exclametry;
        String Actual_For_Correct_cred = Warning_Message_for_Correct_cred_Store;

//        // Debug this
//        System.out.println(" Print Message " + Warning_Message_for_Correct_cred_Store);
//
//        System.out.println("Expected: " + Expected_For_Correct_cred + " | Length: " + Expected_For_Correct_cred.length());
//        System.out.println("Actual: " + Actual_For_Correct_cred + " | Length: " + Actual_For_Correct_cred.length());

        // Taking Screenshot
        captureScreenshot(driver, Actual_For_Correct_cred);

        try {
            Assert.assertEquals(Actual_For_Correct_cred, Expected_For_Correct_cred);
            System.out.println("Test Passed! ");
            System.out.println("Welcome Message : " + Actual_For_Correct_cred);
        } catch (AssertionError e) {
            System.out.println("Test Failed! \n Expected: " + Expected_For_Correct_cred + "\n But got: " + Actual_For_Correct_cred);
        }
        System.out.println("====================================================================\n");

        // 1. Match Total Project Number with the Number of projects (Project Progress)

        System.out.println("====================================================================\n");
        System.out.println("1. Projects in Table Should be Matched with Number of Project Displayed");
        System.out.println("====================================================================\n");

        WebElement Total_Project = driver.findElement(By.xpath("(//a[@href=\"./index.php?page=project_list\"])[2]/h3"));
        String Total_Project_Displayed = Total_Project.getText();

        // Extract numeric value from the displayed text
        int Total_Projects_Displayed;
        try {
            Total_Projects_Displayed = Integer.parseInt(Total_Project_Displayed.replaceAll("[^0-9]", "")); // Remove non-numeric characters
        } catch (NumberFormatException e) {
            System.out.println("Error parsing total projects displayed: " + e.getMessage());
            return; // Exit if parsing fails
        }

        // Now Count the Number of rows
        List<WebElement> RowCount = driver.findElements(By.xpath("//table/tbody/tr"));
        int Total_Projects_in_Table = RowCount.size();

        try {
            Assert.assertEquals(Total_Projects_in_Table, Total_Projects_Displayed);
            System.out.println("Test Passed! ");
            System.out.println("Projects in Table Matched with Number of Project Displayed i.e.: " + Total_Projects_in_Table);
        } catch (AssertionError e) {
            System.out.println("Test Failed! \n Expected: " + Total_Projects_Displayed + "\n But got: " + Total_Projects_in_Table);
        }
        System.out.println("====================================================================\n");

        // Allure Report Console Logs Attachment
        Allure_Helper_Class.attachConsoleLogs(driver, "ConsoleLogs");

        // This is for Console output in allure reports
        System.setOut(originalOut);
        String consoleOutput = baos.toString(StandardCharsets.UTF_8);
        Allure_Helper_Class.attachConsoleOutput(consoleOutput, "ConsoleOutput");

        // Quit the browser
        driver.quit();

    }

    @Test(priority = 3)
    public void Daily_Status() throws InterruptedException {

        // This is for Print Outputs`
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        PrintStream originalOut = System.out;
        System.setOut(new PrintStream(baos));

        // To Disable Notification
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-notifications");

        WebDriver driver = new ChromeDriver(options);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));
        WebDriverWait wait7 = new WebDriverWait(driver, Duration.ofSeconds(7));
        // Sandbox

        // DEV Sandbox
        // URL
        System.out.println("\n");
        driver.get("https://test.pms.cloudprism.in/login.php");

        //Wait for the user id to appear
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//input[@type=\"email\"]")));

        // Maximize Window
        driver.manage().window().maximize();

        // Printing the Url
        String URL = driver.getCurrentUrl();
        System.out.println("URL: " + URL);

        driver.findElement(By.name("email")).sendKeys(PMS_UserName);
        driver.findElement(By.name("password")).sendKeys(PMS_Password);
        driver.findElement(By.xpath("//button[@type=\"submit\"]")).click();

        // Actual and Expected Result

        WebElement Waring_Message_for_Correct_cred = wait7.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='card-body']")));
        String Warning_Message_for_Correct_cred_Store = Waring_Message_for_Correct_cred.getText();

        //String Expected_For_Correct_cred = "Welcome Mayank Jha!";
        String Expected_For_Correct_cred = "Welcome " + Name + Exclametry;
        String Actual_For_Correct_cred = Warning_Message_for_Correct_cred_Store;

//        // Debug this
//        System.out.println(" Print Message " + Warning_Message_for_Correct_cred_Store);
//
//        System.out.println("Expected: " + Expected_For_Correct_cred + " | Length: " + Expected_For_Correct_cred.length());
//        System.out.println("Actual: " + Actual_For_Correct_cred + " | Length: " + Actual_For_Correct_cred.length());

        try {
            Assert.assertEquals(Actual_For_Correct_cred, Expected_For_Correct_cred);
            System.out.println("Test Passed! ");
            System.out.println("Welcome Message : " + Actual_For_Correct_cred);
        } catch (AssertionError e) {
            System.out.println("Test Failed! \n Expected: " + Expected_For_Correct_cred + "\n But got: " + Actual_For_Correct_cred);
        }
        System.out.println("====================================================================\n");

        System.out.println("====================================================================\n");
        System.out.println("1. Verifying Daily Status Menu on Heading ");
        System.out.println("====================================================================\n");

        // Click on Daily Status Menu
        WebElement Daily_Status_Menu = wait7.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@class=\"nav-link nav-edit_user\"]")));
        Daily_Status_Menu.click();

        // Now Clicking on Add New
        Thread.sleep(2000);
        WebElement Add_New = wait7.until(ExpectedConditions.elementToBeClickable(By.xpath("(//*[text()='Add New'])[2]")));
        Add_New.click();

        //Verify the Daily Status heading
        // Actual and Expected Result

        WebElement Daily_Staus_Heading = wait7.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class=\"col-sm-6\"]/h1")));
        String Daily_Staus_Heading_Store = Daily_Staus_Heading.getText();

        //String Expected_For_Correct_cred = "Welcome Mayank Jha!";
        String Expected_For_Daily_Staus = "Daily Status";
        String Actual_For_Daily_Staus = Daily_Staus_Heading_Store;

        // Taking Screenshot
        captureScreenshot(driver, Actual_For_Daily_Staus);

        // Error Handling
        try {
            Assert.assertEquals(Actual_For_Daily_Staus, Expected_For_Daily_Staus);
            System.out.println("Test Passed! ");
            System.out.println("Welcome Message : " + Actual_For_Daily_Staus);
        } catch (AssertionError e) {
            System.out.println("Test Failed! \n Expected: " + Expected_For_Daily_Staus + "\n But got: " + Actual_For_Daily_Staus);
        }

        System.out.println("====================================================================\n");
        System.out.println("2. Creating New Task ");
        System.out.println("====================================================================\n");

        //Click on Project and selecting any One project
        Actions Action_Class = new Actions(driver);

        WebElement Click_On_Project_Name = wait7.until(ExpectedConditions.elementToBeClickable(By.xpath("//select[@name=\"project_id\"]")));
        Action_Class.moveToElement(Click_On_Project_Name).click().build().perform();

        //Selecting the Value
        List<WebElement> Projects = driver.findElements(By.xpath("//select[@name=\"project_id\"]/option"));
        //System.out.println(Projects.size()-1 + " Projects");
        for (int i = 1; i < Projects.size(); i++) {
            Projects.get(17).click();
            Action_Class.sendKeys(Keys.ENTER).build().perform();
        }

        // Now Entering the Task Title
        String Title = "New Project + Testing this Component + Automation of this Page";

        WebElement Task_Title = wait7.until(ExpectedConditions.elementToBeClickable(By.id("task_id")));
        Action_Class.moveToElement(Task_Title).click().sendKeys(Title).build().perform();

        // Now Entering the Description of the Project
        String Description_Text = "Project Name: Streamlined Workflow Automation\\n\" +\n" +
                "                \"\\n\" +\n" +
                "                \"Description:\\n\" +\n" +
                "                \"This project focuses on automating the New Component interface to enhance user interactions and improve operational efficiency. The primary goals include:\\n\" +\n" +
                "                \"\\n\" +\n" +
                "                \"\\t•\\tAutomating User Actions: Implementing automation tools to streamline routine tasks, reducing manual effort.\\n\" +\n" +
                "                \"\\t•\\tComprehensive Testing: Conducting functional and non-functional testing to ensure reliability and meet user requirements.\\n\" +\n" +
                "                \"\\t•\\tUser Experience Improvement: Providing a more intuitive interface to minimize load times and enhance satisfaction.\\n\" +\n" +
                "                \"\\n\" +\n" +
                "                \"Using tools like Selenium and TestNG, we will establish a robust automation framework for scheduled testing and detailed reporting, ultimately increasing productivity and maintaining high-quality standards.";

        WebElement Description = wait7.until(ExpectedConditions.elementToBeClickable(By.id("comment")));
        Action_Class.moveToElement(Description).click().sendKeys(Description_Text).build().perform();

        // Now Selecting the Start Date
        WebElement Start_Date = wait7.until(ExpectedConditions.elementToBeClickable(By.name("start_time")));
        Action_Class.moveToElement(Start_Date).click().sendKeys("10:00AM").build().perform();

        // now Selecting the End Date
        WebElement End_Date = wait7.until(ExpectedConditions.elementToBeClickable(By.name("end_time")));
        Action_Class.moveToElement(End_Date).click().sendKeys("8:00PM").build().perform();

        // Taking Screenshot
        captureScreenshot(driver, "Data");

        // Now Save the Daily Status ... Clicking on Save Button
        WebElement Save_btn = wait7.until(ExpectedConditions.elementToBeClickable(By.id("saveButton")));
        Action_Class.moveToElement(Save_btn).click().build().perform();

        // Success Toast Message

        // Actual and Expected Result
        WebElement Daily_Status_Toast_Message = wait7.until(ExpectedConditions.elementToBeClickable(By.id("swal2-title")));
        String Daily_Status_Toast_Message_Store = Daily_Status_Toast_Message.getText();


        String Expected_For_Daily_Status_Toast_Message = "Data successfully saved.";
        String Actual_For_Daily_Status_Toast_Message = Daily_Status_Toast_Message_Store;

        // Taking Screenshot
        captureScreenshot(driver, Actual_For_Daily_Status_Toast_Message);

        // Error Handling
        try {
            Assert.assertEquals(Actual_For_Daily_Status_Toast_Message, Expected_For_Daily_Status_Toast_Message);
            System.out.println("Test Passed! ");
            System.out.println("Toast Message : " + Actual_For_Daily_Status_Toast_Message);
        } catch (AssertionError e) {
            System.out.println("Test Failed! \n Expected: " + Expected_For_Daily_Status_Toast_Message + "\n But got: " + Actual_For_Daily_Status_Toast_Message);
        }

        // Checking the Save button is Disabled or not After click on save

        System.out.println("====================================================================\n");
        System.out.println("3. Checking Save Button is disabled after save");
        System.out.println("====================================================================\n");
        try {
            if (!Save_btn.isEnabled()) {
                // Taking Screenshot
                captureScreenshot(driver, "Save button is Disabled");

                System.out.println("Test Passed! ");
                System.out.println("Save button is Disabled");
            }
        } catch (Exception e) {
            System.out.println("Test Failed!");
            System.out.println("Save Button is Enabled");

            // Taking a screenshot in case of an exception
            captureScreenshot(driver, "Exception occurred or Save button is Enabled");
        }

        // Checking with null fields

        System.out.println("====================================================================\n");
        System.out.println("4. Checking if Fields are not filled and still blank");
        System.out.println("====================================================================\n");

        // Again click on Add New
        Thread.sleep(2000);
        Add_New = wait7.until(ExpectedConditions.elementToBeClickable(By.xpath("(//*[text()='Add New'])[2]")));
        //Add_New.click();
        Action_Class.moveToElement(Add_New).click().build().perform();

        //Again Click on project Name Section
        Click_On_Project_Name = wait7.until(ExpectedConditions.elementToBeClickable(By.xpath("//select[@name=\"project_id\"]")));
        Click_On_Project_Name.click();
        Action_Class.moveToElement(Click_On_Project_Name).click().build().perform();

        //Selecting the Project
        List<WebElement> Selecting_Projects = driver.findElements(By.xpath("//select[@name=\"project_id\"]/option"));
        //System.out.println(Projects.size()-1 + " Projects");
        for (int i = 1; i < Selecting_Projects.size(); i++) {
            Selecting_Projects.get(17).click();
            Action_Class.sendKeys(Keys.ENTER).build().perform();
        }

        //Enter the texts in Description

        // Now Entering the Description of the Project
        WebElement Description_Writing = wait7.until(ExpectedConditions.elementToBeClickable(By.id("comment")));
        Action_Class.moveToElement(Description_Writing).click().sendKeys(Description_Text).build().perform();

        // Taking Screenshot
        captureScreenshot(driver, "Fileds are blank");

        // Now again we have to click on Save button
        Save_btn = wait7.until(ExpectedConditions.elementToBeClickable(By.id("saveButton")));
        Action_Class.moveToElement(Save_btn).click().build().perform();

        // Rest of them are still blank to check the Validation

        // Actual and Expected Result
        WebElement Warning_Toast_Message = wait7.until(ExpectedConditions.elementToBeClickable(By.id("swal2-title")));
        String Warning_Toast_Message_Store = Warning_Toast_Message.getText();


        String Expected_For_Daily_Status_Warning_Toast_Message = "Please fill all the fields. All fields are required.";
        String Actual_For_Daily_Status_Warning_Toast_Message = Warning_Toast_Message_Store;

        // Taking Screenshot
        captureScreenshot(driver, Actual_For_Daily_Status_Warning_Toast_Message);

        // Error Handling
        try {
            Assert.assertEquals(Actual_For_Daily_Status_Warning_Toast_Message, Expected_For_Daily_Status_Warning_Toast_Message);
            System.out.println("Test Passed! ");
            System.out.println("Toast Message : " + Actual_For_Daily_Status_Warning_Toast_Message);
        } catch (AssertionError e) {
            System.out.println("Test Failed! \n Expected: " + Expected_For_Daily_Status_Warning_Toast_Message + "\n But got: " + Actual_For_Daily_Status_Warning_Toast_Message);
        }

        //5. Checking with Back Date while Creating New Daily Status
        System.out.println("====================================================================\n");
        System.out.println("5. Checking with back date !!! ");
        System.out.println("====================================================================\n");

        Click_On_Project_Name = wait7.until(ExpectedConditions.elementToBeClickable(By.xpath("//select[@name=\"project_id\"]")));
        Action_Class.moveToElement(Click_On_Project_Name).click().build().perform();

        //Again Selecting the Value
        List<WebElement> Projects2 = driver.findElements(By.xpath("//select[@name=\"project_id\"]/option"));
        //System.out.println(Projects.size()-1 + " Projects");
        for (int i = 1; i < Projects2.size(); i++) {
            Projects2.get(17).click();
            Action_Class.sendKeys(Keys.ENTER).build().perform();
        }

        // Now Entering the Task Title
        String Title2 = "This is the Title for the back date check ";

        Task_Title = wait7.until(ExpectedConditions.elementToBeClickable(By.id("task_id")));
        Action_Class.moveToElement(Task_Title).click().sendKeys(Title2).build().perform();

        // Now Entering the Description of the Project
        String Description_Text2 = "Project Name: Streamlined Workflow Automation\\n\" +\n" +
                "                \"\\n\" +\n" +
                "                \"Description:\\n\" +\n" +
                "                \"This project focuses on automating the New Component interface to enhance user interactions and improve operational efficiency. The primary goals include:\\n\" +\n" +
                "                \"\\n\" +\n" +
                "                \"\\t•\\tAutomating User Actions: Implementing automation tools to streamline routine tasks, reducing manual effort.\\n\" +\n" +
                "                \"\\t•\\tComprehensive Testing: Conducting functional and non-functional testing to ensure reliability and meet user requirements.\\n\" +\n" +
                "                \"\\t•\\tUser Experience Improvement: Providing a more intuitive interface to minimize load times and enhance satisfaction.\\n\" +\n" +
                "                \"\\n\" +\n" +
                "                \"Using tools like Selenium and TestNG, we will establish a robust automation framework for scheduled testing and detailed reporting, ultimately increasing productivity and maintaining high-quality standards.";

        Description = wait7.until(ExpectedConditions.elementToBeClickable(By.id("comment")));
        Action_Class.moveToElement(Description).click().sendKeys(Description_Text2).build().perform();

        // Now Selecting the Start Date
        Start_Date = wait7.until(ExpectedConditions.elementToBeClickable(By.name("start_time")));
        Action_Class.moveToElement(Start_Date).click().sendKeys("10:00AM").build().perform();

        // now Selecting the End Date
        End_Date = wait7.until(ExpectedConditions.elementToBeClickable(By.name("end_time")));
        Action_Class.moveToElement(End_Date).click().sendKeys("8:00PM").build().perform();

        //Now Select the Previous Date
        WebElement back_date = wait7.until(ExpectedConditions.elementToBeClickable(By.name("date")));
        Action_Class.moveToElement(back_date).click().sendKeys("15/10/2024").build().perform();

        // Wait for 7 second
        Thread.sleep(7000);

        // Taking Screenshot
        captureScreenshot(driver, "Back Date");

        // Now Save the Daily Status ... Clicking on Save Button
        Save_btn = wait7.until(ExpectedConditions.elementToBeClickable(By.id("saveButton")));
        Action_Class.moveToElement(Save_btn).click().build().perform();

        // Success Toast Message
        // Actual and Expected Result
        WebElement Daily_Status_Toast_Message_for_back_date = wait7.until(ExpectedConditions.elementToBeClickable(By.id("swal2-title")));
        String Daily_Status_Toast_Message_for_back_date_Store = Daily_Status_Toast_Message_for_back_date.getText();


        String Expected_For_Daily_Status_Toast_Message_for_back_date = "Data successfully saved.";
        String Actual_For_Daily_Status_Toast_Message_for_back_date = Daily_Status_Toast_Message_for_back_date_Store;

        // Taking Screenshot
        captureScreenshot(driver, Actual_For_Daily_Status_Toast_Message_for_back_date);

        // Error Handling
        try {
            Assert.assertEquals(Actual_For_Daily_Status_Toast_Message_for_back_date, Expected_For_Daily_Status_Toast_Message_for_back_date);
            System.out.println("Test Passed! ");
            System.out.println("Toast Message : " + Actual_For_Daily_Status_Toast_Message_for_back_date);
        } catch (AssertionError e) {
            System.out.println("Test Failed! \n Expected: " + Expected_For_Daily_Status_Toast_Message_for_back_date + "\n But got: " + Actual_For_Daily_Status_Toast_Message_for_back_date);
        }

        //6. Checking with Back Date while Creating New Daily Status
        System.out.println("====================================================================\n");
        System.out.println("6. Checking Work Report !!! ");
        System.out.println("====================================================================\n");

        WebElement List = wait7.until(ExpectedConditions.elementToBeClickable(By.xpath(" //a[@href=\"./index.php?page=work_report\"]")));
        Action_Class.moveToElement(List).click().build().perform();

        //Matching Heading with Expected and Actual
        // Actual and Expected Result
        WebElement List_Heading = wait7.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class=\"col-sm-6\"]/h1")));
        String List_Heading_Store = List_Heading.getText();


        String Expected_List_Heading = "Work Report";
        String Actual_List_Heading = List_Heading_Store;

        // Taking Screenshot
        captureScreenshot(driver, Actual_List_Heading);
        // Error Handling
        try {
            Assert.assertEquals(Actual_List_Heading, Expected_List_Heading);
            System.out.println("Test Passed! ");
            System.out.println("Toast Message : " + Actual_List_Heading);
        } catch (AssertionError e) {
            System.out.println("Test Failed! \n Expected: " + Expected_List_Heading + "\n But got: " + Actual_List_Heading);
        }

        // Now Selecting the User
        WebElement Users = wait7.until(ExpectedConditions.elementToBeClickable(By.id("user")));
        Action_Class.moveToElement(Users).click().build().perform();

        // Selecting the user
        //Again Selecting the Value
        List<WebElement> User_Selection = driver.findElements(By.xpath("//select[@name=\"user\"]/option"));
        //  System.out.println(User_Selection.size());
        for (int i = 0; i < User_Selection.size(); i++) {
            User_Selection.get(0).click();
            WebElement User_option = User_Selection.get(i);
            User_option.click(); // Selects the option
            //Action_Class.moveToElement(User_option).click().build().perform();
            String selectedText = User_option.getText(); // Retrieves the displayed text of the selected option
            System.out.println("Selected Text: " + User_Selection.size() + ". " + selectedText);
            Action_Class.sendKeys(Keys.ENTER).build().perform();
        }

        // Date From

        WebElement Date_From = wait7.until(ExpectedConditions.elementToBeClickable(By.name("date_from")));
        //Action_Class.moveToElement(Date_From).click().sendKeys("01/10/2024").build().perform();

        Action_Class.moveToElement(Date_From).click()
                .sendKeys(Keys.HOME).sendKeys(Keys.ARROW_LEFT).sendKeys(Keys.ARROW_LEFT)// Move cursor to the start
                .sendKeys("01")
                .sendKeys("10")
                .sendKeys("2024")
                .build().perform();

        // Date To
        WebElement Date_To = wait7.until(ExpectedConditions.elementToBeClickable(By.name("date_from")));
        Action_Class.moveToElement(Date_To).click()
                .sendKeys(Keys.TAB).sendKeys(Keys.TAB)// Move cursor to the start
                .sendKeys("28")
                .sendKeys("10")
                .sendKeys("2024")
                .build().perform();
        // Taking Screenshot
        captureScreenshot(driver, "Daily Status Lists");
        // Click on Show
        Action_Class.sendKeys(Keys.TAB).sendKeys(Keys.TAB).sendKeys(Keys.ENTER).build().perform();

        // Now Change Shorting to 100 to print all the Table Data
        WebElement Entries = wait7.until(ExpectedConditions.elementToBeClickable(By.name("list_length")));
        Action_Class.moveToElement(Entries).click().build().perform();

        List<WebElement> Sorting = driver.findElements(By.xpath("//select[@name=\"list_length\"]/option"));
        System.out.println(Sorting.size());
        for (int i = 0; i < Sorting.size(); i++) {
            Sorting.get(3).click();
            WebElement User_option = Sorting.get(i);
            User_option.click(); // Selects the option
            //Action_Class.moveToElement(User_option).click().build().perform();
            // String selectedText = User_option.getText(); // Retrieves the displayed text of the selected option
            // System.out.println("Selected Text: " + Sorting.size() + ". " + selectedText);
            //Action_Class.sendKeys(Keys.ENTER).build().perform();
        }

        // Click on a random position on the page, e.g., x=100, y=100
        Actions actions = new Actions(driver);
        actions.moveByOffset(100, 100).click().perform();


        // Click on Search
        String project_Name = "test12345";
        WebElement Search = wait7.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@type=\"search\"]")));
        Action_Class.moveToElement(Search).click().sendKeys(project_Name).build().perform();

        // Taking Screenshot
        captureScreenshot(driver, "project --> " + project_Name);

        // Print all the Table Data
        List<WebElement> Table_Data = driver.findElements(By.xpath("//table/tbody/tr"));
        for (WebElement element : Table_Data) {
            System.out.println(element.getText());
            // Taking Screenshot
            captureScreenshot(driver, "Inside Table");
        }

        //       If the result is not found handle the situation
        try {
            // Check if the element is present and displayed
            if (driver.findElement(By.xpath("//*[text()='No matching records found']")).isDisplayed()) {
                System.out.println("====================================================================\n");
                System.out.println("No Data Found on Table");

                // Taking Screenshot
                captureScreenshot(driver, "No Data Found on Table");

                // Quit the driver if no data is found
                driver.quit();
                return;
            }
        } catch (NoSuchElementException e) {
            // Handle the case when the element is not found
            // Taking Screenshot
            captureScreenshot(driver, "Data is present in the table");
            System.out.println("Data is present in the table.");
        }


        //7. Checking with Back Date while Creating New Daily Status
        System.out.println("====================================================================\n");
        System.out.println("7. Checking Edit Button !!! ");
        System.out.println("====================================================================\n");
        //Checking Edit
        WebElement Edit_button = wait7.until(ExpectedConditions.elementToBeClickable(By.xpath("(//a[@class=\"dropdown-item\"])[3]")));
        Action_Class.moveToElement(Edit_button).click().build().perform();

        //click on Description >> Select All >> Delete
        WebElement Description_Click = wait7.until(ExpectedConditions.elementToBeClickable(By.name("comment")));
        Description_Click.clear();
        Action_Class.moveToElement(Description_Click).click().sendKeys("Updated Texts").build().perform();

        // Taking Screenshot
        captureScreenshot(driver, "Data");

        // Click on Save and get Toast Message
        Save_btn = wait7.until(ExpectedConditions.elementToBeClickable(By.id("saveButton")));
        Action_Class.moveToElement(Save_btn).click().build().perform();

        // Success Toast Message

        // Actual and Expected Result
        WebElement Save_Toast_Message = wait7.until(ExpectedConditions.elementToBeClickable(By.id("swal2-title")));
        String Save_Toast_Message_Store = Save_Toast_Message.getText();


        String Expected_For_Save_Toast_Message = "Data successfully saved.";
        String Actual_For_Save_Toast_Message = Save_Toast_Message_Store;

        // Taking Screenshot
        captureScreenshot(driver, Actual_For_Save_Toast_Message);

        // Error Handling
        try {
            Assert.assertEquals(Actual_For_Save_Toast_Message, Expected_For_Save_Toast_Message);
            System.out.println("Test Passed! ");
            System.out.println("Toast Message : " + Actual_For_Save_Toast_Message);
        } catch (AssertionError e) {
            System.out.println("Test Failed! \n Expected: " + Expected_For_Save_Toast_Message + "\n But got: " + Actual_For_Daily_Status_Toast_Message);
        }

        //8. Checking with Back Date while Creating New Daily Status
        System.out.println("====================================================================\n");
        System.out.println("8. Checking Delete Button !!! ");
        System.out.println("====================================================================\n");

        // Now Selecting the User
        Users = wait7.until(ExpectedConditions.elementToBeClickable(By.id("user")));
        Action_Class.moveToElement(Users).click().build().perform();

        // Selecting the user
        //Again Selecting the Value
        User_Selection = driver.findElements(By.xpath("//select[@name=\"user\"]/option"));
        //  System.out.println(User_Selection.size());
        for (int i = 0; i < User_Selection.size(); i++) {
            User_Selection.get(0).click();
            WebElement User_option = User_Selection.get(i);
            User_option.click(); // Selects the option
            //Action_Class.moveToElement(User_option).click().build().perform();
            String selectedText = User_option.getText(); // Retrieves the displayed text of the selected option
            // System.out.println("Selected Text: " + User_Selection.size() + ". " + selectedText);
            Action_Class.sendKeys(Keys.ENTER).build().perform();
        }

        // Date From

        Date_From = wait7.until(ExpectedConditions.elementToBeClickable(By.name("date_from")));
        //Action_Class.moveToElement(Date_From).click().sendKeys("01/10/2024").build().perform();

        Action_Class.moveToElement(Date_From).click()
                .sendKeys(Keys.HOME).sendKeys(Keys.ARROW_LEFT).sendKeys(Keys.ARROW_LEFT)// Move cursor to the start
                .sendKeys("01")
                .sendKeys("10")
                .sendKeys("2024")
                .build().perform();

        // Date To
        Date_To = wait7.until(ExpectedConditions.elementToBeClickable(By.name("date_from")));
        Action_Class.moveToElement(Date_To).click()
                .sendKeys(Keys.TAB).sendKeys(Keys.TAB)// Move cursor to the start
                .sendKeys("28")
                .sendKeys("10")
                .sendKeys("2024")
                .build().perform();

        // Taking Screenshot
        captureScreenshot(driver, "UserName and Dates");

        // Click on Show
        Action_Class.sendKeys(Keys.TAB).sendKeys(Keys.TAB).sendKeys(Keys.ENTER).build().perform();

        // Now Change Shorting to 100 to print all the Table Data
        Entries = wait7.until(ExpectedConditions.elementToBeClickable(By.name("list_length")));
        Action_Class.moveToElement(Entries).click().build().perform();

        Sorting = driver.findElements(By.xpath("//select[@name=\"list_length\"]/option"));
        //System.out.println(Sorting.size());
        for (int i = 0; i < Sorting.size(); i++) {
            Sorting.get(3).click();
            WebElement User_option = Sorting.get(i);
            User_option.click(); // Selects the option

        }

        // Click on a random position on the page, e.g., x=100, y=100
        // Actions actions = new Actions(driver);
        actions.moveByOffset(100, 100).click().perform();

        // Wait for 7 Second
        Thread.sleep(7000);
        // Taking Screenshot
        captureScreenshot(driver, "Data");

        // Click on Search

        Search = wait7.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@type=\"search\"]")));
        Search.clear();

        // Taking Screenshot
        captureScreenshot(driver, "Searched Item");

        Action_Class.moveToElement(Search).click().sendKeys("test").build().perform();

        // Taking Screenshot
        captureScreenshot(driver, "Cleared");

        // Click on Delete
        WebElement delete_button = wait7.until(ExpectedConditions.elementToBeClickable(By.xpath("(//*[text()='Delete'])[1]")));
        Action_Class.moveToElement(delete_button).click().build().perform();

        // Actual and Expected Result
        WebElement Delete_Toast_Message = wait7.until(ExpectedConditions.elementToBeClickable(By.id("swal2-title")));
        String Delete_Toast_Message_Store = Delete_Toast_Message.getText();


        String Expected_For_Delete_Toast_Message = "Data successfully deleted";
        String Actual_For_Delete_Toast_Message = Delete_Toast_Message_Store;

        // Taking Screenshot
        captureScreenshot(driver, Actual_For_Delete_Toast_Message);

        // Error Handling
        try {
            Assert.assertEquals(Actual_For_Delete_Toast_Message, Expected_For_Delete_Toast_Message);
            System.out.println("Test Passed! ");
            System.out.println("Toast Message : " + Actual_For_Delete_Toast_Message);
        } catch (AssertionError e) {
            System.out.println("Test Failed! \n Expected: " + Expected_For_Delete_Toast_Message + "\n But got: " + Actual_For_Delete_Toast_Message);
        }

        // Allure Report Console Logs Attachment
        Allure_Helper_Class.attachConsoleLogs(driver, "ConsoleLogs");

        // This is for Console output in allure reports
        System.setOut(originalOut);
        String consoleOutput = baos.toString(StandardCharsets.UTF_8);
        Allure_Helper_Class.attachConsoleOutput(consoleOutput, "ConsoleOutput");

        // Testing for Git

        //Quit Driver
        driver.quit();


    }

    @Test(priority = 4)
    public void TimeSheet() throws InterruptedException {

        // To Disable Notification
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-notifications");

        WebDriver driver = new ChromeDriver(options);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));
        WebDriverWait wait7 = new WebDriverWait(driver, Duration.ofSeconds(7));
        // Sandbox

        // DEV Sandbox
        // URL
        System.out.println("\n");
        driver.get("https://test.pms.cloudprism.in/login.php");

        //Wait for the user id to appear
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//input[@type=\"email\"]")));

        // Maximize Window
        driver.manage().window().maximize();

        // Printing the Url
        String URL = driver.getCurrentUrl();
        System.out.println("URL: " + URL);

        driver.findElement(By.name("email")).sendKeys(PMS_UserName);
        driver.findElement(By.name("password")).sendKeys(PMS_Password);
        driver.findElement(By.xpath("//button[@type=\"submit\"]")).click();

        // Actual and Expected Result

        WebElement Waring_Message_for_Correct_cred = wait7.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='card-body']")));
        String Warning_Message_for_Correct_cred_Store = Waring_Message_for_Correct_cred.getText();

        //String Expected_For_Correct_cred = "Welcome Mayank Jha!";
        String Expected_For_Correct_cred = "Welcome " + Name + Exclametry;
        String Actual_For_Correct_cred = Warning_Message_for_Correct_cred_Store;

        try {
            Assert.assertEquals(Actual_For_Correct_cred, Expected_For_Correct_cred);
            System.out.println("Test Passed! ");
            System.out.println("Welcome Message : " + Actual_For_Correct_cred);
        } catch (AssertionError e) {
            System.out.println("Test Failed! \n Expected: " + Expected_For_Correct_cred + "\n But got: " + Actual_For_Correct_cred);
        }
        System.out.println("====================================================================\n");


        System.out.println("====================================================================\n");
        System.out.println("1. Checking TimeSheet  ");
        System.out.println("====================================================================\n");

        Actions actionClass = new Actions(driver);

        //Click on Timesheet Menu
        WebElement Timesheet_Menu = wait7.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@class=\"nav-link nav-calendar nav-time_sheet\"]")));
        actionClass.moveToElement(Timesheet_Menu).click().build().perform();

        // Now Click on Add New Button
        Thread.sleep(2000);
        WebElement Timesheet_Add_New_Button = wait7.until(ExpectedConditions.elementToBeClickable(By.xpath("(//*[text()='Add New'])[1]")));
        actionClass.moveToElement(Timesheet_Add_New_Button).click().build().perform();

        // Check the Calendar is visible or not
        WebElement Calendar = wait7.until(ExpectedConditions.elementToBeClickable(By.xpath("//h1[@class=\"m-0\"]")));
        String Calendar_Text = Calendar.getText();
        System.out.println(Calendar_Text + " is Visible");

 // Testing code

    }

}
