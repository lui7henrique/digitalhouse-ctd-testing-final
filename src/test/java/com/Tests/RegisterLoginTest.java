package com.Tests;

import static org.junit.jupiter.api.Assertions.*;
import com.Pages.Register;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class RegisterLoginTest {

	public static String accountNumber = "//*[@id=\"__next\"]/div/div[3]/form/div[1]/div[1]/input";
	public static String accountDigiter = "/html/body/div/div/div[3]/form/div[1]/div[2]/input";
	public static String amount = "/html/body/div/div/div[3]/form/div[2]/input";
	private static Register page;

	@BeforeEach
	public void setUp() {
		page = new Register();
		page.openApp();
	}

	@Test
	public void getIntoPagAndRegister() throws InterruptedException {
		// register
		page.getInRegisterPag();
		page.insertFields();
		page.confirmRegister();
		assertTrue(
				page.verifyIfSucessed().contains("foi criada com sucesso"));

		// second account
		page.closeModalButton();
		page.getInRegisterPag();
		page.insertnewFields();
		page.confirmRegister();
		assertTrue(
				page.verifyIfSucessed().contains("foi criada com sucesso"));

		// login
		page.closeModalButton();
		page.FillInput();
		page.AcessButton();
		Thread.sleep(2000);
		String acountNumber = page.getAccountNumber();
		String account[] = acountNumber.split("-", 2);
		String firstSubstring = account[0];
		String secondSubstring = account[1];
		System.out.println(firstSubstring);
		page.logOut();

		// transfer
		page.FillInputSecondAccount();
		page.AcessButton();
		page.transferButton();
		Thread.sleep(2000);
		/*
		 * WebElement accountNumberField = getWebElement(By.xpath(accountNumber));
		 * accountNumberField.sendKeys(firstSubstring);
		 */

		page.insertIntoField(accountNumber, firstSubstring);
		page.insertIntoField(accountDigiter, secondSubstring);
		page.insertIntoField(amount, "100");
		page.submitButton();
		Thread.sleep(2000);
		page.closeModalTransfer();
		page.logOut();

		// login first account
		page.FillInputSecondAccount();
		page.AcessButton();
		Thread.sleep(2000);
		page.clickExtractButton();

		// extrato
		page.clickExtractButton();
		page.checkIfThereIsNoComment();
		page.checkIfIsTransferAndGreenLabel();
		page.checkAmount();
	}

}
