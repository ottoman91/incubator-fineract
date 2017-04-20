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
    public void checkMinimumAgeOfClient(){  


    List<ApiParameterError> dataValidationErrorsTest = new ArrayList<>();

    //need to complete the constructor properly
    DataValidatorBuilder dataValidatorBuilderTest = new DataValidatorBuilder(dataValidationErrorsTest);

    Random rand1 = new Random();
    int invalidClientAge = rand1.nextInt(17) + 1; 
    Random rand2 = new Random();
    int validClientAge = rand2.nextInt(100) + 18;
    LocalDate currentDateTest = LocalDate.now();
    LocalDate validClientDateOfBirth = currentDateTest.minusYears(validClientAge);
    LocalDate invalidClientDateOfBirth = currentDateTest.minusYears(invalidClientAge);  

    //test for age that qualifies minimum client age criteria
    dataValidatorBuilderTest.validateMinimumClientAge(validClientDateOfBirth);
    



    }
}

    

