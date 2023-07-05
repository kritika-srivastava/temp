package com.stackroute.commonjavaclasses;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.Period;

import static org.junit.jupiter.api.Assertions.assertEquals;


class BankDepositTests {

    private BankDeposit bankDeposit;

    @BeforeEach
    public void setUp() {
        bankDeposit = new BankDeposit();
    }

    @AfterEach
    public void tearDown() {
        bankDeposit = null;
    }

    private static final String MATURITY_MESSAGE = "please check logic of getMaturityDate method";
    private static final String INVESTMENT_DURATION_MESSAGE = "please check logic of getInvestmentDuration method";

    private static final String PROPER_NULL_MESSAGE = "Give proper input not null";

    @Test
    public void givenInvestmentDateAndDurationAsInputThenReturnMaturityDateAsResult() {
        String investmentDate = "20/06/2019";
        Period duration = Period.of(2, 3, 5);
        String output = "25/09/2021";
        assertEquals(output, bankDeposit.getMaturityDate(investmentDate, duration), MATURITY_MESSAGE);
    }

    @Test
    public void givenInvestmentDateAndNegativeDurationAsInputThenReturnErrorMessage() {
        String investmentDate = "20/06/2019";
        Period duration = Period.of(-4, 8, 5);
        String output = "Give proper duration not negative value";
        assertEquals(output, bankDeposit.getMaturityDate(investmentDate, duration), MATURITY_MESSAGE);
    }

    @Test
    public void givenInvestmentDateAsNullAndDurationAsInputThenReturnErrorMessage() {
        Period duration = Period.of(6, 10, 5);
        assertEquals(PROPER_NULL_MESSAGE, bankDeposit.getMaturityDate(null, duration), MATURITY_MESSAGE);
    }

    @Test
    public void givenInvestmentDateAsNullAndDurationAsNullThenReturnErrorMessage() {
        assertEquals(PROPER_NULL_MESSAGE, bankDeposit.getMaturityDate(null, null), MATURITY_MESSAGE);
    }

    @Test
    public void givenEmptyInvestmentDateAndDurationAsInputThenReturnErrorMessage() {
        Period duration = Period.of(4, 6, 9);
        String output = "Give proper input not empty investment date";
        assertEquals(output, bankDeposit.getMaturityDate("", duration), MATURITY_MESSAGE);
    }

    @Test
    public void givenInvestmentDateAndMaturityDateAsInputThenReturnDurationAsResult() {
        String investmentDate = "20/06/2019";
        String maturityDate = "22/06/2022";
        Period output = Period.of(3, 0, 2);
        assertEquals(output.toString(), bankDeposit.getInvestmentDuration(investmentDate, maturityDate), INVESTMENT_DURATION_MESSAGE);
    }

    @Test
    public void givenInvestmentDateAndMaturityDateAsSameThenReturnDurationAsResult() {
        String investmentDate = "22/06/2022";
        String maturityDate = "22/06/2022";
        Period output = Period.of(0, 0, 0);
        assertEquals(output.toString(), bankDeposit.getInvestmentDuration(investmentDate, maturityDate), INVESTMENT_DURATION_MESSAGE);
    }

    @Test
    public void givenInvestmentDateAsNullAndMaturityDateThenReturnErrorMessage() {
        String maturityDate = "22/06/2022";
        assertEquals(PROPER_NULL_MESSAGE, bankDeposit.getInvestmentDuration(null, maturityDate), INVESTMENT_DURATION_MESSAGE);
    }

    @Test
    public void givenInvestmentDateAsEmptyStringAndMaturityDateThenReturnErrorMessage() {
        String maturityDate = "22/06/2022";
        String output = "Give proper input not empty value";
        assertEquals(output, bankDeposit.getInvestmentDuration("", maturityDate), INVESTMENT_DURATION_MESSAGE);
    }

    @Test
    public void givenInvestmentDateAsNullAndMaturityDateAsNullThenReturnErrorMessage() {
        assertEquals(PROPER_NULL_MESSAGE, bankDeposit.getInvestmentDuration(null, null), INVESTMENT_DURATION_MESSAGE);
    }

    @Test
    public void givenInvestmentDateGreaterThanMaturityDateAsNullThenReturnErrorMessage() {
        String investmentDate = "22/06/2022";
        String maturityDate = "22/06/2018";
        String output = "Give proper maturity date greater than investment date";
        assertEquals(output, bankDeposit.getInvestmentDuration(investmentDate, maturityDate), INVESTMENT_DURATION_MESSAGE);
    }

}