import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

public class StringVSStringBufferTest {
    StringVSStringBufferVSStringBuilder stringBufferVSStringBuilder = new StringVSStringBufferVSStringBuilder();

    @Test
    public void stringTest(){
        stringBufferVSStringBuilder.concatString("Manu","Tiwari");
    }

    @Test
    public void stringBufferTest(){
        stringBufferVSStringBuilder.concatStringBuffer(new StringBuffer("Manu"),new StringBuffer("Tiwari"));
    }

    @Test
    public void stringBuilderTest(){
        stringBufferVSStringBuilder.concatStringBuilder(new StringBuilder("Manu"),new StringBuilder("Tiwari"));
    }


}
