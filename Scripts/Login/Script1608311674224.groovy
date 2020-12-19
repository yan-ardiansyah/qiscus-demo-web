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

'Maximize the browser window'
WebUI.maximizeWindow()

'Wait page to load in 5 seconds'
WebUI.waitForPageLoad(5)

WebUI.takeScreenshot(GlobalVariable.ss_path + todaysDate + '-' + nowTime + '.png')

'Verify Welcome Back text in login page appear'
WebUI.verifyElementPresent(findTestObject('Login_Object/h2_Welcome Back'), 5)

'Verify field input email appear'
WebUI.verifyElementPresent(findTestObject('Login_Object/input_email'), 5)

'Verify field input password appear'
WebUI.verifyElementPresent(findTestObject('Login_Object/input_pass'), 5)

'Verify forget password link appear'
WebUI.verifyElementPresent(findTestObject('Login_Object/link_Forgot Password'), 
    5)

'Verify button Sign In in login page appear'
WebUI.verifyElementPresent(findTestObject('Login_Object/button_Sign In'), 5)

'Verify button Sign In in login page can be clicked'
WebUI.verifyElementClickable(findTestObject('Login_Object/button_Sign In'))

'Input email'
WebUI.setText(findTestObject('Login_Object/input_email'), email)

'Input Password'
WebUI.setText(findTestObject('Login_Object/input_pass'), password)

'Click Sign In button'
WebUI.click(findTestObject('Login_Object/button_Sign In'))

WebUI.delay(3)

WebUI.takeScreenshot(GlobalVariable.ss_path + testcase_id + '-' +todaysDate + '-' + nowTime + '.png')

'Do switch function'
switch (testcase_id) {
    case 'TC_Login_1-1':
        'Verify alert message from email field'
        WebUI.verifyElementPresent(findTestObject('Login_Object/alert_email'), 5)

        'Get alert email text'
        actual_alert_email = WebUI.getText(findTestObject('Login_Object/alert_email'), 
            FailureHandling.STOP_ON_FAILURE)

        'Print alert email text'
        println(actual_alert_email)

        'Verify alert message from password field'
        WebUI.verifyElementPresent(findTestObject('Login_Object/alert_pass'), 5)

        'Get alert password text'
        actual_alert_pass = WebUI.getText(findTestObject('Login_Object/alert_pass'), 
            FailureHandling.STOP_ON_FAILURE)

        'Print alert password text'
        println(actual_alert_pass)

        'Verify data alert text equal with actual alert text'
        WebUI.verifyEqual((actual_alert_email + '\n') + actual_alert_pass, alert)

        'Stop'
        break
    case 'TC_Login_1-2':
        'Verify Inbox icon section'
        WebUI.verifyElementPresent(findTestObject('Login_Object/inbox_logo'), 5)

        'Verify Logout icon section'
        WebUI.verifyElementPresent(findTestObject('Login_Object/logout_logo'), 5)

        'Stop'
        break
    case 'TC_Login_1-3':
        'Verify Failed text appear'
        WebUI.verifyElementPresent(findTestObject('Popup_Failed/Failed_title'), 
            5)

        'Verify content of pop up alert equal with alert data'
        WebUI.verifyElementText(findTestObject('Popup_Failed/content_Please check email and password combination'), 
            alert)

        'Verify button OK can clicked'
        WebUI.verifyElementClickable(findTestObject('Popup_Failed/button_OK'))

        'Click button OK'
        WebUI.click(findTestObject('Popup_Failed/button_OK'))

        'Stop'
        break
    case 'TC_Login_1-4':
        WebUI.verifyElementPresent(findTestObject('Popup_Failed/Failed_title'), 
            5)

        WebUI.verifyElementText(findTestObject('Popup_Failed/content_Please check email and password combination'), 
            alert)

        WebUI.verifyElementClickable(findTestObject('Popup_Failed/button_OK'))

        WebUI.click(findTestObject('Popup_Failed/button_OK'))

        break
    case 'TC_Login_1-5':
        WebUI.verifyElementPresent(findTestObject('Login_Object/alert-invalid email format'), 
            5)

        WebUI.verifyElementText(findTestObject('Login_Object/alert-invalid email format'), 
            alert)

        break
    case 'TC_Login_1-6':
        WebUI.verifyElementPresent(findTestObject('Login_Object/alert_pass'), 5)

        WebUI.verifyElementText(findTestObject('Login_Object/alert_pass'), alert)

        break
    case 'TC_Login_1-7':
        WebUI.verifyElementPresent(findTestObject('Login_Object/alert_email'), 5)

        WebUI.verifyElementText(findTestObject('Login_Object/alert_email'), alert)

        break
    default:
        WebUI.comment('All case not running')

        break
}

