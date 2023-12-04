package ru.vipksu;

import com.google.gson.Gson;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ru.vipksu.model.Glossary;
import java.io.InputStreamReader;
import java.io.Reader;


public class JsonTest {
    private ClassLoader cl = JsonTest.class.getClassLoader();
    private static final Gson gson = new Gson();

    @Test
    void jsonFileParsingTest() throws Exception {
        try (Reader reader = new InputStreamReader(
                cl.getResourceAsStream("glossary.json")
        )) {
            Glossary actual = gson.fromJson(reader, Glossary.class);
            Assertions.assertEquals("My comment", actual.getComment());
            Assertions.assertEquals(12311, actual.getID());
            Assertions.assertEquals("nine", actual.getGlossary().getDB());
            Assertions.assertEquals("one", actual.getGlossary().getDBAngle());
        }
    }
}