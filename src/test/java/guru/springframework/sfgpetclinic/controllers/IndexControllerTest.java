package guru.springframework.sfgpetclinic.controllers;

import guru.springframework.sfgpetclinic.ControllerTests;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;


class IndexControllerTest  implements ControllerTests {

    IndexController controller;

    @BeforeEach
    void setUp(){
        controller =  new IndexController();
    }

    @Test
    @DisplayName("Test Proper view name is returned for index page")
    void index() {
        assertEquals("index", controller.index());
        assertEquals("index",controller.index(), "Wrong View Returned");
        assertEquals("index",controller.index(), "Another Expensive Message" +
                "Make mee");
        assertThat(controller.index()).isEqualTo("index");
    }

    @Test
    @DisplayName("Test Exception")
    void oupsHandler() {
         assertThrows(ValueNotFoundException.class,  () -> {
             controller.oopsHandler();
         });
    }
}