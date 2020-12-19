import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testng.keyword.TestNGBuiltinKeywords as TestNGKW
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import internal.GlobalVariable as GlobalVariable

WebUI.comment((scenario_id + ' | ') + scenario_title)

WebUI.comment((testcase_id + ' | ') + testcase_title)

'Open Browser and go to website'
WebUI.openBrowser(GlobalVariable.url)

today = new Date()

String todaysDate = today.format('MM_dd_yy')

String nowTime = today.format('hh_mm_ss')

'Wait page to load in 5 seconds'
WebUI.waitForPageLoad(5)

'Maximize the browser window'
WebUI.maximizeWindow()

'Take screenshot when website already loaded'
WebUI.takeScreenshot((((GlobalVariable.ss_path + todaysDate) + '-') + nowTime) + 
    '.png')

'Verify Welcome Back text in login page appear'
WebUI.verifyElementPresent(findTestObject('Login_Object/h2_Welcome Back'), 5)

'Verify field input email appear'
WebUI.verifyElementPresent(findTestObject('Login_Object/input_email'), 5)

'Verify field input password appear'
WebUI.verifyElementPresent(findTestObject('Login_Object/input_pass'), 5)

'Verify forget password link appear'
WebUI.verifyElementPresent(findTestObject('Login_Object/link_Forgot Password'), 
    5)

WebUI.verifyElementClickable(findTestObject('Login_Object/link_Forgot Password'))

WebUI.click(findTestObject('Login_Object/link_Forgot Password'))

WebUI.waitForPageLoad(5)

WebUI.verifyElementPresent(findTestObject('Forget_password_Object/h2_Forgot Password'), 
    5)

WebUI.verifyElementPresent(findTestObject('Forget_password_Object/label_Email'), 
    5)

WebUI.verifyElementPresent(findTestObject('Forget_password_Object/input_Email_email'), 
    5)

WebUI.verifyElementPresent(findTestObject('Forget_password_Object/button_Reset Password'), 
    5)

WebUI.verifyElementClickable(findTestObject('Forget_password_Object/button_Reset Password'))

WebUI.verifyElementPresent(findTestObject('Forget_password_Object/a_ Back to Login'), 
    5)

WebUI.verifyElementClickable(findTestObject('Forget_password_Object/a_ Back to Login'))

WebUI.setText(findTestObject('Forget_password_Object/input_Email_email'), email)

WebUI.click(findTestObject('Forget_password_Object/button_Reset Password'))

'Take screenshot when website already loaded'
WebUI.takeScreenshot((((((GlobalVariable.ss_path + testcase_id) + '-') + todaysDate) + '-') + nowTime) + '.png')

switch (testcase_id) {
    case 'TC_FPass_1-1':
        WebUI.verifyElementPresent(findTestObject('Forget_password_Object/small_The email field is required'), 
            5)

        WebUI.verifyElementText(findTestObject('Forget_password_Object/small_The email field is required'), 
            alert)

        break
    case 'TC_FPass_1-2':
        WebUI.verifyElementPresent(findTestObject('Forget_password_Object/div_An email has been sent. Please check your email'), 
            5)

        WebUI.verifyElementText(findTestObject('Forget_password_Object/div_An email has been sent. Please check your email'), 
            alert)

        break
    case 'TC_FPass_1-3':
        WebUI.verifyElementPresent(findTestObject('Forget_password_Object/h2_Failed'), 
            5)

        WebUI.verifyElementPresent(findTestObject('Forget_password_Object/div_user not found'), 
            5)

        WebUI.verifyElementText(findTestObject('Forget_password_Object/div_user not found'), 
            alert)

        WebUI.verifyElementPresent(findTestObject('Forget_password_Object/button_OK'), 
            5)

        WebUI.verifyElementClickable(findTestObject('Forget_password_Object/button_OK'))

        WebUI.click(findTestObject('Forget_password_Object/button_OK'))

        break
    case 'TC_FPass_1-4':
        WebUI.verifyElementPresent(findTestObject('Forget_password_Object/small_The email field must be a valid email'), 
            5)

        WebUI.verifyElementText(findTestObject('Forget_password_Object/small_The email field must be a valid email'), 
            alert)

        break
    case 'TC_FPass_1-5':
        WebUI.verifyElementPresent(findTestObject('Forget_password_Object/a_ Back to Login'), 
            5)

        WebUI.verifyElementClickable(findTestObject('Forget_password_Object/a_ Back to Login'))

        WebUI.click(findTestObject('Forget_password_Object/a_ Back to Login'))

        WebUI.verifyElementPresent(findTestObject('Login_Object/h2_Welcome Back'), 
            5)

        WebUI.verifyElementPresent(findTestObject('Login_Object/button_Sign In'), 
            5)

        break
    default:
        WebUI.comment('All case not running')

        break
}

