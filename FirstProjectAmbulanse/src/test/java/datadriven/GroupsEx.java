package datadriven;

import org.testng.annotations.Test;

public class GroupsEx {

	@Test(groups = "smoke")
	public void test1() {
		System.out.println("this is smoke ");
	}
	
	@Test(groups = {"smoke","sanity"})
	public void test2() {
		System.out.println("this is smoke ");
	}
	@Test(groups = {"smoke","sanity","integration"})
	public void test3() {
		System.out.println("this is smoke ");
	}
	@Test(groups = {"smoke","sanity","positive"})
	public void test4() {
		System.out.println("this is smoke ");
	}
	@Test(groups = {"smoke","regression"})
	public void test7() {
		System.out.println("this is smoke ");
	}
	@Test(groups = {"smoke","sanity","regression"})
	public void test5() {
		System.out.println("this is smoke ");
	}
	@Test(groups = {"smoke","sanity"})
	public void test6() {
		System.out.println("this is smoke ");
	}
	
	
}
