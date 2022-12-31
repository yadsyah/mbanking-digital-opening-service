package id.co.diansetiyadi.digitalopeningservice;

import com.tngtech.archunit.core.domain.JavaClasses;
import com.tngtech.archunit.core.importer.ClassFileImporter;
import com.tngtech.archunit.core.importer.ImportOption;
import com.tngtech.archunit.library.Architectures;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class DigitalOpeningServiceApplicationTests {

	private static JavaClasses importedClasses;


	@BeforeAll
	static void setUp() {
		ImportOption ignoreTests = location -> {
			return !location.contains("/test/"); // ignore any URI to sources that contains '/test/'
		};
		importedClasses = new ClassFileImporter().withImportOption(ignoreTests).importPackages("id.co.diansetiyadi");
	}

	@Test
	void contextLoads() {
	}

	@Test
	void architectPatternGuardianTest() {
		Architectures.LayeredArchitecture layeredArchitecture = Architectures.layeredArchitecture()
				.layer("Controller").definedBy("..controller..")
				.layer("Service").definedBy("..service..")
				.layer("Repository").definedBy("..repository..")
				.whereLayer("Controller").mayNotBeAccessedByAnyLayer()
				.whereLayer("Service").mayOnlyBeAccessedByLayers("Controller", "Service")
				.whereLayer("Repository").mayOnlyBeAccessedByLayers("Service");

		layeredArchitecture.check(importedClasses);

	}

}
