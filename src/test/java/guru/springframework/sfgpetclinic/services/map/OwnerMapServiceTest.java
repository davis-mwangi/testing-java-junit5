package guru.springframework.sfgpetclinic.services.map;

import guru.springframework.sfgpetclinic.model.Owner;
import guru.springframework.sfgpetclinic.model.PetType;
import guru.springframework.sfgpetclinic.services.PetService;
import guru.springframework.sfgpetclinic.services.PetTypeService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class OwnerMapServiceTest {

    OwnerMapService ownerMapService;
    PetTypeService petTypeService;
    PetService petService;

    @BeforeEach
    void setUp() {
        petTypeService = new PetTypeMapService();
        petService = new PetMapService();
        ownerMapService = new OwnerMapService(petTypeService, petService);
    }

    @DisplayName("Verify Zero Owners")
    @Test
    void onwersAreZero() {
        int ownerCount = ownerMapService.findAll().size();
        assertThat(ownerCount).isZero();
    }

    @DisplayName("Pet Type -")
    @Nested
    class TestCreatePetTypes {
        @BeforeEach
        void setUp() {
            PetType petType1 = new PetType(1L, "Dog");
            PetType petType2 = new PetType(2L, "Cat");
            petTypeService.save(petType1);
            petTypeService.save(petType2);
        }

        @Test
        void testPetCount() {
            int petTypeCount = petTypeService.findAll().size();
            assertThat(petTypeCount).isNotZero().isEqualTo(2);
        }

        @DisplayName("Save Owners Tests - ")
        @Nested
        class SaveOwnesTests {
            @BeforeEach
            void setUp() {
                ownerMapService.save(new Owner(1L, "Before", "Each"));

            }

            @DisplayName("Save Owner Tests")
            @Test
            void saveOwner() {
                Owner owner = new Owner(2l, "Joe", "Mwangi");
                Owner savedOwner = ownerMapService.save(owner);
                assertThat(savedOwner).isNotNull();
            }

            @DisplayName("Save Owner Tests - ")
            @Nested
            class FindOwnersTests {
                @DisplayName("Find Owner")
                @Test
                void findOwner() {
                    Owner foundOwner = ownerMapService.findById(1L);
                    assertThat(foundOwner).isNotNull();
                }

                @Test
                void findOwnerNotFound() {
                    Owner foundOwner =  ownerMapService.findById(2L);
                    assertThat(foundOwner).isNull();
                }
            }


        }
    }


    @DisplayName("Verify Still Zero owners ")
    @Test
    void ownersAreStillZero() {
        int ownerCount = ownerMapService.findAll().size();
        assertThat(ownerCount).isZero();
    }
}