package com.Pages;

import com.Base.BasePage;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.Color;

public class Register extends BasePage {
    // Register
    public static final String registerButton = "/html/body/div/div/div[2]/div/div[1]/form/div[3]/button[2]";
    public static final String email = "/html/body/div/div/div[2]/div/div[2]/form/div[2]/input";
    public static final String email2 = "/html/body/div/div/div[2]/div/div[2]/form/div[2]/input";
    public static final String name = "/html/body/div/div/div[2]/div/div[2]/form/div[3]/input";
    public static final String password = "/html/body/div/div/div[2]/div/div[2]/form/div[4]/div/input";
    public static final String confirmPassword = "/html/body/div/div/div[2]/div/div[2]/form/div[5]/div/input";
    public static final String confirmRegister = "/html/body/div/div/div[2]/div/div[2]/form/button";
    public static final String successMessage = "/html/body/div/div/div[3]/div/div[2]/p";
    public static final String createwithSaldo = "/html/body/div/div/div[2]/div/div[2]/form/div[6]/label/label";
    public static String closeModal = "/html/body/div/div/div[3]/div/div[2]/a";
    public static String logOut = "/html/body/div/div/div[1]/div";

    // login
    public static String emailInput = "/html/body/div/div/div[2]/div/div[1]/form/div[1]/input";
    public static String passwordInput = "/html/body/div/div/div[2]/div/div[1]/form/div[2]/div/input";
    public static String acessButton = "/html/body/div/div/div[2]/div/div[1]/form/div[3]/button[1]";
    public static String verifyLabel = "/html/body/div/div/div[3]/div[1]/p";

    // transfer
    public static String getAccountNumber = "/html/body/div/div/div[2]/div/div[3]/p/span";
    public static String transferButton = "/html/body/div/div/div[3]/div[2]/div[1]/a";
    public static String accountNumber = "/html/body/div/div/div[3]/form/div[1]/div[1]/input";
    public static String accountDigiter = "/html/body/div/div/div[3]/form/div[1]/div[2]/input";
    public static String amount = "/html/body/div/div/div[3]/form/div[2]/input";
    public static String submit = "/html/body/div/div/div[3]/form/button";
    public static String closeModalTransfer = "/html/body/div/div/div[5]/div/div[2]/a";

    // extrato
    public static String transferLabel = "/html/body/div/div/div[3]/div/div[2]/div[2]/div[1]/p[2]";
    public static final String buttonExtract = "/html/body/div/div/div[3]/div[2]/div[3]/a";
    public static final String verifyBalanceText = "/html/body/div/div/div[3]/div/div[2]/div[1]/div[2]/p[2]";
    public static final String verifyExtractTextIfNoMessage = "/html/body/div/div/div[3]/div/div[2]/div[2]/div[2]/p[1]";
    public static final String clickBack = "/html/body/div/div/div[2]/div[1]/a";

    // register methods
    public void getInRegisterPag() throws InterruptedException {
        WebElement myAccountButton = getWebElement(By.xpath(registerButton));
        myAccountButton.click();
        Thread.sleep(2000);
    }

    public void insertIntoField(String field, String value) {
        WebElement fieldPersonal = getWebElement(By.xpath(field));
        fieldPersonal.clear();
        fieldPersonal.sendKeys(value);
    }

    public void insertPQP(String field, String value) {
        WebElement fieldPersonal = getWebElement(By.xpath(field));
        fieldPersonal.sendKeys(value);
    }

    public void insertFields() throws InterruptedException {
        insertIntoField(email, "test-0a37vixu5@srv1.mail-tester.com");
        insertIntoField(name, "Thiago");
        insertIntoField(password, "Thiago123");
        insertIntoField(confirmPassword, "Thiago123");
        WebElement createWithSaldoButton = getWebElement(By.xpath(createwithSaldo));
        createWithSaldoButton.click();
    }

    public void logOut() {
        WebElement logOutButton = getWebElement(By.xpath(logOut));
        logOutButton.click();
    }

    public void insertnewFields() throws InterruptedException {
        insertIntoField(email2, "thiagomaurat@hotmail.com");
        insertIntoField(name, "Professor");
        insertIntoField(password, "Professor123");
        insertIntoField(confirmPassword, "Professor123");
    }

    public void confirmRegister() throws InterruptedException {
        WebElement registerButton = getWebElement(By.xpath(confirmRegister));
        registerButton.click();
        Thread.sleep(2000);
    }

    public String verifyIfSucessed() {
        WebElement verifyMessageSucess = getWebElement(By.xpath(successMessage));
        System.out.println(verifyMessageSucess.getText());
        return verifyMessageSucess.getText();

    }

    public void closeModalButton() throws InterruptedException {
        WebElement closeWebElement = getWebElement(By.xpath(closeModal));
        closeWebElement.click();
        Thread.sleep(2000);
    }

    // login methods

    public void FillInput() throws InterruptedException {
        insertIntoField(emailInput, "test-0a37vixu5@srv1.mail-tester.com");
        insertIntoField(passwordInput, "Thiago123");
    }

    public void FillInputSecondAccount() throws InterruptedException {
        insertIntoField(emailInput, "thiagomaurat@hotmail.com");
        insertIntoField(passwordInput, "Professor123");
    }

    public void AcessButton() {
        WebElement buttonPage = getWebElement(By.xpath(acessButton));
        buttonPage.click();
    }

    public String verifyIfTextSucessed() {
        WebElement textAsert = getWebElement(By.xpath(verifyLabel));
        return textAsert.getText();
    }

    // transfer methods
    public String getAccountNumber() {
        WebElement accountNumber = getWebElement(By.xpath(getAccountNumber));
        return accountNumber.getText();
    }

    public void transferButton() {
        WebElement transferButtonClick = getWebElement(By.xpath(transferButton));
        transferButtonClick.click();
    }

    public void fillTransferInput() throws InterruptedException {
        insertIntoField(accountNumber, URL);
    }

    public void submitButton() {
        WebElement submitButton = getWebElement(By.xpath(submit));
        submitButton.click();
    }

    public void closeModalTransfer() {
        WebElement closeModalTransferButton = getWebElement(By.xpath(closeModalTransfer));
        closeModalTransferButton.click();
    }

    // extrato methods
    public void clickExtractButton() {
        WebElement buttonExtractButton = getWebElement(By.xpath(buttonExtract));
        buttonExtractButton.click();
    }

    public void checkIfIsTransferAndGreenLabel() {
        WebElement labelTransferLabel = getWebElement(By.xpath(transferLabel));
        if (labelTransferLabel.getText().contains("Transferência recebida")) {
            WebElement labelTransferLabelGreen = getWebElement(By.xpath(verifyBalanceText));
            String greenText = labelTransferLabelGreen.getCssValue("color");
            String hex = Color.fromString(greenText).asHex();
            assertTrue(hex.equals("#008000"));
        }
    }

    public void checkIfThereIsNoComment() {
        WebElement labelExtractLabel = getWebElement(By.xpath(verifyExtractTextIfNoMessage));
        assertTrue(labelExtractLabel.getText().contains("-"));
    }

    public void checkAmount() {
        WebElement labelExtractLabel = getWebElement(By.xpath(verifyBalanceText));
        assertTrue(labelExtractLabel.getText().contains("R$ 1.000,00"));
    }

}
