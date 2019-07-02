package com.duoc.restspringjpa.tests;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ AddClienteTest.class, DeleteClienteTest.class, GetClientesTest.class, GetClienteTest.class,
		ModifyClienteTest.class })
public class AllTests {

}
