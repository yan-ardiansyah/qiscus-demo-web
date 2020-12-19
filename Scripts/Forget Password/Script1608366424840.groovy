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

'Call datetime function'
today = new Date()

'Create var todaysDate'
String todaysDate = today.format('MM_dd_yy')

'Create nowTime'
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

'Verify link forget password can be clicked'
WebUI.verifyElementClickable(findTestObject('Login_Object/link_Forgot Password'))

'Click link Forget Password'
WebUI.click(findTestObject('Login_Object/link_Forgot Password'))

'Wait for page load in 5s'
WebUI.waitForPageLoad(5)

'Verify title of Forget Password appear'
WebUI.verifyElementPresent(findTestObject('Forget_password_Object/h2_Forgot Password'), 
    5)

'Verify label Email appear'
WebUI.verifyElementPresent(findTestObject('Forget_password_Object/label_Email'), 
    5)

'Verify input email field appear'
WebUI.verifyElementPresent(findTestObject('Forget_password_Object/input_Email_email'), 
    5)

'Verify button Reset Password appear'
WebUI.verifyElementPresent(findTestObject('Forget_password_Object/button_Reset Password'), 
    5)

'Verify button Reset Password can be clicked'
WebUI.verifyElementClickable(findTestObject('Forget_password_Object/button_Reset Password'))

'Verify link Back to Login appear'
WebUI.verifyElementPresent(findTestObject('Forget_password_Object/a_ Back to Login'), 
    5)

'Verify link Back to Login can be clicked'
WebUI.verifyElementClickable(findTestObject('Forget_password_Object/a_ Back to Login'))

'Input email on email field'
WebUI.setText(findTestObject('Forget_password_Object/input_Email_email'), email)

'Click button Reset Password'
WebUI.click(findTestObject('Forget_password_Object/button_Reset Password'))

'Take screenshot when website already loaded'
WebUI.takeScreenshot((((((GlobalVariable.ss_path + testcase_id) + '-') + todaysDate) + 
    '-') + nowTime) + '.png')

'Do switch function'
switch (testcase_id) {
    case 'TC_FPass_1-1':
        'Verify alert appear'
        WebUI.verifyElementPresent(findTestObject('Forget_password_Object/small_The email field is required'), 
            5)

        'Verify actual alert equal to alert data'
        WebUI.verifyElementText(findTestObject('Forget_password_Object/small_The email field is required'), 
            alert)

        break
    case 'TC_FPass_1-2':
        'Verify alert appear'
        WebUI.verifyElementPresent(findTestObject('Forget_password_Object/div_An email has been sent. Please check your email'), 
            5)
		'Verify actual alert equal to alert data'
        WebUI.verifyElementText(findTestObject('Forget_password_Object/div_An email has been sent. Please check your email'), 
            alert)

        break
    case 'TC_FPass_1-3':
		'Verify Failed title'
        WebUI.verifyElementPresent(findTestObject('Forget_password_Object/h2_Failed'), 
            5)
		'Verify alert appear'
        WebUI.verifyElementPresent(findTestObject('Forget_password_Object/div_user not found'), 
            5)
		'Verify actual alert equal to alert data'
        WebUI.verifyElementText(findTestObject('Forget_password_Object/div_user not found'), 
            alert)
		'Verify button OK appear'
        WebUI.verifyElementPresent(findTestObject('Forget_password_Object/button_OK'), 
            5)
		'Verify button OK can be clicked'
        WebUI.verifyElementClickable(findTestObject('Forget_password_Object/button_OK'))
		'Click button OK'
        WebUI.click(findTestObject('Forget_password_Object/button_OK'))

        break
    case 'TC_FPass_1-4':
	'Verify alert appear'
        WebUI.verifyElementPresent(findTestObject('Forget_password_Object/small_The email field must be a valid email'), 
            5)
		'Verify actual alert equal to alert data'
        WebUI.verifyElementText(findTestObject('Forget_password_Object/small_The email field must be a valid email'), 
            alert)

        break
    case 'TC_FPass_1-5':
	'Verify link Back To Login appear'
        WebUI.verifyElementPresent(findTestObject('Forget_password_Object/a_ Back to Login'), 
            5)
		'Verify link Back To Login can be clicked'
        WebUI.verifyElementClickable(findTestObject('Forget_password_Object/a_ Back to Login'))
		'Click link Back To Login'
        WebUI.click(findTestObject('Forget_password_Object/a_ Back to Login'))
		'Verify Welcome Back title appear'
        WebUI.verifyElementPresent(findTestObject('Login_Object/h2_Welcome Back'), 
            5)
		'Verify button Sign In appear'
        WebUI.verifyElementPresent(findTestObject('Login_Object/button_Sign In'), 
            5)

        break
    default:
        WebUI.comment('All case not running')

        break
}

