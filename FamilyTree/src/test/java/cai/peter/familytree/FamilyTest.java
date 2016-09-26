package cai.peter.familytree;

import static org.junit.Assert.fail;

import org.apache.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath*:/META-INF/spring/applicationContext*.xml")
public class FamilyTest
{
	/**
	* Logger for this class
	*/
	private static final Logger	logger	= Logger.getLogger(FamilyTest.class);
	@Autowired
	Person grandpa;
	@Test
	public void test()
	{
		logger.info(grandpa.getName());
	}
}
