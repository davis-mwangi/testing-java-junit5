package guru.springframework.sfgpetclinic.model;

import guru.springframework.sfgpetclinic.ModelTests;
import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

class PersonTest  implements ModelTests {

    @Test
    void groupedAssertions() {
        //given
        Person person =  new Person(1l, "Joe","Buck");

        //then
        assertAll("Test props set",
                ()  -> assertEquals(person.getFirstName(), "Joe"),
                () -> assertEquals(person.getLastName(), "Buck"));
    }

    @Test
    void groupedAssertionMsgs() {
        //given
        Person person =  new Person(1l, "Joe","Buck");

        //then
        assertAll("Test props set",
                ()  -> assertEquals(person.getFirstName(), "Joe",  "First Name Failed"),
                () -> assertEquals(person.getLastName(), "Buck", "Last Name Failed"));
    }

    /**
     *
     * Repeated Tests
     */
     @RepeatedTest(value = 10, name = "{displayName} : {currentRepetition} - {totalRepetitions}")
     @DisplayName("My Repeated Test")
     void myRepeatedTest(){
         // do something
     }
     @RepeatedTest(5)
     @DisplayName("Dependency injection")
     void  myRepeatedTestsWithDI(TestInfo testInfo, RepetitionInfo repetitionInfo){
         System.out.print(testInfo.getDisplayName() +":  " + repetitionInfo.getCurrentRepetition()+ ": " + repetitionInfo.getTotalRepetitions());
     }

}