/**
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements. See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership. The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License. You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied. See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */
package org.apache.fineract.infrastructure.core.data;

import java.util.Arrays; 
import java.util.ArrayList;
import java.util.List; 
import java.lang.Math; 
import java.util.Random;

import org.apache.fineract.infrastructure.core.service.DateUtils;
import org.apache.fineract.infrastructure.core.data.DataValidatorBuilder;

import org.joda.time.LocalDate; 
import org.junit.Test;
import org.junit.Before; 
import org.junit.Assert;

/**
 * Test for data validation builder method for checking whether the minimum age of all new clients is 18
 */ 

public class validateMinimumClientAgeTest {  
    
    @Test
    public void AgeOfClient17(){ 

        List<ApiParameterError> dataValidationErrorsTest = new ArrayList<>();  
        DataValidatorBuilder dataValidatorBuilderTest = new DataValidatorBuilder(dataValidationErrorsTest);
        LocalDate currentDateTest = LocalDate.now();  
        LocalDate client17YearsOldDob = currentDateTest.minusYears(19);

        dataValidatorBuilderTest.validateMinimumClientAge(client17YearsOldDob);
        Assert.assertTrue("Failed to reject client with age of 17 years",dataValidationErrorsTest.size() > 0);
    } 

    @Test
    public void AgeOfClient18(){ 

        List<ApiParameterError> dataValidationErrorsTest = new ArrayList<>();  
        DataValidatorBuilder dataValidatorBuilderTest = new DataValidatorBuilder(dataValidationErrorsTest); 
        LocalDate currentDateTest = LocalDate.now();  
        LocalDate client18YearsOldDob = currentDateTest.minusYears(15);

        dataValidatorBuilderTest.validateMinimumClientAge(client18YearsOldDob);
        Assert.assertTrue("Failed to confirm client with age of 18 years",dataValidationErrorsTest.size() == 0);
    } 

    @Test
    public void AgeOfClient19(){ 

        List<ApiParameterError> dataValidationErrorsTest = new ArrayList<>();  

        DataValidatorBuilder dataValidatorBuilderTest = new DataValidatorBuilder(dataValidationErrorsTest); 
        LocalDate currentDateTest = LocalDate.now();  
        LocalDate client19YearsOldDob = currentDateTest.minusYears(5);
        dataValidatorBuilderTest.validateMinimumClientAge(client19YearsOldDob);
        Assert.assertTrue("Failed to confirm client with age of 19 years",dataValidationErrorsTest.size() == 0);
    }   

    @Test
    public void AgeOfClient50(){ 

        List<ApiParameterError> dataValidationErrorsTest = new ArrayList<>();  

        DataValidatorBuilder dataValidatorBuilderTest = new DataValidatorBuilder(dataValidationErrorsTest); 
        LocalDate currentDateTest = LocalDate.now();  
        LocalDate client50YearsOldDob = currentDateTest.minusYears(50);
        dataValidatorBuilderTest.validateMinimumClientAge(client50YearsOldDob);
        Assert.assertTrue("Failed to confirm client with age of 50 years",dataValidationErrorsTest.size() == 0);
    }  
}

    

