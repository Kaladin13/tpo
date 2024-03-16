package HashString;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.NoSuchElementException;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class HashTableTest {
    private HashTableImpl<Integer> hashTable;

    @BeforeEach
    void setup() {
        this.hashTable = new HashTableImpl<>(10);
    }

    static Stream<Arguments> stringIntAndListProvider() {
        return Stream.of(
                arguments("apple", 1),
                arguments("lemon", 2),
                arguments("key", 5)
        );
    }

    @ParameterizedTest
    @MethodSource("stringIntAndListProvider")
    void insertTest(String key, int value) {
        assertTrue(hashTable.insert(key, value));
        assertEquals(value, hashTable.get(key).orElseThrow());
    }

    @Test
    void capacityTest() {
        assertTrue(hashTable.insert("rand", 1));
        assertEquals(1, hashTable.get("rand").orElseThrow());

        // same key, different value
        assertTrue(hashTable.insert("rand", 2));
        assertEquals(2, hashTable.get("rand").orElseThrow());

        for (int i = 0; i < 8; i++) {
            assertTrue(hashTable.insert("rand-string", -1));
        }

        // space ended
        assertFalse(hashTable.insert("out-of-capacity-string", 1));
    }

    @Test
    void getTest() {
        assertThrows(NoSuchElementException.class, () -> hashTable.get("non-existing-key").orElseThrow());

        String key = "new-key";
        assertTrue(hashTable.insert(key, 42));
        assertEquals(42, hashTable.get(key).orElseThrow());
    }

    @Test
    void removeTest() {
    }
}