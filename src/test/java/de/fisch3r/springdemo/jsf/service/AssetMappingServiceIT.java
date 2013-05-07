package de.fisch3r.springdemo.jsf.service;

import java.util.HashSet;
import java.util.Set;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import de.fisch3r.springdemo.jsf.domain.AssetMapping;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="classpath:/spring/services.xml")
public class AssetMappingServiceIT {
	
	@Autowired
	private AssetMappingService sut;

	@Test
	public void setValidAssetMappingThrowsNoException() {
		sut.setAssetMappings(new HashSet<AssetMapping>());		
	}
	
	@Test(expected=org.hibernate.validator.method.MethodConstraintViolationException.class)
	public void settingNullAsAssetMappingsShouldThrowException() {
		sut.setAssetMappings(null);
	}
	
	
	@Test(expected=org.hibernate.validator.method.MethodConstraintViolationException.class)
	public void setInvalidAssetMappingsShouldThrowException() {
		Set<AssetMapping> assetMappings = new HashSet<AssetMapping>();
		assetMappings.add(new AssetMapping("", ""));
		sut.setAssetMappings(assetMappings);
	}
	
}
