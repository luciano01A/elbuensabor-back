package com.utn.elbuensabor.archunit;

import com.tngtech.archunit.core.importer.ImportOption;
import com.tngtech.archunit.junit.AnalyzeClasses;
import com.tngtech.archunit.junit.ArchTest;
import com.tngtech.archunit.lang.ArchRule;
import com.utn.elbuensabor.controllers.BaseController;
import com.utn.elbuensabor.services.BaseService;
import jakarta.persistence.Entity;

import static com.tngtech.archunit.lang.syntax.ArchRuleDefinition.classes;
import static com.tngtech.archunit.library.Architectures.layeredArchitecture;

@AnalyzeClasses(packages = "com.utn.elbuensabor", importOptions = {ImportOption.DoNotIncludeTests.class})
public class ArchUnitTest {

    @ArchTest
    public static final ArchRule layerRule =
            layeredArchitecture().consideringAllDependencies()
                    .layer("Controller").definedBy("com.utn.elbuensabor.controllers")
                    .layer("Service").definedBy("com.utn.elbuensabor.services")
                    .layer("Persistence").definedBy("com.utn.elbuensabor.repositories")

                    .whereLayer("Controller").mayNotBeAccessedByAnyLayer()
                    .whereLayer("Service").mayOnlyBeAccessedByLayers("Controller")
                    .whereLayer("Persistence").mayOnlyBeAccessedByLayers("Service");

    @ArchTest
    public static final ArchRule controllerNameRule =
            classes().that().haveSimpleNameEndingWith("Controller").should().resideInAPackage("com.utn.elbuensabor.controllers");

    @ArchTest
    public static final ArchRule controllerBaseRule =
            classes().that().haveSimpleNameEndingWith("Controller").should().implement(BaseController.class)
                    .orShould().haveSimpleName("BaseController");
    @ArchTest
    public static final ArchRule serviceNameRule =
            classes().that().haveSimpleNameEndingWith("Service").should().resideInAPackage("com.utn.elbuensabor.services");

    @ArchTest
    public static final ArchRule serviceBaseRule =
            classes().that().haveSimpleNameEndingWith("Service").should().implement(BaseController.class)
                    .orShould().haveSimpleName("BaseService");
    @ArchTest
    public static final ArchRule repositoriesNameRule =
            classes().that().haveSimpleNameEndingWith("Repository").should().resideInAPackage("com.utn.elbuensabor.repositories");

    @ArchTest
    public static final ArchRule repositoryBaseRule =
            classes().that().haveSimpleNameEndingWith("Repository").should().implement(BaseController.class)
                    .orShould().haveSimpleName("BaseRepository");

    @ArchTest
    public static final ArchRule serviceImplNameRule =
            classes().that().haveSimpleNameEndingWith("ServiceImpl").should().resideInAPackage("com.utn.elbuensabor.services");

    @ArchTest
    public static final ArchRule serviceBaseImplRule =
            classes().that().haveSimpleNameEndingWith("ServiceImpl").should().implement(BaseService.class)
                    .orShould().haveSimpleName("BaseServiceImpl");

    @ArchTest
    public static final ArchRule entitiesAnnotation =
            classes().that().resideInAPackage("com.utn.elbuensabor.entities").should().beAnnotatedWith(Entity.class)
                    .orShould().haveSimpleName("Base");
}
