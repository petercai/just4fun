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
	@Autowired
	Person father_1;
	@Autowired
	Person mother_1;
	@Autowired
	Person child_1_1;

	@Test
	public void testGrandpa()
	{
	    grandpa.getFamilyTree();
	}
	@Test
	public void testFather1()
	{
	    father_1.getFamilyTree();
	}
	@Test
	public void testmother_1()
	{
		mother_1.getFamilyTree();
	}
	@Test
	public void testChild11()
	{
	    child_1_1.getFamilyTree();
	}
}
