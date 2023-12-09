package ru.vipksu;

import com.google.gson.Gson;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ru.vipksu.model.Glossary;
import java.io.InputStreamReader;
import java.io.Reader;
import static org.assertj.core.api.Assertions.assertThat;


public class JsonTest {
    private ClassLoader cl = JsonTest.class.getClassLoader();
    private static final Gson gson = new Gson();

    @Test
    void jsonFileParsingTest() throws Exception {
        try (Reader reader = new InputStreamReader(
                cl.getResourceAsStream("glossary.json")
        )) {
            Glossary actual = gson.fromJson(reader, Glossary.class);
            assertThat(actual.getComment()).isEqualTo("My comment");
            //Assertions.assertEquals("My comment", actual.getComment());
            assertThat(actual.getID()).isEqualTo(12311);
            //Assertions.assertEquals(12311, actual.getID());
            assertThat(actual.getGlossary().getDB()).isEqualTo("nine");
            //Assertions.assertEquals("nine", actual.getGlossary().getDB());
            assertThat(actual.getGlossary().getDBAngle()).isEqualTo("one");
            //Assertions.assertEquals("one", actual.getGlossary().getDBAngle());
        }
    }
}