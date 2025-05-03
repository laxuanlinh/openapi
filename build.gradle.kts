plugins {
	java
	id("org.springframework.boot") version "3.4.5"
	id("io.spring.dependency-management") version "1.1.7"
	id("org.openapi.generator") version "7.5.0"
}

openApiGenerate {
	generatorName.set("spring")
	inputSpec.set("$rootDir/src/main/resources/openapi.yaml")
	outputDir.set(file("generated").absolutePath)
	apiPackage.set("com.example.openapi.api")
	modelPackage.set("com.example.openapi.model")
	invokerPackage.set("com.example.openapi.client")
	configOptions.set(
			mapOf(
					"interfaceOnly" to "true",
					"dateLibrary" to "java8",
					"annotationLibrary" to "none",
					"documentationProvider" to "none",
					"generatedAnnotation" to "",
					"useBeanValidation" to "false",
					"useSpringBoot3" to "true",
					"delegatePattern" to "true"
			)
	)
}

val generateClientCode by tasks.register("generateClientCode", org.openapitools.generator.gradle.plugin.tasks.GenerateTask::class) {
	group = "openapi"
	description = "Generates client (invoker) code from OpenAPI spec"

	generatorName.set("java")  // Set generator for Java client code
	inputSpec.set(file("src/main/resources/book-openapi.yaml").absolutePath)  // Path to the downstream OpenAPI spec
	outputDir.set(file("generated").absolutePath)  // Output directory for generated client code
	apiPackage.set("com.example.openapi.client.api")  // Client API package
	modelPackage.set("com.example.openapi.client.model")  // Client model package
	configOptions.set(mapOf(
			"library" to "resttemplate",
			"interfaceOnly" to "false",
			"annotationLibrary" to "none",
			"documentationProvider" to "none",
			"generatedAnnotation" to "",
			"useBeanValidation" to "false",
			"useSpringBoot3" to "true",
			"delegatePattern" to "true",
			"useJakartaEe" to "true",
			"apiNameSuffix" to "Client",
			"apiNamePrefix" to "Book"
	))
}

val generateClientCodeOrder by tasks.register("generateClientCodeOrder", org.openapitools.generator.gradle.plugin.tasks.GenerateTask::class) {
	group = "openapi"
	description = "Generates client (invoker) code from OpenAPI spec"

	generatorName.set("java")  // Set generator for Java client code
	inputSpec.set(file("src/main/resources/order-openapi.yaml").absolutePath)  // Path to the downstream OpenAPI spec
	outputDir.set(file("generated").absolutePath)  // Output directory for generated client code
	apiPackage.set("com.example.openapi.client.api")  // Client API package
	modelPackage.set("com.example.openapi.client.model")  // Client model package
	configOptions.set(mapOf(
			"library" to "resttemplate",
			"interfaceOnly" to "false",
			"annotationLibrary" to "none",
			"documentationProvider" to "none",
			"generatedAnnotation" to "",
			"useBeanValidation" to "false",
			"useSpringBoot3" to "true",
			"delegatePattern" to "true",
			"useJakartaEe" to "true",
			"apiNameSuffix" to "Client",
			"apiNamePrefix" to "Book"
	))
}
sourceSets {
	named("main") {
		java.srcDir("$rootDir/generated/src/main/java")
	}
}

tasks.compileJava {
	dependsOn(tasks.openApiGenerate)
	dependsOn(generateClientCode)
	dependsOn(generateClientCodeOrder)
}


group = "com.example"
version = "0.0.1-SNAPSHOT"

java {
	toolchain {
		languageVersion = JavaLanguageVersion.of(21)
	}
}

configurations {
	compileOnly {
		extendsFrom(configurations.annotationProcessor.get())
	}
}

repositories {
	mavenCentral()
}

dependencies {
	implementation("org.springframework.boot:spring-boot-starter-web")
	compileOnly("org.projectlombok:lombok")
	annotationProcessor("org.projectlombok:lombok")
	implementation("io.swagger:swagger-annotations:1.6.3")
	implementation("jakarta.validation:jakarta.validation-api:3.0.2")
	implementation("org.openapitools:jackson-databind-nullable:0.2.1")
	testImplementation("org.springframework.boot:spring-boot-starter-test")
	testRuntimeOnly("org.junit.platform:junit-platform-launcher")
}

tasks.withType<Test> {
	useJUnitPlatform()
}

